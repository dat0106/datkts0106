package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class DrawerLayout
  extends ViewGroup
{
  private static final boolean ALLOW_EDGE_LOCK = false;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  private DrawerListener mListener;
  private int mLockModeLeft;
  private int mLockModeRight;
  private int mMinDrawerMargin;
  private final ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowLeft;
  private Drawable mShadowRight;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842931;
    LAYOUT_ATTRS = arrayOfInt;
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = ((int)(0.5F + 64.0F * f));
    f = 400.0F * f;
    this.mLeftCallback = new ViewDragCallback(3);
    this.mRightCallback = new ViewDragCallback(5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
  }
  
  private View findVisibleDrawer()
  {
    int j = getChildCount();
    View localView;
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        localView = null;
        break;
      }
      localView = getChildAt(i);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
        break;
      }
    }
    return localView;
  }
  
  static String gravityToString(int paramInt)
  {
    String str;
    if ((paramInt & 0x3) != 3)
    {
      if ((paramInt & 0x5) != 5) {
        str = Integer.toHexString(paramInt);
      } else {
        str = "RIGHT";
      }
    }
    else {
      str = "LEFT";
    }
    return str;
  }
  
  private static boolean hasOpaqueBackground(View paramView)
  {
    boolean bool = false;
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable != null) && (localDrawable.getOpacity() == -1)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean hasPeekingDrawer()
  {
    int i = getChildCount();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return 0;
      }
      if (((LayoutParams)getChildAt(j).getLayoutParams()).isPeeking) {
        break;
      }
    }
    i = 1;
    return i;
  }
  
  private boolean hasVisibleDrawer()
  {
    boolean bool;
    if (findVisibleDrawer() == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  void cancelChildViewTouch()
  {
    MotionEvent localMotionEvent;
    int j;
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      j = getChildCount();
    }
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        localMotionEvent.recycle();
        this.mChildrenCanceledTouch = true;
        return;
      }
      getChildAt(i).dispatchTouchEvent(localMotionEvent);
    }
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    boolean bool;
    if ((paramInt & getDrawerViewAbsoluteGravity(paramView)) != paramInt) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if ((!(paramLayoutParams instanceof LayoutParams)) || (!super.checkLayoutParams(paramLayoutParams))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void closeDrawer(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null)
    {
      closeDrawer(localView);
      return;
    }
    throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
  }
  
  public void closeDrawer(View paramView)
  {
    if (isDrawerView(paramView))
    {
      if (!this.mFirstLayout)
      {
        if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        } else {
          this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
        localLayoutParams.onScreen = 0.0F;
        localLayoutParams.knownOpen = false;
      }
      invalidate();
      return;
    }
    throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean)
  {
    boolean bool = false;
    int k = getChildCount();
    for (int j = 0;; j++)
    {
      if (j >= k)
      {
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (bool) {
          invalidate();
        }
        return;
      }
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((isDrawerView(localView)) && ((!paramBoolean) || (localLayoutParams.isPeeking)))
      {
        int i = localView.getWidth();
        if (!checkDrawerViewAbsoluteGravity(localView, 3)) {
          bool |= this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
        } else {
          bool |= this.mLeftDragger.smoothSlideViewTo(localView, -i, localView.getTop());
        }
        localLayoutParams.isPeeking = false;
      }
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        this.mScrimOpacity = f;
        if ((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true))) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
      }
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).onScreen);
    }
  }
  
  void dispatchOnDrawerClosed(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.knownOpen)
    {
      localLayoutParams.knownOpen = false;
      if (this.mListener != null) {
        this.mListener.onDrawerClosed(paramView);
      }
      sendAccessibilityEvent(32);
    }
  }
  
  void dispatchOnDrawerOpened(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.knownOpen)
    {
      localLayoutParams.knownOpen = true;
      if (this.mListener != null) {
        this.mListener.onDrawerOpened(paramView);
      }
      paramView.sendAccessibilityEvent(32);
    }
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mListener != null) {
      this.mListener.onDrawerSlide(paramView, paramFloat);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i4 = getHeight();
    boolean bool = isContentView(paramView);
    int k = 0;
    int m = getWidth();
    int i3 = paramCanvas.save();
    int i5;
    if (bool) {
      i5 = getChildCount();
    }
    int j;
    for (int i = 0;; j++)
    {
      if (i >= i5)
      {
        paramCanvas.clipRect(k, 0, m, getHeight());
        j = super.drawChild(paramCanvas, paramView, paramLong);
        paramCanvas.restoreToCount(i3);
        if ((this.mScrimOpacity <= 0.0F) || (!bool))
        {
          if ((this.mShadowLeft == null) || (!checkDrawerViewAbsoluteGravity(paramView, 3)))
          {
            if ((this.mShadowRight != null) && (checkDrawerViewAbsoluteGravity(paramView, 5)))
            {
              k = this.mShadowRight.getIntrinsicWidth();
              m = paramView.getLeft();
              i3 = getWidth() - m;
              int n = this.mRightDragger.getEdgeSize();
              float f1 = Math.max(0.0F, Math.min(i3 / n, 1.0F));
              this.mShadowRight.setBounds(m - k, paramView.getTop(), m, paramView.getBottom());
              this.mShadowRight.setAlpha((int)(255.0F * f1));
              this.mShadowRight.draw(paramCanvas);
            }
          }
          else
          {
            k = this.mShadowLeft.getIntrinsicWidth();
            m = paramView.getRight();
            int i1 = this.mLeftDragger.getEdgeSize();
            float f2 = Math.max(0.0F, Math.min(m / i1, 1.0F));
            this.mShadowLeft.setBounds(m, paramView.getTop(), m + k, paramView.getBottom());
            this.mShadowLeft.setAlpha((int)(255.0F * f2));
            this.mShadowLeft.draw(paramCanvas);
          }
        }
        else
        {
          int i2 = (int)(((0xFF000000 & this.mScrimColor) >>> 24) * this.mScrimOpacity) << 24 | 0xFFFFFF & this.mScrimColor;
          this.mScrimPaint.setColor(i2);
          paramCanvas.drawRect(k, 0.0F, m, getHeight(), this.mScrimPaint);
        }
        return j;
      }
      View localView = getChildAt(j);
      if ((localView != paramView) && (localView.getVisibility() == 0) && (hasOpaqueBackground(localView)) && (isDrawerView(localView)) && (localView.getHeight() >= i4))
      {
        int i6;
        if (!checkDrawerViewAbsoluteGravity(localView, 3))
        {
          i6 = localView.getLeft();
          if (i6 < m) {
            m = i6;
          }
        }
        else
        {
          i6 = i6.getRight();
          if (i6 > k) {
            k = i6;
          }
        }
      }
    }
  }
  
  View findDrawerWithGravity(int paramInt)
  {
    int j = 0x7 & GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int k = getChildCount();
    View localView;
    for (int i = 0;; i++)
    {
      if (i >= k)
      {
        localView = null;
        break;
      }
      localView = getChildAt(i);
      if ((0x7 & getDrawerViewAbsoluteGravity(localView)) == j) {
        break;
      }
    }
    return localView;
  }
  
  View findOpenDrawer()
  {
    int i = getChildCount();
    View localView;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        localView = null;
        break;
      }
      localView = getChildAt(j);
      if (((LayoutParams)localView.getLayoutParams()).knownOpen) {
        break;
      }
    }
    return localView;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    LayoutParams localLayoutParams;
    if (!(paramLayoutParams instanceof LayoutParams))
    {
      if (!(paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        localLayoutParams = new LayoutParams(paramLayoutParams);
      } else {
        localLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
    }
    else {
      localLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
    }
    return localLayoutParams;
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (i != 3)
    {
      if (i != 5) {
        i = 0;
      } else {
        i = this.mLockModeRight;
      }
    }
    else {
      i = this.mLockModeLeft;
    }
    return i;
  }
  
  public int getDrawerLockMode(View paramView)
  {
    int i = getDrawerViewAbsoluteGravity(paramView);
    if (i != 3)
    {
      if (i != 5) {
        i = 0;
      } else {
        i = this.mLockModeRight;
      }
    }
    else {
      i = this.mLockModeLeft;
    }
    return i;
  }
  
  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }
  
  float getDrawerViewOffset(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  boolean isContentView(View paramView)
  {
    boolean bool;
    if (((LayoutParams)paramView.getLayoutParams()).gravity != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    boolean bool;
    if (localView == null) {
      bool = false;
    } else {
      bool = isDrawerOpen(bool);
    }
    return bool;
  }
  
  public boolean isDrawerOpen(View paramView)
  {
    if (isDrawerView(paramView)) {
      return ((LayoutParams)paramView.getLayoutParams()).knownOpen;
    }
    throw new IllegalArgumentException("View " + paramView + " is not a drawer");
  }
  
  boolean isDrawerView(View paramView)
  {
    boolean bool;
    if ((0x7 & GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView))) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    boolean bool;
    if (localView == null) {
      bool = false;
    } else {
      bool = isDrawerVisible(bool);
    }
    return bool;
  }
  
  public boolean isDrawerVisible(View paramView)
  {
    if (isDrawerView(paramView))
    {
      boolean bool;
      if (((LayoutParams)paramView.getLayoutParams()).onScreen <= 0.0F) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    throw new IllegalArgumentException("View " + paramView + " is not a drawer");
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f = getDrawerViewOffset(paramView);
    int i = paramView.getWidth();
    int j = (int)(f * i);
    i = (int)(paramFloat * i) - j;
    if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
      i = -i;
    }
    paramView.offsetLeftAndRight(i);
    setDrawerViewOffset(paramView, paramFloat);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool2 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent) | this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    int i = 0;
    switch (j)
    {
    case 0: 
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if ((this.mScrimOpacity > 0.0F) && (isContentView(this.mLeftDragger.findTopChildUnder((int)f1, (int)f2)))) {
        i = 1;
      }
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break;
    case 1: 
    case 3: 
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break;
    case 2: 
      if (this.mLeftDragger.checkTouchSlop(3))
      {
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
      }
      break;
    }
    if ((bool2) || (i != 0) || (hasPeekingDrawer()) || (this.mChildrenCanceledTouch)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 4) || (!hasVisibleDrawer()))
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
    else
    {
      KeyEventCompat.startTracking(paramKeyEvent);
      bool = true;
    }
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2;
    if (paramInt != 4)
    {
      boolean bool1 = super.onKeyUp(paramInt, paramKeyEvent);
    }
    else
    {
      View localView = findVisibleDrawer();
      if ((localView != null) && (getDrawerLockMode(localView) == 0)) {
        closeDrawers();
      }
      if (localView == null) {
        bool2 = false;
      } else {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int k = paramInt3 - paramInt1;
    int j = getChildCount();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        this.mInLayout = false;
        this.mFirstLayout = false;
        return;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isContentView(localView))
        {
          int n = localView.getMeasuredWidth();
          int i4 = localView.getMeasuredHeight();
          int m;
          float f;
          if (!checkDrawerViewAbsoluteGravity(localView, 3))
          {
            m = k - (int)(n * localLayoutParams.onScreen);
            f = (k - m) / n;
          }
          else
          {
            m = -n + (int)(n * localLayoutParams.onScreen);
            f = (n + m) / n;
          }
          int i1;
          if (f == localLayoutParams.onScreen) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          int i2;
          switch (0x70 & localLayoutParams.gravity)
          {
          default: 
            localView.layout(m, localLayoutParams.topMargin, m + n, i4 + localLayoutParams.topMargin);
            break;
          case 16: 
            i2 = paramInt4 - paramInt2;
            int i3 = (i2 - i4) / 2;
            if (i3 >= localLayoutParams.topMargin)
            {
              if (i3 + i4 > i2 - localLayoutParams.bottomMargin) {
                i3 = i2 - localLayoutParams.bottomMargin - i4;
              }
            }
            else {
              i3 = localLayoutParams.topMargin;
            }
            localView.layout(m, i3, m + n, i3 + i4);
            break;
          case 80: 
            i2 = paramInt4 - paramInt2;
            localView.layout(m, i2 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), m + n, i2 - localLayoutParams.bottomMargin);
          }
          if (i1 != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (localLayoutParams.onScreen <= 0.0F) {
            m = 4;
          } else {
            m = 0;
          }
          if (localView.getVisibility() != m) {
            localView.setVisibility(m);
          }
        }
        else
        {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if ((k != 1073741824) || (m != 1073741824))
    {
      if (!isInEditMode()) {
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      }
      if ((k != -2147483648) && (k == 0)) {
        i = 300;
      }
      if ((m != -2147483648) && (m == 0)) {
        j = 300;
      }
    }
    setMeasuredDimension(i, j);
    m = getChildCount();
    for (k = 0;; k++)
    {
      if (k >= m) {
        return;
      }
      View localView = getChildAt(k);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isContentView(localView))
        {
          if (!isDrawerView(localView)) {
            throw new IllegalStateException("Child " + localView + " at index " + k + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
          }
          int n = 0x7 & getDrawerViewAbsoluteGravity(localView);
          if ((0x0 & n) == 0) {
            localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          } else {
            throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(n) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
          }
        }
        else
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(j - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.openDrawerGravity != 0)
    {
      View localView = findDrawerWithGravity(localSavedState.openDrawerGravity);
      if (localView != null) {
        openDrawer(localView);
      }
    }
    setDrawerLockMode(localSavedState.lockModeLeft, 3);
    setDrawerLockMode(localSavedState.lockModeRight, 5);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i = getChildCount();
    int j = 0;
    while (j < i)
    {
      Object localObject = getChildAt(j);
      if (isDrawerView((View)localObject))
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        if (((LayoutParams)localObject).knownOpen) {}
      }
      else
      {
        j++;
        continue;
      }
      localSavedState.openDrawerGravity = ((LayoutParams)localObject).gravity;
    }
    localSavedState.lockModeLeft = this.mLockModeLeft;
    localSavedState.lockModeRight = this.mLockModeRight;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    float f2;
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 0: 
      f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      this.mInitialMotionX = f2;
      this.mInitialMotionY = f1;
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break;
    case 1: 
      f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      boolean bool = true;
      View localView2 = this.mLeftDragger.findTopChildUnder((int)f2, (int)f3);
      if ((localView2 != null) && (isContentView(localView2)))
      {
        f2 -= this.mInitialMotionX;
        f3 -= this.mInitialMotionY;
        int i = this.mLeftDragger.getTouchSlop();
        if (f2 * f2 + f3 * f3 < i * i)
        {
          View localView1 = findOpenDrawer();
          if (localView1 != null) {
            if (getDrawerLockMode(localView1) != 2) {
              bool = false;
            } else {
              bool = true;
            }
          }
        }
      }
      closeDrawers(bool);
      this.mDisallowInterceptRequested = false;
      break;
    case 3: 
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
    }
    return true;
  }
  
  public void openDrawer(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null)
    {
      openDrawer(localView);
      return;
    }
    throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
  }
  
  public void openDrawer(View paramView)
  {
    if (isDrawerView(paramView))
    {
      if (!this.mFirstLayout)
      {
        if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        } else {
          this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
        localLayoutParams.onScreen = 1.0F;
        localLayoutParams.knownOpen = true;
      }
      invalidate();
      return;
    }
    throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    if (i != 3)
    {
      if (i == 5) {
        this.mLockModeRight = paramInt1;
      }
    }
    else {
      this.mLockModeLeft = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i != 3) {
        localObject = this.mRightDragger;
      } else {
        localObject = this.mLeftDragger;
      }
      ((ViewDragHelper)localObject).cancel();
    }
    switch (paramInt1)
    {
    case 1: 
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        closeDrawer((View)localObject);
      }
      break;
    case 2: 
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        openDrawer((View)localObject);
      }
      break;
    }
  }
  
  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (isDrawerView(paramView))
    {
      setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
      return;
    }
    throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity");
  }
  
  public void setDrawerShadow(int paramInt1, int paramInt2)
  {
    setDrawerShadow(getResources().getDrawable(paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if ((i & 0x3) == 3)
    {
      this.mShadowLeft = paramDrawable;
      invalidate();
    }
    if ((i & 0x5) == 5)
    {
      this.mShadowRight = paramDrawable;
      invalidate();
    }
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat != localLayoutParams.onScreen)
    {
      localLayoutParams.onScreen = paramFloat;
      dispatchOnDrawerSlide(paramView, paramFloat);
    }
  }
  
  public void setScrimColor(int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    int i = this.mLeftDragger.getViewDragState();
    int j = this.mRightDragger.getViewDragState();
    if ((i != 1) && (j != 1))
    {
      if ((i != 2) && (j != 2)) {
        i = 0;
      } else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    if ((paramView != null) && (paramInt2 == 0))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.onScreen != 0.0F)
      {
        if (localLayoutParams.onScreen == 1.0F) {
          dispatchOnDrawerOpened(paramView);
        }
      }
      else {
        dispatchOnDrawerClosed(paramView);
      }
    }
    if (i != this.mDrawerState)
    {
      this.mDrawerState = i;
      if (this.mListener != null) {
        this.mListener.onDrawerStateChanged(i);
      }
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
    {
      int i = paramViewGroup.getChildCount();
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return;
        }
        View localView = paramViewGroup.getChildAt(j);
        if (!filter(localView)) {
          switch (ViewCompat.getImportantForAccessibility(localView))
          {
          case 3: 
          default: 
            break;
          case 0: 
            ViewCompat.setImportantForAccessibility(localView, 1);
          case 1: 
            paramAccessibilityNodeInfoCompat.addChild(localView);
            break;
          case 2: 
            if ((localView instanceof ViewGroup)) {
              addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)localView);
            }
            break;
          }
        }
      }
    }
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    }
    
    public boolean filter(View paramView)
    {
      View localView = DrawerLayout.this.findOpenDrawer();
      boolean bool;
      if ((localView == null) || (localView == paramView)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
      if ((localViewParent instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
      }
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.recycle();
      addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool;
      if (filter(paramView)) {
        bool = false;
      } else {
        bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return bool;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    boolean isPeeking;
    boolean knownOpen;
    float onScreen;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2);
      this.gravity = paramInt3;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.gravity = localTypedArray.getInt(0, 0);
      localTypedArray.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  private class ViewDragCallback
    extends ViewDragHelper.Callback
  {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new Runnable()
    {
      public void run()
      {
        DrawerLayout.ViewDragCallback.this.peekDrawer();
      }
    };
    
    public ViewDragCallback(int paramInt)
    {
      this.mAbsGravity = paramInt;
    }
    
    private void closeOtherDrawer()
    {
      int i = 3;
      if (this.mAbsGravity == i) {
        i = 5;
      }
      View localView = DrawerLayout.this.findDrawerWithGravity(i);
      if (localView != null) {
        DrawerLayout.this.closeDrawer(localView);
      }
    }
    
    private void peekDrawer()
    {
      int j = 0;
      int k = this.mDragger.getEdgeSize();
      int i;
      if (this.mAbsGravity != 3) {
        i = 0;
      } else {
        i = 1;
      }
      View localView;
      if (i == 0)
      {
        localView = DrawerLayout.this.findDrawerWithGravity(5);
        j = DrawerLayout.this.getWidth() - k;
      }
      else
      {
        localView = DrawerLayout.this.findDrawerWithGravity(3);
        if (localView != null) {
          j = -localView.getWidth();
        }
        j += k;
      }
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.mDragger.smoothSlideViewTo(localView, j, localView.getTop());
        localLayoutParams.isPeeking = true;
        DrawerLayout.this.invalidate();
        closeOtherDrawer();
        DrawerLayout.this.cancelChildViewTouch();
      }
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      int i;
      if (!DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        i = DrawerLayout.this.getWidth();
        i = Math.max(i - paramView.getWidth(), Math.min(paramInt1, i));
      }
      else
      {
        i = Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      }
      return i;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return paramView.getWidth();
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      View localView;
      if ((paramInt1 & 0x1) != 1) {
        localView = DrawerLayout.this.findDrawerWithGravity(5);
      } else {
        localView = DrawerLayout.this.findDrawerWithGravity(3);
      }
      if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0)) {
        this.mDragger.captureChildView(localView, paramInt2);
      }
    }
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
      closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout.this.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = paramView.getWidth();
      float f;
      if (!DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
        f = (DrawerLayout.this.getWidth() - paramInt1) / i;
      } else {
        f = (f + paramInt1) / f;
      }
      DrawerLayout.this.setDrawerViewOffset(paramView, f);
      int j;
      if (f != 0.0F) {
        j = 0;
      } else {
        j = 4;
      }
      paramView.setVisibility(j);
      DrawerLayout.this.invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      float f1 = DrawerLayout.this.getDrawerViewOffset(paramView);
      int j = paramView.getWidth();
      int i;
      if (!DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        float f2 = DrawerLayout.this.getWidth();
        if ((paramFloat1 >= 0.0F) && ((paramFloat1 != 0.0F) || (f1 <= 0.5F))) {
          f1 = f2;
        } else {
          i = f2 - j;
        }
      }
      else if ((paramFloat1 <= 0.0F) && ((paramFloat1 != 0.0F) || (i <= 0.5F)))
      {
        i = -j;
      }
      else
      {
        i = 0;
      }
      this.mDragger.settleCapturedViewAt(i, paramView.getTop());
      DrawerLayout.this.invalidate();
    }
    
    public void removeCallbacks()
    {
      DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
    }
    
    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      this.mDragger = paramViewDragHelper;
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      boolean bool;
      if ((!DrawerLayout.this.isDrawerView(paramView)) || (!DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) || (DrawerLayout.this.getDrawerLockMode(paramView) != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel);
      }
      
      public DrawerLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new DrawerLayout.SavedState[paramAnonymousInt];
      }
    };
    int lockModeLeft = 0;
    int lockModeRight = 0;
    int openDrawerGravity = 0;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.openDrawerGravity = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.openDrawerGravity);
    }
  }
  
  public static abstract class SimpleDrawerListener
    implements DrawerLayout.DrawerListener
  {
    public void onDrawerClosed(View paramView) {}
    
    public void onDrawerOpened(View paramView) {}
    
    public void onDrawerSlide(View paramView, float paramFloat) {}
    
    public void onDrawerStateChanged(int paramInt) {}
  }
  
  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed(View paramView);
    
    public abstract void onDrawerOpened(View paramView);
    
    public abstract void onDrawerSlide(View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RemoteViews.RemoteView;

@RemoteViews.RemoteView
public class IcsProgressBar
  extends View
{
  private static final int ANIMATION_RESOLUTION = 200;
  private static final boolean IS_HONEYCOMB = false;
  private static final int MAX_LEVEL = 10000;
  private static final int[] ProgressBar;
  private static final int ProgressBar_animationResolution = 14;
  private static final int ProgressBar_indeterminate = 5;
  private static final int ProgressBar_indeterminateBehavior = 10;
  private static final int ProgressBar_indeterminateDrawable = 7;
  private static final int ProgressBar_indeterminateDuration = 9;
  private static final int ProgressBar_indeterminateOnly = 6;
  private static final int ProgressBar_interpolator = 13;
  private static final int ProgressBar_max = 2;
  private static final int ProgressBar_maxHeight = 1;
  private static final int ProgressBar_maxWidth = 0;
  private static final int ProgressBar_minHeight = 12;
  private static final int ProgressBar_minWidth = 11;
  private static final int ProgressBar_progress = 3;
  private static final int ProgressBar_progressDrawable = 8;
  private static final int ProgressBar_secondaryProgress = 4;
  private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
  private AccessibilityEventSender mAccessibilityEventSender;
  private AccessibilityManager mAccessibilityManager;
  private AlphaAnimation mAnimation;
  private int mAnimationResolution;
  private int mBehavior;
  private Drawable mCurrentDrawable;
  private int mDuration;
  private boolean mInDrawing;
  private boolean mIndeterminate;
  private Drawable mIndeterminateDrawable;
  private int mIndeterminateRealLeft;
  private int mIndeterminateRealTop;
  private Interpolator mInterpolator;
  private long mLastDrawTime;
  private int mMax;
  int mMaxHeight;
  int mMaxWidth;
  int mMinHeight;
  int mMinWidth;
  private boolean mNoInvalidate;
  private boolean mOnlyIndeterminate;
  private int mProgress;
  private Drawable mProgressDrawable;
  private RefreshProgressRunnable mRefreshProgressRunnable;
  Bitmap mSampleTile;
  private int mSecondaryProgress;
  private boolean mShouldStartAnimationDrawable;
  private Transformation mTransformation;
  private long mUiThreadId = Thread.currentThread().getId();
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = false;
    } else {
      bool = true;
    }
    IS_HONEYCOMB = bool;
    int[] arrayOfInt = new int[15];
    arrayOfInt[0] = 16843039;
    arrayOfInt[1] = 16843040;
    arrayOfInt[2] = 16843062;
    arrayOfInt[3] = 16843063;
    arrayOfInt[4] = 16843064;
    arrayOfInt[5] = 16843065;
    arrayOfInt[6] = 16843066;
    arrayOfInt[7] = 16843067;
    arrayOfInt[8] = 16843068;
    arrayOfInt[9] = 16843069;
    arrayOfInt[10] = 16843070;
    arrayOfInt[11] = 16843071;
    arrayOfInt[12] = 16843072;
    arrayOfInt[13] = 16843073;
    arrayOfInt[14] = 16843546;
    ProgressBar = arrayOfInt;
  }
  
  public IcsProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IcsProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842871);
  }
  
  public IcsProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public IcsProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    initProgressBar();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ProgressBar, paramInt1, paramInt2);
    this.mNoInvalidate = true;
    Drawable localDrawable1 = localTypedArray.getDrawable(8);
    if (localDrawable1 != null) {
      setProgressDrawable(tileify(localDrawable1, false));
    }
    this.mDuration = localTypedArray.getInt(9, this.mDuration);
    this.mMinWidth = localTypedArray.getDimensionPixelSize(11, this.mMinWidth);
    this.mMaxWidth = localTypedArray.getDimensionPixelSize(0, this.mMaxWidth);
    this.mMinHeight = localTypedArray.getDimensionPixelSize(12, this.mMinHeight);
    this.mMaxHeight = localTypedArray.getDimensionPixelSize(1, this.mMaxHeight);
    this.mBehavior = localTypedArray.getInt(10, this.mBehavior);
    int i = localTypedArray.getResourceId(13, 17432587);
    if (i > 0) {
      setInterpolator(paramContext, i);
    }
    setMax(localTypedArray.getInt(2, this.mMax));
    setProgress(localTypedArray.getInt(3, this.mProgress));
    setSecondaryProgress(localTypedArray.getInt(4, this.mSecondaryProgress));
    Drawable localDrawable2 = localTypedArray.getDrawable(7);
    if (localDrawable2 != null) {
      setIndeterminateDrawable(tileifyIndeterminate(localDrawable2));
    }
    this.mOnlyIndeterminate = localTypedArray.getBoolean(6, this.mOnlyIndeterminate);
    this.mNoInvalidate = false;
    if ((this.mOnlyIndeterminate) || (localTypedArray.getBoolean(5, this.mIndeterminate))) {
      bool = true;
    }
    setIndeterminate(bool);
    this.mAnimationResolution = localTypedArray.getInteger(14, 200);
    localTypedArray.recycle();
    this.mAccessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
  }
  
  /**
   * @deprecated
   */
  private void doRefreshProgress(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        float f;
        Drawable localDrawable2;
        Drawable localDrawable1;
        if (this.mMax > 0)
        {
          f = paramInt2 / this.mMax;
          localDrawable2 = this.mCurrentDrawable;
          if (localDrawable2 != null)
          {
            localDrawable1 = null;
            if (!(localDrawable2 instanceof LayerDrawable)) {
              break label114;
            }
            localDrawable1 = ((LayerDrawable)localDrawable2).findDrawableByLayerId(paramInt1);
            break label114;
            localDrawable1.setLevel(i);
            if ((paramBoolean2) && (paramInt1 == 16908301)) {
              onProgressRefresh(f, paramBoolean1);
            }
          }
        }
        else
        {
          f = 0.0F;
          continue;
          localDrawable1 = localDrawable2;
          continue;
        }
        invalidate();
        continue;
        int i = (int)(10000.0F * f);
      }
      finally {}
      label114:
      if (localObject == null) {}
    }
  }
  
  private void initProgressBar()
  {
    this.mMax = 100;
    this.mProgress = 0;
    this.mSecondaryProgress = 0;
    this.mIndeterminate = false;
    this.mOnlyIndeterminate = false;
    this.mDuration = 4000;
    this.mBehavior = 1;
    this.mMinWidth = 24;
    this.mMaxWidth = 48;
    this.mMinHeight = 24;
    this.mMaxHeight = 48;
  }
  
  /**
   * @deprecated
   */
  private void refreshProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mUiThreadId == Thread.currentThread().getId())
        {
          doRefreshProgress(paramInt1, paramInt2, paramBoolean, true);
          return;
        }
        if (this.mRefreshProgressRunnable != null)
        {
          RefreshProgressRunnable localRefreshProgressRunnable1 = this.mRefreshProgressRunnable;
          this.mRefreshProgressRunnable = null;
          localRefreshProgressRunnable1.setup(paramInt1, paramInt2, paramBoolean);
          post(localRefreshProgressRunnable1);
        }
        else
        {
          RefreshProgressRunnable localRefreshProgressRunnable2 = new RefreshProgressRunnable(paramInt1, paramInt2, paramBoolean);
        }
      }
      finally {}
    }
  }
  
  private void scheduleAccessibilityEventSender()
  {
    if (this.mAccessibilityEventSender != null) {
      removeCallbacks(this.mAccessibilityEventSender);
    } else {
      this.mAccessibilityEventSender = new AccessibilityEventSender(null);
    }
    postDelayed(this.mAccessibilityEventSender, 200L);
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject3;
    Object localObject2;
    int i;
    if (!(paramDrawable instanceof LayerDrawable))
    {
      if (!(paramDrawable instanceof BitmapDrawable))
      {
        localObject3 = paramDrawable;
      }
      else
      {
        localObject2 = ((BitmapDrawable)paramDrawable).getBitmap();
        if (this.mSampleTile == null) {
          this.mSampleTile = ((Bitmap)localObject2);
        }
        Object localObject1 = new ShapeDrawable(getDrawableShape());
        localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        ((ShapeDrawable)localObject1).getPaint().setShader((Shader)localObject2);
        if (paramBoolean) {
          localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
        }
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject2 = (LayerDrawable)paramDrawable;
      i = ((LayerDrawable)localObject2).getNumberOfLayers();
      localObject3 = new Drawable[i];
    }
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        localObject3 = new LayerDrawable((Drawable[])localObject3);
        for (j = 0;; j++)
        {
          if (j >= i) {
            return localObject3;
          }
          ((LayerDrawable)localObject3).setId(j, ((LayerDrawable)localObject2).getId(j));
        }
      }
      int k = ((LayerDrawable)localObject2).getId(j);
      Drawable localDrawable = ((LayerDrawable)localObject2).getDrawable(j);
      if ((k != 16908301) && (k != 16908303)) {
        k = 0;
      } else {
        k = 1;
      }
      localObject3[j] = tileify(localDrawable, k);
    }
  }
  
  private Drawable tileifyIndeterminate(Drawable paramDrawable)
  {
    AnimationDrawable localAnimationDrawable2;
    int j;
    AnimationDrawable localAnimationDrawable1;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      localAnimationDrawable2 = (AnimationDrawable)paramDrawable;
      j = localAnimationDrawable2.getNumberOfFrames();
      localAnimationDrawable1 = new AnimationDrawable();
      localAnimationDrawable1.setOneShot(localAnimationDrawable2.isOneShot());
    }
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        localAnimationDrawable1.setLevel(10000);
        paramDrawable = localAnimationDrawable1;
        return paramDrawable;
      }
      Drawable localDrawable = tileify(localAnimationDrawable2.getFrame(i), true);
      localDrawable.setLevel(10000);
      localAnimationDrawable1.addFrame(localDrawable, localAnimationDrawable2.getDuration(i));
    }
  }
  
  private void updateDrawableBounds(int paramInt1, int paramInt2)
  {
    int k = paramInt1 - getPaddingRight() - getPaddingLeft();
    int m = paramInt2 - getPaddingBottom() - getPaddingTop();
    int i = 0;
    int j = 0;
    if (this.mIndeterminateDrawable != null)
    {
      if ((this.mOnlyIndeterminate) && (!(this.mIndeterminateDrawable instanceof AnimationDrawable)))
      {
        int n = this.mIndeterminateDrawable.getIntrinsicWidth();
        int i1 = this.mIndeterminateDrawable.getIntrinsicHeight();
        float f2 = n / i1;
        float f1 = paramInt1 / paramInt2;
        if (f2 != f1) {
          if (f1 <= f2)
          {
            m = (int)(paramInt1 * (1.0F / f2));
            i = (paramInt2 - m) / 2;
            m = i + m;
          }
          else
          {
            k = (int)(f2 * paramInt2);
            j = (paramInt1 - k) / 2;
            k = j + k;
          }
        }
      }
      this.mIndeterminateDrawable.setBounds(0, 0, k - j, m - i);
      this.mIndeterminateRealLeft = j;
      this.mIndeterminateRealTop = i;
    }
    if (this.mProgressDrawable != null) {
      this.mProgressDrawable.setBounds(0, 0, k, m);
    }
  }
  
  private void updateDrawableState()
  {
    int[] arrayOfInt = getDrawableState();
    if ((this.mProgressDrawable != null) && (this.mProgressDrawable.isStateful())) {
      this.mProgressDrawable.setState(arrayOfInt);
    }
    if ((this.mIndeterminateDrawable != null) && (this.mIndeterminateDrawable.isStateful())) {
      this.mIndeterminateDrawable.setState(arrayOfInt);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    updateDrawableState();
  }
  
  Drawable getCurrentDrawable()
  {
    return this.mCurrentDrawable;
  }
  
  Shape getDrawableShape()
  {
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = 5.0F;
    arrayOfFloat[1] = 5.0F;
    arrayOfFloat[2] = 5.0F;
    arrayOfFloat[3] = 5.0F;
    arrayOfFloat[4] = 5.0F;
    arrayOfFloat[5] = 5.0F;
    arrayOfFloat[6] = 5.0F;
    arrayOfFloat[7] = 5.0F;
    return new RoundRectShape(arrayOfFloat, null, null);
  }
  
  public Drawable getIndeterminateDrawable()
  {
    return this.mIndeterminateDrawable;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  /**
   * @deprecated
   */
  @ViewDebug.ExportedProperty(category="progress")
  public int getMax()
  {
    try
    {
      int i = this.mMax;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  @ViewDebug.ExportedProperty(category="progress")
  public int getProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 205	com/actionbarsherlock/internal/widget/IcsProgressBar:mProgress	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	IcsProgressBar
    //   6	10	1	i	int
    //   21	1	1	j	int
    //   25	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public Drawable getProgressDrawable()
  {
    return this.mProgressDrawable;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  @ViewDebug.ExportedProperty(category="progress")
  public int getSecondaryProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 210	com/actionbarsherlock/internal/widget/IcsProgressBar:mSecondaryProgress	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	IcsProgressBar
    //   6	10	1	i	int
    //   21	1	1	j	int
    //   25	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /**
   * @deprecated
   */
  public final void incrementProgressBy(int paramInt)
  {
    try
    {
      setProgress(paramInt + this.mProgress);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public final void incrementSecondaryProgressBy(int paramInt)
  {
    try
    {
      setSecondaryProgress(paramInt + this.mSecondaryProgress);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!this.mInDrawing) {
      if (!verifyDrawable(paramDrawable))
      {
        super.invalidateDrawable(paramDrawable);
      }
      else
      {
        Rect localRect = paramDrawable.getBounds();
        int j = getScrollX() + getPaddingLeft();
        int i = getScrollY() + getPaddingTop();
        invalidate(j + localRect.left, i + localRect.top, j + localRect.right, i + localRect.bottom);
      }
    }
  }
  
  /**
   * @deprecated
   */
  @ViewDebug.ExportedProperty(category="progress")
  public boolean isIndeterminate()
  {
    try
    {
      boolean bool = this.mIndeterminate;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mProgressDrawable != null) {
      this.mProgressDrawable.jumpToCurrentState();
    }
    if (this.mIndeterminateDrawable != null) {
      this.mIndeterminateDrawable.jumpToCurrentState();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mIndeterminate) {
      startAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mIndeterminate) {
      stopAnimation();
    }
    if (this.mRefreshProgressRunnable != null) {
      removeCallbacks(this.mRefreshProgressRunnable);
    }
    if (this.mAccessibilityEventSender != null) {
      removeCallbacks(this.mAccessibilityEventSender);
    }
    super.onDetachedFromWindow();
  }
  
  /* Error */
  /**
   * @deprecated
   */
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 526	android/view/View:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: getfield 262	com/actionbarsherlock/internal/widget/IcsProgressBar:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +156 -> 169
    //   16: aload_1
    //   17: invokevirtual 531	android/graphics/Canvas:save	()I
    //   20: pop
    //   21: aload_1
    //   22: aload_0
    //   23: invokevirtual 404	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingLeft	()I
    //   26: aload_0
    //   27: getfield 425	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminateRealLeft	I
    //   30: iadd
    //   31: i2f
    //   32: aload_0
    //   33: invokevirtual 410	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingTop	()I
    //   36: aload_0
    //   37: getfield 427	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminateRealTop	I
    //   40: iadd
    //   41: i2f
    //   42: invokevirtual 535	android/graphics/Canvas:translate	(FF)V
    //   45: aload_0
    //   46: invokevirtual 538	com/actionbarsherlock/internal/widget/IcsProgressBar:getDrawingTime	()J
    //   49: lstore_3
    //   50: aload_0
    //   51: getfield 540	com/actionbarsherlock/internal/widget/IcsProgressBar:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   54: ifnull +78 -> 132
    //   57: aload_0
    //   58: getfield 540	com/actionbarsherlock/internal/widget/IcsProgressBar:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   61: lload_3
    //   62: aload_0
    //   63: getfield 542	com/actionbarsherlock/internal/widget/IcsProgressBar:mTransformation	Landroid/view/animation/Transformation;
    //   66: invokevirtual 548	android/view/animation/AlphaAnimation:getTransformation	(JLandroid/view/animation/Transformation;)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield 542	com/actionbarsherlock/internal/widget/IcsProgressBar:mTransformation	Landroid/view/animation/Transformation;
    //   74: invokevirtual 554	android/view/animation/Transformation:getAlpha	()F
    //   77: fstore_3
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 471	com/actionbarsherlock/internal/widget/IcsProgressBar:mInDrawing	Z
    //   83: aload_2
    //   84: ldc_w 283
    //   87: fload_3
    //   88: fmul
    //   89: f2i
    //   90: invokevirtual 273	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   93: pop
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 471	com/actionbarsherlock/internal/widget/IcsProgressBar:mInDrawing	Z
    //   99: invokestatic 559	android/os/SystemClock:uptimeMillis	()J
    //   102: aload_0
    //   103: getfield 561	com/actionbarsherlock/internal/widget/IcsProgressBar:mLastDrawTime	J
    //   106: lsub
    //   107: aload_0
    //   108: getfield 237	com/actionbarsherlock/internal/widget/IcsProgressBar:mAnimationResolution	I
    //   111: i2l
    //   112: lcmp
    //   113: iflt +19 -> 132
    //   116: aload_0
    //   117: invokestatic 559	android/os/SystemClock:uptimeMillis	()J
    //   120: putfield 561	com/actionbarsherlock/internal/widget/IcsProgressBar:mLastDrawTime	J
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 237	com/actionbarsherlock/internal/widget/IcsProgressBar:mAnimationResolution	I
    //   128: i2l
    //   129: invokevirtual 565	com/actionbarsherlock/internal/widget/IcsProgressBar:postInvalidateDelayed	(J)V
    //   132: aload_2
    //   133: aload_1
    //   134: invokevirtual 568	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   137: aload_1
    //   138: invokevirtual 571	android/graphics/Canvas:restore	()V
    //   141: aload_0
    //   142: getfield 573	com/actionbarsherlock/internal/widget/IcsProgressBar:mShouldStartAnimationDrawable	Z
    //   145: ifeq +24 -> 169
    //   148: aload_2
    //   149: instanceof 575
    //   152: ifeq +17 -> 169
    //   155: aload_2
    //   156: checkcast 575	android/graphics/drawable/Animatable
    //   159: invokeinterface 578 1 0
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 573	com/actionbarsherlock/internal/widget/IcsProgressBar:mShouldStartAnimationDrawable	Z
    //   169: aload_0
    //   170: monitorexit
    //   171: return
    //   172: astore_2
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield 471	com/actionbarsherlock/internal/widget/IcsProgressBar:mInDrawing	Z
    //   178: aload_2
    //   179: athrow
    //   180: astore_2
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_2
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	IcsProgressBar
    //   0	185	1	paramCanvas	android.graphics.Canvas
    //   11	145	2	localDrawable	Drawable
    //   172	7	2	localObject1	Object
    //   180	4	2	localObject2	Object
    //   49	13	3	l	long
    //   77	11	3	f	float
    // Exception table:
    //   from	to	target	type
    //   78	94	172	finally
    //   2	78	180	finally
    //   94	169	180	finally
    //   173	180	180	finally
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setItemCount(this.mMax);
    paramAccessibilityEvent.setCurrentItemIndex(this.mProgress);
  }
  
  /* Error */
  /**
   * @deprecated
   */
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 262	com/actionbarsherlock/internal/widget/IcsProgressBar:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   6: astore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore_3
    //   13: aload 5
    //   15: ifnull +44 -> 59
    //   18: aload_0
    //   19: getfield 178	com/actionbarsherlock/internal/widget/IcsProgressBar:mMinWidth	I
    //   22: aload_0
    //   23: getfield 183	com/actionbarsherlock/internal/widget/IcsProgressBar:mMaxWidth	I
    //   26: aload 5
    //   28: invokevirtual 415	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   31: invokestatic 596	java/lang/Math:min	(II)I
    //   34: invokestatic 599	java/lang/Math:max	(II)I
    //   37: istore 4
    //   39: aload_0
    //   40: getfield 185	com/actionbarsherlock/internal/widget/IcsProgressBar:mMinHeight	I
    //   43: aload_0
    //   44: getfield 187	com/actionbarsherlock/internal/widget/IcsProgressBar:mMaxHeight	I
    //   47: aload 5
    //   49: invokevirtual 418	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   52: invokestatic 596	java/lang/Math:min	(II)I
    //   55: invokestatic 599	java/lang/Math:max	(II)I
    //   58: istore_3
    //   59: aload_0
    //   60: invokespecial 446	com/actionbarsherlock/internal/widget/IcsProgressBar:updateDrawableState	()V
    //   63: iload 4
    //   65: aload_0
    //   66: invokevirtual 404	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingLeft	()I
    //   69: aload_0
    //   70: invokevirtual 401	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingRight	()I
    //   73: iadd
    //   74: iadd
    //   75: istore 4
    //   77: iload_3
    //   78: aload_0
    //   79: invokevirtual 410	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingTop	()I
    //   82: aload_0
    //   83: invokevirtual 407	com/actionbarsherlock/internal/widget/IcsProgressBar:getPaddingBottom	()I
    //   86: iadd
    //   87: iadd
    //   88: istore_3
    //   89: getstatic 103	com/actionbarsherlock/internal/widget/IcsProgressBar:IS_HONEYCOMB	Z
    //   92: ifeq +23 -> 115
    //   95: aload_0
    //   96: iload 4
    //   98: iload_1
    //   99: iconst_0
    //   100: invokestatic 603	android/view/View:resolveSizeAndState	(III)I
    //   103: iload_3
    //   104: iload_2
    //   105: iconst_0
    //   106: invokestatic 603	android/view/View:resolveSizeAndState	(III)I
    //   109: invokevirtual 606	com/actionbarsherlock/internal/widget/IcsProgressBar:setMeasuredDimension	(II)V
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: aload_0
    //   116: iload 4
    //   118: iload_1
    //   119: invokestatic 609	android/view/View:resolveSize	(II)I
    //   122: iload_3
    //   123: iload_2
    //   124: invokestatic 609	android/view/View:resolveSize	(II)I
    //   127: invokevirtual 606	com/actionbarsherlock/internal/widget/IcsProgressBar:setMeasuredDimension	(II)V
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	IcsProgressBar
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   12	111	3	i	int
    //   133	4	3	localObject	Object
    //   9	108	4	j	int
    //   6	42	5	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	112	133	finally
    //   115	130	133	finally
  }
  
  void onProgressRefresh(float paramFloat, boolean paramBoolean)
  {
    if (this.mAccessibilityManager.isEnabled()) {
      scheduleAccessibilityEventSender();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setProgress(localSavedState.progress);
    setSecondaryProgress(localSavedState.secondaryProgress);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.progress = this.mProgress;
    localSavedState.secondaryProgress = this.mSecondaryProgress;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateDrawableBounds(paramInt1, paramInt2);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mIndeterminate) {
      if ((paramInt != 8) && (paramInt != 4)) {
        startAnimation();
      } else {
        stopAnimation();
      }
    }
  }
  
  public void postInvalidate()
  {
    if (!this.mNoInvalidate) {
      super.postInvalidate();
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void setIndeterminate(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 222	com/actionbarsherlock/internal/widget/IcsProgressBar:mOnlyIndeterminate	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   13: ifne +32 -> 45
    //   16: iload_1
    //   17: aload_0
    //   18: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   21: if_icmpeq +24 -> 45
    //   24: aload_0
    //   25: iload_1
    //   26: putfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   29: iload_1
    //   30: ifeq +18 -> 48
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 412	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminateDrawable	Landroid/graphics/drawable/Drawable;
    //   38: putfield 262	com/actionbarsherlock/internal/widget/IcsProgressBar:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   41: aload_0
    //   42: invokevirtual 516	com/actionbarsherlock/internal/widget/IcsProgressBar:startAnimation	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 429	com/actionbarsherlock/internal/widget/IcsProgressBar:mProgressDrawable	Landroid/graphics/drawable/Drawable;
    //   53: putfield 262	com/actionbarsherlock/internal/widget/IcsProgressBar:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   56: aload_0
    //   57: invokevirtual 520	com/actionbarsherlock/internal/widget/IcsProgressBar:stopAnimation	()V
    //   60: goto -15 -> 45
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	IcsProgressBar
    //   0	68	1	paramBoolean	boolean
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	63	finally
    //   48	60	63	finally
  }
  
  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    this.mIndeterminateDrawable = paramDrawable;
    if (this.mIndeterminate)
    {
      this.mCurrentDrawable = paramDrawable;
      postInvalidate();
    }
  }
  
  public void setInterpolator(Context paramContext, int paramInt)
  {
    setInterpolator(AnimationUtils.loadInterpolator(paramContext, paramInt));
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  /**
   * @deprecated
   */
  public void setMax(int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 0;
    }
    try
    {
      if (paramInt != this.mMax)
      {
        this.mMax = paramInt;
        postInvalidate();
        if (this.mProgress > paramInt) {
          this.mProgress = paramInt;
        }
        refreshProgress(16908301, this.mProgress, false);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void setProgress(int paramInt)
  {
    try
    {
      setProgress(paramInt, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  void setProgress(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iload_1
    //   15: ifge +5 -> 20
    //   18: iconst_0
    //   19: istore_1
    //   20: iload_1
    //   21: aload_0
    //   22: getfield 199	com/actionbarsherlock/internal/widget/IcsProgressBar:mMax	I
    //   25: if_icmple +8 -> 33
    //   28: aload_0
    //   29: getfield 199	com/actionbarsherlock/internal/widget/IcsProgressBar:mMax	I
    //   32: istore_1
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 205	com/actionbarsherlock/internal/widget/IcsProgressBar:mProgress	I
    //   38: if_icmpeq -27 -> 11
    //   41: aload_0
    //   42: iload_1
    //   43: putfield 205	com/actionbarsherlock/internal/widget/IcsProgressBar:mProgress	I
    //   46: aload_0
    //   47: ldc_w 274
    //   50: aload_0
    //   51: getfield 205	com/actionbarsherlock/internal/widget/IcsProgressBar:mProgress	I
    //   54: iload_2
    //   55: invokespecial 658	com/actionbarsherlock/internal/widget/IcsProgressBar:refreshProgress	(IIZ)V
    //   58: goto -47 -> 11
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	IcsProgressBar
    //   0	66	1	paramInt	int
    //   0	66	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   20	58	61	finally
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    int i;
    if ((this.mProgressDrawable == null) || (paramDrawable == this.mProgressDrawable))
    {
      i = 0;
    }
    else
    {
      this.mProgressDrawable.setCallback(null);
      i = 1;
    }
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      int j = paramDrawable.getMinimumHeight();
      if (this.mMaxHeight < j)
      {
        this.mMaxHeight = j;
        requestLayout();
      }
    }
    this.mProgressDrawable = paramDrawable;
    if (!this.mIndeterminate)
    {
      this.mCurrentDrawable = paramDrawable;
      postInvalidate();
    }
    if (i != 0)
    {
      updateDrawableBounds(getWidth(), getHeight());
      updateDrawableState();
      doRefreshProgress(16908301, this.mProgress, false, false);
      doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void setSecondaryProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/actionbarsherlock/internal/widget/IcsProgressBar:mIndeterminate	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iload_1
    //   15: ifge +5 -> 20
    //   18: iconst_0
    //   19: istore_1
    //   20: iload_1
    //   21: aload_0
    //   22: getfield 199	com/actionbarsherlock/internal/widget/IcsProgressBar:mMax	I
    //   25: if_icmple +8 -> 33
    //   28: aload_0
    //   29: getfield 199	com/actionbarsherlock/internal/widget/IcsProgressBar:mMax	I
    //   32: istore_1
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 210	com/actionbarsherlock/internal/widget/IcsProgressBar:mSecondaryProgress	I
    //   38: if_icmpeq -27 -> 11
    //   41: aload_0
    //   42: iload_1
    //   43: putfield 210	com/actionbarsherlock/internal/widget/IcsProgressBar:mSecondaryProgress	I
    //   46: aload_0
    //   47: ldc_w 372
    //   50: aload_0
    //   51: getfield 210	com/actionbarsherlock/internal/widget/IcsProgressBar:mSecondaryProgress	I
    //   54: iconst_0
    //   55: invokespecial 658	com/actionbarsherlock/internal/widget/IcsProgressBar:refreshProgress	(IIZ)V
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	IcsProgressBar
    //   0	66	1	paramInt	int
    //   6	2	2	bool	boolean
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   20	58	61	finally
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      if (this.mIndeterminate) {
        if ((paramInt != 8) && (paramInt != 4)) {
          startAnimation();
        } else {
          stopAnimation();
        }
      }
    }
  }
  
  void startAnimation()
  {
    if (getVisibility() == 0)
    {
      if (!(this.mIndeterminateDrawable instanceof Animatable))
      {
        if (this.mInterpolator == null) {
          this.mInterpolator = new LinearInterpolator();
        }
        this.mTransformation = new Transformation();
        this.mAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.mAnimation.setRepeatMode(this.mBehavior);
        this.mAnimation.setRepeatCount(-1);
        this.mAnimation.setDuration(this.mDuration);
        this.mAnimation.setInterpolator(this.mInterpolator);
        this.mAnimation.setStartTime(-1L);
      }
      else
      {
        this.mShouldStartAnimationDrawable = true;
        this.mAnimation = null;
      }
      postInvalidate();
    }
  }
  
  void stopAnimation()
  {
    this.mAnimation = null;
    this.mTransformation = null;
    if ((this.mIndeterminateDrawable instanceof Animatable))
    {
      ((Animatable)this.mIndeterminateDrawable).stop();
      this.mShouldStartAnimationDrawable = false;
    }
    postInvalidate();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((paramDrawable != this.mProgressDrawable) && (paramDrawable != this.mIndeterminateDrawable) && (!super.verifyDrawable(paramDrawable))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private class AccessibilityEventSender
    implements Runnable
  {
    private AccessibilityEventSender() {}
    
    public void run()
    {
      IcsProgressBar.this.sendAccessibilityEvent(4);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public IcsProgressBar.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new IcsProgressBar.SavedState(paramAnonymousParcel, null);
      }
      
      public IcsProgressBar.SavedState[] newArray(int paramAnonymousInt)
      {
        return new IcsProgressBar.SavedState[paramAnonymousInt];
      }
    };
    int progress;
    int secondaryProgress;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.progress = paramParcel.readInt();
      this.secondaryProgress = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.progress);
      paramParcel.writeInt(this.secondaryProgress);
    }
  }
  
  private class RefreshProgressRunnable
    implements Runnable
  {
    private boolean mFromUser;
    private int mId;
    private int mProgress;
    
    RefreshProgressRunnable(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mId = paramInt1;
      this.mProgress = paramInt2;
      this.mFromUser = paramBoolean;
    }
    
    public void run()
    {
      IcsProgressBar.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
      IcsProgressBar.access$102(IcsProgressBar.this, this);
    }
    
    public void setup(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mId = paramInt1;
      this.mProgress = paramInt2;
      this.mFromUser = paramBoolean;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsProgressBar
 * JD-Core Version:    0.7.0.1
 */
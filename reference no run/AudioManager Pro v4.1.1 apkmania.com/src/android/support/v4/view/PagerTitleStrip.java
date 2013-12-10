package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerTitleStrip
  extends ViewGroup
  implements ViewPager.Decor
{
  private static final int[] ATTRS;
  private static final PagerTitleStripImpl IMPL;
  private static final float SIDE_ALPHA = 0.6F;
  private static final String TAG = "PagerTitleStrip";
  private static final int[] TEXT_ATTRS;
  private static final int TEXT_SPACING = 16;
  TextView mCurrText;
  private int mGravity;
  private int mLastKnownCurrentPage = -1;
  private float mLastKnownPositionOffset = -1.0F;
  TextView mNextText;
  private int mNonPrimaryAlpha;
  private final PageListener mPageListener = new PageListener(null);
  ViewPager mPager;
  TextView mPrevText;
  private int mScaledTextSpacing;
  int mTextColor;
  private boolean mUpdatingPositions;
  private boolean mUpdatingText;
  
  static
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = 16842804;
    arrayOfInt[1] = 16842901;
    arrayOfInt[2] = 16842904;
    arrayOfInt[3] = 16842927;
    ATTRS = arrayOfInt;
    arrayOfInt = new int[1];
    arrayOfInt[0] = 16843660;
    TEXT_ATTRS = arrayOfInt;
    if (Build.VERSION.SDK_INT < 14) {
      IMPL = new PagerTitleStripImplBase();
    } else {
      IMPL = new PagerTitleStripImplIcs();
    }
  }
  
  public PagerTitleStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.mPrevText = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mCurrText = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mNextText = localTextView;
    addView(localTextView);
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    int i = localTypedArray2.getResourceId(0, 0);
    if (i != 0)
    {
      this.mPrevText.setTextAppearance(paramContext, i);
      this.mCurrText.setTextAppearance(paramContext, i);
      this.mNextText.setTextAppearance(paramContext, i);
    }
    int j = localTypedArray2.getDimensionPixelSize(1, 0);
    if (j != 0) {
      setTextSize(0, j);
    }
    if (localTypedArray2.hasValue(2))
    {
      j = localTypedArray2.getColor(2, 0);
      this.mPrevText.setTextColor(j);
      this.mCurrText.setTextColor(j);
      this.mNextText.setTextColor(j);
    }
    this.mGravity = localTypedArray2.getInteger(3, 80);
    localTypedArray2.recycle();
    this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
    this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
    this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = false;
    if (i != 0)
    {
      TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(i, TEXT_ATTRS);
      bool = localTypedArray1.getBoolean(0, false);
      localTypedArray1.recycle();
    }
    if (!bool)
    {
      this.mPrevText.setSingleLine();
      this.mCurrText.setSingleLine();
      this.mNextText.setSingleLine();
    }
    else
    {
      setSingleLineAllCaps(this.mPrevText);
      setSingleLineAllCaps(this.mCurrText);
      setSingleLineAllCaps(this.mNextText);
    }
    this.mScaledTextSpacing = ((int)(16.0F * paramContext.getResources().getDisplayMetrics().density));
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    IMPL.setSingleLineAllCaps(paramTextView);
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.mScaledTextSpacing;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof ViewPager))
    {
      localObject = (ViewPager)localObject;
      PagerAdapter localPagerAdapter = ((ViewPager)localObject).getAdapter();
      ((ViewPager)localObject).setInternalPageChangeListener(this.mPageListener);
      ((ViewPager)localObject).setOnAdapterChangeListener(this.mPageListener);
      this.mPager = ((ViewPager)localObject);
      updateAdapter(null, localPagerAdapter);
      return;
    }
    throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mPager != null)
    {
      updateAdapter(this.mPager.getAdapter(), null);
      this.mPager.setInternalPageChangeListener(null);
      this.mPager.setOnAdapterChangeListener(null);
      this.mPager = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.mPager != null)
    {
      if (this.mLastKnownPositionOffset >= 0.0F) {
        f = this.mLastKnownPositionOffset;
      }
      updateTextPositions(this.mPager.getCurrentItem(), f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      int i1 = getMinHeight();
      int n = getPaddingTop() + getPaddingBottom();
      int i2 = k - n;
      m = View.MeasureSpec.makeMeasureSpec((int)(0.8F * j), -2147483648);
      i2 = View.MeasureSpec.makeMeasureSpec(i2, -2147483648);
      this.mPrevText.measure(m, i2);
      this.mCurrText.measure(m, i2);
      this.mNextText.measure(m, i2);
      if (i != 1073741824) {
        setMeasuredDimension(j, Math.max(i1, n + this.mCurrText.getMeasuredHeight()));
      } else {
        setMeasuredDimension(j, k);
      }
      return;
    }
    throw new IllegalStateException("Must measure with an exact width");
  }
  
  public void requestLayout()
  {
    if (!this.mUpdatingText) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.mNonPrimaryAlpha = (0xFF & (int)(255.0F * paramFloat));
    int i = this.mNonPrimaryAlpha << 24 | 0xFFFFFF & this.mTextColor;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mCurrText.setTextColor(paramInt);
    int i = this.mNonPrimaryAlpha << 24 | 0xFFFFFF & this.mTextColor;
    this.mPrevText.setTextColor(i);
    this.mNextText.setTextColor(i);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.mPrevText.setTextSize(paramInt, paramFloat);
    this.mCurrText.setTextSize(paramInt, paramFloat);
    this.mNextText.setTextSize(paramInt, paramFloat);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.mScaledTextSpacing = paramInt;
    requestLayout();
  }
  
  void updateAdapter(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (paramPagerAdapter1 != null) {
      paramPagerAdapter1.unregisterDataSetObserver(this.mPageListener);
    }
    if (paramPagerAdapter2 != null) {
      paramPagerAdapter2.registerDataSetObserver(this.mPageListener);
    }
    if (this.mPager != null)
    {
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      updateText(this.mPager.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    }
  }
  
  void updateText(int paramInt, PagerAdapter paramPagerAdapter)
  {
    if (paramPagerAdapter == null) {
      i = 0;
    } else {
      i = paramPagerAdapter.getCount();
    }
    this.mUpdatingText = true;
    Object localObject = null;
    if ((paramInt >= 1) && (paramPagerAdapter != null)) {
      localObject = paramPagerAdapter.getPageTitle(paramInt - 1);
    }
    this.mPrevText.setText((CharSequence)localObject);
    localObject = this.mCurrText;
    CharSequence localCharSequence;
    if ((paramPagerAdapter == null) || (paramInt >= i)) {
      localCharSequence = null;
    } else {
      localCharSequence = paramPagerAdapter.getPageTitle(paramInt);
    }
    ((TextView)localObject).setText(localCharSequence);
    localObject = null;
    if ((paramInt + 1 < i) && (paramPagerAdapter != null)) {
      localObject = paramPagerAdapter.getPageTitle(paramInt + 1);
    }
    this.mNextText.setText((CharSequence)localObject);
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    i = View.MeasureSpec.makeMeasureSpec((int)(0.8F * i), -2147483648);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    this.mPrevText.measure(i, j);
    this.mCurrText.measure(i, j);
    this.mNextText.measure(i, j);
    this.mLastKnownCurrentPage = paramInt;
    if (!this.mUpdatingPositions) {
      updateTextPositions(paramInt, this.mLastKnownPositionOffset, false);
    }
    this.mUpdatingText = false;
  }
  
  void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt == this.mLastKnownCurrentPage)
    {
      if ((!paramBoolean) && (paramFloat == this.mLastKnownPositionOffset)) {
        return;
      }
    }
    else {
      updateText(paramInt, this.mPager.getAdapter());
    }
    this.mUpdatingPositions = true;
    int m = this.mPrevText.getMeasuredWidth();
    int i1 = this.mCurrText.getMeasuredWidth();
    int i = this.mNextText.getMeasuredWidth();
    int i3 = i1 / 2;
    int k = getWidth();
    int i4 = getHeight();
    int n = getPaddingLeft();
    int j = getPaddingRight();
    int i2 = getPaddingTop();
    int i5 = getPaddingBottom();
    int i6 = n + i3;
    i3 = j + i3;
    i6 = k - i6 - i3;
    float f = paramFloat + 0.5F;
    if (f > 1.0F) {
      f -= 1.0F;
    }
    i3 = k - i3 - (int)(f * i6) - i1 / 2;
    i1 = i3 + i1;
    int i7 = this.mPrevText.getBaseline();
    i6 = this.mCurrText.getBaseline();
    int i8 = this.mNextText.getBaseline();
    int i9 = Math.max(Math.max(i7, i6), i8);
    i7 = i9 - i7;
    i6 = i9 - i6;
    i8 = i9 - i8;
    int i10 = i7 + this.mPrevText.getMeasuredHeight();
    int i11 = i6 + this.mCurrText.getMeasuredHeight();
    i9 = i8 + this.mNextText.getMeasuredHeight();
    i9 = Math.max(Math.max(i10, i11), i9);
    switch (0x70 & this.mGravity)
    {
    default: 
      i4 = i2 + i7;
      i5 = i2 + i6;
      i2 += i8;
      break;
    case 16: 
      i2 = (i4 - i2 - i5 - i9) / 2;
      i4 = i2 + i7;
      i5 = i2 + i6;
      i2 += i8;
      break;
    case 80: 
      i2 = i4 - i5 - i9;
      i4 = i2 + i7;
      i5 = i2 + i6;
      i2 += i8;
    }
    TextView localTextView3 = this.mCurrText;
    i6 = i5 + this.mCurrText.getMeasuredHeight();
    localTextView3.layout(i3, i5, i1, i6);
    i3 = Math.min(n, i3 - this.mScaledTextSpacing - m);
    TextView localTextView2 = this.mPrevText;
    i5 = i3 + m;
    m = i4 + this.mPrevText.getMeasuredHeight();
    localTextView2.layout(i3, i4, i5, m);
    j = Math.max(k - j - i, i1 + this.mScaledTextSpacing);
    TextView localTextView1 = this.mNextText;
    i = j + i;
    m = i2 + this.mNextText.getMeasuredHeight();
    localTextView1.layout(j, i2, i, m);
    this.mLastKnownPositionOffset = paramFloat;
    this.mUpdatingPositions = false;
  }
  
  private class PageListener
    extends DataSetObserver
    implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener
  {
    private int mScrollState;
    
    private PageListener() {}
    
    public void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
    {
      PagerTitleStrip.this.updateAdapter(paramPagerAdapter1, paramPagerAdapter2);
    }
    
    public void onChanged()
    {
      PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      this.mScrollState = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (paramFloat > 0.5F) {
        paramInt1++;
      }
      PagerTitleStrip.this.updateTextPositions(paramInt1, paramFloat, false);
    }
    
    public void onPageSelected(int paramInt)
    {
      if (this.mScrollState == 0) {
        PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
      }
    }
  }
  
  static class PagerTitleStripImplIcs
    implements PagerTitleStrip.PagerTitleStripImpl
  {
    public void setSingleLineAllCaps(TextView paramTextView)
    {
      PagerTitleStripIcs.setSingleLineAllCaps(paramTextView);
    }
  }
  
  static class PagerTitleStripImplBase
    implements PagerTitleStrip.PagerTitleStripImpl
  {
    public void setSingleLineAllCaps(TextView paramTextView)
    {
      paramTextView.setSingleLine();
    }
  }
  
  static abstract interface PagerTitleStripImpl
  {
    public abstract void setSingleLineAllCaps(TextView paramTextView);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */
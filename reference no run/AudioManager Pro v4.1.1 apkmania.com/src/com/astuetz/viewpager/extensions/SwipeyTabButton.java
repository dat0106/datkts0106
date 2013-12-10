package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

public class SwipeyTabButton
  extends Button
  implements SwipeyTab
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private int mCenterPercent = 0;
  private Context mContext;
  private int mLineColorCenter = -13527106;
  private int mLineColorNormal = 0;
  private int mLineHeightSelected = 3;
  private Paint mLinePaint = new Paint();
  private int mTextColorCenter = -13527106;
  private int mTextColorNormal = 0;
  
  public SwipeyTabButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeyTabButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeyTabButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLineHeightSelected = ((int)TypedValue.applyDimension(1, this.mLineHeightSelected, paramContext.getResources().getDisplayMetrics()));
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mTextColorCenter = localTypedArray.getColor(2, this.mTextColorCenter);
    this.mLineColorCenter = localTypedArray.getColor(4, this.mLineColorCenter);
    this.mLineHeightSelected = localTypedArray.getDimensionPixelSize(6, this.mLineHeightSelected);
    localTypedArray.recycle();
    this.mTextColorNormal = getTextColors().getDefaultColor();
    setSingleLine(true);
  }
  
  private int ave(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
  
  private int interpColor(int[] paramArrayOfInt, float paramFloat)
  {
    int i;
    if (paramFloat > 0.0F)
    {
      if (paramFloat < 1.0F)
      {
        float f1 = paramFloat * (-1 + paramArrayOfInt.length);
        int j = (int)f1;
        float f2 = f1 - j;
        i = paramArrayOfInt[j];
        j = paramArrayOfInt[(j + 1)];
        i = Color.argb(ave(Color.alpha(i), Color.alpha(j), f2), ave(Color.red(i), Color.red(j), f2), ave(Color.green(i), Color.green(j), f2), ave(Color.blue(i), Color.blue(j), f2));
      }
      else
      {
        i = paramArrayOfInt[(-1 + paramArrayOfInt.length)];
      }
    }
    else {
      i = paramArrayOfInt[0];
    }
    return i;
  }
  
  /**
   * @deprecated
   */
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      Paint localPaint = this.mLinePaint;
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = this.mTextColorNormal;
      arrayOfInt[1] = this.mTextColorCenter;
      setTextColor(interpColor(arrayOfInt, this.mCenterPercent / 100.0F));
      arrayOfInt = new int[2];
      arrayOfInt[0] = this.mLineColorNormal;
      arrayOfInt[1] = this.mLineColorCenter;
      localPaint.setColor(interpColor(arrayOfInt, this.mCenterPercent / 100.0F));
      paramCanvas.drawRect(0.0F, getHeight() - this.mLineHeightSelected, getWidth(), getHeight(), localPaint);
      super.onDraw(paramCanvas);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setHighlightPercentage(int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 0;
    }
    if (paramInt > 100) {
      paramInt = 100;
    }
    this.mCenterPercent = paramInt;
    invalidate();
  }
  
  public void setLineColorCenter(int paramInt)
  {
    this.mLineColorCenter = paramInt;
    invalidate();
  }
  
  public void setLineHeight(int paramInt)
  {
    this.mLineHeightSelected = paramInt;
    invalidate();
  }
  
  public void setTextColorCenter(int paramInt)
  {
    this.mTextColorCenter = paramInt;
    invalidate();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.SwipeyTabButton
 * JD-Core Version:    0.7.0.1
 */
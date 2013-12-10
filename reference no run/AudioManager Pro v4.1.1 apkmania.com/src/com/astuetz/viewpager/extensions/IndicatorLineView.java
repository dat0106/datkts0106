package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;

public class IndicatorLineView
  extends View
  implements ViewPager.OnPageChangeListener
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private int mAlpha = 255;
  private int mFadeOutTime = 500;
  private int mFadingDuration = 200;
  private int mLineColor = -13322776;
  private float mLineLeft = 0.0F;
  private Paint mLinePaint = new Paint();
  private float mLineWidth = 0.0F;
  private ViewPager mPager;
  private FadeTimer mTimer;
  
  public IndicatorLineView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndicatorLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndicatorLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mLineColor = localTypedArray.getColor(3, this.mLineColor);
    this.mFadeOutTime = localTypedArray.getInt(0, this.mFadeOutTime);
    this.mFadingDuration = localTypedArray.getInt(1, this.mFadingDuration);
    localTypedArray.recycle();
  }
  
  private void resetTimer()
  {
    if (this.mFadeOutTime > 0)
    {
      if ((this.mTimer != null) && (this.mTimer.isRunning))
      {
        this.mTimer.reset();
      }
      else
      {
        this.mTimer = new FadeTimer(null);
        this.mTimer.execute(new Void[0]);
      }
      this.mAlpha = 255;
    }
  }
  
  private void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
    invalidate();
  }
  
  public int getFadeOutDelay()
  {
    return this.mFadeOutTime;
  }
  
  public int getFadeOutDuration()
  {
    return this.mFadingDuration;
  }
  
  public int getLineColor()
  {
    return this.mLineColor;
  }
  
  /**
   * @deprecated
   */
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      Paint localPaint = this.mLinePaint;
      localPaint.setColor(Color.argb(this.mAlpha, Color.red(this.mLineColor), Color.green(this.mLineColor), Color.blue(this.mLineColor)));
      paramCanvas.drawRect(this.mLineLeft, 0.0F, this.mLineLeft + this.mLineWidth, getMeasuredHeight(), localPaint);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    float f1 = this.mPager.getScrollX();
    float f2 = (this.mPager.getWidth() + this.mPager.getPageMargin()) * this.mPager.getAdapter().getCount();
    this.mLineLeft = (f1 * getMeasuredWidth() / f2);
    this.mLineWidth = (getMeasuredWidth() / this.mPager.getAdapter().getCount());
    resetTimer();
    invalidate();
  }
  
  public void onPageSelected(int paramInt) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mPager != null)
    {
      this.mLineWidth = (paramInt1 / this.mPager.getAdapter().getCount());
      this.mLineLeft = (this.mLineWidth * this.mPager.getCurrentItem());
      invalidate();
      resetTimer();
    }
  }
  
  public void setFadeOutDelay(int paramInt)
  {
    this.mFadeOutTime = paramInt;
    invalidate();
  }
  
  public void setFadeOutDuration(int paramInt)
  {
    this.mFadingDuration = paramInt;
    invalidate();
  }
  
  public void setLineColor(int paramInt)
  {
    this.mLineColor = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mPager = paramViewPager;
    this.mPager.setOnPageChangeListener(this);
  }
  
  private class FadeTimer
    extends AsyncTask<Void, Integer, Void>
  {
    private int elapsed = 0;
    private boolean isRunning = true;
    
    private FadeTimer() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      while (this.isRunning)
      {
        try
        {
          Thread.sleep(1L);
          this.elapsed = (1 + this.elapsed);
          if ((this.elapsed < IndicatorLineView.this.mFadeOutTime) || (this.elapsed >= IndicatorLineView.this.mFadeOutTime + IndicatorLineView.this.mFadingDuration)) {
            break label141;
          }
          int j = IndicatorLineView.this.mFadeOutTime;
          int i = IndicatorLineView.this.mFadeOutTime + IndicatorLineView.this.mFadingDuration;
          int k = this.elapsed;
          j = 255 + (0 * (k - j) - 255 * (k - j)) / (i - j);
          Integer[] arrayOfInteger = new Integer[1];
          arrayOfInteger[0] = Integer.valueOf(j);
          publishProgress(arrayOfInteger);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        continue;
        label141:
        if (this.elapsed >= IndicatorLineView.this.mFadeOutTime + IndicatorLineView.this.mFadingDuration) {
          this.isRunning = false;
        }
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      IndicatorLineView.this.setAlpha(0);
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      IndicatorLineView.this.setAlpha(paramVarArgs[0].intValue());
    }
    
    public void reset()
    {
      this.elapsed = 0;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.IndicatorLineView
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class AspectRatioImageView
  extends ImageView
{
  public AspectRatioImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AspectRatioImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      int i;
      int j;
      if (getLayoutParams().height != -2)
      {
        i = View.MeasureSpec.getSize(paramInt2);
        j = localDrawable.getIntrinsicHeight();
        if (j <= 0) {
          super.onMeasure(paramInt1, paramInt2);
        } else {
          setMeasuredDimension(i * localDrawable.getIntrinsicWidth() / j, i);
        }
      }
      else
      {
        i = View.MeasureSpec.getSize(paramInt1);
        j = localDrawable.getIntrinsicWidth();
        if (j <= 0) {
          super.onMeasure(paramInt1, paramInt2);
        } else {
          setMeasuredDimension(i, i * localDrawable.getIntrinsicHeight() / j);
        }
      }
    }
    else
    {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.AspectRatioImageView
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.actionbarsherlock.R.styleable;

public class FakeDialogPhoneWindow
  extends LinearLayout
{
  final TypedValue mMinWidthMajor = new TypedValue();
  final TypedValue mMinWidthMinor = new TypedValue();
  
  public FakeDialogPhoneWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockTheme);
    localTypedArray.getValue(34, this.mMinWidthMajor);
    localTypedArray.getValue(35, this.mMinWidthMinor);
    localTypedArray.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int n;
    if (localDisplayMetrics.widthPixels >= localDisplayMetrics.heightPixels) {
      n = 0;
    } else {
      n = 1;
    }
    super.onMeasure(paramInt1, paramInt2);
    int k = getMeasuredWidth();
    int i = 0;
    int j = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
    TypedValue localTypedValue;
    if (n == 0) {
      localTypedValue = this.mMinWidthMajor;
    } else {
      localTypedValue = this.mMinWidthMinor;
    }
    if (localTypedValue.type != 0)
    {
      int m;
      if (localTypedValue.type != 5)
      {
        if (localTypedValue.type != 6) {
          m = 0;
        } else {
          m = (int)localTypedValue.getFraction(m.widthPixels, m.widthPixels);
        }
      }
      else {
        m = (int)localTypedValue.getDimension(m);
      }
      if (k < m)
      {
        j = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
        i = 1;
      }
    }
    if (i != 0) {
      super.onMeasure(j, paramInt2);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.FakeDialogPhoneWindow
 * JD-Core Version:    0.7.0.1
 */
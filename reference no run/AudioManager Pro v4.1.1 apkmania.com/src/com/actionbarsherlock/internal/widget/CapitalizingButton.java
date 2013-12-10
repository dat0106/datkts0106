package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton
  extends Button
{
  private static final boolean IS_GINGERBREAD;
  private static final int[] R_styleable_Button;
  private static final int R_styleable_Button_textAllCaps;
  private static final boolean SANS_ICE_CREAM;
  private boolean mAllCaps;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 14) {
      bool = false;
    } else {
      bool = true;
    }
    SANS_ICE_CREAM = bool;
    if (Build.VERSION.SDK_INT < 9) {
      bool = false;
    } else {
      bool = true;
    }
    IS_GINGERBREAD = bool;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843660;
    R_styleable_Button = arrayOfInt;
  }
  
  public CapitalizingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_Button);
    this.mAllCaps = localTypedArray.getBoolean(0, true);
    localTypedArray.recycle();
  }
  
  public void setTextCompat(CharSequence paramCharSequence)
  {
    if ((!SANS_ICE_CREAM) || (!this.mAllCaps) || (paramCharSequence == null)) {
      setText(paramCharSequence);
    } else if (!IS_GINGERBREAD) {
      setText(paramCharSequence.toString().toUpperCase());
    } else {
      setText(paramCharSequence.toString().toUpperCase(Locale.ROOT));
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.CapitalizingButton
 * JD-Core Version:    0.7.0.1
 */
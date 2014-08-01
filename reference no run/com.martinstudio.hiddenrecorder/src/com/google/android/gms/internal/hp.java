package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.R.color;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;

public final class hp
  extends Button
{
  public hp(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public hp(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown color scheme: " + paramInt1);
    case 1: 
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  private void b(Resources paramResources, int paramInt1, int paramInt2)
  {
    int i;
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    case 0: 
    case 1: 
      i = b(paramInt2, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
      break;
    case 2: 
      i = b(paramInt2, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
    }
    if (i != -1)
    {
      setBackgroundDrawable(paramResources.getDrawable(i));
      return;
    }
    throw new IllegalStateException("Could not find background resource!");
  }
  
  private void c(Resources paramResources)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = paramResources.getDisplayMetrics().density;
    setMinHeight((int)(0.5F + f * 48.0F));
    setMinWidth((int)(0.5F + f * 48.0F));
  }
  
  private void c(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTextColor(paramResources.getColorStateList(b(paramInt2, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    case 0: 
      setText(paramResources.getString(R.string.common_signin_button_text));
      break;
    case 1: 
      setText(paramResources.getString(R.string.common_signin_button_text_long));
      break;
    case 2: 
      setText(null);
    }
  }
  
  public void a(Resources paramResources, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {
      bool = false;
    } else {
      bool = true;
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    hn.a(bool, "Unknown button size %d", arrayOfObject);
    if ((paramInt2 < 0) || (paramInt2 >= 2)) {
      bool = false;
    } else {
      bool = true;
    }
    arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt2);
    hn.a(bool, "Unknown color scheme %s", arrayOfObject);
    c(paramResources);
    b(paramResources, paramInt1, paramInt2);
    c(paramResources, paramInt1, paramInt2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hp
 * JD-Core Version:    0.7.0.1
 */
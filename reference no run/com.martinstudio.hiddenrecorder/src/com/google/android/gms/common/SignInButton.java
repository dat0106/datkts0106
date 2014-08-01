package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.ho;
import com.google.android.gms.internal.hp;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int Dg;
  private View Dh;
  private View.OnClickListener Di = null;
  private int mSize;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setStyle(0, 0);
  }
  
  private static Button a(Context paramContext, int paramInt1, int paramInt2)
  {
    hp localhp = new hp(paramContext);
    localhp.a(paramContext.getResources(), paramInt1, paramInt2);
    return localhp;
  }
  
  private void z(Context paramContext)
  {
    if (this.Dh != null) {
      removeView(this.Dh);
    }
    try
    {
      this.Dh = ho.b(paramContext, this.mSize, this.Dg);
      addView(this.Dh);
      this.Dh.setEnabled(isEnabled());
      this.Dh.setOnClickListener(this);
      return;
    }
    catch (g.a locala)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        this.Dh = a(paramContext, this.mSize, this.Dg);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.Di != null) && (paramView == this.Dh)) {
      this.Di.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.Dh.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Di = paramOnClickListener;
    if (this.Dh != null) {
      this.Dh.setOnClickListener(this);
    }
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, this.Dg);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
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
    this.mSize = paramInt1;
    this.Dg = paramInt2;
    z(getContext());
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * JD-Core Version:    0.7.0.1
 */
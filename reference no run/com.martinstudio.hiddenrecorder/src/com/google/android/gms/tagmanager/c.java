package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class c
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.v.toString();
  private final a aeg;
  
  public c(Context paramContext)
  {
    this(a.J(paramContext));
  }
  
  c(a parama)
  {
    super(ID, new String[0]);
    this.aeg = parama;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    boolean bool;
    if (this.aeg.isLimitAdTrackingEnabled()) {
      bool = false;
    } else {
      bool = true;
    }
    return dh.r(Boolean.valueOf(bool));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.c
 * JD-Core Version:    0.7.0.1
 */
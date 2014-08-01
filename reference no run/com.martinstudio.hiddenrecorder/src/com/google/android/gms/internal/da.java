package com.google.android.gms.internal;

import android.content.Intent;

public class da
{
  private final String mx;
  
  public da(String paramString)
  {
    this.mx = paramString;
  }
  
  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if ((paramString != null) && (paramIntent != null))
    {
      String str2 = cz.d(paramIntent);
      String str1 = cz.e(paramIntent);
      if ((str2 != null) && (str1 != null)) {
        if (paramString.equals(cz.p(str2)))
        {
          if ((this.mx == null) || (db.b(this.mx, str2, str1))) {
            bool = true;
          } else {
            ev.D("Fail to verify signature.");
          }
        }
        else {
          ev.D("Developer payload not match.");
        }
      }
    }
    return bool;
  }
  
  public String bh()
  {
    return ep.bO();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.da
 * JD-Core Version:    0.7.0.1
 */
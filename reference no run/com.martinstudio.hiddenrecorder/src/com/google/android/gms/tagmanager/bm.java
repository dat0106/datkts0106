package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class bm
{
  public bl lM()
  {
    Object localObject;
    if (le() >= 8) {
      localObject = new aw();
    } else {
      localObject = new av();
    }
    return localObject;
  }
  
  int le()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bm
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class ao
  extends at.a
{
  private final AppEventListener mf;
  
  public ao(AppEventListener paramAppEventListener)
  {
    this.mf = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.mf.onAppEvent(paramString1, paramString2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ao
 * JD-Core Version:    0.7.0.1
 */
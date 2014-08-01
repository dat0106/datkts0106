package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class gh
{
  protected final go BA;
  private final String BB;
  private gq BC;
  
  protected gh(String paramString1, String paramString2, String paramString3)
  {
    gj.ak(paramString1);
    this.BB = paramString1;
    this.BA = new go(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      this.BA.ap(paramString3);
    }
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public final void a(gq paramgq)
  {
    this.BC = paramgq;
    if (this.BC == null) {
      dZ();
    }
  }
  
  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    go localgo = this.BA;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    localgo.a("Sending text message: %s to: %s", arrayOfObject);
    this.BC.a(this.BB, paramString1, paramLong, paramString2);
  }
  
  public void ai(String paramString) {}
  
  protected final long dY()
  {
    return this.BC.dW();
  }
  
  public void dZ() {}
  
  public final String getNamespace()
  {
    return this.BB;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gh
 * JD-Core Version:    0.7.0.1
 */
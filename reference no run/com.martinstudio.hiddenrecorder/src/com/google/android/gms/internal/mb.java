package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class mb<M extends mb<M>>
  extends mf
{
  protected List<mh> amU;
  
  public final <T> T a(mc<M, T> parammc)
  {
    return parammc.i(this.amU);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    int i;
    if (this.amU != null) {
      i = this.amU.size();
    } else {
      i = 0;
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      mh localmh = (mh)this.amU.get(j);
      paramma.eI(localmh.tag);
      paramma.t(localmh.amZ);
    }
  }
  
  protected final boolean a(lz paramlz, int paramInt)
    throws IOException
  {
    int i = paramlz.getPosition();
    boolean bool;
    if (paramlz.ev(paramInt))
    {
      if (this.amU == null) {
        this.amU = new ArrayList();
      }
      byte[] arrayOfByte = paramlz.o(i, paramlz.getPosition() - i);
      this.amU.add(new mh(paramInt, arrayOfByte));
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  protected int c()
  {
    int j;
    if (this.amU != null) {
      j = this.amU.size();
    } else {
      j = 0;
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (k >= j) {
        return i;
      }
      mh localmh = (mh)this.amU.get(k);
      i = i + ma.eJ(localmh.tag) + localmh.amZ.length;
      k++;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mb
 * JD-Core Version:    0.7.0.1
 */
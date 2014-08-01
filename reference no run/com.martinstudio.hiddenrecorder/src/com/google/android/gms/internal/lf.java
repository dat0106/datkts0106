package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface lf
{
  public static final class a
    extends mb<a>
  {
    public long aiD;
    public c.j aiE;
    public c.f fK;
    
    public a()
    {
      na();
    }
    
    public static a l(byte[] paramArrayOfByte)
      throws me
    {
      return (a)mf.a(new a(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.b(1, this.aiD);
      if (this.fK != null) {
        paramma.a(2, this.fK);
      }
      if (this.aiE != null) {
        paramma.a(3, this.aiE);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c() + ma.d(1, this.aiD);
      if (this.fK != null) {
        i += ma.b(2, this.fK);
      }
      if (this.aiE != null) {
        i += ma.b(3, this.aiE);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof a))
        {
          a locala = (a)paramObject;
          if ((this.aiD == locala.aiD) && (this.fK != null ? this.fK.equals(locala.fK) : locala.fK == null)) {
            if (this.aiE != null ? this.aiE.equals(locala.aiE) : locala.aiE == null) {
              if ((this.amU != null) && (!this.amU.isEmpty())) {
                bool = this.amU.equals(locala.amU);
              } else if ((locala.amU == null) || (locala.amU.isEmpty())) {
                bool = true;
              }
            }
          }
        }
      }
      else {
        bool = true;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i = 0;
      int j = 31 * (527 + (int)(this.aiD ^ this.aiD >>> 32));
      if (this.fK != null) {
        k = this.fK.hashCode();
      } else {
        k = 0;
      }
      int k = 31 * (k + j);
      if (this.aiE != null) {
        j = this.aiE.hashCode();
      } else {
        j = 0;
      }
      j = 31 * (j + k);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public a na()
    {
      this.aiD = 0L;
      this.fK = null;
      this.aiE = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a p(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {
            continue;
          }
        case 0: 
          return this;
        case 8: 
          this.aiD = paramlz.ny();
          break;
        case 18: 
          if (this.fK == null) {
            this.fK = new c.f();
          }
          paramlz.a(this.fK);
          break;
        }
        if (this.aiE == null) {
          this.aiE = new c.j();
        }
        paramlz.a(this.aiE);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lf
 * JD-Core Version:    0.7.0.1
 */
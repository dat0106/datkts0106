package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;
import java.io.IOException;
import java.util.List;

public final class af
  extends mb<af>
{
  public String Jq;
  public long Jr;
  public long Js;
  public int versionCode;
  
  public af()
  {
    gn();
  }
  
  public static af g(byte[] paramArrayOfByte)
    throws me
  {
    return (af)mf.a(new af(), paramArrayOfByte);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    paramma.p(1, this.versionCode);
    paramma.b(2, this.Jq);
    paramma.c(3, this.Jr);
    paramma.c(4, this.Js);
    super.a(paramma);
  }
  
  protected int c()
  {
    return super.c() + ma.r(1, this.versionCode) + ma.h(2, this.Jq) + ma.e(3, this.Jr) + ma.e(4, this.Js);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != this)
    {
      if ((paramObject instanceof af))
      {
        af localaf = (af)paramObject;
        if ((this.versionCode == localaf.versionCode) && (this.Jq != null ? this.Jq.equals(localaf.Jq) : localaf.Jq == null)) {
          if ((this.Jr == localaf.Jr) && (this.Js == localaf.Js)) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(localaf.amU);
            } else if ((localaf.amU == null) || (localaf.amU.isEmpty())) {
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
  
  public af gn()
  {
    this.versionCode = 1;
    this.Jq = "";
    this.Jr = -1L;
    this.Js = -1L;
    this.amU = null;
    this.amY = -1;
    return this;
  }
  
  public int hashCode()
  {
    int i = 0;
    int k = 31 * (527 + this.versionCode);
    if (this.Jq != null) {
      j = this.Jq.hashCode();
    } else {
      j = 0;
    }
    int j = 31 * (31 * (31 * (j + k) + (int)(this.Jr ^ this.Jr >>> 32)) + (int)(this.Js ^ this.Js >>> 32));
    if ((this.amU != null) && (!this.amU.isEmpty())) {
      i = this.amU.hashCode();
    }
    return j + i;
  }
  
  public af m(lz paramlz)
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
        this.versionCode = paramlz.nz();
        break;
      case 18: 
        this.Jq = paramlz.readString();
        break;
      case 24: 
        this.Jr = paramlz.nC();
        break;
      }
      this.Js = paramlz.nC();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.af
 * JD-Core Version:    0.7.0.1
 */
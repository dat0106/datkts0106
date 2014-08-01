package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

public abstract class d
{
  protected final DataHolder DD;
  private int EA;
  protected int Ez;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.DD = ((DataHolder)hn.f(paramDataHolder));
    ac(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.DD.a(paramString, this.Ez, this.EA, paramCharArrayBuffer);
  }
  
  protected void ac(int paramInt)
  {
    boolean bool;
    if ((paramInt < 0) || (paramInt >= this.DD.getCount())) {
      bool = false;
    } else {
      bool = true;
    }
    hn.A(bool);
    this.Ez = paramInt;
    this.EA = this.DD.ae(this.Ez);
  }
  
  public boolean av(String paramString)
  {
    return this.DD.av(paramString);
  }
  
  protected Uri aw(String paramString)
  {
    return this.DD.g(paramString, this.Ez, this.EA);
  }
  
  protected boolean ax(String paramString)
  {
    return this.DD.h(paramString, this.Ez, this.EA);
  }
  
  protected int eQ()
  {
    return this.Ez;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof d))
    {
      d locald = (d)paramObject;
      if ((hl.equal(Integer.valueOf(locald.Ez), Integer.valueOf(this.Ez))) && (hl.equal(Integer.valueOf(locald.EA), Integer.valueOf(this.EA))) && (locald.DD == this.DD)) {
        bool = true;
      }
    }
    return bool;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.DD.d(paramString, this.Ez, this.EA);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.DD.f(paramString, this.Ez, this.EA);
  }
  
  protected float getFloat(String paramString)
  {
    return this.DD.e(paramString, this.Ez, this.EA);
  }
  
  protected int getInteger(String paramString)
  {
    return this.DD.b(paramString, this.Ez, this.EA);
  }
  
  protected long getLong(String paramString)
  {
    return this.DD.a(paramString, this.Ez, this.EA);
  }
  
  protected String getString(String paramString)
  {
    return this.DD.c(paramString, this.Ez, this.EA);
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.Ez);
    arrayOfObject[1] = Integer.valueOf(this.EA);
    arrayOfObject[2] = this.DD;
    return hl.hashCode(arrayOfObject);
  }
  
  public boolean isDataValid()
  {
    boolean bool;
    if (this.DD.isClosed()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.d
 * JD-Core Version:    0.7.0.1
 */
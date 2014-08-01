package com.google.android.gms.tagmanager;

class dg
  extends Number
  implements Comparable<dg>
{
  private double aih;
  private long aii;
  private boolean aij;
  
  private dg(double paramDouble)
  {
    this.aih = paramDouble;
    this.aij = false;
  }
  
  private dg(long paramLong)
  {
    this.aii = paramLong;
    this.aij = true;
  }
  
  public static dg a(Double paramDouble)
  {
    return new dg(paramDouble.doubleValue());
  }
  
  public static dg co(String paramString)
    throws NumberFormatException
  {
    try
    {
      localdg = new dg(Long.parseLong(paramString));
      return localdg;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        dg localdg = new dg(Double.parseDouble(paramString));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public static dg z(long paramLong)
  {
    return new dg(paramLong);
  }
  
  public int a(dg paramdg)
  {
    int i;
    if ((!mO()) || (!paramdg.mO())) {
      i = Double.compare(doubleValue(), paramdg.doubleValue());
    } else {
      i = new Long(this.aii).compareTo(Long.valueOf(paramdg.aii));
    }
    return i;
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    double d;
    if (!mO()) {
      d = this.aih;
    } else {
      d = this.aii;
    }
    return d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((!(paramObject instanceof dg)) || (a((dg)paramObject) != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return mQ();
  }
  
  public long longValue()
  {
    return mP();
  }
  
  public boolean mN()
  {
    boolean bool;
    if (mO()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean mO()
  {
    return this.aij;
  }
  
  public long mP()
  {
    long l;
    if (!mO()) {
      l = this.aih;
    } else {
      l = this.aii;
    }
    return l;
  }
  
  public int mQ()
  {
    return (int)longValue();
  }
  
  public short mR()
  {
    return (short)(int)longValue();
  }
  
  public short shortValue()
  {
    return mR();
  }
  
  public String toString()
  {
    String str;
    if (!mO()) {
      str = Double.toString(this.aih);
    } else {
      str = Long.toString(this.aii);
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dg
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.analytics;

class z
  implements ad
{
  private final long wB;
  private final int wC;
  private double wD;
  private long wE;
  private final Object wF = new Object();
  private final String wG;
  
  public z(int paramInt, long paramLong, String paramString)
  {
    this.wC = paramInt;
    this.wD = this.wC;
    this.wB = paramLong;
    this.wG = paramString;
  }
  
  public z(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean dj()
  {
    synchronized (this.wF)
    {
      long l = System.currentTimeMillis();
      if (this.wD < this.wC)
      {
        double d = (l - this.wE) / this.wB;
        if (d > 0.0D) {
          this.wD = Math.min(this.wC, d + this.wD);
        }
      }
      this.wE = l;
      int i;
      if (this.wD >= 1.0D)
      {
        this.wD -= 1.0D;
        i = 1;
      }
      else
      {
        aa.D("Excessive " + this.wG + " detected; call ignored.");
        i = 0;
      }
    }
    return localObject2;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.z
 * JD-Core Version:    0.7.0.1
 */
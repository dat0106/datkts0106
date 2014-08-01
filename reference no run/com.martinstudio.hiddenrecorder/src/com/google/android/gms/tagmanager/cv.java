package com.google.android.gms.tagmanager;

class cv
  implements cf
{
  private long ahG;
  private final long wB;
  private final int wC;
  private double wD;
  private final Object wF = new Object();
  
  public cv()
  {
    this(60, 2000L);
  }
  
  public cv(int paramInt, long paramLong)
  {
    this.wC = paramInt;
    this.wD = this.wC;
    this.wB = paramLong;
  }
  
  public boolean dj()
  {
    synchronized (this.wF)
    {
      long l = System.currentTimeMillis();
      if (this.wD < this.wC)
      {
        double d = (l - this.ahG) / this.wB;
        if (d > 0.0D) {
          this.wD = Math.min(this.wC, d + this.wD);
        }
      }
      this.ahG = l;
      int i;
      if (this.wD >= 1.0D)
      {
        this.wD -= 1.0D;
        i = 1;
      }
      else
      {
        bh.D("No more tokens available.");
        i = 0;
      }
    }
    return localObject2;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cv
 * JD-Core Version:    0.7.0.1
 */
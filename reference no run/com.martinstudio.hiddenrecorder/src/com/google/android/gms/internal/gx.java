package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class gx
  extends hr<a, Drawable>
{
  public gx()
  {
    super(10);
  }
  
  public static final class a
  {
    public final int FP;
    public final int FQ;
    
    public a(int paramInt1, int paramInt2)
    {
      this.FP = paramInt1;
      this.FQ = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if ((paramObject instanceof a))
      {
        if (this != paramObject)
        {
          a locala = (a)paramObject;
          if ((locala.FP != this.FP) || (locala.FQ != this.FQ)) {
            bool = false;
          }
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.FP);
      arrayOfObject[1] = Integer.valueOf(this.FQ);
      return hl.hashCode(arrayOfObject);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gx
 * JD-Core Version:    0.7.0.1
 */
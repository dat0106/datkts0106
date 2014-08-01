package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ma
{
  private final int amT;
  private final byte[] buffer;
  private int position;
  
  private ma(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.position = paramInt1;
    this.amT = (paramInt1 + paramInt2);
  }
  
  public static int D(long paramLong)
  {
    return G(paramLong);
  }
  
  public static int E(long paramLong)
  {
    return G(I(paramLong));
  }
  
  public static int G(long paramLong)
  {
    int i;
    if ((0xFFFFFF80 & paramLong) != 0L)
    {
      if ((0xFFFFC000 & paramLong) != 0L)
      {
        if ((0xFFE00000 & paramLong) != 0L)
        {
          if ((0xF0000000 & paramLong) != 0L)
          {
            if ((0x0 & paramLong) != 0L)
            {
              if ((0x0 & paramLong) != 0L)
              {
                if ((0x0 & paramLong) != 0L)
                {
                  if ((0x0 & paramLong) != 0L)
                  {
                    if ((0x0 & paramLong) != 0L) {
                      i = 10;
                    } else {
                      i = 9;
                    }
                  }
                  else {
                    i = 8;
                  }
                }
                else {
                  i = 7;
                }
              }
              else {
                i = 6;
              }
            }
            else {
              i = 5;
            }
          }
          else {
            i = 4;
          }
        }
        else {
          i = 3;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static long I(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int J(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return eH(paramInt) + f(paramDouble);
  }
  
  public static int b(int paramInt, mf parammf)
  {
    return eH(paramInt) + c(parammf);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return eH(paramInt) + J(paramBoolean);
  }
  
  public static int b(int paramInt, byte[] paramArrayOfByte)
  {
    return eH(paramInt) + s(paramArrayOfByte);
  }
  
  public static ma b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ma(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    return eH(paramInt) + e(paramFloat);
  }
  
  public static int c(mf parammf)
  {
    int i = parammf.nV();
    return i + eJ(i);
  }
  
  public static int cz(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = eJ(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.");
    }
  }
  
  public static int d(int paramInt, long paramLong)
  {
    return eH(paramInt) + D(paramLong);
  }
  
  public static int e(float paramFloat)
  {
    return 4;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    return eH(paramInt) + E(paramLong);
  }
  
  public static int eE(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = 10;
    } else {
      i = eJ(paramInt);
    }
    return i;
  }
  
  public static int eF(int paramInt)
  {
    return eJ(eL(paramInt));
  }
  
  public static int eH(int paramInt)
  {
    return eJ(mi.u(paramInt, 0));
  }
  
  public static int eJ(int paramInt)
  {
    int i;
    if ((paramInt & 0xFFFFFF80) != 0)
    {
      if ((paramInt & 0xFFFFC000) != 0)
      {
        if ((0xFFE00000 & paramInt) != 0)
        {
          if ((0xF0000000 & paramInt) != 0) {
            i = 5;
          } else {
            i = 4;
          }
        }
        else {
          i = 3;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static int eL(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int f(double paramDouble)
  {
    return 8;
  }
  
  public static int h(int paramInt, String paramString)
  {
    return eH(paramInt) + cz(paramString);
  }
  
  public static ma q(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int r(int paramInt1, int paramInt2)
  {
    return eH(paramInt1) + eE(paramInt2);
  }
  
  public static int s(int paramInt1, int paramInt2)
  {
    return eH(paramInt1) + eF(paramInt2);
  }
  
  public static int s(byte[] paramArrayOfByte)
  {
    return eJ(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public void B(long paramLong)
    throws IOException
  {
    F(paramLong);
  }
  
  public void C(long paramLong)
    throws IOException
  {
    F(I(paramLong));
  }
  
  public void F(long paramLong)
    throws IOException
  {
    while ((0xFFFFFF80 & paramLong) != 0L)
    {
      eG(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
    eG((int)paramLong);
  }
  
  public void H(long paramLong)
    throws IOException
  {
    eG(0xFF & (int)paramLong);
    eG(0xFF & (int)(paramLong >> 8));
    eG(0xFF & (int)(paramLong >> 16));
    eG(0xFF & (int)(paramLong >> 24));
    eG(0xFF & (int)(paramLong >> 32));
    eG(0xFF & (int)(paramLong >> 40));
    eG(0xFF & (int)(paramLong >> 48));
    eG(0xFF & (int)(paramLong >> 56));
  }
  
  public void I(boolean paramBoolean)
    throws IOException
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    eG(i);
  }
  
  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    t(paramInt, 1);
    e(paramDouble);
  }
  
  public void a(int paramInt, mf parammf)
    throws IOException
  {
    t(paramInt, 2);
    b(parammf);
  }
  
  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    t(paramInt, 0);
    I(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    t(paramInt, 2);
    r(paramArrayOfByte);
  }
  
  public void b(byte paramByte)
    throws IOException
  {
    if (this.position != this.amT)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = paramByte;
      return;
    }
    throw new a(this.position, this.amT);
  }
  
  public void b(int paramInt, float paramFloat)
    throws IOException
  {
    t(paramInt, 5);
    d(paramFloat);
  }
  
  public void b(int paramInt, long paramLong)
    throws IOException
  {
    t(paramInt, 0);
    B(paramLong);
  }
  
  public void b(int paramInt, String paramString)
    throws IOException
  {
    t(paramInt, 2);
    cy(paramString);
  }
  
  public void b(mf parammf)
    throws IOException
  {
    eI(parammf.nU());
    parammf.a(this);
  }
  
  public void c(int paramInt, long paramLong)
    throws IOException
  {
    t(paramInt, 0);
    C(paramLong);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.amT - this.position < paramInt2) {
      throw new a(this.position, this.amT);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
    this.position = (paramInt2 + this.position);
  }
  
  public void cy(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    eI(arrayOfByte.length);
    t(arrayOfByte);
  }
  
  public void d(float paramFloat)
    throws IOException
  {
    eK(Float.floatToIntBits(paramFloat));
  }
  
  public void e(double paramDouble)
    throws IOException
  {
    H(Double.doubleToLongBits(paramDouble));
  }
  
  public void eC(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      F(paramInt);
    } else {
      eI(paramInt);
    }
  }
  
  public void eD(int paramInt)
    throws IOException
  {
    eI(eL(paramInt));
  }
  
  public void eG(int paramInt)
    throws IOException
  {
    b((byte)paramInt);
  }
  
  public void eI(int paramInt)
    throws IOException
  {
    while ((paramInt & 0xFFFFFF80) != 0)
    {
      eG(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
    eG(paramInt);
  }
  
  public void eK(int paramInt)
    throws IOException
  {
    eG(paramInt & 0xFF);
    eG(0xFF & paramInt >> 8);
    eG(0xFF & paramInt >> 16);
    eG(0xFF & paramInt >> 24);
  }
  
  public int nL()
  {
    return this.amT - this.position;
  }
  
  public void nM()
  {
    if (nL() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public void p(int paramInt1, int paramInt2)
    throws IOException
  {
    t(paramInt1, 0);
    eC(paramInt2);
  }
  
  public void q(int paramInt1, int paramInt2)
    throws IOException
  {
    t(paramInt1, 0);
    eD(paramInt2);
  }
  
  public void r(byte[] paramArrayOfByte)
    throws IOException
  {
    eI(paramArrayOfByte.length);
    t(paramArrayOfByte);
  }
  
  public void t(int paramInt1, int paramInt2)
    throws IOException
  {
    eI(mi.u(paramInt1, paramInt2));
  }
  
  public void t(byte[] paramArrayOfByte)
    throws IOException
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static class a
    extends IOException
  {
    a(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ma
 * JD-Core Version:    0.7.0.1
 */
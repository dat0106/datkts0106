package com.google.android.gms.internal;

import java.io.IOException;

public final class lz
{
  private int amK;
  private int amL;
  private int amM;
  private int amN;
  private int amO;
  private int amP = 2147483647;
  private int amQ;
  private int amR = 64;
  private int amS = 67108864;
  private final byte[] buffer;
  
  private lz(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.amK = paramInt1;
    this.amL = (paramInt1 + paramInt2);
    this.amN = paramInt1;
  }
  
  public static long A(long paramLong)
  {
    return paramLong >>> 1 ^ -(0x1 & paramLong);
  }
  
  public static lz a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new lz(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int ew(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private void nH()
  {
    this.amL += this.amM;
    int i = this.amL;
    if (i <= this.amP)
    {
      this.amM = 0;
    }
    else
    {
      this.amM = (i - this.amP);
      this.amL -= this.amM;
    }
  }
  
  public static lz p(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(mf parammf)
    throws IOException
  {
    int i = nD();
    if (this.amQ < this.amR)
    {
      i = ex(i);
      this.amQ = (1 + this.amQ);
      parammf.b(this);
      eu(0);
      this.amQ = (-1 + this.amQ);
      ey(i);
      return;
    }
    throw me.nT();
  }
  
  public void a(mf parammf, int paramInt)
    throws IOException
  {
    if (this.amQ < this.amR)
    {
      this.amQ = (1 + this.amQ);
      parammf.b(this);
      eu(mi.u(paramInt, 4));
      this.amQ = (-1 + this.amQ);
      return;
    }
    throw me.nT();
  }
  
  public byte[] eA(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      if (paramInt + this.amN <= this.amP)
      {
        if (paramInt > this.amL - this.amN) {
          throw me.nN();
        }
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(this.buffer, this.amN, arrayOfByte, 0, paramInt);
        this.amN = (paramInt + this.amN);
        return arrayOfByte;
      }
      eB(this.amP - this.amN);
      throw me.nN();
    }
    throw me.nO();
  }
  
  public void eB(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      if (paramInt + this.amN <= this.amP)
      {
        if (paramInt > this.amL - this.amN) {
          throw me.nN();
        }
        this.amN = (paramInt + this.amN);
        return;
      }
      eB(this.amP - this.amN);
      throw me.nN();
    }
    throw me.nO();
  }
  
  public void eu(int paramInt)
    throws me
  {
    if (this.amO == paramInt) {
      return;
    }
    throw me.nR();
  }
  
  public boolean ev(int paramInt)
    throws IOException
  {
    boolean bool = true;
    switch (mi.eN(paramInt))
    {
    default: 
      throw me.nS();
    case 0: 
      nz();
      break;
    case 1: 
      nG();
      break;
    case 2: 
      eB(nD());
      break;
    case 3: 
      nx();
      eu(mi.u(mi.eO(paramInt), 4));
      break;
    case 4: 
      bool = false;
      break;
    case 5: 
      nF();
    }
    return bool;
  }
  
  public int ex(int paramInt)
    throws me
  {
    if (paramInt >= 0)
    {
      int i = paramInt + this.amN;
      int j = this.amP;
      if (i <= j)
      {
        this.amP = i;
        nH();
        return j;
      }
      throw me.nN();
    }
    throw me.nO();
  }
  
  public void ey(int paramInt)
  {
    this.amP = paramInt;
    nH();
  }
  
  public void ez(int paramInt)
  {
    if (paramInt <= this.amN - this.amK)
    {
      if (paramInt >= 0)
      {
        this.amN = (paramInt + this.amK);
        return;
      }
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.amN - this.amK));
  }
  
  public int getPosition()
  {
    return this.amN - this.amK;
  }
  
  public boolean nA()
    throws IOException
  {
    boolean bool;
    if (nD() == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int nB()
    throws IOException
  {
    return ew(nD());
  }
  
  public long nC()
    throws IOException
  {
    return A(nE());
  }
  
  public int nD()
    throws IOException
  {
    int j = nK();
    if (j < 0)
    {
      int i = j & 0x7F;
      j = nK();
      if (j < 0)
      {
        j = i | (j & 0x7F) << 7;
        i = nK();
        if (i < 0)
        {
          i = j | (i & 0x7F) << 14;
          j = nK();
          if (j < 0)
          {
            j = i | (j & 0x7F) << 21;
            i = nK();
            j |= i << 28;
            if (i < 0) {
              for (i = 0;; i++)
              {
                if (i >= 5) {
                  throw me.nP();
                }
                if (nK() >= 0) {
                  break;
                }
              }
            }
          }
          else
          {
            j = i | j << 21;
          }
        }
        else
        {
          j |= i << 14;
        }
      }
      else
      {
        j = i | j << 7;
      }
    }
    return j;
  }
  
  public long nE()
    throws IOException
  {
    int j = 0;
    long l = 0L;
    for (;;)
    {
      if (j >= 64) {
        throw me.nP();
      }
      int i = nK();
      l |= (i & 0x7F) << j;
      if ((i & 0x80) == 0) {
        break;
      }
      j += 7;
    }
    return l;
  }
  
  public int nF()
    throws IOException
  {
    int j = nK();
    int i = nK();
    int m = nK();
    int k = nK();
    return j & 0xFF | (i & 0xFF) << 8 | (m & 0xFF) << 16 | (k & 0xFF) << 24;
  }
  
  public long nG()
    throws IOException
  {
    int i2 = nK();
    int i3 = nK();
    int m = nK();
    int i1 = nK();
    int j = nK();
    int n = nK();
    int i = nK();
    int k = nK();
    return 0xFF & i2 | (0xFF & i3) << 8 | (0xFF & m) << 16 | (0xFF & i1) << 24 | (0xFF & j) << 32 | (0xFF & n) << 40 | (0xFF & i) << 48 | (0xFF & k) << 56;
  }
  
  public int nI()
  {
    int i;
    if (this.amP != 2147483647)
    {
      i = this.amN;
      i = this.amP - i;
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public boolean nJ()
  {
    boolean bool;
    if (this.amN != this.amL) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public byte nK()
    throws IOException
  {
    if (this.amN != this.amL)
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.amN;
      this.amN = (i + 1);
      return arrayOfByte[i];
    }
    throw me.nN();
  }
  
  public int nw()
    throws IOException
  {
    int i = 0;
    if (!nJ())
    {
      this.amO = nD();
      if (this.amO != 0) {
        i = this.amO;
      } else {
        throw me.nQ();
      }
    }
    else
    {
      this.amO = 0;
    }
    return i;
  }
  
  public void nx()
    throws IOException
  {
    int i;
    do
    {
      i = nw();
    } while ((i != 0) && (ev(i)));
  }
  
  public long ny()
    throws IOException
  {
    return nE();
  }
  
  public int nz()
    throws IOException
  {
    return nD();
  }
  
  public byte[] o(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte;
    if (paramInt2 != 0)
    {
      arrayOfByte = new byte[paramInt2];
      int i = paramInt1 + this.amK;
      System.arraycopy(this.buffer, i, arrayOfByte, 0, paramInt2);
    }
    else
    {
      arrayOfByte = mi.anh;
    }
    return arrayOfByte;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = nD();
    byte[] arrayOfByte;
    if ((i > this.amL - this.amN) || (i <= 0))
    {
      arrayOfByte = eA(i);
    }
    else
    {
      arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.amN, arrayOfByte, 0, i);
      this.amN = (i + this.amN);
    }
    return arrayOfByte;
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(nG());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(nF());
  }
  
  public String readString()
    throws IOException
  {
    int i = nD();
    String str;
    if ((i > this.amL - this.amN) || (i <= 0))
    {
      str = new String(eA(i), "UTF-8");
    }
    else
    {
      str = new String(this.buffer, this.amN, i, "UTF-8");
      this.amN = (i + this.amN);
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lz
 * JD-Core Version:    0.7.0.1
 */
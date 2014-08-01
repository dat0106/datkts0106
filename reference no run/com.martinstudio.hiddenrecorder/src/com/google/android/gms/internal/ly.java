package com.google.android.gms.internal;

public class ly
{
  private final byte[] amH = new byte[256];
  private int amI;
  private int amJ;
  
  public ly(byte[] paramArrayOfByte)
  {
    for (int i = 0;; i++)
    {
      if (i >= 256)
      {
        int k = 0;
        for (int j = 0;; j++)
        {
          if (j >= 256)
          {
            this.amI = 0;
            this.amJ = 0;
            return;
          }
          k = 0xFF & k + this.amH[j] + paramArrayOfByte[(j % paramArrayOfByte.length)];
          i = this.amH[j];
          this.amH[j] = this.amH[k];
          this.amH[k] = i;
        }
      }
      this.amH[i] = ((byte)i);
    }
  }
  
  public void o(byte[] paramArrayOfByte)
  {
    int j = this.amI;
    int i = this.amJ;
    for (int k = 0;; k++)
    {
      if (k >= paramArrayOfByte.length)
      {
        this.amI = j;
        this.amJ = i;
        return;
      }
      j = 0xFF & j + 1;
      i = 0xFF & i + this.amH[j];
      int m = this.amH[j];
      this.amH[j] = this.amH[i];
      this.amH[i] = m;
      paramArrayOfByte[k] = ((byte)(paramArrayOfByte[k] ^ this.amH[(0xFF & this.amH[j] + this.amH[i])]));
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ly
 * JD-Core Version:    0.7.0.1
 */
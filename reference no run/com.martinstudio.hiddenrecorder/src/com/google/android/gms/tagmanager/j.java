package com.google.android.gms.tagmanager;

class j
{
  public static byte[] bE(String paramString)
  {
    int i = paramString.length();
    if (i % 2 == 0)
    {
      byte[] arrayOfByte = new byte[i / 2];
      for (int m = 0;; m += 2)
      {
        if (m >= i) {
          return arrayOfByte;
        }
        int j = Character.digit(paramString.charAt(m), 16);
        int k = Character.digit(paramString.charAt(m + 1), 16);
        if ((j == -1) || (k == -1)) {
          break;
        }
        arrayOfByte[(m / 2)] = ((byte)(k + (j << 4)));
      }
      throw new IllegalArgumentException("purported base16 string has illegal char");
    }
    throw new IllegalArgumentException("purported base16 string has odd number of characters");
  }
  
  public static String d(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localStringBuilder.toString().toUpperCase();
      }
      int k = paramArrayOfByte[j];
      if ((k & 0xF0) == 0) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(k & 0xFF));
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.j
 * JD-Core Version:    0.7.0.1
 */
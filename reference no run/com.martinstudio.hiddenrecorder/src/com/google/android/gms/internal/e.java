package com.google.android.gms.internal;

import android.util.Base64;

class e
  implements n
{
  public String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 2;
    } else {
      i = 11;
    }
    return Base64.encodeToString(paramArrayOfByte, i);
  }
  
  public byte[] a(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    int i;
    if (!paramBoolean) {
      i = 2;
    } else {
      i = 11;
    }
    return Base64.decode(paramString, i);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.e
 * JD-Core Version:    0.7.0.1
 */
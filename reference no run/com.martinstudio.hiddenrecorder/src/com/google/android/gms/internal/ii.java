package com.google.android.gms.internal;

import android.util.Base64;

public final class ii
{
  public static String d(byte[] paramArrayOfByte)
  {
    String str;
    if (paramArrayOfByte != null) {
      str = Base64.encodeToString(paramArrayOfByte, 0);
    } else {
      str = null;
    }
    return str;
  }
  
  public static String e(byte[] paramArrayOfByte)
  {
    String str;
    if (paramArrayOfByte != null) {
      str = Base64.encodeToString(paramArrayOfByte, 10);
    } else {
      str = null;
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ii
 * JD-Core Version:    0.7.0.1
 */
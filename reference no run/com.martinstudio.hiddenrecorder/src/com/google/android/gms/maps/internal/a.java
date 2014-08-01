package com.google.android.gms.maps.internal;

public final class a
{
  public static Boolean a(byte paramByte)
  {
    Boolean localBoolean;
    switch (paramByte)
    {
    default: 
      localBoolean = null;
      break;
    case 0: 
      localBoolean = Boolean.FALSE;
      break;
    case 1: 
      localBoolean = Boolean.TRUE;
    }
    return localBoolean;
  }
  
  public static byte c(Boolean paramBoolean)
  {
    byte b;
    if (paramBoolean == null) {
      b = -1;
    } else if (!paramBoolean.booleanValue()) {
      b = 0;
    } else {
      b = 1;
    }
    return b;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.a
 * JD-Core Version:    0.7.0.1
 */
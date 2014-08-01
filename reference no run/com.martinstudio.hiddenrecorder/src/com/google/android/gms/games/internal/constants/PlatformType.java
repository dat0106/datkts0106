package com.google.android.gms.games.internal.constants;

public final class PlatformType
{
  public static String cm(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown platform type: " + paramInt);
    case 0: 
      str = "ANDROID";
      break;
    case 1: 
      str = "IOS";
      break;
    case 2: 
      str = "WEB_APP";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.PlatformType
 * JD-Core Version:    0.7.0.1
 */
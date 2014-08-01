package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType
{
  public static String cm(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      GamesLog.k("RequestType", "Unknown request type: " + paramInt);
      str = "UNKNOWN_TYPE";
      break;
    case 1: 
      str = "GIFT";
      break;
    case 2: 
      str = "WISH";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.RequestType
 * JD-Core Version:    0.7.0.1
 */
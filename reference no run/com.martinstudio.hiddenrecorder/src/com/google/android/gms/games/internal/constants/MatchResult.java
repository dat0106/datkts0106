package com.google.android.gms.games.internal.constants;

public final class MatchResult
{
  public static boolean isValid(int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.MatchResult
 * JD-Core Version:    0.7.0.1
 */
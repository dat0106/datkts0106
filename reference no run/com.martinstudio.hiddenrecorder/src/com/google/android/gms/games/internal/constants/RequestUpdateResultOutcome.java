package com.google.android.gms.games.internal.constants;

public final class RequestUpdateResultOutcome
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
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome
 * JD-Core Version:    0.7.0.1
 */
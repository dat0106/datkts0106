package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class TurnBasedMatchTurnStatus
{
  public static String cm(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      GamesLog.k("MatchTurnStatus", "Unknown match turn status: " + paramInt);
      str = "TURN_STATUS_UNKNOWN";
      break;
    case 0: 
      str = "TURN_STATUS_INVITED";
      break;
    case 1: 
      str = "TURN_STATUS_MY_TURN";
      break;
    case 2: 
      str = "TURN_STATUS_THEIR_TURN";
      break;
    case 3: 
      str = "TURN_STATUS_COMPLETE";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus
 * JD-Core Version:    0.7.0.1
 */
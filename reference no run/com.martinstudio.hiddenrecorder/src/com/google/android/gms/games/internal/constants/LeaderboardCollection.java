package com.google.android.gms.games.internal.constants;

public final class LeaderboardCollection
{
  public static String cm(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown leaderboard collection: " + paramInt);
    case 0: 
      str = "PUBLIC";
      break;
    case 1: 
      str = "SOCIAL";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.LeaderboardCollection
 * JD-Core Version:    0.7.0.1
 */
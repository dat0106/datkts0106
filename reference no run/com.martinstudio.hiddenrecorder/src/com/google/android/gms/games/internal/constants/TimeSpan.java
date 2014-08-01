package com.google.android.gms.games.internal.constants;

public final class TimeSpan
{
  private TimeSpan()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static String cm(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown time span " + paramInt);
    case 0: 
      str = "DAILY";
      break;
    case 1: 
      str = "WEEKLY";
      break;
    case 2: 
      str = "ALL_TIME";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.constants.TimeSpan
 * JD-Core Version:    0.7.0.1
 */
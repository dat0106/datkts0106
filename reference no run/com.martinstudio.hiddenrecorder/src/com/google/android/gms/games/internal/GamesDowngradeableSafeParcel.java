package com.google.android.gms.games.internal;

import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.in;

public abstract class GamesDowngradeableSafeParcel
  extends hb
{
  protected static boolean c(Integer paramInteger)
  {
    boolean bool;
    if (paramInteger != null) {
      bool = in.aE(paramInteger.intValue());
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesDowngradeableSafeParcel
 * JD-Core Version:    0.7.0.1
 */
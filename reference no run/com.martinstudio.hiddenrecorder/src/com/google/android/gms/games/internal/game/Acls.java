package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Acls
{
  public static abstract interface LoadFAclResult
    extends Releasable, Result
  {}
  
  public static abstract interface OnGameplayAclUpdatedCallback {}
  
  public static abstract interface OnGameplayAclLoadedCallback {}
  
  public static abstract interface OnNotifyAclUpdatedCallback {}
  
  public static abstract interface OnNotifyAclLoadedCallback {}
  
  public static abstract interface LoadAclResult
    extends Releasable, Result
  {}
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.Acls
 * JD-Core Version:    0.7.0.1
 */
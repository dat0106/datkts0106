package com.google.android.gms.appstate;

import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class a
  implements AppState
{
  private final byte[] yA;
  private final boolean yB;
  private final String yC;
  private final byte[] yD;
  private final int yy;
  private final String yz;
  
  public a(AppState paramAppState)
  {
    this.yy = paramAppState.getKey();
    this.yz = paramAppState.getLocalVersion();
    this.yA = paramAppState.getLocalData();
    this.yB = paramAppState.hasConflict();
    this.yC = paramAppState.getConflictVersion();
    this.yD = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(paramAppState.getKey());
    arrayOfObject[1] = paramAppState.getLocalVersion();
    arrayOfObject[2] = paramAppState.getLocalData();
    arrayOfObject[3] = Boolean.valueOf(paramAppState.hasConflict());
    arrayOfObject[4] = paramAppState.getConflictVersion();
    arrayOfObject[5] = paramAppState.getConflictData();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(AppState paramAppState, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof AppState))
    {
      if (paramAppState != paramObject)
      {
        AppState localAppState = (AppState)paramObject;
        if ((!hl.equal(Integer.valueOf(localAppState.getKey()), Integer.valueOf(paramAppState.getKey()))) || (!hl.equal(localAppState.getLocalVersion(), paramAppState.getLocalVersion())) || (!hl.equal(localAppState.getLocalData(), paramAppState.getLocalData())) || (!hl.equal(Boolean.valueOf(localAppState.hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) || (!hl.equal(localAppState.getConflictVersion(), paramAppState.getConflictVersion())) || (!hl.equal(localAppState.getConflictData(), paramAppState.getConflictData()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(AppState paramAppState)
  {
    return hl.e(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public AppState dN()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getConflictData()
  {
    return this.yD;
  }
  
  public String getConflictVersion()
  {
    return this.yC;
  }
  
  public int getKey()
  {
    return this.yy;
  }
  
  public byte[] getLocalData()
  {
    return this.yA;
  }
  
  public String getLocalVersion()
  {
    return this.yz;
  }
  
  public boolean hasConflict()
  {
    return this.yB;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.appstate.a
 * JD-Core Version:    0.7.0.1
 */
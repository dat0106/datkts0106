package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.i.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
  private float aau;
  private boolean aav = true;
  private i aba;
  private TileProvider abb;
  private boolean abc = true;
  private final int xJ;
  
  public TileOverlayOptions()
  {
    this.xJ = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.xJ = paramInt;
    this.aba = i.a.bg(paramIBinder);
    TileProvider local1;
    if (this.aba != null) {
      local1 = new TileProvider()
      {
        private final i abd = TileOverlayOptions.a(TileOverlayOptions.this);
        
        public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          try
          {
            localTile = this.abd.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
            localTile = localTile;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              Tile localTile = null;
            }
          }
          return localTile;
        }
      };
    } else {
      local1 = null;
    }
    this.abb = local1;
    this.aav = paramBoolean1;
    this.aau = paramFloat;
    this.abc = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.abc = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.abc;
  }
  
  public TileProvider getTileProvider()
  {
    return this.abb;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  IBinder jL()
  {
    return this.aba.asBinder();
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.abb = paramTileProvider;
    i.a local2;
    if (this.abb != null) {
      local2 = new i.a()
      {
        public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
      };
    } else {
      local2 = null;
    }
    this.aba = local2;
    return this;
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      TileOverlayOptionsCreator.a(this, paramParcel, paramInt);
    } else {
      j.a(this, paramParcel, paramInt);
    }
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */
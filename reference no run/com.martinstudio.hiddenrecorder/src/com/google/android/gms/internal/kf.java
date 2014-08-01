package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface kf
  extends IInterface
{
  public abstract void a(ke paramke, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements kf
  {
    public static kf bi(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
        if ((localObject == null) || (!(localObject instanceof kf))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (kf)localObject;
        }
      }
      else
      {
        localObject = null;
      }
      return localObject;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool1 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
        ke localke = ke.a.bh(paramParcel1.readStrongBinder());
        Uri localUri;
        if (paramParcel1.readInt() == 0) {
          localUri = null;
        } else {
          localUri = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        a(localke, localUri, localBundle, bool2);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
      }
      return bool1;
    }
    
    private static class a
      implements kf
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(ke paramke, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
        throws RemoteException
      {
        IBinder localIBinder = null;
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
            if (paramke != null) {
              localIBinder = paramke.asBinder();
            }
            localParcel.writeStrongBinder(localIBinder);
            if (paramUri != null)
            {
              localParcel.writeInt(1);
              paramUri.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                break label136;
                localParcel.writeInt(i);
                this.ko.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
          label136:
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kf
 * JD-Core Version:    0.7.0.1
 */
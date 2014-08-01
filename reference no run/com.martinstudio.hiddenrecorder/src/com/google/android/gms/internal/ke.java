package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ke
  extends IInterface
{
  public abstract void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ke
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
    }
    
    public static ke bh(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        if ((localObject == null) || (!(localObject instanceof ke))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ke)localObject;
        }
      }
      else
      {
        localObject = null;
      }
      return localObject;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        int i = paramParcel1.readInt();
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        int j = paramParcel1.readInt();
        Intent localIntent;
        if (paramParcel1.readInt() == 0) {
          localIntent = null;
        } else {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        a(i, localBundle, j, localIntent);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ke
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            localParcel2.writeInt(paramInt1);
            if (paramBundle != null)
            {
              localParcel2.writeInt(1);
              paramBundle.writeToParcel(localParcel2, 0);
              localParcel2.writeInt(paramInt2);
              if (paramIntent != null)
              {
                localParcel2.writeInt(1);
                paramIntent.writeToParcel(localParcel2, 0);
                this.ko.transact(1, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            localParcel2.writeInt(0);
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
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
 * Qualified Name:     com.google.android.gms.internal.ke
 * JD-Core Version:    0.7.0.1
 */
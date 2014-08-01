package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

public abstract interface iz
  extends IInterface
{
  public abstract void a(iy paramiy, UserAddressRequest paramUserAddressRequest, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements iz
  {
    public static iz ap(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
        if ((localObject == null) || (!(localObject instanceof iz))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (iz)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
        iy localiy = iy.a.ao(paramParcel1.readStrongBinder());
        UserAddressRequest localUserAddressRequest;
        if (paramParcel1.readInt() == 0) {
          localUserAddressRequest = null;
        } else {
          localUserAddressRequest = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(localiy, localUserAddressRequest, localBundle);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements iz
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(iy paramiy, UserAddressRequest paramUserAddressRequest, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label132:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
            IBinder localIBinder;
            if (paramiy != null)
            {
              localIBinder = paramiy.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramUserAddressRequest != null)
              {
                localParcel1.writeInt(1);
                paramUserAddressRequest.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
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
 * Qualified Name:     com.google.android.gms.internal.iz
 * JD-Core Version:    0.7.0.1
 */
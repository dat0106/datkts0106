package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface bu
  extends IInterface
{
  public abstract bv m(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements bu
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }
    
    public static bu i(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if ((localObject == null) || (!(localObject instanceof bu))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (bu)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        Object localObject = m(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((bv)localObject).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements bu
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public bv m(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          bv localbv = bv.a.j(localParcel2.readStrongBinder());
          return localbv;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bu
 * JD-Core Version:    0.7.0.1
 */
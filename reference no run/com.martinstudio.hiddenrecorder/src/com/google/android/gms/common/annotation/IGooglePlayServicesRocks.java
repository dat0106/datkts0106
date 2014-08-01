package com.google.android.gms.common.annotation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IGooglePlayServicesRocks
  extends IInterface
{
  public static abstract class Stub
    extends Binder
    implements IGooglePlayServicesRocks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
    }
    
    public static IGooglePlayServicesRocks asInterface(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
        if ((localObject == null) || (!(localObject instanceof IGooglePlayServicesRocks))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IGooglePlayServicesRocks)localObject;
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
      boolean bool;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
        bool = true;
      }
      return bool;
    }
    
    private static class a
      implements IGooglePlayServicesRocks
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.annotation.IGooglePlayServicesRocks
 * JD-Core Version:    0.7.0.1
 */
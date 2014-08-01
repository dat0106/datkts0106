package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface dx
  extends IInterface
{
  public abstract dv b(dt paramdt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements dx
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }
    
    public static dx y(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if ((localObject == null) || (!(localObject instanceof dx))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (dx)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = dt.CREATOR.h(paramParcel1);
        }
        Object localObject = b((dt)localObject);
        paramParcel2.writeNoException();
        if (localObject == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          ((dv)localObject).writeToParcel(paramParcel2, 1);
        }
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements dx
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
      
      public dv b(dt paramdt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramdt != null)
            {
              localParcel2.writeInt(1);
              paramdt.writeToParcel(localParcel2, 0);
              this.ko.transact(1, localParcel2, localParcel1, 0);
              localParcel1.readException();
              if (localParcel1.readInt() != 0)
              {
                dv localdv = dv.CREATOR.i(localParcel1);
                localdv = localdv;
                return localdv;
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            Object localObject2 = null;
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dx
 * JD-Core Version:    0.7.0.1
 */
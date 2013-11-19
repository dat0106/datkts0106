package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public abstract interface IAnalyticsService
  extends IInterface
{
  public abstract void clearHits()
    throws RemoteException;
  
  public abstract void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IAnalyticsService
  {
    private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
    static final int TRANSACTION_clearHits = 2;
    static final int TRANSACTION_sendHit = 1;
    
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }
    
    public static IAnalyticsService asInterface(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if ((localObject == null) || (!(localObject instanceof IAnalyticsService))) {
          localObject = new Proxy(paramIBinder);
        } else {
          localObject = (IAnalyticsService)localObject;
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
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        sendHit(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(Command.CREATOR));
        paramParcel2.writeNoException();
        bool = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        clearHits();
        paramParcel2.writeNoException();
        bool = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
        bool = true;
      }
      return bool;
    }
    
    private static class Proxy
      implements IAnalyticsService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void clearHits()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.google.android.gms.analytics.internal.IAnalyticsService";
      }
      
      public void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          localParcel2.writeMap(paramMap);
          localParcel2.writeLong(paramLong);
          localParcel2.writeString(paramString);
          localParcel2.writeTypedList(paramList);
          this.mRemote.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
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


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.internal.IAnalyticsService
 * JD-Core Version:    0.7.0.1
 */
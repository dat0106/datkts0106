package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public abstract interface ff
  extends IInterface
{
  public abstract void a(Map paramMap, long paramLong, String paramString, List<fe> paramList)
    throws RemoteException;
  
  public abstract void cg()
    throws RemoteException;
  
  public abstract String getVersion()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ff
  {
    public static ff z(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if ((localObject == null) || (!(localObject instanceof ff))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ff)localObject;
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
      boolean bool1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        a(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(fe.CREATOR));
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        cg();
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        String str = getVersion();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ff
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(Map paramMap, long paramLong, String paramString, List<fe> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          localParcel1.writeMap(paramMap);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          localParcel1.writeTypedList(paramList);
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void cg()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          this.ko.transact(2, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String getVersion()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          this.ko.transact(3, localParcel2, localParcel1, 0);
          localParcel1.readException();
          String str = localParcel1.readString();
          return str;
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


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ff
 * JD-Core Version:    0.7.0.1
 */
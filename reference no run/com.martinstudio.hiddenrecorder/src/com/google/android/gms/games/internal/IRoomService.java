package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface IRoomService
  extends IInterface
{
  public abstract void G(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IBinder paramIBinder, IRoomServiceCallbacks paramIRoomServiceCallbacks)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(byte[] paramArrayOfByte, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void a(byte[] paramArrayOfByte, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void be(String paramString)
    throws RemoteException;
  
  public abstract void bf(String paramString)
    throws RemoteException;
  
  public abstract void c(String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void hA()
    throws RemoteException;
  
  public abstract void hB()
    throws RemoteException;
  
  public abstract void hC()
    throws RemoteException;
  
  public abstract void hD()
    throws RemoteException;
  
  public abstract void r(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void s(String paramString, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IRoomService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2 = false;
      boolean bool1 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.readStrongBinder(), IRoomServiceCallbacks.Stub.am(paramParcel1.readStrongBinder()));
        break;
      case 1002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        hA();
        break;
      case 1003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        hB();
        break;
      case 1004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        break;
      case 1005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        hC();
        break;
      case 1006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        DataHolder localDataHolder;
        if (paramParcel1.readInt() == 0) {
          localDataHolder = null;
        } else {
          localDataHolder = DataHolder.CREATOR.x(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          bool2 = bool1;
        }
        a(localDataHolder, bool2);
        break;
      case 1007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        hD();
        break;
      case 1008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        if (paramParcel1.readInt() != 0) {
          bool2 = bool1;
        }
        G(bool2);
        break;
      case 1009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readInt());
        break;
      case 1010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        a(paramParcel1.createByteArray(), paramParcel1.createStringArray());
        break;
      case 1011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        r(paramParcel1.readString(), paramParcel1.readInt());
        break;
      case 1012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        s(paramParcel1.readString(), paramParcel1.readInt());
        break;
      case 1013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        be(paramParcel1.readString());
        break;
      case 1014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
        bf(paramParcel1.readString());
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IRoomService");
      }
      return bool1;
    }
    
    private static class Proxy
      implements IRoomService
    {
      private IBinder ko;
      
      /* Error */
      public void G(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_2
        //   6: aload_2
        //   7: ldc 23
        //   9: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: iload_1
        //   13: ifeq +29 -> 42
        //   16: aload_2
        //   17: iload_3
        //   18: invokevirtual 31	android/os/Parcel:writeInt	(I)V
        //   21: aload_0
        //   22: getfield 33	com/google/android/gms/games/internal/IRoomService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   25: sipush 1008
        //   28: aload_2
        //   29: aconst_null
        //   30: iconst_1
        //   31: invokeinterface 39 5 0
        //   36: pop
        //   37: aload_2
        //   38: invokevirtual 43	android/os/Parcel:recycle	()V
        //   41: return
        //   42: iconst_0
        //   43: istore_3
        //   44: goto -28 -> 16
        //   47: astore_3
        //   48: aload_2
        //   49: invokevirtual 43	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	54	0	this	Proxy
        //   0	54	1	paramBoolean	boolean
        //   5	44	2	localParcel	Parcel
        //   1	43	3	i	int
        //   47	6	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	37	47	finally
      }
      
      public void a(IBinder paramIBinder, IRoomServiceCallbacks paramIRoomServiceCallbacks)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeStrongBinder(paramIBinder);
          if (paramIRoomServiceCallbacks != null) {
            localIBinder = paramIRoomServiceCallbacks.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.ko.transact(1001, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(DataHolder paramDataHolder, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            if (paramDataHolder != null)
            {
              localParcel.writeInt(1);
              paramDataHolder.writeToParcel(localParcel, 0);
              break label81;
              localParcel.writeInt(i);
              this.ko.transact(1006, localParcel, null, 1);
            }
            else
            {
              localParcel.writeInt(0);
            }
          }
          finally
          {
            localParcel.recycle();
          }
          label81:
          while (!paramBoolean)
          {
            int j = 0;
            break;
          }
        }
      }
      
      public void a(byte[] paramArrayOfByte, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.ko.transact(1009, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(byte[] paramArrayOfByte, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1010, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void be(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          this.ko.transact(1013, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bf(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          this.ko.transact(1014, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          this.ko.transact(1004, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hA()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.ko.transact(1002, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hB()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.ko.transact(1003, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hC()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.ko.transact(1005, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hD()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          this.ko.transact(1007, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void r(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.ko.transact(1011, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void s(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.ko.transact(1012, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IRoomService
 * JD-Core Version:    0.7.0.1
 */
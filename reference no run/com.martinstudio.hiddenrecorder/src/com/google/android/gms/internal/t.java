package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface t
  extends IInterface
{
  public abstract boolean a(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract String c(String paramString)
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements t
  {
    public static t b(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if ((localObject == null) || (!(localObject instanceof t))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (t)localObject;
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
      int i = 0;
      String str1 = 1;
      String str2;
      switch (paramInt1)
      {
      default: 
        str1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        str2 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (paramParcel1.readInt() == 0) {
          bool = false;
        } else {
          bool = str1;
        }
        boolean bool = a(bool);
        paramParcel2.writeNoException();
        if (bool) {
          str2 = str1;
        }
        paramParcel2.writeInt(str2);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        str2 = c(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        String str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          str2 = str1;
        }
        b(str3, str2);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      }
      return str1;
    }
    
    private static class a
      implements t
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public boolean a(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +53 -> 71
        //   21: iload 4
        //   23: istore 5
        //   25: aload_3
        //   26: iload 5
        //   28: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   31: aload_0
        //   32: getfield 18	com/google/android/gms/internal/t$a$a:ko	Landroid/os/IBinder;
        //   35: iconst_2
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 43 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 46	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 50	android/os/Parcel:readInt	()I
        //   53: istore 5
        //   55: iload 5
        //   57: ifeq +20 -> 77
        //   60: aload_2
        //   61: invokevirtual 53	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 53	android/os/Parcel:recycle	()V
        //   68: iload 4
        //   70: ireturn
        //   71: iconst_0
        //   72: istore 5
        //   74: goto -49 -> 25
        //   77: iconst_0
        //   78: istore 4
        //   80: goto -20 -> 60
        //   83: astore 4
        //   85: aload_2
        //   86: invokevirtual 53	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 53	android/os/Parcel:recycle	()V
        //   93: aload 4
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramBoolean	boolean
        //   10	76	2	localParcel1	Parcel
        //   6	84	3	localParcel2	Parcel
        //   1	78	4	i	int
        //   83	11	4	localObject	Object
        //   23	4	5	j	int
        //   53	20	5	k	int
        // Exception table:
        //   from	to	target	type
        //   11	55	83	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          localParcel2.writeString(paramString);
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(4, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String c(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          localParcel2.writeString(paramString);
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
      
      public String getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
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
 * Qualified Name:     com.google.android.gms.internal.t
 * JD-Core Version:    0.7.0.1
 */
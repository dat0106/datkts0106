package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface dg
  extends IInterface
{
  public abstract void finishPurchase()
    throws RemoteException;
  
  public abstract String getProductId()
    throws RemoteException;
  
  public abstract Intent getPurchaseData()
    throws RemoteException;
  
  public abstract int getResultCode()
    throws RemoteException;
  
  public abstract boolean isVerified()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements dg
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
    }
    
    public static dg t(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        if ((localObject == null) || (!(localObject instanceof dg))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (dg)localObject;
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
      int k = 0;
      int i = 1;
      Object localObject;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        localObject = getProductId();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        localObject = getPurchaseData();
        paramParcel2.writeNoException();
        if (localObject == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          ((Intent)localObject).writeToParcel(paramParcel2, i);
        }
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        int j = getResultCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        boolean bool = isVerified();
        paramParcel2.writeNoException();
        if (bool) {
          k = i;
        }
        paramParcel2.writeInt(k);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        finishPurchase();
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      }
      return i;
    }
    
    private static class a
      implements dg
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
      
      public void finishPurchase()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.ko.transact(5, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String getProductId()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.ko.transact(1, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public Intent getPurchaseData()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/internal/dg$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_2
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokeinterface 41 5 0
        //   27: pop
        //   28: aload_2
        //   29: invokevirtual 44	android/os/Parcel:readException	()V
        //   32: aload_2
        //   33: invokevirtual 58	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 64	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_2
        //   43: invokeinterface 70 2 0
        //   48: checkcast 60	android/content/Intent
        //   51: astore_3
        //   52: aload_2
        //   53: invokevirtual 47	android/os/Parcel:recycle	()V
        //   56: aload_1
        //   57: invokevirtual 47	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: areturn
        //   62: aconst_null
        //   63: astore_3
        //   64: goto -12 -> 52
        //   67: astore_3
        //   68: aload_2
        //   69: invokevirtual 47	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: invokevirtual 47	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   3	70	1	localParcel1	Parcel
        //   7	62	2	localParcel2	Parcel
        //   51	13	3	localIntent	Intent
        //   67	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public int getResultCode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.ko.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isVerified()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
          this.ko.transact(4, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
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
 * Qualified Name:     com.google.android.gms.internal.dg
 * JD-Core Version:    0.7.0.1
 */
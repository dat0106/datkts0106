package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface de
  extends IInterface
{
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    throws RemoteException;
  
  public abstract void onCreate()
    throws RemoteException;
  
  public abstract void onDestroy()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements de
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
    }
    
    public static de r(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if ((localObject == null) || (!(localObject instanceof de))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (de)localObject;
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
      int i;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        onCreate();
        paramParcel2.writeNoException();
        bool = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        onDestroy();
        paramParcel2.writeNoException();
        bool = true;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        int j = paramParcel1.readInt();
        i = paramParcel1.readInt();
        Intent localIntent;
        if (paramParcel1.readInt() == 0) {
          localIntent = null;
        } else {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        onActivityResult(j, i, localIntent);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        i = 1;
      }
      return i;
    }
    
    private static class a
      implements de
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
      
      /* Error */
      public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 6
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: iload_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload 6
        //   25: iload_2
        //   26: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +48 -> 78
        //   33: aload 6
        //   35: iconst_1
        //   36: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 6
        //   42: iconst_0
        //   43: invokevirtual 46	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/de$a$a:ko	Landroid/os/IBinder;
        //   50: iconst_3
        //   51: aload 6
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 52 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 55	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: aload 6
        //   74: invokevirtual 58	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aload 6
        //   80: iconst_0
        //   81: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   84: goto -38 -> 46
        //   87: astore 5
        //   89: aload 4
        //   91: invokevirtual 58	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: invokevirtual 58	android/os/Parcel:recycle	()V
        //   99: aload 5
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramInt1	int
        //   0	102	2	paramInt2	int
        //   0	102	3	paramIntent	Intent
        //   8	82	4	localParcel1	Parcel
        //   87	13	5	localObject	Object
        //   3	92	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	67	87	finally
        //   78	84	87	finally
      }
      
      public void onCreate()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.de
 * JD-Core Version:    0.7.0.1
 */
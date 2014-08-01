package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface dh
  extends IInterface
{
  public abstract void a(dg paramdg)
    throws RemoteException;
  
  public abstract boolean isValidPurchase(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements dh
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
    }
    
    public static dh u(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if ((localObject == null) || (!(localObject instanceof dh))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (dh)localObject;
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
      int i = 1;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        int j = isValidPurchase(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        a(dg.a.t(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
      }
      return i;
    }
    
    private static class a
      implements dh
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(dg paramdg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/dh$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 48 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 51	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 54	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 54	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramdg	dg
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public boolean isValidPurchase(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_2
        //   18: aload_1
        //   19: invokevirtual 59	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   22: aload_0
        //   23: getfield 18	com/google/android/gms/internal/dh$a$a:ko	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_2
        //   28: aload_3
        //   29: iconst_0
        //   30: invokeinterface 48 5 0
        //   35: pop
        //   36: aload_3
        //   37: invokevirtual 51	android/os/Parcel:readException	()V
        //   40: aload_3
        //   41: invokevirtual 63	android/os/Parcel:readInt	()I
        //   44: istore 5
        //   46: iload 5
        //   48: ifeq +14 -> 62
        //   51: aload_3
        //   52: invokevirtual 54	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 54	android/os/Parcel:recycle	()V
        //   59: iload 4
        //   61: ireturn
        //   62: iconst_0
        //   63: istore 4
        //   65: goto -14 -> 51
        //   68: astore 4
        //   70: aload_3
        //   71: invokevirtual 54	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 54	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramString	String
        //   6	69	2	localParcel1	Parcel
        //   10	61	3	localParcel2	Parcel
        //   1	63	4	bool	boolean
        //   68	11	4	localObject	Object
        //   44	3	5	i	int
        // Exception table:
        //   from	to	target	type
        //   11	46	68	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dh
 * JD-Core Version:    0.7.0.1
 */
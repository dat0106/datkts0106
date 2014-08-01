package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface hi
  extends IInterface
{
  public abstract void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements hi
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    public static hi K(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if ((localObject == null) || (!(localObject instanceof hi))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (hi)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        int i = paramParcel1.readInt();
        IBinder localIBinder = paramParcel1.readStrongBinder();
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        b(i, localIBinder, localBundle);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements hi
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
      public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: iload_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload 6
        //   25: aload_2
        //   26: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   29: aload_3
        //   30: ifnull +48 -> 78
        //   33: aload 6
        //   35: iconst_1
        //   36: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 6
        //   42: iconst_0
        //   43: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/hi$a$a:ko	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 6
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 55 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 58	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 61	android/os/Parcel:recycle	()V
        //   72: aload 6
        //   74: invokevirtual 61	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aload 6
        //   80: iconst_0
        //   81: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   84: goto -38 -> 46
        //   87: astore 4
        //   89: aload 5
        //   91: invokevirtual 61	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: invokevirtual 61	android/os/Parcel:recycle	()V
        //   99: aload 4
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramInt	int
        //   0	102	2	paramIBinder	IBinder
        //   0	102	3	paramBundle	Bundle
        //   87	13	4	localObject	Object
        //   8	82	5	localParcel1	Parcel
        //   3	92	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	67	87	finally
        //   78	84	87	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hi
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface h
  extends IInterface
{
  public abstract void c(boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements h
  {
    public static h X(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
        if ((localObject == null) || (!(localObject instanceof h))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (h)localObject;
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
      boolean bool1 = false;
      boolean bool3 = true;
      switch (paramInt1)
      {
      default: 
        bool3 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool3;
        }
        if (paramParcel1.readInt() != 0) {
          bool1 = bool3;
        }
        c(bool2, bool1);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
      }
      return bool3;
    }
    
    private static class a
      implements h
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
      public void c(boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore_3
        //   12: aload 4
        //   14: ldc 32
        //   16: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: iload_1
        //   20: ifeq +54 -> 74
        //   23: iload 5
        //   25: istore 6
        //   27: aload 4
        //   29: iload 6
        //   31: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   34: iload_2
        //   35: ifeq +45 -> 80
        //   38: aload 4
        //   40: iload 5
        //   42: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   45: aload_0
        //   46: getfield 18	com/google/android/gms/drive/realtime/internal/h$a$a:ko	Landroid/os/IBinder;
        //   49: iconst_1
        //   50: aload 4
        //   52: aload_3
        //   53: iconst_0
        //   54: invokeinterface 46 5 0
        //   59: pop
        //   60: aload_3
        //   61: invokevirtual 49	android/os/Parcel:readException	()V
        //   64: aload_3
        //   65: invokevirtual 52	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: invokevirtual 52	android/os/Parcel:recycle	()V
        //   73: return
        //   74: iconst_0
        //   75: istore 6
        //   77: goto -50 -> 27
        //   80: iconst_0
        //   81: istore 5
        //   83: goto -45 -> 38
        //   86: astore 5
        //   88: aload_3
        //   89: invokevirtual 52	android/os/Parcel:recycle	()V
        //   92: aload 4
        //   94: invokevirtual 52	android/os/Parcel:recycle	()V
        //   97: aload 5
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramBoolean1	boolean
        //   0	100	2	paramBoolean2	boolean
        //   11	78	3	localParcel1	Parcel
        //   6	87	4	localParcel2	Parcel
        //   1	81	5	i	int
        //   86	12	5	localObject	Object
        //   25	51	6	j	int
        // Exception table:
        //   from	to	target	type
        //   12	64	86	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.h
 * JD-Core Version:    0.7.0.1
 */
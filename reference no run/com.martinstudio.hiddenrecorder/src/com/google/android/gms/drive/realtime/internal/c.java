package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface c
  extends IInterface
{
  public abstract void D(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c S(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
        if ((localObject == null) || (!(localObject instanceof c))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (c)localObject;
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
      boolean bool1 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        D(bool2);
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
        Status localStatus;
        if (paramParcel1.readInt() == 0) {
          localStatus = null;
        } else {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        o(localStatus);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
      }
      return bool1;
    }
    
    private static class a
      implements c
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void D(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_3
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +36 -> 54
        //   21: aload_3
        //   22: iload 4
        //   24: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   27: aload_0
        //   28: getfield 18	com/google/android/gms/drive/realtime/internal/c$a$a:ko	Landroid/os/IBinder;
        //   31: iconst_1
        //   32: aload_3
        //   33: aload_2
        //   34: iconst_0
        //   35: invokeinterface 44 5 0
        //   40: pop
        //   41: aload_2
        //   42: invokevirtual 47	android/os/Parcel:readException	()V
        //   45: aload_2
        //   46: invokevirtual 50	android/os/Parcel:recycle	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: return
        //   54: iconst_0
        //   55: istore 4
        //   57: goto -36 -> 21
        //   60: astore 4
        //   62: aload_2
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramBoolean	boolean
        //   10	53	2	localParcel1	Parcel
        //   6	61	3	localParcel2	Parcel
        //   1	55	4	i	int
        //   60	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	45	60	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void o(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +44 -> 60
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 60	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/realtime/internal/c$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 47	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 50	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 50	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_3
        //   61: iconst_0
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_2
        //   69: aload 4
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramStatus	Status
        //   68	11	2	localObject	Object
        //   3	72	3	localParcel1	Parcel
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.c
 * JD-Core Version:    0.7.0.1
 */
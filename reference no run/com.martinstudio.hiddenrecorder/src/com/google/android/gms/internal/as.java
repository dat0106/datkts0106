package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface as
  extends IInterface
{
  public abstract IBinder a(d paramd, am paramam, String paramString, bu parambu, int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements as
  {
    public static as g(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if ((localObject == null) || (!(localObject instanceof as))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (as)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        d locald = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = am.CREATOR.c(paramParcel1);
        }
        Object localObject = a(locald, (am)localObject, paramParcel1.readString(), bu.a.i(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder((IBinder)localObject);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements as
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public IBinder a(d paramd, am paramam, String paramString, bu parambu, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 9
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +110 -> 131
        //   24: aload_1
        //   25: invokeinterface 39 1 0
        //   30: astore 8
        //   32: aload 6
        //   34: aload 8
        //   36: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +97 -> 137
        //   43: aload 6
        //   45: iconst_1
        //   46: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   49: aload_2
        //   50: aload 6
        //   52: iconst_0
        //   53: invokevirtual 52	com/google/android/gms/internal/am:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload 6
        //   58: aload_3
        //   59: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload 4
        //   64: ifnull +12 -> 76
        //   67: aload 4
        //   69: invokeinterface 58 1 0
        //   74: astore 9
        //   76: aload 6
        //   78: aload 9
        //   80: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   83: aload 6
        //   85: iload 5
        //   87: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   90: aload_0
        //   91: getfield 18	com/google/android/gms/internal/as$a$a:ko	Landroid/os/IBinder;
        //   94: iconst_1
        //   95: aload 6
        //   97: aload 7
        //   99: iconst_0
        //   100: invokeinterface 64 5 0
        //   105: pop
        //   106: aload 7
        //   108: invokevirtual 67	android/os/Parcel:readException	()V
        //   111: aload 7
        //   113: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   116: astore 8
        //   118: aload 7
        //   120: invokevirtual 73	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: invokevirtual 73	android/os/Parcel:recycle	()V
        //   128: aload 8
        //   130: areturn
        //   131: aconst_null
        //   132: astore 8
        //   134: goto -102 -> 32
        //   137: aload 6
        //   139: iconst_0
        //   140: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   143: goto -87 -> 56
        //   146: astore 8
        //   148: aload 7
        //   150: invokevirtual 73	android/os/Parcel:recycle	()V
        //   153: aload 6
        //   155: invokevirtual 73	android/os/Parcel:recycle	()V
        //   158: aload 8
        //   160: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	161	0	this	a
        //   0	161	1	paramd	d
        //   0	161	2	paramam	am
        //   0	161	3	paramString	String
        //   0	161	4	parambu	bu
        //   0	161	5	paramInt	int
        //   6	148	6	localParcel1	Parcel
        //   11	138	7	localParcel2	Parcel
        //   30	103	8	localIBinder1	IBinder
        //   146	13	8	localObject	Object
        //   1	78	9	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	118	146	finally
        //   137	143	146	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.as
 * JD-Core Version:    0.7.0.1
 */
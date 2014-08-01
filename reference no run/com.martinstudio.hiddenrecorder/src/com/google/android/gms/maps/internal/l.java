package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.f;
import com.google.android.gms.maps.model.internal.f.a;

public abstract interface l
  extends IInterface
{
  public abstract boolean a(f paramf)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements l
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }
    
    public static l aK(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
        if ((localObject == null) || (!(localObject instanceof l))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (l)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
        int j = a(f.a.bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }
      return i;
    }
    
    private static class a
      implements l
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public boolean a(f paramf)
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
        //   17: aload_1
        //   18: ifnull +57 -> 75
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 5
        //   29: aload_2
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/internal/l$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_1
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 48 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 51	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 55	android/os/Parcel:readInt	()I
        //   57: istore 5
        //   59: iload 5
        //   61: ifeq +20 -> 81
        //   64: aload_3
        //   65: invokevirtual 58	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 58	android/os/Parcel:recycle	()V
        //   72: iload 4
        //   74: ireturn
        //   75: aconst_null
        //   76: astore 5
        //   78: goto -49 -> 29
        //   81: iconst_0
        //   82: istore 4
        //   84: goto -20 -> 64
        //   87: astore 4
        //   89: aload_3
        //   90: invokevirtual 58	android/os/Parcel:recycle	()V
        //   93: aload_2
        //   94: invokevirtual 58	android/os/Parcel:recycle	()V
        //   97: aload 4
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramf	f
        //   6	88	2	localParcel1	Parcel
        //   10	80	3	localParcel2	Parcel
        //   1	82	4	bool	boolean
        //   87	11	4	localObject1	Object
        //   27	4	5	localIBinder	IBinder
        //   57	3	5	i	int
        //   76	1	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   11	59	87	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.l
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface e
  extends IInterface
{
  public abstract boolean a(e parame)
    throws RemoteException;
  
  public abstract void activate()
    throws RemoteException;
  
  public abstract String getName()
    throws RemoteException;
  
  public abstract String getShortName()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements e
  {
    public static e bb(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        if ((localObject == null) || (!(localObject instanceof e))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (e)localObject;
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
      int i = 1;
      String str;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        str = getName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        str = getShortName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        activate();
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        int j = a(bb(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        int k = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
      }
      return i;
    }
    
    private static class a
      implements e
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public boolean a(e parame)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +60 -> 78
        //   21: aload_1
        //   22: invokeinterface 37 1 0
        //   27: astore 5
        //   29: aload_2
        //   30: aload 5
        //   32: invokevirtual 40	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/e$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_4
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 46 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 49	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 53	android/os/Parcel:readInt	()I
        //   57: istore 5
        //   59: iload 5
        //   61: ifeq +6 -> 67
        //   64: iconst_1
        //   65: istore 4
        //   67: aload_3
        //   68: invokevirtual 56	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: iload 4
        //   77: ireturn
        //   78: aconst_null
        //   79: astore 5
        //   81: goto -52 -> 29
        //   84: astore 4
        //   86: aload_3
        //   87: invokevirtual 56	android/os/Parcel:recycle	()V
        //   90: aload_2
        //   91: invokevirtual 56	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	parame	e
        //   6	85	2	localParcel1	Parcel
        //   10	77	3	localParcel2	Parcel
        //   1	75	4	bool	boolean
        //   84	11	4	localObject1	Object
        //   27	4	5	localIBinder	IBinder
        //   57	3	5	i	int
        //   79	1	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   11	59	84	finally
      }
      
      public void activate()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
          this.ko.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public String getName()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
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
      
      public String getShortName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
          this.ko.transact(2, localParcel1, localParcel2, 0);
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
      
      public int hashCodeRemote()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
          this.ko.transact(5, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.e
 * JD-Core Version:    0.7.0.1
 */
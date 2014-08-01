package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract boolean b(d paramd)
    throws RemoteException;
  
  public abstract int getActiveLevelIndex()
    throws RemoteException;
  
  public abstract int getDefaultLevelIndex()
    throws RemoteException;
  
  public abstract List<IBinder> getLevels()
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract boolean isUnderground()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements d
  {
    public static d ba(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        if ((localObject == null) || (!(localObject instanceof d))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (d)localObject;
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
      List localList1 = 1;
      List localList2;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        localList1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        i = getActiveLevelIndex();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        i = getDefaultLevelIndex();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        localList2 = getLevels();
        paramParcel2.writeNoException();
        paramParcel2.writeBinderList(localList2);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        bool = isUnderground();
        paramParcel2.writeNoException();
        if (bool) {
          localList2 = localList1;
        }
        paramParcel2.writeInt(localList2);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        bool = b(ba(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {
          localList2 = localList1;
        }
        paramParcel2.writeInt(localList2);
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        int j = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
      }
      return localList1;
    }
    
    private static class a
      implements d
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
      public boolean b(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +60 -> 78
        //   21: aload_1
        //   22: invokeinterface 38 1 0
        //   27: astore 5
        //   29: aload_2
        //   30: aload 5
        //   32: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/d$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_5
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 47 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 54	android/os/Parcel:readInt	()I
        //   57: istore 5
        //   59: iload 5
        //   61: ifeq +6 -> 67
        //   64: iconst_1
        //   65: istore 4
        //   67: aload_3
        //   68: invokevirtual 57	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 57	android/os/Parcel:recycle	()V
        //   75: iload 4
        //   77: ireturn
        //   78: aconst_null
        //   79: astore 5
        //   81: goto -52 -> 29
        //   84: astore 4
        //   86: aload_3
        //   87: invokevirtual 57	android/os/Parcel:recycle	()V
        //   90: aload_2
        //   91: invokevirtual 57	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramd	d
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
      
      public int getActiveLevelIndex()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
          this.ko.transact(1, localParcel1, localParcel2, 0);
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
      
      public int getDefaultLevelIndex()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
          this.ko.transact(2, localParcel1, localParcel2, 0);
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
      
      public List<IBinder> getLevels()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
          this.ko.transact(3, localParcel2, localParcel1, 0);
          localParcel1.readException();
          ArrayList localArrayList = localParcel1.createBinderArrayList();
          return localArrayList;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public int hashCodeRemote()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
          this.ko.transact(6, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          return i;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public boolean isUnderground()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
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
 * Qualified Name:     com.google.android.gms.maps.model.internal.d
 * JD-Core Version:    0.7.0.1
 */
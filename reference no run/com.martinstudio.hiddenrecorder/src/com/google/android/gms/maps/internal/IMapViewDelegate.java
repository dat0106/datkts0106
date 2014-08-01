package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface IMapViewDelegate
  extends IInterface
{
  public abstract IGoogleMapDelegate getMap()
    throws RemoteException;
  
  public abstract d getView()
    throws RemoteException;
  
  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onDestroy()
    throws RemoteException;
  
  public abstract void onLowMemory()
    throws RemoteException;
  
  public abstract void onPause()
    throws RemoteException;
  
  public abstract void onResume()
    throws RemoteException;
  
  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IMapViewDelegate
  {
    public static IMapViewDelegate aC(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        if ((localObject == null) || (!(localObject instanceof IMapViewDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IMapViewDelegate)localObject;
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
      Object localObject1 = null;
      Object localObject2;
      int j;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        localObject2 = getMap();
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (localObject2 != null) {
          localIBinder1 = ((IGoogleMapDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        Bundle localBundle1;
        if (paramParcel1.readInt() != 0) {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onCreate(localBundle1);
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        onResume();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        onPause();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        Bundle localBundle2;
        if (paramParcel1.readInt() != 0) {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onSaveInstanceState(localBundle2);
        paramParcel2.writeNoException();
        if (localBundle2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          localBundle2.writeToParcel(paramParcel2, 1);
        }
        int k = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        localObject2 = getView();
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (localObject2 != null) {
          localIBinder2 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements IMapViewDelegate
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
      
      public IGoogleMapDelegate getMap()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          IGoogleMapDelegate localIGoogleMapDelegate = IGoogleMapDelegate.a.ay(localParcel1.readStrongBinder());
          return localIGoogleMapDelegate;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public d getView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 77	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IMapViewDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 42 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 45	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 57	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 57	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_3
        //   67: invokevirtual 57	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 57	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramBundle	Bundle
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
      
      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
          this.ko.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
          this.ko.transact(6, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onPause()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
          this.ko.transact(4, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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
      
      /* Error */
      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +54 -> 69
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 77	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IMapViewDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 7
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 42 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 45	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 86	android/os/Parcel:readInt	()I
        //   52: ifeq +8 -> 60
        //   55: aload_1
        //   56: aload_3
        //   57: invokevirtual 90	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   60: aload_3
        //   61: invokevirtual 57	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 57	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload_2
        //   70: iconst_0
        //   71: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   74: goto -45 -> 29
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 57	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 57	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramBundle	Bundle
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
        //   69	74	77	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IMapViewDelegate
 * JD-Core Version:    0.7.0.1
 */
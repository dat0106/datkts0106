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

public abstract interface IStreetViewPanoramaViewDelegate
  extends IInterface
{
  public abstract IStreetViewPanoramaDelegate getStreetViewPanorama()
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
    implements IStreetViewPanoramaViewDelegate
  {
    public static IStreetViewPanoramaViewDelegate aV(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        if ((localObject == null) || (!(localObject instanceof IStreetViewPanoramaViewDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IStreetViewPanoramaViewDelegate)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        localObject2 = getStreetViewPanorama();
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (localObject2 != null) {
          localIBinder1 = ((IStreetViewPanoramaDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        Bundle localBundle1;
        if (paramParcel1.readInt() != 0) {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onCreate(localBundle1);
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        onResume();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        onPause();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
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
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
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
        paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements IStreetViewPanoramaViewDelegate
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
      
      public IStreetViewPanoramaDelegate getStreetViewPanorama()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = IStreetViewPanoramaDelegate.a.aT(localParcel1.readStrongBinder());
          return localIStreetViewPanoramaDelegate;
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
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
          this.ko.transact(8, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
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
        //   30: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaViewDelegate$a$a:ko	Landroid/os/IBinder;
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
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
          this.ko.transact(5, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
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
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
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
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +59 -> 75
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 77	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaViewDelegate$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 7
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 42 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 45	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 86	android/os/Parcel:readInt	()I
        //   56: ifeq +9 -> 65
        //   59: aload_1
        //   60: aload 4
        //   62: invokevirtual 90	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   65: aload 4
        //   67: invokevirtual 57	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 57	android/os/Parcel:recycle	()V
        //   74: return
        //   75: aload_3
        //   76: iconst_0
        //   77: invokevirtual 71	android/os/Parcel:writeInt	(I)V
        //   80: goto -50 -> 30
        //   83: astore_2
        //   84: aload 4
        //   86: invokevirtual 57	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 57	android/os/Parcel:recycle	()V
        //   93: aload_2
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramBundle	Bundle
        //   83	11	2	localObject	Object
        //   3	87	3	localParcel1	Parcel
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	65	83	finally
        //   75	80	83	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
 * JD-Core Version:    0.7.0.1
 */
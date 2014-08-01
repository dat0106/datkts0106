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
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptionsCreator;

public abstract interface IStreetViewPanoramaFragmentDelegate
  extends IInterface
{
  public abstract IStreetViewPanoramaDelegate getStreetViewPanorama()
    throws RemoteException;
  
  public abstract boolean isReady()
    throws RemoteException;
  
  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;
  
  public abstract d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onDestroy()
    throws RemoteException;
  
  public abstract void onDestroyView()
    throws RemoteException;
  
  public abstract void onInflate(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle)
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
    implements IStreetViewPanoramaFragmentDelegate
  {
    public static IStreetViewPanoramaFragmentDelegate aU(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if ((localObject == null) || (!(localObject instanceof IStreetViewPanoramaFragmentDelegate))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (IStreetViewPanoramaFragmentDelegate)localObject;
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
      int i = 1;
      Object localObject3;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        localObject1 = getStreetViewPanorama();
        paramParcel2.writeNoException();
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((IStreetViewPanoramaDelegate)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject1);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        localObject3 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = StreetViewPanoramaOptions.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onInflate((d)localObject3, (StreetViewPanoramaOptions)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onCreate((Bundle)localObject1);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        localObject2 = d.a.ag(paramParcel1.readStrongBinder());
        d locald = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = onCreateView((d)localObject2, locald, (Bundle)localObject3);
        paramParcel2.writeNoException();
        if (localObject2 != null) {
          localObject1 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject1);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onResume();
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onPause();
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onDestroyView();
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onSaveInstanceState((Bundle)localObject1);
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          ((Bundle)localObject1).writeToParcel(paramParcel2, i);
        }
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        int j = isReady();
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      }
      return i;
    }
    
    private static class a
      implements IStreetViewPanoramaFragmentDelegate
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
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IStreetViewPanoramaDelegate localIStreetViewPanoramaDelegate = IStreetViewPanoramaDelegate.a.aT(localParcel2.readStrongBinder());
          return localIStreetViewPanoramaDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isReady()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(11, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 75	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_3
        //   34: aload_3
        //   35: aload_2
        //   36: iconst_0
        //   37: invokeinterface 42 5 0
        //   42: pop
        //   43: aload_2
        //   44: invokevirtual 45	android/os/Parcel:readException	()V
        //   47: aload_2
        //   48: invokevirtual 57	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 57	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_3
        //   57: iconst_0
        //   58: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_2
        //   67: invokevirtual 57	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 57	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramBundle	Bundle
        //   7	60	2	localParcel1	Parcel
        //   3	68	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 5
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +98 -> 119
        //   24: aload_1
        //   25: invokeinterface 81 1 0
        //   30: astore 6
        //   32: aload 5
        //   34: aload 6
        //   36: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +11 -> 51
        //   43: aload_2
        //   44: invokeinterface 81 1 0
        //   49: astore 7
        //   51: aload 5
        //   53: aload 7
        //   55: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   58: aload_3
        //   59: ifnull +66 -> 125
        //   62: aload 5
        //   64: iconst_1
        //   65: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   68: aload_3
        //   69: aload 5
        //   71: iconst_0
        //   72: invokevirtual 75	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   75: aload_0
        //   76: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate$a$a:ko	Landroid/os/IBinder;
        //   79: iconst_4
        //   80: aload 5
        //   82: aload 4
        //   84: iconst_0
        //   85: invokeinterface 42 5 0
        //   90: pop
        //   91: aload 4
        //   93: invokevirtual 45	android/os/Parcel:readException	()V
        //   96: aload 4
        //   98: invokevirtual 48	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   101: invokestatic 90	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   104: astore 6
        //   106: aload 4
        //   108: invokevirtual 57	android/os/Parcel:recycle	()V
        //   111: aload 5
        //   113: invokevirtual 57	android/os/Parcel:recycle	()V
        //   116: aload 6
        //   118: areturn
        //   119: aconst_null
        //   120: astore 6
        //   122: goto -90 -> 32
        //   125: aload 5
        //   127: iconst_0
        //   128: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   131: goto -56 -> 75
        //   134: astore 6
        //   136: aload 4
        //   138: invokevirtual 57	android/os/Parcel:recycle	()V
        //   141: aload 5
        //   143: invokevirtual 57	android/os/Parcel:recycle	()V
        //   146: aload 6
        //   148: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	149	0	this	a
        //   0	149	1	paramd1	d
        //   0	149	2	paramd2	d
        //   0	149	3	paramBundle	Bundle
        //   11	126	4	localParcel1	Parcel
        //   6	136	5	localParcel2	Parcel
        //   30	91	6	localObject1	Object
        //   134	13	6	localObject2	Object
        //   1	53	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	106	134	finally
        //   125	131	134	finally
      }
      
      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDestroyView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onInflate(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label132:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            IBinder localIBinder;
            if (paramd != null)
            {
              localIBinder = paramd.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramStreetViewPanoramaOptions != null)
              {
                localParcel1.writeInt(1);
                paramStreetViewPanoramaOptions.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onPause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
          this.ko.transact(6, localParcel1, localParcel2, 0);
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
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
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
        //   20: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 75	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 10
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 42 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 45	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 63	android/os/Parcel:readInt	()I
        //   52: ifeq +8 -> 60
        //   55: aload_1
        //   56: aload_3
        //   57: invokevirtual 105	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   60: aload_3
        //   61: invokevirtual 57	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 57	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload_2
        //   70: iconst_0
        //   71: invokevirtual 69	android/os/Parcel:writeInt	(I)V
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
 * Qualified Name:     com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */
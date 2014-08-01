package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface co
  extends IInterface
{
  public abstract void N()
    throws RemoteException;
  
  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onDestroy()
    throws RemoteException;
  
  public abstract void onPause()
    throws RemoteException;
  
  public abstract void onRestart()
    throws RemoteException;
  
  public abstract void onResume()
    throws RemoteException;
  
  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onStart()
    throws RemoteException;
  
  public abstract void onStop()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements co
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }
    
    public static co m(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if ((localObject == null) || (!(localObject instanceof co))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (co)localObject;
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
      Object localObject = null;
      int i;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        Bundle localBundle1;
        if (paramParcel1.readInt() != 0) {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onCreate(localBundle1);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onRestart();
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onStart();
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onResume();
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onPause();
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
        bool2 = true;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onStop();
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        onDestroy();
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        N();
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements co
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void N()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
          this.ko.transact(9, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 53	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 59	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/internal/co$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_1
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 39 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 42	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 45	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 45	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 53	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 45	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 45	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramBundle	Bundle
        //   71	11	2	localObject	Object
        //   8	65	3	localParcel1	Parcel
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
      
      public void onPause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
      
      public void onRestart()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
          this.ko.transact(2, localParcel1, localParcel2, 0);
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
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
      
      /* Error */
      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +54 -> 69
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 53	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 59	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/co$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 39 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 42	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 68	android/os/Parcel:readInt	()I
        //   52: ifeq +8 -> 60
        //   55: aload_1
        //   56: aload_2
        //   57: invokevirtual 72	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   60: aload_2
        //   61: invokevirtual 45	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 45	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload_3
        //   70: iconst_0
        //   71: invokevirtual 53	android/os/Parcel:writeInt	(I)V
        //   74: goto -45 -> 29
        //   77: astore 4
        //   79: aload_2
        //   80: invokevirtual 45	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 45	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramBundle	Bundle
        //   7	73	2	localParcel1	Parcel
        //   3	81	3	localParcel2	Parcel
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
        //   69	74	77	finally
      }
      
      public void onStart()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
          this.ko.transact(3, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onStop()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.co
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface IGamesSignInCallbacks
  extends IInterface
{
  public abstract void S(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void T(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void b(int paramInt, Intent paramIntent)
    throws RemoteException;
  
  public abstract void ci(int paramInt)
    throws RemoteException;
  
  public abstract void cj(int paramInt)
    throws RemoteException;
  
  public abstract void g(DataHolder paramDataHolder)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IGamesSignInCallbacks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
    }
    
    public static IGamesSignInCallbacks ak(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        if ((localObject == null) || (!(localObject instanceof IGamesSignInCallbacks))) {
          localObject = new Proxy(paramIBinder);
        } else {
          localObject = (IGamesSignInCallbacks)localObject;
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
      Object localObject = null;
      int i;
      switch (paramInt1)
      {
      default: 
        boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localObject = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        b(i, (Intent)localObject);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject = DataHolder.CREATOR.x(paramParcel1);
        }
        S((DataHolder)localObject);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject = DataHolder.CREATOR.x(paramParcel1);
        }
        T((DataHolder)localObject);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        ci(paramParcel1.readInt());
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject = DataHolder.CREATOR.x(paramParcel1);
        }
        g((DataHolder)localObject);
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 5006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        cj(paramParcel1.readInt());
        paramParcel2.writeNoException();
        i = 1;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
        i = 1;
      }
      return i;
    }
    
    private static class Proxy
      implements IGamesSignInCallbacks
    {
      private IBinder ko;
      
      Proxy(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void S(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesSignInCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5002
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void T(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesSignInCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5003
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void b(int paramInt, Intent paramIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 5
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +46 -> 67
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 64	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesSignInCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 5001
        //   42: aload_3
        //   43: aload 5
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 5
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 5
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -37 -> 35
        //   75: astore 4
        //   77: aload 5
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramInt	int
        //   0	89	2	paramIntent	Intent
        //   3	80	3	localParcel1	Parcel
        //   75	12	4	localObject	Object
        //   7	71	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      public void ci(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
          localParcel1.writeInt(paramInt);
          this.ko.transact(5004, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void cj(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
          localParcel2.writeInt(paramInt);
          this.ko.transact(5006, localParcel2, localParcel1, 0);
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
      public void g(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesSignInCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5005
        //   40: aload 4
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_2
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   73	11	2	localObject	Object
        //   8	67	3	localParcel1	Parcel
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IGamesSignInCallbacks
 * JD-Core Version:    0.7.0.1
 */
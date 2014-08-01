package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public abstract interface lo
  extends IInterface
{
  public abstract ll a(d paramd, c paramc, WalletFragmentOptions paramWalletFragmentOptions, lm paramlm)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements lo
  {
    public static lo br(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        if ((localObject == null) || (!(localObject instanceof lo))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (lo)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        Object localObject2 = d.a.ag(paramParcel1.readStrongBinder());
        c localc = c.a.af(paramParcel1.readStrongBinder());
        WalletFragmentOptions localWalletFragmentOptions;
        if (paramParcel1.readInt() == 0) {
          localWalletFragmentOptions = null;
        } else {
          localWalletFragmentOptions = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = a((d)localObject2, localc, localWalletFragmentOptions, lm.a.bp(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder;
        if (localObject2 != null) {
          localIBinder = ((ll)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements lo
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public ll a(d paramd, c paramc, WalletFragmentOptions paramWalletFragmentOptions, lm paramlm)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +119 -> 140
        //   24: aload_1
        //   25: invokeinterface 39 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +106 -> 146
        //   43: aload_2
        //   44: invokeinterface 45 1 0
        //   49: astore 8
        //   51: aload 5
        //   53: aload 8
        //   55: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   58: aload_3
        //   59: ifnull +93 -> 152
        //   62: aload 5
        //   64: iconst_1
        //   65: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   68: aload_3
        //   69: aload 5
        //   71: iconst_0
        //   72: invokevirtual 55	com/google/android/gms/wallet/fragment/WalletFragmentOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   75: aload 4
        //   77: ifnull +12 -> 89
        //   80: aload 4
        //   82: invokeinterface 58 1 0
        //   87: astore 7
        //   89: aload 5
        //   91: aload 7
        //   93: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   96: aload_0
        //   97: getfield 18	com/google/android/gms/internal/lo$a$a:ko	Landroid/os/IBinder;
        //   100: iconst_1
        //   101: aload 5
        //   103: aload 6
        //   105: iconst_0
        //   106: invokeinterface 64 5 0
        //   111: pop
        //   112: aload 6
        //   114: invokevirtual 67	android/os/Parcel:readException	()V
        //   117: aload 6
        //   119: invokevirtual 70	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   122: invokestatic 76	com/google/android/gms/internal/ll$a:bo	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ll;
        //   125: astore 7
        //   127: aload 6
        //   129: invokevirtual 79	android/os/Parcel:recycle	()V
        //   132: aload 5
        //   134: invokevirtual 79	android/os/Parcel:recycle	()V
        //   137: aload 7
        //   139: areturn
        //   140: aconst_null
        //   141: astore 8
        //   143: goto -111 -> 32
        //   146: aconst_null
        //   147: astore 8
        //   149: goto -98 -> 51
        //   152: aload 5
        //   154: iconst_0
        //   155: invokevirtual 49	android/os/Parcel:writeInt	(I)V
        //   158: goto -83 -> 75
        //   161: astore 7
        //   163: aload 6
        //   165: invokevirtual 79	android/os/Parcel:recycle	()V
        //   168: aload 5
        //   170: invokevirtual 79	android/os/Parcel:recycle	()V
        //   173: aload 7
        //   175: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	176	0	this	a
        //   0	176	1	paramd	d
        //   0	176	2	paramc	c
        //   0	176	3	paramWalletFragmentOptions	WalletFragmentOptions
        //   0	176	4	paramlm	lm
        //   6	163	5	localParcel1	Parcel
        //   11	153	6	localParcel2	Parcel
        //   1	137	7	localObject1	Object
        //   161	13	7	localObject2	Object
        //   30	118	8	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	127	161	finally
        //   152	158	161	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lo
 * JD-Core Version:    0.7.0.1
 */
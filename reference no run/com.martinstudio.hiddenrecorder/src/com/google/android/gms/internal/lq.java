package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

public abstract interface lq
  extends IInterface
{
  public abstract void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(Status paramStatus, lj paramlj, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void i(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements lq
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    }
    
    public static lq bt(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        if ((localObject == null) || (!(localObject instanceof lq))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (lq)localObject;
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
      boolean bool1 = true;
      Object localObject1;
      int i;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        int k = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle2;
        if (paramParcel1.readInt() == 0) {
          localBundle2 = null;
        } else {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(k, (MaskedWallet)localObject1, localBundle2);
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        int j = paramParcel1.readInt();
        FullWallet localFullWallet;
        if (paramParcel1.readInt() == 0) {
          localFullWallet = null;
        } else {
          localFullWallet = (FullWallet)FullWallet.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(j, localFullWallet, (Bundle)localObject1);
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        i = paramParcel1.readInt();
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(i, bool2, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        i(i, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = Status.CREATOR.createFromParcel(paramParcel1);
        }
        lj locallj;
        if (paramParcel1.readInt() == 0) {
          locallj = null;
        } else {
          locallj = (lj)lj.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle1;
        if (paramParcel1.readInt() == 0) {
          localBundle1 = null;
        } else {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((Status)localObject2, locallj, localBundle1);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      }
      return bool1;
    }
    
    private static class a
      implements lq
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramFullWallet != null)
            {
              localParcel1.writeInt(1);
              paramFullWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramMaskedWallet != null)
            {
              localParcel1.writeInt(1);
              paramMaskedWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 6
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 4
        //   22: iload_1
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: iload_2
        //   27: ifeq +59 -> 86
        //   30: aload 4
        //   32: iload 6
        //   34: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   37: aload_3
        //   38: ifnull +54 -> 92
        //   41: aload 4
        //   43: iconst_1
        //   44: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokevirtual 46	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   54: aload_0
        //   55: getfield 18	com/google/android/gms/internal/lq$a$a:ko	Landroid/os/IBinder;
        //   58: iconst_3
        //   59: aload 4
        //   61: aload 5
        //   63: iconst_0
        //   64: invokeinterface 52 5 0
        //   69: pop
        //   70: aload 5
        //   72: invokevirtual 55	android/os/Parcel:readException	()V
        //   75: aload 5
        //   77: invokevirtual 58	android/os/Parcel:recycle	()V
        //   80: aload 4
        //   82: invokevirtual 58	android/os/Parcel:recycle	()V
        //   85: return
        //   86: iconst_0
        //   87: istore 6
        //   89: goto -59 -> 30
        //   92: aload 4
        //   94: iconst_0
        //   95: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   98: goto -44 -> 54
        //   101: astore 6
        //   103: aload 5
        //   105: invokevirtual 58	android/os/Parcel:recycle	()V
        //   108: aload 4
        //   110: invokevirtual 58	android/os/Parcel:recycle	()V
        //   113: aload 6
        //   115: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	a
        //   0	116	1	paramInt	int
        //   0	116	2	paramBoolean	boolean
        //   0	116	3	paramBundle	Bundle
        //   6	103	4	localParcel1	Parcel
        //   11	93	5	localParcel2	Parcel
        //   1	87	6	i	int
        //   101	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	75	101	finally
        //   92	98	101	finally
      }
      
      public void a(Status paramStatus, lj paramlj, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (paramStatus != null)
            {
              localParcel1.writeInt(1);
              paramStatus.writeToParcel(localParcel1, 0);
              if (paramlj != null)
              {
                localParcel1.writeInt(1);
                paramlj.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label133;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label133:
          localParcel1.writeInt(0);
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void i(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: iload_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_2
        //   24: ifnull +48 -> 72
        //   27: aload 5
        //   29: iconst_1
        //   30: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 5
        //   36: iconst_0
        //   37: invokevirtual 46	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/internal/lq$a$a:ko	Landroid/os/IBinder;
        //   44: iconst_4
        //   45: aload 5
        //   47: aload 4
        //   49: iconst_0
        //   50: invokeinterface 52 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 55	android/os/Parcel:readException	()V
        //   61: aload 4
        //   63: invokevirtual 58	android/os/Parcel:recycle	()V
        //   66: aload 5
        //   68: invokevirtual 58	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aload 5
        //   74: iconst_0
        //   75: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   78: goto -38 -> 40
        //   81: astore_3
        //   82: aload 4
        //   84: invokevirtual 58	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: invokevirtual 58	android/os/Parcel:recycle	()V
        //   92: aload_3
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	this	a
        //   0	94	1	paramInt	int
        //   0	94	2	paramBundle	Bundle
        //   81	12	3	localObject	Object
        //   8	75	4	localParcel1	Parcel
        //   3	85	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	61	81	finally
        //   72	78	81	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lq
 * JD-Core Version:    0.7.0.1
 */
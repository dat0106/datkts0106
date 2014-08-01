package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.d;

public abstract interface ln
  extends IInterface
{
  public abstract void a(Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void a(lh paramlh, Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lp paramlp)
    throws RemoteException;
  
  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(d paramd, Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, lq paramlq)
    throws RemoteException;
  
  public abstract void o(Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ln
  {
    public static ln bq(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
        if ((localObject == null) || (!(localObject instanceof ln))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ln)localObject;
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
      Object localObject;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        MaskedWalletRequest localMaskedWalletRequest1;
        if (paramParcel1.readInt() == 0) {
          localMaskedWalletRequest1 = null;
        } else {
          localMaskedWalletRequest1 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(localMaskedWalletRequest1, (Bundle)localObject, lq.a.bt(paramParcel1.readStrongBinder()));
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        FullWalletRequest localFullWalletRequest;
        if (paramParcel1.readInt() == 0) {
          localFullWalletRequest = null;
        } else {
          localFullWalletRequest = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(localFullWalletRequest, (Bundle)localObject, lq.a.bt(paramParcel1.readStrongBinder()));
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        localObject = paramParcel1.readString();
        String str = paramParcel1.readString();
        Bundle localBundle1;
        if (paramParcel1.readInt() == 0) {
          localBundle1 = null;
        } else {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((String)localObject, str, localBundle1, lq.a.bt(paramParcel1.readStrongBinder()));
        int k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle2;
        if (paramParcel1.readInt() == 0) {
          localBundle2 = null;
        } else {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((NotifyTransactionStatusRequest)localObject, localBundle2);
        int m = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        Bundle localBundle3;
        if (paramParcel1.readInt() == 0) {
          localBundle3 = null;
        } else {
          localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(localBundle3, lq.a.bt(paramParcel1.readStrongBinder()));
        int n = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (d)d.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle4;
        if (paramParcel1.readInt() == 0) {
          localBundle4 = null;
        } else {
          localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((d)localObject, localBundle4, lq.a.bt(paramParcel1.readStrongBinder()));
        int i1 = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        MaskedWalletRequest localMaskedWalletRequest2;
        if (paramParcel1.readInt() == 0) {
          localMaskedWalletRequest2 = null;
        } else {
          localMaskedWalletRequest2 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(localMaskedWalletRequest2, (Bundle)localObject, lp.a.bs(paramParcel1.readStrongBinder()));
        int i2 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        lh locallh;
        if (paramParcel1.readInt() == 0) {
          locallh = null;
        } else {
          locallh = (lh)lh.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject = null;
        } else {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(locallh, (Bundle)localObject, lq.a.bt(paramParcel1.readStrongBinder()));
        int i3 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
        Bundle localBundle5;
        if (paramParcel1.readInt() == 0) {
          localBundle5 = null;
        } else {
          localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        o(localBundle5);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ln
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: aload_3
        //   8: ldc 29
        //   10: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   13: aload_1
        //   14: ifnull +51 -> 65
        //   17: aload_3
        //   18: iconst_1
        //   19: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   22: aload_1
        //   23: aload_3
        //   24: iconst_0
        //   25: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   28: aload_2
        //   29: ifnull +11 -> 40
        //   32: aload_2
        //   33: invokeinterface 49 1 0
        //   38: astore 4
        //   40: aload_3
        //   41: aload 4
        //   43: invokevirtual 52	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/ln$a$a:ko	Landroid/os/IBinder;
        //   50: iconst_5
        //   51: aload_3
        //   52: aconst_null
        //   53: iconst_1
        //   54: invokeinterface 58 5 0
        //   59: pop
        //   60: aload_3
        //   61: invokevirtual 61	android/os/Parcel:recycle	()V
        //   64: return
        //   65: aload_3
        //   66: iconst_0
        //   67: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   70: goto -42 -> 28
        //   73: astore 4
        //   75: aload_3
        //   76: invokevirtual 61	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	a
        //   0	82	1	paramBundle	Bundle
        //   0	82	2	paramlq	lq
        //   6	70	3	localParcel	Parcel
        //   1	41	4	localIBinder	IBinder
        //   73	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	60	73	finally
        //   65	70	73	finally
      }
      
      public void a(lh paramlh, Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramlh != null)
            {
              localParcel.writeInt(1);
              paramlh.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                if (paramlq != null) {
                  localIBinder = paramlq.asBinder();
                }
                localParcel.writeStrongBinder(localIBinder);
                this.ko.transact(8, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramFullWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramFullWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                if (paramlq != null) {
                  localIBinder = paramlq.asBinder();
                }
                localParcel.writeStrongBinder(localIBinder);
                this.ko.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lp paramlp)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramMaskedWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramMaskedWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                if (paramlp != null) {
                  localIBinder = paramlp.asBinder();
                }
                localParcel.writeStrongBinder(localIBinder);
                this.ko.transact(7, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramMaskedWalletRequest != null)
            {
              localParcel.writeInt(1);
              paramMaskedWalletRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                if (paramlq != null) {
                  localIBinder = paramlq.asBinder();
                }
                localParcel.writeStrongBinder(localIBinder);
                this.ko.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramNotifyTransactionStatusRequest != null)
            {
              localParcel.writeInt(1);
              paramNotifyTransactionStatusRequest.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                this.ko.transact(4, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(d paramd, Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
            if (paramd != null)
            {
              localParcel.writeInt(1);
              paramd.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                if (paramlq != null) {
                  localIBinder = paramlq.asBinder();
                }
                localParcel.writeStrongBinder(localIBinder);
                this.ko.transact(6, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      /* Error */
      public void a(String paramString1, String paramString2, Bundle paramBundle, lq paramlq)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 5
        //   17: aload_1
        //   18: invokevirtual 89	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   21: aload 5
        //   23: aload_2
        //   24: invokevirtual 89	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   27: aload_3
        //   28: ifnull +58 -> 86
        //   31: aload 5
        //   33: iconst_1
        //   34: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   37: aload_3
        //   38: aload 5
        //   40: iconst_0
        //   41: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   44: aload 4
        //   46: ifnull +12 -> 58
        //   49: aload 4
        //   51: invokeinterface 49 1 0
        //   56: astore 6
        //   58: aload 5
        //   60: aload 6
        //   62: invokevirtual 52	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   65: aload_0
        //   66: getfield 18	com/google/android/gms/internal/ln$a$a:ko	Landroid/os/IBinder;
        //   69: iconst_3
        //   70: aload 5
        //   72: aconst_null
        //   73: iconst_1
        //   74: invokeinterface 58 5 0
        //   79: pop
        //   80: aload 5
        //   82: invokevirtual 61	android/os/Parcel:recycle	()V
        //   85: return
        //   86: aload 5
        //   88: iconst_0
        //   89: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   92: goto -48 -> 44
        //   95: astore 6
        //   97: aload 5
        //   99: invokevirtual 61	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramString1	String
        //   0	105	2	paramString2	String
        //   0	105	3	paramBundle	Bundle
        //   0	105	4	paramlq	lq
        //   6	92	5	localParcel	Parcel
        //   1	60	6	localIBinder	IBinder
        //   95	8	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	80	95	finally
        //   86	92	95	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void o(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 29
        //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/ln$a$a:ko	Landroid/os/IBinder;
        //   29: bipush 9
        //   31: aload_3
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 58 5 0
        //   39: pop
        //   40: aload_3
        //   41: invokevirtual 61	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_3
        //   46: iconst_0
        //   47: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_2
        //   54: aload_3
        //   55: invokevirtual 61	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	a
        //   0	60	1	paramBundle	Bundle
        //   53	6	2	localObject	Object
        //   3	52	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	40	53	finally
        //   45	50	53	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ln
 * JD-Core Version:    0.7.0.1
 */
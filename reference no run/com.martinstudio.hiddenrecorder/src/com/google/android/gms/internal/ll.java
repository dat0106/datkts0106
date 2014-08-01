package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public abstract interface ll
  extends IInterface
{
  public abstract void a(d paramd, WalletFragmentOptions paramWalletFragmentOptions, Bundle paramBundle)
    throws RemoteException;
  
  public abstract int getState()
    throws RemoteException;
  
  public abstract void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    throws RemoteException;
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    throws RemoteException;
  
  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;
  
  public abstract d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onPause()
    throws RemoteException;
  
  public abstract void onResume()
    throws RemoteException;
  
  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onStart()
    throws RemoteException;
  
  public abstract void onStop()
    throws RemoteException;
  
  public abstract void setEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    throws RemoteException;
  
  public abstract void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ll
  {
    public static ll bo(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if ((localObject == null) || (!(localObject instanceof ll))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ll)localObject;
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
      d locald1;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        locald1 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(locald1, (WalletFragmentOptions)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onCreate((Bundle)localObject1);
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        locald1 = d.a.ag(paramParcel1.readStrongBinder());
        d locald2 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = onCreateView(locald1, locald2, (Bundle)localObject2);
        paramParcel2.writeNoException();
        if (localObject2 != null) {
          localObject1 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject1);
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        onStart();
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        onResume();
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        onPause();
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        onStop();
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        int k = paramParcel1.readInt();
        int m = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        onActivityResult(k, m, (Intent)localObject1);
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (WalletFragmentInitParams)WalletFragmentInitParams.CREATOR.createFromParcel(paramParcel1);
        }
        initialize((WalletFragmentInitParams)localObject1);
        paramParcel2.writeNoException();
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(paramParcel1);
        }
        updateMaskedWalletRequest((MaskedWalletRequest)localObject1);
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        boolean bool;
        if (paramParcel1.readInt() == 0) {
          bool = false;
        } else {
          bool = i;
        }
        setEnabled(bool);
        paramParcel2.writeNoException();
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        int j = getState();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
        MaskedWallet localMaskedWallet;
        if (paramParcel1.readInt() == 0) {
          localMaskedWallet = null;
        } else {
          localMaskedWallet = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
        }
        updateMaskedWallet(localMaskedWallet);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
      }
      return i;
    }
    
    private static class a
      implements ll
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(d paramd, WalletFragmentOptions paramWalletFragmentOptions, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        label132:
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            IBinder localIBinder;
            if (paramd != null)
            {
              localIBinder = paramd.asBinder();
              localParcel2.writeStrongBinder(localIBinder);
              if (paramWalletFragmentOptions != null)
              {
                localParcel2.writeInt(1);
                paramWalletFragmentOptions.writeToParcel(localParcel2, 0);
                if (paramBundle == null) {
                  break label132;
                }
                localParcel2.writeInt(1);
                paramBundle.writeToParcel(localParcel2, 0);
                this.ko.transact(1, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel2.writeInt(0);
            continue;
            localParcel2.writeInt(0);
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public int getState()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
          this.ko.transact(13, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +45 -> 61
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 77	com/google/android/gms/wallet/fragment/WalletFragmentInitParams:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 10
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 61 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 64	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 67	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 67	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_2
        //   62: iconst_0
        //   63: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_3
        //   70: aload 4
        //   72: invokevirtual 67	android/os/Parcel:recycle	()V
        //   75: aload_2
        //   76: invokevirtual 67	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramWalletFragmentInitParams	WalletFragmentInitParams
        //   3	73	2	localParcel1	Parcel
        //   69	11	3	localObject	Object
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      /* Error */
      public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: iload_1
        //   20: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   23: aload 4
        //   25: iload_2
        //   26: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +49 -> 79
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 82	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   50: bipush 9
        //   52: aload 4
        //   54: aload 5
        //   56: iconst_0
        //   57: invokeinterface 61 5 0
        //   62: pop
        //   63: aload 5
        //   65: invokevirtual 64	android/os/Parcel:readException	()V
        //   68: aload 5
        //   70: invokevirtual 67	android/os/Parcel:recycle	()V
        //   73: aload 4
        //   75: invokevirtual 67	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 4
        //   81: iconst_0
        //   82: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   85: goto -39 -> 46
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 67	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 67	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	a
        //   0	103	1	paramInt1	int
        //   0	103	2	paramInt2	int
        //   0	103	3	paramIntent	Intent
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	68	88	finally
        //   79	85	88	finally
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
        //   23: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 55	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_2
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 61 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 64	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 67	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 67	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 67	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 67	android/os/Parcel:recycle	()V
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
      
      /* Error */
      public d onCreateView(d paramd1, d paramd2, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +98 -> 119
        //   24: aload_1
        //   25: invokeinterface 39 1 0
        //   30: astore 7
        //   32: aload 4
        //   34: aload 7
        //   36: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_2
        //   40: ifnull +11 -> 51
        //   43: aload_2
        //   44: invokeinterface 39 1 0
        //   49: astore 6
        //   51: aload 4
        //   53: aload 6
        //   55: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   58: aload_3
        //   59: ifnull +66 -> 125
        //   62: aload 4
        //   64: iconst_1
        //   65: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   68: aload_3
        //   69: aload 4
        //   71: iconst_0
        //   72: invokevirtual 55	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   75: aload_0
        //   76: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   79: iconst_3
        //   80: aload 4
        //   82: aload 5
        //   84: iconst_0
        //   85: invokeinterface 61 5 0
        //   90: pop
        //   91: aload 5
        //   93: invokevirtual 64	android/os/Parcel:readException	()V
        //   96: aload 5
        //   98: invokevirtual 89	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   101: invokestatic 95	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   104: astore 6
        //   106: aload 5
        //   108: invokevirtual 67	android/os/Parcel:recycle	()V
        //   111: aload 4
        //   113: invokevirtual 67	android/os/Parcel:recycle	()V
        //   116: aload 6
        //   118: areturn
        //   119: aconst_null
        //   120: astore 7
        //   122: goto -90 -> 32
        //   125: aload 4
        //   127: iconst_0
        //   128: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   131: goto -56 -> 75
        //   134: astore 6
        //   136: aload 5
        //   138: invokevirtual 67	android/os/Parcel:recycle	()V
        //   141: aload 4
        //   143: invokevirtual 67	android/os/Parcel:recycle	()V
        //   146: aload 6
        //   148: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	149	0	this	a
        //   0	149	1	paramd1	d
        //   0	149	2	paramd2	d
        //   0	149	3	paramBundle	Bundle
        //   6	136	4	localParcel1	Parcel
        //   11	126	5	localParcel2	Parcel
        //   1	116	6	localObject1	Object
        //   134	13	6	localObject2	Object
        //   30	91	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	106	134	finally
        //   125	131	134	finally
      }
      
      public void onPause()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      
      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      
      /* Error */
      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +59 -> 75
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 55	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 8
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 61 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 64	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 72	android/os/Parcel:readInt	()I
        //   56: ifeq +9 -> 65
        //   59: aload_1
        //   60: aload 4
        //   62: invokevirtual 102	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   65: aload 4
        //   67: invokevirtual 67	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 67	android/os/Parcel:recycle	()V
        //   74: return
        //   75: aload_2
        //   76: iconst_0
        //   77: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   80: goto -50 -> 30
        //   83: astore_3
        //   84: aload 4
        //   86: invokevirtual 67	android/os/Parcel:recycle	()V
        //   89: aload_2
        //   90: invokevirtual 67	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramBundle	Bundle
        //   3	87	2	localParcel1	Parcel
        //   83	11	3	localObject	Object
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	65	83	finally
        //   75	80	83	finally
      }
      
      public void onStart()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      
      public void onStop()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
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
      
      public void setEnabled(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(12, localParcel1, localParcel2, 0);
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
      public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 111	com/google/android/gms/wallet/MaskedWallet:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 14
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 61 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 64	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 67	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 67	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 67	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 67	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramMaskedWallet	MaskedWallet
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      /* Error */
      public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
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
        //   15: ifnull +42 -> 57
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 116	com/google/android/gms/wallet/MaskedWalletRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/ll$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 11
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 61 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 64	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 67	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 67	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_3
        //   58: iconst_0
        //   59: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 67	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 67	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramMaskedWalletRequest	MaskedWalletRequest
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ll
 * JD-Core Version:    0.7.0.1
 */
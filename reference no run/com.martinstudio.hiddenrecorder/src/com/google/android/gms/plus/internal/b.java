package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.internal.if;
import com.google.android.gms.internal.ig;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.ku;

public abstract interface b
  extends IInterface
{
  public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException;
  
  public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;
  
  public abstract void a(int paramInt, Bundle paramBundle, if paramif)
    throws RemoteException;
  
  public abstract void a(int paramInt, kt paramkt)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, String paramString)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void am(Status paramStatus)
    throws RemoteException;
  
  public abstract void bw(String paramString)
    throws RemoteException;
  
  public abstract void bx(String paramString)
    throws RemoteException;
  
  public abstract void h(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
    }
    
    public static b bk(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        if ((localObject == null) || (!(localObject instanceof b))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (b)localObject;
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
      Object localObject1 = null;
      int i5;
      Object localObject2;
      int j;
      int i4;
      int i1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        int i3 = paramParcel1.readInt();
        Bundle localBundle4;
        if (paramParcel1.readInt() == 0) {
          localBundle4 = null;
        } else {
          localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle1;
        if (paramParcel1.readInt() == 0) {
          localBundle1 = null;
        } else {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(i3, localBundle4, localBundle1);
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        i5 = paramParcel1.readInt();
        Bundle localBundle2;
        if (paramParcel1.readInt() == 0) {
          localBundle2 = null;
        } else {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
        }
        a(i5, localBundle2, (ParcelFileDescriptor)localObject2);
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        bw(paramParcel1.readString());
        paramParcel2.writeNoException();
        j = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        DataHolder localDataHolder1;
        if (paramParcel1.readInt() != 0) {
          localDataHolder1 = DataHolder.CREATOR.x(paramParcel1);
        }
        a(localDataHolder1, paramParcel1.readString());
        paramParcel2.writeNoException();
        int k = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        i5 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        if localif;
        if (paramParcel1.readInt() != 0) {
          localif = if.CREATOR.L(paramParcel1);
        }
        a(i5, (Bundle)localObject2, localif);
        paramParcel2.writeNoException();
        int m = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        DataHolder localDataHolder2;
        if (paramParcel1.readInt() != 0) {
          localDataHolder2 = DataHolder.CREATOR.x(paramParcel1);
        }
        a(localDataHolder2, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        int n = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        i4 = paramParcel1.readInt();
        Bundle localBundle3;
        if (paramParcel1.readInt() == 0) {
          localBundle3 = null;
        } else {
          localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        h(i4, localBundle3);
        paramParcel2.writeNoException();
        i1 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        bx(paramParcel1.readString());
        paramParcel2.writeNoException();
        i1 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        i4 = paramParcel1.readInt();
        kt localkt;
        if (paramParcel1.readInt() != 0) {
          localkt = kt.CREATOR.bG(paramParcel1);
        }
        a(i4, localkt);
        paramParcel2.writeNoException();
        int i2 = 1;
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
        Status localStatus;
        if (paramParcel1.readInt() != 0) {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        am(localStatus);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements b
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle1 != null)
            {
              localParcel1.writeInt(1);
              paramBundle1.writeToParcel(localParcel1, 0);
              if (paramBundle2 != null)
              {
                localParcel1.writeInt(1);
                paramBundle2.writeToParcel(localParcel1, 0);
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
      
      public void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramParcelFileDescriptor != null)
              {
                localParcel1.writeInt(1);
                paramParcelFileDescriptor.writeToParcel(localParcel1, 0);
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
      
      public void a(int paramInt, Bundle paramBundle, if paramif)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramif != null)
              {
                localParcel1.writeInt(1);
                paramif.writeToParcel(localParcel1, 0);
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
        }
      }
      
      /* Error */
      public void a(int paramInt, kt paramkt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 5
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload 5
        //   18: iload_1
        //   19: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   22: aload_2
        //   23: ifnull +46 -> 69
        //   26: aload 5
        //   28: iconst_1
        //   29: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   32: aload_2
        //   33: aload 5
        //   35: iconst_0
        //   36: invokevirtual 67	com/google/android/gms/internal/kt:writeToParcel	(Landroid/os/Parcel;I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/plus/internal/b$a$a:ko	Landroid/os/IBinder;
        //   43: bipush 9
        //   45: aload 5
        //   47: aload_3
        //   48: iconst_0
        //   49: invokeinterface 49 5 0
        //   54: pop
        //   55: aload_3
        //   56: invokevirtual 52	android/os/Parcel:readException	()V
        //   59: aload_3
        //   60: invokevirtual 55	android/os/Parcel:recycle	()V
        //   63: aload 5
        //   65: invokevirtual 55	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload 5
        //   71: iconst_0
        //   72: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   75: goto -36 -> 39
        //   78: astore 4
        //   80: aload_3
        //   81: invokevirtual 55	android/os/Parcel:recycle	()V
        //   84: aload 5
        //   86: invokevirtual 55	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	a
        //   0	92	1	paramInt	int
        //   0	92	2	paramkt	kt
        //   8	73	3	localParcel1	Parcel
        //   78	12	4	localObject	Object
        //   3	82	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	59	78	finally
        //   69	75	78	finally
      }
      
      /* Error */
      public void a(DataHolder paramDataHolder, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +49 -> 65
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 71	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 74	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/plus/internal/b$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_4
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 49 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 52	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 55	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 55	android/os/Parcel:recycle	()V
        //   64: return
        //   65: aload_3
        //   66: iconst_0
        //   67: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   70: goto -40 -> 30
        //   73: astore 5
        //   75: aload 4
        //   77: invokevirtual 55	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 55	android/os/Parcel:recycle	()V
        //   84: aload 5
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	a
        //   0	87	1	paramDataHolder	DataHolder
        //   0	87	2	paramString	String
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        //   73	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	55	73	finally
        //   65	70	73	finally
      }
      
      /* Error */
      public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
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
        //   17: aload_1
        //   18: ifnull +61 -> 79
        //   21: aload 5
        //   23: iconst_1
        //   24: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 5
        //   30: iconst_0
        //   31: invokevirtual 71	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 5
        //   36: aload_2
        //   37: invokevirtual 74	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 5
        //   42: aload_3
        //   43: invokevirtual 74	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/plus/internal/b$a$a:ko	Landroid/os/IBinder;
        //   50: bipush 6
        //   52: aload 5
        //   54: aload 4
        //   56: iconst_0
        //   57: invokeinterface 49 5 0
        //   62: pop
        //   63: aload 4
        //   65: invokevirtual 52	android/os/Parcel:readException	()V
        //   68: aload 4
        //   70: invokevirtual 55	android/os/Parcel:recycle	()V
        //   73: aload 5
        //   75: invokevirtual 55	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 5
        //   81: iconst_0
        //   82: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   85: goto -51 -> 34
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 55	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 55	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	a
        //   0	103	1	paramDataHolder	DataHolder
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	68	88	finally
        //   79	85	88	finally
      }
      
      /* Error */
      public void am(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +45 -> 61
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 80	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/plus/internal/b$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 10
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 55	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_3
        //   62: iconst_0
        //   63: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_2
        //   70: aload 4
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload_3
        //   76: invokevirtual 55	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramStatus	Status
        //   69	11	2	localObject	Object
        //   3	73	3	localParcel1	Parcel
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void bw(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel1.writeString(paramString);
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
      
      public void bx(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
          localParcel2.writeString(paramString);
          this.ko.transact(8, localParcel2, localParcel1, 0);
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
      public void h(int paramInt, Bundle paramBundle)
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
        //   24: ifnull +49 -> 73
        //   27: aload 5
        //   29: iconst_1
        //   30: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 5
        //   36: iconst_0
        //   37: invokevirtual 43	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/plus/internal/b$a$a:ko	Landroid/os/IBinder;
        //   44: bipush 7
        //   46: aload 5
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 49 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 52	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 55	android/os/Parcel:recycle	()V
        //   67: aload 5
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aload 5
        //   75: iconst_0
        //   76: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   79: goto -39 -> 40
        //   82: astore_3
        //   83: aload 4
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: invokevirtual 55	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramInt	int
        //   0	95	2	paramBundle	Bundle
        //   82	12	3	localObject	Object
        //   8	76	4	localParcel1	Parcel
        //   3	86	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	62	82	finally
        //   73	79	82	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.b
 * JD-Core Version:    0.7.0.1
 */
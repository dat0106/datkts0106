package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract interface ab
  extends IInterface
{
  public abstract void Z(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void a(Status paramStatus)
    throws RemoteException;
  
  public abstract void a(am paramam)
    throws RemoteException;
  
  public abstract void a(aq paramaq)
    throws RemoteException;
  
  public abstract void a(as paramas)
    throws RemoteException;
  
  public abstract void a(p paramp)
    throws RemoteException;
  
  public abstract void a(r paramr)
    throws RemoteException;
  
  public abstract void a(t paramt)
    throws RemoteException;
  
  public abstract void a(v paramv)
    throws RemoteException;
  
  public abstract void a(x paramx)
    throws RemoteException;
  
  public abstract void a(z paramz)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ab
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
    }
    
    public static ab bw(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        if ((localObject == null) || (!(localObject instanceof ab))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ab)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        r localr;
        if (paramParcel1.readInt() != 0) {
          localr = (r)r.CREATOR.createFromParcel(paramParcel1);
        }
        a(localr);
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        am localam;
        if (paramParcel1.readInt() != 0) {
          localam = (am)am.CREATOR.createFromParcel(paramParcel1);
        }
        a(localam);
        paramParcel2.writeNoException();
        int j = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        v localv;
        if (paramParcel1.readInt() != 0) {
          localv = (v)v.CREATOR.createFromParcel(paramParcel1);
        }
        a(localv);
        paramParcel2.writeNoException();
        int k = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        DataHolder localDataHolder;
        if (paramParcel1.readInt() != 0) {
          localDataHolder = DataHolder.CREATOR.x(paramParcel1);
        }
        Z(localDataHolder);
        paramParcel2.writeNoException();
        int m = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        p localp;
        if (paramParcel1.readInt() != 0) {
          localp = (p)p.CREATOR.createFromParcel(paramParcel1);
        }
        a(localp);
        paramParcel2.writeNoException();
        int n = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        aq localaq;
        if (paramParcel1.readInt() != 0) {
          localaq = (aq)aq.CREATOR.createFromParcel(paramParcel1);
        }
        a(localaq);
        paramParcel2.writeNoException();
        int i1 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        x localx;
        if (paramParcel1.readInt() != 0) {
          localx = (x)x.CREATOR.createFromParcel(paramParcel1);
        }
        a(localx);
        paramParcel2.writeNoException();
        int i2 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        z localz;
        if (paramParcel1.readInt() != 0) {
          localz = (z)z.CREATOR.createFromParcel(paramParcel1);
        }
        a(localz);
        paramParcel2.writeNoException();
        int i3 = 1;
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        t localt;
        if (paramParcel1.readInt() != 0) {
          localt = (t)t.CREATOR.createFromParcel(paramParcel1);
        }
        a(localt);
        paramParcel2.writeNoException();
        int i4 = 1;
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        Status localStatus;
        if (paramParcel1.readInt() != 0) {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        a(localStatus);
        paramParcel2.writeNoException();
        int i5 = 1;
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
        as localas;
        if (paramParcel1.readInt() != 0) {
          localas = (as)as.CREATOR.createFromParcel(paramParcel1);
        }
        a(localas);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ab
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void Z(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +44 -> 60
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_5
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 53	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 56	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 56	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_3
        //   61: iconst_0
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_2
        //   69: aload 4
        //   71: invokevirtual 56	android/os/Parcel:recycle	()V
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramDataHolder	DataHolder
        //   68	11	2	localObject	Object
        //   3	72	3	localParcel1	Parcel
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      /* Error */
      public void a(Status paramStatus)
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
        //   16: ifnull +45 -> 61
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 60	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 11
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 56	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_2
        //   62: iconst_0
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_3
        //   70: aload 4
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: aload_2
        //   76: invokevirtual 56	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramStatus	Status
        //   3	73	2	localParcel1	Parcel
        //   69	11	3	localObject	Object
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      /* Error */
      public void a(am paramam)
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
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 64	com/google/android/gms/wearable/internal/am:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_3
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 50 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 56	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramam	am
        //   71	11	2	localObject	Object
        //   8	65	3	localParcel1	Parcel
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void a(aq paramaq)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 68	com/google/android/gms/wearable/internal/aq:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 7
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 56	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 56	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramaq	aq
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void a(as paramas)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 72	com/google/android/gms/wearable/internal/as:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 12
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 50 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 53	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 56	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramas	as
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      /* Error */
      public void a(p paramp)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 76	com/google/android/gms/wearable/internal/p:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 56	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 56	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramp	p
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void a(r paramr)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 80	com/google/android/gms/wearable/internal/r:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 50 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 53	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 56	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_3
        //   67: invokevirtual 56	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 56	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramr	r
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public void a(t paramt)
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
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 84	com/google/android/gms/wearable/internal/t:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 10
        //   39: aload 4
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 50 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 53	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_2
        //   73: aload_3
        //   74: invokevirtual 56	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramt	t
        //   72	11	2	localObject	Object
        //   8	66	3	localParcel1	Parcel
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      /* Error */
      public void a(v paramv)
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
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 88	com/google/android/gms/wearable/internal/v:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_4
        //   38: aload 4
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 50 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_2
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 56	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramv	v
        //   71	11	2	localObject	Object
        //   8	65	3	localParcel1	Parcel
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void a(x paramx)
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
        //   16: ifnull +45 -> 61
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 92	com/google/android/gms/wearable/internal/x:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 8
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 56	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_2
        //   62: iconst_0
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_3
        //   70: aload 4
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: aload_2
        //   76: invokevirtual 56	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramx	x
        //   3	73	2	localParcel1	Parcel
        //   69	11	3	localObject	Object
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      /* Error */
      public void a(z paramz)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +45 -> 61
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 96	com/google/android/gms/wearable/internal/z:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/wearable/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 9
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 50 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 53	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 56	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 56	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_3
        //   62: iconst_0
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_2
        //   70: aload 4
        //   72: invokevirtual 56	android/os/Parcel:recycle	()V
        //   75: aload_3
        //   76: invokevirtual 56	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramz	z
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ab
 * JD-Core Version:    0.7.0.1
 */
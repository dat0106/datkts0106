package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

public abstract interface gm
  extends IInterface
{
  public abstract void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(String paramString, LaunchOptions paramLaunchOptions)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, long paramLong)
    throws RemoteException;
  
  public abstract void a(String paramString, byte[] paramArrayOfByte, long paramLong)
    throws RemoteException;
  
  public abstract void a(boolean paramBoolean1, double paramDouble, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void am(String paramString)
    throws RemoteException;
  
  public abstract void an(String paramString)
    throws RemoteException;
  
  public abstract void ao(String paramString)
    throws RemoteException;
  
  public abstract void disconnect()
    throws RemoteException;
  
  public abstract void e(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void eb()
    throws RemoteException;
  
  public abstract void ek()
    throws RemoteException;
  
  public abstract void h(String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements gm
  {
    public static gm H(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        if ((localObject == null) || (!(localObject instanceof gm))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (gm)localObject;
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
      boolean bool1 = false;
      double d1 = 1;
      double d2;
      switch (paramInt1)
      {
      default: 
        d1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        disconnect();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        String str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool1 = d1;
        }
        e(str1, bool1);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        h(paramParcel1.readString(), paramParcel1.readString());
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        ek();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        am(paramParcel1.readString());
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        eb();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        double d4 = paramParcel1.readDouble();
        d2 = paramParcel1.readDouble();
        boolean bool3;
        if (paramParcel1.readInt() == 0) {
          bool3 = false;
        } else {
          bool3 = d1;
        }
        a(d4, d2, bool3);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = d1;
        }
        double d3 = paramParcel1.readDouble();
        if (paramParcel1.readInt() != 0) {
          d2 = d1;
        }
        a(bool2, d3, d2);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        a(paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readLong());
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        an(paramParcel1.readString());
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        ao(paramParcel1.readString());
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        String str2 = paramParcel1.readString();
        LaunchOptions localLaunchOptions;
        if (paramParcel1.readInt() == 0) {
          localLaunchOptions = null;
        } else {
          localLaunchOptions = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(paramParcel1);
        }
        a(str2, localLaunchOptions);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
      }
      return d1;
    }
    
    private static class a
      implements gm
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(double paramDouble1, double paramDouble2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: aload 6
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 6
        //   17: dload_1
        //   18: invokevirtual 37	android/os/Parcel:writeDouble	(D)V
        //   21: aload 6
        //   23: dload_3
        //   24: invokevirtual 37	android/os/Parcel:writeDouble	(D)V
        //   27: iload 5
        //   29: ifeq +32 -> 61
        //   32: aload 6
        //   34: iload 7
        //   36: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/internal/gm$a$a:ko	Landroid/os/IBinder;
        //   43: bipush 7
        //   45: aload 6
        //   47: aconst_null
        //   48: iconst_1
        //   49: invokeinterface 47 5 0
        //   54: pop
        //   55: aload 6
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: iconst_0
        //   62: istore 7
        //   64: goto -32 -> 32
        //   67: astore 7
        //   69: aload 6
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload 7
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramDouble1	double
        //   0	77	3	paramDouble2	double
        //   0	77	5	paramBoolean	boolean
        //   6	64	6	localParcel	Parcel
        //   1	62	7	i	int
        //   67	8	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	55	67	finally
      }
      
      /* Error */
      public void a(String paramString, LaunchOptions paramLaunchOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 29
        //   9: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload_2
        //   19: ifnull +38 -> 57
        //   22: aload 4
        //   24: iconst_1
        //   25: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: aload 4
        //   31: iconst_0
        //   32: invokevirtual 60	com/google/android/gms/cast/LaunchOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/internal/gm$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 13
        //   41: aload 4
        //   43: aconst_null
        //   44: iconst_1
        //   45: invokeinterface 47 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload 4
        //   59: iconst_0
        //   60: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   63: goto -28 -> 35
        //   66: astore_3
        //   67: aload 4
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramString	String
        //   0	74	2	paramLaunchOptions	LaunchOptions
        //   66	7	3	localObject	Object
        //   3	65	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	51	66	finally
        //   57	63	66	finally
      }
      
      public void a(String paramString1, String paramString2, long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeLong(paramLong);
          this.ko.transact(9, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeLong(paramLong);
          this.ko.transact(10, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void a(boolean paramBoolean1, double paramDouble, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 6
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: iload_1
        //   16: ifeq +54 -> 70
        //   19: iload 6
        //   21: istore 7
        //   23: aload 5
        //   25: iload 7
        //   27: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   30: aload 5
        //   32: dload_2
        //   33: invokevirtual 37	android/os/Parcel:writeDouble	(D)V
        //   36: iload 4
        //   38: ifeq +38 -> 76
        //   41: aload 5
        //   43: iload 6
        //   45: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/internal/gm$a$a:ko	Landroid/os/IBinder;
        //   52: bipush 8
        //   54: aload 5
        //   56: aconst_null
        //   57: iconst_1
        //   58: invokeinterface 47 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: iconst_0
        //   71: istore 7
        //   73: goto -50 -> 23
        //   76: iconst_0
        //   77: istore 6
        //   79: goto -38 -> 41
        //   82: astore 6
        //   84: aload 5
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 6
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	a
        //   0	92	1	paramBoolean1	boolean
        //   0	92	2	paramDouble	double
        //   0	92	4	paramBoolean2	boolean
        //   6	79	5	localParcel	Parcel
        //   1	77	6	i	int
        //   82	8	6	localObject	Object
        //   21	51	7	j	int
        // Exception table:
        //   from	to	target	type
        //   8	64	82	finally
      }
      
      public void am(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.ko.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void an(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.ko.transact(11, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void ao(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString);
          this.ko.transact(12, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void disconnect()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.ko.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void e(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: aload_3
        //   8: ldc 29
        //   10: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   13: aload_3
        //   14: aload_1
        //   15: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: iload_2
        //   19: ifeq +28 -> 47
        //   22: aload_3
        //   23: iload 4
        //   25: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   28: aload_0
        //   29: getfield 18	com/google/android/gms/internal/gm$a$a:ko	Landroid/os/IBinder;
        //   32: iconst_2
        //   33: aload_3
        //   34: aconst_null
        //   35: iconst_1
        //   36: invokeinterface 47 5 0
        //   41: pop
        //   42: aload_3
        //   43: invokevirtual 50	android/os/Parcel:recycle	()V
        //   46: return
        //   47: iconst_0
        //   48: istore 4
        //   50: goto -28 -> 22
        //   53: astore 4
        //   55: aload_3
        //   56: invokevirtual 50	android/os/Parcel:recycle	()V
        //   59: aload 4
        //   61: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	this	a
        //   0	62	1	paramString	String
        //   0	62	2	paramBoolean	boolean
        //   6	50	3	localParcel	Parcel
        //   1	48	4	i	int
        //   53	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	42	53	finally
      }
      
      public void eb()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.ko.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void ek()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          this.ko.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void h(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.ko.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gm
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface fv
  extends IInterface
{
  public abstract void a(fw paramfw)
    throws RemoteException;
  
  public abstract void a(fw paramfw, String paramString, fs[] paramArrayOffs)
    throws RemoteException;
  
  public abstract void a(fw paramfw, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(fw paramfw)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements fv
  {
    public static fv A(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if ((localObject == null) || (!(localObject instanceof fv))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (fv)localObject;
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
      boolean bool2 = true;
      switch (paramInt1)
      {
      default: 
        bool2 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        a(fw.a.B(paramParcel1.readStrongBinder()), paramParcel1.readString(), (fs[])paramParcel1.createTypedArray(fs.CREATOR));
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        a(fw.a.B(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        b(fw.a.B(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        fw localfw = fw.a.B(paramParcel1.readStrongBinder());
        boolean bool1;
        if (paramParcel1.readInt() == 0) {
          bool1 = false;
        } else {
          bool1 = bool2;
        }
        a(localfw, bool1);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      }
      return bool2;
    }
    
    private static class a
      implements fv
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(fw paramfw)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/fv$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 48 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 51	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 54	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 54	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramfw	fw
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public void a(fw paramfw, String paramString, fs[] paramArrayOffs)
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
        //   18: ifnull +63 -> 81
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 58	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: iconst_0
        //   46: invokevirtual 62	android/os/Parcel:writeTypedArray	([Landroid/os/Parcelable;I)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/internal/fv$a$a:ko	Landroid/os/IBinder;
        //   53: iconst_1
        //   54: aload 5
        //   56: aload 4
        //   58: iconst_0
        //   59: invokeinterface 48 5 0
        //   64: pop
        //   65: aload 4
        //   67: invokevirtual 51	android/os/Parcel:readException	()V
        //   70: aload 4
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 5
        //   77: invokevirtual 54	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 6
        //   84: goto -55 -> 29
        //   87: astore 6
        //   89: aload 4
        //   91: invokevirtual 54	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 54	android/os/Parcel:recycle	()V
        //   99: aload 6
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramfw	fw
        //   0	102	2	paramString	String
        //   0	102	3	paramArrayOffs	fs[]
        //   8	82	4	localParcel1	Parcel
        //   3	92	5	localParcel2	Parcel
        //   27	56	6	localIBinder	IBinder
        //   87	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	70	87	finally
      }
      
      /* Error */
      public void a(fw paramfw, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore_3
        //   12: aload 4
        //   14: ldc 29
        //   16: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +61 -> 81
        //   23: aload_1
        //   24: invokeinterface 39 1 0
        //   29: astore 6
        //   31: aload 4
        //   33: aload 6
        //   35: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   38: iload_2
        //   39: ifeq +6 -> 45
        //   42: iconst_1
        //   43: istore 5
        //   45: aload 4
        //   47: iload 5
        //   49: invokevirtual 67	android/os/Parcel:writeInt	(I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/internal/fv$a$a:ko	Landroid/os/IBinder;
        //   56: iconst_4
        //   57: aload 4
        //   59: aload_3
        //   60: iconst_0
        //   61: invokeinterface 48 5 0
        //   66: pop
        //   67: aload_3
        //   68: invokevirtual 51	android/os/Parcel:readException	()V
        //   71: aload_3
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: invokevirtual 54	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 6
        //   84: goto -53 -> 31
        //   87: astore 5
        //   89: aload_3
        //   90: invokevirtual 54	android/os/Parcel:recycle	()V
        //   93: aload 4
        //   95: invokevirtual 54	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramfw	fw
        //   0	101	2	paramBoolean	boolean
        //   11	79	3	localParcel1	Parcel
        //   6	88	4	localParcel2	Parcel
        //   1	47	5	i	int
        //   87	12	5	localObject	Object
        //   29	54	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	71	87	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void b(fw paramfw)
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
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/fv$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_3
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 48 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 51	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 54	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 54	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 54	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramfw	fw
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fv
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;

public abstract interface c
  extends IInterface
{
  public abstract d a(d paramd, int paramInt1, int paramInt2, String paramString, int paramInt3)
    throws RemoteException;
  
  public abstract d a(d paramd, int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c bl(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if ((localObject == null) || (!(localObject instanceof c))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (c)localObject;
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
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        Object localObject2 = a(d.a.ag(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject2);
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        d locald = a(d.a.ag(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        IBinder localIBinder;
        if (locald != null) {
          localIBinder = locald.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements c
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public d a(d paramd, int paramInt1, int paramInt2, String paramString, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +88 -> 106
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: iload_2
        //   39: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   42: aload 6
        //   44: iload_3
        //   45: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload 6
        //   57: iload 5
        //   59: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   62: aload_0
        //   63: getfield 18	com/google/android/gms/plus/internal/c$a$a:ko	Landroid/os/IBinder;
        //   66: iconst_1
        //   67: aload 6
        //   69: aload 7
        //   71: iconst_0
        //   72: invokeinterface 55 5 0
        //   77: pop
        //   78: aload 7
        //   80: invokevirtual 58	android/os/Parcel:readException	()V
        //   83: aload 7
        //   85: invokevirtual 61	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   88: invokestatic 67	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   91: astore 8
        //   93: aload 7
        //   95: invokevirtual 70	android/os/Parcel:recycle	()V
        //   98: aload 6
        //   100: invokevirtual 70	android/os/Parcel:recycle	()V
        //   103: aload 8
        //   105: areturn
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -80 -> 29
        //   112: astore 8
        //   114: aload 7
        //   116: invokevirtual 70	android/os/Parcel:recycle	()V
        //   119: aload 6
        //   121: invokevirtual 70	android/os/Parcel:recycle	()V
        //   124: aload 8
        //   126: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	127	0	this	a
        //   0	127	1	paramd	d
        //   0	127	2	paramInt1	int
        //   0	127	3	paramInt2	int
        //   0	127	4	paramString	String
        //   0	127	5	paramInt3	int
        //   3	117	6	localParcel1	Parcel
        //   8	107	7	localParcel2	Parcel
        //   27	81	8	localObject1	Object
        //   112	13	8	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	93	112	finally
      }
      
      /* Error */
      public d a(d paramd, int paramInt1, int paramInt2, String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 7
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 7
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +88 -> 106
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 8
        //   29: aload 7
        //   31: aload 8
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 7
        //   38: iload_2
        //   39: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   42: aload 7
        //   44: iload_3
        //   45: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   48: aload 7
        //   50: aload 4
        //   52: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload 7
        //   57: aload 5
        //   59: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload_0
        //   63: getfield 18	com/google/android/gms/plus/internal/c$a$a:ko	Landroid/os/IBinder;
        //   66: iconst_2
        //   67: aload 7
        //   69: aload 6
        //   71: iconst_0
        //   72: invokeinterface 55 5 0
        //   77: pop
        //   78: aload 6
        //   80: invokevirtual 58	android/os/Parcel:readException	()V
        //   83: aload 6
        //   85: invokevirtual 61	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   88: invokestatic 67	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
        //   91: astore 8
        //   93: aload 6
        //   95: invokevirtual 70	android/os/Parcel:recycle	()V
        //   98: aload 7
        //   100: invokevirtual 70	android/os/Parcel:recycle	()V
        //   103: aload 8
        //   105: areturn
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -80 -> 29
        //   112: astore 8
        //   114: aload 6
        //   116: invokevirtual 70	android/os/Parcel:recycle	()V
        //   119: aload 7
        //   121: invokevirtual 70	android/os/Parcel:recycle	()V
        //   124: aload 8
        //   126: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	127	0	this	a
        //   0	127	1	paramd	d
        //   0	127	2	paramInt1	int
        //   0	127	3	paramInt2	int
        //   0	127	4	paramString1	String
        //   0	127	5	paramString2	String
        //   8	107	6	localParcel1	Parcel
        //   3	117	7	localParcel2	Parcel
        //   27	81	8	localObject1	Object
        //   112	13	8	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	93	112	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.c
 * JD-Core Version:    0.7.0.1
 */
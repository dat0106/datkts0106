package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IGamesSignInService
  extends IInterface
{
  public abstract void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
    throws RemoteException;
  
  public abstract void b(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void b(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract String bc(String paramString)
    throws RemoteException;
  
  public abstract String bd(String paramString)
    throws RemoteException;
  
  public abstract String f(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void o(String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IGamesSignInService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool1 = true;
      String str1;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        str1 = bc(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        str1 = bd(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        b(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        b(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        String str3 = paramParcel1.readString();
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        String str2 = f(str3, bool2);
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        break;
      case 9001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
        o(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IGamesSignInService");
      }
      return bool1;
    }
    
    private static class Proxy
      implements IGamesSignInService
    {
      private IBinder ko;
      
      /* Error */
      public void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 5006
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 48 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 52	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 55	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 55	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 55	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 5005
        //   62: aload 6
        //   64: aload 5
        //   66: iconst_0
        //   67: invokeinterface 48 5 0
        //   72: pop
        //   73: aload 5
        //   75: invokevirtual 52	android/os/Parcel:readException	()V
        //   78: aload 5
        //   80: invokevirtual 55	android/os/Parcel:recycle	()V
        //   83: aload 6
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 5
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramString2	String
        //   0	110	4	paramString3	String
        //   8	90	5	localParcel1	Parcel
        //   3	100	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 61	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 5004
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 48 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 52	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 55	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramString2	String
        //   0	110	4	paramArrayOfString	String[]
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +78 -> 96
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 61	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   55: aload 6
        //   57: aload 5
        //   59: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload_0
        //   63: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   66: sipush 5003
        //   69: aload 6
        //   71: aload 7
        //   73: iconst_0
        //   74: invokeinterface 48 5 0
        //   79: pop
        //   80: aload 7
        //   82: invokevirtual 52	android/os/Parcel:readException	()V
        //   85: aload 7
        //   87: invokevirtual 55	android/os/Parcel:recycle	()V
        //   90: aload 6
        //   92: invokevirtual 55	android/os/Parcel:recycle	()V
        //   95: return
        //   96: aconst_null
        //   97: astore 8
        //   99: goto -70 -> 29
        //   102: astore 8
        //   104: aload 7
        //   106: invokevirtual 55	android/os/Parcel:recycle	()V
        //   109: aload 6
        //   111: invokevirtual 55	android/os/Parcel:recycle	()V
        //   114: aload 8
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	Proxy
        //   0	117	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	117	2	paramString1	String
        //   0	117	3	paramString2	String
        //   0	117	4	paramArrayOfString	String[]
        //   0	117	5	paramString3	String
        //   3	107	6	localParcel1	Parcel
        //   8	97	7	localParcel2	Parcel
        //   27	71	8	localIBinder	IBinder
        //   102	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	85	102	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void b(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 5007
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 48 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 52	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 55	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramString2	String
        //   0	110	4	paramString3	String
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void b(IGamesSignInCallbacks paramIGamesSignInCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 21	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 23
        //   14: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 33 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 37	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 61	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 42	com/google/android/gms/games/internal/IGamesSignInService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 5008
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 48 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 52	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 55	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesSignInCallbacks	IGamesSignInCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramString2	String
        //   0	110	4	paramArrayOfString	String[]
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      public String bc(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
          localParcel2.writeString(paramString);
          this.ko.transact(5001, localParcel2, localParcel1, 0);
          localParcel1.readException();
          String str = localParcel1.readString();
          return str;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String bd(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
          localParcel1.writeString(paramString);
          this.ko.transact(5002, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String f(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
          localParcel2.writeString(paramString);
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(5009, localParcel2, localParcel1, 0);
          localParcel1.readException();
          String str = localParcel1.readString();
          return str;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void o(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
          localParcel2.writeString(paramString1);
          localParcel2.writeString(paramString2);
          this.ko.transact(9001, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IGamesSignInService
 * JD-Core Version:    0.7.0.1
 */
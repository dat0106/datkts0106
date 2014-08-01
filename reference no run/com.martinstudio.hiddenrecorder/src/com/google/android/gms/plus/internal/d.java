package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.ht;
import com.google.android.gms.internal.if;
import com.google.android.gms.internal.ig;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract hh a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws RemoteException;
  
  public abstract void a(if paramif)
    throws RemoteException;
  
  public abstract void a(b paramb)
    throws RemoteException;
  
  public abstract void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void a(b paramb, Uri paramUri, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(b paramb, if paramif)
    throws RemoteException;
  
  public abstract void a(b paramb, String paramString)
    throws RemoteException;
  
  public abstract void a(b paramb, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void a(b paramb, List<String> paramList)
    throws RemoteException;
  
  public abstract void a(String paramString, hs paramhs1, hs paramhs2)
    throws RemoteException;
  
  public abstract void b(b paramb)
    throws RemoteException;
  
  public abstract void b(b paramb, String paramString)
    throws RemoteException;
  
  public abstract void c(b paramb, String paramString)
    throws RemoteException;
  
  public abstract void clearDefaultAccount()
    throws RemoteException;
  
  public abstract void d(b paramb, String paramString)
    throws RemoteException;
  
  public abstract void e(b paramb, String paramString)
    throws RemoteException;
  
  public abstract String getAccountName()
    throws RemoteException;
  
  public abstract String jP()
    throws RemoteException;
  
  public abstract boolean jQ()
    throws RemoteException;
  
  public abstract String jR()
    throws RemoteException;
  
  public abstract void removeMoment(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements d
  {
    public static d bm(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        if ((localObject == null) || (!(localObject instanceof d))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (d)localObject;
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
      Object localObject4;
      Object localObject3;
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = if.CREATOR.L(paramParcel1);
        }
        a((if)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject1 = getAccountName();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject1);
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        clearDefaultAccount();
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bk(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject1 = b.a.bk(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((b)localObject1, (Uri)localObject4, localBundle);
        paramParcel2.writeNoException();
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject1 = b.a.bk(paramParcel1.readStrongBinder());
        int k = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        a((b)localObject1, k, str, (Uri)localObject4, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject3 = a(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localObject1 = ((hh)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder((IBinder)localObject1);
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        removeMoment(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        c(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        b(b.a.bk(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        a(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        break;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        d(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject1 = jP();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject1);
        break;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        int j = jQ();
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 43: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject2 = jR();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 44: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        e(b.a.bk(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 45: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject3 = b.a.bk(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject2 = if.CREATOR.L(paramParcel1);
        }
        a((b)localObject3, (if)localObject2);
        paramParcel2.writeNoException();
        break;
      case 46: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = hs.CREATOR.D(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject2 = hs.CREATOR.D(paramParcel1);
        }
        a((String)localObject3, (hs)localObject4, (hs)localObject2);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
      }
      return i;
    }
    
    private static class a
      implements d
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public hh a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString)
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
        //   18: ifnull +89 -> 107
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
        //   50: iload 4
        //   52: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   55: aload 6
        //   57: aload 5
        //   59: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   62: aload_0
        //   63: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   66: bipush 16
        //   68: aload 6
        //   70: aload 7
        //   72: iconst_0
        //   73: invokeinterface 55 5 0
        //   78: pop
        //   79: aload 7
        //   81: invokevirtual 58	android/os/Parcel:readException	()V
        //   84: aload 7
        //   86: invokevirtual 61	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   89: invokestatic 67	com/google/android/gms/internal/hh$a:J	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/hh;
        //   92: astore 8
        //   94: aload 7
        //   96: invokevirtual 70	android/os/Parcel:recycle	()V
        //   99: aload 6
        //   101: invokevirtual 70	android/os/Parcel:recycle	()V
        //   104: aload 8
        //   106: areturn
        //   107: aconst_null
        //   108: astore 8
        //   110: goto -81 -> 29
        //   113: astore 8
        //   115: aload 7
        //   117: invokevirtual 70	android/os/Parcel:recycle	()V
        //   120: aload 6
        //   122: invokevirtual 70	android/os/Parcel:recycle	()V
        //   125: aload 8
        //   127: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	a
        //   0	128	1	paramb	b
        //   0	128	2	paramInt1	int
        //   0	128	3	paramInt2	int
        //   0	128	4	paramInt3	int
        //   0	128	5	paramString	String
        //   3	118	6	localParcel1	Parcel
        //   8	108	7	localParcel2	Parcel
        //   27	82	8	localObject1	Object
        //   113	13	8	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	94	113	finally
      }
      
      /* Error */
      public void a(if paramif)
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
        //   16: ifnull +44 -> 60
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 77	com/google/android/gms/internal/if:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_4
        //   35: aload_2
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 55 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 58	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 70	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 70	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_2
        //   61: iconst_0
        //   62: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_3
        //   69: aload 4
        //   71: invokevirtual 70	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 70	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramif	if
        //   3	72	2	localParcel1	Parcel
        //   68	11	3	localObject	Object
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      /* Error */
      public void a(b paramb)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 8
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 55 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 58	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 70	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 70	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 70	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 70	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramb	b
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 8
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 8
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +96 -> 114
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 9
        //   29: aload 8
        //   31: aload 9
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 8
        //   38: iload_2
        //   39: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   42: aload 8
        //   44: aload_3
        //   45: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 4
        //   50: ifnull +70 -> 120
        //   53: aload 8
        //   55: iconst_1
        //   56: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   59: aload 4
        //   61: aload 8
        //   63: iconst_0
        //   64: invokevirtual 82	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
        //   67: aload 8
        //   69: aload 5
        //   71: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   74: aload 8
        //   76: aload 6
        //   78: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   81: aload_0
        //   82: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   85: bipush 14
        //   87: aload 8
        //   89: aload 7
        //   91: iconst_0
        //   92: invokeinterface 55 5 0
        //   97: pop
        //   98: aload 7
        //   100: invokevirtual 58	android/os/Parcel:readException	()V
        //   103: aload 7
        //   105: invokevirtual 70	android/os/Parcel:recycle	()V
        //   108: aload 8
        //   110: invokevirtual 70	android/os/Parcel:recycle	()V
        //   113: return
        //   114: aconst_null
        //   115: astore 9
        //   117: goto -88 -> 29
        //   120: aload 8
        //   122: iconst_0
        //   123: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   126: goto -59 -> 67
        //   129: astore 9
        //   131: aload 7
        //   133: invokevirtual 70	android/os/Parcel:recycle	()V
        //   136: aload 8
        //   138: invokevirtual 70	android/os/Parcel:recycle	()V
        //   141: aload 9
        //   143: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	144	0	this	a
        //   0	144	1	paramb	b
        //   0	144	2	paramInt	int
        //   0	144	3	paramString1	String
        //   0	144	4	paramUri	Uri
        //   0	144	5	paramString2	String
        //   0	144	6	paramString3	String
        //   8	124	7	localParcel1	Parcel
        //   3	134	8	localParcel2	Parcel
        //   27	89	9	localIBinder	IBinder
        //   129	13	9	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	103	129	finally
        //   120	126	129	finally
      }
      
      public void a(b paramb, Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label133:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            IBinder localIBinder;
            if (paramb != null)
            {
              localIBinder = paramb.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              if (paramUri != null)
              {
                localParcel1.writeInt(1);
                paramUri.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label133;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
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
      public void a(b paramb, if paramif)
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
        //   17: ifnull +65 -> 82
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_2
        //   36: ifnull +52 -> 88
        //   39: aload 4
        //   41: iconst_1
        //   42: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   45: aload_2
        //   46: aload 4
        //   48: iconst_0
        //   49: invokevirtual 77	com/google/android/gms/internal/if:writeToParcel	(Landroid/os/Parcel;I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   56: bipush 45
        //   58: aload 4
        //   60: aload_3
        //   61: iconst_0
        //   62: invokeinterface 55 5 0
        //   67: pop
        //   68: aload_3
        //   69: invokevirtual 58	android/os/Parcel:readException	()V
        //   72: aload_3
        //   73: invokevirtual 70	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 70	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 5
        //   85: goto -57 -> 28
        //   88: aload 4
        //   90: iconst_0
        //   91: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   94: goto -42 -> 52
        //   97: astore 5
        //   99: aload_3
        //   100: invokevirtual 70	android/os/Parcel:recycle	()V
        //   103: aload 4
        //   105: invokevirtual 70	android/os/Parcel:recycle	()V
        //   108: aload 5
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	a
        //   0	111	1	paramb	b
        //   0	111	2	paramif	if
        //   8	92	3	localParcel1	Parcel
        //   3	101	4	localParcel2	Parcel
        //   26	58	5	localIBinder	IBinder
        //   97	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	72	97	finally
        //   88	94	97	finally
      }
      
      /* Error */
      public void a(b paramb, String paramString)
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
        //   17: ifnull +53 -> 70
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   45: iconst_1
        //   46: aload 4
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 55 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 58	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 70	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: invokevirtual 70	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -45 -> 28
        //   76: astore 5
        //   78: aload_3
        //   79: invokevirtual 70	android/os/Parcel:recycle	()V
        //   82: aload 4
        //   84: invokevirtual 70	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramb	b
        //   0	90	2	paramString	String
        //   8	71	3	localParcel1	Parcel
        //   3	80	4	localParcel2	Parcel
        //   26	46	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void a(b paramb, String paramString1, String paramString2)
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
        //   18: ifnull +62 -> 80
        //   21: aload_1
        //   22: invokeinterface 39 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   52: iconst_2
        //   53: aload 5
        //   55: aload 4
        //   57: iconst_0
        //   58: invokeinterface 55 5 0
        //   63: pop
        //   64: aload 4
        //   66: invokevirtual 58	android/os/Parcel:readException	()V
        //   69: aload 4
        //   71: invokevirtual 70	android/os/Parcel:recycle	()V
        //   74: aload 5
        //   76: invokevirtual 70	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aconst_null
        //   81: astore 6
        //   83: goto -54 -> 29
        //   86: astore 6
        //   88: aload 4
        //   90: invokevirtual 70	android/os/Parcel:recycle	()V
        //   93: aload 5
        //   95: invokevirtual 70	android/os/Parcel:recycle	()V
        //   98: aload 6
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramb	b
        //   0	101	2	paramString1	String
        //   0	101	3	paramString2	String
        //   8	81	4	localParcel1	Parcel
        //   3	91	5	localParcel2	Parcel
        //   27	55	6	localIBinder	IBinder
        //   86	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	69	86	finally
      }
      
      /* Error */
      public void a(b paramb, List<String> paramList)
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
        //   17: ifnull +54 -> 71
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 94	android/os/Parcel:writeStringList	(Ljava/util/List;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   45: bipush 34
        //   47: aload 4
        //   49: aload_3
        //   50: iconst_0
        //   51: invokeinterface 55 5 0
        //   56: pop
        //   57: aload_3
        //   58: invokevirtual 58	android/os/Parcel:readException	()V
        //   61: aload_3
        //   62: invokevirtual 70	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: invokevirtual 70	android/os/Parcel:recycle	()V
        //   70: return
        //   71: aconst_null
        //   72: astore 5
        //   74: goto -46 -> 28
        //   77: astore 5
        //   79: aload_3
        //   80: invokevirtual 70	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 70	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramb	b
        //   0	91	2	paramList	List<String>
        //   8	72	3	localParcel1	Parcel
        //   3	81	4	localParcel2	Parcel
        //   26	47	5	localIBinder	IBinder
        //   77	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	61	77	finally
      }
      
      public void a(String paramString, hs paramhs1, hs paramhs2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            localParcel1.writeString(paramString);
            if (paramhs1 != null)
            {
              localParcel1.writeInt(1);
              paramhs1.writeToParcel(localParcel1, 0);
              if (paramhs2 != null)
              {
                localParcel1.writeInt(1);
                paramhs2.writeToParcel(localParcel1, 0);
                this.ko.transact(46, localParcel1, localParcel2, 0);
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
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void b(b paramb)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 19
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 55 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 58	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 70	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 70	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 70	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 70	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramb	b
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void b(b paramb, String paramString)
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
        //   16: ifnull +52 -> 68
        //   19: aload_1
        //   20: invokeinterface 39 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   42: iconst_3
        //   43: aload_3
        //   44: aload 4
        //   46: iconst_0
        //   47: invokeinterface 55 5 0
        //   52: pop
        //   53: aload 4
        //   55: invokevirtual 58	android/os/Parcel:readException	()V
        //   58: aload 4
        //   60: invokevirtual 70	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 70	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aconst_null
        //   69: astore 5
        //   71: goto -44 -> 27
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 70	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 70	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramb	b
        //   0	88	2	paramString	String
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   25	45	5	localIBinder	IBinder
        //   74	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	58	74	finally
      }
      
      /* Error */
      public void c(b paramb, String paramString)
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
        //   17: ifnull +54 -> 71
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   45: bipush 18
        //   47: aload 4
        //   49: aload_3
        //   50: iconst_0
        //   51: invokeinterface 55 5 0
        //   56: pop
        //   57: aload_3
        //   58: invokevirtual 58	android/os/Parcel:readException	()V
        //   61: aload_3
        //   62: invokevirtual 70	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: invokevirtual 70	android/os/Parcel:recycle	()V
        //   70: return
        //   71: aconst_null
        //   72: astore 5
        //   74: goto -46 -> 28
        //   77: astore 5
        //   79: aload_3
        //   80: invokevirtual 70	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 70	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramb	b
        //   0	91	2	paramString	String
        //   8	72	3	localParcel1	Parcel
        //   3	81	4	localParcel2	Parcel
        //   26	47	5	localIBinder	IBinder
        //   77	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	61	77	finally
      }
      
      public void clearDefaultAccount()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
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
      
      /* Error */
      public void d(b paramb, String paramString)
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
        //   16: ifnull +53 -> 69
        //   19: aload_1
        //   20: invokeinterface 39 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   42: bipush 40
        //   44: aload_3
        //   45: aload 4
        //   47: iconst_0
        //   48: invokeinterface 55 5 0
        //   53: pop
        //   54: aload 4
        //   56: invokevirtual 58	android/os/Parcel:readException	()V
        //   59: aload 4
        //   61: invokevirtual 70	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 70	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aconst_null
        //   70: astore 5
        //   72: goto -45 -> 27
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 70	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 70	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramb	b
        //   0	89	2	paramString	String
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   25	46	5	localIBinder	IBinder
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	59	75	finally
      }
      
      /* Error */
      public void e(b paramb, String paramString)
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
        //   16: ifnull +53 -> 69
        //   19: aload_1
        //   20: invokeinterface 39 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/plus/internal/d$a$a:ko	Landroid/os/IBinder;
        //   42: bipush 44
        //   44: aload_3
        //   45: aload 4
        //   47: iconst_0
        //   48: invokeinterface 55 5 0
        //   53: pop
        //   54: aload 4
        //   56: invokevirtual 58	android/os/Parcel:readException	()V
        //   59: aload 4
        //   61: invokevirtual 70	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 70	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aconst_null
        //   70: astore 5
        //   72: goto -45 -> 27
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 70	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 70	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramb	b
        //   0	89	2	paramString	String
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   25	46	5	localIBinder	IBinder
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	59	75	finally
      }
      
      public String getAccountName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.ko.transact(5, localParcel1, localParcel2, 0);
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
      
      public String jP()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.ko.transact(41, localParcel1, localParcel2, 0);
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
      
      public boolean jQ()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.ko.transact(42, localParcel2, localParcel1, 0);
          localParcel1.readException();
          int i = localParcel1.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String jR()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          this.ko.transact(43, localParcel1, localParcel2, 0);
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
      
      public void removeMoment(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
          localParcel2.writeString(paramString);
          this.ko.transact(17, localParcel2, localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.plus.internal.d
 * JD-Core Version:    0.7.0.1
 */
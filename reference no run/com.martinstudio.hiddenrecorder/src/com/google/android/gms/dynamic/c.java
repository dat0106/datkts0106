package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface c
  extends IInterface
{
  public abstract void c(d paramd)
    throws RemoteException;
  
  public abstract void d(d paramd)
    throws RemoteException;
  
  public abstract d gD()
    throws RemoteException;
  
  public abstract c gE()
    throws RemoteException;
  
  public abstract d gF()
    throws RemoteException;
  
  public abstract c gG()
    throws RemoteException;
  
  public abstract Bundle getArguments()
    throws RemoteException;
  
  public abstract int getId()
    throws RemoteException;
  
  public abstract boolean getRetainInstance()
    throws RemoteException;
  
  public abstract String getTag()
    throws RemoteException;
  
  public abstract int getTargetRequestCode()
    throws RemoteException;
  
  public abstract boolean getUserVisibleHint()
    throws RemoteException;
  
  public abstract d getView()
    throws RemoteException;
  
  public abstract boolean isAdded()
    throws RemoteException;
  
  public abstract boolean isDetached()
    throws RemoteException;
  
  public abstract boolean isHidden()
    throws RemoteException;
  
  public abstract boolean isInLayout()
    throws RemoteException;
  
  public abstract boolean isRemoving()
    throws RemoteException;
  
  public abstract boolean isResumed()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void setHasOptionsMenu(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMenuVisibility(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRetainInstance(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setUserVisibleHint(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void startActivity(Intent paramIntent)
    throws RemoteException;
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public static c af(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
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
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      IBinder localIBinder1 = null;
      int i = 0;
      d locald1 = 1;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int m;
      d locald2;
      boolean bool2;
      Intent localIntent;
      switch (paramInt1)
      {
      default: 
        locald1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = gD();
        paramParcel2.writeNoException();
        if (localObject1 != null) {
          localIBinder1 = ((d)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = getArguments();
        paramParcel2.writeNoException();
        if (localObject1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(locald1);
          ((Bundle)localObject1).writeToParcel(paramParcel2, locald1);
        }
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int j = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject2 = gE();
        paramParcel2.writeNoException();
        if (localObject2 != null) {
          localIBinder1 = ((c)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject2 = gF();
        paramParcel2.writeNoException();
        if (localObject2 != null) {
          localIBinder1 = ((d)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        int k = getRetainInstance();
        paramParcel2.writeNoException();
        if (k == 0) {
          k = 0;
        } else {
          k = locald1;
        }
        paramParcel2.writeInt(k);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject3 = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject3);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject3 = gG();
        paramParcel2.writeNoException();
        if (localObject3 != null) {
          localIBinder1 = ((c)localObject3).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        m = getTargetRequestCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(m);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bool1 = getUserVisibleHint();
        paramParcel2.writeNoException();
        if (bool1) {
          m = locald1;
        }
        paramParcel2.writeInt(m);
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        locald2 = getView();
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (locald2 != null) {
          localIBinder2 = locald2.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isAdded();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isDetached();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isHidden();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isInLayout();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isRemoving();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isResumed();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool2 = isVisible();
        paramParcel2.writeNoException();
        if (bool2) {
          locald2 = locald1;
        }
        paramParcel2.writeInt(locald2);
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        c(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          locald2 = locald1;
        }
        setHasOptionsMenu(locald2);
        paramParcel2.writeNoException();
        break;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          locald2 = locald1;
        }
        setMenuVisibility(locald2);
        paramParcel2.writeNoException();
        break;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          locald2 = locald1;
        }
        setRetainInstance(locald2);
        paramParcel2.writeNoException();
        break;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          locald2 = locald1;
        }
        setUserVisibleHint(locald2);
        paramParcel2.writeNoException();
        break;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        startActivity(localIntent);
        paramParcel2.writeNoException();
        break;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0) {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        }
        startActivityForResult(localIntent, paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        d(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
      }
      return locald1;
    }
    
    private static class a
      implements c
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void c(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/dynamic/c$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 20
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramd	d
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void d(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/dynamic/c$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 27
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramd	d
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public d gD()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public c gE()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          c localc = c.a.af(localParcel2.readStrongBinder());
          return localc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public d gF()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(6, localParcel2, localParcel1, 0);
          localParcel1.readException();
          d locald = d.a.ag(localParcel1.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public c gG()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          c localc = c.a.af(localParcel2.readStrongBinder());
          return localc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public Bundle getArguments()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/dynamic/c$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_3
        //   19: aload_2
        //   20: aload_1
        //   21: iconst_0
        //   22: invokeinterface 49 5 0
        //   27: pop
        //   28: aload_1
        //   29: invokevirtual 52	android/os/Parcel:readException	()V
        //   32: aload_1
        //   33: invokevirtual 81	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 87	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_1
        //   43: invokeinterface 93 2 0
        //   48: checkcast 83	android/os/Bundle
        //   51: astore_3
        //   52: aload_1
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 55	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: areturn
        //   62: aconst_null
        //   63: astore_3
        //   64: goto -12 -> 52
        //   67: astore_3
        //   68: aload_1
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   7	62	1	localParcel1	Parcel
        //   3	70	2	localParcel2	Parcel
        //   51	13	3	localBundle	Bundle
        //   67	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public int getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean getRetainInstance()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getTag()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(8, localParcel2, localParcel1, 0);
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
      
      public int getTargetRequestCode()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(10, localParcel2, localParcel1, 0);
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
      
      public boolean getUserVisibleHint()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(11, localParcel2, localParcel1, 0);
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
      
      public d getView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          d locald = d.a.ag(localParcel2.readStrongBinder());
          return locald;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isAdded()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isDetached()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isHidden()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(15, localParcel2, localParcel1, 0);
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
      
      public boolean isInLayout()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(16, localParcel2, localParcel1, 0);
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
      
      public boolean isRemoving()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isResumed()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isVisible()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.ko.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setHasOptionsMenu(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setMenuVisibility(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setRetainInstance(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(23, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setUserVisibleHint(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(24, localParcel2, localParcel1, 0);
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
      public void startActivity(Intent paramIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 117	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 128	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/dynamic/c$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 25
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 49 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 52	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 55	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 117	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramIntent	Intent
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void startActivityForResult(Intent paramIntent, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +55 -> 73
        //   21: aload 4
        //   23: iconst_1
        //   24: invokevirtual 117	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 4
        //   30: iconst_0
        //   31: invokevirtual 128	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 4
        //   36: iload_2
        //   37: invokevirtual 117	android/os/Parcel:writeInt	(I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/dynamic/c$a$a:ko	Landroid/os/IBinder;
        //   44: bipush 26
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 49 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 52	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 55	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aload 4
        //   75: iconst_0
        //   76: invokevirtual 117	android/os/Parcel:writeInt	(I)V
        //   79: goto -45 -> 34
        //   82: astore_3
        //   83: aload 5
        //   85: invokevirtual 55	android/os/Parcel:recycle	()V
        //   88: aload 4
        //   90: invokevirtual 55	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramIntent	Intent
        //   0	95	2	paramInt	int
        //   82	12	3	localObject	Object
        //   3	86	4	localParcel1	Parcel
        //   8	76	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	62	82	finally
        //   73	79	82	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.c
 * JD-Core Version:    0.7.0.1
 */
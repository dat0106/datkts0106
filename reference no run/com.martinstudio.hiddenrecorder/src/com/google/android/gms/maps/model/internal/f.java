package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;

public abstract interface f
  extends IInterface
{
  public abstract float getAlpha()
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
  
  public abstract LatLng getPosition()
    throws RemoteException;
  
  public abstract float getRotation()
    throws RemoteException;
  
  public abstract String getSnippet()
    throws RemoteException;
  
  public abstract String getTitle()
    throws RemoteException;
  
  public abstract boolean h(f paramf)
    throws RemoteException;
  
  public abstract int hashCodeRemote()
    throws RemoteException;
  
  public abstract void hideInfoWindow()
    throws RemoteException;
  
  public abstract boolean isDraggable()
    throws RemoteException;
  
  public abstract boolean isFlat()
    throws RemoteException;
  
  public abstract boolean isInfoWindowShown()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void m(d paramd)
    throws RemoteException;
  
  public abstract void remove()
    throws RemoteException;
  
  public abstract void setAlpha(float paramFloat)
    throws RemoteException;
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract void setDraggable(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setFlat(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
    throws RemoteException;
  
  public abstract void setPosition(LatLng paramLatLng)
    throws RemoteException;
  
  public abstract void setRotation(float paramFloat)
    throws RemoteException;
  
  public abstract void setSnippet(String paramString)
    throws RemoteException;
  
  public abstract void setTitle(String paramString)
    throws RemoteException;
  
  public abstract void setVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void showInfoWindow()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements f
  {
    public static f bc(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if ((localObject == null) || (!(localObject instanceof f))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (f)localObject;
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
      int i = 0;
      Object localObject1 = 1;
      Object localObject2;
      boolean bool;
      int j;
      float f;
      switch (paramInt1)
      {
      default: 
        localObject1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        remove();
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        localObject2 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        setPosition((LatLng)localObject2);
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        localObject2 = getPosition();
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((LatLng)localObject2).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setTitle(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        localObject2 = getTitle();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setSnippet(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        localObject2 = getSnippet();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject2 = localObject1;
        }
        setDraggable(localObject2);
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        bool = isDraggable();
        paramParcel2.writeNoException();
        if (bool) {
          localObject2 = localObject1;
        }
        paramParcel2.writeInt(localObject2);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        showInfoWindow();
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        hideInfoWindow();
        paramParcel2.writeNoException();
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        bool = isInfoWindowShown();
        paramParcel2.writeNoException();
        if (bool) {
          localObject2 = localObject1;
        }
        paramParcel2.writeInt(localObject2);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          localObject2 = localObject1;
        }
        setVisible(localObject2);
        paramParcel2.writeNoException();
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        bool = isVisible();
        paramParcel2.writeNoException();
        if (bool) {
          localObject2 = localObject1;
        }
        paramParcel2.writeInt(localObject2);
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        bool = h(bc(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {
          localObject2 = localObject1;
        }
        paramParcel2.writeInt(localObject2);
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        j = hashCodeRemote();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        m(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setAnchor(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (paramParcel1.readInt() != 0) {
          j = localObject1;
        }
        setFlat(j);
        paramParcel2.writeNoException();
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        bool = isFlat();
        paramParcel2.writeNoException();
        if (bool) {
          j = localObject1;
        }
        paramParcel2.writeInt(j);
        break;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setRotation(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        f = getRotation();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        break;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setInfoWindowAnchor(paramParcel1.readFloat(), paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        setAlpha(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        break;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        f = getAlpha();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
      }
      return localObject1;
    }
    
    private static class a
      implements f
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
      
      public float getAlpha()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getId()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(2, localParcel2, localParcel1, 0);
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
      
      /* Error */
      public LatLng getPosition()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/maps/model/internal/f$a$a:ko	Landroid/os/IBinder;
        //   18: iconst_4
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokeinterface 42 5 0
        //   27: pop
        //   28: aload_2
        //   29: invokevirtual 45	android/os/Parcel:readException	()V
        //   32: aload_2
        //   33: invokevirtual 62	android/os/Parcel:readInt	()I
        //   36: ifeq +23 -> 59
        //   39: getstatic 68	com/google/android/gms/maps/model/LatLng:CREATOR	Lcom/google/android/gms/maps/model/LatLngCreator;
        //   42: aload_2
        //   43: invokevirtual 74	com/google/android/gms/maps/model/LatLngCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/LatLng;
        //   46: astore_3
        //   47: aload_3
        //   48: astore_3
        //   49: aload_2
        //   50: invokevirtual 51	android/os/Parcel:recycle	()V
        //   53: aload_1
        //   54: invokevirtual 51	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: areturn
        //   59: aconst_null
        //   60: astore_3
        //   61: goto -12 -> 49
        //   64: astore_3
        //   65: aload_2
        //   66: invokevirtual 51	android/os/Parcel:recycle	()V
        //   69: aload_1
        //   70: invokevirtual 51	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   3	67	1	localParcel1	Parcel
        //   7	59	2	localParcel2	Parcel
        //   46	15	3	localLatLng	LatLng
        //   64	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
      }
      
      public float getRotation()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(23, localParcel2, localParcel1, 0);
          localParcel1.readException();
          float f = localParcel1.readFloat();
          return f;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public String getSnippet()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(8, localParcel1, localParcel2, 0);
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
      
      public String getTitle()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(6, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public boolean h(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_2
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: aload_2
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +61 -> 79
        //   21: aload_1
        //   22: invokeinterface 81 1 0
        //   27: astore 5
        //   29: aload_2
        //   30: aload 5
        //   32: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/f$a$a:ko	Landroid/os/IBinder;
        //   39: bipush 16
        //   41: aload_2
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 42 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 45	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 62	android/os/Parcel:readInt	()I
        //   58: istore 5
        //   60: iload 5
        //   62: ifeq +6 -> 68
        //   65: iconst_1
        //   66: istore 4
        //   68: aload_3
        //   69: invokevirtual 51	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 51	android/os/Parcel:recycle	()V
        //   76: iload 4
        //   78: ireturn
        //   79: aconst_null
        //   80: astore 5
        //   82: goto -53 -> 29
        //   85: astore 4
        //   87: aload_3
        //   88: invokevirtual 51	android/os/Parcel:recycle	()V
        //   91: aload_2
        //   92: invokevirtual 51	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	a
        //   0	98	1	paramf	f
        //   6	86	2	localParcel1	Parcel
        //   10	78	3	localParcel2	Parcel
        //   1	76	4	bool	boolean
        //   85	11	4	localObject1	Object
        //   27	4	5	localIBinder	IBinder
        //   58	3	5	i	int
        //   80	1	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   11	60	85	finally
      }
      
      public int hashCodeRemote()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(17, localParcel1, localParcel2, 0);
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
      
      public void hideInfoWindow()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(12, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public boolean isDraggable()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(10, localParcel1, localParcel2, 0);
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
      
      public boolean isFlat()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(21, localParcel1, localParcel2, 0);
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
      
      public boolean isInfoWindowShown()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
      
      public boolean isVisible()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(15, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public void m(d paramd)
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
        //   19: invokeinterface 96 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/model/internal/f$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 18
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 42 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 45	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 51	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 51	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 51	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 51	android/os/Parcel:recycle	()V
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
      
      public void remove()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setAlpha(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel1.writeFloat(paramFloat);
          this.ko.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setAnchor(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel1.writeFloat(paramFloat1);
          localParcel1.writeFloat(paramFloat2);
          this.ko.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setDraggable(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setFlat(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel2.writeFloat(paramFloat1);
          localParcel2.writeFloat(paramFloat2);
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
      public void setPosition(LatLng paramLatLng)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 32
        //   13: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 110	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 118	com/google/android/gms/maps/model/LatLng:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/maps/model/internal/f$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_3
        //   38: aload 4
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 42 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 45	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 51	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 51	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 110	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 51	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 51	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramLatLng	LatLng
        //   8	65	2	localParcel1	Parcel
        //   71	11	3	localObject	Object
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      public void setRotation(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel2.writeFloat(paramFloat);
          this.ko.transact(22, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setSnippet(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel1.writeString(paramString);
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
      
      public void setTitle(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          localParcel2.writeString(paramString);
          this.ko.transact(5, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void setVisible(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          if (paramBoolean) {
            i = 1;
          }
          localParcel2.writeInt(i);
          this.ko.transact(14, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void showInfoWindow()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
          this.ko.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.f
 * JD-Core Version:    0.7.0.1
 */
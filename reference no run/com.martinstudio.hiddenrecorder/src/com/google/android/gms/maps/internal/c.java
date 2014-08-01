package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.GoogleMapOptionsCreator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptionsCreator;
import com.google.android.gms.maps.model.internal.a;
import com.google.android.gms.maps.model.internal.a.a;

public abstract interface c
  extends IInterface
{
  public abstract IMapViewDelegate a(d paramd, GoogleMapOptions paramGoogleMapOptions)
    throws RemoteException;
  
  public abstract IStreetViewPanoramaViewDelegate a(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    throws RemoteException;
  
  public abstract void a(d paramd, int paramInt)
    throws RemoteException;
  
  public abstract void h(d paramd)
    throws RemoteException;
  
  public abstract IMapFragmentDelegate i(d paramd)
    throws RemoteException;
  
  public abstract IStreetViewPanoramaFragmentDelegate j(d paramd)
    throws RemoteException;
  
  public abstract ICameraUpdateFactoryDelegate jC()
    throws RemoteException;
  
  public abstract a jD()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c ax(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
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
      boolean bool1;
      Object localObject2;
      Object localObject3;
      int m;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        h(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject2 = i(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder1;
        if (localObject2 != null) {
          localIBinder1 = ((IMapFragmentDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        int i = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject2 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = GoogleMapOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = a((d)localObject2, (GoogleMapOptions)localObject3);
        paramParcel2.writeNoException();
        IBinder localIBinder2;
        if (localObject2 != null) {
          localIBinder2 = ((IMapViewDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        int j = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject2 = jC();
        paramParcel2.writeNoException();
        IBinder localIBinder3;
        if (localObject2 != null) {
          localIBinder3 = ((ICameraUpdateFactoryDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder3);
        int k = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject2 = jD();
        paramParcel2.writeNoException();
        IBinder localIBinder4;
        if (localObject2 != null) {
          localIBinder4 = ((a)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder4);
        m = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        a(d.a.ag(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        m = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject3 = d.a.ag(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = StreetViewPanoramaOptions.CREATOR.createFromParcel(paramParcel1);
        }
        localObject2 = a((d)localObject3, (StreetViewPanoramaOptions)localObject2);
        paramParcel2.writeNoException();
        IBinder localIBinder5;
        if (localObject2 != null) {
          localIBinder5 = ((IStreetViewPanoramaViewDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder5);
        int n = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.ICreator");
        localObject2 = j(d.a.ag(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        IBinder localIBinder6;
        if (localObject2 != null) {
          localIBinder6 = ((IStreetViewPanoramaFragmentDelegate)localObject2).asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder6);
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.ICreator");
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
      public IMapViewDelegate a(d paramd, GoogleMapOptions paramGoogleMapOptions)
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
        //   17: ifnull +75 -> 92
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_2
        //   36: ifnull +62 -> 98
        //   39: aload 4
        //   41: iconst_1
        //   42: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   45: aload_2
        //   46: aload 4
        //   48: iconst_0
        //   49: invokevirtual 52	com/google/android/gms/maps/GoogleMapOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   56: iconst_3
        //   57: aload 4
        //   59: aload_3
        //   60: iconst_0
        //   61: invokeinterface 58 5 0
        //   66: pop
        //   67: aload_3
        //   68: invokevirtual 61	android/os/Parcel:readException	()V
        //   71: aload_3
        //   72: invokevirtual 64	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   75: invokestatic 70	com/google/android/gms/maps/internal/IMapViewDelegate$a:aC	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/internal/IMapViewDelegate;
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 73	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 73	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: areturn
        //   92: aconst_null
        //   93: astore 5
        //   95: goto -67 -> 28
        //   98: aload 4
        //   100: iconst_0
        //   101: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   104: goto -52 -> 52
        //   107: astore 5
        //   109: aload_3
        //   110: invokevirtual 73	android/os/Parcel:recycle	()V
        //   113: aload 4
        //   115: invokevirtual 73	android/os/Parcel:recycle	()V
        //   118: aload 5
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	a
        //   0	121	1	paramd	d
        //   0	121	2	paramGoogleMapOptions	GoogleMapOptions
        //   8	102	3	localParcel1	Parcel
        //   3	111	4	localParcel2	Parcel
        //   26	68	5	localObject1	Object
        //   107	12	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   9	80	107	finally
        //   98	104	107	finally
      }
      
      /* Error */
      public IStreetViewPanoramaViewDelegate a(d paramd, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
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
        //   17: ifnull +76 -> 93
        //   20: aload_1
        //   21: invokeinterface 39 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_2
        //   36: ifnull +63 -> 99
        //   39: aload 4
        //   41: iconst_1
        //   42: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   45: aload_2
        //   46: aload 4
        //   48: iconst_0
        //   49: invokevirtual 77	com/google/android/gms/maps/StreetViewPanoramaOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   56: bipush 7
        //   58: aload 4
        //   60: aload_3
        //   61: iconst_0
        //   62: invokeinterface 58 5 0
        //   67: pop
        //   68: aload_3
        //   69: invokevirtual 61	android/os/Parcel:readException	()V
        //   72: aload_3
        //   73: invokevirtual 64	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   76: invokestatic 83	com/google/android/gms/maps/internal/IStreetViewPanoramaViewDelegate$a:aV	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/internal/IStreetViewPanoramaViewDelegate;
        //   79: astore 5
        //   81: aload_3
        //   82: invokevirtual 73	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: invokevirtual 73	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: areturn
        //   93: aconst_null
        //   94: astore 5
        //   96: goto -68 -> 28
        //   99: aload 4
        //   101: iconst_0
        //   102: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   105: goto -53 -> 52
        //   108: astore 5
        //   110: aload_3
        //   111: invokevirtual 73	android/os/Parcel:recycle	()V
        //   114: aload 4
        //   116: invokevirtual 73	android/os/Parcel:recycle	()V
        //   119: aload 5
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	a
        //   0	122	1	paramd	d
        //   0	122	2	paramStreetViewPanoramaOptions	StreetViewPanoramaOptions
        //   8	103	3	localParcel1	Parcel
        //   3	112	4	localParcel2	Parcel
        //   26	69	5	localObject1	Object
        //   108	12	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   9	81	108	finally
        //   99	105	108	finally
      }
      
      /* Error */
      public void a(d paramd, int paramInt)
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
        //   37: iload_2
        //   38: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   45: bipush 6
        //   47: aload 4
        //   49: aload_3
        //   50: iconst_0
        //   51: invokeinterface 58 5 0
        //   56: pop
        //   57: aload_3
        //   58: invokevirtual 61	android/os/Parcel:readException	()V
        //   61: aload_3
        //   62: invokevirtual 73	android/os/Parcel:recycle	()V
        //   65: aload 4
        //   67: invokevirtual 73	android/os/Parcel:recycle	()V
        //   70: return
        //   71: aconst_null
        //   72: astore 5
        //   74: goto -46 -> 28
        //   77: astore 5
        //   79: aload_3
        //   80: invokevirtual 73	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 73	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramd	d
        //   0	91	2	paramInt	int
        //   8	72	3	localParcel1	Parcel
        //   3	81	4	localParcel2	Parcel
        //   26	47	5	localIBinder	IBinder
        //   77	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	61	77	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void h(d paramd)
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
        //   33: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 58 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 61	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 73	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 73	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 4
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 73	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 73	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	d
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   24	37	4	localIBinder	IBinder
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	50	65	finally
      }
      
      /* Error */
      public IMapFragmentDelegate i(d paramd)
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
        //   15: ifnull +55 -> 70
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_3
        //   38: aload_2
        //   39: iconst_0
        //   40: invokeinterface 58 5 0
        //   45: pop
        //   46: aload_2
        //   47: invokevirtual 61	android/os/Parcel:readException	()V
        //   50: aload_2
        //   51: invokevirtual 64	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   54: invokestatic 94	com/google/android/gms/maps/internal/IMapFragmentDelegate$a:aB	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/internal/IMapFragmentDelegate;
        //   57: astore 4
        //   59: aload_2
        //   60: invokevirtual 73	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 73	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: areturn
        //   70: aconst_null
        //   71: astore 4
        //   73: goto -47 -> 26
        //   76: astore 4
        //   78: aload_2
        //   79: invokevirtual 73	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 73	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramd	d
        //   7	72	2	localParcel1	Parcel
        //   3	80	3	localParcel2	Parcel
        //   24	48	4	localObject1	Object
        //   76	11	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	59	76	finally
      }
      
      /* Error */
      public IStreetViewPanoramaFragmentDelegate j(d paramd)
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
        //   15: ifnull +56 -> 71
        //   18: aload_1
        //   19: invokeinterface 39 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/maps/internal/c$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 8
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 58 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 61	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 64	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   55: invokestatic 102	com/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate$a:aU	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/internal/IStreetViewPanoramaFragmentDelegate;
        //   58: astore 4
        //   60: aload_3
        //   61: invokevirtual 73	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 73	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -48 -> 26
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 73	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 73	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramd	d
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   24	49	4	localObject1	Object
        //   77	11	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      public ICameraUpdateFactoryDelegate jC()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          this.ko.transact(4, localParcel2, localParcel1, 0);
          localParcel1.readException();
          ICameraUpdateFactoryDelegate localICameraUpdateFactoryDelegate = ICameraUpdateFactoryDelegate.a.av(localParcel1.readStrongBinder());
          return localICameraUpdateFactoryDelegate;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public a jD()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
          this.ko.transact(5, localParcel2, localParcel1, 0);
          localParcel1.readException();
          a locala = a.a.aX(localParcel1.readStrongBinder());
          return locala;
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
 * Qualified Name:     com.google.android.gms.maps.internal.c
 * JD-Core Version:    0.7.0.1
 */
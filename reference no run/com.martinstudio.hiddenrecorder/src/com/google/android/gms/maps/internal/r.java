package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientationCreator;

public abstract interface r
  extends IInterface
{
  public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements r
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
    }
    
    public static r aQ(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        if ((localObject == null) || (!(localObject instanceof r))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (r)localObject;
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
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        StreetViewPanoramaOrientation localStreetViewPanoramaOrientation;
        if (paramParcel1.readInt() == 0) {
          localStreetViewPanoramaOrientation = null;
        } else {
          localStreetViewPanoramaOrientation = StreetViewPanoramaOrientation.CREATOR.createFromParcel(paramParcel1);
        }
        onStreetViewPanoramaClick(localStreetViewPanoramaOrientation);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements r
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
      public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
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
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 46	com/google/android/gms/maps/model/StreetViewPanoramaOrientation:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/maps/internal/r$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 52 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 55	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 58	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 58	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_3
        //   67: invokevirtual 58	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 58	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramStreetViewPanoramaOrientation	StreetViewPanoramaOrientation
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.r
 * JD-Core Version:    0.7.0.1
 */
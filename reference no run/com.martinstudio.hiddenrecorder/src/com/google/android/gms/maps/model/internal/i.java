package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract interface i
  extends IInterface
{
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements i
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }
    
    public static i bg(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        if ((localObject == null) || (!(localObject instanceof i))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (i)localObject;
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
      int i = 1;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        Tile localTile = getTile(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localTile == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(i);
          localTile.writeToParcel(paramParcel2, i);
        }
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
      }
      return i;
    }
    
    private static class a
      implements i
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
      public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: iload_1
        //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   23: aload 5
        //   25: iload_2
        //   26: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   29: aload 5
        //   31: iload_3
        //   32: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/maps/model/internal/i$a$a:ko	Landroid/os/IBinder;
        //   39: iconst_1
        //   40: aload 5
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 46 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 49	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 53	android/os/Parcel:readInt	()I
        //   61: ifeq +30 -> 91
        //   64: getstatic 59	com/google/android/gms/maps/model/Tile:CREATOR	Lcom/google/android/gms/maps/model/TileCreator;
        //   67: aload 4
        //   69: invokevirtual 65	com/google/android/gms/maps/model/TileCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/Tile;
        //   72: astore 6
        //   74: aload 6
        //   76: astore 6
        //   78: aload 4
        //   80: invokevirtual 68	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 68	android/os/Parcel:recycle	()V
        //   88: aload 6
        //   90: areturn
        //   91: aconst_null
        //   92: astore 6
        //   94: goto -16 -> 78
        //   97: astore 6
        //   99: aload 4
        //   101: invokevirtual 68	android/os/Parcel:recycle	()V
        //   104: aload 5
        //   106: invokevirtual 68	android/os/Parcel:recycle	()V
        //   109: aload 6
        //   111: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	112	0	this	a
        //   0	112	1	paramInt1	int
        //   0	112	2	paramInt2	int
        //   0	112	3	paramInt3	int
        //   8	92	4	localParcel1	Parcel
        //   3	102	5	localParcel2	Parcel
        //   72	21	6	localTile	Tile
        //   97	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	74	97	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.i
 * JD-Core Version:    0.7.0.1
 */
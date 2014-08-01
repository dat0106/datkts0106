package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface je
  extends IInterface
{
  public abstract void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements je
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
    }
    
    public static je ar(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        if ((localObject == null) || (!(localObject instanceof je))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (je)localObject;
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
      boolean bool1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        onAddGeofencesResult(paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        onRemoveGeofencesByRequestIdsResult(paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        bool1 = true;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        int i = paramParcel1.readInt();
        PendingIntent localPendingIntent;
        if (paramParcel1.readInt() == 0) {
          localPendingIntent = null;
        } else {
          localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        onRemoveGeofencesByPendingIntentResult(i, localPendingIntent);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements je
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
      
      public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStringArray(paramArrayOfString);
          this.ko.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 32
        //   13: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload 4
        //   18: iload_1
        //   19: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   22: aload_2
        //   23: ifnull +45 -> 68
        //   26: aload 4
        //   28: iconst_1
        //   29: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   32: aload_2
        //   33: aload 4
        //   35: iconst_0
        //   36: invokevirtual 64	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/internal/je$a$a:ko	Landroid/os/IBinder;
        //   43: iconst_3
        //   44: aload 4
        //   46: aload_3
        //   47: iconst_0
        //   48: invokeinterface 50 5 0
        //   53: pop
        //   54: aload_3
        //   55: invokevirtual 53	android/os/Parcel:readException	()V
        //   58: aload_3
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload 4
        //   64: invokevirtual 56	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aload 4
        //   70: iconst_0
        //   71: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   74: goto -35 -> 39
        //   77: astore 5
        //   79: aload_3
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 56	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramInt	int
        //   0	91	2	paramPendingIntent	PendingIntent
        //   8	72	3	localParcel1	Parcel
        //   3	81	4	localParcel2	Parcel
        //   77	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	58	77	finally
        //   68	74	77	finally
      }
      
      public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
          localParcel2.writeInt(paramInt);
          localParcel2.writeStringArray(paramArrayOfString);
          this.ko.transact(2, localParcel2, localParcel1, 0);
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
 * Qualified Name:     com.google.android.gms.internal.je
 * JD-Core Version:    0.7.0.1
 */
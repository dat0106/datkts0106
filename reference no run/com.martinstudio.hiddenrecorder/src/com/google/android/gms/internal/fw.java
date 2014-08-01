package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract interface fw
  extends IInterface
{
  public abstract void a(Status paramStatus)
    throws RemoteException;
  
  public abstract void a(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;
  
  public abstract void a(Status paramStatus, boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements fw
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }
    
    public static fw B(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if ((localObject == null) || (!(localObject instanceof fw))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (fw)localObject;
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
      Object localObject = null;
      boolean bool1 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject = Status.CREATOR.createFromParcel(paramParcel1);
        }
        a((Status)localObject);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        Status localStatus;
        if (paramParcel1.readInt() == 0) {
          localStatus = null;
        } else {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
        }
        a(localStatus, (ParcelFileDescriptor)localObject);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject = Status.CREATOR.createFromParcel(paramParcel1);
        }
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        a((Status)localObject, bool2);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      }
      return bool1;
    }
    
    private static class a
      implements fw
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 29
        //   7: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 43	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/fw$a$a:ko	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload_3
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 49 5 0
        //   38: pop
        //   39: aload_3
        //   40: invokevirtual 52	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_3
        //   45: iconst_0
        //   46: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_2
        //   53: aload_3
        //   54: invokevirtual 52	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramStatus	Status
        //   52	6	2	localObject	Object
        //   3	51	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	39	52	finally
        //   44	49	52	finally
      }
      
      public void a(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            if (paramStatus != null)
            {
              localParcel.writeInt(1);
              paramStatus.writeToParcel(localParcel, 0);
              if (paramParcelFileDescriptor != null)
              {
                localParcel.writeInt(1);
                paramParcelFileDescriptor.writeToParcel(localParcel, 0);
                this.ko.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(Status paramStatus, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            if (paramStatus != null)
            {
              localParcel.writeInt(1);
              paramStatus.writeToParcel(localParcel, 0);
              break label79;
              localParcel.writeInt(i);
              this.ko.transact(3, localParcel, null, 1);
            }
            else
            {
              localParcel.writeInt(0);
            }
          }
          finally
          {
            localParcel.recycle();
          }
          label79:
          while (!paramBoolean)
          {
            int j = 0;
            break;
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fw
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface s
  extends IInterface
{
  public abstract Bundle a(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle a(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements s
  {
    public static s a(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
        if ((localObject == null) || (!(localObject instanceof s))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (s)localObject;
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
      Object localObject = null;
      String str1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle1 = a(str1, str2, localBundle1);
        paramParcel2.writeNoException();
        if (localBundle1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          localBundle1.writeToParcel(paramParcel2, 1);
        }
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        Bundle localBundle2 = a(str1, localBundle2);
        paramParcel2.writeNoException();
        if (localBundle2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          localBundle2.writeToParcel(paramParcel2, 1);
        }
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.auth.IAuthManagerService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements s
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public Bundle a(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.ko.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            Object localObject2 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public Bundle a(String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.ko.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            Object localObject2 = null;
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
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.s
 * JD-Core Version:    0.7.0.1
 */
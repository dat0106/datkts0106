package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public abstract interface gn
  extends IInterface
{
  public abstract void T(int paramInt)
    throws RemoteException;
  
  public abstract void U(int paramInt)
    throws RemoteException;
  
  public abstract void V(int paramInt)
    throws RemoteException;
  
  public abstract void W(int paramInt)
    throws RemoteException;
  
  public abstract void a(ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(String paramString, double paramDouble, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void a(String paramString, long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract void b(gf paramgf)
    throws RemoteException;
  
  public abstract void b(gk paramgk)
    throws RemoteException;
  
  public abstract void b(String paramString, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void g(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void onApplicationDisconnected(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements gn
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2 = false;
      Object localObject = null;
      boolean bool1 = true;
      String str2;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        T(paramParcel1.readInt());
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        if (paramParcel1.readInt() != 0) {
          localObject = (ApplicationMetadata)ApplicationMetadata.CREATOR.createFromParcel(paramParcel1);
        }
        str2 = paramParcel1.readString();
        String str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          bool2 = bool1;
        }
        a((ApplicationMetadata)localObject, str2, str1, bool2);
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        U(paramParcel1.readInt());
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        str2 = paramParcel1.readString();
        double d = paramParcel1.readDouble();
        if (paramParcel1.readInt() != 0) {
          bool2 = bool1;
        }
        a(str2, d, bool2);
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        g(paramParcel1.readString(), paramParcel1.readString());
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        b(paramParcel1.readString(), paramParcel1.createByteArray());
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        W(paramParcel1.readInt());
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        V(paramParcel1.readInt());
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        onApplicationDisconnected(paramParcel1.readInt());
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        a(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        a(paramParcel1.readString(), paramParcel1.readLong());
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        if (paramParcel1.readInt() != 0) {
          localObject = (gf)gf.CREATOR.createFromParcel(paramParcel1);
        }
        b((gf)localObject);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        if (paramParcel1.readInt() != 0) {
          localObject = (gk)gk.CREATOR.createFromParcel(paramParcel1);
        }
        b((gk)localObject);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
      }
      return bool1;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gn
 * JD-Core Version:    0.7.0.1
 */
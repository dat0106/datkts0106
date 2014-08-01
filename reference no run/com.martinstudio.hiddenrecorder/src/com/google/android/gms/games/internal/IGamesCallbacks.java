package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public abstract interface IGamesCallbacks
  extends IInterface
{
  public abstract void A(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void B(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void C(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void D(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void E(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void F(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void G(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void H(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void I(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void J(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void K(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void L(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void M(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void N(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void O(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void P(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, Contents paramContents)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    throws RemoteException;
  
  public abstract void a(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void b(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void b(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void b(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void c(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void c(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void c(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void cd(int paramInt)
    throws RemoteException;
  
  public abstract void ce(int paramInt)
    throws RemoteException;
  
  public abstract void d(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void d(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void d(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void d(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void dO()
    throws RemoteException;
  
  public abstract void e(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void e(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void e(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void e(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void f(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void f(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void f(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void f(DataHolder paramDataHolder, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void g(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void g(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void h(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void i(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void j(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void k(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void l(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void m(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void n(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void o(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void onInvitationRemoved(String paramString)
    throws RemoteException;
  
  public abstract void onLeftRoom(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void onP2PConnected(String paramString)
    throws RemoteException;
  
  public abstract void onP2PDisconnected(String paramString)
    throws RemoteException;
  
  public abstract void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    throws RemoteException;
  
  public abstract void onRequestRemoved(String paramString)
    throws RemoteException;
  
  public abstract void onTurnBasedMatchRemoved(String paramString)
    throws RemoteException;
  
  public abstract void p(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void q(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void r(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void s(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void t(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void u(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void v(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void w(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void x(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void y(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void z(DataHolder paramDataHolder)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IGamesCallbacks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
    }
    
    public static IGamesCallbacks ai(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if ((localObject == null) || (!(localObject instanceof IGamesCallbacks))) {
          localObject = new Proxy(paramIBinder);
        } else {
          localObject = (IGamesCallbacks)localObject;
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
      Object localObject1 = null;
      boolean bool1 = true;
      Object localObject4;
      Object localObject2;
      Object localObject3;
      int m;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        d(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        c((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        e(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        e((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = DataHolder.CREATOR.x(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        a((DataHolder)localObject4, (DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        f((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        g((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        h((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        i((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        j((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        k((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        dO();
        paramParcel2.writeNoException();
        break;
      case 5017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        m((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        u((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        v((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onLeftRoom(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        w((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        x((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        y((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5024: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        z((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5025: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        A((DataHolder)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5026: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        a((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5027: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        b((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5028: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        c((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5029: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        d((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5030: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        e((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5031: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject1 = DataHolder.CREATOR.x(paramParcel1);
        }
        f((DataHolder)localObject1, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 5032: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() == 0) {
          localObject1 = null;
        } else {
          localObject1 = (RealTimeMessage)RealTimeMessage.CREATOR.createFromParcel(paramParcel1);
        }
        onRealTimeMessageReceived((RealTimeMessage)localObject1);
        paramParcel2.writeNoException();
        break;
      case 5033: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        b(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5034: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        int i = paramParcel1.readInt();
        localObject4 = paramParcel1.readString();
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        a(i, (String)localObject4, bool2);
        paramParcel2.writeNoException();
        break;
      case 5035: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        C((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5036: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        cd(paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5037: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        n((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5038: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        B((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5039: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        D((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5040: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        ce(paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 6001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onP2PConnected(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 6002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onP2PDisconnected(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        E((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        int k = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        b(k, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        p((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        q((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        r((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        s((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        f(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        t((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 8009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onTurnBasedMatchRemoved(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onInvitationRemoved(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 9001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        l((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        o((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        onRequestRemoved(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 10003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        F((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject2 = DataHolder.CREATOR.x(paramParcel1);
        }
        G((DataHolder)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        int j = paramParcel1.readInt();
        Bundle localBundle;
        if (paramParcel1.readInt() == 0) {
          localBundle = null;
        } else {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        c(j, localBundle);
        paramParcel2.writeNoException();
        break;
      case 10006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        H((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 11001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        m = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        d(m, (Bundle)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        I((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        m = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        e(m, (Bundle)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        DataHolder localDataHolder1;
        if (paramParcel1.readInt() == 0) {
          localDataHolder1 = null;
        } else {
          localDataHolder1 = DataHolder.CREATOR.x(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDataHolder1, (Contents)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        J((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        K((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        L((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        O((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        d((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        g(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        P((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        M((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        int n = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        f(n, (Bundle)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        if (paramParcel1.readInt() != 0) {
          localObject3 = DataHolder.CREATOR.x(paramParcel1);
        }
        N((DataHolder)localObject3);
        paramParcel2.writeNoException();
        break;
      case 12017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
        DataHolder localDataHolder2;
        if (paramParcel1.readInt() == 0) {
          localDataHolder2 = null;
        } else {
          localDataHolder2 = DataHolder.CREATOR.x(paramParcel1);
        }
        String str = paramParcel1.readString();
        Contents localContents2;
        if (paramParcel1.readInt() == 0) {
          localContents2 = null;
        } else {
          localContents2 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        Contents localContents1;
        if (paramParcel1.readInt() == 0) {
          localContents1 = null;
        } else {
          localContents1 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDataHolder2, str, localContents2, localContents1, (Contents)localObject3);
        paramParcel2.writeNoException();
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
      }
      return bool1;
    }
    
    private static class Proxy
      implements IGamesCallbacks
    {
      private IBinder ko;
      
      Proxy(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void A(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5025
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void B(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5038
        //   40: aload 4
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_3
        //   74: aload_2
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   8	67	2	localParcel1	Parcel
        //   73	11	3	localObject	Object
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void C(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5035
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void D(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5039
        //   40: aload 4
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_2
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   73	11	2	localObject	Object
        //   8	67	3	localParcel1	Parcel
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void E(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 8001
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void F(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 10003
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void G(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 10004
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void H(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 10006
        //   40: aload 4
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_3
        //   74: aload_2
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   8	67	2	localParcel1	Parcel
        //   73	11	3	localObject	Object
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void I(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 12001
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void J(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 12005
        //   40: aload 4
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_3
        //   74: aload_2
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   8	67	2	localParcel1	Parcel
        //   73	11	3	localObject	Object
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void K(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 12006
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void L(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 12007
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void M(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 12014
        //   40: aload 4
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_2
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   73	11	2	localObject	Object
        //   8	67	3	localParcel1	Parcel
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void N(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 12016
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void O(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 12008
        //   40: aload 4
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_3
        //   74: aload_2
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   8	67	2	localParcel1	Parcel
        //   73	11	3	localObject	Object
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void P(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 12013
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      public void a(int paramInt, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(5034, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            if (paramDataHolder1 != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder1.writeToParcel(localParcel1, 0);
              if (paramDataHolder2 != null)
              {
                localParcel1.writeInt(1);
                paramDataHolder2.writeToParcel(localParcel1, 0);
                this.ko.transact(5005, localParcel1, localParcel2, 0);
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
      
      public void a(DataHolder paramDataHolder, Contents paramContents)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            if (paramDataHolder != null)
            {
              localParcel2.writeInt(1);
              paramDataHolder.writeToParcel(localParcel2, 0);
              if (paramContents != null)
              {
                localParcel2.writeInt(1);
                paramContents.writeToParcel(localParcel2, 0);
                this.ko.transact(12004, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            localParcel2.writeInt(0);
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            if (paramDataHolder != null)
            {
              localParcel1.writeInt(1);
              paramDataHolder.writeToParcel(localParcel1, 0);
              localParcel1.writeString(paramString);
              if (paramContents1 != null)
              {
                localParcel1.writeInt(1);
                paramContents1.writeToParcel(localParcel1, 0);
                if (paramContents2 == null) {
                  break label162;
                }
                localParcel1.writeInt(1);
                paramContents2.writeToParcel(localParcel1, 0);
                if (paramContents3 == null) {
                  break label171;
                }
                localParcel1.writeInt(1);
                paramContents3.writeToParcel(localParcel1, 0);
                this.ko.transact(12017, localParcel1, localParcel2, 0);
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
          continue;
          label162:
          localParcel1.writeInt(0);
          continue;
          label171:
          localParcel1.writeInt(0);
        }
      }
      
      /* Error */
      public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 5
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +53 -> 70
        //   20: aload 5
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 5
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload 5
        //   35: aload_2
        //   36: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   43: sipush 5026
        //   46: aload 5
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 50 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 53	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 56	android/os/Parcel:recycle	()V
        //   64: aload 5
        //   66: invokevirtual 56	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 5
        //   72: iconst_0
        //   73: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   76: goto -43 -> 33
        //   79: astore 4
        //   81: aload_3
        //   82: invokevirtual 56	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: invokevirtual 56	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramDataHolder	DataHolder
        //   0	93	2	paramArrayOfString	String[]
        //   8	74	3	localParcel1	Parcel
        //   79	12	4	localObject	Object
        //   3	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	60	79	finally
        //   70	76	79	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(int paramInt1, int paramInt2, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt1);
          localParcel2.writeInt(paramInt2);
          localParcel2.writeString(paramString);
          this.ko.transact(5033, localParcel2, localParcel1, 0);
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
      public void b(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: iload_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_2
        //   24: ifnull +50 -> 74
        //   27: aload 5
        //   29: iconst_1
        //   30: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 5
        //   36: iconst_0
        //   37: invokevirtual 95	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   44: sipush 8002
        //   47: aload 5
        //   49: aload 4
        //   51: iconst_0
        //   52: invokeinterface 50 5 0
        //   57: pop
        //   58: aload 4
        //   60: invokevirtual 53	android/os/Parcel:readException	()V
        //   63: aload 4
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload 5
        //   70: invokevirtual 56	android/os/Parcel:recycle	()V
        //   73: return
        //   74: aload 5
        //   76: iconst_0
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: goto -40 -> 40
        //   83: astore_3
        //   84: aload 4
        //   86: invokevirtual 56	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: invokevirtual 56	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	Proxy
        //   0	96	1	paramInt	int
        //   0	96	2	paramBundle	Bundle
        //   83	12	3	localObject	Object
        //   8	77	4	localParcel1	Parcel
        //   3	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	63	83	finally
        //   74	80	83	finally
      }
      
      /* Error */
      public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 5027
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramDataHolder	DataHolder
        //   0	89	2	paramArrayOfString	String[]
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      /* Error */
      public void c(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +46 -> 67
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 95	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 10005
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -37 -> 35
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramInt	int
        //   0	89	2	paramBundle	Bundle
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      /* Error */
      public void c(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5002
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 5
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 5028
        //   42: aload_3
        //   43: aload 5
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 5
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 5
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore 4
        //   77: aload 5
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramDataHolder	DataHolder
        //   0	89	2	paramArrayOfString	String[]
        //   3	80	3	localParcel1	Parcel
        //   75	12	4	localObject	Object
        //   7	71	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      public void cd(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt);
          this.ko.transact(5036, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void ce(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt);
          this.ko.transact(5040, localParcel2, localParcel1, 0);
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
      public void d(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 5
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload 5
        //   18: iload_1
        //   19: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   22: aload_2
        //   23: ifnull +47 -> 70
        //   26: aload 5
        //   28: iconst_1
        //   29: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   32: aload_2
        //   33: aload 5
        //   35: iconst_0
        //   36: invokevirtual 95	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   43: sipush 11001
        //   46: aload 5
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 50 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 53	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 56	android/os/Parcel:recycle	()V
        //   64: aload 5
        //   66: invokevirtual 56	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 5
        //   72: iconst_0
        //   73: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   76: goto -37 -> 39
        //   79: astore 4
        //   81: aload_3
        //   82: invokevirtual 56	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: invokevirtual 56	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramInt	int
        //   0	93	2	paramBundle	Bundle
        //   8	74	3	localParcel1	Parcel
        //   79	12	4	localObject	Object
        //   3	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	60	79	finally
        //   70	76	79	finally
      }
      
      public void d(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt);
          localParcel2.writeString(paramString);
          this.ko.transact(5001, localParcel2, localParcel1, 0);
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
      public void d(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 12011
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 5029
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramDataHolder	DataHolder
        //   0	89	2	paramArrayOfString	String[]
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      public void dO()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          this.ko.transact(5016, localParcel2, localParcel1, 0);
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
      public void e(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: iload_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_2
        //   24: ifnull +50 -> 74
        //   27: aload 4
        //   29: iconst_1
        //   30: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   33: aload_2
        //   34: aload 4
        //   36: iconst_0
        //   37: invokevirtual 95	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   44: sipush 12003
        //   47: aload 4
        //   49: aload 5
        //   51: iconst_0
        //   52: invokeinterface 50 5 0
        //   57: pop
        //   58: aload 5
        //   60: invokevirtual 53	android/os/Parcel:readException	()V
        //   63: aload 5
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: invokevirtual 56	android/os/Parcel:recycle	()V
        //   73: return
        //   74: aload 4
        //   76: iconst_0
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: goto -40 -> 40
        //   83: astore_3
        //   84: aload 5
        //   86: invokevirtual 56	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 56	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	Proxy
        //   0	96	1	paramInt	int
        //   0	96	2	paramBundle	Bundle
        //   83	12	3	localObject	Object
        //   3	87	4	localParcel1	Parcel
        //   8	77	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	63	83	finally
        //   74	80	83	finally
      }
      
      public void e(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.ko.transact(5003, localParcel1, localParcel2, 0);
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
      public void e(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5004
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +56 -> 74
        //   21: aload 5
        //   23: iconst_1
        //   24: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 5
        //   30: iconst_0
        //   31: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 5
        //   36: aload_2
        //   37: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   44: sipush 5030
        //   47: aload 5
        //   49: aload 4
        //   51: iconst_0
        //   52: invokeinterface 50 5 0
        //   57: pop
        //   58: aload 4
        //   60: invokevirtual 53	android/os/Parcel:readException	()V
        //   63: aload 4
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload 5
        //   70: invokevirtual 56	android/os/Parcel:recycle	()V
        //   73: return
        //   74: aload 5
        //   76: iconst_0
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: goto -46 -> 34
        //   83: astore_3
        //   84: aload 4
        //   86: invokevirtual 56	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: invokevirtual 56	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	Proxy
        //   0	96	1	paramDataHolder	DataHolder
        //   0	96	2	paramArrayOfString	String[]
        //   83	12	3	localObject	Object
        //   8	77	4	localParcel1	Parcel
        //   3	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	63	83	finally
        //   74	80	83	finally
      }
      
      /* Error */
      public void f(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +46 -> 67
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 95	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   39: sipush 12015
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 50 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 53	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: goto -37 -> 35
        //   75: astore 5
        //   77: aload 4
        //   79: invokevirtual 56	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: invokevirtual 56	android/os/Parcel:recycle	()V
        //   86: aload 5
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	Proxy
        //   0	89	1	paramInt	int
        //   0	89	2	paramBundle	Bundle
        //   3	80	3	localParcel1	Parcel
        //   7	71	4	localParcel2	Parcel
        //   75	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	57	75	finally
        //   67	72	75	finally
      }
      
      public void f(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt);
          localParcel2.writeString(paramString);
          this.ko.transact(8007, localParcel2, localParcel1, 0);
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
      public void f(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5006
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +53 -> 70
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload 4
        //   35: aload_2
        //   36: invokevirtual 87	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   43: sipush 5031
        //   46: aload 4
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 50 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 53	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 56	android/os/Parcel:recycle	()V
        //   64: aload 4
        //   66: invokevirtual 56	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 4
        //   72: iconst_0
        //   73: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   76: goto -43 -> 33
        //   79: astore 5
        //   81: aload_3
        //   82: invokevirtual 56	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: invokevirtual 56	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramDataHolder	DataHolder
        //   0	93	2	paramArrayOfString	String[]
        //   8	74	3	localParcel1	Parcel
        //   3	83	4	localParcel2	Parcel
        //   79	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	79	finally
        //   70	76	79	finally
      }
      
      public void g(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.ko.transact(12012, localParcel1, localParcel2, 0);
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
      public void g(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5007
        //   40: aload 4
        //   42: aload_2
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_2
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_2
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_3
        //   74: aload_2
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   8	67	2	localParcel1	Parcel
        //   73	11	3	localObject	Object
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void h(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5008
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void i(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5009
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void j(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5010
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void k(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5011
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void l(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 9001
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void m(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5017
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void n(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5037
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void o(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 10001
        //   37: aload_3
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_3
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_2
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   70	11	2	localObject	Object
        //   3	74	3	localParcel1	Parcel
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      public void onInvitationRemoved(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeString(paramString);
          this.ko.transact(8010, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onLeftRoom(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeInt(paramInt);
          localParcel2.writeString(paramString);
          this.ko.transact(5020, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onP2PConnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeString(paramString);
          this.ko.transact(6001, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void onP2PDisconnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeString(paramString);
          this.ko.transact(6002, localParcel2, localParcel1, 0);
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
      public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 121	com/google/android/gms/games/multiplayer/realtime/RealTimeMessage:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5032
        //   40: aload 4
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_2
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramRealTimeMessage	RealTimeMessage
        //   73	11	2	localObject	Object
        //   8	67	3	localParcel1	Parcel
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      public void onRequestRemoved(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel1.writeString(paramString);
          this.ko.transact(10002, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onTurnBasedMatchRemoved(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
          localParcel2.writeString(paramString);
          this.ko.transact(8009, localParcel2, localParcel1, 0);
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
      public void p(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 8003
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void q(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 8004
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void r(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 8005
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void s(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 8006
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void t(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 8008
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void u(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5018
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void v(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5019
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_2
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void w(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_3
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   33: sipush 5021
        //   36: aload_3
        //   37: aload_2
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_2
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:recycle	()V
        //   53: aload_3
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aload_3
        //   59: iconst_0
        //   60: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   63: goto -34 -> 29
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramDataHolder	DataHolder
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
        //   58	63	66	finally
      }
      
      /* Error */
      public void x(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5022
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void y(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 30
        //   13: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +47 -> 64
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   37: sipush 5023
        //   40: aload 4
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 50 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 53	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 56	android/os/Parcel:recycle	()V
        //   58: aload 4
        //   60: invokevirtual 56	android/os/Parcel:recycle	()V
        //   63: return
        //   64: aload 4
        //   66: iconst_0
        //   67: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   70: goto -37 -> 33
        //   73: astore_2
        //   74: aload_3
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	Proxy
        //   0	85	1	paramDataHolder	DataHolder
        //   73	11	2	localObject	Object
        //   8	67	3	localParcel1	Parcel
        //   3	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	54	73	finally
        //   64	70	73	finally
      }
      
      /* Error */
      public void z(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +46 -> 62
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 44	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 5024
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 56	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 56	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramDataHolder	DataHolder
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IGamesCallbacks
 * JD-Core Version:    0.7.0.1
 */
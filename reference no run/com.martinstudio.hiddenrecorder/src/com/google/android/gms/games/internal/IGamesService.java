package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;

public abstract interface IGamesService
  extends IInterface
{
  public abstract void E(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void F(boolean paramBoolean)
    throws RemoteException;
  
  public abstract int a(IGamesCallbacks paramIGamesCallbacks, byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract Intent a(ZInvitationCluster paramZInvitationCluster, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract Intent a(GameRequestCluster paramGameRequestCluster, String paramString)
    throws RemoteException;
  
  public abstract Intent a(RoomEntity paramRoomEntity, int paramInt)
    throws RemoteException;
  
  public abstract Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    throws RemoteException;
  
  public abstract Intent a(int[] paramArrayOfInt)
    throws RemoteException;
  
  public abstract Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2)
    throws RemoteException;
  
  public abstract void a(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void a(IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(Contents paramContents)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, String[] paramArrayOfString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, int[] paramArrayOfInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, long paramLong)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, Bundle paramBundle, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, int paramInt, String[] paramArrayOfString, Bundle paramBundle, boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, String paramString, boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, int[] paramArrayOfInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, long paramLong, String paramString2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int[] paramArrayOfInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract Intent aR(String paramString)
    throws RemoteException;
  
  public abstract Intent aU(String paramString)
    throws RemoteException;
  
  public abstract String aV(String paramString)
    throws RemoteException;
  
  public abstract String aW(String paramString)
    throws RemoteException;
  
  public abstract void aX(String paramString)
    throws RemoteException;
  
  public abstract int aY(String paramString)
    throws RemoteException;
  
  public abstract Uri aZ(String paramString)
    throws RemoteException;
  
  public abstract int b(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, long paramLong)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void b(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void b(String paramString1, String paramString2, int paramInt)
    throws RemoteException;
  
  public abstract void ba(String paramString)
    throws RemoteException;
  
  public abstract ParcelFileDescriptor bb(String paramString)
    throws RemoteException;
  
  public abstract void c(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, long paramLong)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void c(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void c(String paramString1, String paramString2, int paramInt)
    throws RemoteException;
  
  public abstract void ch(int paramInt)
    throws RemoteException;
  
  public abstract void d(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, long paramLong)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void d(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract void e(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract Bundle ea()
    throws RemoteException;
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void f(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
    throws RemoteException;
  
  public abstract ParcelFileDescriptor g(Uri paramUri)
    throws RemoteException;
  
  public abstract void g(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void g(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract String gU()
    throws RemoteException;
  
  public abstract String gV()
    throws RemoteException;
  
  public abstract Intent gY()
    throws RemoteException;
  
  public abstract Intent gZ()
    throws RemoteException;
  
  public abstract RoomEntity h(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void h(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract Intent ha()
    throws RemoteException;
  
  public abstract Intent hb()
    throws RemoteException;
  
  public abstract Intent hg()
    throws RemoteException;
  
  public abstract Intent hh()
    throws RemoteException;
  
  public abstract int hi()
    throws RemoteException;
  
  public abstract String hj()
    throws RemoteException;
  
  public abstract int hk()
    throws RemoteException;
  
  public abstract Intent hl()
    throws RemoteException;
  
  public abstract int hm()
    throws RemoteException;
  
  public abstract int hn()
    throws RemoteException;
  
  public abstract int ho()
    throws RemoteException;
  
  public abstract int hp()
    throws RemoteException;
  
  public abstract void hr()
    throws RemoteException;
  
  public abstract DataHolder ht()
    throws RemoteException;
  
  public abstract boolean hu()
    throws RemoteException;
  
  public abstract DataHolder hv()
    throws RemoteException;
  
  public abstract void hw()
    throws RemoteException;
  
  public abstract Intent hx()
    throws RemoteException;
  
  public abstract void hy()
    throws RemoteException;
  
  public abstract boolean hz()
    throws RemoteException;
  
  public abstract void i(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void i(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void j(IGamesCallbacks paramIGamesCallbacks)
    throws RemoteException;
  
  public abstract void j(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void k(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void l(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void l(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void m(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void m(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void m(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void n(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void n(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void n(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void o(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void p(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void p(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void q(long paramLong)
    throws RemoteException;
  
  public abstract void q(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void q(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void r(long paramLong)
    throws RemoteException;
  
  public abstract void r(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void s(long paramLong)
    throws RemoteException;
  
  public abstract void s(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void t(long paramLong)
    throws RemoteException;
  
  public abstract void t(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public abstract void u(long paramLong)
    throws RemoteException;
  
  public abstract void u(IGamesCallbacks paramIGamesCallbacks, String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IGamesService
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
    }
    
    public static IGamesService aj(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if ((localObject == null) || (!(localObject instanceof IGamesService))) {
          localObject = new Proxy(paramIBinder);
        } else {
          localObject = (IGamesService)localObject;
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
      Object localObject11 = null;
      int i = 0;
      Object localObject1 = 1;
      Object localObject2;
      int i13;
      Object localObject25;
      int i30;
      boolean bool1;
      Object localObject3;
      Object localObject12;
      Object localObject19;
      int j;
      String str1;
      String str5;
      int i31;
      int i18;
      IGamesCallbacks localIGamesCallbacks3;
      int i14;
      boolean bool3;
      int i9;
      RoomEntity localRoomEntity;
      Object localObject20;
      Object localObject13;
      int k;
      Object localObject4;
      Object localObject14;
      Object localObject5;
      int i20;
      boolean bool15;
      Object localObject21;
      Object localObject26;
      int m;
      Object localObject30;
      int i21;
      int n;
      Object localObject6;
      int i29;
      int i15;
      int i10;
      Object localObject7;
      Object localObject33;
      Object localObject15;
      Object localObject27;
      Object localObject8;
      Object localObject22;
      Object localObject31;
      Intent localIntent2;
      Object localObject9;
      Object localObject16;
      Object localObject23;
      Object localObject28;
      Object localObject29;
      boolean bool8;
      Object localObject17;
      Object localObject32;
      int i12;
      int i5;
      Object localObject24;
      IGamesCallbacks localIGamesCallbacks7;
      Object localObject18;
      boolean bool9;
      Object localObject10;
      int i6;
      switch (paramInt1)
      {
      default: 
        localObject1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 5001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        q(paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject2 = hj();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 5004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject2 = ea();
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Bundle)localObject2).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 5005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject11 = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IBinder)localObject11, (Bundle)localObject2);
        paramParcel2.writeNoException();
        break;
      case 5006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        hr();
        paramParcel2.writeNoException();
        break;
      case 5007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject2 = gU();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 5012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject2 = gV();
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject2);
        break;
      case 5013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject2 = ht();
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((DataHolder)localObject2).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 5014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject11 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i13 = paramParcel1.readInt();
        boolean bool19;
        if (paramParcel1.readInt() == 0) {
          bool19 = false;
        } else {
          bool19 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          localObject2 = localObject1;
        }
        a((IGamesCallbacks)localObject11, i13, bool19, localObject2);
        paramParcel2.writeNoException();
        break;
      case 5016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject25 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject11 = paramParcel1.readString();
        int i25 = paramParcel1.readInt();
        i13 = paramParcel1.readInt();
        i30 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool1 = false;
        } else {
          bool1 = localObject1;
        }
        a((IGamesCallbacks)localObject25, (String)localObject11, i25, i13, i30, bool1);
        paramParcel2.writeNoException();
        break;
      case 5020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks8 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject25 = paramParcel1.readString();
        i30 = paramParcel1.readInt();
        i13 = paramParcel1.readInt();
        int i7 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool1 = false;
        } else {
          bool1 = localObject1;
        }
        b(localIGamesCallbacks8, (String)localObject25, i30, i13, i7, bool1);
        paramParcel2.writeNoException();
        break;
      case 5021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject3 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() == 0) {
          localObject12 = null;
        } else {
          localObject12 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject3, (Bundle)localObject12, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject25 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject19 = paramParcel1.readString();
        localObject3 = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() == 0) {
          localObject12 = null;
        } else {
          localObject12 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject25, (String)localObject19, (IBinder)localObject3, (Bundle)localObject12);
        paramParcel2.writeNoException();
        break;
      case 5024: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject12 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject3 = paramParcel1.readString();
        localObject25 = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() == 0) {
          localObject19 = null;
        } else {
          localObject19 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        b((IGamesCallbacks)localObject12, (String)localObject3, (IBinder)localObject25, (Bundle)localObject19);
        paramParcel2.writeNoException();
        break;
      case 5025: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject19 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject3 = paramParcel1.readString();
        int i26 = paramParcel1.readInt();
        localObject25 = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0) {
          localObject12 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject19, (String)localObject3, i26, (IBinder)localObject25, (Bundle)localObject12);
        paramParcel2.writeNoException();
        break;
      case 5026: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5027: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5028: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        n(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5029: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        m(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5030: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks9 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        IBinder localIBinder2 = paramParcel1.readStrongBinder();
        int i17 = paramParcel1.readInt();
        localObject19 = paramParcel1.createStringArray();
        if (paramParcel1.readInt() != 0) {
          localObject12 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        boolean bool2;
        if (paramParcel1.readInt() == 0) {
          bool2 = false;
        } else {
          bool2 = localObject1;
        }
        a(localIGamesCallbacks9, localIBinder2, i17, (String[])localObject19, (Bundle)localObject12, bool2, paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5031: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        IBinder localIBinder1 = paramParcel1.readStrongBinder();
        localObject19 = paramParcel1.readString();
        boolean bool10;
        if (paramParcel1.readInt() == 0) {
          bool10 = false;
        } else {
          bool10 = localObject1;
        }
        a(localIGamesCallbacks1, localIBinder1, (String)localObject19, bool10, paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5032: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5033: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        j = a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 5034: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        j = b(paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        break;
      case 5035: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        str1 = aW(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        break;
      case 5036: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        ch(paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5037: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5038: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5039: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject19 = paramParcel1.readString();
        str5 = paramParcel1.readString();
        i31 = paramParcel1.readInt();
        i18 = paramParcel1.readInt();
        int i27 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          str1 = localObject1;
        }
        a(localIGamesCallbacks2, (String)localObject19, str5, i31, i18, i27, str1);
        paramParcel2.writeNoException();
        break;
      case 5040: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks10 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject19 = paramParcel1.readString();
        str5 = paramParcel1.readString();
        i18 = paramParcel1.readInt();
        int i8 = paramParcel1.readInt();
        i31 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          str1 = localObject1;
        }
        b(localIGamesCallbacks10, (String)localObject19, str5, i18, i8, i31, str1);
        paramParcel2.writeNoException();
        break;
      case 5041: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5042: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5043: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5044: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localIGamesCallbacks3 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i14 = paramParcel1.readInt();
        i18 = paramParcel1.readInt();
        boolean bool22;
        if (paramParcel1.readInt() == 0) {
          bool22 = false;
        } else {
          bool22 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          bool3 = false;
        } else {
          bool3 = localObject1;
        }
        a(localIGamesCallbacks3, i14, i18, bool22, bool3);
        paramParcel2.writeNoException();
        break;
      case 5045: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localIGamesCallbacks3 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        String str4 = paramParcel1.readString();
        i14 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool3 = false;
        } else {
          bool3 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          i18 = 0;
        } else {
          i18 = localObject1;
        }
        a(localIGamesCallbacks3, str4, i14, bool3, i18);
        paramParcel2.writeNoException();
        break;
      case 5046: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks4 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i9 = paramParcel1.readInt();
        boolean bool20;
        if (paramParcel1.readInt() == 0) {
          bool20 = false;
        } else {
          bool20 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          bool3 = localObject1;
        }
        b(localIGamesCallbacks4, i9, bool20, bool3);
        paramParcel2.writeNoException();
        break;
      case 5047: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5048: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks6 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i9 = paramParcel1.readInt();
        boolean bool14;
        if (paramParcel1.readInt() == 0) {
          bool14 = false;
        } else {
          bool14 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          bool3 = localObject1;
        }
        c(localIGamesCallbacks6, i9, bool14, bool3);
        paramParcel2.writeNoException();
        break;
      case 5049: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        g(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5050: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        aX(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5051: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5052: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        g(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5053: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localRoomEntity = h(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localRoomEntity == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localRoomEntity.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 5054: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject20 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject13 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localRoomEntity = localObject1;
        }
        a((IGamesCallbacks)localObject20, (String)localObject13, localRoomEntity);
        paramParcel2.writeNoException();
        break;
      case 5055: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        p(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 5056: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        h(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5057: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        j(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5058: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5059: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        r(paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 5060: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        k = aY(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        break;
      case 5061: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5062: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 5063: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject20 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          k = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          localObject13 = null;
        } else {
          localObject13 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject20, k, (Bundle)localObject13);
        paramParcel2.writeNoException();
        break;
      case 5064: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject4 = aV(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString((String)localObject4);
        break;
      case 5065: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        m(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5066: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject4 = aZ(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject4 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Uri)localObject4).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 5067: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        boolean bool11 = hu();
        paramParcel2.writeNoException();
        if (bool11) {
          localObject4 = localObject1;
        }
        paramParcel2.writeInt(localObject4);
        break;
      case 5068: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() != 0) {
          localObject4 = localObject1;
        }
        E(localObject4);
        paramParcel2.writeNoException();
        break;
      case 5501: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject20 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject14 = paramParcel1.readString();
        int i19 = paramParcel1.readInt();
        boolean bool23;
        if (paramParcel1.readInt() == 0) {
          bool23 = false;
        } else {
          bool23 = localObject1;
        }
        boolean bool4;
        if (paramParcel1.readInt() == 0) {
          bool4 = false;
        } else {
          bool4 = localObject1;
        }
        b((IGamesCallbacks)localObject20, (String)localObject14, i19, bool23, bool4);
        paramParcel2.writeNoException();
        break;
      case 5502: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject5 = hv();
        paramParcel2.writeNoException();
        if (localObject5 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((DataHolder)localObject5).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 6001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        a((IGamesCallbacks)localObject14, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject20 = paramParcel1.readString();
        String str3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        a((IGamesCallbacks)localObject14, (String)localObject20, str3, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i20 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool15 = false;
        } else {
          bool15 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        d((IGamesCallbacks)localObject14, i20, bool15, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        i20 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool15 = false;
        } else {
          bool15 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        e((IGamesCallbacks)localObject14, i20, bool15, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6501: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject21 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject14 = paramParcel1.readString();
        int i28 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          i31 = 0;
        } else {
          i31 = localObject1;
        }
        boolean bool26;
        if (paramParcel1.readInt() == 0) {
          bool26 = false;
        } else {
          bool26 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          i20 = 0;
        } else {
          i20 = localObject1;
        }
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        a((IGamesCallbacks)localObject21, (String)localObject14, i28, i31, bool26, i20, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6502: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject21 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject14 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        b((IGamesCallbacks)localObject21, (String)localObject14, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6503: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        b((IGamesCallbacks)localObject14, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6504: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject21 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        c((IGamesCallbacks)localObject14, (String)localObject21, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6505: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject21 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        d((IGamesCallbacks)localObject14, (String)localObject21, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6506: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject21 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject26 = paramParcel1.readString();
        localObject14 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject5 = localObject1;
        }
        b((IGamesCallbacks)localObject21, (String)localObject26, (String)localObject14, localObject5);
        paramParcel2.writeNoException();
        break;
      case 6507: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() == 0) {
          localObject5 = null;
        } else {
          localObject5 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        localObject5 = g((Uri)localObject5);
        paramParcel2.writeNoException();
        if (localObject5 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((ParcelFileDescriptor)localObject5).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 7001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        k(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 7002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 7003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject26 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject21 = paramParcel1.readString();
        m = paramParcel1.readInt();
        localObject30 = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0) {
          localObject14 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        b((IGamesCallbacks)localObject26, (String)localObject21, m, (IBinder)localObject30, (Bundle)localObject14);
        paramParcel2.writeNoException();
        break;
      case 8001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 8002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        ba(paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        break;
      case 8004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject30 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        m = paramParcel1.readInt();
        i21 = paramParcel1.readInt();
        localObject21 = paramParcel1.createStringArray();
        if (paramParcel1.readInt() != 0) {
          localObject14 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject30, m, i21, (String[])localObject21, (Bundle)localObject14);
        paramParcel2.writeNoException();
        break;
      case 8005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        l(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        m(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readString(), (ParticipantResult[])paramParcel1.createTypedArray(ParticipantResult.CREATOR));
        paramParcel2.writeNoException();
        break;
      case 8008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray(), (ParticipantResult[])paramParcel1.createTypedArray(ParticipantResult.CREATOR));
        paramParcel2.writeNoException();
        break;
      case 8009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        n(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        o(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 8013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        s(paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 8014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        p(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        break;
      case 8018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        hw();
        paramParcel2.writeNoException();
        break;
      case 8023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject21 = paramParcel1.readString();
        i21 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          m = localObject1;
        }
        a((IGamesCallbacks)localObject14, (String)localObject21, i21, m);
        paramParcel2.writeNoException();
        break;
      case 8024: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        n = hk();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(n);
        break;
      case 8025: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        n(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 8026: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 8027: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          n = localObject1;
        }
        c((IGamesCallbacks)localObject14, n);
        paramParcel2.writeNoException();
        break;
      case 9001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject14 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject6 = paramParcel1.readString();
        i29 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          i21 = 0;
        } else {
          i21 = localObject1;
        }
        boolean bool16;
        if (paramParcel1.readInt() == 0) {
          bool16 = false;
        } else {
          bool16 = localObject1;
        }
        c((IGamesCallbacks)localObject14, (String)localObject6, i29, i21, bool16);
        paramParcel2.writeNoException();
        break;
      case 9002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        q(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 9003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject6 = gY();
        paramParcel2.writeNoException();
        if (localObject6 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject6).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject6 = aR(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject6 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject6).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject6 = gZ();
        paramParcel2.writeNoException();
        if (localObject6 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject6).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject6 = ha();
        paramParcel2.writeNoException();
        if (localObject6 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject6).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject6 = hb();
        paramParcel2.writeNoException();
        if (localObject6 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject6).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i15 = paramParcel1.readInt();
        i10 = paramParcel1.readInt();
        boolean bool5;
        if (paramParcel1.readInt() == 0) {
          bool5 = false;
        } else {
          bool5 = localObject1;
        }
        Intent localIntent1 = a(i15, i10, bool5);
        paramParcel2.writeNoException();
        if (localIntent1 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localIntent1.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i15 = paramParcel1.readInt();
        i10 = paramParcel1.readInt();
        boolean bool6;
        if (paramParcel1.readInt() == 0) {
          bool6 = false;
        } else {
          bool6 = localObject1;
        }
        localObject7 = b(i15, i10, bool6);
        paramParcel2.writeNoException();
        if (localObject7 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject7).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject7 = hg();
        paramParcel2.writeNoException();
        if (localObject7 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject7).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() == 0) {
          localObject7 = null;
        } else {
          localObject7 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(paramParcel1);
        }
        localObject7 = a((RoomEntity)localObject7, paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localObject7 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject7).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject7 = hh();
        paramParcel2.writeNoException();
        if (localObject7 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject7).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject7 = hx();
        paramParcel2.writeNoException();
        if (localObject7 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject7).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        int i1 = hi();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i1);
        break;
      case 9020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        IGamesCallbacks localIGamesCallbacks5 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        String str2 = paramParcel1.readString();
        i29 = paramParcel1.readInt();
        boolean bool21;
        if (paramParcel1.readInt() == 0) {
          bool21 = false;
        } else {
          bool21 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          i10 = 0;
        } else {
          i10 = localObject1;
        }
        d(localIGamesCallbacks5, str2, i29, bool21, i10);
        paramParcel2.writeNoException();
        break;
      case 9028: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject33 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject15 = paramParcel1.readString();
        localObject27 = paramParcel1.readString();
        int i16 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          i29 = 0;
        } else {
          i29 = localObject1;
        }
        boolean bool7;
        if (paramParcel1.readInt() == 0) {
          bool7 = false;
        } else {
          bool7 = localObject1;
        }
        a((IGamesCallbacks)localObject33, (String)localObject15, (String)localObject27, i16, i29, bool7);
        paramParcel2.writeNoException();
        break;
      case 9030: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject8 = bb(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject8 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((ParcelFileDescriptor)localObject8).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 9031: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject22 = (ParticipantEntity[])paramParcel1.createTypedArray(ParticipantEntity.CREATOR);
        localObject31 = paramParcel1.readString();
        localObject8 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject27 = null;
        } else {
          localObject27 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject15 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        localObject8 = a((ParticipantEntity[])localObject22, (String)localObject31, (String)localObject8, (Uri)localObject27, (Uri)localObject15);
        paramParcel2.writeNoException();
        if (localObject8 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject8).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 10001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 10002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        t(paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 10003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 10004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 10005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createStringArray(), paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 10007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 10008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 10009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject8 = a(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject8 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject8).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 10013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        int i2 = hm();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i2);
        break;
      case 10014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        q(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localIntent2 = hl();
        paramParcel2.writeNoException();
        if (localIntent2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localIntent2.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 10016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 10017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject22 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject15 = paramParcel1.readString();
        int i22 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localIntent2 = localObject1;
        }
        b((IGamesCallbacks)localObject22, (String)localObject15, i22, localIntent2);
        paramParcel2.writeNoException();
        break;
      case 10018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        break;
      case 10019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        break;
      case 10020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 10021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() != 0) {
          localObject15 = ZInvitationCluster.CREATOR.bi(paramParcel1);
        }
        localIntent2 = a((ZInvitationCluster)localObject15, paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localIntent2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localIntent2.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 10022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() != 0) {
          localObject15 = GameRequestCluster.CREATOR.bk(paramParcel1);
        }
        localIntent2 = a((GameRequestCluster)localObject15, paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localIntent2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          localIntent2.writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 10023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        int i3 = hn();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i3);
        break;
      case 11001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        j(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 11002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        hy();
        paramParcel2.writeNoException();
        break;
      case 12001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject9 = paramParcel1.readString();
        boolean bool12;
        if (paramParcel1.readInt() == 0) {
          bool12 = false;
        } else {
          bool12 = localObject1;
        }
        boolean bool17;
        if (paramParcel1.readInt() == 0) {
          bool17 = false;
        } else {
          bool17 = localObject1;
        }
        localObject9 = a((String)localObject9, bool12, bool17, paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (localObject9 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject9).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 12002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject16 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject9 = localObject1;
        }
        d((IGamesCallbacks)localObject16, localObject9);
        paramParcel2.writeNoException();
        break;
      case 12003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject16 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject23 = paramParcel1.readString();
        localObject28 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject9 = localObject1;
        }
        c((IGamesCallbacks)localObject16, (String)localObject23, (String)localObject28, localObject9);
        paramParcel2.writeNoException();
        break;
      case 12005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        s(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject16 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject23 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject9 = localObject1;
        }
        e((IGamesCallbacks)localObject16, (String)localObject23, localObject9);
        paramParcel2.writeNoException();
        break;
      case 12007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject23 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject9 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject16 = null;
        } else {
          localObject16 = SnapshotMetadataChange.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject28 = null;
        } else {
          localObject28 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject23, (String)localObject9, (SnapshotMetadataChange)localObject16, (Contents)localObject28);
        paramParcel2.writeNoException();
        break;
      case 12008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        u(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject16 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject23 = paramParcel1.createIntArray();
        int i23 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localObject9 = localObject1;
        }
        a((IGamesCallbacks)localObject16, (int[])localObject23, i23, localObject9);
        paramParcel2.writeNoException();
        break;
      case 12011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 12012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        u(paramParcel1.readLong());
        paramParcel2.writeNoException();
        break;
      case 12013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        d(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject23 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject29 = paramParcel1.readString();
        localObject33 = paramParcel1.readString();
        localObject31 = paramParcel1.createIntArray();
        int i11 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          bool8 = false;
        } else {
          bool8 = localObject1;
        }
        a((IGamesCallbacks)localObject23, (String)localObject29, (String)localObject33, (int[])localObject31, i11, bool8);
        paramParcel2.writeNoException();
        break;
      case 12016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject17 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          bool8 = localObject1;
        }
        f((IGamesCallbacks)localObject17, bool8);
        paramParcel2.writeNoException();
        break;
      case 12017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        l(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 12018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject23 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject17 = paramParcel1.readString();
        localObject29 = paramParcel1.readString();
        int i4 = paramParcel1.readInt();
        boolean bool25;
        if (paramParcel1.readInt() == 0) {
          bool25 = false;
        } else {
          bool25 = localObject1;
        }
        boolean bool24;
        if (paramParcel1.readInt() == 0) {
          bool24 = false;
        } else {
          bool24 = localObject1;
        }
        b((IGamesCallbacks)localObject23, (String)localObject17, (String)localObject29, i4, bool25, bool24);
        paramParcel2.writeNoException();
        break;
      case 12019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        Contents localContents;
        if (paramParcel1.readInt() == 0) {
          localContents = null;
        } else {
          localContents = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a(localContents);
        paramParcel2.writeNoException();
        break;
      case 12020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        r(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject29 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject32 = paramParcel1.readString();
        i12 = paramParcel1.readInt();
        boolean bool18;
        if (paramParcel1.readInt() == 0) {
          bool18 = false;
        } else {
          bool18 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          i5 = 0;
        } else {
          i5 = localObject1;
        }
        e((IGamesCallbacks)localObject29, (String)localObject32, i12, bool18, i5);
        paramParcel2.writeNoException();
        break;
      case 12022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject32 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject24 = paramParcel1.readString();
        int i24 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          i5 = 0;
        } else {
          i5 = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          i12 = 0;
        } else {
          i12 = localObject1;
        }
        f((IGamesCallbacks)localObject32, (String)localObject24, i24, i5, i12);
        paramParcel2.writeNoException();
        break;
      case 12023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 12024: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 12025: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        boolean bool13 = hz();
        paramParcel2.writeNoException();
        if (bool13) {
          i5 = localObject1;
        }
        paramParcel2.writeInt(i5);
        break;
      case 12026: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        if (paramParcel1.readInt() != 0) {
          i5 = localObject1;
        }
        F(i5);
        paramParcel2.writeNoException();
        break;
      case 12027: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        t(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 12028: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localIGamesCallbacks7 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject32 = paramParcel1.readString();
        localObject24 = paramParcel1.readString();
        localObject18 = paramParcel1.createStringArray();
        if (paramParcel1.readInt() == 0) {
          bool9 = false;
        } else {
          bool9 = localObject1;
        }
        a(localIGamesCallbacks7, (String)localObject32, (String)localObject24, (String[])localObject18, bool9);
        paramParcel2.writeNoException();
        break;
      case 12029: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject24 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject18 = paramParcel1.createStringArray();
        if (paramParcel1.readInt() != 0) {
          bool9 = localObject1;
        }
        a((IGamesCallbacks)localObject24, (String[])localObject18, bool9);
        paramParcel2.writeNoException();
        break;
      case 12030: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject10 = a(paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        if (localObject10 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject10).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 12031: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject18 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject10 = localObject1;
        }
        a((IGamesCallbacks)localObject18, localObject10, paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        break;
      case 12032: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject18 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject10 = localObject1;
        }
        e((IGamesCallbacks)localObject18, localObject10);
        paramParcel2.writeNoException();
        break;
      case 12033: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localIGamesCallbacks7 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
        localObject10 = paramParcel1.readString();
        localObject32 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject24 = null;
        } else {
          localObject24 = SnapshotMetadataChange.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject18 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a(localIGamesCallbacks7, (String)localObject10, (String)localObject32, (SnapshotMetadataChange)localObject24, (Contents)localObject18);
        paramParcel2.writeNoException();
        break;
      case 12034: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        localObject10 = aU(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject10 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Intent)localObject10).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 12035: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i6 = ho();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i6);
        break;
      case 12036: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
        i6 = hp();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i6);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IGamesService");
      }
      return localObject1;
    }
    
    private static class Proxy
      implements IGamesService
    {
      private IBinder ko;
      
      Proxy(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void E(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(5068, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void F(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(12026, localParcel1, localParcel2, 0);
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
      public int a(IGamesCallbacks paramIGamesCallbacks, byte[] paramArrayOfByte, String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +80 -> 98
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 66	android/os/Parcel:writeByteArray	([B)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 5033
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 73	android/os/Parcel:readInt	()I
        //   83: istore 7
        //   85: aload 6
        //   87: invokevirtual 50	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: iload 7
        //   97: ireturn
        //   98: aconst_null
        //   99: astore 7
        //   101: goto -72 -> 29
        //   104: astore 7
        //   106: aload 6
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 5
        //   113: invokevirtual 50	android/os/Parcel:recycle	()V
        //   116: aload 7
        //   118: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	119	0	this	Proxy
        //   0	119	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	119	2	paramArrayOfByte	byte[]
        //   0	119	3	paramString1	String
        //   0	119	4	paramString2	String
        //   3	109	5	localParcel1	Parcel
        //   8	99	6	localParcel2	Parcel
        //   27	5	7	localIBinder	IBinder
        //   83	13	7	i	int
        //   99	1	7	localObject1	Object
        //   104	13	7	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	85	104	finally
      }
      
      /* Error */
      public Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: iload_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload 5
        //   28: iload_2
        //   29: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   32: iload_3
        //   33: ifeq +6 -> 39
        //   36: iconst_1
        //   37: istore 6
        //   39: aload 5
        //   41: iload 6
        //   43: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   50: sipush 9008
        //   53: aload 5
        //   55: aload 4
        //   57: iconst_0
        //   58: invokeinterface 44 5 0
        //   63: pop
        //   64: aload 4
        //   66: invokevirtual 47	android/os/Parcel:readException	()V
        //   69: aload 4
        //   71: invokevirtual 73	android/os/Parcel:readInt	()I
        //   74: ifeq +31 -> 105
        //   77: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   80: aload 4
        //   82: invokeinterface 86 2 0
        //   87: checkcast 76	android/content/Intent
        //   90: astore 6
        //   92: aload 4
        //   94: invokevirtual 50	android/os/Parcel:recycle	()V
        //   97: aload 5
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: areturn
        //   105: aconst_null
        //   106: astore 6
        //   108: goto -16 -> 92
        //   111: astore 6
        //   113: aload 4
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 5
        //   120: invokevirtual 50	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	Proxy
        //   0	126	1	paramInt1	int
        //   0	126	2	paramInt2	int
        //   0	126	3	paramBoolean	boolean
        //   11	103	4	localParcel1	Parcel
        //   6	113	5	localParcel2	Parcel
        //   1	41	6	i	int
        //   90	17	6	localIntent	Intent
        //   111	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	92	111	finally
      }
      
      /* Error */
      public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: iload_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload 6
        //   25: aload_2
        //   26: invokevirtual 66	android/os/Parcel:writeByteArray	([B)V
        //   29: aload 6
        //   31: iload_3
        //   32: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   35: aload 6
        //   37: aload 4
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload_0
        //   43: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   46: sipush 10012
        //   49: aload 6
        //   51: aload 5
        //   53: iconst_0
        //   54: invokeinterface 44 5 0
        //   59: pop
        //   60: aload 5
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload 5
        //   67: invokevirtual 73	android/os/Parcel:readInt	()I
        //   70: ifeq +31 -> 101
        //   73: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   76: aload 5
        //   78: invokeinterface 86 2 0
        //   83: checkcast 76	android/content/Intent
        //   86: astore 7
        //   88: aload 5
        //   90: invokevirtual 50	android/os/Parcel:recycle	()V
        //   93: aload 6
        //   95: invokevirtual 50	android/os/Parcel:recycle	()V
        //   98: aload 7
        //   100: areturn
        //   101: aconst_null
        //   102: astore 7
        //   104: goto -16 -> 88
        //   107: astore 7
        //   109: aload 5
        //   111: invokevirtual 50	android/os/Parcel:recycle	()V
        //   114: aload 6
        //   116: invokevirtual 50	android/os/Parcel:recycle	()V
        //   119: aload 7
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	Proxy
        //   0	122	1	paramInt1	int
        //   0	122	2	paramArrayOfByte	byte[]
        //   0	122	3	paramInt2	int
        //   0	122	4	paramString	String
        //   8	102	5	localParcel1	Parcel
        //   3	112	6	localParcel2	Parcel
        //   86	17	7	localIntent	Intent
        //   107	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	88	107	finally
      }
      
      public Intent a(ZInvitationCluster paramZInvitationCluster, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (paramZInvitationCluster != null)
            {
              localParcel2.writeInt(1);
              paramZInvitationCluster.writeToParcel(localParcel2, 0);
              localParcel2.writeString(paramString1);
              localParcel2.writeString(paramString2);
              this.ko.transact(10021, localParcel2, localParcel1, 0);
              localParcel1.readException();
              if (localParcel1.readInt() != 0)
              {
                Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel1);
                return localIntent;
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            Object localObject2 = null;
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public Intent a(GameRequestCluster paramGameRequestCluster, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (paramGameRequestCluster != null)
            {
              localParcel1.writeInt(1);
              paramGameRequestCluster.writeToParcel(localParcel1, 0);
              localParcel1.writeString(paramString);
              this.ko.transact(10022, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
                return localIntent;
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
      
      public Intent a(RoomEntity paramRoomEntity, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (paramRoomEntity != null)
            {
              localParcel1.writeInt(1);
              paramRoomEntity.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              this.ko.transact(9011, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
                return localIntent;
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
      
      /* Error */
      public Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: aload_1
        //   23: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: iload_2
        //   27: ifeq +91 -> 118
        //   30: iload 7
        //   32: istore 8
        //   34: aload 6
        //   36: iload 8
        //   38: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   41: iload_3
        //   42: ifeq +82 -> 124
        //   45: aload 6
        //   47: iload 7
        //   49: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   52: aload 6
        //   54: iload 4
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 12001
        //   66: aload 6
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 73	android/os/Parcel:readInt	()I
        //   87: ifeq +43 -> 130
        //   90: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   93: aload 5
        //   95: invokeinterface 86 2 0
        //   100: checkcast 76	android/content/Intent
        //   103: astore 7
        //   105: aload 5
        //   107: invokevirtual 50	android/os/Parcel:recycle	()V
        //   110: aload 6
        //   112: invokevirtual 50	android/os/Parcel:recycle	()V
        //   115: aload 7
        //   117: areturn
        //   118: iconst_0
        //   119: istore 8
        //   121: goto -87 -> 34
        //   124: iconst_0
        //   125: istore 7
        //   127: goto -82 -> 45
        //   130: aconst_null
        //   131: astore 7
        //   133: goto -28 -> 105
        //   136: astore 7
        //   138: aload 5
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 6
        //   145: invokevirtual 50	android/os/Parcel:recycle	()V
        //   148: aload 7
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	Proxy
        //   0	151	1	paramString	String
        //   0	151	2	paramBoolean1	boolean
        //   0	151	3	paramBoolean2	boolean
        //   0	151	4	paramInt	int
        //   11	128	5	localParcel1	Parcel
        //   6	138	6	localParcel2	Parcel
        //   1	47	7	i	int
        //   103	13	7	localIntent	Intent
        //   125	1	7	j	int
        //   131	1	7	localObject1	Object
        //   136	13	7	localObject2	Object
        //   32	88	8	k	int
        // Exception table:
        //   from	to	target	type
        //   13	105	136	finally
      }
      
      /* Error */
      public Intent a(int[] paramArrayOfInt)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   23: sipush 12030
        //   26: aload_2
        //   27: aload_3
        //   28: iconst_0
        //   29: invokeinterface 44 5 0
        //   34: pop
        //   35: aload_3
        //   36: invokevirtual 47	android/os/Parcel:readException	()V
        //   39: aload_3
        //   40: invokevirtual 73	android/os/Parcel:readInt	()I
        //   43: ifeq +28 -> 71
        //   46: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   49: aload_3
        //   50: invokeinterface 86 2 0
        //   55: checkcast 76	android/content/Intent
        //   58: astore 4
        //   60: aload_3
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -14 -> 60
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramArrayOfInt	int[]
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   58	15	4	localIntent	Intent
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      public Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            localParcel1.writeTypedArray(paramArrayOfParticipantEntity, 0);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramUri1 != null)
            {
              localParcel1.writeInt(1);
              paramUri1.writeToParcel(localParcel1, 0);
              if (paramUri2 != null)
              {
                localParcel1.writeInt(1);
                paramUri2.writeToParcel(localParcel1, 0);
                this.ko.transact(9031, localParcel1, localParcel2, 0);
                localParcel2.readException();
                if (localParcel2.readInt() == 0) {
                  break label166;
                }
                Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
                return localIntent;
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
          label166:
          Object localObject2 = null;
        }
      }
      
      public void a(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
          localParcel2.writeString(paramString);
          this.ko.transact(8019, localParcel2, localParcel1, 0);
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
      public void a(IBinder paramIBinder, Bundle paramBundle)
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
        //   18: aload_1
        //   19: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   22: aload_2
        //   23: ifnull +47 -> 70
        //   26: aload 5
        //   28: iconst_1
        //   29: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   32: aload_2
        //   33: aload 5
        //   35: iconst_0
        //   36: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   39: aload_0
        //   40: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   43: sipush 5005
        //   46: aload 5
        //   48: aload_3
        //   49: iconst_0
        //   50: invokeinterface 44 5 0
        //   55: pop
        //   56: aload_3
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload_3
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload 5
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 5
        //   72: iconst_0
        //   73: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   76: goto -37 -> 39
        //   79: astore 4
        //   81: aload_3
        //   82: invokevirtual 50	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: invokevirtual 50	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	Proxy
        //   0	93	1	paramIBinder	IBinder
        //   0	93	2	paramBundle	Bundle
        //   8	74	3	localParcel1	Parcel
        //   79	12	4	localObject	Object
        //   3	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	60	79	finally
        //   70	76	79	finally
      }
      
      /* Error */
      public void a(Contents paramContents)
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
        //   27: invokevirtual 129	com/google/android/gms/drive/Contents:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 12019
        //   37: aload_2
        //   38: aload 4
        //   40: iconst_0
        //   41: invokeinterface 44 5 0
        //   46: pop
        //   47: aload 4
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload 4
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload_2
        //   63: iconst_0
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: goto -37 -> 30
        //   70: astore_3
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: invokevirtual 50	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	Proxy
        //   0	82	1	paramContents	Contents
        //   3	74	2	localParcel1	Parcel
        //   70	11	3	localObject	Object
        //   7	65	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	70	finally
        //   62	67	70	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5002
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: iload_2
        //   35: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 10016
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramInt	int
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: iload_2
        //   39: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   42: aload 5
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload 5
        //   50: iload 4
        //   52: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 10009
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	110	2	paramInt1	int
        //   0	110	3	paramInt2	int
        //   0	110	4	paramInt3	int
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: aload 6
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 6
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 6
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 5044
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 6
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 7
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 6
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramInt1	int
        //   0	146	3	paramInt2	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   6	133	6	localParcel1	Parcel
        //   11	123	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt1, int paramInt2, String[] paramArrayOfString, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +90 -> 108
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: iload_2
        //   39: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   42: aload 6
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   55: aload 5
        //   57: ifnull +57 -> 114
        //   60: aload 6
        //   62: iconst_1
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload 5
        //   68: aload 6
        //   70: iconst_0
        //   71: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   74: aload_0
        //   75: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   78: sipush 8004
        //   81: aload 6
        //   83: aload 7
        //   85: iconst_0
        //   86: invokeinterface 44 5 0
        //   91: pop
        //   92: aload 7
        //   94: invokevirtual 47	android/os/Parcel:readException	()V
        //   97: aload 7
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: return
        //   108: aconst_null
        //   109: astore 8
        //   111: goto -82 -> 29
        //   114: aload 6
        //   116: iconst_0
        //   117: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   120: goto -46 -> 74
        //   123: astore 8
        //   125: aload 7
        //   127: invokevirtual 50	android/os/Parcel:recycle	()V
        //   130: aload 6
        //   132: invokevirtual 50	android/os/Parcel:recycle	()V
        //   135: aload 8
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	Proxy
        //   0	138	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	138	2	paramInt1	int
        //   0	138	3	paramInt2	int
        //   0	138	4	paramArrayOfString	String[]
        //   0	138	5	paramBundle	Bundle
        //   3	128	6	localParcel1	Parcel
        //   8	118	7	localParcel2	Parcel
        //   27	83	8	localIBinder	IBinder
        //   123	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	97	123	finally
        //   114	120	123	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +85 -> 106
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: iload_3
        //   46: ifeq +66 -> 112
        //   49: iload 7
        //   51: istore 8
        //   53: aload 5
        //   55: iload 8
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: iload 4
        //   62: ifeq +56 -> 118
        //   65: aload 5
        //   67: iload 7
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: aload_0
        //   73: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   76: sipush 5015
        //   79: aload 5
        //   81: aload 6
        //   83: iconst_0
        //   84: invokeinterface 44 5 0
        //   89: pop
        //   90: aload 6
        //   92: invokevirtual 47	android/os/Parcel:readException	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 50	android/os/Parcel:recycle	()V
        //   105: return
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -77 -> 32
        //   112: iconst_0
        //   113: istore 8
        //   115: goto -62 -> 53
        //   118: iconst_0
        //   119: istore 7
        //   121: goto -56 -> 65
        //   124: astore 7
        //   126: aload 6
        //   128: invokevirtual 50	android/os/Parcel:recycle	()V
        //   131: aload 5
        //   133: invokevirtual 50	android/os/Parcel:recycle	()V
        //   136: aload 7
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	Proxy
        //   0	139	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	139	2	paramInt	int
        //   0	139	3	paramBoolean1	boolean
        //   0	139	4	paramBoolean2	boolean
        //   6	126	5	localParcel1	Parcel
        //   11	116	6	localParcel2	Parcel
        //   1	119	7	localIBinder1	IBinder
        //   124	13	7	localObject	Object
        //   30	78	8	localIBinder2	IBinder
        //   113	1	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	95	124	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int paramInt, int[] paramArrayOfInt)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: iload_2
        //   39: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 10018
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramInt	int
        //   0	103	3	paramArrayOfInt	int[]
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, long paramLong)
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
        //   17: aload_1
        //   18: ifnull +58 -> 76
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload_0
        //   43: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   46: sipush 5058
        //   49: aload 4
        //   51: aload 5
        //   53: iconst_0
        //   54: invokeinterface 44 5 0
        //   59: pop
        //   60: aload 5
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload 5
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: return
        //   76: aconst_null
        //   77: astore 6
        //   79: goto -50 -> 29
        //   82: astore 6
        //   84: aload 5
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	Proxy
        //   0	97	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	97	2	paramLong	long
        //   3	87	4	localParcel1	Parcel
        //   8	77	5	localParcel2	Parcel
        //   27	51	6	localIBinder	IBinder
        //   82	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	65	82	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +65 -> 83
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload 6
        //   44: aload 4
        //   46: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 8018
        //   56: aload 6
        //   58: aload 5
        //   60: iconst_0
        //   61: invokeinterface 44 5 0
        //   66: pop
        //   67: aload 5
        //   69: invokevirtual 47	android/os/Parcel:readException	()V
        //   72: aload 5
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 6
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 7
        //   86: goto -57 -> 29
        //   89: astore 7
        //   91: aload 5
        //   93: invokevirtual 50	android/os/Parcel:recycle	()V
        //   96: aload 6
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	Proxy
        //   0	104	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	104	2	paramLong	long
        //   0	104	4	paramString	String
        //   8	84	5	localParcel1	Parcel
        //   3	94	6	localParcel2	Parcel
        //   27	58	7	localIBinder	IBinder
        //   89	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	72	89	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, Bundle paramBundle, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +82 -> 100
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_2
        //   37: ifnull +69 -> 106
        //   40: aload 6
        //   42: iconst_1
        //   43: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   46: aload_2
        //   47: aload 6
        //   49: iconst_0
        //   50: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   53: aload 6
        //   55: iload_3
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload 6
        //   61: iload 4
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 5021
        //   73: aload 6
        //   75: aload 5
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 5
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 5
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 7
        //   103: goto -74 -> 29
        //   106: aload 6
        //   108: iconst_0
        //   109: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   112: goto -59 -> 53
        //   115: astore 7
        //   117: aload 5
        //   119: invokevirtual 50	android/os/Parcel:recycle	()V
        //   122: aload 6
        //   124: invokevirtual 50	android/os/Parcel:recycle	()V
        //   127: aload 7
        //   129: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	130	0	this	Proxy
        //   0	130	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	130	2	paramBundle	Bundle
        //   0	130	3	paramInt1	int
        //   0	130	4	paramInt2	int
        //   8	110	5	localParcel1	Parcel
        //   3	120	6	localParcel2	Parcel
        //   27	75	7	localIBinder	IBinder
        //   115	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	89	115	finally
        //   106	112	115	finally
      }
      
      public void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, int paramInt, String[] paramArrayOfString, Bundle paramBundle, boolean paramBoolean, long paramLong)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            IBinder localIBinder;
            if (paramIGamesCallbacks != null)
            {
              localIBinder = paramIGamesCallbacks.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              localParcel1.writeStrongBinder(paramIBinder);
              localParcel1.writeInt(paramInt);
              localParcel1.writeStringArray(paramArrayOfString);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                break label164;
                localParcel1.writeInt(i);
                localParcel1.writeLong(paramLong);
                this.ko.transact(5030, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label164:
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, IBinder paramIBinder, String paramString, boolean paramBoolean, long paramLong)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 10
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 8
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +86 -> 107
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 8
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 8
        //   41: aload_2
        //   42: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   45: aload 8
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 10
        //   59: aload 8
        //   61: iload 10
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload 8
        //   68: lload 5
        //   70: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   73: aload_0
        //   74: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   77: sipush 5031
        //   80: aload 8
        //   82: aload 7
        //   84: iconst_0
        //   85: invokeinterface 44 5 0
        //   90: pop
        //   91: aload 7
        //   93: invokevirtual 47	android/os/Parcel:readException	()V
        //   96: aload 7
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 8
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: return
        //   107: aconst_null
        //   108: astore 9
        //   110: goto -78 -> 32
        //   113: astore 9
        //   115: aload 7
        //   117: invokevirtual 50	android/os/Parcel:recycle	()V
        //   120: aload 8
        //   122: invokevirtual 50	android/os/Parcel:recycle	()V
        //   125: aload 9
        //   127: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	Proxy
        //   0	128	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	128	2	paramIBinder	IBinder
        //   0	128	3	paramString	String
        //   0	128	4	paramBoolean	boolean
        //   0	128	5	paramLong	long
        //   11	105	7	localParcel1	Parcel
        //   6	115	8	localParcel2	Parcel
        //   30	79	9	localIBinder	IBinder
        //   113	13	9	localObject	Object
        //   1	61	10	i	int
        // Exception table:
        //   from	to	target	type
        //   13	96	113	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5014
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
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
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 4
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 10011
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString	String
        //   0	103	3	paramInt	int
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 9
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 8
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +93 -> 114
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 8
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 8
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 8
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: aload 8
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: aload 8
        //   60: iload 5
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: iload 6
        //   67: ifeq +6 -> 73
        //   70: iconst_1
        //   71: istore 9
        //   73: aload 8
        //   75: iload 9
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: aload_0
        //   81: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   84: sipush 5019
        //   87: aload 8
        //   89: aload 7
        //   91: iconst_0
        //   92: invokeinterface 44 5 0
        //   97: pop
        //   98: aload 7
        //   100: invokevirtual 47	android/os/Parcel:readException	()V
        //   103: aload 7
        //   105: invokevirtual 50	android/os/Parcel:recycle	()V
        //   108: aload 8
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: return
        //   114: aconst_null
        //   115: astore 10
        //   117: goto -85 -> 32
        //   120: astore 9
        //   122: aload 7
        //   124: invokevirtual 50	android/os/Parcel:recycle	()V
        //   127: aload 8
        //   129: invokevirtual 50	android/os/Parcel:recycle	()V
        //   132: aload 9
        //   134: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	Proxy
        //   0	135	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	135	2	paramString	String
        //   0	135	3	paramInt1	int
        //   0	135	4	paramInt2	int
        //   0	135	5	paramInt3	int
        //   0	135	6	paramBoolean	boolean
        //   11	112	7	localParcel1	Parcel
        //   6	122	8	localParcel2	Parcel
        //   1	75	9	i	int
        //   120	13	9	localObject	Object
        //   30	86	10	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	103	120	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +90 -> 108
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   55: aload 5
        //   57: ifnull +57 -> 114
        //   60: aload 6
        //   62: iconst_1
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload 5
        //   68: aload 6
        //   70: iconst_0
        //   71: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   74: aload_0
        //   75: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   78: sipush 5025
        //   81: aload 6
        //   83: aload 7
        //   85: iconst_0
        //   86: invokeinterface 44 5 0
        //   91: pop
        //   92: aload 7
        //   94: invokevirtual 47	android/os/Parcel:readException	()V
        //   97: aload 7
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: return
        //   108: aconst_null
        //   109: astore 8
        //   111: goto -82 -> 29
        //   114: aload 6
        //   116: iconst_0
        //   117: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   120: goto -46 -> 74
        //   123: astore 8
        //   125: aload 7
        //   127: invokevirtual 50	android/os/Parcel:recycle	()V
        //   130: aload 6
        //   132: invokevirtual 50	android/os/Parcel:recycle	()V
        //   135: aload 8
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	Proxy
        //   0	138	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	138	2	paramString	String
        //   0	138	3	paramInt	int
        //   0	138	4	paramIBinder	IBinder
        //   0	138	5	paramBundle	Bundle
        //   3	128	6	localParcel1	Parcel
        //   8	118	7	localParcel2	Parcel
        //   27	83	8	localIBinder	IBinder
        //   123	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	97	123	finally
        //   114	120	123	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 5
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 7
        //   59: aload 5
        //   61: iload 7
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 8023
        //   73: aload 5
        //   75: aload 6
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 6
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 6
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 8
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 6
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 5
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramString	String
        //   0	121	3	paramInt	int
        //   0	121	4	paramBoolean	boolean
        //   6	108	5	localParcel1	Parcel
        //   11	98	6	localParcel2	Parcel
        //   1	61	7	i	int
        //   106	13	7	localObject	Object
        //   30	72	8	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 6
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 6
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 5045
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 6
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 7
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 6
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   6	133	6	localParcel1	Parcel
        //   11	123	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 10
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 9
        //   13: aload 8
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +124 -> 145
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 11
        //   32: aload 8
        //   34: aload 11
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 8
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 8
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +98 -> 151
        //   56: iload 10
        //   58: istore 11
        //   60: aload 8
        //   62: iload 11
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +88 -> 157
        //   72: iload 10
        //   74: istore 11
        //   76: aload 8
        //   78: iload 11
        //   80: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   83: iload 6
        //   85: ifeq +78 -> 163
        //   88: iload 10
        //   90: istore 11
        //   92: aload 8
        //   94: iload 11
        //   96: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   99: iload 7
        //   101: ifeq +68 -> 169
        //   104: aload 8
        //   106: iload 10
        //   108: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   111: aload_0
        //   112: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   115: sipush 6501
        //   118: aload 8
        //   120: aload 9
        //   122: iconst_0
        //   123: invokeinterface 44 5 0
        //   128: pop
        //   129: aload 9
        //   131: invokevirtual 47	android/os/Parcel:readException	()V
        //   134: aload 9
        //   136: invokevirtual 50	android/os/Parcel:recycle	()V
        //   139: aload 8
        //   141: invokevirtual 50	android/os/Parcel:recycle	()V
        //   144: return
        //   145: aconst_null
        //   146: astore 11
        //   148: goto -116 -> 32
        //   151: iconst_0
        //   152: istore 11
        //   154: goto -94 -> 60
        //   157: iconst_0
        //   158: istore 11
        //   160: goto -84 -> 76
        //   163: iconst_0
        //   164: istore 11
        //   166: goto -74 -> 92
        //   169: iconst_0
        //   170: istore 10
        //   172: goto -68 -> 104
        //   175: astore 10
        //   177: aload 9
        //   179: invokevirtual 50	android/os/Parcel:recycle	()V
        //   182: aload 8
        //   184: invokevirtual 50	android/os/Parcel:recycle	()V
        //   187: aload 10
        //   189: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	190	0	this	Proxy
        //   0	190	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	190	2	paramString	String
        //   0	190	3	paramInt	int
        //   0	190	4	paramBoolean1	boolean
        //   0	190	5	paramBoolean2	boolean
        //   0	190	6	paramBoolean3	boolean
        //   0	190	7	paramBoolean4	boolean
        //   6	177	8	localParcel1	Parcel
        //   11	167	9	localParcel2	Parcel
        //   1	170	10	localIBinder1	IBinder
        //   175	13	10	localObject	Object
        //   30	117	11	localIBinder2	IBinder
        //   152	13	11	i	int
        // Exception table:
        //   from	to	target	type
        //   13	134	175	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, int[] paramArrayOfInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 10019
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	110	2	paramString	String
        //   0	110	3	paramInt	int
        //   0	110	4	paramArrayOfInt	int[]
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, long paramLong)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: lload_3
        //   45: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 5016
        //   55: aload 6
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 6
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 7
        //   85: goto -56 -> 29
        //   88: astore 7
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 7
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString	String
        //   0	103	3	paramLong	long
        //   8	83	5	localParcel1	Parcel
        //   3	93	6	localParcel2	Parcel
        //   27	57	7	localIBinder	IBinder
        //   88	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, long paramLong, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: lload_3
        //   45: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   48: aload 6
        //   50: aload 5
        //   52: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 7002
        //   62: aload 6
        //   64: aload 7
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 7
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 7
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload 6
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 8
        //   92: goto -63 -> 29
        //   95: astore 8
        //   97: aload 7
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 8
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramLong	long
        //   0	110	5	paramString2	String
        //   3	100	6	localParcel1	Parcel
        //   8	90	7	localParcel2	Parcel
        //   27	64	8	localIBinder	IBinder
        //   95	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +83 -> 101
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   48: aload 4
        //   50: ifnull +57 -> 107
        //   53: aload 6
        //   55: iconst_1
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload 4
        //   61: aload 6
        //   63: iconst_0
        //   64: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   67: aload_0
        //   68: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   71: sipush 5023
        //   74: aload 6
        //   76: aload 5
        //   78: iconst_0
        //   79: invokeinterface 44 5 0
        //   84: pop
        //   85: aload 5
        //   87: invokevirtual 47	android/os/Parcel:readException	()V
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: return
        //   101: aconst_null
        //   102: astore 7
        //   104: goto -75 -> 29
        //   107: aload 6
        //   109: iconst_0
        //   110: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   113: goto -46 -> 67
        //   116: astore 7
        //   118: aload 5
        //   120: invokevirtual 50	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: invokevirtual 50	android/os/Parcel:recycle	()V
        //   128: aload 7
        //   130: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	131	0	this	Proxy
        //   0	131	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	131	2	paramString	String
        //   0	131	3	paramIBinder	IBinder
        //   0	131	4	paramBundle	Bundle
        //   8	111	5	localParcel1	Parcel
        //   3	121	6	localParcel2	Parcel
        //   27	76	7	localIBinder	IBinder
        //   116	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	90	116	finally
        //   107	113	116	finally
      }
      
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        label142:
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            IBinder localIBinder;
            if (paramIGamesCallbacks != null)
            {
              localIBinder = paramIGamesCallbacks.asBinder();
              localParcel2.writeStrongBinder(localIBinder);
              localParcel2.writeString(paramString);
              if (paramSnapshotMetadataChange != null)
              {
                localParcel2.writeInt(1);
                paramSnapshotMetadataChange.writeToParcel(localParcel2, 0);
                if (paramContents == null) {
                  break label142;
                }
                localParcel2.writeInt(1);
                paramContents.writeToParcel(localParcel2, 0);
                this.ko.transact(12007, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel2.writeInt(0);
            continue;
            localParcel2.writeInt(0);
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 5038
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +78 -> 96
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 6
        //   50: iload 4
        //   52: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   55: aload 6
        //   57: iload 5
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: aload_0
        //   63: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   66: sipush 8001
        //   69: aload 6
        //   71: aload 7
        //   73: iconst_0
        //   74: invokeinterface 44 5 0
        //   79: pop
        //   80: aload 7
        //   82: invokevirtual 47	android/os/Parcel:readException	()V
        //   85: aload 7
        //   87: invokevirtual 50	android/os/Parcel:recycle	()V
        //   90: aload 6
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: return
        //   96: aconst_null
        //   97: astore 8
        //   99: goto -70 -> 29
        //   102: astore 8
        //   104: aload 7
        //   106: invokevirtual 50	android/os/Parcel:recycle	()V
        //   109: aload 6
        //   111: invokevirtual 50	android/os/Parcel:recycle	()V
        //   114: aload 8
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	Proxy
        //   0	117	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	117	2	paramString1	String
        //   0	117	3	paramString2	String
        //   0	117	4	paramInt1	int
        //   0	117	5	paramInt2	int
        //   3	107	6	localParcel1	Parcel
        //   8	97	7	localParcel2	Parcel
        //   27	71	8	localIBinder	IBinder
        //   102	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	85	102	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 8
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 8
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +85 -> 103
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 9
        //   29: aload 8
        //   31: aload 9
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 8
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 8
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 8
        //   50: iload 4
        //   52: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   55: aload 8
        //   57: iload 5
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: aload 8
        //   64: iload 6
        //   66: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   69: aload_0
        //   70: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   73: sipush 10010
        //   76: aload 8
        //   78: aload 7
        //   80: iconst_0
        //   81: invokeinterface 44 5 0
        //   86: pop
        //   87: aload 7
        //   89: invokevirtual 47	android/os/Parcel:readException	()V
        //   92: aload 7
        //   94: invokevirtual 50	android/os/Parcel:recycle	()V
        //   97: aload 8
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: return
        //   103: aconst_null
        //   104: astore 9
        //   106: goto -77 -> 29
        //   109: astore 9
        //   111: aload 7
        //   113: invokevirtual 50	android/os/Parcel:recycle	()V
        //   116: aload 8
        //   118: invokevirtual 50	android/os/Parcel:recycle	()V
        //   121: aload 9
        //   123: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	124	0	this	Proxy
        //   0	124	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	124	2	paramString1	String
        //   0	124	3	paramString2	String
        //   0	124	4	paramInt1	int
        //   0	124	5	paramInt2	int
        //   0	124	6	paramInt3	int
        //   8	104	7	localParcel1	Parcel
        //   3	114	8	localParcel2	Parcel
        //   27	78	9	localIBinder	IBinder
        //   109	13	9	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	92	109	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 11
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 9
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 9
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +100 -> 121
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 9
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 9
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 9
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 9
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: aload 9
        //   60: iload 5
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: aload 9
        //   67: iload 6
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: iload 7
        //   74: ifeq +6 -> 80
        //   77: iconst_1
        //   78: istore 11
        //   80: aload 9
        //   82: iload 11
        //   84: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   87: aload_0
        //   88: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   91: sipush 5039
        //   94: aload 9
        //   96: aload 8
        //   98: iconst_0
        //   99: invokeinterface 44 5 0
        //   104: pop
        //   105: aload 8
        //   107: invokevirtual 47	android/os/Parcel:readException	()V
        //   110: aload 8
        //   112: invokevirtual 50	android/os/Parcel:recycle	()V
        //   115: aload 9
        //   117: invokevirtual 50	android/os/Parcel:recycle	()V
        //   120: return
        //   121: aconst_null
        //   122: astore 10
        //   124: goto -92 -> 32
        //   127: astore 10
        //   129: aload 8
        //   131: invokevirtual 50	android/os/Parcel:recycle	()V
        //   134: aload 9
        //   136: invokevirtual 50	android/os/Parcel:recycle	()V
        //   139: aload 10
        //   141: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	142	0	this	Proxy
        //   0	142	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	142	2	paramString1	String
        //   0	142	3	paramString2	String
        //   0	142	4	paramInt1	int
        //   0	142	5	paramInt2	int
        //   0	142	6	paramInt3	int
        //   0	142	7	paramBoolean	boolean
        //   11	119	8	localParcel1	Parcel
        //   6	129	9	localParcel2	Parcel
        //   30	93	10	localIBinder	IBinder
        //   127	13	10	localObject	Object
        //   1	82	11	i	int
        // Exception table:
        //   from	to	target	type
        //   13	110	127	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 9
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +99 -> 120
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 7
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 7
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: iload 5
        //   60: ifeq +66 -> 126
        //   63: iload 9
        //   65: istore 10
        //   67: aload 7
        //   69: iload 10
        //   71: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   74: iload 6
        //   76: ifeq +56 -> 132
        //   79: aload 7
        //   81: iload 9
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: aload_0
        //   87: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   90: sipush 9028
        //   93: aload 7
        //   95: aload 8
        //   97: iconst_0
        //   98: invokeinterface 44 5 0
        //   103: pop
        //   104: aload 8
        //   106: invokevirtual 47	android/os/Parcel:readException	()V
        //   109: aload 8
        //   111: invokevirtual 50	android/os/Parcel:recycle	()V
        //   114: aload 7
        //   116: invokevirtual 50	android/os/Parcel:recycle	()V
        //   119: return
        //   120: aconst_null
        //   121: astore 10
        //   123: goto -91 -> 32
        //   126: iconst_0
        //   127: istore 10
        //   129: goto -62 -> 67
        //   132: iconst_0
        //   133: istore 9
        //   135: goto -56 -> 79
        //   138: astore 9
        //   140: aload 8
        //   142: invokevirtual 50	android/os/Parcel:recycle	()V
        //   145: aload 7
        //   147: invokevirtual 50	android/os/Parcel:recycle	()V
        //   150: aload 9
        //   152: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	153	0	this	Proxy
        //   0	153	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	153	2	paramString1	String
        //   0	153	3	paramString2	String
        //   0	153	4	paramInt	int
        //   0	153	5	paramBoolean1	boolean
        //   0	153	6	paramBoolean2	boolean
        //   6	140	7	localParcel1	Parcel
        //   11	130	8	localParcel2	Parcel
        //   1	133	9	localIBinder1	IBinder
        //   138	13	9	localObject	Object
        //   30	92	10	localIBinder2	IBinder
        //   127	1	10	i	int
        // Exception table:
        //   from	to	target	type
        //   13	109	138	finally
      }
      
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label150:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            IBinder localIBinder;
            if (paramIGamesCallbacks != null)
            {
              localIBinder = paramIGamesCallbacks.asBinder();
              localParcel1.writeStrongBinder(localIBinder);
              localParcel1.writeString(paramString1);
              localParcel1.writeString(paramString2);
              if (paramSnapshotMetadataChange != null)
              {
                localParcel1.writeInt(1);
                paramSnapshotMetadataChange.writeToParcel(localParcel1, 0);
                if (paramContents == null) {
                  break label150;
                }
                localParcel1.writeInt(1);
                paramContents.writeToParcel(localParcel1, 0);
                this.ko.transact(12033, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localIBinder = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 6
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 8
        //   59: aload 6
        //   61: iload 8
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 6002
        //   73: aload 6
        //   75: aload 5
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 5
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 5
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 7
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 5
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 6
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramString1	String
        //   0	121	3	paramString2	String
        //   0	121	4	paramBoolean	boolean
        //   11	98	5	localParcel1	Parcel
        //   6	108	6	localParcel2	Parcel
        //   30	72	7	localIBinder	IBinder
        //   106	13	7	localObject	Object
        //   1	61	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 10
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +93 -> 114
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 7
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 7
        //   53: aload 4
        //   55: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   58: aload 7
        //   60: iload 5
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: iload 6
        //   67: ifeq +6 -> 73
        //   70: iconst_1
        //   71: istore 10
        //   73: aload 7
        //   75: iload 10
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: aload_0
        //   81: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   84: sipush 12015
        //   87: aload 7
        //   89: aload 8
        //   91: iconst_0
        //   92: invokeinterface 44 5 0
        //   97: pop
        //   98: aload 8
        //   100: invokevirtual 47	android/os/Parcel:readException	()V
        //   103: aload 8
        //   105: invokevirtual 50	android/os/Parcel:recycle	()V
        //   108: aload 7
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: return
        //   114: aconst_null
        //   115: astore 9
        //   117: goto -85 -> 32
        //   120: astore 9
        //   122: aload 8
        //   124: invokevirtual 50	android/os/Parcel:recycle	()V
        //   127: aload 7
        //   129: invokevirtual 50	android/os/Parcel:recycle	()V
        //   132: aload 9
        //   134: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	Proxy
        //   0	135	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	135	2	paramString1	String
        //   0	135	3	paramString2	String
        //   0	135	4	paramArrayOfInt	int[]
        //   0	135	5	paramInt	int
        //   0	135	6	paramBoolean	boolean
        //   6	122	7	localParcel1	Parcel
        //   11	112	8	localParcel2	Parcel
        //   30	86	9	localIBinder	IBinder
        //   120	13	9	localObject	Object
        //   1	75	10	i	int
        // Exception table:
        //   from	to	target	type
        //   13	103	120	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +71 -> 89
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload 5
        //   50: aload 4
        //   52: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   55: aload_0
        //   56: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   59: sipush 10008
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: return
        //   89: aconst_null
        //   90: astore 7
        //   92: goto -63 -> 29
        //   95: astore 7
        //   97: aload 6
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	110	2	paramString1	String
        //   0	110	3	paramString2	String
        //   0	110	4	paramArrayOfString	String[]
        //   3	100	5	localParcel1	Parcel
        //   8	90	6	localParcel2	Parcel
        //   27	64	7	localIBinder	IBinder
        //   95	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	78	95	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +86 -> 107
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 7
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 7
        //   53: aload 4
        //   55: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   58: iload 5
        //   60: ifeq +6 -> 66
        //   63: iconst_1
        //   64: istore 8
        //   66: aload 7
        //   68: iload 8
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: aload_0
        //   74: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   77: sipush 12028
        //   80: aload 7
        //   82: aload 6
        //   84: iconst_0
        //   85: invokeinterface 44 5 0
        //   90: pop
        //   91: aload 6
        //   93: invokevirtual 47	android/os/Parcel:readException	()V
        //   96: aload 6
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: return
        //   107: aconst_null
        //   108: astore 9
        //   110: goto -78 -> 32
        //   113: astore 8
        //   115: aload 6
        //   117: invokevirtual 50	android/os/Parcel:recycle	()V
        //   120: aload 7
        //   122: invokevirtual 50	android/os/Parcel:recycle	()V
        //   125: aload 8
        //   127: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	Proxy
        //   0	128	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	128	2	paramString1	String
        //   0	128	3	paramString2	String
        //   0	128	4	paramArrayOfString	String[]
        //   0	128	5	paramBoolean	boolean
        //   11	105	6	localParcel1	Parcel
        //   6	115	7	localParcel2	Parcel
        //   1	68	8	i	int
        //   113	13	8	localObject	Object
        //   30	79	9	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	96	113	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 6
        //   32: aload 4
        //   34: aload 6
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 7
        //   52: aload 4
        //   54: iload 7
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 5054
        //   66: aload 4
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 6
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 5
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramString	String
        //   0	114	3	paramBoolean	boolean
        //   6	101	4	localParcel1	Parcel
        //   11	91	5	localParcel2	Parcel
        //   30	65	6	localIBinder	IBinder
        //   99	13	6	localObject	Object
        //   1	54	7	i	int
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +79 -> 97
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 66	android/os/Parcel:writeByteArray	([B)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   55: aload 6
        //   57: aload 5
        //   59: iconst_0
        //   60: invokevirtual 113	android/os/Parcel:writeTypedArray	([Landroid/os/Parcelable;I)V
        //   63: aload_0
        //   64: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   67: sipush 8007
        //   70: aload 6
        //   72: aload 7
        //   74: iconst_0
        //   75: invokeinterface 44 5 0
        //   80: pop
        //   81: aload 7
        //   83: invokevirtual 47	android/os/Parcel:readException	()V
        //   86: aload 7
        //   88: invokevirtual 50	android/os/Parcel:recycle	()V
        //   91: aload 6
        //   93: invokevirtual 50	android/os/Parcel:recycle	()V
        //   96: return
        //   97: aconst_null
        //   98: astore 8
        //   100: goto -71 -> 29
        //   103: astore 8
        //   105: aload 7
        //   107: invokevirtual 50	android/os/Parcel:recycle	()V
        //   110: aload 6
        //   112: invokevirtual 50	android/os/Parcel:recycle	()V
        //   115: aload 8
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	Proxy
        //   0	118	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	118	2	paramString1	String
        //   0	118	3	paramArrayOfByte	byte[]
        //   0	118	4	paramString2	String
        //   0	118	5	paramArrayOfParticipantResult	ParticipantResult[]
        //   3	108	6	localParcel1	Parcel
        //   8	98	7	localParcel2	Parcel
        //   27	72	8	localIBinder	IBinder
        //   103	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	86	103	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +72 -> 90
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 66	android/os/Parcel:writeByteArray	([B)V
        //   48: aload 6
        //   50: aload 4
        //   52: iconst_0
        //   53: invokevirtual 113	android/os/Parcel:writeTypedArray	([Landroid/os/Parcelable;I)V
        //   56: aload_0
        //   57: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   60: sipush 8008
        //   63: aload 6
        //   65: aload 5
        //   67: iconst_0
        //   68: invokeinterface 44 5 0
        //   73: pop
        //   74: aload 5
        //   76: invokevirtual 47	android/os/Parcel:readException	()V
        //   79: aload 5
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 6
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: return
        //   90: aconst_null
        //   91: astore 7
        //   93: goto -64 -> 29
        //   96: astore 7
        //   98: aload 5
        //   100: invokevirtual 50	android/os/Parcel:recycle	()V
        //   103: aload 6
        //   105: invokevirtual 50	android/os/Parcel:recycle	()V
        //   108: aload 7
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	Proxy
        //   0	111	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	111	2	paramString	String
        //   0	111	3	paramArrayOfByte	byte[]
        //   0	111	4	paramArrayOfParticipantResult	ParticipantResult[]
        //   8	91	5	localParcel1	Parcel
        //   3	101	6	localParcel2	Parcel
        //   27	65	7	localIBinder	IBinder
        //   96	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	79	96	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, int[] paramArrayOfInt)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 8017
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString	String
        //   0	103	3	paramArrayOfInt	int[]
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 7
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 8
        //   10: aload 7
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +85 -> 103
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 9
        //   29: aload 7
        //   31: aload 9
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 7
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 7
        //   44: aload_3
        //   45: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   48: aload 7
        //   50: iload 4
        //   52: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   55: aload 7
        //   57: aload 5
        //   59: invokevirtual 66	android/os/Parcel:writeByteArray	([B)V
        //   62: aload 7
        //   64: iload 6
        //   66: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   69: aload_0
        //   70: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   73: sipush 10005
        //   76: aload 7
        //   78: aload 8
        //   80: iconst_0
        //   81: invokeinterface 44 5 0
        //   86: pop
        //   87: aload 8
        //   89: invokevirtual 47	android/os/Parcel:readException	()V
        //   92: aload 8
        //   94: invokevirtual 50	android/os/Parcel:recycle	()V
        //   97: aload 7
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: return
        //   103: aconst_null
        //   104: astore 9
        //   106: goto -77 -> 29
        //   109: astore 9
        //   111: aload 8
        //   113: invokevirtual 50	android/os/Parcel:recycle	()V
        //   116: aload 7
        //   118: invokevirtual 50	android/os/Parcel:recycle	()V
        //   121: aload 9
        //   123: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	124	0	this	Proxy
        //   0	124	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	124	2	paramString	String
        //   0	124	3	paramArrayOfString	String[]
        //   0	124	4	paramInt1	int
        //   0	124	5	paramArrayOfByte	byte[]
        //   0	124	6	paramInt2	int
        //   3	114	7	localParcel1	Parcel
        //   8	104	8	localParcel2	Parcel
        //   27	78	9	localIBinder	IBinder
        //   109	13	9	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	92	109	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +62 -> 81
        //   22: aload_1
        //   23: invokeinterface 59 1 0
        //   28: astore 6
        //   30: aload_3
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: iload_2
        //   37: ifeq +6 -> 43
        //   40: iconst_1
        //   41: istore 5
        //   43: aload_3
        //   44: iload 5
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 6001
        //   56: aload_3
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 50	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 6
        //   84: goto -54 -> 30
        //   87: astore 5
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: invokevirtual 50	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	Proxy
        //   0	101	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	101	2	paramBoolean	boolean
        //   6	89	3	localParcel1	Parcel
        //   10	80	4	localParcel2	Parcel
        //   1	44	5	i	int
        //   87	12	5	localObject	Object
        //   28	55	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	71	87	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +80 -> 101
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 6
        //   32: aload 5
        //   34: aload 6
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: iload_2
        //   40: ifeq +67 -> 107
        //   43: aload 5
        //   45: iload 7
        //   47: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   50: aload_3
        //   51: ifnull +62 -> 113
        //   54: aload 5
        //   56: iconst_1
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: aload_3
        //   61: aload 5
        //   63: iconst_0
        //   64: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   67: aload_0
        //   68: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   71: sipush 5063
        //   74: aload 5
        //   76: aload 4
        //   78: iconst_0
        //   79: invokeinterface 44 5 0
        //   84: pop
        //   85: aload 4
        //   87: invokevirtual 47	android/os/Parcel:readException	()V
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: return
        //   101: aconst_null
        //   102: astore 6
        //   104: goto -72 -> 32
        //   107: iconst_0
        //   108: istore 7
        //   110: goto -67 -> 43
        //   113: aload 5
        //   115: iconst_0
        //   116: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   119: goto -52 -> 67
        //   122: astore 6
        //   124: aload 4
        //   126: invokevirtual 50	android/os/Parcel:recycle	()V
        //   129: aload 5
        //   131: invokevirtual 50	android/os/Parcel:recycle	()V
        //   134: aload 6
        //   136: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	137	0	this	Proxy
        //   0	137	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	137	2	paramBoolean	boolean
        //   0	137	3	paramBundle	Bundle
        //   11	114	4	localParcel1	Parcel
        //   6	124	5	localParcel2	Parcel
        //   30	73	6	localIBinder	IBinder
        //   122	13	6	localObject	Object
        //   1	108	7	i	int
        // Exception table:
        //   from	to	target	type
        //   13	90	122	finally
        //   113	119	122	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 5
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: iload_2
        //   40: ifeq +6 -> 46
        //   43: iconst_1
        //   44: istore 6
        //   46: aload 5
        //   48: iload 6
        //   50: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   53: aload 5
        //   55: aload_3
        //   56: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 12031
        //   66: aload 5
        //   68: aload 4
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 4
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 4
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 7
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 4
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 5
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramBoolean	boolean
        //   0	114	3	paramArrayOfString	String[]
        //   11	91	4	localParcel1	Parcel
        //   6	101	5	localParcel2	Parcel
        //   1	48	6	i	int
        //   99	13	6	localObject	Object
        //   30	65	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 8003
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramArrayOfInt	int[]
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 108	android/os/Parcel:writeIntArray	([I)V
        //   45: aload 5
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 7
        //   59: aload 5
        //   61: iload 7
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 12010
        //   73: aload 5
        //   75: aload 6
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 6
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 6
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 8
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 6
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 5
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramArrayOfInt	int[]
        //   0	121	3	paramInt	int
        //   0	121	4	paramBoolean	boolean
        //   6	108	5	localParcel1	Parcel
        //   11	98	6	localParcel2	Parcel
        //   1	61	7	i	int
        //   106	13	7	localObject	Object
        //   30	72	8	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 10006
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramArrayOfString	String[]
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      /* Error */
      public void a(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 6
        //   32: aload 4
        //   34: aload 6
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: aload_2
        //   42: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 7
        //   52: aload 4
        //   54: iload 7
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 12029
        //   66: aload 4
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 6
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 5
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramArrayOfString	String[]
        //   0	114	3	paramBoolean	boolean
        //   6	101	4	localParcel1	Parcel
        //   11	91	5	localParcel2	Parcel
        //   30	65	6	localIBinder	IBinder
        //   99	13	6	localObject	Object
        //   1	54	7	i	int
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public Intent aR(String paramString)
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
        //   14: aload_3
        //   15: aload_1
        //   16: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   23: sipush 9004
        //   26: aload_3
        //   27: aload_2
        //   28: iconst_0
        //   29: invokeinterface 44 5 0
        //   34: pop
        //   35: aload_2
        //   36: invokevirtual 47	android/os/Parcel:readException	()V
        //   39: aload_2
        //   40: invokevirtual 73	android/os/Parcel:readInt	()I
        //   43: ifeq +28 -> 71
        //   46: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   49: aload_2
        //   50: invokeinterface 86 2 0
        //   55: checkcast 76	android/content/Intent
        //   58: astore 4
        //   60: aload_2
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -14 -> 60
        //   77: astore 4
        //   79: aload_2
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramString	String
        //   7	73	2	localParcel1	Parcel
        //   3	81	3	localParcel2	Parcel
        //   58	15	4	localIntent	Intent
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      /* Error */
      public Intent aU(String paramString)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   23: sipush 12034
        //   26: aload_2
        //   27: aload_3
        //   28: iconst_0
        //   29: invokeinterface 44 5 0
        //   34: pop
        //   35: aload_3
        //   36: invokevirtual 47	android/os/Parcel:readException	()V
        //   39: aload_3
        //   40: invokevirtual 73	android/os/Parcel:readInt	()I
        //   43: ifeq +28 -> 71
        //   46: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   49: aload_3
        //   50: invokeinterface 86 2 0
        //   55: checkcast 76	android/content/Intent
        //   58: astore 4
        //   60: aload_3
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -14 -> 60
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramString	String
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   58	15	4	localIntent	Intent
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      public String aV(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          this.ko.transact(5064, localParcel1, localParcel2, 0);
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
      
      public String aW(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          this.ko.transact(5035, localParcel1, localParcel2, 0);
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
      
      public void aX(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          this.ko.transact(5050, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int aY(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          this.ko.transact(5060, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public Uri aZ(String paramString)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   23: sipush 5066
        //   26: aload_2
        //   27: aload_3
        //   28: iconst_0
        //   29: invokeinterface 44 5 0
        //   34: pop
        //   35: aload_3
        //   36: invokevirtual 47	android/os/Parcel:readException	()V
        //   39: aload_3
        //   40: invokevirtual 73	android/os/Parcel:readInt	()I
        //   43: ifeq +28 -> 71
        //   46: getstatic 198	android/net/Uri:CREATOR	Landroid/os/Parcelable$Creator;
        //   49: aload_3
        //   50: invokeinterface 86 2 0
        //   55: checkcast 115	android/net/Uri
        //   58: astore 4
        //   60: aload_3
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -14 -> 60
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramString	String
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   58	15	4	localUri	Uri
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public int b(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeString(paramString);
          localParcel1.writeStringArray(paramArrayOfString);
          this.ko.transact(5034, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 4
        //   22: iload_1
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload 4
        //   28: iload_2
        //   29: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   32: iload_3
        //   33: ifeq +6 -> 39
        //   36: iconst_1
        //   37: istore 6
        //   39: aload 4
        //   41: iload 6
        //   43: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   50: sipush 9009
        //   53: aload 4
        //   55: aload 5
        //   57: iconst_0
        //   58: invokeinterface 44 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 47	android/os/Parcel:readException	()V
        //   69: aload 5
        //   71: invokevirtual 73	android/os/Parcel:readInt	()I
        //   74: ifeq +31 -> 105
        //   77: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   80: aload 5
        //   82: invokeinterface 86 2 0
        //   87: checkcast 76	android/content/Intent
        //   90: astore 6
        //   92: aload 5
        //   94: invokevirtual 50	android/os/Parcel:recycle	()V
        //   97: aload 4
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: areturn
        //   105: aconst_null
        //   106: astore 6
        //   108: goto -16 -> 92
        //   111: astore 6
        //   113: aload 5
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 4
        //   120: invokevirtual 50	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	Proxy
        //   0	126	1	paramInt1	int
        //   0	126	2	paramInt2	int
        //   0	126	3	paramBoolean	boolean
        //   6	113	4	localParcel1	Parcel
        //   11	103	5	localParcel2	Parcel
        //   1	41	6	i	int
        //   90	17	6	localIntent	Intent
        //   111	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	92	111	finally
      }
      
      public void b(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.ko.transact(8021, localParcel1, localParcel2, 0);
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
      public void b(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5017
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +85 -> 106
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: iload_3
        //   46: ifeq +66 -> 112
        //   49: iload 7
        //   51: istore 8
        //   53: aload 5
        //   55: iload 8
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: iload 4
        //   62: ifeq +56 -> 118
        //   65: aload 5
        //   67: iload 7
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: aload_0
        //   73: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   76: sipush 5046
        //   79: aload 5
        //   81: aload 6
        //   83: iconst_0
        //   84: invokeinterface 44 5 0
        //   89: pop
        //   90: aload 6
        //   92: invokevirtual 47	android/os/Parcel:readException	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 50	android/os/Parcel:recycle	()V
        //   105: return
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -77 -> 32
        //   112: iconst_0
        //   113: istore 8
        //   115: goto -62 -> 53
        //   118: iconst_0
        //   119: istore 7
        //   121: goto -56 -> 65
        //   124: astore 7
        //   126: aload 6
        //   128: invokevirtual 50	android/os/Parcel:recycle	()V
        //   131: aload 5
        //   133: invokevirtual 50	android/os/Parcel:recycle	()V
        //   136: aload 7
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	Proxy
        //   0	139	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	139	2	paramInt	int
        //   0	139	3	paramBoolean1	boolean
        //   0	139	4	paramBoolean2	boolean
        //   6	126	5	localParcel1	Parcel
        //   11	116	6	localParcel2	Parcel
        //   1	119	7	localIBinder1	IBinder
        //   124	13	7	localObject	Object
        //   30	78	8	localIBinder2	IBinder
        //   113	1	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	95	124	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, long paramLong)
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
        //   17: aload_1
        //   18: ifnull +58 -> 76
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload_0
        //   43: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   46: sipush 8012
        //   49: aload 4
        //   51: aload 5
        //   53: iconst_0
        //   54: invokeinterface 44 5 0
        //   59: pop
        //   60: aload 5
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload 5
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload 4
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: return
        //   76: aconst_null
        //   77: astore 6
        //   79: goto -50 -> 29
        //   82: astore 6
        //   84: aload 5
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	Proxy
        //   0	97	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	97	2	paramLong	long
        //   3	87	4	localParcel1	Parcel
        //   8	77	5	localParcel2	Parcel
        //   27	51	6	localIBinder	IBinder
        //   82	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	65	82	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +65 -> 83
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload 5
        //   44: aload 4
        //   46: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 8020
        //   56: aload 5
        //   58: aload 6
        //   60: iconst_0
        //   61: invokeinterface 44 5 0
        //   66: pop
        //   67: aload 6
        //   69: invokevirtual 47	android/os/Parcel:readException	()V
        //   72: aload 6
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 5
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 7
        //   86: goto -57 -> 29
        //   89: astore 7
        //   91: aload 6
        //   93: invokevirtual 50	android/os/Parcel:recycle	()V
        //   96: aload 5
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	Proxy
        //   0	104	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	104	2	paramLong	long
        //   0	104	4	paramString	String
        //   3	94	5	localParcel1	Parcel
        //   8	84	6	localParcel2	Parcel
        //   27	58	7	localIBinder	IBinder
        //   89	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	72	89	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5018
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 12023
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString	String
        //   0	103	3	paramInt	int
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 9
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +93 -> 114
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 7
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: aload 7
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: aload 7
        //   60: iload 5
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: iload 6
        //   67: ifeq +6 -> 73
        //   70: iconst_1
        //   71: istore 9
        //   73: aload 7
        //   75: iload 9
        //   77: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   80: aload_0
        //   81: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   84: sipush 5020
        //   87: aload 7
        //   89: aload 8
        //   91: iconst_0
        //   92: invokeinterface 44 5 0
        //   97: pop
        //   98: aload 8
        //   100: invokevirtual 47	android/os/Parcel:readException	()V
        //   103: aload 8
        //   105: invokevirtual 50	android/os/Parcel:recycle	()V
        //   108: aload 7
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: return
        //   114: aconst_null
        //   115: astore 10
        //   117: goto -85 -> 32
        //   120: astore 9
        //   122: aload 8
        //   124: invokevirtual 50	android/os/Parcel:recycle	()V
        //   127: aload 7
        //   129: invokevirtual 50	android/os/Parcel:recycle	()V
        //   132: aload 9
        //   134: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	Proxy
        //   0	135	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	135	2	paramString	String
        //   0	135	3	paramInt1	int
        //   0	135	4	paramInt2	int
        //   0	135	5	paramInt3	int
        //   0	135	6	paramBoolean	boolean
        //   6	122	7	localParcel1	Parcel
        //   11	112	8	localParcel2	Parcel
        //   1	75	9	i	int
        //   120	13	9	localObject	Object
        //   30	86	10	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	103	120	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +90 -> 108
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 8
        //   29: aload 6
        //   31: aload 8
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload 6
        //   50: aload 4
        //   52: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   55: aload 5
        //   57: ifnull +57 -> 114
        //   60: aload 6
        //   62: iconst_1
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload 5
        //   68: aload 6
        //   70: iconst_0
        //   71: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   74: aload_0
        //   75: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   78: sipush 7003
        //   81: aload 6
        //   83: aload 7
        //   85: iconst_0
        //   86: invokeinterface 44 5 0
        //   91: pop
        //   92: aload 7
        //   94: invokevirtual 47	android/os/Parcel:readException	()V
        //   97: aload 7
        //   99: invokevirtual 50	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: return
        //   108: aconst_null
        //   109: astore 8
        //   111: goto -82 -> 29
        //   114: aload 6
        //   116: iconst_0
        //   117: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   120: goto -46 -> 74
        //   123: astore 8
        //   125: aload 7
        //   127: invokevirtual 50	android/os/Parcel:recycle	()V
        //   130: aload 6
        //   132: invokevirtual 50	android/os/Parcel:recycle	()V
        //   135: aload 8
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	Proxy
        //   0	138	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	138	2	paramString	String
        //   0	138	3	paramInt	int
        //   0	138	4	paramIBinder	IBinder
        //   0	138	5	paramBundle	Bundle
        //   3	128	6	localParcel1	Parcel
        //   8	118	7	localParcel2	Parcel
        //   27	83	8	localIBinder	IBinder
        //   123	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	97	123	finally
        //   114	120	123	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 5
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 5
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 8
        //   59: aload 5
        //   61: iload 8
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 10017
        //   73: aload 5
        //   75: aload 6
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 6
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 6
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 7
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 6
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 5
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramString	String
        //   0	121	3	paramInt	int
        //   0	121	4	paramBoolean	boolean
        //   6	108	5	localParcel1	Parcel
        //   11	98	6	localParcel2	Parcel
        //   30	72	7	localIBinder	IBinder
        //   106	13	7	localObject	Object
        //   1	61	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 6
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 6
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 5501
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 6
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 7
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 6
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   6	133	6	localParcel1	Parcel
        //   11	123	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +83 -> 101
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 6
        //   44: aload_3
        //   45: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   48: aload 4
        //   50: ifnull +57 -> 107
        //   53: aload 6
        //   55: iconst_1
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload 4
        //   61: aload 6
        //   63: iconst_0
        //   64: invokevirtual 125	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   67: aload_0
        //   68: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   71: sipush 5024
        //   74: aload 6
        //   76: aload 5
        //   78: iconst_0
        //   79: invokeinterface 44 5 0
        //   84: pop
        //   85: aload 5
        //   87: invokevirtual 47	android/os/Parcel:readException	()V
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: return
        //   101: aconst_null
        //   102: astore 7
        //   104: goto -75 -> 29
        //   107: aload 6
        //   109: iconst_0
        //   110: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   113: goto -46 -> 67
        //   116: astore 7
        //   118: aload 5
        //   120: invokevirtual 50	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: invokevirtual 50	android/os/Parcel:recycle	()V
        //   128: aload 7
        //   130: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	131	0	this	Proxy
        //   0	131	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	131	2	paramString	String
        //   0	131	3	paramIBinder	IBinder
        //   0	131	4	paramBundle	Bundle
        //   8	111	5	localParcel1	Parcel
        //   3	121	6	localParcel2	Parcel
        //   27	76	7	localIBinder	IBinder
        //   116	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	90	116	finally
        //   107	113	116	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 5041
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 11
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 9
        //   13: aload 8
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +100 -> 121
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 8
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 8
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 8
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 8
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: aload 8
        //   60: iload 5
        //   62: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   65: aload 8
        //   67: iload 6
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: iload 7
        //   74: ifeq +6 -> 80
        //   77: iconst_1
        //   78: istore 11
        //   80: aload 8
        //   82: iload 11
        //   84: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   87: aload_0
        //   88: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   91: sipush 5040
        //   94: aload 8
        //   96: aload 9
        //   98: iconst_0
        //   99: invokeinterface 44 5 0
        //   104: pop
        //   105: aload 9
        //   107: invokevirtual 47	android/os/Parcel:readException	()V
        //   110: aload 9
        //   112: invokevirtual 50	android/os/Parcel:recycle	()V
        //   115: aload 8
        //   117: invokevirtual 50	android/os/Parcel:recycle	()V
        //   120: return
        //   121: aconst_null
        //   122: astore 10
        //   124: goto -92 -> 32
        //   127: astore 10
        //   129: aload 9
        //   131: invokevirtual 50	android/os/Parcel:recycle	()V
        //   134: aload 8
        //   136: invokevirtual 50	android/os/Parcel:recycle	()V
        //   139: aload 10
        //   141: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	142	0	this	Proxy
        //   0	142	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	142	2	paramString1	String
        //   0	142	3	paramString2	String
        //   0	142	4	paramInt1	int
        //   0	142	5	paramInt2	int
        //   0	142	6	paramInt3	int
        //   0	142	7	paramBoolean	boolean
        //   6	129	8	localParcel1	Parcel
        //   11	119	9	localParcel2	Parcel
        //   30	93	10	localIBinder	IBinder
        //   127	13	10	localObject	Object
        //   1	82	11	i	int
        // Exception table:
        //   from	to	target	type
        //   13	110	127	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 9
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 8
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +99 -> 120
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 10
        //   32: aload 8
        //   34: aload 10
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 8
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 8
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: aload 8
        //   53: iload 4
        //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   58: iload 5
        //   60: ifeq +66 -> 126
        //   63: iload 9
        //   65: istore 10
        //   67: aload 8
        //   69: iload 10
        //   71: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   74: iload 6
        //   76: ifeq +56 -> 132
        //   79: aload 8
        //   81: iload 9
        //   83: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   86: aload_0
        //   87: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   90: sipush 12018
        //   93: aload 8
        //   95: aload 7
        //   97: iconst_0
        //   98: invokeinterface 44 5 0
        //   103: pop
        //   104: aload 7
        //   106: invokevirtual 47	android/os/Parcel:readException	()V
        //   109: aload 7
        //   111: invokevirtual 50	android/os/Parcel:recycle	()V
        //   114: aload 8
        //   116: invokevirtual 50	android/os/Parcel:recycle	()V
        //   119: return
        //   120: aconst_null
        //   121: astore 10
        //   123: goto -91 -> 32
        //   126: iconst_0
        //   127: istore 10
        //   129: goto -62 -> 67
        //   132: iconst_0
        //   133: istore 9
        //   135: goto -56 -> 79
        //   138: astore 9
        //   140: aload 7
        //   142: invokevirtual 50	android/os/Parcel:recycle	()V
        //   145: aload 8
        //   147: invokevirtual 50	android/os/Parcel:recycle	()V
        //   150: aload 9
        //   152: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	153	0	this	Proxy
        //   0	153	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	153	2	paramString1	String
        //   0	153	3	paramString2	String
        //   0	153	4	paramInt	int
        //   0	153	5	paramBoolean1	boolean
        //   0	153	6	paramBoolean2	boolean
        //   11	130	7	localParcel1	Parcel
        //   6	140	8	localParcel2	Parcel
        //   1	133	9	localIBinder1	IBinder
        //   138	13	9	localObject	Object
        //   30	92	10	localIBinder2	IBinder
        //   127	1	10	i	int
        // Exception table:
        //   from	to	target	type
        //   13	109	138	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 6
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 8
        //   59: aload 6
        //   61: iload 8
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 6506
        //   73: aload 6
        //   75: aload 5
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 5
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 5
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 7
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 5
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 6
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramString1	String
        //   0	121	3	paramString2	String
        //   0	121	4	paramBoolean	boolean
        //   11	98	5	localParcel1	Parcel
        //   6	108	6	localParcel2	Parcel
        //   30	72	7	localIBinder	IBinder
        //   106	13	7	localObject	Object
        //   1	61	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 4
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 6
        //   52: aload 4
        //   54: iload 6
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 6502
        //   66: aload 4
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 7
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 5
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramString	String
        //   0	114	3	paramBoolean	boolean
        //   6	101	4	localParcel1	Parcel
        //   11	91	5	localParcel2	Parcel
        //   1	54	6	i	int
        //   99	13	6	localObject	Object
        //   30	65	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +62 -> 81
        //   22: aload_1
        //   23: invokeinterface 59 1 0
        //   28: astore 5
        //   30: aload_3
        //   31: aload 5
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: iload_2
        //   37: ifeq +6 -> 43
        //   40: iconst_1
        //   41: istore 6
        //   43: aload_3
        //   44: iload 6
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 6503
        //   56: aload_3
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 50	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 5
        //   84: goto -54 -> 30
        //   87: astore 5
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: invokevirtual 50	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	Proxy
        //   0	101	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	101	2	paramBoolean	boolean
        //   6	89	3	localParcel1	Parcel
        //   10	80	4	localParcel2	Parcel
        //   28	55	5	localIBinder	IBinder
        //   87	12	5	localObject	Object
        //   1	44	6	i	int
        // Exception table:
        //   from	to	target	type
        //   12	71	87	finally
      }
      
      /* Error */
      public void b(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 10007
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramArrayOfString	String[]
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void b(String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt);
          this.ko.transact(5051, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void ba(String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeString(paramString);
          this.ko.transact(8002, localParcel2, localParcel1, 0);
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
      public ParcelFileDescriptor bb(String paramString)
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
        //   14: aload_3
        //   15: aload_1
        //   16: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   23: sipush 9030
        //   26: aload_3
        //   27: aload_2
        //   28: iconst_0
        //   29: invokeinterface 44 5 0
        //   34: pop
        //   35: aload_2
        //   36: invokevirtual 47	android/os/Parcel:readException	()V
        //   39: aload_2
        //   40: invokevirtual 73	android/os/Parcel:readInt	()I
        //   43: ifeq +28 -> 71
        //   46: getstatic 207	android/os/ParcelFileDescriptor:CREATOR	Landroid/os/Parcelable$Creator;
        //   49: aload_2
        //   50: invokeinterface 86 2 0
        //   55: checkcast 206	android/os/ParcelFileDescriptor
        //   58: astore 4
        //   60: aload_2
        //   61: invokevirtual 50	android/os/Parcel:recycle	()V
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: areturn
        //   71: aconst_null
        //   72: astore 4
        //   74: goto -14 -> 60
        //   77: astore 4
        //   79: aload_2
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramString	String
        //   7	73	2	localParcel1	Parcel
        //   3	81	3	localParcel2	Parcel
        //   58	15	4	localParcelFileDescriptor	ParcelFileDescriptor
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	60	77	finally
      }
      
      public void c(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
          localParcel2.writeString(paramString);
          this.ko.transact(10004, localParcel2, localParcel1, 0);
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
      public void c(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5022
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +85 -> 106
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: iload_3
        //   46: ifeq +66 -> 112
        //   49: iload 7
        //   51: istore 8
        //   53: aload 5
        //   55: iload 8
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: iload 4
        //   62: ifeq +56 -> 118
        //   65: aload 5
        //   67: iload 7
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: aload_0
        //   73: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   76: sipush 5048
        //   79: aload 5
        //   81: aload 6
        //   83: iconst_0
        //   84: invokeinterface 44 5 0
        //   89: pop
        //   90: aload 6
        //   92: invokevirtual 47	android/os/Parcel:readException	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 50	android/os/Parcel:recycle	()V
        //   105: return
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -77 -> 32
        //   112: iconst_0
        //   113: istore 8
        //   115: goto -62 -> 53
        //   118: iconst_0
        //   119: istore 7
        //   121: goto -56 -> 65
        //   124: astore 7
        //   126: aload 6
        //   128: invokevirtual 50	android/os/Parcel:recycle	()V
        //   131: aload 5
        //   133: invokevirtual 50	android/os/Parcel:recycle	()V
        //   136: aload 7
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	Proxy
        //   0	139	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	139	2	paramInt	int
        //   0	139	3	paramBoolean1	boolean
        //   0	139	4	paramBoolean2	boolean
        //   6	126	5	localParcel1	Parcel
        //   11	116	6	localParcel2	Parcel
        //   1	119	7	localIBinder1	IBinder
        //   124	13	7	localObject	Object
        //   30	78	8	localIBinder2	IBinder
        //   113	1	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	95	124	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, long paramLong)
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
        //   18: ifnull +58 -> 76
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload_0
        //   43: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   46: sipush 10001
        //   49: aload 5
        //   51: aload 4
        //   53: iconst_0
        //   54: invokeinterface 44 5 0
        //   59: pop
        //   60: aload 4
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload 4
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload 5
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: return
        //   76: aconst_null
        //   77: astore 6
        //   79: goto -50 -> 29
        //   82: astore 6
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	Proxy
        //   0	97	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	97	2	paramLong	long
        //   8	77	4	localParcel1	Parcel
        //   3	87	5	localParcel2	Parcel
        //   27	51	6	localIBinder	IBinder
        //   82	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	65	82	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +65 -> 83
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 5
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload 5
        //   44: aload 4
        //   46: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 10003
        //   56: aload 5
        //   58: aload 6
        //   60: iconst_0
        //   61: invokeinterface 44 5 0
        //   66: pop
        //   67: aload 6
        //   69: invokevirtual 47	android/os/Parcel:readException	()V
        //   72: aload 6
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 5
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 7
        //   86: goto -57 -> 29
        //   89: astore 7
        //   91: aload 6
        //   93: invokevirtual 50	android/os/Parcel:recycle	()V
        //   96: aload 5
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	Proxy
        //   0	104	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	104	2	paramLong	long
        //   0	104	4	paramString	String
        //   3	94	5	localParcel1	Parcel
        //   8	84	6	localParcel2	Parcel
        //   27	58	7	localIBinder	IBinder
        //   89	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	72	89	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5032
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: iload_3
        //   45: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 12024
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString	String
        //   0	103	3	paramInt	int
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 6
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 6
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 9001
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 6
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 7
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 6
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   6	133	6	localParcel1	Parcel
        //   11	123	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 8011
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +79 -> 100
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 5
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 5
        //   47: aload_3
        //   48: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   51: iload 4
        //   53: ifeq +6 -> 59
        //   56: iconst_1
        //   57: istore 8
        //   59: aload 5
        //   61: iload 8
        //   63: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   66: aload_0
        //   67: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   70: sipush 12003
        //   73: aload 5
        //   75: aload 6
        //   77: iconst_0
        //   78: invokeinterface 44 5 0
        //   83: pop
        //   84: aload 6
        //   86: invokevirtual 47	android/os/Parcel:readException	()V
        //   89: aload 6
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 5
        //   96: invokevirtual 50	android/os/Parcel:recycle	()V
        //   99: return
        //   100: aconst_null
        //   101: astore 7
        //   103: goto -71 -> 32
        //   106: astore 7
        //   108: aload 6
        //   110: invokevirtual 50	android/os/Parcel:recycle	()V
        //   113: aload 5
        //   115: invokevirtual 50	android/os/Parcel:recycle	()V
        //   118: aload 7
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	Proxy
        //   0	121	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	121	2	paramString1	String
        //   0	121	3	paramString2	String
        //   0	121	4	paramBoolean	boolean
        //   6	108	5	localParcel1	Parcel
        //   11	98	6	localParcel2	Parcel
        //   30	72	7	localIBinder	IBinder
        //   106	13	7	localObject	Object
        //   1	61	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	89	106	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 4
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 6
        //   52: aload 4
        //   54: iload 6
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 6504
        //   66: aload 4
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 7
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 5
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramString	String
        //   0	114	3	paramBoolean	boolean
        //   6	101	4	localParcel1	Parcel
        //   11	91	5	localParcel2	Parcel
        //   1	54	6	i	int
        //   99	13	6	localObject	Object
        //   30	65	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore_3
        //   12: aload 4
        //   14: ldc 30
        //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +63 -> 83
        //   23: aload_1
        //   24: invokeinterface 59 1 0
        //   29: astore 6
        //   31: aload 4
        //   33: aload 6
        //   35: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   38: iload_2
        //   39: ifeq +6 -> 45
        //   42: iconst_1
        //   43: istore 5
        //   45: aload 4
        //   47: iload 5
        //   49: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   56: sipush 8027
        //   59: aload 4
        //   61: aload_3
        //   62: iconst_0
        //   63: invokeinterface 44 5 0
        //   68: pop
        //   69: aload_3
        //   70: invokevirtual 47	android/os/Parcel:readException	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 6
        //   86: goto -55 -> 31
        //   89: astore 5
        //   91: aload_3
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramBoolean	boolean
        //   11	81	3	localParcel1	Parcel
        //   6	90	4	localParcel2	Parcel
        //   1	47	5	i	int
        //   89	12	5	localObject	Object
        //   29	56	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	73	89	finally
      }
      
      /* Error */
      public void c(IGamesCallbacks paramIGamesCallbacks, String[] paramArrayOfString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 138	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 10020
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramArrayOfString	String[]
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void c(String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt);
          this.ko.transact(8026, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void ch(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeInt(paramInt);
          this.ko.transact(5036, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void d(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
          localParcel2.writeString(paramString);
          this.ko.transact(12014, localParcel2, localParcel1, 0);
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
      public void d(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5026
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +85 -> 106
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: iload_3
        //   46: ifeq +66 -> 112
        //   49: iload 7
        //   51: istore 8
        //   53: aload 5
        //   55: iload 8
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: iload 4
        //   62: ifeq +56 -> 118
        //   65: aload 5
        //   67: iload 7
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: aload_0
        //   73: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   76: sipush 6003
        //   79: aload 5
        //   81: aload 6
        //   83: iconst_0
        //   84: invokeinterface 44 5 0
        //   89: pop
        //   90: aload 6
        //   92: invokevirtual 47	android/os/Parcel:readException	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 50	android/os/Parcel:recycle	()V
        //   105: return
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -77 -> 32
        //   112: iconst_0
        //   113: istore 8
        //   115: goto -62 -> 53
        //   118: iconst_0
        //   119: istore 7
        //   121: goto -56 -> 65
        //   124: astore 7
        //   126: aload 6
        //   128: invokevirtual 50	android/os/Parcel:recycle	()V
        //   131: aload 5
        //   133: invokevirtual 50	android/os/Parcel:recycle	()V
        //   136: aload 7
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	Proxy
        //   0	139	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	139	2	paramInt	int
        //   0	139	3	paramBoolean1	boolean
        //   0	139	4	paramBoolean2	boolean
        //   6	126	5	localParcel1	Parcel
        //   11	116	6	localParcel2	Parcel
        //   1	119	7	localIBinder1	IBinder
        //   124	13	7	localObject	Object
        //   30	78	8	localIBinder2	IBinder
        //   113	1	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	95	124	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, long paramLong)
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
        //   18: ifnull +58 -> 76
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload_0
        //   43: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   46: sipush 12011
        //   49: aload 5
        //   51: aload 4
        //   53: iconst_0
        //   54: invokeinterface 44 5 0
        //   59: pop
        //   60: aload 4
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload 4
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload 5
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: return
        //   76: aconst_null
        //   77: astore 6
        //   79: goto -50 -> 29
        //   82: astore 6
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload 6
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	Proxy
        //   0	97	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	97	2	paramLong	long
        //   8	77	4	localParcel1	Parcel
        //   3	87	5	localParcel2	Parcel
        //   27	51	6	localIBinder	IBinder
        //   82	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	65	82	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, long paramLong, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +65 -> 83
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 7
        //   29: aload 6
        //   31: aload 7
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 6
        //   38: lload_2
        //   39: invokevirtual 121	android/os/Parcel:writeLong	(J)V
        //   42: aload 6
        //   44: aload 4
        //   46: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 12013
        //   56: aload 6
        //   58: aload 5
        //   60: iconst_0
        //   61: invokeinterface 44 5 0
        //   66: pop
        //   67: aload 5
        //   69: invokevirtual 47	android/os/Parcel:readException	()V
        //   72: aload 5
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 6
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 7
        //   86: goto -57 -> 29
        //   89: astore 7
        //   91: aload 5
        //   93: invokevirtual 50	android/os/Parcel:recycle	()V
        //   96: aload 6
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	Proxy
        //   0	104	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	104	2	paramLong	long
        //   0	104	4	paramString	String
        //   8	84	5	localParcel1	Parcel
        //   3	94	6	localParcel2	Parcel
        //   27	58	7	localIBinder	IBinder
        //   89	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	72	89	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 5037
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 7
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 7
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 7
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 9020
        //   86: aload 7
        //   88: aload 6
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 6
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 6
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 7
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   11	123	6	localParcel1	Parcel
        //   6	133	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 8015
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 4
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 4
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 6
        //   52: aload 4
        //   54: iload 6
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 6505
        //   66: aload 4
        //   68: aload 5
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 5
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 5
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 7
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 5
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramString	String
        //   0	114	3	paramBoolean	boolean
        //   6	101	4	localParcel1	Parcel
        //   11	91	5	localParcel2	Parcel
        //   1	54	6	i	int
        //   99	13	6	localObject	Object
        //   30	65	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void d(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +62 -> 81
        //   22: aload_1
        //   23: invokeinterface 59 1 0
        //   28: astore 6
        //   30: aload_3
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: iload_2
        //   37: ifeq +6 -> 43
        //   40: iconst_1
        //   41: istore 5
        //   43: aload_3
        //   44: iload 5
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 12002
        //   56: aload_3
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 50	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 6
        //   84: goto -54 -> 30
        //   87: astore 5
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: invokevirtual 50	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	Proxy
        //   0	101	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	101	2	paramBoolean	boolean
        //   6	89	3	localParcel1	Parcel
        //   10	80	4	localParcel2	Parcel
        //   1	44	5	i	int
        //   87	12	5	localObject	Object
        //   28	55	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	71	87	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5027
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +85 -> 106
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 8
        //   32: aload 5
        //   34: aload 8
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   45: iload_3
        //   46: ifeq +66 -> 112
        //   49: iload 7
        //   51: istore 8
        //   53: aload 5
        //   55: iload 8
        //   57: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   60: iload 4
        //   62: ifeq +56 -> 118
        //   65: aload 5
        //   67: iload 7
        //   69: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   72: aload_0
        //   73: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   76: sipush 6004
        //   79: aload 5
        //   81: aload 6
        //   83: iconst_0
        //   84: invokeinterface 44 5 0
        //   89: pop
        //   90: aload 6
        //   92: invokevirtual 47	android/os/Parcel:readException	()V
        //   95: aload 6
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 50	android/os/Parcel:recycle	()V
        //   105: return
        //   106: aconst_null
        //   107: astore 8
        //   109: goto -77 -> 32
        //   112: iconst_0
        //   113: istore 8
        //   115: goto -62 -> 53
        //   118: iconst_0
        //   119: istore 7
        //   121: goto -56 -> 65
        //   124: astore 7
        //   126: aload 6
        //   128: invokevirtual 50	android/os/Parcel:recycle	()V
        //   131: aload 5
        //   133: invokevirtual 50	android/os/Parcel:recycle	()V
        //   136: aload 7
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	Proxy
        //   0	139	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	139	2	paramInt	int
        //   0	139	3	paramBoolean1	boolean
        //   0	139	4	paramBoolean2	boolean
        //   6	126	5	localParcel1	Parcel
        //   11	116	6	localParcel2	Parcel
        //   1	119	7	localIBinder1	IBinder
        //   124	13	7	localObject	Object
        //   30	78	8	localIBinder2	IBinder
        //   113	1	8	i	int
        // Exception table:
        //   from	to	target	type
        //   13	95	124	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5042
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 6
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 6
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 6
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 6
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 6
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 12021
        //   86: aload 6
        //   88: aload 7
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 7
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 7
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 6
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 7
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 6
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   6	133	6	localParcel1	Parcel
        //   11	123	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 5
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 5
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 5
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 8016
        //   55: aload 5
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 5
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 5
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   8	83	4	localParcel1	Parcel
        //   3	93	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +72 -> 93
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 7
        //   32: aload 5
        //   34: aload 7
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: iload_3
        //   46: ifeq +6 -> 52
        //   49: iconst_1
        //   50: istore 6
        //   52: aload 5
        //   54: iload 6
        //   56: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   59: aload_0
        //   60: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   63: sipush 12006
        //   66: aload 5
        //   68: aload 4
        //   70: iconst_0
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 4
        //   79: invokevirtual 47	android/os/Parcel:readException	()V
        //   82: aload 4
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: invokevirtual 50	android/os/Parcel:recycle	()V
        //   92: return
        //   93: aconst_null
        //   94: astore 7
        //   96: goto -64 -> 32
        //   99: astore 6
        //   101: aload 4
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload 5
        //   108: invokevirtual 50	android/os/Parcel:recycle	()V
        //   111: aload 6
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	Proxy
        //   0	114	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	114	2	paramString	String
        //   0	114	3	paramBoolean	boolean
        //   11	91	4	localParcel1	Parcel
        //   6	101	5	localParcel2	Parcel
        //   1	54	6	i	int
        //   99	13	6	localObject	Object
        //   30	65	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   13	82	99	finally
      }
      
      /* Error */
      public void e(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_3
        //   7: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: aload_3
        //   13: ldc 30
        //   15: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: ifnull +62 -> 81
        //   22: aload_1
        //   23: invokeinterface 59 1 0
        //   28: astore 6
        //   30: aload_3
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: iload_2
        //   37: ifeq +6 -> 43
        //   40: iconst_1
        //   41: istore 5
        //   43: aload_3
        //   44: iload 5
        //   46: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   49: aload_0
        //   50: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   53: sipush 12032
        //   56: aload_3
        //   57: aload 4
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 4
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_3
        //   77: invokevirtual 50	android/os/Parcel:recycle	()V
        //   80: return
        //   81: aconst_null
        //   82: astore 6
        //   84: goto -54 -> 30
        //   87: astore 5
        //   89: aload 4
        //   91: invokevirtual 50	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: invokevirtual 50	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	Proxy
        //   0	101	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	101	2	paramBoolean	boolean
        //   6	89	3	localParcel1	Parcel
        //   10	80	4	localParcel2	Parcel
        //   1	44	5	i	int
        //   87	12	5	localObject	Object
        //   28	55	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	71	87	finally
      }
      
      /* Error */
      public Bundle ea()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 5004
        //   21: aload_1
        //   22: aload_2
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 214	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_2
        //   45: invokeinterface 86 2 0
        //   50: checkcast 124	android/os/Bundle
        //   53: astore_3
        //   54: aload_2
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   3	72	1	localParcel1	Parcel
        //   7	64	2	localParcel2	Parcel
        //   53	13	3	localBundle	Bundle
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public void f(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5047
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void f(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 5043
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      /* Error */
      public void f(IGamesCallbacks paramIGamesCallbacks, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 7
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +92 -> 113
        //   24: aload_1
        //   25: invokeinterface 59 1 0
        //   30: astore 9
        //   32: aload 7
        //   34: aload 9
        //   36: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 7
        //   41: aload_2
        //   42: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   45: aload 7
        //   47: iload_3
        //   48: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   51: iload 4
        //   53: ifeq +66 -> 119
        //   56: iload 8
        //   58: istore 9
        //   60: aload 7
        //   62: iload 9
        //   64: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   67: iload 5
        //   69: ifeq +56 -> 125
        //   72: aload 7
        //   74: iload 8
        //   76: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   79: aload_0
        //   80: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   83: sipush 12022
        //   86: aload 7
        //   88: aload 6
        //   90: iconst_0
        //   91: invokeinterface 44 5 0
        //   96: pop
        //   97: aload 6
        //   99: invokevirtual 47	android/os/Parcel:readException	()V
        //   102: aload 6
        //   104: invokevirtual 50	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: invokevirtual 50	android/os/Parcel:recycle	()V
        //   112: return
        //   113: aconst_null
        //   114: astore 9
        //   116: goto -84 -> 32
        //   119: iconst_0
        //   120: istore 9
        //   122: goto -62 -> 60
        //   125: iconst_0
        //   126: istore 8
        //   128: goto -56 -> 72
        //   131: astore 8
        //   133: aload 6
        //   135: invokevirtual 50	android/os/Parcel:recycle	()V
        //   138: aload 7
        //   140: invokevirtual 50	android/os/Parcel:recycle	()V
        //   143: aload 8
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	146	2	paramString	String
        //   0	146	3	paramInt	int
        //   0	146	4	paramBoolean1	boolean
        //   0	146	5	paramBoolean2	boolean
        //   11	123	6	localParcel1	Parcel
        //   6	133	7	localParcel2	Parcel
        //   1	126	8	localIBinder1	IBinder
        //   131	13	8	localObject	Object
        //   30	85	9	localIBinder2	IBinder
        //   120	1	9	i	int
        // Exception table:
        //   from	to	target	type
        //   13	102	131	finally
      }
      
      /* Error */
      public void f(IGamesCallbacks paramIGamesCallbacks, String paramString1, String paramString2)
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
        //   17: aload_1
        //   18: ifnull +64 -> 82
        //   21: aload_1
        //   22: invokeinterface 59 1 0
        //   27: astore 6
        //   29: aload 4
        //   31: aload 6
        //   33: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: aload_2
        //   39: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   52: sipush 12009
        //   55: aload 4
        //   57: aload 5
        //   59: iconst_0
        //   60: invokeinterface 44 5 0
        //   65: pop
        //   66: aload 5
        //   68: invokevirtual 47	android/os/Parcel:readException	()V
        //   71: aload 5
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: return
        //   82: aconst_null
        //   83: astore 6
        //   85: goto -56 -> 29
        //   88: astore 6
        //   90: aload 5
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 6
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramString1	String
        //   0	103	3	paramString2	String
        //   3	93	4	localParcel1	Parcel
        //   8	83	5	localParcel2	Parcel
        //   27	57	6	localIBinder	IBinder
        //   88	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	71	88	finally
      }
      
      /* Error */
      public void f(IGamesCallbacks paramIGamesCallbacks, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore_3
        //   12: aload 4
        //   14: ldc 30
        //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +63 -> 83
        //   23: aload_1
        //   24: invokeinterface 59 1 0
        //   29: astore 6
        //   31: aload 4
        //   33: aload 6
        //   35: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   38: iload_2
        //   39: ifeq +6 -> 45
        //   42: iconst_1
        //   43: istore 5
        //   45: aload 4
        //   47: iload 5
        //   49: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   56: sipush 12016
        //   59: aload 4
        //   61: aload_3
        //   62: iconst_0
        //   63: invokeinterface 44 5 0
        //   68: pop
        //   69: aload_3
        //   70: invokevirtual 47	android/os/Parcel:readException	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 50	android/os/Parcel:recycle	()V
        //   82: return
        //   83: aconst_null
        //   84: astore 6
        //   86: goto -55 -> 31
        //   89: astore 5
        //   91: aload_3
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 50	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	103	2	paramBoolean	boolean
        //   11	81	3	localParcel1	Parcel
        //   6	90	4	localParcel2	Parcel
        //   1	47	5	i	int
        //   89	12	5	localObject	Object
        //   29	56	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   12	73	89	finally
      }
      
      public ParcelFileDescriptor g(Uri paramUri)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (paramUri != null)
            {
              localParcel1.writeInt(1);
              paramUri.writeToParcel(localParcel1, 0);
              this.ko.transact(6507, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(localParcel2);
                return localParcelFileDescriptor;
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
      
      /* Error */
      public void g(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5049
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void g(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5052
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public String gU()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(5007, localParcel2, localParcel1, 0);
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
      
      public String gV()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(5012, localParcel2, localParcel1, 0);
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
      public Intent gY()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9003
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_1
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_1
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_1
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   7	64	1	localParcel1	Parcel
        //   3	72	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public Intent gZ()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9005
        //   21: aload_1
        //   22: aload_2
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_2
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_2
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   3	72	1	localParcel1	Parcel
        //   7	64	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public RoomEntity h(IGamesCallbacks paramIGamesCallbacks, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 6
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 4
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore_3
        //   12: aload 4
        //   14: ldc 30
        //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +78 -> 98
        //   23: aload_1
        //   24: invokeinterface 59 1 0
        //   29: astore 5
        //   31: aload 4
        //   33: aload 5
        //   35: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   38: aload 4
        //   40: aload_2
        //   41: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   44: aload_0
        //   45: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   48: sipush 5053
        //   51: aload 4
        //   53: aload_3
        //   54: iconst_0
        //   55: invokeinterface 44 5 0
        //   60: pop
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:readException	()V
        //   65: aload_3
        //   66: invokevirtual 73	android/os/Parcel:readInt	()I
        //   69: ifeq +17 -> 86
        //   72: getstatic 225	com/google/android/gms/games/multiplayer/realtime/RoomEntity:CREATOR	Landroid/os/Parcelable$Creator;
        //   75: aload_3
        //   76: invokeinterface 86 2 0
        //   81: checkcast 101	com/google/android/gms/games/multiplayer/realtime/RoomEntity
        //   84: astore 6
        //   86: aload_3
        //   87: invokevirtual 50	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: invokevirtual 50	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: areturn
        //   98: aconst_null
        //   99: astore 5
        //   101: goto -70 -> 31
        //   104: astore 5
        //   106: aload_3
        //   107: invokevirtual 50	android/os/Parcel:recycle	()V
        //   110: aload 4
        //   112: invokevirtual 50	android/os/Parcel:recycle	()V
        //   115: aload 5
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	Proxy
        //   0	118	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	118	2	paramString	String
        //   11	96	3	localParcel1	Parcel
        //   6	105	4	localParcel2	Parcel
        //   29	71	5	localIBinder	IBinder
        //   104	12	5	localObject	Object
        //   1	95	6	localRoomEntity	RoomEntity
        // Exception table:
        //   from	to	target	type
        //   12	86	104	finally
      }
      
      /* Error */
      public void h(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5056
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public Intent ha()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9006
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_1
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_1
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_1
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   7	64	1	localParcel1	Parcel
        //   3	72	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public Intent hb()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9007
        //   21: aload_1
        //   22: aload_2
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_2
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_2
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   3	72	1	localParcel1	Parcel
        //   7	64	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public Intent hg()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9010
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_1
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_1
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_1
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   7	64	1	localParcel1	Parcel
        //   3	72	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      /* Error */
      public Intent hh()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9012
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_1
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_1
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_1
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   7	64	1	localParcel1	Parcel
        //   3	72	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      public int hi()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(9019, localParcel2, localParcel1, 0);
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
      
      public String hj()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(5003, localParcel1, localParcel2, 0);
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
      
      public int hk()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(8024, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public Intent hl()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 10015
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_1
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_1
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_1
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   7	64	1	localParcel1	Parcel
        //   3	72	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      public int hm()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(10013, localParcel2, localParcel1, 0);
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
      
      public int hn()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(10023, localParcel2, localParcel1, 0);
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
      
      public int ho()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(12035, localParcel2, localParcel1, 0);
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
      
      public int hp()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(12036, localParcel2, localParcel1, 0);
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
      
      public void hr()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(5006, localParcel2, localParcel1, 0);
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
      public DataHolder ht()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 5013
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +23 -> 61
        //   41: getstatic 245	com/google/android/gms/common/data/DataHolder:CREATOR	Lcom/google/android/gms/common/data/f;
        //   44: aload_1
        //   45: invokevirtual 251	com/google/android/gms/common/data/f:x	(Landroid/os/Parcel;)Lcom/google/android/gms/common/data/DataHolder;
        //   48: astore_3
        //   49: aload_3
        //   50: astore_3
        //   51: aload_1
        //   52: invokevirtual 50	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 50	android/os/Parcel:recycle	()V
        //   59: aload_3
        //   60: areturn
        //   61: aconst_null
        //   62: astore_3
        //   63: goto -12 -> 51
        //   66: astore_3
        //   67: aload_1
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: aload_3
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	Proxy
        //   7	61	1	localParcel1	Parcel
        //   3	69	2	localParcel2	Parcel
        //   48	15	3	localDataHolder	DataHolder
        //   66	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
      }
      
      public boolean hu()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(5067, localParcel1, localParcel2, 0);
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
      public DataHolder hv()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_1
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 5502
        //   21: aload_2
        //   22: aload_1
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_1
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_1
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +23 -> 61
        //   41: getstatic 245	com/google/android/gms/common/data/DataHolder:CREATOR	Lcom/google/android/gms/common/data/f;
        //   44: aload_1
        //   45: invokevirtual 251	com/google/android/gms/common/data/f:x	(Landroid/os/Parcel;)Lcom/google/android/gms/common/data/DataHolder;
        //   48: astore_3
        //   49: aload_3
        //   50: astore_3
        //   51: aload_1
        //   52: invokevirtual 50	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 50	android/os/Parcel:recycle	()V
        //   59: aload_3
        //   60: areturn
        //   61: aconst_null
        //   62: astore_3
        //   63: goto -12 -> 51
        //   66: astore_3
        //   67: aload_1
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 50	android/os/Parcel:recycle	()V
        //   75: aload_3
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	Proxy
        //   7	61	1	localParcel1	Parcel
        //   3	69	2	localParcel2	Parcel
        //   48	15	3	localDataHolder	DataHolder
        //   66	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	49	66	finally
      }
      
      public void hw()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(8022, localParcel1, localParcel2, 0);
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
      public Intent hx()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   18: sipush 9013
        //   21: aload_1
        //   22: aload_2
        //   23: iconst_0
        //   24: invokeinterface 44 5 0
        //   29: pop
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:readException	()V
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:readInt	()I
        //   38: ifeq +26 -> 64
        //   41: getstatic 80	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   44: aload_2
        //   45: invokeinterface 86 2 0
        //   50: checkcast 76	android/content/Intent
        //   53: astore_3
        //   54: aload_2
        //   55: invokevirtual 50	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 50	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: areturn
        //   64: aconst_null
        //   65: astore_3
        //   66: goto -12 -> 54
        //   69: astore_3
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: invokevirtual 50	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   3	72	1	localParcel1	Parcel
        //   7	64	2	localParcel2	Parcel
        //   53	13	3	localIntent	Intent
        //   69	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	69	finally
      }
      
      public void hy()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(11002, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public boolean hz()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          this.ko.transact(12025, localParcel1, localParcel2, 0);
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
      public void i(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 5062
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void i(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5061
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void j(IGamesCallbacks paramIGamesCallbacks)
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
        //   15: ifnull +46 -> 61
        //   18: aload_1
        //   19: invokeinterface 59 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   36: sipush 11001
        //   39: aload_3
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 47	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aconst_null
        //   62: astore 4
        //   64: goto -38 -> 26
        //   67: astore 4
        //   69: aload_2
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	Proxy
        //   0	80	1	paramIGamesCallbacks	IGamesCallbacks
        //   7	63	2	localParcel1	Parcel
        //   3	71	3	localParcel2	Parcel
        //   24	39	4	localIBinder	IBinder
        //   67	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void j(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 5057
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void k(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 7001
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      /* Error */
      public void l(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 8005
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      public void l(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeString(paramString);
          localParcel2.writeInt(paramInt);
          this.ko.transact(12017, localParcel2, localParcel1, 0);
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
      public void m(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 8006
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void m(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeString(paramString);
          localParcel2.writeInt(paramInt);
          this.ko.transact(5029, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void m(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.ko.transact(5065, localParcel1, localParcel2, 0);
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
      public void n(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 8009
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      public void n(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeString(paramString);
          localParcel2.writeInt(paramInt);
          this.ko.transact(5028, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
      
      public void n(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeString(paramString1);
          localParcel2.writeString(paramString2);
          this.ko.transact(8025, localParcel2, localParcel1, 0);
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
      public void o(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 8010
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      /* Error */
      public void p(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 8014
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      public void p(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.ko.transact(5055, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void q(long paramLong)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
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
      public void q(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 9002
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void q(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.ko.transact(10014, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void r(long paramLong)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
          this.ko.transact(5059, localParcel2, localParcel1, 0);
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
      public void r(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 12020
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void s(long paramLong)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel2.writeLong(paramLong);
          this.ko.transact(8013, localParcel2, localParcel1, 0);
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
      public void s(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 12005
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
      
      public void t(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeLong(paramLong);
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
      
      /* Error */
      public void t(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   17: ifnull +55 -> 72
        //   20: aload_1
        //   21: invokeinterface 59 1 0
        //   26: astore 5
        //   28: aload 4
        //   30: aload 5
        //   32: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload 4
        //   37: aload_2
        //   38: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   45: sipush 12027
        //   48: aload 4
        //   50: aload_3
        //   51: iconst_0
        //   52: invokeinterface 44 5 0
        //   57: pop
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:readException	()V
        //   62: aload_3
        //   63: invokevirtual 50	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aconst_null
        //   73: astore 5
        //   75: goto -47 -> 28
        //   78: astore 5
        //   80: aload_3
        //   81: invokevirtual 50	android/os/Parcel:recycle	()V
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   0	92	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	92	2	paramString	String
        //   8	73	3	localParcel1	Parcel
        //   3	82	4	localParcel2	Parcel
        //   26	48	5	localIBinder	IBinder
        //   78	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	62	78	finally
      }
      
      public void u(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
          localParcel1.writeLong(paramLong);
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
      public void u(IGamesCallbacks paramIGamesCallbacks, String paramString)
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
        //   16: ifnull +54 -> 70
        //   19: aload_1
        //   20: invokeinterface 59 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 69	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/games/internal/IGamesService$Stub$Proxy:ko	Landroid/os/IBinder;
        //   42: sipush 12008
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 47	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 50	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aconst_null
        //   71: astore 5
        //   73: goto -46 -> 27
        //   76: astore 5
        //   78: aload 4
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload_3
        //   84: invokevirtual 50	android/os/Parcel:recycle	()V
        //   87: aload 5
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	Proxy
        //   0	90	1	paramIGamesCallbacks	IGamesCallbacks
        //   0	90	2	paramString	String
        //   3	81	3	localParcel1	Parcel
        //   7	72	4	localParcel2	Parcel
        //   25	47	5	localIBinder	IBinder
        //   76	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	60	76	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.IGamesService
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.a;
import com.google.android.gms.location.a.a;
import com.google.android.gms.location.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;
import java.util.List;

public abstract interface jf
  extends IInterface
{
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent, je paramje, String paramString)
    throws RemoteException;
  
  public abstract void a(Location paramLocation, int paramInt)
    throws RemoteException;
  
  public abstract void a(je paramje, String paramString)
    throws RemoteException;
  
  public abstract void a(jl paramjl, kb paramkb, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(jn paramjn, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(jp paramjp, kb paramkb)
    throws RemoteException;
  
  public abstract void a(jr paramjr, kb paramkb, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(jv paramjv, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(kb paramkb, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, a parama)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, a parama, String paramString)
    throws RemoteException;
  
  public abstract void a(a parama)
    throws RemoteException;
  
  public abstract void a(LatLng paramLatLng, jn paramjn, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, jn paramjn, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, jn paramjn, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(String paramString, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(String paramString, LatLngBounds paramLatLngBounds, jn paramjn, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(String paramString, List<String> paramList, List<jx> paramList1, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract void a(List<ji> paramList, PendingIntent paramPendingIntent, je paramje, String paramString)
    throws RemoteException;
  
  public abstract void a(String[] paramArrayOfString, je paramje, String paramString)
    throws RemoteException;
  
  public abstract void b(kb paramkb, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void b(String paramString, kb paramkb, jz paramjz)
    throws RemoteException;
  
  public abstract Location bo(String paramString)
    throws RemoteException;
  
  public abstract b bp(String paramString)
    throws RemoteException;
  
  public abstract Location iR()
    throws RemoteException;
  
  public abstract IBinder iS()
    throws RemoteException;
  
  public abstract void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void setMockLocation(Location paramLocation)
    throws RemoteException;
  
  public abstract void setMockMode(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements jf
  {
    public static jf as(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if ((localObject == null) || (!(localObject instanceof jf))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (jf)localObject;
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
      int j = 0;
      Object localObject1 = 1;
      PendingIntent localPendingIntent = null;
      Object localObject4;
      Object localObject7;
      Object localObject2;
      Object localObject5;
      Object localObject3;
      Object localObject6;
      switch (paramInt1)
      {
      default: 
        localObject1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject4 = paramParcel1.createTypedArrayList(ji.CREATOR);
        if (paramParcel1.readInt() == 0) {
          localPendingIntent = null;
        } else {
          localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((List)localObject4, localPendingIntent, je.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localPendingIntent = null;
        } else {
          localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a(localPendingIntent, je.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createStringArray(), je.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(je.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        long l = paramParcel1.readLong();
        boolean bool;
        if (paramParcel1.readInt() == 0) {
          bool = false;
        } else {
          bool = localObject1;
        }
        if (paramParcel1.readInt() == 0) {
          localObject7 = null;
        } else {
          localObject7 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a(l, bool, (PendingIntent)localObject7);
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        removeActivityUpdates((PendingIntent)localObject2);
        paramParcel2.writeNoException();
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = iR();
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Location)localObject2).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject2 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((LocationRequest)localObject2, a.a.aq(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((LocationRequest)localObject4, (PendingIntent)localObject2);
        paramParcel2.writeNoException();
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(a.a.aq(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((PendingIntent)localObject2);
        paramParcel2.writeNoException();
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject4 = localObject1;
        }
        setMockMode(localObject4);
        paramParcel2.writeNoException();
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject2 = null;
        } else {
          localObject2 = (Location)Location.CREATOR.createFromParcel(paramParcel1);
        }
        setMockLocation((Location)localObject2);
        paramParcel2.writeNoException();
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        int i = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          localObject5 = null;
        } else {
          localObject5 = jn.CREATOR.bv(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject7 = null;
        } else {
          localObject7 = kb.CREATOR.bB(paramParcel1);
        }
        a((LatLngBounds)localObject4, i, (jn)localObject5, (kb)localObject7, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((String)localObject4, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = LatLng.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject5 = null;
        } else {
          localObject5 = jn.CREATOR.bv(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((LatLng)localObject4, (jn)localObject5, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = jn.CREATOR.bv(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((jn)localObject4, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject5 = null;
        } else {
          localObject5 = jr.CREATOR.bx(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((jr)localObject5, (kb)localObject3, (PendingIntent)localObject4);
        paramParcel2.writeNoException();
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = kb.CREATOR.bB(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((kb)localObject4, (PendingIntent)localObject3);
        paramParcel2.writeNoException();
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {
          localObject3 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((LocationRequest)localObject3, a.a.aq(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject3 = bo(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject3 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((Location)localObject3).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = jp.CREATOR.bw(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((jp)localObject4, (kb)localObject3);
        break;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (Location)Location.CREATOR.createFromParcel(paramParcel1);
        }
        a((Location)localObject3, paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject3 = bp(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localObject3 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(localObject1);
          ((b)localObject3).writeToParcel(paramParcel2, localObject1);
        }
        break;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        b((String)localObject4, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 45: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject7 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = jn.CREATOR.bv(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject5 = null;
        } else {
          localObject5 = kb.CREATOR.bB(paramParcel1);
        }
        a((String)localObject7, (LatLngBounds)localObject4, (jn)localObject3, (kb)localObject5, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 46: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = (jv)jv.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((jv)localObject4, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 47: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        }
        int k = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          localObject7 = null;
        } else {
          localObject7 = jn.CREATOR.bv(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((LatLngBounds)localObject4, k, str, (jn)localObject7, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 48: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = jl.CREATOR.bu(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject6 = null;
        } else {
          localObject6 = kb.CREATOR.bB(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((jl)localObject4, (kb)localObject6, (PendingIntent)localObject3);
        paramParcel2.writeNoException();
        break;
      case 49: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() == 0) {
          localObject4 = null;
        } else {
          localObject4 = kb.CREATOR.bB(paramParcel1);
        }
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        b((kb)localObject4, (PendingIntent)localObject3);
        paramParcel2.writeNoException();
        break;
      case 50: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject4 = paramParcel1.readString();
        localObject6 = paramParcel1.createStringArrayList();
        localObject7 = paramParcel1.createTypedArrayList(jx.CREATOR);
        if (paramParcel1.readInt() == 0) {
          localObject3 = null;
        } else {
          localObject3 = kb.CREATOR.bB(paramParcel1);
        }
        a((String)localObject4, (List)localObject6, (List)localObject7, (kb)localObject3, jz.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 51: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject3 = iS();
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder((IBinder)localObject3);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      }
      return localObject1;
    }
    
    private static class a
      implements jf
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 29
        //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: lload_1
        //   23: invokevirtual 37	android/os/Parcel:writeLong	(J)V
        //   26: iload_3
        //   27: ifeq +61 -> 88
        //   30: aload 5
        //   32: iload 7
        //   34: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   37: aload 4
        //   39: ifnull +55 -> 94
        //   42: aload 5
        //   44: iconst_1
        //   45: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   48: aload 4
        //   50: aload 5
        //   52: iconst_0
        //   53: invokevirtual 47	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload_0
        //   57: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   60: iconst_5
        //   61: aload 5
        //   63: aload 6
        //   65: iconst_0
        //   66: invokeinterface 53 5 0
        //   71: pop
        //   72: aload 6
        //   74: invokevirtual 56	android/os/Parcel:readException	()V
        //   77: aload 6
        //   79: invokevirtual 59	android/os/Parcel:recycle	()V
        //   82: aload 5
        //   84: invokevirtual 59	android/os/Parcel:recycle	()V
        //   87: return
        //   88: iconst_0
        //   89: istore 7
        //   91: goto -61 -> 30
        //   94: aload 5
        //   96: iconst_0
        //   97: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   100: goto -44 -> 56
        //   103: astore 7
        //   105: aload 6
        //   107: invokevirtual 59	android/os/Parcel:recycle	()V
        //   110: aload 5
        //   112: invokevirtual 59	android/os/Parcel:recycle	()V
        //   115: aload 7
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramLong	long
        //   0	118	3	paramBoolean	boolean
        //   0	118	4	paramPendingIntent	PendingIntent
        //   6	105	5	localParcel1	Parcel
        //   11	95	6	localParcel2	Parcel
        //   1	89	7	i	int
        //   103	13	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	77	103	finally
        //   94	100	103	finally
      }
      
      /* Error */
      public void a(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_2
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +45 -> 61
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 47	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 11
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 53 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 56	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 59	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 59	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_2
        //   62: iconst_0
        //   63: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_3
        //   70: aload 4
        //   72: invokevirtual 59	android/os/Parcel:recycle	()V
        //   75: aload_2
        //   76: invokevirtual 59	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramPendingIntent	PendingIntent
        //   3	73	2	localParcel1	Parcel
        //   69	11	3	localObject	Object
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      public void a(PendingIntent paramPendingIntent, je paramje, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramje != null)
              {
                IBinder localIBinder = paramje.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.ko.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      public void a(Location paramLocation, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +55 -> 73
        //   21: aload 4
        //   23: iconst_1
        //   24: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 4
        //   30: iconst_0
        //   31: invokevirtual 77	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 4
        //   36: iload_2
        //   37: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   44: bipush 26
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 53 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 56	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 59	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 59	android/os/Parcel:recycle	()V
        //   72: return
        //   73: aload 4
        //   75: iconst_0
        //   76: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   79: goto -45 -> 34
        //   82: astore_3
        //   83: aload 5
        //   85: invokevirtual 59	android/os/Parcel:recycle	()V
        //   88: aload 4
        //   90: invokevirtual 59	android/os/Parcel:recycle	()V
        //   93: aload_3
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramLocation	Location
        //   0	95	2	paramInt	int
        //   82	12	3	localObject	Object
        //   3	86	4	localParcel1	Parcel
        //   8	76	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	62	82	finally
        //   73	79	82	finally
      }
      
      /* Error */
      public void a(je paramje, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +52 -> 68
        //   19: aload_1
        //   20: invokeinterface 67 1 0
        //   25: astore 5
        //   27: aload_3
        //   28: aload 5
        //   30: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   42: iconst_4
        //   43: aload_3
        //   44: aload 4
        //   46: iconst_0
        //   47: invokeinterface 53 5 0
        //   52: pop
        //   53: aload 4
        //   55: invokevirtual 56	android/os/Parcel:readException	()V
        //   58: aload 4
        //   60: invokevirtual 59	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 59	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aconst_null
        //   69: astore 5
        //   71: goto -44 -> 27
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 59	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 59	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramje	je
        //   0	88	2	paramString	String
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   25	45	5	localIBinder	IBinder
        //   74	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	58	74	finally
      }
      
      public void a(jl paramjl, kb paramkb, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramjl != null)
            {
              localParcel1.writeInt(1);
              paramjl.writeToParcel(localParcel1, 0);
              if (paramkb != null)
              {
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label134;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.ko.transact(48, localParcel1, localParcel2, 0);
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
          label134:
          localParcel1.writeInt(0);
        }
      }
      
      public void a(jn paramjn, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramjn != null)
            {
              localParcel1.writeInt(1);
              paramjn.writeToParcel(localParcel1, 0);
              if (paramkb != null)
              {
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label136;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(17, localParcel1, localParcel2, 0);
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
          label136:
          Object localObject2 = null;
        }
      }
      
      public void a(jp paramjp, kb paramkb)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramjp != null)
            {
              localParcel.writeInt(1);
              paramjp.writeToParcel(localParcel, 0);
              if (paramkb != null)
              {
                localParcel.writeInt(1);
                paramkb.writeToParcel(localParcel, 0);
                this.ko.transact(25, localParcel, null, 1);
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
      
      public void a(jr paramjr, kb paramkb, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramjr != null)
            {
              localParcel2.writeInt(1);
              paramjr.writeToParcel(localParcel2, 0);
              if (paramkb != null)
              {
                localParcel2.writeInt(1);
                paramkb.writeToParcel(localParcel2, 0);
                if (paramPendingIntent == null) {
                  break label134;
                }
                localParcel2.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel2, 0);
                this.ko.transact(18, localParcel2, localParcel1, 0);
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
          continue;
          label134:
          localParcel2.writeInt(0);
        }
      }
      
      public void a(jv paramjv, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramjv != null)
            {
              localParcel1.writeInt(1);
              paramjv.writeToParcel(localParcel1, 0);
              if (paramkb != null)
              {
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label136;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(46, localParcel1, localParcel2, 0);
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
          label136:
          Object localObject2 = null;
        }
      }
      
      public void a(kb paramkb, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramkb != null)
            {
              localParcel1.writeInt(1);
              paramkb.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.ko.transact(19, localParcel1, localParcel2, 0);
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
      
      public void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.ko.transact(9, localParcel1, localParcel2, 0);
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
      
      public void a(LocationRequest paramLocationRequest, a parama)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel2.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel2, 0);
              if (parama != null)
              {
                IBinder localIBinder = parama.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(8, localParcel2, localParcel1, 0);
                localParcel1.readException();
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
      
      public void a(LocationRequest paramLocationRequest, a parama, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                IBinder localIBinder = parama.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.ko.transact(20, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      public void a(a parama)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 113 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 10
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 53 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 59	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 59	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 59	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 59	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	parama	a
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public void a(LatLng paramLatLng, jn paramjn, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLng != null)
            {
              localParcel1.writeInt(1);
              paramLatLng.writeToParcel(localParcel1, 0);
              if (paramjn != null)
              {
                localParcel1.writeInt(1);
                paramjn.writeToParcel(localParcel1, 0);
                if (paramkb == null) {
                  break label155;
                }
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label164;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(16, localParcel1, localParcel2, 0);
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
          label155:
          localParcel1.writeInt(0);
          continue;
          label164:
          Object localObject2 = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, jn paramjn, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (paramjn != null)
              {
                localParcel1.writeInt(1);
                paramjn.writeToParcel(localParcel1, 0);
                if (paramkb == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label172;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(14, localParcel1, localParcel2, 0);
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
          label163:
          localParcel1.writeInt(0);
          continue;
          label172:
          Object localObject2 = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, jn paramjn, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              localParcel1.writeString(paramString);
              if (paramjn != null)
              {
                localParcel1.writeInt(1);
                paramjn.writeToParcel(localParcel1, 0);
                if (paramkb == null) {
                  break label171;
                }
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label180;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(47, localParcel1, localParcel2, 0);
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
          label171:
          localParcel1.writeInt(0);
          continue;
          label180:
          Object localObject2 = null;
        }
      }
      
      public void a(String paramString, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramkb != null)
            {
              localParcel1.writeInt(1);
              paramkb.writeToParcel(localParcel1, 0);
              if (paramjz != null)
              {
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(15, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void a(String paramString, LatLngBounds paramLatLngBounds, jn paramjn, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              if (paramjn != null)
              {
                localParcel1.writeInt(1);
                paramjn.writeToParcel(localParcel1, 0);
                if (paramkb == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramkb.writeToParcel(localParcel1, 0);
                if (paramjz == null) {
                  break label172;
                }
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(45, localParcel1, localParcel2, 0);
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
          label163:
          localParcel1.writeInt(0);
          continue;
          label172:
          Object localObject2 = null;
        }
      }
      
      public void a(String paramString, List<String> paramList, List<jx> paramList1, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            localParcel1.writeStringList(paramList);
            localParcel1.writeTypedList(paramList1);
            if (paramkb != null)
            {
              localParcel1.writeInt(1);
              paramkb.writeToParcel(localParcel1, 0);
              if (paramjz != null)
              {
                IBinder localIBinder = paramjz.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(50, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void a(List<ji> paramList, PendingIntent paramPendingIntent, je paramje, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeTypedList(paramList);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramje != null)
              {
                IBinder localIBinder = paramje.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.ko.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      public void a(String[] paramArrayOfString, je paramje, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 140	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnull +56 -> 80
        //   27: aload_2
        //   28: invokeinterface 67 1 0
        //   33: astore 6
        //   35: aload 4
        //   37: aload 6
        //   39: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   52: iconst_3
        //   53: aload 4
        //   55: aload 5
        //   57: iconst_0
        //   58: invokeinterface 53 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 56	android/os/Parcel:readException	()V
        //   69: aload 5
        //   71: invokevirtual 59	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: invokevirtual 59	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aconst_null
        //   81: astore 6
        //   83: goto -48 -> 35
        //   86: astore 6
        //   88: aload 5
        //   90: invokevirtual 59	android/os/Parcel:recycle	()V
        //   93: aload 4
        //   95: invokevirtual 59	android/os/Parcel:recycle	()V
        //   98: aload 6
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramArrayOfString	String[]
        //   0	101	2	paramje	je
        //   0	101	3	paramString	String
        //   3	91	4	localParcel1	Parcel
        //   8	81	5	localParcel2	Parcel
        //   33	49	6	localIBinder	IBinder
        //   86	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   10	69	86	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(kb paramkb, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramkb != null)
            {
              localParcel2.writeInt(1);
              paramkb.writeToParcel(localParcel2, 0);
              if (paramPendingIntent != null)
              {
                localParcel2.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel2, 0);
                this.ko.transact(49, localParcel2, localParcel1, 0);
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
      
      public void b(String paramString, kb paramkb, jz paramjz)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel2.writeString(paramString);
            if (paramkb != null)
            {
              localParcel2.writeInt(1);
              paramkb.writeToParcel(localParcel2, 0);
              if (paramjz != null)
              {
                IBinder localIBinder = paramjz.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(42, localParcel2, localParcel1, 0);
                localParcel1.readException();
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
      
      /* Error */
      public Location bo(String paramString)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   23: bipush 21
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 53 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 56	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 147	android/os/Parcel:readInt	()I
        //   42: ifeq +28 -> 70
        //   45: getstatic 151	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 157 2 0
        //   54: checkcast 76	android/location/Location
        //   57: astore 4
        //   59: aload_3
        //   60: invokevirtual 59	android/os/Parcel:recycle	()V
        //   63: aload_2
        //   64: invokevirtual 59	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: areturn
        //   70: aconst_null
        //   71: astore 4
        //   73: goto -14 -> 59
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 59	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 59	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramString	String
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   57	15	4	localLocation	Location
        //   76	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	59	76	finally
      }
      
      /* Error */
      public b bp(String paramString)
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
        //   14: aload_3
        //   15: aload_1
        //   16: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   23: bipush 34
        //   25: aload_3
        //   26: aload_2
        //   27: iconst_0
        //   28: invokeinterface 53 5 0
        //   33: pop
        //   34: aload_2
        //   35: invokevirtual 56	android/os/Parcel:readException	()V
        //   38: aload_2
        //   39: invokevirtual 147	android/os/Parcel:readInt	()I
        //   42: ifeq +27 -> 69
        //   45: getstatic 164	com/google/android/gms/location/b:CREATOR	Lcom/google/android/gms/location/c;
        //   48: aload_2
        //   49: invokevirtual 170	com/google/android/gms/location/c:bs	(Landroid/os/Parcel;)Lcom/google/android/gms/location/b;
        //   52: astore 4
        //   54: aload 4
        //   56: astore 4
        //   58: aload_2
        //   59: invokevirtual 59	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 59	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: areturn
        //   69: aconst_null
        //   70: astore 4
        //   72: goto -14 -> 58
        //   75: astore 4
        //   77: aload_2
        //   78: invokevirtual 59	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 59	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramString	String
        //   7	71	2	localParcel1	Parcel
        //   3	79	3	localParcel2	Parcel
        //   52	19	4	localb	b
        //   75	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	54	75	finally
      }
      
      /* Error */
      public Location iR()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   18: bipush 7
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 53 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 56	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 147	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 151	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_2
        //   44: invokeinterface 157 2 0
        //   49: checkcast 76	android/location/Location
        //   52: astore_3
        //   53: aload_2
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: areturn
        //   63: aconst_null
        //   64: astore_3
        //   65: goto -12 -> 53
        //   68: astore_3
        //   69: aload_2
        //   70: invokevirtual 59	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: invokevirtual 59	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   3	71	1	localParcel1	Parcel
        //   7	63	2	localParcel2	Parcel
        //   52	13	3	localLocation	Location
        //   68	10	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public IBinder iS()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.ko.transact(51, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void removeActivityUpdates(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: aload 4
        //   11: ldc 29
        //   13: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 47	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 6
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 53 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 56	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 59	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 59	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 59	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramPendingIntent	PendingIntent
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      /* Error */
      public void setMockLocation(Location paramLocation)
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
        //   15: ifnull +42 -> 57
        //   18: aload_3
        //   19: iconst_1
        //   20: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_3
        //   25: iconst_0
        //   26: invokevirtual 77	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/jf$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 13
        //   35: aload_3
        //   36: aload_2
        //   37: iconst_0
        //   38: invokeinterface 53 5 0
        //   43: pop
        //   44: aload_2
        //   45: invokevirtual 56	android/os/Parcel:readException	()V
        //   48: aload_2
        //   49: invokevirtual 59	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 59	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_3
        //   58: iconst_0
        //   59: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_2
        //   68: invokevirtual 59	android/os/Parcel:recycle	()V
        //   71: aload_3
        //   72: invokevirtual 59	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramLocation	Location
        //   7	61	2	localParcel1	Parcel
        //   3	69	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      public void setMockMode(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.ko.transact(12, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.internal.jf
 * JD-Core Version:    0.7.0.1
 */
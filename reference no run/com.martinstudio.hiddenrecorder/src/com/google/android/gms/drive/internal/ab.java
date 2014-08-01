package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.drive.realtime.internal.m;
import com.google.android.gms.drive.realtime.internal.m.a;

public abstract interface ab
  extends IInterface
{
  public abstract void a(OnContentsResponse paramOnContentsResponse)
    throws RemoteException;
  
  public abstract void a(OnDownloadProgressResponse paramOnDownloadProgressResponse)
    throws RemoteException;
  
  public abstract void a(OnDriveIdResponse paramOnDriveIdResponse)
    throws RemoteException;
  
  public abstract void a(OnListEntriesResponse paramOnListEntriesResponse)
    throws RemoteException;
  
  public abstract void a(OnListParentsResponse paramOnListParentsResponse)
    throws RemoteException;
  
  public abstract void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, m paramm)
    throws RemoteException;
  
  public abstract void a(OnMetadataResponse paramOnMetadataResponse)
    throws RemoteException;
  
  public abstract void a(OnResourceIdSetResponse paramOnResourceIdSetResponse)
    throws RemoteException;
  
  public abstract void a(OnStorageStatsResponse paramOnStorageStatsResponse)
    throws RemoteException;
  
  public abstract void a(OnSyncMoreResponse paramOnSyncMoreResponse)
    throws RemoteException;
  
  public abstract void o(Status paramStatus)
    throws RemoteException;
  
  public abstract void onSuccess()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ab
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    }
    
    public static ab Q(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        if ((localObject == null) || (!(localObject instanceof ab))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (ab)localObject;
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
      int i1;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnDownloadProgressResponse localOnDownloadProgressResponse;
        if (paramParcel1.readInt() != 0) {
          localOnDownloadProgressResponse = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnDownloadProgressResponse);
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnListEntriesResponse localOnListEntriesResponse;
        if (paramParcel1.readInt() != 0) {
          localOnListEntriesResponse = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnListEntriesResponse);
        paramParcel2.writeNoException();
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnDriveIdResponse localOnDriveIdResponse;
        if (paramParcel1.readInt() != 0) {
          localOnDriveIdResponse = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnDriveIdResponse);
        paramParcel2.writeNoException();
        int k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnMetadataResponse localOnMetadataResponse;
        if (paramParcel1.readInt() != 0) {
          localOnMetadataResponse = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnMetadataResponse);
        paramParcel2.writeNoException();
        int m = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnContentsResponse localOnContentsResponse;
        if (paramParcel1.readInt() != 0) {
          localOnContentsResponse = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnContentsResponse);
        paramParcel2.writeNoException();
        int n = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        Status localStatus;
        if (paramParcel1.readInt() != 0) {
          localStatus = Status.CREATOR.createFromParcel(paramParcel1);
        }
        o(localStatus);
        paramParcel2.writeNoException();
        i1 = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        onSuccess();
        paramParcel2.writeNoException();
        i1 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnListParentsResponse localOnListParentsResponse;
        if (paramParcel1.readInt() != 0) {
          localOnListParentsResponse = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnListParentsResponse);
        paramParcel2.writeNoException();
        int i2 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnSyncMoreResponse localOnSyncMoreResponse;
        if (paramParcel1.readInt() != 0) {
          localOnSyncMoreResponse = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnSyncMoreResponse);
        paramParcel2.writeNoException();
        int i3 = 1;
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnStorageStatsResponse localOnStorageStatsResponse;
        if (paramParcel1.readInt() != 0) {
          localOnStorageStatsResponse = (OnStorageStatsResponse)OnStorageStatsResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnStorageStatsResponse);
        paramParcel2.writeNoException();
        int i4 = 1;
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnLoadRealtimeResponse localOnLoadRealtimeResponse;
        if (paramParcel1.readInt() != 0) {
          localOnLoadRealtimeResponse = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnLoadRealtimeResponse, m.a.ac(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i5 = 1;
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        OnResourceIdSetResponse localOnResourceIdSetResponse;
        if (paramParcel1.readInt() != 0) {
          localOnResourceIdSetResponse = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOnResourceIdSetResponse);
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements ab
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(OnContentsResponse paramOnContentsResponse)
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
        //   16: ifnull +44 -> 60
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 43	com/google/android/gms/drive/internal/OnContentsResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_5
        //   35: aload_2
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 49 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_2
        //   61: iconst_0
        //   62: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_3
        //   69: aload 4
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 55	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramOnContentsResponse	OnContentsResponse
        //   3	72	2	localParcel1	Parcel
        //   68	11	3	localObject	Object
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      /* Error */
      public void a(OnDownloadProgressResponse paramOnDownloadProgressResponse)
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
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 59	com/google/android/gms/drive/internal/OnDownloadProgressResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 49 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 52	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 55	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore 4
        //   66: aload_3
        //   67: invokevirtual 55	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   0	77	1	paramOnDownloadProgressResponse	OnDownloadProgressResponse
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        //   64	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public void a(OnDriveIdResponse paramOnDriveIdResponse)
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
        //   16: ifnull +44 -> 60
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 63	com/google/android/gms/drive/internal/OnDriveIdResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_3
        //   35: aload_2
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 49 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_2
        //   61: iconst_0
        //   62: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_3
        //   69: aload 4
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 55	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramOnDriveIdResponse	OnDriveIdResponse
        //   3	72	2	localParcel1	Parcel
        //   68	11	3	localObject	Object
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      /* Error */
      public void a(OnListEntriesResponse paramOnListEntriesResponse)
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
        //   17: ifnull +45 -> 62
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 67	com/google/android/gms/drive/internal/OnListEntriesResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: iconst_2
        //   38: aload 4
        //   40: aload_2
        //   41: iconst_0
        //   42: invokeinterface 49 5 0
        //   47: pop
        //   48: aload_2
        //   49: invokevirtual 52	android/os/Parcel:readException	()V
        //   52: aload_2
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload 4
        //   58: invokevirtual 55	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   68: goto -35 -> 33
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: invokevirtual 55	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramOnListEntriesResponse	OnListEntriesResponse
        //   8	65	2	localParcel1	Parcel
        //   71	11	3	localObject	Object
        //   3	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	52	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void a(OnListParentsResponse paramOnListParentsResponse)
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
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 71	com/google/android/gms/drive/internal/OnListParentsResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 8
        //   39: aload 4
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 55	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_2
        //   73: aload_3
        //   74: invokevirtual 55	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 55	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramOnListParentsResponse	OnListParentsResponse
        //   72	11	2	localObject	Object
        //   8	66	3	localParcel1	Parcel
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      public void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, m paramm)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (paramOnLoadRealtimeResponse != null)
            {
              localParcel2.writeInt(1);
              paramOnLoadRealtimeResponse.writeToParcel(localParcel2, 0);
              if (paramm != null)
              {
                IBinder localIBinder = paramm.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(11, localParcel2, localParcel1, 0);
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
      public void a(OnMetadataResponse paramOnMetadataResponse)
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
        //   16: ifnull +44 -> 60
        //   19: aload_2
        //   20: iconst_1
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 88	com/google/android/gms/drive/internal/OnMetadataResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: iconst_4
        //   35: aload_2
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 49 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aload_2
        //   61: iconst_0
        //   62: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   65: goto -35 -> 30
        //   68: astore_3
        //   69: aload 4
        //   71: invokevirtual 55	android/os/Parcel:recycle	()V
        //   74: aload_2
        //   75: invokevirtual 55	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramOnMetadataResponse	OnMetadataResponse
        //   3	72	2	localParcel1	Parcel
        //   68	11	3	localObject	Object
        //   7	63	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	50	68	finally
        //   60	65	68	finally
      }
      
      /* Error */
      public void a(OnResourceIdSetResponse paramOnResourceIdSetResponse)
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
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 92	com/google/android/gms/drive/internal/OnResourceIdSetResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   33: bipush 12
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 49 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 52	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 55	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramOnResourceIdSetResponse	OnResourceIdSetResponse
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void a(OnStorageStatsResponse paramOnStorageStatsResponse)
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
        //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_2
        //   26: iconst_0
        //   27: invokevirtual 96	com/google/android/gms/drive/internal/OnStorageStatsResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   34: bipush 10
        //   36: aload_2
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 55	android/os/Parcel:recycle	()V
        //   60: return
        //   61: aload_2
        //   62: iconst_0
        //   63: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   66: goto -36 -> 30
        //   69: astore_3
        //   70: aload 4
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload_2
        //   76: invokevirtual 55	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	a
        //   0	81	1	paramOnStorageStatsResponse	OnStorageStatsResponse
        //   3	73	2	localParcel1	Parcel
        //   69	11	3	localObject	Object
        //   7	64	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	51	69	finally
        //   61	66	69	finally
      }
      
      /* Error */
      public void a(OnSyncMoreResponse paramOnSyncMoreResponse)
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
        //   17: ifnull +46 -> 63
        //   20: aload 4
        //   22: iconst_1
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 100	com/google/android/gms/drive/internal/OnSyncMoreResponse:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 9
        //   39: aload 4
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 55	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_2
        //   73: aload_3
        //   74: invokevirtual 55	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 55	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramOnSyncMoreResponse	OnSyncMoreResponse
        //   72	11	2	localObject	Object
        //   8	66	3	localParcel1	Parcel
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      /* Error */
      public void o(Status paramStatus)
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
        //   23: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   26: aload_1
        //   27: aload 4
        //   29: iconst_0
        //   30: invokevirtual 105	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/internal/ab$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 6
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 55	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 55	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 55	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramStatus	Status
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      public void onSuccess()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
          this.ko.transact(7, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.drive.internal.ab
 * JD-Core Version:    0.7.0.1
 */
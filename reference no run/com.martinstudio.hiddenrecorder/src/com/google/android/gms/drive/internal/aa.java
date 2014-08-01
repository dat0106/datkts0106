package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface aa
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, ac paramac, String paramString, ab paramab)
    throws RemoteException;
  
  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(DeleteResourceRequest paramDeleteResourceRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(DisconnectRequest paramDisconnectRequest)
    throws RemoteException;
  
  public abstract void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(ListParentsRequest paramListParentsRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(LoadRealtimeRequest paramLoadRealtimeRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(OpenContentsRequest paramOpenContentsRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(QueryRequest paramQueryRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ac paramac, String paramString, ab paramab)
    throws RemoteException;
  
  public abstract void a(SetResourceParentsRequest paramSetResourceParentsRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(TrashResourceRequest paramTrashResourceRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, ab paramab)
    throws RemoteException;
  
  public abstract void a(ab paramab)
    throws RemoteException;
  
  public abstract void b(QueryRequest paramQueryRequest, ab paramab)
    throws RemoteException;
  
  public abstract void b(ab paramab)
    throws RemoteException;
  
  public abstract void c(ab paramab)
    throws RemoteException;
  
  public abstract void d(ab paramab)
    throws RemoteException;
  
  public abstract void e(ab paramab)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements aa
  {
    public static aa P(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        if ((localObject == null) || (!(localObject instanceof aa))) {
          localObject = new a(paramIBinder);
        } else {
          localObject = (aa)localObject;
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
      Object localObject1 = null;
      int i3;
      int i13;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        boolean bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        GetMetadataRequest localGetMetadataRequest;
        if (paramParcel1.readInt() != 0) {
          localGetMetadataRequest = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localGetMetadataRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i = 1;
        break;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        QueryRequest localQueryRequest1;
        if (paramParcel1.readInt() != 0) {
          localQueryRequest1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localQueryRequest1, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int j = 1;
        break;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        UpdateMetadataRequest localUpdateMetadataRequest;
        if (paramParcel1.readInt() != 0) {
          localUpdateMetadataRequest = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localUpdateMetadataRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int k = 1;
        break;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CreateContentsRequest localCreateContentsRequest;
        if (paramParcel1.readInt() != 0) {
          localCreateContentsRequest = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateContentsRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int m = 1;
        break;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CreateFileRequest localCreateFileRequest;
        if (paramParcel1.readInt() != 0) {
          localCreateFileRequest = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateFileRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int n = 1;
        break;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CreateFolderRequest localCreateFolderRequest;
        if (paramParcel1.readInt() != 0) {
          localCreateFolderRequest = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCreateFolderRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i1 = 1;
        break;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        OpenContentsRequest localOpenContentsRequest;
        if (paramParcel1.readInt() != 0) {
          localOpenContentsRequest = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localOpenContentsRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i2 = 1;
        break;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CloseContentsRequest localCloseContentsRequest;
        if (paramParcel1.readInt() != 0) {
          localCloseContentsRequest = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCloseContentsRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i3 = 1;
        break;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        a(ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i3 = 1;
        break;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        if (paramParcel1.readInt() != 0) {
          localObject2 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        Object localObject2 = a((OpenFileIntentSenderRequest)localObject2);
        paramParcel2.writeNoException();
        if (localObject2 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          ((IntentSender)localObject2).writeToParcel(paramParcel2, 1);
        }
        int i4 = 1;
        break;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        if (paramParcel1.readInt() != 0) {
          localObject3 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        Object localObject3 = a((CreateFileIntentSenderRequest)localObject3);
        paramParcel2.writeNoException();
        if (localObject3 == null)
        {
          paramParcel2.writeInt(0);
        }
        else
        {
          paramParcel2.writeInt(1);
          ((IntentSender)localObject3).writeToParcel(paramParcel2, 1);
        }
        int i5 = 1;
        break;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        AuthorizeAccessRequest localAuthorizeAccessRequest;
        if (paramParcel1.readInt() != 0) {
          localAuthorizeAccessRequest = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localAuthorizeAccessRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i6 = 1;
        break;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        ListParentsRequest localListParentsRequest;
        if (paramParcel1.readInt() != 0) {
          localListParentsRequest = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localListParentsRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i7 = 1;
        break;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        AddEventListenerRequest localAddEventListenerRequest;
        if (paramParcel1.readInt() != 0) {
          localAddEventListenerRequest = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localAddEventListenerRequest, ac.a.R(paramParcel1.readStrongBinder()), paramParcel1.readString(), ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i8 = 1;
        break;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        RemoveEventListenerRequest localRemoveEventListenerRequest;
        if (paramParcel1.readInt() != 0) {
          localRemoveEventListenerRequest = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localRemoveEventListenerRequest, ac.a.R(paramParcel1.readStrongBinder()), paramParcel1.readString(), ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i9 = 1;
        break;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        DisconnectRequest localDisconnectRequest;
        if (paramParcel1.readInt() != 0) {
          localDisconnectRequest = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDisconnectRequest);
        paramParcel2.writeNoException();
        int i10 = 1;
        break;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        TrashResourceRequest localTrashResourceRequest;
        if (paramParcel1.readInt() != 0) {
          localTrashResourceRequest = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localTrashResourceRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i11 = 1;
        break;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CloseContentsAndUpdateMetadataRequest localCloseContentsAndUpdateMetadataRequest;
        if (paramParcel1.readInt() != 0) {
          localCloseContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCloseContentsAndUpdateMetadataRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i12 = 1;
        break;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        QueryRequest localQueryRequest2;
        if (paramParcel1.readInt() != 0) {
          localQueryRequest2 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        b(localQueryRequest2, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i13 = 1;
        break;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        b(ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i13 = 1;
        break;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        c(ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i13 = 1;
        break;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        d(ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i13 = 1;
        break;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        e(ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        i13 = 1;
        break;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        DeleteResourceRequest localDeleteResourceRequest;
        if (paramParcel1.readInt() != 0) {
          localDeleteResourceRequest = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDeleteResourceRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i14 = 1;
        break;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        DeleteCustomPropertyRequest localDeleteCustomPropertyRequest;
        if (paramParcel1.readInt() != 0) {
          localDeleteCustomPropertyRequest = (DeleteCustomPropertyRequest)DeleteCustomPropertyRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localDeleteCustomPropertyRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i15 = 1;
        break;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        LoadRealtimeRequest localLoadRealtimeRequest;
        if (paramParcel1.readInt() != 0) {
          localLoadRealtimeRequest = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localLoadRealtimeRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i16 = 1;
        break;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        SetResourceParentsRequest localSetResourceParentsRequest;
        if (paramParcel1.readInt() != 0) {
          localSetResourceParentsRequest = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localSetResourceParentsRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i17 = 1;
        break;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        GetDriveIdFromUniqueIdentifierRequest localGetDriveIdFromUniqueIdentifierRequest;
        if (paramParcel1.readInt() != 0) {
          localGetDriveIdFromUniqueIdentifierRequest = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localGetDriveIdFromUniqueIdentifierRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int i18 = 1;
        break;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        CheckResourceIdsExistRequest localCheckResourceIdsExistRequest;
        if (paramParcel1.readInt() != 0) {
          localCheckResourceIdsExistRequest = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(localCheckResourceIdsExistRequest, ab.a.Q(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        bool2 = true;
        break;
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
        bool2 = true;
      }
      return bool2;
    }
    
    private static class a
      implements aa
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileIntentSenderRequest != null)
            {
              localParcel2.writeInt(1);
              paramCreateFileIntentSenderRequest.writeToParcel(localParcel2, 0);
              this.ko.transact(11, localParcel2, localParcel1, 0);
              localParcel1.readException();
              if (localParcel1.readInt() != 0)
              {
                IntentSender localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel1);
                return localIntentSender;
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
      
      public IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              this.ko.transact(10, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                IntentSender localIntentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return localIntentSender;
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
      
      public void a(AddEventListenerRequest paramAddEventListenerRequest, ac paramac, String paramString, ab paramab)
        throws RemoteException
      {
        IBinder localIBinder1 = null;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAddEventListenerRequest != null)
            {
              localParcel2.writeInt(1);
              paramAddEventListenerRequest.writeToParcel(localParcel2, 0);
              if (paramac != null)
              {
                localIBinder2 = paramac.asBinder();
                localParcel2.writeStrongBinder(localIBinder2);
                localParcel2.writeString(paramString);
                if (paramab != null) {
                  localIBinder1 = paramab.asBinder();
                }
                localParcel2.writeStrongBinder(localIBinder1);
                this.ko.transact(14, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            IBinder localIBinder2 = null;
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAuthorizeAccessRequest != null)
            {
              localParcel1.writeInt(1);
              paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(12, localParcel1, localParcel2, 0);
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
      
      public void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCheckResourceIdsExistRequest != null)
            {
              localParcel1.writeInt(1);
              paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(30, localParcel1, localParcel2, 0);
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
      
      public void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsAndUpdateMetadataRequest != null)
            {
              localParcel2.writeInt(1);
              paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(18, localParcel2, localParcel1, 0);
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
      
      public void a(CloseContentsRequest paramCloseContentsRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(8, localParcel1, localParcel2, 0);
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
      
      public void a(CreateContentsRequest paramCreateContentsRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateContentsRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(4, localParcel1, localParcel2, 0);
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
      
      public void a(CreateFileRequest paramCreateFileRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(5, localParcel1, localParcel2, 0);
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
      
      public void a(CreateFolderRequest paramCreateFolderRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFolderRequest != null)
            {
              localParcel2.writeInt(1);
              paramCreateFolderRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(6, localParcel2, localParcel1, 0);
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
      
      public void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramDeleteCustomPropertyRequest != null)
            {
              localParcel1.writeInt(1);
              paramDeleteCustomPropertyRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(26, localParcel1, localParcel2, 0);
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
      
      public void a(DeleteResourceRequest paramDeleteResourceRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramDeleteResourceRequest != null)
            {
              localParcel2.writeInt(1);
              paramDeleteResourceRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(24, localParcel2, localParcel1, 0);
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
      public void a(DisconnectRequest paramDisconnectRequest)
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
        //   30: invokevirtual 134	com/google/android/gms/drive/internal/DisconnectRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   33: aload_0
        //   34: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   37: bipush 16
        //   39: aload 4
        //   41: aload_2
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_2
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_2
        //   54: invokevirtual 71	android/os/Parcel:recycle	()V
        //   57: aload 4
        //   59: invokevirtual 71	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   69: goto -36 -> 33
        //   72: astore_3
        //   73: aload_2
        //   74: invokevirtual 71	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 71	android/os/Parcel:recycle	()V
        //   82: aload_3
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramDisconnectRequest	DisconnectRequest
        //   8	66	2	localParcel1	Parcel
        //   72	11	3	localObject	Object
        //   3	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	53	72	finally
        //   63	69	72	finally
      }
      
      public void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetDriveIdFromUniqueIdentifierRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(29, localParcel1, localParcel2, 0);
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
      
      public void a(GetMetadataRequest paramGetMetadataRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetMetadataRequest != null)
            {
              localParcel2.writeInt(1);
              paramGetMetadataRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(1, localParcel2, localParcel1, 0);
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
      
      public void a(ListParentsRequest paramListParentsRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramListParentsRequest != null)
            {
              localParcel2.writeInt(1);
              paramListParentsRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(13, localParcel2, localParcel1, 0);
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
      
      public void a(LoadRealtimeRequest paramLoadRealtimeRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramLoadRealtimeRequest != null)
            {
              localParcel2.writeInt(1);
              paramLoadRealtimeRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(27, localParcel2, localParcel1, 0);
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
      
      public void a(OpenContentsRequest paramOpenContentsRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenContentsRequest != null)
            {
              localParcel2.writeInt(1);
              paramOpenContentsRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(7, localParcel2, localParcel1, 0);
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
      
      public void a(QueryRequest paramQueryRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
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
      
      public void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ac paramac, String paramString, ab paramab)
        throws RemoteException
      {
        IBinder localIBinder1 = null;
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRemoveEventListenerRequest != null)
            {
              localParcel2.writeInt(1);
              paramRemoveEventListenerRequest.writeToParcel(localParcel2, 0);
              if (paramac != null)
              {
                localIBinder2 = paramac.asBinder();
                localParcel2.writeStrongBinder(localIBinder2);
                localParcel2.writeString(paramString);
                if (paramab != null) {
                  localIBinder1 = paramab.asBinder();
                }
                localParcel2.writeStrongBinder(localIBinder1);
                this.ko.transact(15, localParcel2, localParcel1, 0);
                localParcel1.readException();
              }
            }
            else
            {
              localParcel2.writeInt(0);
              continue;
            }
            IBinder localIBinder2 = null;
          }
          finally
          {
            localParcel1.recycle();
            localParcel2.recycle();
          }
        }
      }
      
      public void a(SetResourceParentsRequest paramSetResourceParentsRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramSetResourceParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(28, localParcel1, localParcel2, 0);
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
      
      public void a(TrashResourceRequest paramTrashResourceRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramTrashResourceRequest != null)
            {
              localParcel2.writeInt(1);
              paramTrashResourceRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(17, localParcel2, localParcel1, 0);
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
      
      public void a(UpdateMetadataRequest paramUpdateMetadataRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel2.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUpdateMetadataRequest != null)
            {
              localParcel2.writeInt(1);
              paramUpdateMetadataRequest.writeToParcel(localParcel2, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel2.writeStrongBinder(localIBinder);
                this.ko.transact(3, localParcel2, localParcel1, 0);
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
      public void a(ab paramab)
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
        //   19: invokeinterface 94 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 9
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 71	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 71	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramab	ab
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(QueryRequest paramQueryRequest, ab paramab)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramab != null)
              {
                IBinder localIBinder = paramab.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.ko.transact(19, localParcel1, localParcel2, 0);
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
      public void b(ab paramab)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 94 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 20
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 71	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 71	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramab	ab
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void c(ab paramab)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 94 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 21
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 71	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 71	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramab	ab
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void d(ab paramab)
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
        //   19: invokeinterface 94 1 0
        //   24: astore 4
        //   26: aload_2
        //   27: aload 4
        //   29: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 22
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 71	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 71	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramab	ab
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
      
      /* Error */
      public void e(ab paramab)
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
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 94 1 0
        //   24: astore 4
        //   26: aload_3
        //   27: aload 4
        //   29: invokevirtual 88	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 18	com/google/android/gms/drive/internal/aa$a$a:ko	Landroid/os/IBinder;
        //   36: bipush 23
        //   38: aload_3
        //   39: aload_2
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_2
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_2
        //   52: invokevirtual 71	android/os/Parcel:recycle	()V
        //   55: aload_3
        //   56: invokevirtual 71	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 4
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 71	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 71	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramab	ab
        //   7	62	2	localParcel1	Parcel
        //   3	70	3	localParcel2	Parcel
        //   24	38	4	localIBinder	IBinder
        //   66	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	51	66	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aa
 * JD-Core Version:    0.7.0.1
 */
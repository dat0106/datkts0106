package com.sonyericsson.music;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPlayback
  extends IInterface
{
  public abstract int getAlbumId()
    throws RemoteException;
  
  public abstract String getAlbumName()
    throws RemoteException;
  
  public abstract int getArtistId()
    throws RemoteException;
  
  public abstract String getArtistName()
    throws RemoteException;
  
  public abstract long getDuration()
    throws RemoteException;
  
  public abstract String getPath()
    throws RemoteException;
  
  public abstract long getPosition()
    throws RemoteException;
  
  public abstract int getTrackId()
    throws RemoteException;
  
  public abstract String getTrackName()
    throws RemoteException;
  
  public abstract boolean isPlaying()
    throws RemoteException;
  
  public abstract void next()
    throws RemoteException;
  
  public abstract void pause()
    throws RemoteException;
  
  public abstract void play()
    throws RemoteException;
  
  public abstract void prev()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IPlayback
  {
    private static final String DESCRIPTOR = "com.sonyericsson.music.IPlayback";
    static final int TRANSACTION_getAlbumId = 10;
    static final int TRANSACTION_getAlbumName = 11;
    static final int TRANSACTION_getArtistId = 12;
    static final int TRANSACTION_getArtistName = 13;
    static final int TRANSACTION_getDuration = 6;
    static final int TRANSACTION_getPath = 14;
    static final int TRANSACTION_getPosition = 7;
    static final int TRANSACTION_getTrackId = 8;
    static final int TRANSACTION_getTrackName = 9;
    static final int TRANSACTION_isPlaying = 1;
    static final int TRANSACTION_next = 4;
    static final int TRANSACTION_pause = 3;
    static final int TRANSACTION_play = 2;
    static final int TRANSACTION_prev = 5;
    
    public Stub()
    {
      attachInterface(this, "com.sonyericsson.music.IPlayback");
    }
    
    public static IPlayback asInterface(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder != null)
      {
        localObject = paramIBinder.queryLocalInterface("com.sonyericsson.music.IPlayback");
        if ((localObject == null) || (!(localObject instanceof IPlayback))) {
          localObject = new Proxy(paramIBinder);
        } else {
          localObject = (IPlayback)localObject;
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
      long l;
      String str3;
      switch (paramInt1)
      {
      default: 
        i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        break;
      case 1: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        int j = isPlaying();
        paramParcel2.writeNoException();
        if (j == 0) {
          j = 0;
        } else {
          j = i;
        }
        paramParcel2.writeInt(j);
        break;
      case 2: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        play();
        paramParcel2.writeNoException();
        break;
      case 3: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        pause();
        paramParcel2.writeNoException();
        break;
      case 4: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        next();
        paramParcel2.writeNoException();
        break;
      case 5: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        prev();
        paramParcel2.writeNoException();
        break;
      case 6: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        l = getDuration();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        break;
      case 7: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        l = getPosition();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        break;
      case 8: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        int k = getTrackId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(k);
        break;
      case 9: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        String str1 = getTrackName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        break;
      case 10: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        int m = getAlbumId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(m);
        break;
      case 11: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        String str2 = getAlbumName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        break;
      case 12: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        int n = getArtistId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(n);
        break;
      case 13: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        str3 = getArtistName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        break;
      case 14: 
        paramParcel1.enforceInterface("com.sonyericsson.music.IPlayback");
        str3 = getPath();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        break;
      case 1598968902: 
        paramParcel2.writeString("com.sonyericsson.music.IPlayback");
      }
      return i;
    }
    
    private static class Proxy
      implements IPlayback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public int getAlbumId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
      
      public String getAlbumName()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(11, localParcel2, localParcel1, 0);
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
      
      public int getArtistId()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(12, localParcel2, localParcel1, 0);
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
      
      public String getArtistName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
      
      public long getDuration()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.sonyericsson.music.IPlayback";
      }
      
      public String getPath()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      
      public long getPosition()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getTrackId()
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(8, localParcel2, localParcel1, 0);
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
      
      public String getTrackName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public boolean isPlaying()
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore_1
        //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_2
        //   11: aload_1
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 18	com/sonyericsson/music/IPlayback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   21: iconst_1
        //   22: aload_1
        //   23: aload_2
        //   24: iconst_0
        //   25: invokeinterface 42 5 0
        //   30: pop
        //   31: aload_2
        //   32: invokevirtual 45	android/os/Parcel:readException	()V
        //   35: aload_2
        //   36: invokevirtual 48	android/os/Parcel:readInt	()I
        //   39: istore_3
        //   40: iload_3
        //   41: ifeq +14 -> 55
        //   44: aload_2
        //   45: invokevirtual 51	android/os/Parcel:recycle	()V
        //   48: aload_1
        //   49: invokevirtual 51	android/os/Parcel:recycle	()V
        //   52: iload 4
        //   54: ireturn
        //   55: iconst_0
        //   56: istore 4
        //   58: goto -14 -> 44
        //   61: astore_3
        //   62: aload_2
        //   63: invokevirtual 51	android/os/Parcel:recycle	()V
        //   66: aload_1
        //   67: invokevirtual 51	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	72	0	this	Proxy
        //   6	61	1	localParcel1	Parcel
        //   10	53	2	localParcel2	Parcel
        //   39	2	3	i	int
        //   61	10	3	localObject	Object
        //   1	56	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   11	40	61	finally
      }
      
      public void next()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void pause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void play()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void prev()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sonyericsson.music.IPlayback");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.music.IPlayback
 * JD-Core Version:    0.7.0.1
 */
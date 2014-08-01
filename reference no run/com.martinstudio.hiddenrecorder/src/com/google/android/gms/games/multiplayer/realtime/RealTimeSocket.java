package com.google.android.gms.games.multiplayer.realtime;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface RealTimeSocket
{
  public abstract void close()
    throws IOException;
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract OutputStream getOutputStream()
    throws IOException;
  
  public abstract ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException;
  
  public abstract boolean isClosed();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
 * JD-Core Version:    0.7.0.1
 */
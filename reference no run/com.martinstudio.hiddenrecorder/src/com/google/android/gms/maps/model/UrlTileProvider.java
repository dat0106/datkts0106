package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int ks;
  private final int kt;
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.ks = paramInt1;
    this.kt = paramInt2;
  }
  
  private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getTileUrl(paramInt1, paramInt2, paramInt3);
    if (localObject == null) {
      localObject = NO_TILE;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = new Tile(this.ks, this.kt, a(((URL)localObject).openStream()));
      }
      catch (IOException localIOException)
      {
        localObject = null;
      }
    }
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */
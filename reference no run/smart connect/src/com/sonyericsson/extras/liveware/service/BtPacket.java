package com.sonyericsson.extras.liveware.service;

import java.io.IOException;
import java.io.InputStream;

public abstract class BtPacket
{
  public static void fillBuffer(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int j = 0;
    do
    {
      int i = paramInputStream.read(paramArrayOfByte, j, paramArrayOfByte.length - j);
      if (i == -1) {
        break;
      }
      j += i;
    } while (j < paramArrayOfByte.length);
    return;
    throw new IOException("No more data on channel, got " + j + " expected " + paramArrayOfByte.length);
  }
  
  public abstract byte[] toByteArray();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.BtPacket
 * JD-Core Version:    0.7.0.1
 */
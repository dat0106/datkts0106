package com.sonyericsson.extras.liveware.asf;

import android.os.Bundle;
import com.sonyericsson.extras.liveware.aas.AasPacket;
import com.sonyericsson.extras.liveware.service.BtPacket;
import com.sonyericsson.extras.liveware.service.BtPacketProtocolHandler;
import com.sonyericsson.extras.liveware.service.ProtocolHandler;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class AsfPacketProtocolHandler
  implements BtPacketProtocolHandler
{
  public void addPacketMetadata(String paramString, BtPacket paramBtPacket)
  {
    if ((paramBtPacket instanceof AsfPacket))
    {
      AsfPacket localAsfPacket = (AsfPacket)paramBtPacket;
      Bundle localBundle = new Bundle();
      localBundle.putString("Address", paramString);
      localAsfPacket.putMetaData(localBundle);
    }
  }
  
  public BtPacket getErrorPacket()
  {
    return new AasPacket((byte)0, (byte)0, (byte)0, AsfProtocol.ERROR_PACKET.length, AsfProtocol.ERROR_PACKET);
  }
  
  public BtPacket getPacket(InputStream paramInputStream, ProtocolHandler paramProtocolHandler)
    throws IOException
  {
    Object localObject = new byte[2];
    PushbackInputStream localPushbackInputStream = new PushbackInputStream(paramInputStream, localObject.length);
    try
    {
      BtPacket.fillBuffer(localPushbackInputStream, (byte[])localObject);
      localPushbackInputStream.unread((byte[])localObject);
      localObject = new byte[8];
      BtPacket.fillBuffer(localPushbackInputStream, (byte[])localObject);
      localObject = (AsfPacket)paramProtocolHandler.createPacket((byte[])localObject);
      if (localObject != null)
      {
        ((AsfPacket)localObject).data = new byte[((AsfPacket)localObject).length];
        BtPacket.fillBuffer(localPushbackInputStream, ((AsfPacket)localObject).data);
      }
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new EOFException(localIOException.getMessage());
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.AsfPacketProtocolHandler
 * JD-Core Version:    0.7.0.1
 */
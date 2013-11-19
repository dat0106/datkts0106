package com.sonyericsson.extras.liveware.service;

import java.io.IOException;
import java.io.InputStream;

public abstract interface BtPacketProtocolHandler
{
  public abstract void addPacketMetadata(String paramString, BtPacket paramBtPacket);
  
  public abstract BtPacket getErrorPacket();
  
  public abstract BtPacket getPacket(InputStream paramInputStream, ProtocolHandler paramProtocolHandler)
    throws IOException;
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.BtPacketProtocolHandler
 * JD-Core Version:    0.7.0.1
 */
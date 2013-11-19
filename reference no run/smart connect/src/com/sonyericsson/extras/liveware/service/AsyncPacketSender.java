package com.sonyericsson.extras.liveware.service;

import com.sonyericsson.extras.liveware.asf.AsfPacket;
import java.io.IOException;

public abstract interface AsyncPacketSender
{
  public abstract void sendPacket(AsfPacket paramAsfPacket)
    throws IOException;
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.AsyncPacketSender
 * JD-Core Version:    0.7.0.1
 */
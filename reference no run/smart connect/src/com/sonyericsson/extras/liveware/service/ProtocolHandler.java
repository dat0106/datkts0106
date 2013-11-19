package com.sonyericsson.extras.liveware.service;

public abstract interface ProtocolHandler
{
  public abstract BtPacket createPacket(byte paramByte1, byte paramByte2);
  
  public abstract BtPacket createPacket(byte[] paramArrayOfByte);
  
  public abstract void onAsyncEvent(int paramInt1, int paramInt2);
  
  public abstract void onConnect(String paramString, AsyncPacketSender paramAsyncPacketSender);
  
  public abstract void onDisconnect();
  
  public abstract BtPacket processPacket(BtPacket paramBtPacket);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.ProtocolHandler
 * JD-Core Version:    0.7.0.1
 */
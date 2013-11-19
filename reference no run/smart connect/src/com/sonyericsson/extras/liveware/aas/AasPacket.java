package com.sonyericsson.extras.liveware.aas;

import com.sonyericsson.extras.liveware.asf.AsfPacket;
import com.sonyericsson.extras.liveware.asf.AsfProtocol.AasProtocol;

public class AasPacket
  extends AsfPacket
{
  public AasPacket(byte paramByte1, byte paramByte2)
  {
    super(paramByte1, paramByte2);
    this.identifier = AsfProtocol.AasProtocol.AAS_PACKET_IDENTIFIER;
  }
  
  public AasPacket(byte paramByte1, byte paramByte2, byte paramByte3, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramByte1, paramByte2, paramByte3, paramInt, paramArrayOfByte);
    this.identifier = AsfProtocol.AasProtocol.AAS_PACKET_IDENTIFIER;
  }
  
  public AasPacket(byte[] paramArrayOfByte)
    throws Exception
  {
    super(paramArrayOfByte);
    this.identifier = AsfProtocol.AasProtocol.AAS_PACKET_IDENTIFIER;
    if (validateIdentifier(paramArrayOfByte)) {
      return;
    }
    throw new IllegalArgumentException("Invalid Identifier");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aas.AasPacket
 * JD-Core Version:    0.7.0.1
 */
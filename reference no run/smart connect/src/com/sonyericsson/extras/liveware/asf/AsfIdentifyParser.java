package com.sonyericsson.extras.liveware.asf;

import android.content.Context;
import com.sonyericsson.extras.liveware.service.ProtocolHandler;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class AsfIdentifyParser
  extends AsfParser
{
  public static final byte[] ASF_VERSION;
  private byte mClientMajor = 0;
  private byte mClientMinor = 0;
  private ProtocolHandler mProtocolHandler;
  private byte[] mServerVersion;
  
  static
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    ASF_VERSION = arrayOfByte;
  }
  
  public AsfIdentifyParser(Context paramContext, ProtocolHandler paramProtocolHandler, byte[] paramArrayOfByte)
  {
    super(paramContext);
    this.mProtocolHandler = paramProtocolHandler;
    this.mServerVersion = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mServerVersion, 0, paramArrayOfByte.length);
  }
  
  private boolean parseBody(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 2))
    {
      this.mClientMajor = paramArrayOfByte[0];
      this.mClientMinor = paramArrayOfByte[1];
      bool = true;
    }
    return bool;
  }
  
  public boolean isAasVersionUnsupported()
  {
    int i = 1;
    if (this.mClientMajor <= i) {
      i = 0;
    }
    return i;
  }
  
  public AsfPacket parse(AsfPacket paramAsfPacket)
  {
    AsfPacket localAsfPacket = (AsfPacket)this.mProtocolHandler.createPacket(paramAsfPacket.feature, paramAsfPacket.frame);
    if (paramAsfPacket.type != 3)
    {
      if (Dbg.e()) {
        Dbg.e("The type is not supported: field value is:" + paramAsfPacket.type + ".");
      }
      localAsfPacket.type = 0;
      localAsfPacket.data = AsfProtocol.ERROR_TYPE;
      localAsfPacket.length = localAsfPacket.data.length;
    }
    else
    {
      if (Dbg.v()) {
        Dbg.v("Recived version command");
      }
      if (!parseBody(paramAsfPacket.data))
      {
        if (Dbg.e()) {
          Dbg.e("Could not parse data");
        }
        localAsfPacket.data = AsfProtocol.ERROR_DATA;
        localAsfPacket.length = localAsfPacket.data.length;
      }
      else
      {
        if (Dbg.v())
        {
          Dbg.v("Accessory ASF version major = " + this.mClientMajor + ". minor = " + this.mClientMinor);
          Dbg.v("Phone ASF version major = " + this.mServerVersion[0] + ". minor = " + this.mServerVersion[1]);
        }
        localAsfPacket.type = 1;
        localAsfPacket.data = this.mServerVersion;
        localAsfPacket.length = localAsfPacket.data.length;
      }
    }
    return localAsfPacket;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.AsfIdentifyParser
 * JD-Core Version:    0.7.0.1
 */
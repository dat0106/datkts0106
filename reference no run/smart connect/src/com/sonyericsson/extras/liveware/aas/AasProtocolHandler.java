package com.sonyericsson.extras.liveware.aas;

import android.content.Context;
import com.sonyericsson.extras.liveware.asf.AsfIdentifyParser;
import com.sonyericsson.extras.liveware.asf.AsfPacket;
import com.sonyericsson.extras.liveware.service.AsyncPacketSender;
import com.sonyericsson.extras.liveware.service.BtPacket;
import com.sonyericsson.extras.liveware.service.ProtocolHandler;
import com.sonyericsson.extras.liveware.ui.UpdateActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.IOException;

public class AasProtocolHandler
  implements ProtocolHandler
{
  public static final int EVENT_INSTALL_STATUS = 1;
  AasParser mAasParser;
  Context mCtx;
  AsfIdentifyParser mIdentifyParser;
  AsyncPacketSender mSender;
  
  public AasProtocolHandler(Context paramContext)
  {
    this.mCtx = paramContext;
    this.mAasParser = new AasParser(paramContext, this);
    this.mIdentifyParser = new AsfIdentifyParser(paramContext, this, AasParser.VERSION);
  }
  
  public BtPacket createPacket(byte paramByte1, byte paramByte2)
  {
    return new AasPacket(paramByte1, paramByte2);
  }
  
  public BtPacket createPacket(byte[] paramArrayOfByte)
  {
    try
    {
      localAasPacket = new AasPacket(paramArrayOfByte);
      return localAasPacket;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AasPacket localAasPacket = null;
      }
    }
  }
  
  public void onAsyncEvent(int paramInt1, int paramInt2)
  {
    AsfPacket localAsfPacket;
    if ((paramInt1 == 1) && (this.mAasParser.getStatusSubscription())) {
      localAsfPacket = this.mAasParser.getStatusAnswer(paramInt2);
    }
    try
    {
      this.mSender.sendPacket(localAsfPacket);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Failed to send async packet", localIOException);
        }
      }
    }
  }
  
  public void onConnect(String paramString, AsyncPacketSender paramAsyncPacketSender)
  {
    this.mSender = paramAsyncPacketSender;
  }
  
  public void onDisconnect()
  {
    this.mAasParser.resetState();
  }
  
  public AsfPacket processPacket(BtPacket paramBtPacket)
  {
    AsfPacket localAsfPacket = (AsfPacket)paramBtPacket;
    switch (localAsfPacket.feature)
    {
    default: 
      if (Dbg.e()) {
        Dbg.e("Unknown feature");
      }
      localAsfPacket = null;
      break;
    case 0: 
      localAsfPacket = this.mIdentifyParser.parse(localAsfPacket);
      if (this.mIdentifyParser.isAasVersionUnsupported()) {
        UpdateActivity.showUpdateDialog(this.mCtx);
      }
      break;
    case 1: 
      localAsfPacket = this.mAasParser.parse(localAsfPacket);
      break;
    case 2: 
      localAsfPacket = this.mAasParser.parseStatus(localAsfPacket);
    }
    return localAsfPacket;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aas.AasProtocolHandler
 * JD-Core Version:    0.7.0.1
 */
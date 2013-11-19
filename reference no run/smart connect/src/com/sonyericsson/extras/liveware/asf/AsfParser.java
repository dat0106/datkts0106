package com.sonyericsson.extras.liveware.asf;

import android.content.Context;

public abstract class AsfParser
{
  protected Context mCtx;
  
  protected AsfParser(Context paramContext)
  {
    this.mCtx = paramContext;
  }
  
  public abstract AsfPacket parse(AsfPacket paramAsfPacket);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.AsfParser
 * JD-Core Version:    0.7.0.1
 */
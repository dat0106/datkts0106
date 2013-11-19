package com.sonymobile.playanywhere;

import android.graphics.Bitmap;

public abstract class Controller
{
  public abstract boolean getMirrorMode();
  
  public abstract int getOutputSink();
  
  public abstract int getSinkCapabilities(int paramInt);
  
  public abstract int getSinkId(String paramString);
  
  public abstract String getSinkMake(int paramInt);
  
  public abstract String getSinkModel(int paramInt);
  
  public abstract String getSinkName(int paramInt);
  
  public abstract Bitmap getSinkThumbnail(int paramInt);
  
  public abstract String getSinkUUID(int paramInt);
  
  public abstract int[] getSinks();
  
  public abstract boolean hasMirrorMode();
  
  public abstract boolean isOutputSinkStreaming();
  
  public abstract boolean registerController(ControllerCallback paramControllerCallback);
  
  public abstract boolean setMirrorMode(boolean paramBoolean);
  
  public abstract boolean setOutputSink(int paramInt);
  
  public abstract void unregisterController(ControllerCallback paramControllerCallback);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.playanywhere.Controller
 * JD-Core Version:    0.7.0.1
 */
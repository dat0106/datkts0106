package com.samples.camera.utils;

import android.graphics.Bitmap;

public class VideoInfo
{
  long date;
  long length;
  String name;
  String path;
  Bitmap thumbnail;
  
  public long getDate()
  {
    return this.date;
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public Bitmap getThumbnail()
  {
    return this.thumbnail;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setLength(long paramLong)
  {
    this.length = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setThumbnail(Bitmap paramBitmap)
  {
    this.thumbnail = paramBitmap;
  }
}



/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar

 * Qualified Name:     com.martinstudio.utils.VideoInfo

 * JD-Core Version:    0.7.0.1

 */
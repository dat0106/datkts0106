package com.sonyericsson.extras.liveware.ui.list;

public class ListDetail
{
  private String mDescription;
  private int mIconId;
  private String mName;
  
  public ListDetail(String paramString)
  {
    this.mName = paramString;
    this.mDescription = null;
    this.mIconId = -1;
  }
  
  public ListDetail(String paramString1, String paramString2, int paramInt)
  {
    this.mName = paramString1;
    this.mDescription = paramString2;
    this.mIconId = paramInt;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public int getIconId()
  {
    return this.mIconId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean isClickable()
  {
    return false;
  }
  
  public void onClick() {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.list.ListDetail
 * JD-Core Version:    0.7.0.1
 */
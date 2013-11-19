package com.sonyericsson.extras.liveware.utils;

import android.app.Dialog;
import java.util.WeakHashMap;

public class TestDialogManager
{
  private Dialog mLatestDialog;
  private int mLatestID;
  private WeakHashMap<Integer, Dialog> mManagedDialogs = new WeakHashMap();
  
  public Dialog get(int paramInt)
  {
    return (Dialog)this.mManagedDialogs.get(Integer.valueOf(paramInt));
  }
  
  public Dialog getLatestDialog()
  {
    return this.mLatestDialog;
  }
  
  public int getLatestID()
  {
    return this.mLatestID;
  }
  
  public void manage(int paramInt, Dialog paramDialog)
  {
    this.mManagedDialogs.put(Integer.valueOf(paramInt), paramDialog);
    this.mLatestDialog = paramDialog;
    this.mLatestID = paramInt;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.TestDialogManager
 * JD-Core Version:    0.7.0.1
 */
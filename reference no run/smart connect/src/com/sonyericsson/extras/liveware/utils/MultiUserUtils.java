package com.sonyericsson.extras.liveware.utils;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.UserHandle;

@TargetApi(17)
public class MultiUserUtils
{
  static boolean isOwner()
  {
    boolean bool;
    if (Process.myUserHandle().hashCode() != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.MultiUserUtils
 * JD-Core Version:    0.7.0.1
 */
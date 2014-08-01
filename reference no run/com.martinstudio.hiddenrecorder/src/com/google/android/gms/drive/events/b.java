package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class b
{
  public static boolean a(int paramInt, DriveId paramDriveId)
  {
    boolean bool;
    if ((paramDriveId == null) && (!aK(paramInt))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean aK(int paramInt)
  {
    int i = 1;
    if ((0x6 & i << paramInt) == 0L) {
      i = 0;
    }
    return i;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.b
 * JD-Core Version:    0.7.0.1
 */
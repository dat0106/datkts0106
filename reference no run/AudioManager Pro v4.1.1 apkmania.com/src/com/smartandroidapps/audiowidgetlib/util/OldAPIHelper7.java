package com.smartandroidapps.audiowidgetlib.util;

import android.content.pm.PackageManager;

class OldAPIHelper7
{
  static boolean hasSystemTelephony(PackageManager paramPackageManager)
  {
    return paramPackageManager.hasSystemFeature("android.hardware.telephony");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.util.OldAPIHelper7
 * JD-Core Version:    0.7.0.1
 */
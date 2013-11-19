package com.sonyericsson.extras.liveware.aef.registration;

import android.net.Uri;

public class RegistrationRestricted
  extends Registration
{
  public static abstract interface ExtensionColumns
  {
    public static final String UID_NAME = "userId";
  }
  
  public static abstract interface RawQuery
  {
    public static final String RAW_QUERY_MIME_TYPE = "aef-raw_query";
    public static final String RAW_QUERY_PATH = "raw_query";
    public static final Uri URI = Uri.withAppendedPath(RegistrationRestricted.BASE_URI, "raw_query");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.RegistrationRestricted
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

public final class CastMediaControlIntent
{
  public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
  @Deprecated
  public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
  public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
  public static final int ERROR_CODE_REQUEST_FAILED = 1;
  public static final int ERROR_CODE_SESSION_START_FAILED = 2;
  public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
  public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
  public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
  public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
  public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
  public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
  public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
  public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";
  
  private static String a(String paramString1, String paramString2, Collection<String> paramCollection)
    throws IllegalArgumentException
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString1);
    if (paramString2 != null)
    {
      if ((paramString2.matches("[A-F0-9]+")) || (paramString2.equals("00000000-0000-0000-0000-000000000000"))) {
        localStringBuffer.append("/").append(paramString2);
      }
    }
    else
    {
      Iterator localIterator;
      if (paramCollection != null)
      {
        if (!paramCollection.isEmpty()) {
          localIterator = paramCollection.iterator();
        }
      }
      else
      {
        String str;
        do
        {
          if (!localIterator.hasNext())
          {
            if (paramString2 == null) {
              localStringBuffer.append("/");
            }
            localStringBuffer.append("/").append(TextUtils.join(",", paramCollection));
            return localStringBuffer.toString();
          }
          str = (String)localIterator.next();
        } while ((!TextUtils.isEmpty(str)) && (!str.trim().equals("")));
        throw new IllegalArgumentException("Namespaces must not be null or empty");
      }
      throw new IllegalArgumentException("Must specify at least one namespace");
    }
    throw new IllegalArgumentException("Invalid application ID: " + paramString2);
  }
  
  public static String categoryForCast(String paramString)
    throws IllegalArgumentException
  {
    if (paramString != null) {
      return a("com.google.android.gms.cast.CATEGORY_CAST", paramString, null);
    }
    throw new IllegalArgumentException("applicationId cannot be null");
  }
  
  public static String categoryForCast(String paramString, Collection<String> paramCollection)
  {
    if (paramString != null)
    {
      if (paramCollection != null) {
        return a("com.google.android.gms.cast.CATEGORY_CAST", paramString, paramCollection);
      }
      throw new IllegalArgumentException("namespaces cannot be null");
    }
    throw new IllegalArgumentException("applicationId cannot be null");
  }
  
  public static String categoryForCast(Collection<String> paramCollection)
    throws IllegalArgumentException
  {
    if (paramCollection != null) {
      return a("com.google.android.gms.cast.CATEGORY_CAST", null, paramCollection);
    }
    throw new IllegalArgumentException("namespaces cannot be null");
  }
  
  public static String categoryForRemotePlayback()
  {
    return a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null);
  }
  
  public static String categoryForRemotePlayback(String paramString)
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", paramString, null);
    }
    throw new IllegalArgumentException("applicationId cannot be null or empty");
  }
  
  public static String languageTagForLocale(Locale paramLocale)
  {
    return gj.b(paramLocale);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.CastMediaControlIntent
 * JD-Core Version:    0.7.0.1
 */
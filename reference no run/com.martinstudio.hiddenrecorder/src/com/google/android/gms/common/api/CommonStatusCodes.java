package com.google.android.gms.common.api;

public class CommonStatusCodes
{
  public static final int CANCELED = 16;
  public static final int DATE_INVALID = 12;
  public static final int DEVELOPER_ERROR = 10;
  public static final int ERROR = 13;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 14;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int SUCCESS_CACHE = -1;
  public static final int TIMEOUT = 15;
  
  public static String getStatusCodeString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown status code: " + paramInt;
      break;
    case -1: 
      str = "SUCCESS_CACHE";
      break;
    case 0: 
      str = "SUCCESS";
      break;
    case 1: 
      str = "SERVICE_MISSING";
      break;
    case 2: 
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      break;
    case 3: 
      str = "SERVICE_DISABLED";
      break;
    case 4: 
      str = "SIGN_IN_REQUIRED";
      break;
    case 5: 
      str = "INVALID_ACCOUNT";
      break;
    case 6: 
      str = "RESOLUTION_REQUIRED";
      break;
    case 7: 
      str = "NETWORK_ERROR";
      break;
    case 8: 
      str = "INTERNAL_ERROR";
      break;
    case 9: 
      str = "SERVICE_INVALID";
      break;
    case 10: 
      str = "DEVELOPER_ERROR";
      break;
    case 11: 
      str = "LICENSE_CHECK_FAILED";
      break;
    case 3000: 
      str = "AUTH_API_INVALID_CREDENTIALS";
      break;
    case 3001: 
      str = "AUTH_API_ACCESS_FORBIDDEN";
      break;
    case 3002: 
      str = "AUTH_API_CLIENT_ERROR";
      break;
    case 3003: 
      str = "AUTH_API_SERVER_ERROR";
      break;
    case 3004: 
      str = "AUTH_TOKEN_ERROR";
      break;
    case 3005: 
      str = "AUTH_URL_RESOLUTION";
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.CommonStatusCodes
 * JD-Core Version:    0.7.0.1
 */
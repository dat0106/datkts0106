package com.google.ads;

@Deprecated
public final class AdRequest
{
  public static final String LOGTAG = "Ads";
  public static final String TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
  public static final String VERSION = "0.0.0";
  
  public static enum Gender
  {
    static
    {
      MALE = new Gender("MALE", 1);
      FEMALE = new Gender("FEMALE", 2);
      Gender[] arrayOfGender = new Gender[3];
      arrayOfGender[0] = UNKNOWN;
      arrayOfGender[1] = MALE;
      arrayOfGender[2] = FEMALE;
      b = arrayOfGender;
    }
    
    private Gender() {}
  }
  
  public static enum ErrorCode
  {
    private final String description;
    
    static
    {
      NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
      INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 3, "There was an internal error.");
      ErrorCode[] arrayOfErrorCode = new ErrorCode[4];
      arrayOfErrorCode[0] = INVALID_REQUEST;
      arrayOfErrorCode[1] = NO_FILL;
      arrayOfErrorCode[2] = NETWORK_ERROR;
      arrayOfErrorCode[3] = INTERNAL_ERROR;
      a = arrayOfErrorCode;
    }
    
    private ErrorCode(String paramString)
    {
      this.description = paramString;
    }
    
    public String toString()
    {
      return this.description;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdRequest
 * JD-Core Version:    0.7.0.1
 */
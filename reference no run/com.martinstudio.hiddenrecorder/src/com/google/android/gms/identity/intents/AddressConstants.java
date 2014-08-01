package com.google.android.gms.identity.intents;

public abstract interface AddressConstants
{
  public static abstract interface Themes
  {
    public static final int THEME_HOLO_DARK = 0;
    public static final int THEME_HOLO_LIGHT = 1;
  }
  
  public static abstract interface ErrorCodes
  {
    public static final int ERROR_CODE_NO_APPLICABLE_ADDRESSES = 555;
  }
  
  public static abstract interface ResultCodes
  {
    public static final int RESULT_ERROR = 1;
  }
  
  public static abstract interface Extras
  {
    public static final String EXTRA_ADDRESS = "com.google.android.gms.identity.intents.EXTRA_ADDRESS";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.identity.intents.EXTRA_ERROR_CODE";
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.AddressConstants
 * JD-Core Version:    0.7.0.1
 */
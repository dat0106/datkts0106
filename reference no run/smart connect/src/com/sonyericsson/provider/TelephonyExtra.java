package com.sonyericsson.provider;

import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.BaseColumns;
import android.provider.Telephony.Sms.Draft;
import android.provider.Telephony.TextBasedSmsColumns;

public class TelephonyExtra
{
  public static final String SEQUENCE_TIME = "sequence_time";
  public static final String STAR_STATUS = "star_status";
  
  public static abstract interface DeliveryStatus
  {
    public static final int DELIVERED = 2;
    public static final int FAILED = 3;
    public static final int PENDING = 1;
  }
  
  public static final class SmsExtra
    implements TelephonyExtra.SmsExtraColumns, Telephony.TextBasedSmsColumns, BaseColumns
  {
    public static final Uri MULTIPLE_DRAFTS_URI = Telephony.Sms.Draft.CONTENT_URI.buildUpon().appendQueryParameter("allow_multiple_drafts", "true").build();
  }
  
  public static abstract interface SmsExtraColumns
  {
    public static final String DELIVERY_STATUS = "delivery_status";
    public static final String PARENT_ID = "parent_id";
    public static final String SMS_PRIORITY = "semc_message_priority";
  }
  
  public static abstract interface SmscExtraColumns
  {
    public static final String SMSC_NUM = "smsc_num";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.provider.TelephonyExtra
 * JD-Core Version:    0.7.0.1
 */
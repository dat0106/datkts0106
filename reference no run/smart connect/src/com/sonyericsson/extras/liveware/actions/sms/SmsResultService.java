package com.sonyericsson.extras.liveware.actions.sms;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony.Sms;
import android.telephony.SmsMessage;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class SmsResultService
  extends IntentService
{
  private static final Uri STATUS_URI = Uri.parse("content://sms/status");
  
  public SmsResultService()
  {
    super("SmsResultService");
  }
  
  private int handleSmsSent(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {}
    try
    {
      Telephony.Sms.moveMessageToFolder(this, paramIntent.getData(), 2, paramInt2);
      int i = 0;
      break label53;
      Telephony.Sms.moveMessageToFolder(this, paramIntent.getData(), 5, paramInt2);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.w("Failed updating SMS sent status.", localException);
      }
    }
    label53:
    return localException;
  }
  
  /* Error */
  private boolean hasDeliveryStatusColumn(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 54	com/sonyericsson/extras/liveware/actions/sms/SmsResultService:getContentResolver	()Landroid/content/ContentResolver;
    //   6: aload_1
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 60	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_3
    //   15: aload_3
    //   16: ldc 62
    //   18: invokeinterface 68 2 0
    //   23: pop
    //   24: aload_3
    //   25: ifnull +9 -> 34
    //   28: aload_3
    //   29: invokeinterface 71 1 0
    //   34: iconst_1
    //   35: istore_2
    //   36: iload_2
    //   37: ireturn
    //   38: pop
    //   39: aload_3
    //   40: ifnull +9 -> 49
    //   43: aload_3
    //   44: invokeinterface 71 1 0
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -15 -> 36
    //   54: astore_2
    //   55: aload_3
    //   56: ifnull +9 -> 65
    //   59: aload_3
    //   60: invokeinterface 71 1 0
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	SmsResultService
    //   0	67	1	paramUri	Uri
    //   35	16	2	bool	boolean
    //   54	12	2	localObject	Object
    //   1	59	3	localCursor	Cursor
    //   38	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	24	38	java/lang/Exception
    //   2	24	54	finally
  }
  
  private void updateDeliveryStatus(Uri paramUri, int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        localContentValues = new ContentValues();
        j = -1;
        if ((0xFFFF & paramInt) == 0) {
          break label193;
        }
        if (paramInt < 64) {
          break label169;
        }
        j = 3;
        if (Dbg.d()) {
          Dbg.d("updateDeliveryStatus " + paramUri + " status: " + paramInt + " deliveryStatus: " + j);
        }
        if (j == 3)
        {
          localContentValues.put("delivery_status", Integer.valueOf(3));
          localContentValues.put("read", Integer.valueOf(0));
          getContentResolver().update(paramUri, localContentValues, null, null);
        }
        else if (j == 1)
        {
          localContentValues.put("delivery_status", Integer.valueOf(1));
          continue;
        }
      }
      catch (Exception localException)
      {
        ContentValues localContentValues;
        Dbg.w("Failed updating delivery status");
        break label168;
        if (j == 2)
        {
          localContentValues.put("delivery_status", Integer.valueOf(2));
          continue;
        }
      }
      label168:
      return;
      label169:
      if (paramInt >= 32)
      {
        j = 1;
      }
      else if (paramInt != -1)
      {
        j = 2;
        continue;
        label193:
        int i = paramInt >> 16;
        if (i >= 768) {
          j = 3;
        } else if (i >= 512) {
          j = 1;
        } else if (i != -1) {
          j = 2;
        }
      }
    }
  }
  
  private SmsMessage updateMessageStatus(Uri paramUri, byte[] paramArrayOfByte)
  {
    SmsMessage localSmsMessage = SmsMessage.createFromPdu(paramArrayOfByte);
    if (localSmsMessage == null) {
      localSmsMessage = null;
    }
    for (;;)
    {
      return localSmsMessage;
      Cursor localCursor = null;
      try
      {
        ContentResolver localContentResolver = getContentResolver();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = "_id";
        localCursor = localContentResolver.query(paramUri, arrayOfString, null, null, null);
        if (localCursor.moveToFirst())
        {
          int i = localCursor.getInt(0);
          Uri localUri = ContentUris.withAppendedId(STATUS_URI, i);
          int j = localSmsMessage.getStatus();
          boolean bool = localSmsMessage.isStatusReportMessage();
          ContentValues localContentValues = new ContentValues(1);
          if (Dbg.d()) {
            Dbg.d("updateMessageStatus: msgUrl=" + paramUri + ", status=" + j + ", isStatusReport=" + bool);
          }
          localContentValues.put("status", Integer.valueOf(j));
          getContentResolver().update(localUri, localContentValues, null, null);
        }
        while (localCursor != null)
        {
          localCursor.close();
          break;
          if (Dbg.w()) {
            Dbg.w("Can't find message for status update: " + paramUri);
          }
        }
      }
      catch (Exception localException)
      {
        Dbg.w("Failed update message status", localException);
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (!"com.sonyericsson.extras.liveware.SMS_RESULT_INTENT".equals(paramIntent.getAction()))
    {
      if ("com.sonyericsson.extras.liveware.SMS_DELIVERY_INTENT".equals(paramIntent.getAction()))
      {
        Uri localUri = paramIntent.getData();
        SmsMessage localSmsMessage = updateMessageStatus(localUri, paramIntent.getByteArrayExtra("pdu"));
        if (hasDeliveryStatusColumn(localUri)) {
          updateDeliveryStatus(localUri, localSmsMessage.getStatus());
        }
      }
    }
    else
    {
      int i = paramIntent.getIntExtra("errorCode", 0);
      i = handleSmsSent(paramIntent, paramIntent.getIntExtra("result", 0), i);
      ActionUtils.sendExecuteReplyIntent(this, paramIntent.getStringExtra("id"), i);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.sms.SmsResultService
 * JD-Core Version:    0.7.0.1
 */
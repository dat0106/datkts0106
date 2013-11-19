package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.preference.PreferenceManager;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.ui.MillerDeprecatedActivity;
import com.sonyericsson.extras.liveware.ui.UpdateActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.PhoneUtils;
import com.sonyericsson.extras.liveware.utils.TagParser;
import com.sonyericsson.extras.liveware.utils.TagParser.TagKey;
import com.sonyericsson.extras.liveware.utils.TagParser.TagParseException;
import java.util.ArrayList;
import java.util.List;

public class SmartTagsHandler
  extends ConnectionHandler
{
  public static final String MILLER_APP_PACKAGE_NAME = "com.sonyericsson.extras.smarttags";
  public static final String NFC_PRODUCT = "nfc_product_";
  public static final String PREFKEY_PROMPT_MILLER = "PREFKEY_PROMPT_MILLER";
  
  public static SmartTagsHandler getNewHandler()
  {
    return new SmartTagsHandler();
  }
  
  public static List<Intent> getTriggerIntents(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, paramString, true, 17, 10, null));
    return localArrayList;
  }
  
  private static List<Intent> handleNfc(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = null;
    if (Dbg.v()) {
      Dbg.v("handleNfc");
    }
    if (!paramIntent.getAction().equals("android.nfc.action.NDEF_DISCOVERED")) {}
    for (;;)
    {
      return localObject1;
      if (PhoneUtils.hasOngoingCall(paramContext))
      {
        Dbg.d("Ignoring smart tag due to ongoing call.");
      }
      else
      {
        Object localObject2 = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if ((localObject2 != null) && (localObject2.length > 0) && ((localObject2[0] instanceof NdefMessage)))
        {
          localObject2 = ((NdefMessage)localObject2[0]).getRecords();
          if (localObject2.length != 0)
          {
            localObject2 = Uri.parse(new String(localObject2[0].getPayload()));
            try
            {
              switch (TagParser.getConcept((Uri)localObject2))
              {
              default: 
                if (!Dbg.e()) {
                  continue;
                }
                Dbg.e("Unhandled concept.");
              }
            }
            catch (TagParser.TagParseException localTagParseException) {}
            if (Dbg.e())
            {
              Dbg.e("Illegal uri \"" + localObject2 + "\" (" + localTagParseException.getMessage() + ")");
              continue;
              localObject1 = TagParser.parseTagKey((Uri)localObject2);
              localObject1 = handleTagKey(paramContext, ((TagParser.TagKey)localObject1).getProductId(), ((TagParser.TagKey)localObject1).getProductName(), ((TagParser.TagKey)localObject1).getTagCode());
              continue;
              localObject1 = handleUpdate(paramContext, (Uri)localObject2);
              localObject1 = localObject1;
            }
          }
        }
      }
    }
  }
  
  private static List<Intent> handleTagKey(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new ArrayList();
    if (Dbg.v()) {
      Dbg.v("handleTagKey");
    }
    String str = "nfc_product_" + paramString1 + "." + paramInt;
    if (!showMillerDeprecated(paramContext, str)) {
      localObject = getTriggerIntents(paramContext, str);
    }
    return localObject;
  }
  
  private static List<Intent> handleUpdate(Context paramContext, Uri paramUri)
  {
    UpdateActivity.showUpdateDialog(paramContext);
    return null;
  }
  
  public static void neverShowMillerDeprecatedDialogAgain(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean("PREFKEY_PROMPT_MILLER", false).commit();
  }
  
  private static boolean showMillerDeprecated(Context paramContext, String paramString)
  {
    boolean bool = true;
    if (!PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("PREFKEY_PROMPT_MILLER", bool))
    {
      Dbg.d("showMillerDeprecated PREFKEY_PROMPT_MILLER false");
    }
    else
    {
      if (PackageUtils.existsPackage(paramContext, "com.sonyericsson.extras.smarttags")) {
        break label46;
      }
      Dbg.d("showMillerDeprecated No miller found");
    }
    return false;
    label46:
    if (!PackageUtils.existsSystemPackage(paramContext, "com.sonyericsson.extras.smarttags")) {
      MillerDeprecatedActivity.showDialog(paramContext, false, paramString);
    } else {
      MillerDeprecatedActivity.showDialog(paramContext, bool, paramString);
    }
    return bool;
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return handleNfc(paramContext, paramIntent);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent) {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.SmartTagsHandler
 * JD-Core Version:    0.7.0.1
 */
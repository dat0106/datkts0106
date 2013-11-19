package com.sonyericsson.extras.liveware.actions.directcall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PhoneUtils.PhoneNumber;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class DirectCallAction
  extends AbstractAction
{
  public DirectCallAction()
  {
    super(DirectCallAction.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Object localObject = new JSONObject(paramString);
      ArrayList localArrayList = new ArrayList();
      String str1 = ((JSONObject)localObject).optString(paramContext.getString(2131099657), null);
      String str3 = ((JSONObject)localObject).optString(paramContext.getString(2131099656), null);
      localObject = ((JSONObject)localObject).optString(paramContext.getString(2131099655), null);
      if (!TextUtils.isEmpty(str1)) {
        localArrayList.add(str1);
      }
      if (!TextUtils.isEmpty(str3)) {
        localArrayList.add(str3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localArrayList.add(localObject);
        break label194;
        for (;;)
        {
          String str2 = localArrayList.size();
          if (str3 >= str2) {
            return localStringBuilder.toString();
          }
          localStringBuilder.append((String)localArrayList.get(str3));
          if (str3 < -1 + localArrayList.size()) {
            localStringBuilder.append(", ");
          }
          str3++;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
        continue;
        label194:
        int i = 0;
      }
    }
  }
  
  public static JSONObject getRawSetting(Context paramContext, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put(paramContext.getString(2131099655), paramString);
    return localJSONObject;
  }
  
  public static JSONObject getRawSetting(Context paramContext, String paramString, PhoneUtils.PhoneNumber paramPhoneNumber)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put(paramContext.getString(2131099657), paramString);
    if (paramPhoneNumber != null)
    {
      localJSONObject.put(paramContext.getString(2131099655), paramPhoneNumber.number);
      localJSONObject.put(paramContext.getString(2131099656), paramPhoneNumber.label);
    }
    return localJSONObject;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, DirectCallService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("Get inject settings intent");
    return null;
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, DirectCallSettings.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.directcall.DirectCallAction
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.actions.bluetooth.a2dp;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothA2dp
  extends AbstractAction
{
  public BluetoothA2dp()
  {
    super(BluetoothA2dp.class.getSimpleName());
  }
  
  public static String buildRawSetting(Context paramContext, String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put(paramContext.getString(2131099651), paramString1);
    localJSONObject.put(paramContext.getString(2131099652), paramString2);
    return localJSONObject.toString();
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    try
    {
      str1 = new JSONObject(paramString).getString(paramContext.getString(2131099652));
      str1 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        Dbg.e(localJSONException);
        String str2 = "";
      }
    }
    return str1;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, BluetoothA2dpAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, BluetoothA2dpSettings.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool = true;
    try
    {
      arrayOfClass = new Class[1];
      arrayOfClass[0] = BluetoothDevice.class;
      android.bluetooth.BluetoothA2dp.class.getMethod("connect", arrayOfClass);
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = BluetoothDevice.class;
          android.bluetooth.BluetoothA2dp.class.getMethod("connectSink", arrayOfClass);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          bool = false;
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.BluetoothA2dp
 * JD-Core Version:    0.7.0.1
 */
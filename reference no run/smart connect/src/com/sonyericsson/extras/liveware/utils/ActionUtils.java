package com.sonyericsson.extras.liveware.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.Action.ActionEditor;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.ExperienceManager.EmException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ActionUtils
{
  public static final String ACTIVITY_KEY = "activity";
  public static final String CATEGORY_KEY = "category";
  
  private static boolean actionExists(List<ResolveInfo> paramList, Action paramAction)
  {
    int i = 0;
    while (i < paramList.size())
    {
      String str = ((ResolveInfo)paramList.get(i)).serviceInfo.name;
      if (!paramAction.getClassName().equals(str))
      {
        i++;
      }
      else
      {
        paramList.remove(i);
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static int createActionSet(Activity paramActivity, Action paramAction, long paramLong, int paramInt1, UUID paramUUID, int paramInt2)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramActivity);
    Object localObject = localExperienceManager.getActionSetByType(paramLong, paramInt1);
    int i = 0;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActionSet localActionSet2 = (ActionSet)((Iterator)localObject).next();
      if (localActionSet2.getPosition() >= i) {
        i = 1 + localActionSet2.getPosition();
      }
    }
    ActionSet localActionSet1 = new ActionSet(paramAction, paramLong, paramInt1, i, "", "", paramUUID, 0);
    localExperienceManager.addActionSet(localActionSet1);
    return localActionSet1.settingsUi(null, paramActivity, paramInt2);
  }
  
  private static void disableRemovedActionsInDB(Context paramContext)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    List localList = getActionResolveInfos(paramContext);
    Iterator localIterator = localExperienceManager.getAllEnabledActions().iterator();
    while (localIterator.hasNext())
    {
      Action localAction = (Action)localIterator.next();
      if (!actionExists(localList, localAction))
      {
        localExperienceManager.updateAction(localAction.edit().setDisable(true));
        Dbg.d("Disabling " + localAction.getClassName());
      }
    }
  }
  
  public static void finishActivityWithSetting(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("setting_raw", paramString1);
      localIntent.putExtra("setting_label", paramString2);
      paramActivity.setResult(-1, localIntent);
    }
    paramActivity.finish();
  }
  
  public static String getActionActivityByMetadata(Bundle paramBundle)
  {
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("activity", "");
    } else {
      str = "";
    }
    return str;
  }
  
  public static int getActionCategoryByMetadata(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null)
    {
      String str = paramBundle.getString("category", "");
      if ((!TextUtils.isEmpty(str)) && (!"other".equalsIgnoreCase(str))) {
        if (!"applications".equalsIgnoreCase(str))
        {
          if (!"media".equalsIgnoreCase(str))
          {
            if (!"sound".equalsIgnoreCase(str))
            {
              if (!"communication".equalsIgnoreCase(str))
              {
                if (!"network".equalsIgnoreCase(str))
                {
                  if (!"display".equalsIgnoreCase(str))
                  {
                    if (!"text to speech".equalsIgnoreCase(str)) {
                      Dbg.e("Invalid category: " + str);
                    } else {
                      i = 7;
                    }
                  }
                  else {
                    i = 6;
                  }
                }
                else {
                  i = 5;
                }
              }
              else {
                i = 4;
              }
            }
            else {
              i = 3;
            }
          }
          else {
            i = 2;
          }
        }
        else {
          i = 1;
        }
      }
    }
    return i;
  }
  
  public static List<ResolveInfo> getActionResolveInfos(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.EXECUTE_ACTION");
    localIntent.setPackage("com.sonyericsson.extras.liveware");
    return localPackageManager.queryIntentServices(localIntent, 128);
  }
  
  public static String getCategoryName(Context paramContext, int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      Dbg.e("Unknown category.");
      str = paramContext.getString(2131099961);
      break;
    case 0: 
      str = paramContext.getString(2131099961);
      break;
    case 1: 
      str = paramContext.getString(2131099954);
      break;
    case 2: 
      str = paramContext.getString(2131099956);
      break;
    case 3: 
      str = paramContext.getString(2131099955);
      break;
    case 4: 
      str = paramContext.getString(2131099957);
      break;
    case 5: 
      str = paramContext.getString(2131099958);
      break;
    case 6: 
      str = paramContext.getString(2131099960);
      break;
    case 7: 
      str = paramContext.getString(2131099959);
    }
    return str;
  }
  
  public static Intent getSettingsHandlerIntent(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str1 = null;
    String str2 = null;
    int i = 1;
    if (localBundle != null)
    {
      str1 = localBundle.getString("id");
      str2 = localBundle.getString("setting_inject");
      i = 0;
    }
    sendInjectSettingsResponseIntent(paramContext, str1, i, str2);
    return null;
  }
  
  private static void queryAndAddActions(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    Iterator localIterator = getActionResolveInfos(paramContext).iterator();
    if (!localIterator.hasNext()) {
      label29:
      return;
    }
    Object localObject2 = (ResolveInfo)localIterator.next();
    Object localObject1 = ((ResolveInfo)localObject2).loadLabel(paramContext.getPackageManager());
    String str2;
    label66:
    String str1;
    String str3;
    Action localAction;
    int i;
    String str4;
    if (localObject1 != null)
    {
      str2 = ((CharSequence)localObject1).toString();
      str1 = ((ResolveInfo)localObject2).serviceInfo.packageName;
      str3 = ((ResolveInfo)localObject2).serviceInfo.name;
      localAction = localExperienceManager.getActionByClass(str3);
      i = getActionCategoryByMetadata(((ResolveInfo)localObject2).serviceInfo.metaData);
      localObject1 = getActionActivityByMetadata(((ResolveInfo)localObject2).serviceInfo.metaData);
      str4 = "";
      if (((ResolveInfo)localObject2).serviceInfo.icon == 0) {}
    }
    try
    {
      str4 = localPackageManager.getResourcesForApplication(str1).getResourceName(((ResolveInfo)localObject2).serviceInfo.icon);
      str4 = str4;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        Dbg.e(localNotFoundException);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Dbg.e(localNameNotFoundException);
      }
    }
    if (localAction == null)
    {
      localObject2 = UUID.randomUUID();
      localAction = new Action(str2, str3, str1, (UUID)localObject2, str4, (String)localObject1, i);
    }
    for (;;)
    {
      try
      {
        localExperienceManager.addAction(localAction);
        localAction.requestCompability(paramContext, ((UUID)localObject2).toString());
      }
      catch (ExperienceManager.EmException localEmException)
      {
        Dbg.e("Failed to add new action");
      }
      str2 = "";
      break label66;
      break label29;
      if (!str2.equals(localAction.getName())) {
        localExperienceManager.updateAction(localAction.edit().setName(str2));
      }
      if (i != localAction.getCategory()) {
        localExperienceManager.updateAction(localAction.edit().setCategory(i));
      }
      if (!((String)localObject1).equals(localAction.getActivityName())) {
        localExperienceManager.updateAction(localAction.edit().setActivityName((String)localObject1));
      }
      if (!str4.equals(localAction.getIconUri())) {
        localExperienceManager.updateAction(localAction.edit().setIconUri(str4));
      }
      UUID localUUID = localAction.getUuid();
    }
  }
  
  public static void sendCompabilityResponseIntent(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.CHECK_COMPABILITY_ACTION_RESPONSE_ACTION");
    localIntent.putExtra("id", paramString);
    localIntent.putExtra("is_compatible", paramBoolean);
    localIntent.setComponent(ComponentName.unflattenFromString("com.sonyericsson.extras.liveware/.actions.ActionResultService"));
    paramContext.startService(localIntent);
  }
  
  public static void sendExecuteReplyIntent(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.EXECUTE_RESPONSE_ACTION");
    localIntent.putExtra("id", paramString);
    localIntent.putExtra("execution_result", paramInt);
    localIntent.setComponent(ComponentName.unflattenFromString("com.sonyericsson.extras.liveware/.actions.ActionResultService"));
    paramContext.startService(localIntent);
  }
  
  public static void sendInjectSettingsResponseIntent(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.SETTINGS_INJECT_RESPONSE_ACTION");
    localIntent.putExtra("id", paramString1);
    localIntent.putExtra("inject_result", paramInt);
    localIntent.putExtra("setting_raw", paramString2);
    localIntent.putExtra("setting_label", "TODO JAK");
    localIntent.setComponent(ComponentName.unflattenFromString("com.sonyericsson.extras.liveware/.actions.ActionResultService"));
    paramContext.startService(localIntent);
  }
  
  public static void sendUpdateActionResponseIntent(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.UPDATE_RESPONSE_ACTION");
    localIntent.putExtra("id", paramString1);
    localIntent.putExtra("setting_label", paramString2);
    localIntent.setComponent(ComponentName.unflattenFromString("com.sonyericsson.extras.liveware/.actions.ActionResultService"));
    paramContext.startService(localIntent);
  }
  
  public static void updateActions(Context paramContext)
  {
    queryAndAddActions(paramContext);
    disableRemovedActionsInDB(paramContext);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ActionUtils
 * JD-Core Version:    0.7.0.1
 */
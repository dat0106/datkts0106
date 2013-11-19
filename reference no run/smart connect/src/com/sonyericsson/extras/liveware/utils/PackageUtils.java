package com.sonyericsson.extras.liveware.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.experience.Feature.FeatureEditor;
import com.sonyericsson.extras.liveware.ui.LaunchActivity;
import com.sonyericsson.extras.liveware.ui.PreferenceLaunchActivity;
import com.sonyericsson.extras.liveware.ui.StartActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PackageUtils
{
  private static Map<ComponentIntentTuple, Boolean> sCanHandleIntent = new HashMap();
  private static Map<ComponentName, Boolean> sIsReceiver = new HashMap();
  
  private static void addNewActivities(List<ResolveInfo> paramList1, List<ResolveInfo> paramList2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = paramList2.iterator();
    while (localIterator2.hasNext())
    {
      ResolveInfo localResolveInfo2 = (ResolveInfo)localIterator2.next();
      if ((!paramBoolean) || (localResolveInfo2.filter.countCategories() <= 0))
      {
        ComponentName localComponentName = new ComponentName(localResolveInfo2.activityInfo.packageName, localResolveInfo2.activityInfo.name);
        int i = 0;
        Iterator localIterator1 = paramList1.iterator();
        while (localIterator1.hasNext())
        {
          ResolveInfo localResolveInfo1 = (ResolveInfo)localIterator1.next();
          if (localComponentName.equals(new ComponentName(localResolveInfo1.activityInfo.packageName, localResolveInfo1.activityInfo.name))) {
            i = 1;
          }
        }
        if (i == 0) {
          localArrayList.add(localResolveInfo2);
        }
      }
    }
    paramList1.addAll(localArrayList);
  }
  
  public static boolean canHandleIntent(Context paramContext, ComponentName paramComponentName, Intent paramIntent)
  {
    ComponentIntentTuple localComponentIntentTuple = new ComponentIntentTuple(paramComponentName, new Intent(paramIntent));
    Boolean localBoolean = (Boolean)sCanHandleIntent.get(localComponentIntentTuple);
    boolean bool2;
    if (localBoolean != null)
    {
      boolean bool1 = localBoolean.booleanValue();
    }
    else
    {
      Object localObject = paramContext.getPackageManager();
      Intent localIntent = new Intent(paramIntent);
      localIntent.setComponent(null);
      localObject = ((PackageManager)localObject).queryIntentActivities(localIntent, 0);
      bool2 = false;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (ResolveInfo)localIterator.next();
        if ((((ResolveInfo)localObject).activityInfo.packageName.equals(paramComponentName.getPackageName())) && (((ResolveInfo)localObject).activityInfo.name.equals(paramComponentName.getClassName()))) {
          bool2 = true;
        }
      }
      sCanHandleIntent.put(localComponentIntentTuple, Boolean.valueOf(bool2));
    }
    return bool2;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public static boolean checkReceiver(Context paramContext, ComponentName paramComponentName)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/sonyericsson/extras/liveware/utils/PackageUtils:sIsReceiver	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 102 2 0
    //   12: checkcast 104	java/lang/Boolean
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +15 -> 32
    //   20: aload_2
    //   21: invokevirtual 107	java/lang/Boolean:booleanValue	()Z
    //   24: istore_2
    //   25: iload_2
    //   26: istore_2
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 113	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   36: astore_2
    //   37: aload_2
    //   38: aload_1
    //   39: iconst_0
    //   40: invokevirtual 149	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   43: pop
    //   44: iconst_1
    //   45: invokestatic 137	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: astore_2
    //   49: aload_2
    //   50: astore_2
    //   51: getstatic 21	com/sonyericsson/extras/liveware/utils/PackageUtils:sIsReceiver	Ljava/util/Map;
    //   54: aload_1
    //   55: aload_2
    //   56: invokeinterface 141 3 0
    //   61: pop
    //   62: aload_2
    //   63: invokevirtual 107	java/lang/Boolean:booleanValue	()Z
    //   66: istore_2
    //   67: goto -40 -> 27
    //   70: pop
    //   71: iconst_0
    //   72: invokestatic 137	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_2
    //   78: goto -27 -> 51
    //   81: astore_2
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramContext	Context
    //   0	87	1	paramComponentName	ComponentName
    //   15	6	2	localBoolean1	Boolean
    //   24	7	2	bool1	boolean
    //   36	27	2	localObject1	Object
    //   66	1	2	bool2	boolean
    //   75	3	2	localBoolean2	Boolean
    //   81	5	2	localObject2	Object
    //   70	1	8	localNameNotFoundException	PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   37	49	70	android/content/pm/PackageManager$NameNotFoundException
    //   3	25	81	finally
    //   32	37	81	finally
    //   37	49	81	finally
    //   51	76	81	finally
  }
  
  public static List<ApplicationData> createAppData(Context paramContext, List<ResolveInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.ensureCapacity(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ResolveInfo)localIterator.next();
      if (((ResolveInfo)localObject).activityInfo == null)
      {
        if (Dbg.v()) {
          Dbg.v("No activityInfo. Can't resolve package.");
        }
      }
      else
      {
        ApplicationInfo localApplicationInfo = ((ResolveInfo)localObject).activityInfo.applicationInfo;
        localObject = ((ResolveInfo)localObject).activityInfo.name;
        localArrayList.add(new ApplicationData(paramContext, new ComponentName(localApplicationInfo.packageName, (String)localObject)));
      }
    }
    return localArrayList;
  }
  
  public static boolean disableAppIfNotOwner(Context paramContext)
  {
    boolean bool = true;
    if ((Build.VERSION.SDK_INT >= 17) && (!MultiUserUtils.isOwner())) {}
    for (;;)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 15);
        disableComponents(localPackageManager, localPackageInfo.activities);
        disableComponents(localPackageManager, localPackageInfo.services);
        disableComponents(localPackageManager, localPackageInfo.receivers);
        disableComponents(localPackageManager, localPackageInfo.providers);
        updateLauncherActivity(paramContext);
        localPackageManager.setComponentEnabledSetting(new ComponentName(paramContext, StartActivity.class), 1, 1);
        return bool;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      bool = false;
    }
  }
  
  private static void disableComponents(PackageManager paramPackageManager, ComponentInfo[] paramArrayOfComponentInfo)
  {
    if (paramArrayOfComponentInfo != null)
    {
      int i = paramArrayOfComponentInfo.length;
      for (int j = 0; j < i; j++)
      {
        ComponentInfo localComponentInfo = paramArrayOfComponentInfo[j];
        paramPackageManager.setComponentEnabledSetting(new ComponentName(localComponentInfo.packageName, localComponentInfo.name), 2, 1);
      }
    }
  }
  
  public static boolean existsApp(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    if (!paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty()) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean existsApp(Context paramContext, String paramString)
  {
    return existsApp(paramContext, new Intent(paramString));
  }
  
  public static boolean existsPackage(Context paramContext, String paramString)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 0);
      bool = true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label16:
      break label16;
    }
    return bool;
  }
  
  public static boolean existsSystemPackage(Context paramContext, String paramString)
  {
    bool = true;
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        int i = localPackageManager.getPackageInfo(paramString, 0).applicationInfo.flags;
        if ((i & 0x1) != bool) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  public static void filterLiveware(List<ResolveInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if (localResolveInfo.activityInfo.packageName.equals("com.sonyericsson.extras.liveware")) {
        localArrayList.add(localResolveInfo);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void findAndSetDefaultApp(Context paramContext, Device paramDevice, Intent paramIntent, String paramString, int paramInt)
  {
    if (paramInt == 4)
    {
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
      Object localObject1 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (((ResolveInfo)localObject2).activityInfo.packageName.equals(paramString))
        {
          localObject1 = new ComponentName(((ResolveInfo)localObject2).activityInfo.packageName, ((ResolveInfo)localObject2).activityInfo.name);
          localObject2 = paramDevice.getFeature(paramInt).edit();
          ((Feature.FeatureEditor)localObject2).setComponentName((ComponentName)localObject1);
          localExperienceManager.updateFeature((Feature.FeatureEditor)localObject2);
        }
      }
    }
  }
  
  public static List<ResolveInfo> getActivities(Context paramContext, Feature paramFeature, List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject;
    if (paramFeature == null)
    {
      localObject = new Intent("com.sonyericsson.extras.ATTACHED");
    }
    else
    {
      if (Dbg.d()) {
        Dbg.d("Searching for applications matching " + paramFeature.getIntent());
      }
      localObject = new Intent(paramFeature.getIntent());
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null) {
        ((Intent)localObject).addCategory(str);
      }
      List localList = localPackageManager.queryIntentActivities((Intent)localObject, 64);
      boolean bool;
      if (str != null) {
        bool = false;
      } else {
        bool = true;
      }
      addNewActivities(localLinkedList, localList, bool);
      localList = localPackageManager.queryBroadcastReceivers((Intent)localObject, 64);
      if (str != null) {
        bool = false;
      } else {
        bool = true;
      }
      addNewActivities(localLinkedList, localList, bool);
      if (str != null) {
        ((Intent)localObject).removeCategory(str);
      }
    }
    Collections.sort(localLinkedList, new ResolveInfo.DisplayNameComparator(localPackageManager));
    if ((paramFeature == null) || (paramFeature.getIntent().equals("com.sonyericsson.extras.ATTACHED")))
    {
      localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      localObject = localPackageManager.queryIntentActivities((Intent)localObject, 0);
      filterLiveware((List)localObject);
      Collections.sort((List)localObject, new ResolveInfo.DisplayNameComparator(localPackageManager));
      addNewActivities(localLinkedList, (List)localObject, false);
    }
    return localLinkedList;
  }
  
  private static ApplicationData getActivityForIntentInPackage(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramContext.getPackageManager().queryIntentActivities(new Intent(paramString2), 0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      if (localResolveInfo.activityInfo.packageName.equals(paramString1)) {
        return new ApplicationData(paramContext, new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
      }
    }
    localObject = null;
    return localObject;
  }
  
  public static String getActivityNameFromComponentName(Context paramContext, ComponentName paramComponentName)
  {
    if (paramComponentName != null)
    {
      localObject = new ApplicationData(paramContext, paramComponentName);
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = ((ApplicationData)localObject).getName();
    return localObject;
  }
  
  public static String getActivityNameFromIntent(Context paramContext, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = null;
      if (paramIntent.getComponent() == null)
      {
        if (paramIntent.getPackage() != null)
        {
          ApplicationData localApplicationData = new ApplicationData(paramContext, paramIntent.getPackage());
          if (localApplicationData != null) {
            str = localApplicationData.getName();
          }
        }
      }
      else {
        str = getActivityNameFromComponentName(paramContext, paramIntent.getComponent());
      }
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  public static ApplicationData getAppTagReceiver(Context paramContext, String paramString)
  {
    return getReceiverForIntentInPackage(paramContext, paramString, "com.sonyericsson.extras.APPTAG");
  }
  
  private static List<ApplicationData> getApps(Context paramContext, Device paramDevice, int paramInt)
  {
    if (paramDevice != null)
    {
      Object localObject = paramDevice.getFeature(paramInt);
      if (localObject != null)
      {
        localObject = createAppData(paramContext, getActivities(paramContext, (Feature)localObject, getCategoriesForAccessoryName(paramDevice.getProductId())));
      }
      else
      {
        if (Dbg.e()) {
          Dbg.e("Feature not in accessory: " + paramInt);
        }
        localObject = null;
      }
      return localObject;
    }
    throw new IllegalArgumentException("acc cannot be null");
  }
  
  private static List<String> getCategoriesForAccessoryName(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(null);
    localLinkedList.add("android.intent.category.DEFAULT");
    if ((paramString.equals("HDMI")) || (paramString.equals("MHL")) || (paramString.equals("HDMI/MHL")))
    {
      localLinkedList.add("com.sonyericsson.extras.category.ACCESSORY_TV_OUT");
      localLinkedList.add("com.sonyericsson.extras.category.ACCESSORY_HDMI");
      localLinkedList.add("com.sonyericsson.extras.category.ACCESSORY_HDMI_TV_OUT");
    }
    return localLinkedList;
  }
  
  public static ApplicationData getDefault(Context paramContext, Device paramDevice, int paramInt)
  {
    Object localObject = paramDevice.getFeature(paramInt);
    if (localObject != null)
    {
      localObject = ((Feature)localObject).getComponentName();
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = new ApplicationData(paramContext, (ComponentName)localObject);
        if (!((ApplicationData)localObject).exists()) {
          localObject = null;
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static List<ApplicationData> getLiveKeyApps(Context paramContext, Device paramDevice)
  {
    return getApps(paramContext, paramDevice, 2);
  }
  
  public static ApplicationData getLiveKeyDefault(Context paramContext, Device paramDevice)
  {
    return getDefault(paramContext, paramDevice, 2);
  }
  
  private static ApplicationData getReceiverForIntentInPackage(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramContext.getPackageManager().queryBroadcastReceivers(new Intent(paramString2), 0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
      if (localResolveInfo.activityInfo.packageName.equals(paramString1)) {
        return new ApplicationData(paramContext, new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
      }
    }
    localObject = null;
    return localObject;
  }
  
  public static ApplicationData getSettingsActivity(Context paramContext, String paramString)
  {
    return getActivityForIntentInPackage(paramContext, paramString, "com.sonyericsson.extras.SETTINGS");
  }
  
  public static List<ApplicationData> getSmartLaunchApps(Context paramContext, Device paramDevice)
  {
    return getApps(paramContext, paramDevice, 4);
  }
  
  public static ApplicationData getSmartLaunchDefault(Context paramContext, Device paramDevice)
  {
    return getDefault(paramContext, paramDevice, 4);
  }
  
  private static void handleAasNoDefaultApp(Context paramContext, Device paramDevice)
  {
    Object localObject2 = paramDevice.getFeature(4);
    if (localObject2 == null) {
      if (Dbg.e()) {
        Dbg.e("No smartLaunch");
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = getSmartLaunchApps(paramContext, paramDevice);
      if (((List)localObject1).size() == 0)
      {
        if (Dbg.e()) {
          Dbg.e("There are no smartlaunch apps");
        }
      }
      else
      {
        localObject1 = (ApplicationData)((List)localObject1).get(0);
        setDefaultApp(paramContext, (ApplicationData)localObject1, (Feature)localObject2);
        if (localObject1 != null)
        {
          localObject2 = new Intent(((Feature)localObject2).getIntent());
          ((Intent)localObject2).setComponent(((ApplicationData)localObject1).getComponentName());
          ((Intent)localObject2).putExtra("Bearer", paramDevice.getBearerType());
          if (paramDevice.getKeyId() != null) {
            ((Intent)localObject2).putExtra("Address", paramDevice.getKeyId());
          }
          ((Intent)localObject2).setFlags(268435456);
          try
          {
            paramContext.startActivity((Intent)localObject2);
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  public static boolean hasHostApp(Context paramContext, Device paramDevice)
  {
    boolean bool = true;
    Object localObject = getSmartLaunchDefault(paramContext, paramDevice);
    if ((localObject == null) || (!((ApplicationData)localObject).getPackageName().equals("com.sonyericsson.extras.liveview")))
    {
      localObject = paramDevice.getFeature(4);
      if ((localObject == null) || (((Feature)localObject).getCompanionPkg() == null) || (((Feature)localObject).getAppSelection() != 2)) {
        bool = false;
      }
    }
    return bool;
  }
  
  public static void notifyExternalApps(Context paramContext, boolean paramBoolean)
  {
    if (Dbg.d()) {
      Dbg.d("notifyExternalApps: " + paramBoolean);
    }
    Intent localIntent = new Intent("com.sonyericsson.extras.liveware.ACCESSORY_CONFIGURATION_CHANGE");
    if (!paramBoolean) {
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.EXTRA_ACCESSORY_CONNECTION_STATE", 0);
    } else {
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.EXTRA_ACCESSORY_CONNECTION_STATE", 1);
    }
    localIntent.putExtra("com.sonyericsson.extras.liveware.extra.EXTRA_ACCESSORY_CONFIGURATION_TYPES", 1);
    paramContext.sendStickyBroadcast(localIntent);
  }
  
  /* Error */
  public static boolean sendConnectLaunch(Context paramContext, Device paramDevice, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: iconst_0
    //   5: istore_3
    //   6: iload_3
    //   7: ireturn
    //   8: aload_2
    //   9: invokestatic 520	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
    //   12: astore 4
    //   14: iconst_0
    //   15: istore 5
    //   17: aload_0
    //   18: invokevirtual 113	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   21: astore 6
    //   23: aload 6
    //   25: aload 4
    //   27: iconst_0
    //   28: invokevirtual 523	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   31: pop
    //   32: new 90	android/content/Intent
    //   35: dup
    //   36: ldc_w 298
    //   39: invokespecial 246	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: iload 5
    //   45: ifeq +116 -> 161
    //   48: aload 6
    //   50: aload_3
    //   51: iconst_0
    //   52: invokevirtual 327	android/content/pm/PackageManager:queryBroadcastReceivers	(Landroid/content/Intent;I)Ljava/util/List;
    //   55: astore 7
    //   57: iconst_0
    //   58: istore 6
    //   60: aload 7
    //   62: invokeinterface 35 1 0
    //   67: astore 7
    //   69: aload 7
    //   71: invokeinterface 41 1 0
    //   76: ifne +97 -> 173
    //   79: iload 6
    //   81: ifeq +141 -> 222
    //   84: aload_3
    //   85: ldc_w 525
    //   88: aload_1
    //   89: invokevirtual 528	com/sonyericsson/extras/liveware/experience/Device:getProductName	()Ljava/lang/String;
    //   92: invokevirtual 475	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   95: pop
    //   96: aload_3
    //   97: aload 4
    //   99: invokevirtual 117	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   102: pop
    //   103: aload_3
    //   104: ldc_w 476
    //   107: invokevirtual 480	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   110: pop
    //   111: new 174	com/sonyericsson/extras/liveware/utils/ApplicationData
    //   114: dup
    //   115: aload_0
    //   116: aload 4
    //   118: invokespecial 180	com/sonyericsson/extras/liveware/utils/ApplicationData:<init>	(Landroid/content/Context;Landroid/content/ComponentName;)V
    //   121: ifnull +13 -> 134
    //   124: iload 5
    //   126: ifeq +115 -> 241
    //   129: aload_0
    //   130: aload_3
    //   131: invokevirtual 531	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   134: iconst_1
    //   135: istore_3
    //   136: goto -130 -> 6
    //   139: pop
    //   140: aload 6
    //   142: aload 4
    //   144: iconst_0
    //   145: invokevirtual 149	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   148: pop
    //   149: iconst_1
    //   150: istore 5
    //   152: goto -120 -> 32
    //   155: pop
    //   156: iconst_0
    //   157: istore_3
    //   158: goto -152 -> 6
    //   161: aload 6
    //   163: aload_3
    //   164: iconst_0
    //   165: invokevirtual 123	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   168: astore 7
    //   170: goto -113 -> 57
    //   173: aload 7
    //   175: invokeinterface 45 1 0
    //   180: checkcast 47	android/content/pm/ResolveInfo
    //   183: getfield 63	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   186: astore 8
    //   188: new 59	android/content/ComponentName
    //   191: dup
    //   192: aload 8
    //   194: getfield 172	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   197: getfield 177	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   200: aload 8
    //   202: getfield 72	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   205: invokespecial 75	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 4
    //   210: invokevirtual 535	android/content/ComponentName:compareTo	(Landroid/content/ComponentName;)I
    //   213: ifne -144 -> 69
    //   216: iconst_1
    //   217: istore 6
    //   219: goto -150 -> 69
    //   222: aload_3
    //   223: ldc_w 343
    //   226: invokevirtual 538	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   229: pop
    //   230: aload_3
    //   231: ldc_w 345
    //   234: invokevirtual 322	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   237: pop
    //   238: goto -142 -> 96
    //   241: aload_0
    //   242: aload_3
    //   243: invokevirtual 483	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   246: goto -112 -> 134
    //   249: pop
    //   250: ldc_w 540
    //   253: invokestatic 398	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   256: pop
    //   257: iconst_0
    //   258: istore_3
    //   259: goto -253 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   0	262	1	paramDevice	Device
    //   0	262	2	paramString	String
    //   5	2	3	bool	boolean
    //   42	89	3	localIntent	Intent
    //   135	124	3	i	int
    //   12	197	4	localComponentName	ComponentName
    //   15	136	5	j	int
    //   21	28	6	localPackageManager	PackageManager
    //   58	160	6	k	int
    //   55	119	7	localObject	Object
    //   186	15	8	localActivityInfo	ActivityInfo
    //   139	1	12	localNameNotFoundException1	PackageManager.NameNotFoundException
    //   155	1	13	localNameNotFoundException2	PackageManager.NameNotFoundException
    //   249	1	14	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   23	32	139	android/content/pm/PackageManager$NameNotFoundException
    //   140	149	155	android/content/pm/PackageManager$NameNotFoundException
    //   111	134	249	java/lang/RuntimeException
    //   241	246	249	java/lang/RuntimeException
  }
  
  private static void setDefault(Context paramContext, ApplicationData paramApplicationData, Device paramDevice, int paramInt)
  {
    Feature localFeature = paramDevice.getFeature(paramInt);
    if (localFeature != null) {
      setDefaultApp(paramContext, paramApplicationData, localFeature);
    }
  }
  
  public static void setDefaultApp(Context paramContext, ApplicationData paramApplicationData, Feature paramFeature)
  {
    ComponentName localComponentName;
    if (paramApplicationData == null) {
      localComponentName = null;
    } else {
      localComponentName = paramApplicationData.getComponentName();
    }
    Feature.FeatureEditor localFeatureEditor = paramFeature.edit();
    localFeatureEditor.setComponentName(localComponentName);
    if (paramFeature.getState() != 1) {
      localFeatureEditor.setState(1);
    }
    ExperienceManager.getInstance(paramContext).updateFeature(localFeatureEditor);
  }
  
  public static void setLiveKeyDefault(Context paramContext, ApplicationData paramApplicationData, Device paramDevice)
  {
    setDefault(paramContext, paramApplicationData, paramDevice, 2);
  }
  
  public static void startSmartLaunchApplication(Context paramContext, Device paramDevice)
  {
    if (Dbg.v()) {
      Dbg.v("Starting the accessory application");
    }
    Object localObject = paramDevice.getFeature(4);
    if (localObject == null) {
      if (Dbg.e()) {
        Dbg.e("Acc doesn't support smartlaunch.");
      }
    }
    ComponentName localComponentName;
    for (;;)
    {
      return;
      localComponentName = ((Feature)localObject).getComponentName();
      if (localComponentName != null) {
        break;
      }
      handleAasNoDefaultApp(paramContext, paramDevice);
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        for (;;)
        {
          localPackageManager.getActivityInfo(localComponentName, 0);
          localObject = new Intent(((Feature)localObject).getIntent());
          ((Intent)localObject).setComponent(localComponentName);
          ((Intent)localObject).putExtra("Bearer", paramDevice.getBearerType());
          if (paramDevice.getBearerType() == 4)
          {
            if (paramDevice.getKeyId() == null) {
              break label160;
            }
            ((Intent)localObject).putExtra("Address", paramDevice.getKeyId());
          }
          ((Intent)localObject).setFlags(268435456);
          try
          {
            paramContext.startActivity((Intent)localObject);
          }
          catch (Exception localException) {}
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        setDefaultApp(paramContext, null, (Feature)localObject);
        handleAasNoDefaultApp(paramContext, paramDevice);
      }
      break;
      label160:
      Dbg.e("BT accessory without BT address");
    }
  }
  
  public static boolean testCanHandleIntentCached(ComponentName paramComponentName, Intent paramIntent)
  {
    ComponentIntentTuple localComponentIntentTuple = new ComponentIntentTuple(paramComponentName, new Intent(paramIntent));
    return sCanHandleIntent.containsKey(localComponentIntentTuple);
  }
  
  public static void uninstallApplication(Context paramContext, ApplicationData paramApplicationData)
  {
    String str = paramApplicationData.getPackageName();
    paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)));
  }
  
  public static void updateLauncherActivity(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Resources localResources = paramContext.getResources();
    ComponentName localComponentName2 = new ComponentName(paramContext, LaunchActivity.class);
    int j;
    if (!localResources.getBoolean(2131427330)) {
      j = 2;
    } else {
      j = 1;
    }
    localPackageManager.setComponentEnabledSetting(localComponentName2, j, 1);
    if (Dbg.d()) {
      Dbg.d("Updated LaunchActivity: " + j);
    }
    ComponentName localComponentName1 = new ComponentName(paramContext, PreferenceLaunchActivity.class);
    int i;
    if (!localResources.getBoolean(2131427331)) {
      i = 2;
    } else {
      i = 1;
    }
    localPackageManager.setComponentEnabledSetting(localComponentName1, i, 1);
    if (Dbg.d()) {
      Dbg.d("Updated PreferenceLaunchActivity: " + i);
    }
  }
  
  private static class ComponentIntentTuple
  {
    private ComponentName mComponentName;
    private Intent mIntent;
    
    public ComponentIntentTuple(ComponentName paramComponentName, Intent paramIntent)
    {
      this.mComponentName = paramComponentName;
      this.mIntent = paramIntent;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if ((paramObject instanceof ComponentIntentTuple))
      {
        ComponentIntentTuple localComponentIntentTuple = (ComponentIntentTuple)paramObject;
        if ((this.mComponentName.equals(localComponentIntentTuple.mComponentName)) && (this.mIntent.filterEquals(localComponentIntentTuple.mIntent))) {
          bool = true;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      return this.mComponentName.hashCode() ^ this.mIntent.filterHashCode();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.PackageUtils
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

class ActivityChooserModel
  extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final SerialExecutor SERIAL_EXECUTOR = new SerialExecutor(null);
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry;
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivites = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new DefaultSorter(null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final Handler mHandler = new Handler();
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  
  static
  {
    sDataModelRegistry = new HashMap();
  }
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((TextUtils.isEmpty(paramString)) || (paramString.endsWith(".xml"))) {
      this.mHistoryFileName = paramString;
    } else {
      this.mHistoryFileName = (paramString + ".xml");
    }
  }
  
  private boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    synchronized (this.mInstanceLock)
    {
      boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
      if (bool)
      {
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsLocked();
        persistHistoricalData();
        sortActivities();
      }
      return bool;
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel);
      }
      localActivityChooserModel.readHistoricalData();
      return localActivityChooserModel;
    }
  }
  
  private void loadActivitiesLocked()
  {
    this.mActivites.clear();
    List localList;
    int i;
    if (this.mIntent == null)
    {
      notifyChanged();
    }
    else
    {
      localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      i = localList.size();
    }
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        sortActivities();
        return;
      }
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(j);
      this.mActivites.add(new ActivityResolveInfo(localResolveInfo));
    }
  }
  
  /* Error */
  private void persistHistoricalData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	com/actionbarsherlock/widget/ActivityChooserModel:mInstanceLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 146	com/actionbarsherlock/widget/ActivityChooserModel:mReadShareHistoryCalled	Z
    //   11: ifne +19 -> 30
    //   14: new 267	java/lang/IllegalStateException
    //   17: dup
    //   18: ldc_w 269
    //   21: invokespecial 272	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: astore_1
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: getfield 148	com/actionbarsherlock/widget/ActivityChooserModel:mHistoricalRecordsChanged	Z
    //   34: ifne +8 -> 42
    //   37: aload_2
    //   38: monitorexit
    //   39: goto +40 -> 79
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 148	com/actionbarsherlock/widget/ActivityChooserModel:mHistoricalRecordsChanged	Z
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 144	com/actionbarsherlock/widget/ActivityChooserModel:mCanReadHistoricalData	Z
    //   52: aload_0
    //   53: getfield 175	com/actionbarsherlock/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   56: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +18 -> 77
    //   62: getstatic 124	com/actionbarsherlock/widget/ActivityChooserModel:SERIAL_EXECUTOR	Lcom/actionbarsherlock/widget/ActivityChooserModel$SerialExecutor;
    //   65: new 8	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister
    //   68: dup
    //   69: aload_0
    //   70: aconst_null
    //   71: invokespecial 273	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:<init>	(Lcom/actionbarsherlock/widget/ActivityChooserModel;Lcom/actionbarsherlock/widget/ActivityChooserModel$1;)V
    //   74: invokevirtual 277	com/actionbarsherlock/widget/ActivityChooserModel$SerialExecutor:execute	(Ljava/lang/Runnable;)V
    //   77: aload_2
    //   78: monitorexit
    //   79: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ActivityChooserModel
    //   25	4	1	localObject1	Object
    //   4	74	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	28	25	finally
    //   30	79	25	finally
  }
  
  private void pruneExcessiveHistoricalRecordsLocked()
  {
    List localList = this.mHistoricalRecords;
    int j = localList.size() - this.mHistoryMaxSize;
    if (j > 0) {
      this.mHistoricalRecordsChanged = true;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      ((HistoricalRecord)localList.remove(0));
    }
  }
  
  private void readHistoricalData()
  {
    synchronized (this.mInstanceLock)
    {
      if ((!this.mCanReadHistoricalData) || (this.mHistoricalRecordsChanged))
      {
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        if (!TextUtils.isEmpty(this.mHistoryFileName)) {
          SERIAL_EXECUTOR.execute(new HistoryLoader(null));
        }
      }
    }
  }
  
  private void sortActivities()
  {
    synchronized (this.mInstanceLock)
    {
      if ((this.mActivitySorter != null) && (!this.mActivites.isEmpty()))
      {
        this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
        notifyChanged();
      }
      return;
    }
  }
  
  public Intent chooseActivity(int paramInt)
  {
    Object localObject = (ActivityResolveInfo)this.mActivites.get(paramInt);
    ComponentName localComponentName = new ComponentName(((ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, ((ActivityResolveInfo)localObject).resolveInfo.activityInfo.name);
    localObject = new Intent(this.mIntent);
    ((Intent)localObject).setComponent(localComponentName);
    if (this.mActivityChoserModelPolicy != null)
    {
      Intent localIntent = new Intent((Intent)localObject);
      if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent)) {}
    }
    else
    {
      addHisoricalRecord(new HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
      return localObject;
    }
    localObject = null;
    return localObject;
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivites.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mActivites.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    List localList = this.mActivites;
    int j = localList.size();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        i = -1;
        break;
      }
      if (((ActivityResolveInfo)localList.get(i)).resolveInfo == paramResolveInfo) {
        break;
      }
    }
    return i;
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      ResolveInfo localResolveInfo1;
      if (!this.mActivites.isEmpty()) {
        localResolveInfo1 = ((ActivityResolveInfo)this.mActivites.get(0)).resolveInfo;
      } else {
        localResolveInfo1 = null;
      }
    }
    return localResolveInfo2;
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter != paramActivitySorter)
      {
        this.mActivitySorter = paramActivitySorter;
        sortActivities();
      }
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.mActivites.get(paramInt);
    ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.mActivites.get(0);
    float f;
    if (localActivityResolveInfo2 == null) {
      f = 1.0F;
    } else {
      f = 5.0F + (f.weight - localActivityResolveInfo1.weight);
    }
    addHisoricalRecord(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize != paramInt)
      {
        this.mHistoryMaxSize = paramInt;
        pruneExcessiveHistoricalRecordsLocked();
        sortActivities();
      }
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent != paramIntent)
      {
        this.mIntent = paramIntent;
        loadActivitiesLocked();
      }
    }
  }
  
  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
  }
  
  private final class HistoryPersister
    implements Runnable
  {
    private HistoryPersister() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   4: invokestatic 34	com/actionbarsherlock/widget/ActivityChooserModel:access$600	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: new 36	java/util/ArrayList
      //   13: dup
      //   14: aload_0
      //   15: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   18: invokestatic 40	com/actionbarsherlock/widget/ActivityChooserModel:access$700	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
      //   21: invokespecial 43	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_0
      //   28: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   31: invokestatic 47	com/actionbarsherlock/widget/ActivityChooserModel:access$500	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
      //   34: aload_0
      //   35: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   38: invokestatic 51	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   41: iconst_0
      //   42: invokevirtual 57	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   45: astore_1
      //   46: invokestatic 63	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   49: astore 5
      //   51: aload 5
      //   53: aload_1
      //   54: aconst_null
      //   55: invokeinterface 69 3 0
      //   60: aload 5
      //   62: ldc 71
      //   64: iconst_1
      //   65: invokestatic 77	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   68: invokeinterface 81 3 0
      //   73: aload 5
      //   75: aconst_null
      //   76: ldc 83
      //   78: invokeinterface 87 3 0
      //   83: pop
      //   84: aload_2
      //   85: invokeinterface 93 1 0
      //   90: istore 6
      //   92: iconst_0
      //   93: istore_3
      //   94: iload_3
      //   95: iload 6
      //   97: if_icmpge +140 -> 237
      //   100: aload_2
      //   101: iconst_0
      //   102: invokeinterface 97 2 0
      //   107: checkcast 99	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   110: astore 4
      //   112: aload 5
      //   114: aconst_null
      //   115: ldc 101
      //   117: invokeinterface 87 3 0
      //   122: pop
      //   123: aload 5
      //   125: aconst_null
      //   126: ldc 103
      //   128: aload 4
      //   130: getfield 106	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   133: invokevirtual 112	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   136: invokeinterface 116 4 0
      //   141: pop
      //   142: aload 5
      //   144: aconst_null
      //   145: ldc 118
      //   147: aload 4
      //   149: getfield 121	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   152: invokestatic 126	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   155: invokeinterface 116 4 0
      //   160: pop
      //   161: aload 5
      //   163: aconst_null
      //   164: ldc 128
      //   166: aload 4
      //   168: getfield 131	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   171: invokestatic 134	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   174: invokeinterface 116 4 0
      //   179: pop
      //   180: aload 5
      //   182: aconst_null
      //   183: ldc 101
      //   185: invokeinterface 137 3 0
      //   190: pop
      //   191: iinc 3 1
      //   194: goto -100 -> 94
      //   197: astore_2
      //   198: aload_1
      //   199: monitorexit
      //   200: aload_2
      //   201: athrow
      //   202: astore_1
      //   203: invokestatic 140	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   206: new 142	java/lang/StringBuilder
      //   209: dup
      //   210: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   213: ldc 145
      //   215: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   218: aload_0
      //   219: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   222: invokestatic 51	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   225: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   231: aload_1
      //   232: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   235: pop
      //   236: return
      //   237: aload 5
      //   239: aconst_null
      //   240: ldc 83
      //   242: invokeinterface 137 3 0
      //   247: pop
      //   248: aload 5
      //   250: invokeinterface 161 1 0
      //   255: aload_1
      //   256: ifnull -20 -> 236
      //   259: aload_1
      //   260: invokevirtual 166	java/io/FileOutputStream:close	()V
      //   263: goto -27 -> 236
      //   266: pop
      //   267: goto -31 -> 236
      //   270: astore_2
      //   271: invokestatic 140	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   274: new 142	java/lang/StringBuilder
      //   277: dup
      //   278: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   281: ldc 145
      //   283: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   286: aload_0
      //   287: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   290: invokestatic 51	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   293: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   299: aload_2
      //   300: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   303: pop
      //   304: aload_1
      //   305: ifnull -69 -> 236
      //   308: aload_1
      //   309: invokevirtual 166	java/io/FileOutputStream:close	()V
      //   312: goto -76 -> 236
      //   315: pop
      //   316: goto -80 -> 236
      //   319: astore_2
      //   320: invokestatic 140	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   323: new 142	java/lang/StringBuilder
      //   326: dup
      //   327: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   330: ldc 145
      //   332: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   335: aload_0
      //   336: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   339: invokestatic 51	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   342: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   348: aload_2
      //   349: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   352: pop
      //   353: aload_1
      //   354: ifnull -118 -> 236
      //   357: aload_1
      //   358: invokevirtual 166	java/io/FileOutputStream:close	()V
      //   361: goto -125 -> 236
      //   364: pop
      //   365: goto -129 -> 236
      //   368: astore_2
      //   369: invokestatic 140	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   372: new 142	java/lang/StringBuilder
      //   375: dup
      //   376: invokespecial 143	java/lang/StringBuilder:<init>	()V
      //   379: ldc 145
      //   381: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   384: aload_0
      //   385: getfield 15	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   388: invokestatic 51	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   391: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   394: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   397: aload_2
      //   398: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   401: pop
      //   402: aload_1
      //   403: ifnull -167 -> 236
      //   406: aload_1
      //   407: invokevirtual 166	java/io/FileOutputStream:close	()V
      //   410: goto -174 -> 236
      //   413: pop
      //   414: goto -178 -> 236
      //   417: astore_2
      //   418: aload_1
      //   419: ifnull +7 -> 426
      //   422: aload_1
      //   423: invokevirtual 166	java/io/FileOutputStream:close	()V
      //   426: aload_2
      //   427: athrow
      //   428: pop
      //   429: goto -3 -> 426
      //   432: astore_2
      //   433: goto -235 -> 198
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	436	0	this	HistoryPersister
      //   7	192	1	localObject1	Object
      //   202	221	1	localFileNotFoundException	java.io.FileNotFoundException
      //   24	77	2	localArrayList	ArrayList
      //   197	4	2	localObject2	Object
      //   270	30	2	localIllegalArgumentException	java.lang.IllegalArgumentException
      //   319	30	2	localIllegalStateException	java.lang.IllegalStateException
      //   368	30	2	localIOException1	java.io.IOException
      //   417	10	2	localObject3	Object
      //   432	1	2	localObject4	Object
      //   93	99	3	i	int
      //   110	57	4	localHistoricalRecord	ActivityChooserModel.HistoricalRecord
      //   49	200	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
      //   90	8	6	j	int
      //   266	1	14	localIOException2	java.io.IOException
      //   315	1	15	localIOException3	java.io.IOException
      //   364	1	16	localIOException4	java.io.IOException
      //   413	1	17	localIOException5	java.io.IOException
      //   428	1	18	localIOException6	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   10	25	197	finally
      //   198	200	197	finally
      //   27	46	202	java/io/FileNotFoundException
      //   259	263	266	java/io/IOException
      //   51	191	270	java/lang/IllegalArgumentException
      //   237	255	270	java/lang/IllegalArgumentException
      //   308	312	315	java/io/IOException
      //   51	191	319	java/lang/IllegalStateException
      //   237	255	319	java/lang/IllegalStateException
      //   357	361	364	java/io/IOException
      //   51	191	368	java/io/IOException
      //   237	255	368	java/io/IOException
      //   406	410	413	java/io/IOException
      //   51	191	417	finally
      //   237	255	417	finally
      //   271	304	417	finally
      //   320	353	417	finally
      //   369	402	417	finally
      //   422	426	428	java/io/IOException
      //   25	27	432	finally
    }
  }
  
  private final class HistoryLoader
    implements Runnable
  {
    private HistoryLoader() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   4: invokestatic 34	com/actionbarsherlock/widget/ActivityChooserModel:access$500	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
      //   7: aload_0
      //   8: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   11: invokestatic 38	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   14: invokevirtual 44	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   17: astore_1
      //   18: invokestatic 50	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   21: astore_2
      //   22: aload_2
      //   23: aload_1
      //   24: aconst_null
      //   25: invokeinterface 56 3 0
      //   30: iconst_0
      //   31: istore_3
      //   32: iload_3
      //   33: iconst_1
      //   34: if_icmpeq +18 -> 52
      //   37: iload_3
      //   38: iconst_2
      //   39: if_icmpeq +13 -> 52
      //   42: aload_2
      //   43: invokeinterface 60 1 0
      //   48: istore_3
      //   49: goto -17 -> 32
      //   52: ldc 62
      //   54: aload_2
      //   55: invokeinterface 66 1 0
      //   60: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   63: ifne +62 -> 125
      //   66: new 28	org/xmlpull/v1/XmlPullParserException
      //   69: dup
      //   70: ldc 74
      //   72: invokespecial 77	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   75: athrow
      //   76: astore_2
      //   77: invokestatic 80	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   80: new 82	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   87: ldc 85
      //   89: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: aload_0
      //   93: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   96: invokestatic 38	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   99: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: aload_2
      //   106: invokestatic 98	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   109: pop
      //   110: aload_1
      //   111: ifnull +357 -> 468
      //   114: aload_1
      //   115: invokevirtual 103	java/io/FileInputStream:close	()V
      //   118: goto +350 -> 468
      //   121: pop
      //   122: goto +346 -> 468
      //   125: new 105	java/util/ArrayList
      //   128: dup
      //   129: invokespecial 106	java/util/ArrayList:<init>	()V
      //   132: astore_3
      //   133: aload_2
      //   134: invokeinterface 60 1 0
      //   139: istore 4
      //   141: iload 4
      //   143: iconst_1
      //   144: if_icmpne +72 -> 216
      //   147: aload_0
      //   148: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   151: invokestatic 110	com/actionbarsherlock/widget/ActivityChooserModel:access$600	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
      //   154: astore_2
      //   155: aload_2
      //   156: monitorenter
      //   157: new 112	java/util/LinkedHashSet
      //   160: dup
      //   161: aload_3
      //   162: invokespecial 115	java/util/LinkedHashSet:<init>	(Ljava/util/Collection;)V
      //   165: astore 4
      //   167: aload_0
      //   168: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   171: invokestatic 119	com/actionbarsherlock/widget/ActivityChooserModel:access$700	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
      //   174: astore 5
      //   176: bipush 255
      //   178: aload 5
      //   180: invokeinterface 124 1 0
      //   185: iadd
      //   186: istore_3
      //   187: iload_3
      //   188: iflt +174 -> 362
      //   191: aload 4
      //   193: aload 5
      //   195: iload_3
      //   196: invokeinterface 128 2 0
      //   201: checkcast 130	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   204: invokeinterface 135 2 0
      //   209: pop
      //   210: iinc 3 255
      //   213: goto -26 -> 187
      //   216: iload 4
      //   218: iconst_3
      //   219: if_icmpeq -86 -> 133
      //   222: iload 4
      //   224: iconst_4
      //   225: if_icmpeq -92 -> 133
      //   228: ldc 137
      //   230: aload_2
      //   231: invokeinterface 66 1 0
      //   236: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   239: ifne +62 -> 301
      //   242: new 28	org/xmlpull/v1/XmlPullParserException
      //   245: dup
      //   246: ldc 139
      //   248: invokespecial 77	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   251: athrow
      //   252: astore_2
      //   253: invokestatic 80	com/actionbarsherlock/widget/ActivityChooserModel:access$1200	()Ljava/lang/String;
      //   256: new 82	java/lang/StringBuilder
      //   259: dup
      //   260: invokespecial 83	java/lang/StringBuilder:<init>	()V
      //   263: ldc 85
      //   265: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: aload_0
      //   269: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   272: invokestatic 38	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   275: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   278: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   281: aload_2
      //   282: invokestatic 98	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   285: pop
      //   286: aload_1
      //   287: ifnull +181 -> 468
      //   290: aload_1
      //   291: invokevirtual 103	java/io/FileInputStream:close	()V
      //   294: goto +174 -> 468
      //   297: pop
      //   298: goto +170 -> 468
      //   301: aload_3
      //   302: new 130	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   305: dup
      //   306: aload_2
      //   307: aconst_null
      //   308: ldc 141
      //   310: invokeinterface 145 3 0
      //   315: aload_2
      //   316: aconst_null
      //   317: ldc 147
      //   319: invokeinterface 145 3 0
      //   324: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   327: aload_2
      //   328: aconst_null
      //   329: ldc 155
      //   331: invokeinterface 145 3 0
      //   336: invokestatic 161	java/lang/Float:parseFloat	(Ljava/lang/String;)F
      //   339: invokespecial 164	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
      //   342: invokeinterface 165 2 0
      //   347: pop
      //   348: goto -215 -> 133
      //   351: astore_2
      //   352: aload_1
      //   353: ifnull +7 -> 360
      //   356: aload_1
      //   357: invokevirtual 103	java/io/FileInputStream:close	()V
      //   360: aload_2
      //   361: athrow
      //   362: aload 5
      //   364: invokeinterface 124 1 0
      //   369: aload 4
      //   371: invokeinterface 166 1 0
      //   376: if_icmpne +20 -> 396
      //   379: aload_2
      //   380: monitorexit
      //   381: aload_1
      //   382: ifnull +86 -> 468
      //   385: aload_1
      //   386: invokevirtual 103	java/io/FileInputStream:close	()V
      //   389: goto +79 -> 468
      //   392: pop
      //   393: goto +75 -> 468
      //   396: aload 5
      //   398: invokeinterface 169 1 0
      //   403: aload 5
      //   405: aload 4
      //   407: invokeinterface 173 2 0
      //   412: pop
      //   413: aload_0
      //   414: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   417: iconst_1
      //   418: invokestatic 177	com/actionbarsherlock/widget/ActivityChooserModel:access$802	(Lcom/actionbarsherlock/widget/ActivityChooserModel;Z)Z
      //   421: pop
      //   422: aload_0
      //   423: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   426: invokestatic 181	com/actionbarsherlock/widget/ActivityChooserModel:access$1100	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/os/Handler;
      //   429: new 8	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1
      //   432: dup
      //   433: aload_0
      //   434: invokespecial 184	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1:<init>	(Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader;)V
      //   437: invokevirtual 190	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   440: pop
      //   441: aload_2
      //   442: monitorexit
      //   443: aload_1
      //   444: ifnull +24 -> 468
      //   447: aload_1
      //   448: invokevirtual 103	java/io/FileInputStream:close	()V
      //   451: goto +17 -> 468
      //   454: pop
      //   455: goto +13 -> 468
      //   458: astore_3
      //   459: aload_2
      //   460: monitorexit
      //   461: aload_3
      //   462: athrow
      //   463: pop
      //   464: goto -104 -> 360
      //   467: pop
      //   468: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	469	0	this	HistoryLoader
      //   17	431	1	localFileInputStream	java.io.FileInputStream
      //   21	34	2	localXmlPullParser	org.xmlpull.v1.XmlPullParser
      //   76	58	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
      //   252	76	2	localIOException1	java.io.IOException
      //   351	109	2	localObject2	Object
      //   31	18	3	i	int
      //   132	30	3	localArrayList	ArrayList
      //   186	116	3	j	int
      //   458	4	3	localObject3	Object
      //   139	6	4	k	int
      //   165	241	4	localLinkedHashSet	java.util.LinkedHashSet
      //   174	230	5	localList	List
      //   121	1	14	localIOException2	java.io.IOException
      //   297	1	15	localIOException3	java.io.IOException
      //   392	1	16	localIOException4	java.io.IOException
      //   454	1	17	localIOException5	java.io.IOException
      //   463	1	18	localIOException6	java.io.IOException
      //   467	1	19	localFileNotFoundException	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   18	76	76	org/xmlpull/v1/XmlPullParserException
      //   125	157	76	org/xmlpull/v1/XmlPullParserException
      //   228	252	76	org/xmlpull/v1/XmlPullParserException
      //   301	348	76	org/xmlpull/v1/XmlPullParserException
      //   461	463	76	org/xmlpull/v1/XmlPullParserException
      //   114	118	121	java/io/IOException
      //   18	76	252	java/io/IOException
      //   125	157	252	java/io/IOException
      //   228	252	252	java/io/IOException
      //   301	348	252	java/io/IOException
      //   461	463	252	java/io/IOException
      //   290	294	297	java/io/IOException
      //   18	76	351	finally
      //   77	110	351	finally
      //   125	157	351	finally
      //   228	252	351	finally
      //   253	286	351	finally
      //   301	348	351	finally
      //   461	463	351	finally
      //   385	389	392	java/io/IOException
      //   447	451	454	java/io/IOException
      //   157	210	458	finally
      //   362	381	458	finally
      //   396	443	458	finally
      //   459	461	458	finally
      //   356	360	463	java/io/IOException
      //   0	18	467	java/io/FileNotFoundException
    }
  }
  
  private final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    private final Map<String, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();
    
    private DefaultSorter() {}
    
    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      Map localMap = this.mPackageNameToActivityMap;
      localMap.clear();
      int i = paramList.size();
      for (int k = 0;; k++)
      {
        if (k >= i)
        {
          int j = -1 + paramList1.size();
          float f = 1.0F;
          for (k = j;; k--)
          {
            if (k < 0)
            {
              Collections.sort(paramList);
              return;
            }
            ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)paramList1.get(k);
            localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)localMap.get(localHistoricalRecord.activity.getPackageName());
            if (localActivityResolveInfo != null)
            {
              localActivityResolveInfo.weight += f * localHistoricalRecord.weight;
              f *= 0.95F;
            }
          }
        }
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramList.get(k);
        localActivityResolveInfo.weight = 0.0F;
        localMap.put(localActivityResolveInfo.resolveInfo.activityInfo.packageName, localActivityResolveInfo);
      }
    }
  }
  
  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      this.resolveInfo = paramResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this != paramObject) {
        if (paramObject != null)
        {
          if (getClass() == paramObject.getClass())
          {
            ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)paramObject;
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(localActivityResolveInfo.weight)) {
              bool = false;
            }
          }
          else
          {
            bool = false;
          }
        }
        else {
          bool = false;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      return 31 + Float.floatToIntBits(this.weight);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this != paramObject) {
        if (paramObject != null)
        {
          if (getClass() == paramObject.getClass())
          {
            HistoricalRecord localHistoricalRecord = (HistoricalRecord)paramObject;
            if (this.activity != null)
            {
              if (!this.activity.equals(localHistoricalRecord.activity)) {
                return false;
              }
            }
            else {
              if (localHistoricalRecord.activity != null) {
                break label99;
              }
            }
            if (this.time == localHistoricalRecord.time)
            {
              if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(localHistoricalRecord.weight)) {
                bool = false;
              }
            }
            else
            {
              return false;
              label99:
              bool = false;
            }
          }
          else
          {
            bool = false;
          }
        }
        else {
          bool = false;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i;
      if (this.activity != null) {
        i = this.activity.hashCode();
      } else {
        i = 0;
      }
      return 31 * (31 * (i + 31) + (int)(this.time ^ this.time >>> 32)) + Float.floatToIntBits(this.weight);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private static class SerialExecutor
    implements Executor
  {
    Runnable mActive;
    final LinkedList<Runnable> mTasks = new LinkedList();
    
    /**
     * @deprecated
     */
    public void execute(final Runnable paramRunnable)
    {
      try
      {
        this.mTasks.offer(new Runnable()
        {
          public void run()
          {
            try
            {
              paramRunnable.run();
              return;
            }
            finally
            {
              ActivityChooserModel.SerialExecutor.this.scheduleNext();
            }
          }
        });
        if (this.mActive == null) {
          scheduleNext();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /**
     * @deprecated
     */
    protected void scheduleNext()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.mTasks.poll();
        this.mActive = localRunnable;
        if (localRunnable != null) {
          this.mActive.run();
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
  
  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }
  
  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0.1
 */
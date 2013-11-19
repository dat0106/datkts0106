package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Tracker
{
  private static final DecimalFormat DF = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
  static final long MAX_TOKENS = 120000L;
  static final long TIME_PER_TOKEN_MILLIS = 2000L;
  private volatile ExceptionParser mExceptionParser;
  private final TrackerHandler mHandler;
  private boolean mIsThrottlingEnabled = true;
  private volatile boolean mIsTrackerClosed = false;
  private volatile boolean mIsTrackingStarted = false;
  private long mLastTrackTime;
  private final SimpleModel mModel;
  private long mTokens = 120000L;
  
  Tracker()
  {
    this.mHandler = null;
    this.mModel = null;
  }
  
  Tracker(String paramString, TrackerHandler paramTrackerHandler)
  {
    if (paramString != null)
    {
      this.mHandler = paramTrackerHandler;
      this.mModel = new SimpleModel(null);
      this.mModel.set("trackingId", paramString);
      this.mModel.set("sampleRate", "100");
      this.mModel.setForNextHit("sessionControl", "start");
      this.mModel.set("useSecure", Boolean.toString(true));
      return;
    }
    throw new IllegalArgumentException("trackingId cannot be null");
  }
  
  private void assertTrackerOpen()
  {
    if (!this.mIsTrackerClosed) {
      return;
    }
    throw new IllegalStateException("Tracker closed");
  }
  
  private Map<String, String> constructItem(Transaction.Item paramItem, Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transactionId", paramTransaction.getTransactionId());
    localHashMap.put("currencyCode", paramTransaction.getCurrencyCode());
    localHashMap.put("itemCode", paramItem.getSKU());
    localHashMap.put("itemName", paramItem.getName());
    localHashMap.put("itemCategory", paramItem.getCategory());
    localHashMap.put("itemPrice", microsToCurrencyString(paramItem.getPriceInMicros()));
    localHashMap.put("itemQuantity", Long.toString(paramItem.getQuantity()));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
    return localHashMap;
  }
  
  private void internalSend(String paramString, Map<String, String> paramMap)
  {
    this.mIsTrackingStarted = true;
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    paramMap.put("hitType", paramString);
    this.mModel.setAll(paramMap, Boolean.valueOf(true));
    if (tokensAvailable()) {
      this.mHandler.sendHit(this.mModel.getKeysAndValues());
    } else {
      Log.wDebug("Too many hits sent too quickly, throttling invoked.");
    }
    this.mModel.clearTemporaryValues();
  }
  
  private static String microsToCurrencyString(long paramLong)
  {
    return DF.format(paramLong / 1000000.0D);
  }
  
  public void close()
  {
    this.mIsTrackerClosed = true;
    this.mHandler.closeTracker(this);
  }
  
  public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventCategory", paramString1);
    localHashMap.put("eventAction", paramString2);
    localHashMap.put("eventLabel", paramString3);
    if (paramLong != null) {
      localHashMap.put("eventValue", Long.toString(paramLong.longValue()));
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
    return localHashMap;
  }
  
  public Map<String, String> constructException(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("exDescription", paramString);
    localHashMap.put("exFatal", Boolean.toString(paramBoolean));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
    return localHashMap;
  }
  
  public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramThrowable);
    localObjectOutputStream.close();
    localHashMap.put("rawException", Utils.hexEncode(localByteArrayOutputStream.toByteArray()));
    if (paramString != null) {
      localHashMap.put("exceptionThreadName", paramString);
    }
    localHashMap.put("exFatal", Boolean.toString(paramBoolean));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_RAW_EXCEPTION);
    return localHashMap;
  }
  
  public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("socialNetwork", paramString1);
    localHashMap.put("socialAction", paramString2);
    localHashMap.put("socialTarget", paramString3);
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
    return localHashMap;
  }
  
  public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timingCategory", paramString1);
    localHashMap.put("timingValue", Long.toString(paramLong));
    localHashMap.put("timingVar", paramString2);
    localHashMap.put("timingLabel", paramString3);
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
    return localHashMap;
  }
  
  public Map<String, String> constructTransaction(Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transactionId", paramTransaction.getTransactionId());
    localHashMap.put("transactionAffiliation", paramTransaction.getAffiliation());
    localHashMap.put("transactionShipping", microsToCurrencyString(paramTransaction.getShippingCostInMicros()));
    localHashMap.put("transactionTax", microsToCurrencyString(paramTransaction.getTotalTaxInMicros()));
    localHashMap.put("transactionTotal", microsToCurrencyString(paramTransaction.getTotalCostInMicros()));
    localHashMap.put("currencyCode", paramTransaction.getCurrencyCode());
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
    return localHashMap;
  }
  
  public String get(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET);
    return this.mModel.get(paramString);
  }
  
  public String getAppId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_ID);
    return this.mModel.get("appId");
  }
  
  public String getAppInstallerId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_INSTALLER_ID);
    return this.mModel.get("appInstallerId");
  }
  
  public ExceptionParser getExceptionParser()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_EXCEPTION_PARSER);
    return this.mExceptionParser;
  }
  
  public double getSampleRate()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_SAMPLE_RATE);
    return Utils.safeParseDouble(this.mModel.get("sampleRate"));
  }
  
  public String getTrackingId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKING_ID);
    return this.mModel.get("trackingId");
  }
  
  public boolean isAnonymizeIpEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_ANONYMIZE_IP);
    return Utils.safeParseBoolean(this.mModel.get("anonymizeIp"));
  }
  
  public boolean isUseSecure()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_USE_SECURE);
    return Boolean.parseBoolean(this.mModel.get("useSecure"));
  }
  
  public void send(String paramString, Map<String, String> paramMap)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
    internalSend(paramString, paramMap);
  }
  
  public void sendEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EVENT);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("event", constructEvent(paramString1, paramString2, paramString3, paramLong));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void sendException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EXCEPTION_WITH_THROWABLE);
    String str;
    if (this.mExceptionParser != null) {
      str = this.mExceptionParser.getDescription(paramString, paramThrowable);
    }
    for (;;)
    {
      GAUsage.getInstance().setDisableUsage(true);
      sendException(str, paramBoolean);
      GAUsage.getInstance().setDisableUsage(false);
      for (;;)
      {
        return;
        try
        {
          GAUsage.getInstance().setDisableUsage(true);
          internalSend("exception", constructRawException(paramString, paramThrowable, paramBoolean));
          GAUsage.getInstance().setDisableUsage(false);
        }
        catch (IOException localIOException)
        {
          Log.w("trackException: couldn't serialize, sending \"Unknown Exception\"");
          str = "Unknown Exception";
        }
      }
    }
  }
  
  public void sendException(String paramString, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EXCEPTION_WITH_DESCRIPTION);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("exception", constructException(paramString, paramBoolean));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void sendSocial(String paramString1, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_SOCIAL);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("social", constructSocial(paramString1, paramString2, paramString3));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void sendTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_TIMING);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("timing", constructTiming(paramString1, paramLong, paramString2, paramString3));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void sendTransaction(Transaction paramTransaction)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_TRANSACTION);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("tran", constructTransaction(paramTransaction));
    Iterator localIterator = paramTransaction.getItems().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        GAUsage.getInstance().setDisableUsage(false);
        return;
      }
      internalSend("item", constructItem((Transaction.Item)localIterator.next(), paramTransaction));
    }
  }
  
  public void sendView()
  {
    assertTrackerOpen();
    if (!TextUtils.isEmpty(this.mModel.get("description")))
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_VIEW);
      internalSend("appview", null);
      return;
    }
    throw new IllegalStateException("trackView requires a appScreen to be set");
  }
  
  public void sendView(String paramString)
  {
    assertTrackerOpen();
    if (!TextUtils.isEmpty(paramString))
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_VIEW_WITH_APPSCREEN);
      this.mModel.set("description", paramString);
      internalSend("appview", null);
      return;
    }
    throw new IllegalStateException("trackView requires a appScreen to be set");
  }
  
  public void set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET);
    this.mModel.set(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_ANONYMIZE_IP);
    this.mModel.set("anonymizeIp", Boolean.toString(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_ID);
    this.mModel.set("appId", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_INSTALLER_ID);
    this.mModel.set("appInstallerId", paramString);
  }
  
  public void setAppName(String paramString)
  {
    if (!this.mIsTrackingStarted)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_NAME);
        this.mModel.set("appName", paramString);
      }
      else
      {
        Log.wDebug("setting appName to empty value not allowed, call ignored");
      }
    }
    else {
      Log.wDebug("Tracking already started, setAppName call ignored");
    }
  }
  
  public void setAppScreen(String paramString)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_SCREEN);
    this.mModel.set("description", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    if (!this.mIsTrackingStarted)
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_VERSION);
      this.mModel.set("appVersion", paramString);
    }
    else
    {
      Log.wDebug("Tracking already started, setAppVersion call ignored");
    }
  }
  
  public void setCampaign(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_CAMPAIGN);
    this.mModel.setForNextHit("campaign", paramString);
  }
  
  public void setCustomDimension(int paramInt, String paramString)
  {
    if (paramInt >= 1) {
      this.mModel.setForNextHit(Utils.getSlottedModelField("customDimension", paramInt), paramString);
    } else {
      Log.w("index must be > 0, ignoring setCustomDimension call for " + paramInt + ", " + paramString);
    }
  }
  
  public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1)
  {
    Object localObject1;
    if (paramMap != null) {
      localObject1 = paramMap.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        if (paramMap1 != null) {
          localObject2 = paramMap1.keySet().iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            return;
          }
          localObject1 = (Integer)((Iterator)localObject2).next();
          setCustomMetric(((Integer)localObject1).intValue(), (Long)paramMap1.get(localObject1));
        }
      }
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      setCustomDimension(((Integer)localObject2).intValue(), (String)paramMap.get(localObject2));
    }
  }
  
  public void setCustomMetric(int paramInt, Long paramLong)
  {
    if (paramInt >= 1)
    {
      String str = null;
      if (paramLong != null) {
        str = Long.toString(paramLong.longValue());
      }
      this.mModel.setForNextHit(Utils.getSlottedModelField("customMetric", paramInt), str);
    }
    else
    {
      Log.w("index must be > 0, ignoring setCustomMetric call for " + paramInt + ", " + paramLong);
    }
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_EXCEPTION_PARSER);
    this.mExceptionParser = paramExceptionParser;
  }
  
  @VisibleForTesting
  void setLastTrackTime(long paramLong)
  {
    this.mLastTrackTime = paramLong;
  }
  
  public void setReferrer(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_REFERRER);
    this.mModel.setForNextHit("referrer", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_SAMPLE_RATE);
    this.mModel.set("sampleRate", Double.toString(paramDouble));
  }
  
  public void setStartSession(boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_START_SESSION);
    SimpleModel localSimpleModel = this.mModel;
    String str;
    if (!paramBoolean) {
      str = null;
    } else {
      str = "start";
    }
    localSimpleModel.setForNextHit("sessionControl", str);
  }
  
  @VisibleForTesting
  public void setThrottlingEnabled(boolean paramBoolean)
  {
    this.mIsThrottlingEnabled = paramBoolean;
  }
  
  @VisibleForTesting
  void setTokens(long paramLong)
  {
    this.mTokens = paramLong;
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_USE_SECURE);
    this.mModel.set("useSecure", Boolean.toString(paramBoolean));
  }
  
  /**
   * @deprecated
   */
  @VisibleForTesting
  boolean tokensAvailable()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = this.mIsThrottlingEnabled;
        if (!bool2) {
          return bool1;
        }
        long l2 = System.currentTimeMillis();
        if (this.mTokens < 120000L)
        {
          long l1 = l2 - this.mLastTrackTime;
          if (l1 > 0L) {
            this.mTokens = Math.min(120000L, l1 + this.mTokens);
          }
        }
        this.mLastTrackTime = l2;
        if (this.mTokens >= 2000L)
        {
          this.mTokens -= 2000L;
          continue;
        }
        Log.wDebug("Excessive tracking detected.  Tracking call ignored.");
      }
      finally {}
      int i = 0;
    }
  }
  
  @Deprecated
  public void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    sendEvent(paramString1, paramString2, paramString3, paramLong);
  }
  
  @Deprecated
  public void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    sendException(paramString, paramThrowable, paramBoolean);
  }
  
  @Deprecated
  public void trackException(String paramString, boolean paramBoolean)
  {
    sendException(paramString, paramBoolean);
  }
  
  @Deprecated
  public void trackSocial(String paramString1, String paramString2, String paramString3)
  {
    sendSocial(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    sendTiming(paramString1, paramLong, paramString2, paramString3);
  }
  
  @Deprecated
  public void trackTransaction(Transaction paramTransaction)
  {
    sendTransaction(paramTransaction);
  }
  
  @Deprecated
  public void trackView()
  {
    sendView();
  }
  
  @Deprecated
  public void trackView(String paramString)
  {
    sendView(paramString);
  }
  
  private static class SimpleModel
  {
    private Map<String, String> permanentMap = new HashMap();
    private Map<String, String> temporaryMap = new HashMap();
    
    /**
     * @deprecated
     */
    public void clearTemporaryValues()
    {
      try
      {
        this.temporaryMap.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    /**
     * @deprecated
     */
    public String get(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 20	com/google/analytics/tracking/android/Tracker$SimpleModel:temporaryMap	Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface 35 2 0
      //   12: checkcast 37	java/lang/String
      //   15: astore_2
      //   16: aload_2
      //   17: ifnull +7 -> 24
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_2
      //   23: areturn
      //   24: aload_0
      //   25: getfield 22	com/google/analytics/tracking/android/Tracker$SimpleModel:permanentMap	Ljava/util/Map;
      //   28: aload_1
      //   29: invokeinterface 35 2 0
      //   34: checkcast 37	java/lang/String
      //   37: astore_2
      //   38: aload_2
      //   39: astore_2
      //   40: goto -20 -> 20
      //   43: astore_2
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_2
      //   47: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	48	0	this	SimpleModel
      //   0	48	1	paramString	String
      //   15	25	2	str	String
      //   43	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	16	43	finally
      //   24	38	43	finally
    }
    
    /**
     * @deprecated
     */
    public Map<String, String> getKeysAndValues()
    {
      try
      {
        HashMap localHashMap = new HashMap(this.permanentMap);
        localHashMap.putAll(this.temporaryMap);
        return localHashMap;
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
    public void set(String paramString1, String paramString2)
    {
      try
      {
        this.permanentMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    /**
     * @deprecated
     */
    public void setAll(Map<String, String> paramMap, Boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_2
      //   3: invokevirtual 59	java/lang/Boolean:booleanValue	()Z
      //   6: ifeq +16 -> 22
      //   9: aload_0
      //   10: getfield 20	com/google/analytics/tracking/android/Tracker$SimpleModel:temporaryMap	Ljava/util/Map;
      //   13: aload_1
      //   14: invokeinterface 45 2 0
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: getfield 22	com/google/analytics/tracking/android/Tracker$SimpleModel:permanentMap	Ljava/util/Map;
      //   26: aload_1
      //   27: invokeinterface 45 2 0
      //   32: goto -13 -> 19
      //   35: astore_3
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_3
      //   39: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	40	0	this	SimpleModel
      //   0	40	1	paramMap	Map<String, String>
      //   0	40	2	paramBoolean	Boolean
      //   35	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	35	finally
      //   22	32	35	finally
    }
    
    /**
     * @deprecated
     */
    public void setForNextHit(String paramString1, String paramString2)
    {
      try
      {
        this.temporaryMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Tracker
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.experience;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.ui.SCGenericDevicePages;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class Device
  extends Trigger
{
  private int mBearerType;
  private int mConfigured = 0;
  private long mCookie;
  private String mDevicePageActivity;
  private int mEducationLevel;
  private List<Feature> mFeatures = new ArrayList();
  private String mIconName;
  private long mId;
  private boolean mIsRemoved;
  private boolean mIsUserDefNameChanged;
  private String mKeyId;
  private String mLargeIconName;
  private int mManufacturer;
  private boolean mNotifyExternal;
  private String mProductId;
  private String mProductName;
  private boolean mRemovable;
  private long mTimestamp;
  private int mType;
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, long paramLong)
  {
    super(paramBoolean1);
    this.mProductId = paramString1;
    this.mProductName = paramString2;
    this.mIconName = paramString3;
    this.mBearerType = paramInt1;
    this.mType = paramInt2;
    this.mRemovable = paramBoolean2;
    this.mEducationLevel = 0;
    this.mNotifyExternal = paramBoolean3;
    this.mLargeIconName = paramString4;
    this.mTimestamp = paramLong;
    this.mKeyId = null;
    this.mDevicePageActivity = null;
    this.mManufacturer = 0;
    this.mCookie = 0L;
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, long paramLong1, String paramString5, int paramInt3, String paramString6, int paramInt4, long paramLong2)
  {
    super(paramBoolean1);
    this.mProductId = paramString1;
    this.mProductName = paramString2;
    this.mIconName = paramString3;
    this.mBearerType = paramInt1;
    this.mType = paramInt2;
    this.mRemovable = paramBoolean2;
    this.mEducationLevel = 0;
    this.mNotifyExternal = paramBoolean3;
    this.mLargeIconName = paramString4;
    this.mTimestamp = paramLong1;
    this.mKeyId = paramString5;
    this.mConfigured = paramInt3;
    this.mDevicePageActivity = paramString6;
    this.mManufacturer = paramInt4;
    this.mCookie = paramLong2;
  }
  
  private Intent getLaunchIntent(Context paramContext, String paramString)
  {
    Intent localIntent;
    if (!paramString.contains("/"))
    {
      localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    }
    else
    {
      localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setComponent(ComponentName.unflattenFromString(paramString));
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(276824064);
      }
    }
    return localIntent;
  }
  
  public static ByteArrayBuffer getPublicIconData(Context paramContext, String paramString, boolean paramBoolean)
  {
    ByteArrayBuffer localByteArrayBuffer;
    if (paramString != null)
    {
      if (!paramString.contains("file:///"))
      {
        if (!paramBoolean) {
          localByteArrayBuffer = getPublicIconDataFromName(paramContext, "old_" + paramString);
        } else {
          localByteArrayBuffer = getPublicIconDataFromName(paramContext, paramString);
        }
      }
      else {
        localByteArrayBuffer = getPublicIconDataFromUri(paramContext, paramString);
      }
    }
    else {
      localByteArrayBuffer = null;
    }
    return localByteArrayBuffer;
  }
  
  public static ByteArrayBuffer getPublicIconDataFromName(Context paramContext, String paramString)
  {
    int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    ByteArrayBuffer localByteArrayBuffer;
    if (i <= 0) {
      localByteArrayBuffer = null;
    } else {
      localByteArrayBuffer = getPublicIconDataFromResourceId(paramContext, localByteArrayBuffer);
    }
    return localByteArrayBuffer;
  }
  
  public static ByteArrayBuffer getPublicIconDataFromResourceId(Context paramContext, int paramInt)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayBuffer = new ByteArrayBuffer(2048);
      ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localByteArrayBuffer.append(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.toByteArray().length);
      return localByteArrayBuffer;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Dbg.e(localThrowable);
        ByteArrayBuffer localByteArrayBuffer = null;
      }
    }
  }
  
  /* Error */
  public static ByteArrayBuffer getPublicIconDataFromUri(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: invokestatic 221	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   8: astore 4
    //   10: aload_0
    //   11: invokevirtual 225	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: aload 4
    //   16: invokevirtual 231	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: new 233	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_2
    //   25: sipush 128
    //   28: invokespecial 236	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_3
    //   32: new 175	org/apache/http/util/ByteArrayBuffer
    //   35: dup
    //   36: sipush 128
    //   39: invokespecial 178	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   42: astore 4
    //   44: aload_3
    //   45: invokevirtual 240	java/io/BufferedInputStream:read	()I
    //   48: istore 5
    //   50: iload 5
    //   52: bipush 255
    //   54: if_icmpne +22 -> 76
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 245	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: ifnull +7 -> 73
    //   69: aload_3
    //   70: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   73: aload 4
    //   75: areturn
    //   76: iload 5
    //   78: i2b
    //   79: istore 5
    //   81: aload 4
    //   83: iload 5
    //   85: invokevirtual 248	org/apache/http/util/ByteArrayBuffer:append	(I)V
    //   88: goto -44 -> 44
    //   91: pop
    //   92: aload_3
    //   93: astore_3
    //   94: ldc 250
    //   96: invokestatic 253	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   99: pop
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 245	java/io/InputStream:close	()V
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   116: aconst_null
    //   117: astore 4
    //   119: goto -46 -> 73
    //   122: pop
    //   123: ldc 255
    //   125: invokestatic 253	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   128: pop
    //   129: goto -56 -> 73
    //   132: pop
    //   133: ldc 255
    //   135: invokestatic 253	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   138: pop
    //   139: goto -23 -> 116
    //   142: astore 4
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 245	java/io/InputStream:close	()V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 246	java/io/BufferedInputStream:close	()V
    //   160: aload 4
    //   162: athrow
    //   163: pop
    //   164: ldc 255
    //   166: invokestatic 253	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   169: pop
    //   170: goto -10 -> 160
    //   173: astore 4
    //   175: aload_3
    //   176: astore_3
    //   177: goto -33 -> 144
    //   180: pop
    //   181: goto -87 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramString	String
    //   1	148	2	localInputStream	java.io.InputStream
    //   3	174	3	localBufferedInputStream	java.io.BufferedInputStream
    //   8	110	4	localObject1	Object
    //   142	19	4	localObject2	Object
    //   173	1	4	localObject3	Object
    //   48	36	5	i	int
    //   91	1	8	localIOException1	java.io.IOException
    //   122	1	9	localIOException2	java.io.IOException
    //   132	1	10	localIOException3	java.io.IOException
    //   163	1	11	localIOException4	java.io.IOException
    //   180	1	12	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	50	91	java/io/IOException
    //   81	88	91	java/io/IOException
    //   61	73	122	java/io/IOException
    //   104	116	132	java/io/IOException
    //   10	32	142	finally
    //   94	100	142	finally
    //   148	160	163	java/io/IOException
    //   32	50	173	finally
    //   81	88	173	finally
    //   10	32	180	java/io/IOException
  }
  
  public static String getPublicIconUri(Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    try
    {
      int i = localResources.getIdentifier(paramString, "drawable", paramContext.getPackageName());
      if (i > 0)
      {
        String str = new Uri.Builder().scheme("android.resource").authority(paramContext.getPackageName()).appendPath(Integer.toString(i)).toString();
        paramString = str;
      }
    }
    catch (Throwable localThrowable)
    {
      label54:
      break label54;
    }
    return paramString;
  }
  
  public void addFeature(Feature paramFeature)
  {
    if (paramFeature != null) {
      this.mFeatures.add(paramFeature);
    }
  }
  
  public void addFeatures(List<Feature> paramList)
  {
    if (paramList != null) {
      this.mFeatures.addAll(paramList);
    }
  }
  
  public DeviceEditor edit()
  {
    return new DeviceEditor(this);
  }
  
  public int getBearerType()
  {
    return this.mBearerType;
  }
  
  public int getConfigured()
  {
    return this.mConfigured;
  }
  
  ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("product_id", this.mProductId);
    localContentValues.put("device_name", this.mProductName);
    localContentValues.put("type", Integer.valueOf(this.mType));
    localContentValues.put("bearer_type", Integer.valueOf(this.mBearerType));
    localContentValues.put("iconName", this.mIconName);
    localContentValues.put("removable", Boolean.valueOf(this.mRemovable));
    localContentValues.put("connected", Boolean.valueOf(this.mConnected));
    localContentValues.put("education_level", Integer.valueOf(this.mEducationLevel));
    localContentValues.put("notify_external", Boolean.valueOf(this.mNotifyExternal));
    localContentValues.put("user_defined_name_changed", Boolean.valueOf(this.mIsUserDefNameChanged));
    localContentValues.put("iconLargeName", this.mLargeIconName);
    localContentValues.put("timestamp", Long.valueOf(this.mTimestamp));
    localContentValues.put("device_key", this.mKeyId);
    localContentValues.put("configured", Integer.valueOf(this.mConfigured));
    localContentValues.put("device_page_activity", this.mDevicePageActivity);
    localContentValues.put("manufacturer", Integer.valueOf(this.mManufacturer));
    localContentValues.put("cookie", Long.valueOf(this.mCookie));
    return localContentValues;
  }
  
  public long getCookie()
  {
    return this.mCookie;
  }
  
  public String getDevicePageActivity()
  {
    return this.mDevicePageActivity;
  }
  
  public int getEducationLevel()
  {
    return this.mEducationLevel;
  }
  
  public Feature getFeature(int paramInt)
  {
    Iterator localIterator = getFeatureList().iterator();
    while (localIterator.hasNext())
    {
      localFeature = (Feature)localIterator.next();
      if (localFeature.getType() == paramInt) {
        return localFeature;
      }
    }
    Feature localFeature = null;
    return localFeature;
  }
  
  public List<Feature> getFeatureList()
  {
    return this.mFeatures;
  }
  
  public String getIconName()
  {
    return this.mIconName;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentProviderOperation getInsertOperation()
  {
    return ContentProviderOperation.newInsert(ExperienceDef.DeviceTable.URI).withValues(getContentValues()).build();
  }
  
  void getInsertOperation(ArrayList<ContentProviderOperation> paramArrayList)
  {
    int i = paramArrayList.size();
    paramArrayList.add(getInsertOperation());
    Iterator localIterator = this.mFeatures.iterator();
    while (localIterator.hasNext()) {
      paramArrayList.add(((Feature)localIterator.next()).getInsertOperation(i));
    }
  }
  
  public String getKeyId()
  {
    return this.mKeyId;
  }
  
  public String getLargeIconName()
  {
    return this.mLargeIconName;
  }
  
  public int getManufacturer()
  {
    return this.mManufacturer;
  }
  
  public boolean getNotifyExternal()
  {
    return this.mNotifyExternal;
  }
  
  public String getProductId()
  {
    return this.mProductId;
  }
  
  public String getProductName()
  {
    return this.mProductName;
  }
  
  public long getTimestamp()
  {
    return this.mTimestamp;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public boolean hasFeature(int paramInt)
  {
    boolean bool;
    if (getFeature(paramInt) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isConfigured()
  {
    boolean bool;
    if (this.mConfigured == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isNfc()
  {
    boolean bool;
    if (this.mBearerType != 10) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRemovable()
  {
    return this.mRemovable;
  }
  
  public boolean isRemoved()
  {
    return this.mIsRemoved;
  }
  
  public boolean isUserDefNameChanged()
  {
    return this.mIsUserDefNameChanged;
  }
  
  public void setBearer(int paramInt)
  {
    this.mBearerType = paramInt;
  }
  
  public void setConfigured(int paramInt)
  {
    this.mConfigured = paramInt;
  }
  
  public void setCookie(long paramLong)
  {
    this.mCookie = paramLong;
  }
  
  public void setEducationLevel(int paramInt)
  {
    this.mEducationLevel = paramInt;
  }
  
  public void setIcon(String paramString)
  {
    this.mIconName = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setKeyId(String paramString)
  {
    this.mKeyId = paramString;
  }
  
  public void setLargeIconName(String paramString)
  {
    this.mLargeIconName = paramString;
  }
  
  public void setManufacturer(int paramInt)
  {
    this.mManufacturer = paramInt;
  }
  
  public void setNotifyExternal(boolean paramBoolean)
  {
    this.mNotifyExternal = paramBoolean;
  }
  
  public void setProductId(String paramString)
  {
    this.mProductId = paramString;
  }
  
  public void setRemovable(boolean paramBoolean)
  {
    this.mRemovable = paramBoolean;
  }
  
  void setRemoved(boolean paramBoolean)
  {
    this.mIsRemoved = paramBoolean;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.mTimestamp = paramLong;
  }
  
  void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setUserDefinedName(String paramString)
  {
    if (!TextUtils.equals(paramString, this.mProductName)) {
      setUserDefinedNameChanged(true);
    }
    this.mProductName = paramString;
  }
  
  public void setUserDefinedNameChanged(boolean paramBoolean)
  {
    this.mIsUserDefNameChanged = paramBoolean;
  }
  
  public void showDevicePageActivity(Context paramContext)
  {
    try
    {
      Intent localIntent = getLaunchIntent(paramContext, getDevicePageActivity());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_DISPLAY_NAME", getProductName());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_IDENTIFY_NAME", getProductId());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_UNIQUE_ID", getKeyId());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_CONNECTION_TYPE", getBearerType());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_CATEGORY", getType());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_MANUFACTURER", getManufacturer());
      localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_COOKIE", getCookie());
      Object localObject = getPublicIconData(paramContext, getIconName(), false);
      if (localObject != null)
      {
        localObject = ((ByteArrayBuffer)localObject).toByteArray();
        localIntent.putExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_ICON_DATA", BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        SCGenericDevicePages.show(paramContext, this.mId);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Not able to start: " + getDevicePageActivity());
        }
        SCGenericDevicePages.show(paramContext, this.mId);
      }
    }
  }
  
  int unwrapContentProviderInsertResults(ContentProviderResult[] paramArrayOfContentProviderResult, int paramInt)
  {
    if (paramInt < paramArrayOfContentProviderResult.length)
    {
      setId(Long.parseLong(paramArrayOfContentProviderResult[paramInt].uri.getLastPathSegment()));
      paramInt++;
    }
    Iterator localIterator = this.mFeatures.iterator();
    while (localIterator.hasNext())
    {
      Feature localFeature = (Feature)localIterator.next();
      if (paramInt < paramArrayOfContentProviderResult.length)
      {
        localFeature.setId(Long.parseLong(paramArrayOfContentProviderResult[paramInt].uri.getLastPathSegment()));
        paramInt++;
      }
    }
    return paramInt;
  }
  
  public static class DeviceEditor
  {
    private List<Feature> mAddedFeatures = new ArrayList();
    private Device mDevice;
    private Integer mEditedConfigured = null;
    private Boolean mEditedConnected = null;
    private Long mEditedCookie = null;
    private String mEditedDevicePageActivity;
    private Integer mEditedEducationLevel;
    private String mEditedIcon;
    private String mEditedKeyId;
    private String mEditedLargeIcon;
    private Integer mEditedManufacturer;
    private String mEditedProductId;
    private String mEditedProductName;
    private Long mEditedTimestamp;
    private boolean mProductNameChangedBySystem = false;
    private boolean mProductNameChangedByUser = false;
    private List<Feature> mRemovedFeatures = new ArrayList();
    
    DeviceEditor(Device paramDevice)
    {
      this.mDevice = paramDevice;
    }
    
    public DeviceEditor addFeature(Feature paramFeature)
    {
      this.mAddedFeatures.add(paramFeature);
      return this;
    }
    
    Boolean editedConnected()
    {
      return this.mEditedConnected;
    }
    
    Integer editedEducationLevel()
    {
      return this.mEditedEducationLevel;
    }
    
    Long editedTimestamp()
    {
      return this.mEditedTimestamp;
    }
    
    List<Feature> getAddedFeatures()
    {
      return this.mAddedFeatures;
    }
    
    int getConfigured()
    {
      int i;
      if (this.mEditedConfigured == null) {
        i = this.mDevice.getConfigured();
      } else {
        i = this.mEditedConfigured.intValue();
      }
      return i;
    }
    
    public long getCookie()
    {
      return this.mEditedCookie.longValue();
    }
    
    public Device getDevice()
    {
      return this.mDevice;
    }
    
    String getDevicePageActivity()
    {
      String str;
      if (this.mEditedDevicePageActivity == null) {
        str = this.mDevice.getDevicePageActivity();
      } else {
        str = this.mEditedDevicePageActivity;
      }
      return str;
    }
    
    String getIconName()
    {
      String str;
      if (this.mEditedIcon == null) {
        str = this.mDevice.getIconName();
      } else {
        str = this.mEditedIcon;
      }
      return str;
    }
    
    long getId()
    {
      return this.mDevice.getId();
    }
    
    String getKeyId()
    {
      String str;
      if (this.mEditedKeyId == null) {
        str = this.mDevice.getKeyId();
      } else {
        str = this.mEditedKeyId;
      }
      return str;
    }
    
    String getLargeIconName()
    {
      String str;
      if (this.mEditedLargeIcon == null) {
        str = this.mDevice.getLargeIconName();
      } else {
        str = this.mEditedLargeIcon;
      }
      return str;
    }
    
    int getManufacturer()
    {
      int i;
      if (this.mEditedManufacturer == null) {
        i = this.mDevice.getManufacturer();
      } else {
        i = this.mEditedManufacturer.intValue();
      }
      return i;
    }
    
    String getProductId()
    {
      String str;
      if (this.mEditedProductId == null) {
        str = this.mDevice.getProductId();
      } else {
        str = this.mEditedProductId;
      }
      return str;
    }
    
    String getProductName()
    {
      String str;
      if (this.mEditedProductName == null) {
        str = this.mDevice.getProductName();
      } else {
        str = this.mEditedProductName;
      }
      return str;
    }
    
    List<Feature> getRemovedFeatures()
    {
      return this.mRemovedFeatures;
    }
    
    public boolean isConfiguredChanged()
    {
      boolean bool = false;
      if ((this.mEditedConfigured != null) && (this.mEditedConfigured.intValue() != this.mDevice.getConfigured())) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isCookieChanged()
    {
      boolean bool = false;
      if ((this.mEditedCookie != null) && (this.mEditedCookie.longValue() != this.mDevice.mCookie)) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isDevicePageActivityChanged()
    {
      boolean bool = false;
      if ((this.mEditedDevicePageActivity != null) && (!this.mEditedDevicePageActivity.equals(this.mDevice.getDevicePageActivity()))) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isIconNameChanged()
    {
      boolean bool = false;
      if ((this.mEditedIcon != null) && (!this.mEditedIcon.equals(this.mDevice.getIconName()))) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isKeyIdChanged()
    {
      boolean bool = false;
      if ((this.mEditedKeyId != null) && (!this.mEditedKeyId.equals(this.mDevice.getKeyId()))) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isLargeIconNameChanged()
    {
      boolean bool = false;
      if ((this.mEditedLargeIcon != null) && (!this.mEditedLargeIcon.equals(this.mDevice.getIconName()))) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isManufacturerChanged()
    {
      boolean bool = false;
      if ((this.mEditedManufacturer != null) && (this.mEditedManufacturer.intValue() != this.mDevice.getManufacturer())) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isProductIdChanged()
    {
      boolean bool = false;
      if ((this.mEditedProductId != null) && (!this.mEditedProductId.equals(this.mDevice.getProductId()))) {
        bool = true;
      }
      return bool;
    }
    
    public boolean isProductNameChanged()
    {
      return this.mProductNameChangedBySystem;
    }
    
    public boolean isUserDefNameChanged()
    {
      return this.mProductNameChangedByUser;
    }
    
    public DeviceEditor removeFeature(Feature paramFeature)
    {
      int i = 0;
      Iterator localIterator = this.mDevice.getFeatureList().iterator();
      while (localIterator.hasNext()) {
        if (((Feature)localIterator.next()).getId() == paramFeature.getId()) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.mRemovedFeatures.add(paramFeature);
        return this;
      }
      throw new IllegalArgumentException("Feature " + paramFeature + " not in device");
    }
    
    public DeviceEditor setConfigured(int paramInt)
    {
      this.mEditedConfigured = Integer.valueOf(paramInt);
      return this;
    }
    
    public DeviceEditor setConnected(boolean paramBoolean)
    {
      this.mEditedConnected = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public DeviceEditor setCookie(long paramLong)
    {
      this.mEditedCookie = Long.valueOf(paramLong);
      return this;
    }
    
    public DeviceEditor setDevicePageActivity(String paramString)
    {
      this.mEditedDevicePageActivity = paramString;
      return this;
    }
    
    public DeviceEditor setEducationLevel(int paramInt)
    {
      this.mEditedEducationLevel = Integer.valueOf(paramInt);
      return this;
    }
    
    public DeviceEditor setIconName(String paramString)
    {
      this.mEditedIcon = paramString;
      return this;
    }
    
    void setIdOnAddedFeatures(List<Integer> paramList)
    {
      int i;
      if ((paramList != null) && (this.mAddedFeatures != null) && (paramList.size() == this.mAddedFeatures.size())) {
        i = 0;
      }
      while (i < paramList.size())
      {
        ((Feature)this.mAddedFeatures.get(i)).setId(((Integer)paramList.get(i)).intValue());
        i++;
        continue;
        Dbg.e("setIdOnAddedFeatures failed!");
      }
    }
    
    public DeviceEditor setKeyId(String paramString)
    {
      this.mEditedKeyId = paramString;
      return this;
    }
    
    public DeviceEditor setLargeIconName(String paramString)
    {
      this.mEditedLargeIcon = paramString;
      return this;
    }
    
    public DeviceEditor setManufacturer(int paramInt)
    {
      this.mEditedManufacturer = Integer.valueOf(paramInt);
      return this;
    }
    
    public DeviceEditor setProductId(String paramString)
    {
      this.mEditedProductId = paramString;
      return this;
    }
    
    public DeviceEditor setProductNameBySystem(String paramString)
    {
      this.mEditedProductName = paramString;
      this.mProductNameChangedByUser = false;
      this.mProductNameChangedBySystem = true;
      return this;
    }
    
    public DeviceEditor setProductNameByUser(String paramString)
    {
      this.mEditedProductName = paramString;
      this.mProductNameChangedByUser = true;
      this.mProductNameChangedBySystem = false;
      return this;
    }
    
    public DeviceEditor setTimestamp(long paramLong)
    {
      this.mEditedTimestamp = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Device
 * JD-Core Version:    0.7.0.1
 */
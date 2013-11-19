package com.sonymobile.smartconnect.internal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Device.DeviceEditor;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SmartConnectDeviceService
  extends IntentService
{
  public static final String PLAY_ANYWHERE_PACKAGE_NAME = "com.sonymobile.playanywhere";
  
  public SmartConnectDeviceService()
  {
    super(SmartConnectDeviceService.class.getName());
  }
  
  private static Device addNewDevice(Context paramContext, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    Dbg.d("SmartConnectDeviceService.onHandleIntent addNewDevice");
    Object localObject1 = ExperienceManager.getInstance(paramContext);
    Device localDevice1 = ((ExperienceManager)localObject1).getDeviceByKeyId(paramString3);
    Device localDevice2;
    if (localDevice1 == null)
    {
      String str1 = null;
      if (paramArrayOfByte != null) {
        str1 = createIconFromByteArray(paramContext, paramString1, paramArrayOfByte);
      }
      Object localObject2 = lookupDevice(paramContext, paramInt1, paramInt2, paramInt3, paramString1);
      if (localObject2 != null)
      {
        String str2;
        if (str1 != null) {
          str2 = str1;
        } else {
          str2 = ((Device)localObject2).getIconName();
        }
        boolean bool1 = ((Device)localObject2).isConnected();
        boolean bool2 = ((Device)localObject2).isRemovable();
        boolean bool3 = ((Device)localObject2).getNotifyExternal();
        localObject2 = ((Device)localObject2).getDevicePageActivity();
        localDevice2 = new Device(paramString1, paramString2, str2, paramInt1, paramInt2, bool1, bool2, bool3, str1, 0L, paramString3, paramInt4, (String)localObject2, paramInt3, paramLong);
      }
      else
      {
        localDevice2 = new Device(paramString1, paramString2, str1, paramInt1, paramInt2, true, true, false, str1, 0L, paramString3, paramInt4, null, paramInt3, paramLong);
      }
      if (localDevice2 != null)
      {
        localDevice2 = ((ExperienceManager)localObject1).addDevice(localDevice2);
        SmartConnectAnalytics.trackDeviceFirstConnect(paramContext, localDevice2);
      }
      localObject1 = localDevice2;
    }
    else
    {
      ((ExperienceManager)localObject1).updateDevice(localDevice2.edit().setConfigured(paramInt4));
      localObject1 = ((ExperienceManager)localObject1).getDeviceById(localDevice2.getId());
    }
    return localObject1;
  }
  
  private static String createIconFromByteArray(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    Dbg.d("SmartConnectDeviceService.createIconFromUri");
    try
    {
      String str = (paramString + ".png").replace(" ", "_").replace('/', '_');
      localObject = paramContext.openFileOutput(str, 0);
      ((FileOutputStream)localObject).write(paramArrayOfByte);
      ((FileOutputStream)localObject).close();
      localObject = Uri.fromFile(new File(paramContext.getFilesDir() + "/" + str));
      localObject = localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject = null;
      }
    }
    if (localObject != null)
    {
      localObject = ((Uri)localObject).toString();
      return localObject;
    }
  }
  
  public static Device handleDeviceConfigured(Context paramContext, Intent paramIntent)
  {
    Device localDevice = null;
    Object localObject3 = paramIntent.getStringExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_IDENTIFY_NAME");
    Object localObject2 = paramIntent.getStringExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_DISPLAY_NAME");
    String str = paramIntent.getStringExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_SEARCH_ORIGIN");
    if (localObject2 == null) {
      localObject2 = localObject3;
    }
    if (localObject3 == null) {
      localObject3 = localObject2;
    }
    Object localObject1 = paramIntent.getStringExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_UNIQUE_ID");
    Object localObject4 = paramIntent.getParcelableExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_ICON_DATA");
    byte[] arrayOfByte = (byte[])null;
    if ((localObject4 instanceof Bitmap))
    {
      Bitmap localBitmap = (Bitmap)localObject4;
      localObject4 = new ByteArrayOutputStream();
      if (localBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4)) {
        arrayOfByte = ((ByteArrayOutputStream)localObject4).toByteArray();
      }
    }
    int i = paramIntent.getIntExtra("com.sonymobile.smartconnect.EXTRA_CONNECTION_TYPE", 0);
    long l = paramIntent.getLongExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_COOKIE", 0L);
    int k = paramIntent.getIntExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_CATEGORY", 10);
    int j = paramIntent.getIntExtra("com.sonymobile.smartconnect.EXTRA_DEVICE_MANUFACTURER", 2);
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(paramContext);
    if ((localObject3 != null) && (localObject1 != null)) {
      switch (i)
      {
      default: 
        Dbg.e("handleDeviceConfigured for connectionType: " + i);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 5: 
        localDevice = addNewDevice(paramContext, (String)localObject3, (String)localObject2, (String)localObject1, arrayOfByte, i, k, j, 2, l);
        break;
      case 4: 
        localDevice = localExperienceManager.getDeviceByKeyId((String)localObject1);
        if (localDevice != null)
        {
          localExperienceManager.updateDevice(localDevice.edit().setCookie(l));
          localDevice = localExperienceManager.getDeviceByKeyId((String)localObject1);
        }
        break;
      }
    }
    if (!"com.sonymobile.playanywhere".equals(str))
    {
      if ((localDevice != null) && (!TextUtils.isEmpty(localDevice.getDevicePageActivity())))
      {
        localObject1 = localExperienceManager.getExperiencesByDeviceId(localDevice.getId());
        if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {}
      }
      else
      {
        localDevice = null;
      }
    }
    else {
      localDevice = null;
    }
    return localDevice;
  }
  
  /* Error */
  private static Device lookupDevice(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: iload 6
    //   11: iconst_4
    //   12: if_icmplt +10 -> 22
    //   15: aload 7
    //   17: astore 7
    //   19: aload 7
    //   21: areturn
    //   22: iload 6
    //   24: tableswitch	default:+32 -> 56, 0:+46->70, 1:+160->184, 2:+198->222, 3:+236->260
    //   57: iconst_4
    //   58: astore 7
    //   60: iinc 6 1
    //   63: aload 7
    //   65: astore 7
    //   67: goto -58 -> 9
    //   70: ldc_w 268
    //   73: astore 9
    //   75: iconst_4
    //   76: anewarray 110	java/lang/String
    //   79: astore 8
    //   81: aload 8
    //   83: iconst_0
    //   84: iconst_0
    //   85: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   88: aastore
    //   89: aload 8
    //   91: iconst_1
    //   92: iload_2
    //   93: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aload 8
    //   99: iconst_2
    //   100: iload_1
    //   101: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   104: aastore
    //   105: aload 8
    //   107: iconst_3
    //   108: iload_3
    //   109: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   112: aastore
    //   113: new 275	com/sonyericsson/extras/liveware/db/ExperienceDatabaseHelper
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 278	com/sonyericsson/extras/liveware/db/ExperienceDatabaseHelper:<init>	(Landroid/content/Context;)V
    //   121: astore 5
    //   123: aload 5
    //   125: invokevirtual 282	com/sonyericsson/extras/liveware/db/ExperienceDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   128: ldc_w 284
    //   131: aconst_null
    //   132: aload 9
    //   134: aload 8
    //   136: aconst_null
    //   137: aconst_null
    //   138: ldc_w 286
    //   141: invokevirtual 292	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +17 -> 165
    //   151: aload 5
    //   153: invokeinterface 297 1 0
    //   158: istore 8
    //   160: iload 8
    //   162: ifne +582 -> 744
    //   165: aload 5
    //   167: ifnull +673 -> 840
    //   170: aload 5
    //   172: invokeinterface 298 1 0
    //   177: aload 7
    //   179: astore 7
    //   181: goto -121 -> 60
    //   184: ldc_w 300
    //   187: astore 9
    //   189: iconst_3
    //   190: anewarray 110	java/lang/String
    //   193: astore 8
    //   195: aload 8
    //   197: iconst_0
    //   198: iconst_0
    //   199: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   202: aastore
    //   203: aload 8
    //   205: iconst_1
    //   206: iload_2
    //   207: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   210: aastore
    //   211: aload 8
    //   213: iconst_2
    //   214: iload_1
    //   215: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   218: aastore
    //   219: goto -106 -> 113
    //   222: ldc_w 302
    //   225: astore 9
    //   227: iconst_3
    //   228: anewarray 110	java/lang/String
    //   231: astore 8
    //   233: aload 8
    //   235: iconst_0
    //   236: iconst_0
    //   237: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   240: aastore
    //   241: aload 8
    //   243: iconst_1
    //   244: iload_2
    //   245: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   248: aastore
    //   249: aload 8
    //   251: iconst_2
    //   252: iload_3
    //   253: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   256: aastore
    //   257: goto -144 -> 113
    //   260: ldc_w 304
    //   263: astore 9
    //   265: iconst_2
    //   266: anewarray 110	java/lang/String
    //   269: astore 8
    //   271: aload 8
    //   273: iconst_0
    //   274: iconst_0
    //   275: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   278: aastore
    //   279: aload 8
    //   281: iconst_1
    //   282: iload_2
    //   283: invokestatic 273	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   286: aastore
    //   287: goto -174 -> 113
    //   290: aload 5
    //   292: ldc_w 306
    //   295: invokeinterface 310 2 0
    //   300: istore 8
    //   302: aload 5
    //   304: iload 8
    //   306: invokeinterface 313 2 0
    //   311: astore 8
    //   313: aload 5
    //   315: ldc_w 315
    //   318: invokeinterface 310 2 0
    //   323: istore 9
    //   325: aload 5
    //   327: iload 9
    //   329: invokeinterface 313 2 0
    //   334: astore 9
    //   336: aload 5
    //   338: ldc_w 317
    //   341: invokeinterface 310 2 0
    //   346: istore 10
    //   348: aload 5
    //   350: iload 10
    //   352: invokeinterface 313 2 0
    //   357: astore 10
    //   359: aload 5
    //   361: ldc_w 319
    //   364: invokeinterface 310 2 0
    //   369: istore 11
    //   371: aload 5
    //   373: iload 11
    //   375: invokeinterface 323 2 0
    //   380: istore 11
    //   382: aload 5
    //   384: ldc_w 325
    //   387: invokeinterface 310 2 0
    //   392: istore 12
    //   394: aload 5
    //   396: iload 12
    //   398: invokeinterface 323 2 0
    //   403: istore 12
    //   405: aload 5
    //   407: ldc_w 327
    //   410: invokeinterface 310 2 0
    //   415: istore 13
    //   417: aload 5
    //   419: iload 13
    //   421: invokeinterface 323 2 0
    //   426: iconst_1
    //   427: if_icmpne +295 -> 722
    //   430: iconst_1
    //   431: istore 13
    //   433: aload 5
    //   435: ldc_w 329
    //   438: invokeinterface 310 2 0
    //   443: istore 14
    //   445: aload 5
    //   447: iload 14
    //   449: invokeinterface 323 2 0
    //   454: iconst_1
    //   455: if_icmpne +273 -> 728
    //   458: iconst_1
    //   459: istore 14
    //   461: aload 5
    //   463: ldc_w 331
    //   466: invokeinterface 310 2 0
    //   471: istore 15
    //   473: aload 5
    //   475: iload 15
    //   477: invokeinterface 323 2 0
    //   482: iconst_1
    //   483: if_icmpne +251 -> 734
    //   486: iconst_1
    //   487: istore 15
    //   489: aload 5
    //   491: ldc_w 333
    //   494: invokeinterface 310 2 0
    //   499: istore 16
    //   501: aload 5
    //   503: iload 16
    //   505: invokeinterface 313 2 0
    //   510: astore 16
    //   512: aload 5
    //   514: ldc_w 335
    //   517: invokeinterface 310 2 0
    //   522: istore 17
    //   524: aload 5
    //   526: iload 17
    //   528: invokeinterface 339 2 0
    //   533: lstore 17
    //   535: aload 5
    //   537: ldc_w 341
    //   540: invokeinterface 310 2 0
    //   545: istore 19
    //   547: aload 5
    //   549: iload 19
    //   551: invokeinterface 313 2 0
    //   556: astore 19
    //   558: aload 5
    //   560: ldc_w 343
    //   563: invokeinterface 310 2 0
    //   568: istore 20
    //   570: aload 5
    //   572: iload 20
    //   574: invokeinterface 323 2 0
    //   579: istore 20
    //   581: aload 5
    //   583: ldc_w 345
    //   586: invokeinterface 310 2 0
    //   591: istore 21
    //   593: aload 5
    //   595: iload 21
    //   597: invokeinterface 313 2 0
    //   602: astore 21
    //   604: aload 5
    //   606: ldc_w 347
    //   609: invokeinterface 310 2 0
    //   614: istore 22
    //   616: aload 5
    //   618: iload 22
    //   620: invokeinterface 323 2 0
    //   625: istore 22
    //   627: aload 5
    //   629: ldc_w 349
    //   632: invokeinterface 310 2 0
    //   637: istore 23
    //   639: new 49	com/sonyericsson/extras/liveware/experience/Device
    //   642: dup
    //   643: aload 8
    //   645: aload 9
    //   647: aload 10
    //   649: iload 11
    //   651: iload 12
    //   653: iload 13
    //   655: iload 14
    //   657: iload 15
    //   659: aload 16
    //   661: lload 17
    //   663: aload 19
    //   665: iload 20
    //   667: aload 21
    //   669: iload 22
    //   671: aload 5
    //   673: iload 23
    //   675: invokeinterface 339 2 0
    //   680: invokespecial 70	com/sonyericsson/extras/liveware/experience/Device:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZZLjava/lang/String;JLjava/lang/String;ILjava/lang/String;IJ)V
    //   683: astore 7
    //   685: aload 7
    //   687: invokevirtual 352	com/sonyericsson/extras/liveware/experience/Device:getProductId	()Ljava/lang/String;
    //   690: aload 4
    //   692: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   695: istore 8
    //   697: iload 8
    //   699: ifeq +41 -> 740
    //   702: aload 7
    //   704: ifnull +111 -> 815
    //   707: aload 5
    //   709: ifnull -690 -> 19
    //   712: aload 5
    //   714: invokeinterface 298 1 0
    //   719: goto -700 -> 19
    //   722: iconst_0
    //   723: istore 13
    //   725: goto -292 -> 433
    //   728: iconst_0
    //   729: istore 14
    //   731: goto -270 -> 461
    //   734: iconst_0
    //   735: istore 15
    //   737: goto -248 -> 489
    //   740: aload 7
    //   742: astore 7
    //   744: aload 5
    //   746: invokeinterface 355 1 0
    //   751: istore 8
    //   753: iload 8
    //   755: ifne -465 -> 290
    //   758: aload 7
    //   760: astore 7
    //   762: goto -60 -> 702
    //   765: astore 8
    //   767: aload 7
    //   769: astore 7
    //   771: ldc_w 357
    //   774: aload 8
    //   776: invokestatic 360	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   779: pop
    //   780: aload 5
    //   782: ifnull -722 -> 60
    //   785: aload 5
    //   787: invokeinterface 298 1 0
    //   792: goto -732 -> 60
    //   795: astore 6
    //   797: aload 7
    //   799: pop
    //   800: aload 5
    //   802: ifnull +10 -> 812
    //   805: aload 5
    //   807: invokeinterface 298 1 0
    //   812: aload 6
    //   814: athrow
    //   815: aload 5
    //   817: ifnull -757 -> 60
    //   820: aload 5
    //   822: invokeinterface 298 1 0
    //   827: goto -767 -> 60
    //   830: astore 6
    //   832: goto -32 -> 800
    //   835: astore 8
    //   837: goto -66 -> 771
    //   840: aload 7
    //   842: astore 7
    //   844: goto -784 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	paramContext	Context
    //   0	847	1	paramInt1	int
    //   0	847	2	paramInt2	int
    //   0	847	3	paramInt3	int
    //   0	847	4	paramString	String
    //   1	820	5	localObject1	Object
    //   4	57	6	i	int
    //   795	18	6	localObject2	Object
    //   830	1	6	localObject3	Object
    //   7	836	7	localObject4	Object
    //   79	56	8	arrayOfString1	String[]
    //   158	3	8	j	int
    //   193	87	8	arrayOfString2	String[]
    //   300	5	8	k	int
    //   311	333	8	str1	String
    //   695	59	8	bool	boolean
    //   765	10	8	localSQLException1	android.database.SQLException
    //   835	1	8	localSQLException2	android.database.SQLException
    //   73	191	9	str2	String
    //   323	5	9	m	int
    //   334	312	9	str3	String
    //   346	5	10	n	int
    //   357	291	10	str4	String
    //   369	281	11	i1	int
    //   392	260	12	i2	int
    //   415	239	13	i3	int
    //   723	1	13	i4	int
    //   443	213	14	i5	int
    //   729	1	14	i6	int
    //   471	187	15	i7	int
    //   735	1	15	i8	int
    //   499	5	16	i9	int
    //   510	150	16	str5	String
    //   522	5	17	i10	int
    //   533	129	17	l	long
    //   545	5	19	i11	int
    //   556	108	19	str6	String
    //   568	98	20	i12	int
    //   591	5	21	i13	int
    //   602	66	21	str7	String
    //   614	56	22	i14	int
    //   637	37	23	i15	int
    // Exception table:
    //   from	to	target	type
    //   113	160	765	android/database/SQLException
    //   290	685	765	android/database/SQLException
    //   744	753	765	android/database/SQLException
    //   113	160	795	finally
    //   290	685	795	finally
    //   744	753	795	finally
    //   685	697	830	finally
    //   771	780	830	finally
    //   685	697	835	android/database/SQLException
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Dbg.d("SmartConnectDeviceService.onHandleIntent " + paramIntent);
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getAction();
      Dbg.d("SmartConnectDeviceService.onHandleIntent " + (String)localObject);
      if ((localObject != null) && (((String)localObject).equals("com.sonymobile.smartconnect.DEVICE_CONFIGURED")))
      {
        localObject = handleDeviceConfigured(this, paramIntent);
        if (localObject != null) {
          ((Device)localObject).showDevicePageActivity(this);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.smartconnect.internal.SmartConnectDeviceService
 * JD-Core Version:    0.7.0.1
 */
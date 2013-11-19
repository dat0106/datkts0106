package com.sonyericsson.extras.liveware.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.ui.CustomDialog;
import com.sonyericsson.extras.liveware.ui.HomeScreenActivity;
import com.sonyericsson.extras.liveware.ui.InstallActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UIUtils
{
  private static final String CURRENT_NOTIFICATION = "current_notification";
  private static final String DEFAULT_PICTURE = "event_picture_default";
  
  public static void applyDirectionality(View paramView)
  {
    UIUtilsJellyBeanMR1.setTextDirection(paramView);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      BidiUtils.setDirectionality(localViewGroup, 1);
      for (int i = 0; i < localViewGroup.getChildCount(); i++) {
        applyDirectionality(localViewGroup.getChildAt(i));
      }
    }
  }
  
  public static void applyDirectionalityToDecorWindow(Activity paramActivity)
  {
    applyDirectionality(paramActivity.getWindow().getDecorView());
  }
  
  public static boolean attachUI(Context paramContext, Device paramDevice, int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if (paramDevice.getFeature(paramInt).getAppSelection() != 0)
    {
      Intent localIntent = new Intent(paramContext.getApplicationContext(), InstallActivity.class);
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.smartdevice", paramDevice.getId());
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.feature_type", paramInt);
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.sendsstatus", paramBoolean);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public static Dialog createCommonDialog(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable)
  {
    CustomDialog localCustomDialog = new CustomDialog(paramContext);
    localCustomDialog.setTitle(paramString1);
    localCustomDialog.setBody(paramString2);
    localCustomDialog.setNeutralButton(paramContext.getString(2131099767), paramRunnable);
    localCustomDialog.setCancelAction(paramRunnable);
    return localCustomDialog.get();
  }
  
  public static Bitmap getBitmapWithGradient(Context paramContext, String paramString)
  {
    return getBitmapWithGradient(paramContext, paramString, false);
  }
  
  public static Bitmap getBitmapWithGradient(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramContext.getResources();
    int i = 0;
    int k = 0;
    if (paramString != null)
    {
      if (!Experience.isExternalStorageEventPicture(paramString)) {
        break label194;
      }
      k = 1;
    }
    for (;;)
    {
      if ((i == 0) && (k == 0)) {
        i = ((Resources)localObject1).getIdentifier("event_picture_default", "drawable", paramContext.getPackageName());
      }
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inMutable = true;
      ((BitmapFactory.Options)localObject2).inScaled = false;
      ((BitmapFactory.Options)localObject2).inDensity = 160;
      ((BitmapFactory.Options)localObject2).inTargetDensity = 160;
      if (k != 0) {}
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeFile(Experience.getEventPictureFileName(paramString), (BitmapFactory.Options)localObject2);
        label100:
        if (localBitmap1 == null) {
          localBitmap1 = BitmapFactory.decodeResource((Resources)localObject1, ((Resources)localObject1).getIdentifier("event_picture_default", "drawable", paramContext.getPackageName()), (BitmapFactory.Options)localObject2);
        }
        if (paramBoolean) {}
        for (localObject2 = BitmapFactory.decodeResource((Resources)localObject1, 2130837569, (BitmapFactory.Options)localObject2);; localObject2 = localObject1)
        {
          localObject1 = new Canvas((Bitmap)localObject2);
          Paint localPaint = new Paint(2);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
          ((Canvas)localObject1).drawBitmap(localBitmap1, null, ((Canvas)localObject1).getClipBounds(), localPaint);
          return localObject2;
          label194:
          int j = ((Resources)localObject1).getIdentifier(paramString, "drawable", paramContext.getPackageName());
          break;
          Bitmap localBitmap2 = BitmapFactory.decodeResource((Resources)localObject1, j, (BitmapFactory.Options)localObject2);
          break label100;
          localObject1 = BitmapFactory.decodeResource((Resources)localObject1, 2130837592, (BitmapFactory.Options)localObject2);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Dbg.e("No room for bitmaps. Try to continue.");
          localObject2 = null;
        }
      }
    }
  }
  
  private static int getCurrentShowedNotificationId(Context paramContext)
  {
    return paramContext.getSharedPreferences("current_notification", 0).getInt("current_notification", 0);
  }
  
  public static Drawable getDialogIcon(Context paramContext, Device paramDevice, boolean paramBoolean)
  {
    Object localObject = paramContext.getResources();
    int i = 0;
    int j;
    if (paramBoolean)
    {
      String str = paramDevice.getLargeIconName();
      if (TextUtils.isEmpty(str)) {
        str = paramDevice.getIconName();
      }
      j = ((Resources)localObject).getIdentifier(str, "drawable", "com.sonyericsson.extras.liveware");
    }
    if (j == 0) {
      j = ((Resources)localObject).getIdentifier(paramDevice.getIconName(), "drawable", "com.sonyericsson.extras.liveware");
    }
    if (j <= 0) {
      localObject = getIcon(paramContext, paramDevice, false);
    } else {
      localObject = ((Resources)localObject).getDrawable(j);
    }
    return localObject;
  }
  
  public static int getDimAlpha(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842803, localTypedValue, true);
    return (int)(255.0F * localTypedValue.getFloat());
  }
  
  public static Drawable getDisabledDrawable(Context paramContext, String paramString)
  {
    Drawable localDrawable = getDrawable(paramContext, paramString).mutate();
    localDrawable.setAlpha(getDimAlpha(paramContext));
    return localDrawable;
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString)
  {
    Dbg.d("getDrawable(): " + paramString);
    Object localObject1 = getDrawableFromResourceName(paramContext, paramString);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = paramContext.getResources();
      if (paramString != null)
      {
        localObject2 = getDrawableFromUri(paramContext, paramString);
        if (localObject2 == null)
        {
          localObject2 = getDrawableFromLocalFile(paramContext, paramString);
          if (localObject2 == null) {
            localObject2 = ((Resources)localObject1).getDrawable(2130837672);
          }
        }
      }
      else
      {
        localObject2 = ((Resources)localObject1).getDrawable(2130837672);
      }
    }
    else
    {
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString, boolean paramBoolean)
  {
    Drawable localDrawable;
    if (!paramBoolean) {
      localDrawable = getDisabledDrawable(paramContext, paramString);
    } else {
      localDrawable = getDrawable(paramContext, paramString);
    }
    return localDrawable;
  }
  
  private static Drawable getDrawableFromLocalFile(Context paramContext, String paramString)
  {
    Object localObject = BitmapFactory.decodeFile(paramContext.getFilesDir().getAbsolutePath() + "/" + paramString);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = getIconSizeDrawable(paramContext, (Bitmap)localObject);
    }
    return localObject;
  }
  
  private static Drawable getDrawableFromResourceName(Context paramContext, String paramString)
  {
    Drawable localDrawable = null;
    Object localObject = paramContext.getPackageManager();
    if (paramString == null) {}
    for (;;)
    {
      return localDrawable;
      String str = null;
      if (paramString.indexOf(":") > 1) {
        str = paramString.substring(0, paramString.indexOf(":"));
      }
      if (TextUtils.isEmpty(str)) {
        str = paramContext.getPackageName();
      }
      try
      {
        localObject = ((PackageManager)localObject).getResourcesForApplication(str);
        int i = ((Resources)localObject).getIdentifier(paramString, "drawable", str);
        if (i > 0)
        {
          localDrawable = ((Resources)localObject).getDrawable(i);
          localDrawable = localDrawable;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  /* Error */
  private static Drawable getDrawableFromUri(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 395	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: aload_1
    //   10: invokestatic 401	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: invokevirtual 407	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 411	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +14 -> 37
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 416	java/io/InputStream:close	()V
    //   34: aload 4
    //   36: areturn
    //   37: aload_0
    //   38: aload_3
    //   39: invokestatic 365	com/sonyericsson/extras/liveware/utils/UIUtils:getIconSizeDrawable	(Landroid/content/Context;Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;
    //   42: astore_3
    //   43: aload_3
    //   44: astore 4
    //   46: aload_2
    //   47: ifnull -13 -> 34
    //   50: aload_2
    //   51: invokevirtual 416	java/io/InputStream:close	()V
    //   54: goto -20 -> 34
    //   57: pop
    //   58: goto -24 -> 34
    //   61: pop
    //   62: aload_2
    //   63: ifnull -29 -> 34
    //   66: aload_2
    //   67: invokevirtual 416	java/io/InputStream:close	()V
    //   70: goto -36 -> 34
    //   73: pop
    //   74: goto -40 -> 34
    //   77: astore_3
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 416	java/io/InputStream:close	()V
    //   86: aload_3
    //   87: athrow
    //   88: pop
    //   89: goto -55 -> 34
    //   92: pop
    //   93: goto -7 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramString	String
    //   4	79	2	localInputStream	java.io.InputStream
    //   21	23	3	localObject1	Object
    //   77	10	3	localObject2	Object
    //   1	44	4	localObject3	Object
    //   57	1	6	localIOException1	IOException
    //   61	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   73	1	8	localIOException2	IOException
    //   88	1	9	localIOException3	IOException
    //   92	1	10	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   50	54	57	java/io/IOException
    //   5	22	61	java/io/FileNotFoundException
    //   37	43	61	java/io/FileNotFoundException
    //   66	70	73	java/io/IOException
    //   5	22	77	finally
    //   37	43	77	finally
    //   30	34	88	java/io/IOException
    //   82	86	92	java/io/IOException
  }
  
  public static Drawable getIcon(Context paramContext, Device paramDevice, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (paramBoolean) {
      i = localResources.getIdentifier(paramDevice.getLargeIconName(), "drawable", "com.sonyericsson.extras.liveware");
    }
    if (i == 0) {
      i = localResources.getIdentifier(paramDevice.getIconName(), "drawable", "com.sonyericsson.extras.liveware");
    }
    Drawable localDrawable2;
    if (i <= 0)
    {
      Drawable localDrawable1 = BitmapDrawable.createFromPath(paramContext.getFilesDir().getAbsolutePath() + "/" + paramDevice.getIconName());
      if (localDrawable1 == null)
      {
        int j;
        if (!paramBoolean) {
          j = 2130837672;
        } else {
          j = 2130837511;
        }
        localDrawable2 = localResources.getDrawable(j);
      }
    }
    else
    {
      localDrawable2 = localResources.getDrawable(localDrawable2);
    }
    return localDrawable2;
  }
  
  public static Drawable getIconSizeDrawable(Context paramContext, Bitmap paramBitmap)
  {
    BitmapDrawable localBitmapDrawable;
    if (paramBitmap != null)
    {
      int j = paramContext.getResources().getDimensionPixelSize(2131492867);
      if ((paramBitmap.getWidth() != j) || (paramBitmap.getHeight() != j))
      {
        float f = paramBitmap.getWidth() / paramBitmap.getHeight();
        int i;
        if (f < 1.0F) {
          i = (int)(f * j);
        } else {
          i = j;
        }
        int k;
        if (f > 1.0F) {
          k = (int)(j / f);
        } else {
          k = j;
        }
        Bitmap localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, i, k, true);
        if (f < 1.0F)
        {
          Bitmap localBitmap1 = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
          new Canvas(localBitmap1).drawBitmap(localBitmap2, (j - i) / 2.0F, 0.0F, new Paint());
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap1);
        }
        else
        {
          localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap2);
        }
      }
      else
      {
        localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      }
    }
    else
    {
      localBitmapDrawable = null;
    }
    return localBitmapDrawable;
  }
  
  public static boolean isVanillaRtl(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131427332);
  }
  
  public static void removeExperienceNotification(Context paramContext, Experience paramExperience)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel("experience_notification", (int)paramExperience.getId());
  }
  
  public static void saveIcon(Context paramContext, String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString, 0);
    localFileOutputStream.write(paramArrayOfByte);
    localFileOutputStream.close();
  }
  
  private static void setCurrentShowedNotificationId(Context paramContext, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("current_notification", 0).edit();
    localEditor.putInt("current_notification", paramInt);
    localEditor.commit();
  }
  
  public static void setViewEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      for (int i = 0; i < j; i++) {
        setViewEnabled(localViewGroup.getChildAt(i), paramBoolean);
      }
    }
  }
  
  public static void showDialogFragment(FragmentManager paramFragmentManager, DialogFragment paramDialogFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = paramFragmentManager.beginTransaction();
    if (paramFragmentManager.findFragmentByTag(paramString) == null)
    {
      localFragmentTransaction.addToBackStack(null);
      paramDialogFragment.show(localFragmentTransaction, paramString);
    }
  }
  
  public static void showExperienceNotification(Context paramContext, Experience paramExperience, boolean paramBoolean)
  {
    if (PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramContext.getString(2131099732), true))
    {
      Object localObject1 = HomeScreenActivity.getShowExperienceIntent(paramContext, paramExperience.getId());
      ((Intent)localObject1).setAction(HomeScreenActivity.class.getName() + System.currentTimeMillis());
      Object localObject2 = PendingIntent.getActivity(paramContext, (int)System.currentTimeMillis(), (Intent)localObject1, 0);
      localObject1 = (NotificationManager)paramContext.getSystemService("notification");
      int i = getCurrentShowedNotificationId(paramContext);
      if (i > 0) {
        ((NotificationManager)localObject1).cancel("experience_notification", i);
      }
      Object localObject4;
      Object localObject3;
      String str;
      Object localObject5;
      if (!paramBoolean)
      {
        localObject4 = paramContext.getString(2131099846);
        localObject3 = new Object[1];
        localObject3[0] = paramExperience.getName();
        localObject3 = String.format((String)localObject4, (Object[])localObject3);
        int k = paramExperience.getNumberOfAvailableStopActions();
        if (k == 0) {
          return;
        }
        str = paramContext.getString(2131099844);
        localObject4 = new Object[1];
        localObject4[0] = Integer.valueOf(k);
        localObject5 = String.format(str, (Object[])localObject4);
      }
      else
      {
        localObject4 = paramContext.getString(2131099845);
        localObject3 = new Object[1];
        localObject3[0] = paramExperience.getName();
        localObject3 = String.format((String)localObject4, (Object[])localObject3);
        int j = paramExperience.getNumberOfAvailableStartActions();
        str = paramContext.getString(2131099843);
        localObject5 = new Object[1];
        localObject5[0] = Integer.valueOf(j);
        localObject5 = String.format(str, (Object[])localObject5);
      }
      Notification.Builder localBuilder = new Notification.Builder(paramContext);
      localBuilder.setContentIntent((PendingIntent)localObject2);
      localBuilder.setSmallIcon(2130837605);
      localBuilder.setWhen(System.currentTimeMillis());
      localBuilder.setOngoing(false);
      localBuilder.setTicker((CharSequence)localObject3);
      localBuilder.setContentTitle(paramExperience.getName());
      localBuilder.setContentText((CharSequence)localObject5);
      localObject2 = localBuilder.getNotification();
      if (Dbg.v()) {
        Dbg.e("ExperienceService: Create notification ticker=" + (String)localObject3 + " tag=" + "experience_notification" + " id=" + paramExperience.getId());
      }
      setCurrentShowedNotificationId(paramContext, (int)paramExperience.getId());
      ((NotificationManager)localObject1).notify("experience_notification", (int)paramExperience.getId(), (Notification)localObject2);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.UIUtils
 * JD-Core Version:    0.7.0.1
 */
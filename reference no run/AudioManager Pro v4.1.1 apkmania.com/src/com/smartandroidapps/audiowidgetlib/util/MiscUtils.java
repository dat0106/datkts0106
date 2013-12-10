package com.smartandroidapps.audiowidgetlib.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.AApplication;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.activities.ApplyShortcutProfile;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.data.DatabaseHelper;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.widget.VolumeLockWidget;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MiscUtils
  implements Constants
{
  private static final String PATH;
  private static Boolean _isAtLeastLargeHC = null;
  private static Boolean isNotificationAlwaysLinkedOrNotUnlinked = null;
  private static Boolean isNotificationLinkingUnlinkAvailable;
  
  static
  {
    PATH = Environment.getExternalStorageDirectory() + "/audiomanagerpro/backups/";
    isNotificationLinkingUnlinkAvailable = null;
  }
  
  public static Typeface CreateTypefaceFromRawResource(Context paramContext, int paramInt)
  {
    Object localObject2 = paramContext.getResources();
    Object localObject1 = ((Resources)localObject2).getResourceEntryName(paramInt);
    File localFile = new File(paramContext.getCacheDir(), (String)localObject1);
    try
    {
      if (!localFile.exists())
      {
        localFile.createNewFile();
        localObject1 = new FileOutputStream(localFile);
        InputStream localInputStream = ((Resources)localObject2).openRawResource(paramInt);
        localObject2 = new byte[16384];
        for (;;)
        {
          int i = localInputStream.read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
        }
        localInputStream.close();
        ((FileOutputStream)localObject1).flush();
        ((FileOutputStream)localObject1).close();
      }
      localObject1 = Typeface.createFromFile(localFile);
      localObject1 = localObject1;
    }
    catch (Exception localException)
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public static void createProfileShortcut(int paramInt, String paramString, Activity paramActivity)
  {
    Intent localIntent = getProfileCreateShortcutIntent(paramInt, paramString, paramActivity);
    localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    paramActivity.sendBroadcast(localIntent);
  }
  
  private static int getNotificationUseRingVolumeSettingInfo(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AApplication.isDoingLinkedCheck = true;
    if (isDebug()) {
      Log.d("AudioManager", "getNotificationUseRingVolumeSettingInfo start");
    }
    int i = getNotificationUseRingVolumeSettingInfoHelper(paramContentResolver, paramContext, paramBoolean1, paramBoolean2);
    if (isDebug()) {
      Log.d("AudioManager", "getNotificationUseRingVolumeSettingInfo end");
    }
    AApplication.LinkedCheckDone();
    return i;
  }
  
  private static int getNotificationUseRingVolumeSettingInfoHelper(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 11) && (!OldAPIHelper.hasSystemTelephony(paramContext.getPackageManager())))
    {
      isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
      isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(true);
      i = 3;
    }
    label100:
    label106:
    boolean bool4;
    label129:
    int n;
    label385:
    label391:
    label425:
    label467:
    int i2;
    AudioManager localAudioManager;
    int j;
    int m;
    int k;
    for (;;)
    {
      return i;
      boolean bool1 = true;
      for (boolean bool3 = true;; bool3 = false)
      {
        try
        {
          i = Settings.System.getInt(paramContentResolver, "notifications_use_ring_volume");
          if (i != 1) {
            continue;
          }
          bool3 = true;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException1)
        {
          for (;;)
          {
            bool1 = false;
          }
          i = 0;
        }
        if (Build.VERSION.SDK_INT >= 11) {
          break label106;
        }
        isNotificationLinkingUnlinkAvailable = Boolean.valueOf(true);
        if (!bool3) {
          break label100;
        }
        i = 1;
        break;
      }
      continue;
      boolean bool2 = true;
      boolean bool5 = true;
      try
      {
        i = Settings.System.getInt(paramContentResolver, "volume_link_notification");
        if (i == 1)
        {
          bool5 = true;
          bool4 = true;
          n = 1;
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException2)
      {
        try
        {
          i = Settings.System.getInt(paramContentResolver, "unlink_volumes_together");
          if (i != 1) {}
          for (n = 1;; n = 0)
          {
            if ((!bool1) && (!bool2) && (!bool4)) {
              break label385;
            }
            i = 1;
            if (i == 0) {
              break label467;
            }
            if (((!bool1) || (!bool2) || (bool3 == bool5)) && ((!bool1) || (!bool4) || (bool3 == n)) && ((!bool2) || (!bool4) || (bool5 == n))) {
              break label425;
            }
            Log.d("AudioManager", "notifications_use_ring_volume:" + bool1 + "," + bool3);
            Log.d("AudioManager", "volume_link_notification:" + bool2 + "," + bool5);
            Log.d("AudioManager", "!unlink_volumes_together:" + bool4 + "," + n);
            bool4 = false;
            lockUnlockNotificationsAndRingerVolumes(paramContentResolver, paramContext, false);
            if (!paramBoolean2) {
              break label391;
            }
            i = getNotificationUseRingVolumeSettingInfo(paramContentResolver, paramContext, paramBoolean1, false);
            break;
            bool5 = false;
            break label129;
            localSettingNotFoundException2;
            bool2 = false;
            break label129;
          }
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException3)
        {
          for (;;)
          {
            bool4 = false;
            continue;
            i = 0;
          }
          Log.w("AudioManager", "getNotificationUseRingVolumeSettingInfo: second try after set");
          for (;;)
          {
            if ((isNotificationLinkingUnlinkAvailable != null) && (isNotificationLinkingUnlinkAvailable.booleanValue()))
            {
              if (bool4)
              {
                i = 1;
                break;
                if (((bool1) && (bool3)) || ((bool2) && (bool5)) || ((bool4) && (n != 0))) {}
                for (bool4 = true;; bool4 = false) {
                  break;
                }
                Log.d("AudioManager", "notifications_use_ring_volume, volume_link_notification, unlink_volumes_together: NONE FOUND");
                bool4 = true;
                lockUnlockNotificationsAndRingerVolumes(paramContentResolver, paramContext, bool4);
                if (paramBoolean2)
                {
                  i = getNotificationUseRingVolumeSettingInfo(paramContentResolver, paramContext, paramBoolean1, false);
                  break;
                }
                Log.w("AudioManager", "getNotificationUseRingVolumeSettingInfo: second try after set");
                continue;
              }
              i = 0;
              break;
            }
          }
          i2 = 0;
          n = 0;
          localAudioManager = (AudioManager)paramContext.getSystemService("audio");
          j = localAudioManager.getStreamVolume(2);
          m = localAudioManager.getStreamVolume(5);
          k = j - 1;
          if (j < 2) {
            k = j + 2;
          }
          if (j == m) {
            break label729;
          }
        }
      }
    }
    if (!bool4)
    {
      i = 0;
      label584:
      if (i < 2)
      {
        localAudioManager.setStreamVolume(5, m, 0);
        localAudioManager.setStreamVolume(2, j, 0);
        if (i != 1) {
          break label951;
        }
        lockUnlockNotificationsAndRingerVolumes(paramContentResolver, paramContext, false);
        localAudioManager.setStreamVolume(2, k, 0);
        if (localAudioManager.getStreamVolume(2) != localAudioManager.getStreamVolume(5)) {
          break label941;
        }
        isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
        isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(true);
        i = 3;
      }
    }
    for (;;)
    {
      lockUnlockNotificationsAndRingerVolumes(paramContentResolver, paramContext, bool4);
      localAudioManager.setStreamVolume(5, m, 0);
      localAudioManager.setStreamVolume(2, j, 0);
      if (i2 == 0) {
        break;
      }
      if (paramBoolean1) {
        MainActivity.isActive = true;
      }
      localAudioManager.setRingerMode(n);
      break;
      isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
      isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(false);
      i = 2;
      break;
      label729:
      if (j == 0)
      {
        int i1 = localAudioManager.getRingerMode();
        if (i1 != 2)
        {
          if (paramBoolean1) {
            MainActivity.isActive = false;
          }
          i2 = 1;
          localAudioManager.setRingerMode(2);
          j = localAudioManager.getStreamVolume(2);
          m = localAudioManager.getStreamVolume(5);
          if ((j != m) && (bool4)) {
            break label850;
          }
          k = j - 1;
          if (j < 2) {
            k = j + 2;
          }
        }
      }
      localAudioManager.setStreamVolume(2, k, 0);
      if (localAudioManager.getStreamVolume(2) == localAudioManager.getStreamVolume(5))
      {
        if (bool4)
        {
          if (i != 0)
          {
            i = 1;
            break label584;
            label850:
            isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
            isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(false);
            i = 2;
            break;
          }
          isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
          isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(true);
          i = 3;
          break label584;
        }
        isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
        isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(true);
        i = 3;
        break label584;
      }
      if (!bool4)
      {
        i = 0;
        break label584;
      }
      isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
      isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(false);
      i = 2;
      break label584;
      label941:
      isNotificationLinkingUnlinkAvailable = Boolean.valueOf(true);
      continue;
      label951:
      lockUnlockNotificationsAndRingerVolumes(paramContentResolver, paramContext, true);
      localAudioManager.setStreamVolume(2, k, 0);
      if (localAudioManager.getStreamVolume(2) != localAudioManager.getStreamVolume(5))
      {
        isNotificationLinkingUnlinkAvailable = Boolean.valueOf(false);
        isNotificationAlwaysLinkedOrNotUnlinked = Boolean.valueOf(false);
        i = 2;
      }
      else
      {
        isNotificationLinkingUnlinkAvailable = Boolean.valueOf(true);
      }
    }
  }
  
  public static Intent getProfileCreateShortcutIntent(int paramInt, String paramString, Activity paramActivity)
  {
    Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(paramActivity, R.drawable.shortcut_icon);
    Intent localIntent1 = getProfileShortcutIntent(paramInt, paramActivity);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", localShortcutIconResource);
    paramActivity.setResult(-1, localIntent2);
    return localIntent2;
  }
  
  public static Intent getProfileShortcutIntent(int paramInt, Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ApplyShortcutProfile.class);
    localIntent.setFlags(1485111296);
    localIntent.putExtra("profileId", paramInt);
    return localIntent;
  }
  
  public static boolean isAtLeastLargeHC(Context paramContext)
  {
    if (_isAtLeastLargeHC == null) {
      _isAtLeastLargeHC = Boolean.valueOf(OldAPIHelper.isAtLeastLargeHC(paramContext));
    }
    return _isAtLeastLargeHC.booleanValue();
  }
  
  public static boolean isDebug()
  {
    return false;
  }
  
  public static boolean isNotificationAlwaysLinked(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (isNotificationLinkingUnlinkAvailable == null) {
      getNotificationUseRingVolumeSettingInfo(paramContentResolver, paramContext, paramBoolean, bool);
    }
    if ((isNotificationLinkingUnlinkAvailable.booleanValue()) || (!isNotificationAlwaysLinkedOrNotUnlinked.booleanValue())) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isNotificationAndRingerLinked(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean)
  {
    int j = 1;
    if ((isNotificationLinkingUnlinkAvailable == null) || (isNotificationLinkingUnlinkAvailable.booleanValue()))
    {
      int i = getNotificationUseRingVolumeSettingInfo(paramContentResolver, paramContext, paramBoolean, j);
      if ((i != j) && (i != 3)) {
        j = 0;
      }
    }
    else
    {
      j = isNotificationAlwaysLinkedOrNotUnlinked.booleanValue();
    }
    return j;
  }
  
  public static boolean isNotificationLinkingUnlinkAvailable(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean)
  {
    if (isNotificationLinkingUnlinkAvailable == null) {
      getNotificationUseRingVolumeSettingInfo(paramContentResolver, paramContext, paramBoolean, true);
    }
    return isNotificationLinkingUnlinkAvailable.booleanValue();
  }
  
  public static void lockUnlockNotificationsAndRingerVolumes(ContentResolver paramContentResolver, Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      localAudioManager.setStreamVolume(5, localAudioManager.getStreamVolume(2), 0);
    }
    int j;
    if (!paramBoolean) {
      j = 0;
    } else {
      j = 1;
    }
    Settings.System.putInt(paramContentResolver, "notifications_use_ring_volume", j);
    if (!paramBoolean) {
      j = 0;
    } else {
      j = 1;
    }
    Settings.System.putInt(paramContentResolver, "volume_link_notification", j);
    if (!paramBoolean) {
      i = 1;
    }
    Settings.System.putInt(paramContentResolver, "unlink_volumes_together", i);
  }
  
  public static void showBackupDialog(final Activity paramActivity)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      View localView = paramActivity.getLayoutInflater().inflate(R.layout.backup, null, false);
      EditText localEditText = (EditText)localView.findViewById(R.id.input);
      new AlertDialog.Builder(paramActivity).setTitle(R.string.backup_profiles).setView(localView).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          Object localObject1 = MiscUtils.this.getText().toString().trim().replace(" ", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new File(MiscUtils.PATH, (String)localObject1 + ".bk");
            Object localObject2 = DatabaseHelper.ExportDatabase(paramActivity, (File)localObject1);
            Object localObject3;
            Object[] arrayOfObject;
            if (localObject2 != null)
            {
              localObject3 = paramActivity;
              localObject1 = paramActivity.getString(R.string.backup_success);
              arrayOfObject = new Object[1];
              arrayOfObject[0] = ((File)localObject2).getAbsolutePath();
              Toast.makeText((Context)localObject3, String.format((String)localObject1, arrayOfObject), 0).show();
            }
            else
            {
              localObject2 = paramActivity;
              localObject3 = paramActivity.getString(R.string.backup_error);
              arrayOfObject = new Object[1];
              arrayOfObject[0] = ((File)localObject1).getAbsolutePath();
              Toast.makeText((Context)localObject2, String.format((String)localObject3, arrayOfObject), 0).show();
            }
          }
          else
          {
            Toast.makeText(paramActivity, R.string.filename_required, 0).show();
          }
        }
      }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      }).show();
    }
    else
    {
      Toast.makeText(paramActivity, R.string.sdcard_not_available, 0).show();
    }
  }
  
  private static void showOverrideDialog(File paramFile, final Context paramContext, final Activity paramActivity)
  {
    new AlertDialog.Builder(paramContext).setTitle(R.string.restore_profiles).setIcon(17301543).setMessage(R.string.profile_override_message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if (MiscUtils.this != null)
        {
          Context localContext;
          Object localObject2;
          Object localObject1;
          if (!DatabaseHelper.ImportDatabase(paramContext, MiscUtils.this))
          {
            localContext = paramContext;
            localObject2 = paramContext.getString(R.string.import_error);
            localObject1 = new Object[1];
            localObject1[0] = MiscUtils.this.getAbsolutePath();
            Toast.makeText(localContext, String.format((String)localObject2, (Object[])localObject1), 0).show();
          }
          else
          {
            localContext = paramContext;
            localObject1 = paramContext.getString(R.string.import_success);
            localObject2 = new Object[1];
            localObject2[0] = MiscUtils.this.getAbsolutePath();
            Toast.makeText(localContext, String.format((String)localObject1, (Object[])localObject2), 0).show();
          }
        }
        else
        {
          DatabaseHelper.ClearDBandReInitProfiles(paramContext);
          Toast.makeText(paramContext, paramContext.getString(R.string.defaults_restored), 0).show();
        }
        ((MainActivity)paramActivity).updateProfilesUI();
      }
    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).show();
  }
  
  public static void showOverwriteDialog(int paramInt, final boolean paramBoolean, final String paramString, final Activity paramActivity)
  {
    new AlertDialog.Builder(paramActivity).setTitle(R.string.menu_newAudioProfile).setMessage(R.string.dialog_overwrite_message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        Profile.getProfile(this.val$_id, paramActivity).setAllStreamsToCurrent();
        if (paramBoolean) {
          MiscUtils.createProfileShortcut(this.val$_id, paramString, paramActivity);
        }
        ((MainActivity)paramActivity).updateProfilesUI();
        Toast.makeText(paramActivity, R.string.profile_saved, 0).show();
      }
    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).show();
  }
  
  public static void showRestoreDialog(final Context paramContext, final Activity paramActivity)
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {
      Toast.makeText(paramContext, R.string.sdcard_not_available, 0).show();
    }
    File[] arrayOfFile = new File(PATH).listFiles();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext.getString(R.string.restore_defaults));
    if (arrayOfFile != null) {}
    ArrayAdapter localArrayAdapter;
    for (int i = 0;; localArrayAdapter++)
    {
      if (i >= arrayOfFile.length)
      {
        localArrayAdapter = new ArrayAdapter(paramContext, R.layout.simple_list_item_1, localArrayList);
        new AlertDialog.Builder(paramContext).setTitle(R.string.restore_profiles).setAdapter(localArrayAdapter, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            File localFile = null;
            if (paramAnonymousInt != 0) {
              localFile = new File(MiscUtils.this[(paramAnonymousInt - 1)].toString());
            }
            MiscUtils.showOverrideDialog(localFile, paramContext, paramActivity);
          }
        }).show();
        return;
      }
      localArrayList.add(arrayOfFile[localArrayAdapter].toString().replace(PATH, "").trim());
    }
  }
  
  public static void showSaveDialog(final Activity paramActivity)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(R.layout.alert_dialog_text_entry, null);
    new AlertDialog.Builder(paramActivity).setTitle(R.string.menu_newAudioProfile).setView(localView).setPositiveButton(R.string.save, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        Object localObject = (EditText)MiscUtils.this.findViewById(R.id.profileName);
        CheckBox localCheckBox = (CheckBox)MiscUtils.this.findViewById(R.id.shortcut);
        localObject = ((EditText)localObject).getText().toString();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          List localList = Profile.getProfiles(paramActivity);
          int j = 0;
          int k = -1;
          int i = 0;
          while (i < localList.size()) {
            if (!((Profile)localList.get(i)).getName().equalsIgnoreCase((String)localObject))
            {
              i++;
            }
            else
            {
              j = 1;
              k = ((Profile)localList.get(i)).getId();
            }
          }
          if (j == 0)
          {
            Profile localProfile = new Profile((String)localObject, paramActivity);
            if (localCheckBox.isChecked()) {
              MiscUtils.createProfileShortcut(localProfile.getId(), (String)localObject, paramActivity);
            }
            ((MainActivity)paramActivity).updateProfilesUI();
            Toast.makeText(paramActivity, R.string.profile_saved, 0).show();
          }
          else
          {
            MiscUtils.showOverwriteDialog(k, localCheckBox.isChecked(), (String)localObject, paramActivity);
          }
        }
        else
        {
          Toast.makeText(paramActivity, R.string.when_and_profile_fields_are_required, 0).show();
        }
      }
    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  public static void updateVolumeLockWidget(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, VolumeLockWidget.class);
    localIntent.setAction("com.smartandroidapps.audiowidgetlib.VOLUME_WIDG_INIT");
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.util.MiscUtils
 * JD-Core Version:    0.7.0.1
 */
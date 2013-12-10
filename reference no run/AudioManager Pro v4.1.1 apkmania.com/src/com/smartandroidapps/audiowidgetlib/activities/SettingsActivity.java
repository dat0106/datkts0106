package com.smartandroidapps.audiowidgetlib.activities;

import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.array;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.xml;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.receivers.AlarmUpdateReceiver;
import com.smartandroidapps.audiowidgetlib.receivers.CurrentProfileWidget;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import com.smartandroidapps.audiowidgetlib.util.OldAPIHelper;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public class SettingsActivity
  extends PreferenceActivity
  implements Constants
{
  public static Notification console;
  public static NotificationManager nm;
  private static String publisherLink = "https://play.google.com/store/search?q=%22Smart+Android+Apps,+LLC%22&so=1&c=apps";
  private AlarmManager am;
  private PreferenceScreen refresh;
  private int refreshRate;
  private PendingIntent sender;
  private SettingsManager settings;
  private PreferenceScreen shortcut;
  private ListPreference skins;
  private LinkedHashMap<String, String> skinsData;
  private CheckBoxPreference unLink;
  private String widgetSkin;
  
  private Intent createProfileListShorcutIntent()
  {
    Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(this, R.drawable.icon);
    Intent localIntent2 = new Intent(this, ProfilesActivity.class);
    localIntent2.setFlags(411041792);
    localIntent2.putExtra("homeShortcut", true);
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", getResources().getString(R.string.shortcutTitle));
    localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", localShortcutIconResource);
    return localIntent1;
  }
  
  public static void showDownloadSkinsDialog(Context paramContext)
  {
    new AlertDialog.Builder(paramContext).setTitle(R.string.download_skins_title).setMessage(R.string.download_skins_message).setIcon(17301659).setPositiveButton(R.string.download_skins_button1, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (RunTimeConfig.isFullVersion(SettingsActivity.this))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData(Uri.parse("https://play.google.com/store/search?q=%22Smart+Android+Apps,+LLC%22+com.smartandroidapps.audiowidgetpro.themes."));
          SettingsActivity.this.startActivity(localIntent);
        }
      }
    }).setNegativeButton(R.string.download_skins_button2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("https://play.google.com/store/search?q=com.smartandroidapps.audiowidgetpro.themes."));
        SettingsActivity.this.startActivity(localIntent);
      }
    }).setCancelable(true).show();
  }
  
  public static void updateProfileStatusAndNotification(Context paramContext)
  {
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "SettingsActivity updateProfileStatusAndNotification()");
    }
    nm = (NotificationManager)paramContext.getSystemService("notification");
    console = new Notification(R.drawable.ic_stat_am_notification, paramContext.getResources().getString(R.string.status_enabled), 0L);
    console.flags = 2;
    OldAPIHelper.setNotificationLowPriority(console);
    Object localObject1;
    if (!RunTimeConfig.isFullVersion(paramContext))
    {
      String str1 = paramContext.getResources().getString(R.string.notification_default_message);
    }
    else
    {
      int i = new SettingsManager(paramContext).getCurrentProfileID();
      if (MiscUtils.isDebug()) {
        Log.d("AudioManager", "SettingsActivity updateProfileStatusAndNotification() currProfileId: " + i);
      }
      localObject1 = Profile.getProfile(i, paramContext);
      str2 = paramContext.getResources().getString(R.string.profile_none_applied);
      if (localObject1 == null)
      {
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "SettingsActivity updateProfileStatusAndNotification() currProf not found");
        }
      }
      else {
        str2 = ((Profile)localObject1).getName();
      }
      localObject1 = paramContext.getResources().getString(R.string.status_description) + " " + str2;
      if (new SettingsManager(paramContext).getProfileWidgetEnabled())
      {
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "SettingsActivity updateProfileStatusAndNotification() prof Widget Enabled. currProfName: " + str2);
        }
        localObject2 = new Intent(paramContext, CurrentProfileWidget.class);
        ((Intent)localObject2).setAction("com.smartandroidapps.audiowidgetlib.PROF_WIDG_UPDATE");
        ((Intent)localObject2).putExtra("profname", str2);
        paramContext.sendBroadcast((Intent)localObject2);
      }
    }
    String str2 = paramContext.getResources().getString(R.string.consoleTitle);
    Object localObject2 = new Intent(paramContext, MainActivity.class);
    ((Intent)localObject2).setFlags(402653184);
    localObject2 = PendingIntent.getActivity(paramContext, 0, (Intent)localObject2, 0);
    console.setLatestEventInfo(paramContext, str2, (CharSequence)localObject1, (PendingIntent)localObject2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    final boolean bool = MiscUtils.isAtLeastLargeHC(this);
    Object localObject1 = getIntent().getAction();
    if ((localObject1 != null) && (((String)localObject1).equals("android.intent.action.CREATE_SHORTCUT")))
    {
      setResult(-1, createProfileListShorcutIntent());
      finish();
    }
    addPreferencesFromResource(R.xml.preferences);
    localObject1 = new SettingsManager(this);
    this.settings = ((SettingsManager)localObject1);
    this.widgetSkin = this.settings.getString("widgetSkin", "Original");
    this.am = ((AlarmManager)getSystemService("alarm"));
    this.sender = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmUpdateReceiver.class), 0);
    Object localObject9 = (CheckBoxPreference)findPreference("statBar");
    this.unLink = ((CheckBoxPreference)findPreference("unLink"));
    this.refresh = ((PreferenceScreen)findPreference("refreshRate"));
    localObject1 = (PreferenceScreen)findPreference("email");
    PreferenceCategory localPreferenceCategory = (PreferenceCategory)findPreference("about_us");
    Object localObject2 = (PreferenceScreen)findPreference("moreApplications");
    Object localObject3 = (PreferenceScreen)findPreference("downloadSkins");
    Object localObject4 = (PreferenceCategory)findPreference("widget_preferences");
    Object localObject8 = (PreferenceCategory)findPreference("app_preferences");
    Object localObject6 = (CheckBoxPreference)findPreference("showDialog");
    Object localObject5 = (CheckBoxPreference)findPreference("vibrateProfile");
    Object localObject10 = (ListPreference)findPreference("theme");
    if (!RunTimeConfig.isFullVersion(this)) {
      ((ListPreference)localObject10).setEntries(R.array.themes_free);
    }
    Preference.OnPreferenceChangeListener local1 = new Preference.OnPreferenceChangeListener()
    {
      public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        boolean bool = false;
        String str = paramAnonymousObject.toString();
        if (((!str.equals("darkGreen")) && (!str.equals("darkPink")) && (!str.equals("darkRed")) && (!str.equals("darkYellow"))) || (RunTimeConfig.isFullVersion(SettingsActivity.this))) {
          bool = true;
        } else {
          RunTimeConfig.showBuyDialog(SettingsActivity.this, false, R.string.themes_upgrade_message);
        }
        return bool;
      }
    };
    ((ListPreference)localObject10).setOnPreferenceChangeListener(local1);
    localObject10 = new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        Boolean localBoolean = Boolean.valueOf(SettingsActivity.this.settings.getBoolean("statBar", false));
        if ((!localBoolean.booleanValue()) && (SettingsActivity.nm != null)) {
          SettingsActivity.nm.cancel(1);
        }
        if (localBoolean.booleanValue() == true) {
          ProfilesFragment.checkProfileStreams(SettingsActivity.this, true, (AudioManager)SettingsActivity.this.getSystemService("audio"));
        }
        return false;
      }
    };
    ((CheckBoxPreference)localObject9).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject10);
    localObject9 = this.refresh;
    Object localObject7 = new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        View localView = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.scanning, null);
        SettingsActivity.access$102(SettingsActivity.this, SettingsActivity.this.settings.getInt("refreshRate", 0));
        SeekBar localSeekBar = (SeekBar)localView.findViewById(R.id.minutes);
        final TextView localTextView = (TextView)localView.findViewById(R.id.counter);
        if (SettingsActivity.this.refreshRate != 0)
        {
          String str = localTextView.getContext().getString(R.string.configuration_everyMin);
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(SettingsActivity.this.refreshRate);
          localTextView.setText(String.format(str, arrayOfObject));
        }
        else
        {
          localTextView.setText(SettingsActivity.this.getResources().getString(R.string.configuration_neverUpdate));
        }
        int i = 10;
        if (bool) {
          i = 20;
        }
        localView.setPadding(0, 0, 0, (int)(0.5F + SettingsActivity.this.getResources().getDisplayMetrics().density * i));
        localSeekBar.setProgress(SettingsActivity.this.refreshRate);
        localSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
          public void onProgressChanged(SeekBar paramAnonymous2SeekBar, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Int != 0)
            {
              String str = localTextView.getContext().getString(R.string.configuration_everyMin);
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Integer.valueOf(paramAnonymous2Int);
              str = String.format(str, arrayOfObject);
              localTextView.setText(str);
            }
            else
            {
              localTextView.setText(SettingsActivity.this.getResources().getString(R.string.configuration_neverUpdate));
            }
            SettingsActivity.access$102(SettingsActivity.this, paramAnonymous2Int);
          }
          
          public void onStartTrackingTouch(SeekBar paramAnonymous2SeekBar) {}
          
          public void onStopTrackingTouch(SeekBar paramAnonymous2SeekBar) {}
        });
        new AlertDialog.Builder(SettingsActivity.this).setTitle(SettingsActivity.this.getResources().getString(R.string.refreshRate_title)).setIcon(17301543).setView(localView).setPositiveButton(SettingsActivity.this.getResources().getString(R.string.save), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            SettingsActivity.this.am.cancel(SettingsActivity.this.sender);
            SettingsActivity.this.settings.edit().putInt("refreshRate", SettingsActivity.this.refreshRate).commit();
            if (SettingsActivity.this.refreshRate > 0) {
              SettingsActivity.this.am.set(3, SystemClock.elapsedRealtime(), SettingsActivity.this.sender);
            }
          }
        }).setNegativeButton(SettingsActivity.this.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }).show();
        return false;
      }
    };
    ((PreferenceScreen)localObject9).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject7);
    if (!OldAPIHelper.hasSystemTelephony(getPackageManager())) {
      ((PreferenceCategory)localObject8).removePreference(this.unLink);
    }
    for (;;)
    {
      this.skins = ((ListPreference)findPreference("widget_preference_skin"));
      this.skinsData = ConfigurationActivity.getSkins(this);
      localObject8 = new String[this.skinsData.size()];
      System.arraycopy(this.skinsData.values().toArray(), 0, localObject8, 0, this.skinsData.size());
      localObject7 = new String[this.skinsData.size()];
      System.arraycopy(this.skinsData.keySet().toArray(), 0, localObject7, 0, this.skinsData.size());
      this.skins.setEntries((CharSequence[])localObject8);
      this.skins.setEntryValues((CharSequence[])localObject7);
      this.shortcut = ((PreferenceScreen)findPreference("shortcut_profiles"));
      this.skins.setEnabled(true);
      if (RunTimeConfig.isFullVersion(this))
      {
        ((PreferenceScreen)localObject3).setEnabled(true);
        ((CheckBoxPreference)localObject6).setEnabled(true);
        this.shortcut.setEnabled(true);
        ((CheckBoxPreference)localObject5).setEnabled(true);
        label531:
        localObject6 = this.shortcut;
        localObject5 = new Preference.OnPreferenceClickListener()
        {
          public boolean onPreferenceClick(Preference paramAnonymousPreference)
          {
            if (!RunTimeConfig.isFullVersion(SettingsActivity.this))
            {
              RunTimeConfig.showBuyDialog(SettingsActivity.this, false, R.string.saving_profiles_upgrade_message);
            }
            else
            {
              Intent localIntent = SettingsActivity.this.createProfileListShorcutIntent();
              localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
              SettingsActivity.this.sendBroadcast(localIntent);
            }
            return false;
          }
        };
        ((PreferenceScreen)localObject6).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject5);
        this.skins.setValue(this.widgetSkin);
        localObject6 = this.skins;
        localObject5 = new Preference.OnPreferenceChangeListener()
        {
          public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
          {
            SettingsActivity.access$502(SettingsActivity.this, paramAnonymousObject.toString());
            SettingsActivity.this.settings.edit().putString("widgetSkin", SettingsActivity.this.widgetSkin).commit();
            SettingsActivity.this.settings.editTemp().putBoolean("isNewSkin", true).commit();
            SettingsActivity.this.skins.setValue(SettingsActivity.this.widgetSkin);
            SettingsActivity.this.startService(new Intent(SettingsActivity.this, UpdateService.class));
            return false;
          }
        };
        ((ListPreference)localObject6).setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener)localObject5);
        switch (RunTimeConfig.GetMarketTypeCode(this))
        {
        case 6: 
        default: 
          localObject5 = "info@smartandroidapps.com";
          localObject4 = new Preference.OnPreferenceClickListener()
          {
            public boolean onPreferenceClick(Preference paramAnonymousPreference)
            {
              SettingsActivity.showDownloadSkinsDialog(SettingsActivity.this);
              return false;
            }
          };
          ((PreferenceScreen)localObject3).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject4);
          localObject3 = new Preference.OnPreferenceClickListener()
          {
            public boolean onPreferenceClick(Preference paramAnonymousPreference)
            {
              Intent localIntent = new Intent();
              localIntent.setAction("android.intent.action.VIEW");
              localIntent.setData(Uri.parse(SettingsActivity.publisherLink));
              SettingsActivity.this.startActivity(localIntent);
              return false;
            }
          };
          ((PreferenceScreen)localObject2).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject3);
          label658:
          if (RunTimeConfig.isFullVersion(this))
          {
            localObject2 = getString(R.string.app_name);
            label673:
            if ((0xF & getResources().getConfiguration().screenLayout) != 4) {
              break label977;
            }
            localObject3 = (String)localObject2 + " " + "Tablet";
            localObject2 = "";
          }
          break;
        }
      }
      try
      {
        localObject2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        localObject4 = Build.VERSION.SDK_INT + " " + Build.MODEL;
        ((PreferenceScreen)localObject1).setIntent(new Intent("android.intent.action.VIEW", Uri.parse("mailto:" + (String)localObject5 + "?subject=" + (String)localObject3 + " " + (String)localObject2 + " " + (String)localObject4)));
        return;
        this.unLink.setChecked(MiscUtils.isNotificationAndRingerLinked(getContentResolver(), this, false));
        if (!MiscUtils.isNotificationLinkingUnlinkAvailable(getContentResolver(), this, false))
        {
          ((PreferenceGroup)findPreference("app_preferences")).removePreference(this.unLink);
          continue;
        }
        localObject7 = this.unLink;
        localObject8 = new Preference.OnPreferenceClickListener()
        {
          public boolean onPreferenceClick(Preference paramAnonymousPreference)
          {
            Boolean localBoolean = Boolean.valueOf(paramAnonymousPreference.getSharedPreferences().getBoolean("unLink", false));
            if (!localBoolean.booleanValue())
            {
              MiscUtils.lockUnlockNotificationsAndRingerVolumes(SettingsActivity.this.getContentResolver(), SettingsActivity.this, false);
              Toast.makeText(SettingsActivity.this, R.string.settings_unlink_false, 0).show();
            }
            if (localBoolean.booleanValue() == true)
            {
              MiscUtils.lockUnlockNotificationsAndRingerVolumes(SettingsActivity.this.getContentResolver(), SettingsActivity.this, true);
              Toast.makeText(SettingsActivity.this, R.string.settings_unlink_true, 0).show();
            }
            return false;
          }
        };
        ((CheckBoxPreference)localObject7).setOnPreferenceClickListener((Preference.OnPreferenceClickListener)localObject8);
        continue;
        ((PreferenceScreen)localObject3).setEnabled(false);
        ((CheckBoxPreference)localObject6).setEnabled(false);
        this.shortcut.setEnabled(false);
        ((CheckBoxPreference)localObject5).setEnabled(false);
        break label531;
        localObject5 = "help@handnsoft.com";
        ((PreferenceCategory)localObject4).removePreference((Preference)localObject3);
        localPreferenceCategory.removePreference((Preference)localObject2);
        break label658;
        localObject2 = getString(R.string.app_name_free);
        break label673;
        label977:
        localObject3 = (String)localObject2 + " " + "Phone";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  protected void onStop()
  {
    OldAPIHelper.dataChanged(this);
    super.onStop();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.SettingsActivity
 * JD-Core Version:    0.7.0.1
 */
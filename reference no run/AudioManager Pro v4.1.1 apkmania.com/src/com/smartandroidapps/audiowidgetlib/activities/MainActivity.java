package com.smartandroidapps.audiowidgetlib.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.menu;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.style;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.adapters.PagerAdapter;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.fragments.DynamicConsole;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.guidedtour.GuidedTourActivity;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.ui.ActionItem;
import com.smartandroidapps.audiowidgetlib.ui.CustomViewPager;
import com.smartandroidapps.audiowidgetlib.ui.QuickAction;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import com.smartandroidapps.audiowidgetlib.util.OldAPIHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class MainActivity
  extends SherlockFragmentActivity
  implements ViewPager.OnPageChangeListener, ActionBar.TabListener, Constants, SharedPreferences.OnSharedPreferenceChangeListener
{
  public static final int VALUE_VIBRATE_ALWAYS = 0;
  public static final int VALUE_VIBRATE_NEVER = 1;
  public static final int VALUE_VIBRATE_ONLY_SILENT = 2;
  public static final int VALUE_VIBRATE_UNLESS_SILENT = 3;
  public static boolean isActive = false;
  public static final Object[] sSqliteDataLock = new Object[0];
  private final BroadcastReceiver OnRingerModeChanged = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MainActivity.this.updateConsoleUI();
      MainActivity.this.updateProfilesUI();
      MainActivity.this.updateRingerModeIcon();
    }
  };
  private final IntentFilter RINGER_MODE_CHANGED = new IntentFilter("android.media.RINGER_MODE_CHANGED");
  private AudioManager am;
  private boolean isExpired = false;
  private ActionBar mActionBar;
  protected DynamicConsole mDynamicConFrag;
  private final long mExpirationExtraGrace = 5184000000L;
  private FragmentManager mFragManager;
  private List<SherlockFragment> mFragments;
  private boolean mIsVolumeLocked;
  private PagerAdapter mPagerAdapter;
  protected ProfilesFragment mProfilesFrag;
  private SettingsManager mSettingsManager;
  private boolean mShowNotification;
  private final long mUpgradExpiriationTime = 1373715334263L;
  private CustomViewPager mViewPager;
  private int menuItemSelector;
  private MenuItem menuLock;
  private MenuItem menuRingerMode;
  
  private void checkForUpgrade()
  {
    try
    {
      j = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
      int i = getSettingsManager().getInt("versionCode", -1);
      if (j > i)
      {
        Schedule.SetUpAlarmManagerForNextSchedule(this);
        getSettingsManager().editTemp().putInt("versionCode", j).commit();
      }
      if (i < 50) {
        OldAPIHelper.dataChanged(this);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int j = 2147483647;
      }
    }
  }
  
  private void doExpireCheck()
  {
    if (Calendar.getInstance().getTimeInMillis() <= 1373715334263L) {
      this.isExpired = false;
    } else {
      showUpgradeMessage();
    }
  }
  
  private void doUpdate()
  {
    updateConsoleUI();
    updateProfilesUI();
  }
  
  private void enableEmbeddedTabs(Object paramObject)
  {
    try
    {
      Object localObject1 = paramObject.getClass();
      Object localObject2 = new Class[1];
      localObject2[0] = Boolean.TYPE;
      localObject1 = ((Class)localObject1).getDeclaredMethod("setHasEmbeddedTabs", (Class[])localObject2);
      ((Method)localObject1).setAccessible(true);
      localObject2 = new Object[1];
      localObject2[0] = Boolean.valueOf(true);
      ((Method)localObject1).invoke(paramObject, (Object[])localObject2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("AudioManager", "Error marking actionbar embedded", localException);
      }
    }
  }
  
  private void enableVolumeLock()
  {
    this.mIsVolumeLocked = true;
    getSettingsManager().editnew().putVolumeLocked(true).commit();
    saveVolumeConfiguration();
    Toast.makeText(this, R.string.volume_lock_toast, 0).show();
    if (RunTimeConfig.isFullVersion(this)) {
      MiscUtils.updateVolumeLockWidget(this);
    }
  }
  
  private SettingsManager getSettingsManager()
  {
    if (this.mSettingsManager == null) {
      this.mSettingsManager = new SettingsManager(this);
    }
    return this.mSettingsManager;
  }
  
  @SuppressLint({"NewApi"})
  private boolean hasVibrator()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = ((Vibrator)getSystemService("vibrator")).hasVibrator();
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void initPrefs()
  {
    getSettingsManager().getTempDisableVolumeLock();
    getSettingsManager().getInt("stream_voice", this.am.getStreamVolume(0));
    getSettingsManager().getInt("stream_system", this.am.getStreamVolume(1));
    getSettingsManager().getInt("stream_ring", this.am.getStreamVolume(2));
    getSettingsManager().getInt("stream_music", this.am.getStreamVolume(3));
    getSettingsManager().getInt("stream_alarm", this.am.getStreamVolume(4));
    getSettingsManager().getInt("stream_notification", this.am.getStreamVolume(5));
    getSettingsManager().getInt("ringerMode", this.am.getRingerMode());
  }
  
  private String makeFragmentName(int paramInt1, int paramInt2)
  {
    return "android:switcher:" + paramInt1 + ":" + paramInt2;
  }
  
  private void saveVolumeConfiguration()
  {
    SharedPreferences.Editor localEditor = getSettingsManager().edit();
    localEditor.putInt("stream_voice", this.am.getStreamVolume(0));
    localEditor.putInt("stream_system", this.am.getStreamVolume(1));
    localEditor.putInt("stream_ring", this.am.getStreamVolume(2));
    localEditor.putInt("stream_music", this.am.getStreamVolume(3));
    localEditor.putInt("stream_alarm", this.am.getStreamVolume(4));
    localEditor.putInt("stream_notification", this.am.getStreamVolume(5));
    localEditor.putInt("ringerMode", this.am.getRingerMode());
    localEditor.commit();
  }
  
  private void setDefaultRingtone(int paramInt, Uri paramUri)
  {
    RingtoneManager.setActualDefaultRingtoneUri(this, paramInt, paramUri);
  }
  
  private void setEmbeddedTabs()
  {
    if (Build.VERSION.SDK_INT < 14) {
      enableEmbeddedTabs(this.mActionBar);
    }
    for (;;)
    {
      return;
      try
      {
        Field localField = this.mActionBar.getClass().getDeclaredField("mActionBar");
        localField.setAccessible(true);
        enableEmbeddedTabs(localField.get(this.mActionBar));
      }
      catch (Exception localException)
      {
        Log.e("AudioManager", "Error enabling embedded tabs", localException);
      }
    }
  }
  
  private void setLayoutTheme()
  {
    String str = getSettingsManager().getTheme();
    if (!str.equals("darkBlue"))
    {
      if (!str.equals("normal"))
      {
        if (!str.equals("darkRed"))
        {
          if (!str.equals("darkGreen"))
          {
            if (!str.equals("darkYellow"))
            {
              if (str.equals("darkPink")) {
                setTheme(R.style.Theme_AudioManager_Dark_Pink);
              }
            }
            else {
              setTheme(R.style.Theme_AudioManager_Dark_Yellow);
            }
          }
          else {
            setTheme(R.style.Theme_AudioManager_Dark_Green);
          }
        }
        else {
          setTheme(R.style.Theme_AudioManager_Dark_Red);
        }
      }
      else {
        setTheme(R.style.Theme_AudioManager);
      }
    }
    else {
      setTheme(R.style.Theme_AudioManager_Dark_Blue);
    }
  }
  
  private void setPhoneVibrateSettingValue(int paramInt)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT < 16)
    {
      int j;
      int m;
      if (paramInt != 3)
      {
        if (paramInt != i)
        {
          if (paramInt != 2)
          {
            j = 1;
            m = 1;
          }
          else
          {
            j = 2;
            m = 1;
          }
        }
        else
        {
          j = 0;
          m = 0;
        }
      }
      else
      {
        j = 1;
        m = 0;
      }
      ContentResolver localContentResolver = getContentResolver();
      if (m == 0) {
        m = 0;
      } else {
        m = i;
      }
      Settings.System.putInt(localContentResolver, "vibrate_in_silent", m);
      int k = this.am.getRingerMode();
      if (k != 2) {
        if ((paramInt != 0) && (paramInt != 2))
        {
          if (k == i) {
            this.am.setRingerMode(0);
          }
        }
        else if (k == 0) {
          this.am.setRingerMode(i);
        }
      }
      this.am.setVibrateSetting(0, j);
      this.am.setVibrateSetting(i, j);
    }
    else
    {
      if (paramInt == i) {
        i = 0;
      }
      Profile.setVibeWhenRingingSetting(this, i, this.am);
    }
  }
  
  private boolean shouldSilentVibrate()
  {
    int i = getPhoneVibrateSettingValue();
    if ((i != 0) && (i != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    return i;
  }
  
  private void showUpgradeMessage()
  {
    new AlertDialog.Builder(this).setTitle(R.string.upgrade).setMessage(R.string.upgrade_message).setIcon(R.drawable.market_ico).setPositiveButton(R.string.upgrade, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Uri localUri = Uri.parse(RunTimeConfig.getUpdateLink(MainActivity.this));
        if (localUri != null)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("android.intent.action.VIEW").setData(localUri);
          MainActivity.this.startActivity(localIntent);
          MainActivity.this.finish();
        }
        else
        {
          MainActivity.this.finish();
        }
      }
    }).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (Calendar.getInstance().getTimeInMillis() <= 1378899334263L) {
          paramAnonymousDialogInterface.dismiss();
        } else {
          MainActivity.this.finish();
        }
      }
    }).show();
  }
  
  private void showVolumeLockDialog(MenuItem paramMenuItem)
  {
    new AlertDialog.Builder(this).setIcon(17301543).setMessage(R.string.volume_lock_message).setTitle(R.string.volume_lock).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MainActivity.this.enableVolumeLock();
      }
    }).setNegativeButton(R.string.cancel, null).show();
  }
  
  private void updateRingerModeIcon()
  {
    if (this.menuRingerMode != null) {
      if (this.am.getRingerMode() != 2) {
        this.menuRingerMode.setIcon(R.drawable.ic_silent_mode);
      } else {
        this.menuRingerMode.setIcon(R.drawable.ic_normal_mode);
      }
    }
  }
  
  public void doCheck() {}
  
  int getPhoneVibrateSettingValue()
  {
    int j = 0;
    if (Build.VERSION.SDK_INT < 16)
    {
      boolean bool = Profile.getVibeInSilentSetting(this);
      int i = this.am.getVibrateSetting(0);
      if (Build.VERSION.SDK_INT >= 8)
      {
        if (!bool)
        {
          if (i == 2) {
            this.am.setVibrateSetting(0, 0);
          }
          if (i != 1) {
            j = 1;
          } else {
            j = 3;
          }
        }
        else
        {
          if (i == 0) {
            this.am.setVibrateSetting(0, 2);
          }
          if (i != 1) {
            j = 2;
          }
        }
      }
      else if (i != 1) {
        if (i != 2) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
    else if (!Profile.getVibeWhenRingingSetting(this))
    {
      j = 1;
    }
    return j;
  }
  
  public boolean isExpired()
  {
    if (this.isExpired) {
      doExpireCheck();
    }
    return this.isExpired;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Uri localUri = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
      switch (paramInt1)
      {
      case 1000: 
        setDefaultRingtone(1, localUri);
        break;
      case 1001: 
        setDefaultRingtone(2, localUri);
        break;
      case 1002: 
        setDefaultRingtone(4, localUri);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setLayoutTheme();
    this.am = ((AudioManager)getSystemService("audio"));
    checkForUpgrade();
    if (!isExpired()) {
      doCheck();
    }
    this.mShowNotification = getSettingsManager().getBoolean("statBar", false);
    this.mIsVolumeLocked = getSettingsManager().getVolumeLocked();
    if (this.mShowNotification) {
      ProfilesFragment.checkProfileStreams(this, true, (AudioManager)getSystemService("audio"));
    }
    this.mActionBar = getSupportActionBar();
    this.mFragManager = getSupportFragmentManager();
    setEmbeddedTabs();
    this.mActionBar.setDisplayUseLogoEnabled(true);
    this.mActionBar.setDisplayShowHomeEnabled(true);
    this.mActionBar.setDisplayShowTitleEnabled(false);
    if (!MiscUtils.isAtLeastLargeHC(this))
    {
      this.mActionBar.setLogo(getResources().getDrawable(R.drawable.am_top_banner));
      setContentView(R.layout.main_layout_phone);
      this.mActionBar.setNavigationMode(2);
      localObject1 = this.mActionBar.newTab().setText(R.string.volume_menu_title);
      localObject2 = this.mActionBar.newTab().setText(R.string.profiles_menu_title);
      this.mActionBar.addTab(((ActionBar.Tab)localObject1).setTabListener(this));
      this.mActionBar.addTab(((ActionBar.Tab)localObject2).setTabListener(this));
      this.mFragments = new Vector();
      this.mFragments.add(new DynamicConsole());
      this.mFragments.add(new ProfilesFragment());
      this.mPagerAdapter = new PagerAdapter(this.mFragManager, this.mFragments);
      this.mViewPager = ((CustomViewPager)findViewById(R.id.pager));
      this.mViewPager.setAdapter(this.mPagerAdapter);
      this.mViewPager.setOnPageChangeListener(this);
      this.mDynamicConFrag = ((DynamicConsole)this.mFragments.get(0));
      this.mProfilesFrag = ((ProfilesFragment)this.mFragments.get(1));
      this.mDynamicConFrag.setRetainInstance(true);
      this.mProfilesFrag.setRetainInstance(true);
    }
    else
    {
      this.mActionBar.setLogo(getResources().getDrawable(R.drawable.am_top_banner_tablet));
      setContentView(R.layout.main_layout_tablet);
      this.mActionBar.setNavigationMode(0);
      this.mDynamicConFrag = ((DynamicConsole)this.mFragManager.findFragmentById(R.id.frag_console));
      this.mProfilesFrag = ((ProfilesFragment)this.mFragManager.findFragmentById(R.id.frag_profiles));
    }
    if ((paramBundle != null) && (!MiscUtils.isAtLeastLargeHC(this))) {
      this.mActionBar.setSelectedNavigationItem(paramBundle.getInt("index"));
    }
    initPrefs();
    getSettingsManager().registerOnSharedPreferenceChangeListener(this);
    Object localObject1 = findViewById(R.id.mainBackground);
    Object localObject2 = getSettingsManager().getTheme();
    if (!((String)localObject2).equals("darkBlue"))
    {
      if (!((String)localObject2).equals("normal"))
      {
        if (!((String)localObject2).equals("darkRed"))
        {
          if (!((String)localObject2).equals("darkGreen"))
          {
            if (!((String)localObject2).equals("darkYellow"))
            {
              if (((String)localObject2).equals("darkPink"))
              {
                ((View)localObject1).setBackgroundDrawable(null);
                this.mActionBar.setBackgroundDrawable(null);
              }
            }
            else
            {
              ((View)localObject1).setBackgroundDrawable(null);
              this.mActionBar.setBackgroundDrawable(null);
            }
          }
          else
          {
            ((View)localObject1).setBackgroundDrawable(null);
            this.mActionBar.setBackgroundDrawable(null);
          }
        }
        else
        {
          ((View)localObject1).setBackgroundDrawable(null);
          this.mActionBar.setBackgroundDrawable(null);
        }
      }
      else
      {
        ((View)localObject1).setBackgroundDrawable(getResources().getDrawable(R.drawable.background_holo_dark));
        localObject1 = (BitmapDrawable)getResources().getDrawable(R.drawable.actionbar_background);
        ((BitmapDrawable)localObject1).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.mActionBar.setBackgroundDrawable((Drawable)localObject1);
      }
    }
    else
    {
      ((View)localObject1).setBackgroundDrawable(null);
      this.mActionBar.setBackgroundDrawable(null);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    new MenuInflater(this).inflate(R.menu.menu, paramMenu);
    if (hasVibrator())
    {
      Object localObject = getSettingsManager().getTheme();
      if (localObject != null) {
        if (!((String)localObject).equals("darkBlue"))
        {
          if (!((String)localObject).equals("normal"))
          {
            if (!((String)localObject).equals("darkRed"))
            {
              if (!((String)localObject).equals("darkGreen"))
              {
                if (!((String)localObject).equals("darkYellow"))
                {
                  if (((String)localObject).equals("darkPink")) {
                    this.menuItemSelector = R.drawable.actionitem_background_pink;
                  }
                }
                else {
                  this.menuItemSelector = R.drawable.actionitem_background_yellow;
                }
              }
              else {
                this.menuItemSelector = R.drawable.actionitem_background_green;
              }
            }
            else {
              this.menuItemSelector = R.drawable.actionitem_background_red;
            }
          }
          else {
            this.menuItemSelector = R.drawable.actionitem_background_green;
          }
        }
        else {
          this.menuItemSelector = R.drawable.actionitem_background_blue;
        }
      }
      localObject = paramMenu.add(0, 200, 0, R.string.vibrate_button);
      ((MenuItem)localObject).setIcon(R.drawable.ic_audio_ring_notif_vibrate);
      ((MenuItem)localObject).setShowAsAction(2);
      ((MenuItem)localObject).setTitle(R.string.mode_menu_title);
      ImageButton localImageButton = new ImageButton(this);
      localImageButton.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localImageButton.setBackgroundDrawable(getResources().getDrawable(this.menuItemSelector));
      if (Build.VERSION.SDK_INT < 16)
      {
        localImageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_audio_ring_notif_vibrate));
        localImageButton.setOnClickListener(new View.OnClickListener()
        {
          private void updateQuickAction(QuickAction paramAnonymousQuickAction)
          {
            paramAnonymousQuickAction.dismiss();
            MainActivity.this.doUpdate();
          }
          
          public void onClick(View paramAnonymousView)
          {
            final QuickAction localQuickAction = new QuickAction(paramAnonymousView);
            MainActivity localMainActivity = MainActivity.this;
            ActionItem localActionItem4 = new ActionItem();
            localActionItem4.setTitle(localMainActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[0]);
            localActionItem4.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
            localActionItem4.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                MainActivity.this.setPhoneVibrateSettingValue(0);
                MainActivity.2.this.updateQuickAction(localQuickAction);
              }
            });
            ActionItem localActionItem2 = new ActionItem();
            localActionItem2.setTitle(localMainActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[1]);
            localActionItem2.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
            localActionItem2.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                MainActivity.this.setPhoneVibrateSettingValue(1);
                MainActivity.2.this.updateQuickAction(localQuickAction);
              }
            });
            ActionItem localActionItem1 = new ActionItem();
            localActionItem1.setTitle(localMainActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[2]);
            localActionItem1.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
            localActionItem1.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                MainActivity.this.setPhoneVibrateSettingValue(2);
                MainActivity.2.this.updateQuickAction(localQuickAction);
              }
            });
            ActionItem localActionItem3 = new ActionItem();
            localActionItem3.setTitle(localMainActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[3]);
            localActionItem3.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
            localActionItem3.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                MainActivity.this.setPhoneVibrateSettingValue(3);
                MainActivity.2.this.updateQuickAction(localQuickAction);
              }
            });
            switch (MainActivity.this.getPhoneVibrateSettingValue())
            {
            case 0: 
              localActionItem4.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
              break;
            case 1: 
              localActionItem2.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
              break;
            case 2: 
              localActionItem1.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
              break;
            case 3: 
              localActionItem3.setIcon(localMainActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
            }
            localQuickAction.addActionItem(localActionItem4);
            localQuickAction.addActionItem(localActionItem2);
            localQuickAction.addActionItem(localActionItem1);
            if (Build.VERSION.SDK_INT >= 8) {
              localQuickAction.addActionItem(localActionItem3);
            }
            MainActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                localQuickAction.show();
              }
            });
          }
        });
      }
      else
      {
        if (!Profile.getVibeWhenRingingSetting(this)) {
          localImageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_audio_ring_notif_novibrate));
        } else {
          localImageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_audio_ring_notif_vibrate));
        }
        localImageButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            boolean bool;
            if (Profile.getVibeWhenRingingSetting(MainActivity.this)) {
              bool = false;
            } else {
              bool = true;
            }
            Profile.setVibeWhenRingingSetting(MainActivity.this, bool, MainActivity.this.am);
            if (!bool) {
              ((ImageButton)paramAnonymousView).setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.ic_audio_ring_notif_novibrate));
            } else {
              ((ImageButton)paramAnonymousView).setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.ic_audio_ring_notif_vibrate));
            }
          }
        });
      }
      ((MenuItem)localObject).setActionView(localImageButton);
    }
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 25) || (paramInt == 24))
    {
      updateConsoleUI();
      updateProfilesUI();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = 1;
    if (paramMenuItem.getItemId() != R.id.menu_backup)
    {
      if (paramMenuItem.getItemId() != R.id.menu_restore)
      {
        if (paramMenuItem.getItemId() != R.id.menu_settings)
        {
          if (paramMenuItem.getItemId() != R.id.menu_upgrade)
          {
            if (paramMenuItem.getItemId() != R.id.menu_save)
            {
              if (paramMenuItem.getItemId() != R.id.menu_help)
              {
                if (paramMenuItem.getItemId() != R.id.menu_lock)
                {
                  if (paramMenuItem.getItemId() != R.id.menu_ringermode)
                  {
                    i = super.onOptionsItemSelected(paramMenuItem);
                  }
                  else if (this.am.getRingerMode() != 2)
                  {
                    this.am.setRingerMode(2);
                    this.menuRingerMode.setIcon(R.drawable.ic_normal_mode);
                  }
                  else
                  {
                    if (!shouldSilentVibrate())
                    {
                      this.am.setRingerMode(0);
                    }
                    else
                    {
                      this.am.setRingerMode(i);
                      ((Vibrator)getSystemService("vibrator")).vibrate(50L);
                    }
                    this.menuRingerMode.setIcon(R.drawable.ic_silent_mode);
                  }
                }
                else if (this.mIsVolumeLocked)
                {
                  paramMenuItem.setIcon(getResources().getDrawable(R.drawable.ic_unlock));
                  this.mIsVolumeLocked = false;
                  getSettingsManager().editnew().putVolumeLocked(false).commit();
                  Toast.makeText(this, R.string.volume_unlock_toast, 0).show();
                  if (RunTimeConfig.isFullVersion(this)) {
                    MiscUtils.updateVolumeLockWidget(this);
                  }
                }
                else if (!getSettingsManager().getShowVolumeLockDialog())
                {
                  enableVolumeLock();
                }
                else
                {
                  showVolumeLockDialog(paramMenuItem);
                  getSettingsManager().editnew().putShowVolumeLockDialog(false).commit();
                }
              }
              else {
                startActivity(new Intent(this, GuidedTourActivity.class));
              }
            }
            else if (!RunTimeConfig.isFullVersion(this)) {
              RunTimeConfig.showBuyDialog(this, false, R.string.saving_profiles_upgrade_message);
            } else {
              MiscUtils.showSaveDialog(this);
            }
          }
          else
          {
            Uri localUri = Uri.parse(RunTimeConfig.getUpgradeLink(this));
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW").setData(localUri);
            startActivity(localIntent);
          }
        }
        else {
          startActivity(new Intent(this, SettingsActivity.class));
        }
      }
      else if (!RunTimeConfig.isFullVersion(this)) {
        RunTimeConfig.showBuyDialog(this, false, R.string.saving_profiles_upgrade_message);
      } else {
        MiscUtils.showRestoreDialog(this, this);
      }
    }
    else if (!RunTimeConfig.isFullVersion(this)) {
      RunTimeConfig.showBuyDialog(this, false, R.string.saving_profiles_upgrade_message);
    } else {
      MiscUtils.showBackupDialog(this);
    }
    return i;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.mActionBar.setSelectedNavigationItem(paramInt);
  }
  
  public void onPause()
  {
    super.onPause();
    boolean bool1 = this.mSettingsManager.getBoolean("statBar", false);
    boolean bool2 = this.mSettingsManager.getProfileWidgetEnabled();
    if ((bool1) || (bool2)) {
      ProfilesFragment.checkProfileStreams(this, true, (AudioManager)getSystemService("audio"));
    }
    startService(new Intent(this, UpdateService.class));
    try
    {
      unregisterReceiver(this.OnRingerModeChanged);
      isActive = false;
      if (this.mIsVolumeLocked) {
        saveVolumeConfiguration();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {}
      throw localIllegalArgumentException;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem2 = paramMenu.findItem(R.id.menu_backup);
    MenuItem localMenuItem1 = paramMenu.findItem(R.id.menu_upgrade);
    this.menuRingerMode = paramMenu.findItem(R.id.menu_ringermode);
    this.menuLock = paramMenu.findItem(R.id.menu_lock);
    updateRingerModeIcon();
    if (!Profile.getProfiles(this).isEmpty()) {
      localMenuItem2.setEnabled(true);
    } else {
      localMenuItem2.setEnabled(false);
    }
    if (!this.mIsVolumeLocked) {
      this.menuLock.setIcon(R.drawable.ic_unlock);
    } else {
      this.menuLock.setIcon(R.drawable.ic_lock);
    }
    if (RunTimeConfig.isFullVersion(this)) {
      localMenuItem1.setVisible(false);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onResume()
  {
    super.onResume();
    registerReceiver(this.OnRingerModeChanged, this.RINGER_MODE_CHANGED);
    isActive = true;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!MiscUtils.isAtLeastLargeHC(this)) {
      paramBundle.putInt("index", getSupportActionBar().getSelectedNavigationIndex());
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramString.equals("volumeLockKey"))
    {
      this.mIsVolumeLocked = getSettingsManager().getVolumeLocked();
      if (this.menuLock != null) {
        if (!this.mIsVolumeLocked) {
          this.menuLock.setIcon(R.drawable.ic_unlock);
        } else {
          this.menuLock.setIcon(R.drawable.ic_lock);
        }
      }
    }
  }
  
  public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {}
  
  public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    if (this.mViewPager != null) {
      this.mViewPager.setCurrentItem(paramTab.getPosition());
    }
  }
  
  public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction) {}
  
  public void updateConsoleUI()
  {
    if ((this.mDynamicConFrag == null) || (!this.mDynamicConFrag.isVisible()))
    {
      DynamicConsole localDynamicConsole = (DynamicConsole)getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.pager, 0));
      if ((localDynamicConsole != null) && (localDynamicConsole.isVisible())) {
        localDynamicConsole.doUIUpdate();
      }
    }
    else
    {
      this.mDynamicConFrag.doUIUpdate();
    }
  }
  
  public void updateProfilesUI()
  {
    if ((this.mProfilesFrag == null) || (!this.mProfilesFrag.isVisible()))
    {
      ProfilesFragment localProfilesFragment = (ProfilesFragment)getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.pager, 1));
      if ((localProfilesFragment != null) && (localProfilesFragment.isVisible())) {
        localProfilesFragment.loadList();
      }
    }
    else
    {
      this.mProfilesFrag.loadList();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.MainActivity
 * JD-Core Version:    0.7.0.1
 */
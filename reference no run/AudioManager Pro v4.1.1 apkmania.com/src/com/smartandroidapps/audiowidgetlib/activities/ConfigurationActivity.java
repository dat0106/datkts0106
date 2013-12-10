package com.smartandroidapps.audiowidgetlib.activities;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.array;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.style;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import com.smartandroidapps.audiowidgetlib.util.OldAPIHelper;
import com.smartandroidapps.audiowidgetlib.widget.Mainsmall;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public class ConfigurationActivity
  extends Activity
  implements Constants
{
  public static final String skinsSubPackage = "themes";
  private Button cancelButton;
  private TextView counter;
  private int downloadBackground;
  private Button downloadSkins;
  private boolean isTransparent = false;
  private int mAppWidgetId = 0;
  private SeekBar minutes;
  private Button okButton;
  private int refreshRate = 0;
  private SettingsManager settings;
  private Spinner skins;
  private LinkedHashMap<String, String> skinsData;
  private ArrayAdapter<?> spinner;
  private int spinnerBackground;
  private String widgetSkin;
  
  public static LinkedHashMap<String, String> getSkins(Context paramContext)
  {
    String str1 = paramContext.getPackageName() + "." + "themes";
    PackageManager localPackageManager = paramContext.getPackageManager();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String[] arrayOfString1 = paramContext.getResources().getStringArray(R.array.skins);
    String[] arrayOfString2 = paramContext.getResources().getStringArray(R.array.skinvalues);
    for (int k = 0; k < arrayOfString1.length; k++) {
      localLinkedHashMap.put(arrayOfString2[k], arrayOfString1[k]);
    }
    if (!RunTimeConfig.isFullVersion(paramContext)) {}
    for (;;)
    {
      return localLinkedHashMap;
      List localList = localPackageManager.getInstalledPackages(0);
      int i = localList.size();
      int j = 0;
      while (j < i) {
        if (((PackageInfo)localList.get(j)).packageName.startsWith(str1 + "."))
        {
          ApplicationInfo localApplicationInfo = ((PackageInfo)localList.get(j)).applicationInfo;
          try
          {
            Object localObject1 = localPackageManager.getResourcesForApplication(localApplicationInfo);
            int m = ((Resources)localObject1).getIdentifier("name", "string", localApplicationInfo.packageName);
            if (m != 0) {
              localLinkedHashMap.put(localApplicationInfo.packageName, ((Resources)localObject1).getText(m).toString());
            }
            m = ((Resources)localObject1).getIdentifier("skins", "array", localApplicationInfo.packageName);
            if (m != 0)
            {
              localObject1 = ((Resources)localObject1).getStringArray(m);
              for (int n = 0; n < localObject1.length; n++)
              {
                Object localObject2 = localObject1[n];
                int i1 = localObject2.lastIndexOf('/');
                if ((i1 > -1) && (i1 + 1 < localObject2.length()))
                {
                  String str2 = localObject2.substring(0, i1);
                  String str3 = localObject2.substring(i1 + 1);
                  localLinkedHashMap.put(localApplicationInfo.packageName + "/" + str3, str2);
                }
              }
            }
            j++;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
      }
    }
  }
  
  private void loadLayout()
  {
    boolean bool = MiscUtils.isAtLeastLargeHC(this);
    int j;
    if (Build.VERSION.SDK_INT <= 10) {
      j = 0;
    } else {
      j = 1;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    int i = -1;
    if (bool) {
      i = 520;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i);
    LinearLayout localLinearLayout = OldAPIHelper.getLinearLayout_Holo_ButtonBar_AlertDialog(this);
    localLinearLayout.setId(800);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLinearLayout.setPadding(4, 5, 4, 1);
    if (!bool) {
      localLinearLayout.setBackgroundResource(17301658);
    }
    localLayoutParams2.addRule(12, localRelativeLayout.getId());
    ScrollView localScrollView = new ScrollView(this);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, localLinearLayout.getId());
    localScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(100);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    Object localObject3 = new ImageView(this);
    ((ImageView)localObject3).setImageDrawable(getResources().getDrawable(R.drawable.am_top_banner_tablet));
    if (bool) {
      ((ImageView)localObject3).setPadding(0, 20, 0, 0);
    }
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    localObject3 = new TextView(this);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setGravity(3);
    ((TextView)localObject3).setTypeface(Typeface.DEFAULT_BOLD);
    ((TextView)localObject3).setText(R.string.configuration_refreshLabel);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((TextView)localObject3).setPadding(convertDip(15), convertDip(10), 0, 0);
    ((LinearLayout)localObject1).addView((View)localObject3);
    Object localObject4 = new TextView(this);
    ((TextView)localObject4).setId(200);
    ((TextView)localObject4).setText(R.string.configuration_refreshText);
    ((TextView)localObject4).setGravity(3);
    ((TextView)localObject4).setPadding(convertDip(9), 0, convertDip(9), 0);
    localObject3 = new LinearLayout.LayoutParams(-1, -2);
    ((TextView)localObject4).setPadding(convertDip(15), convertDip(15), 0, 0);
    ((LinearLayout)localObject1).addView((View)localObject4);
    localObject4 = new TextView(this);
    this.counter = ((TextView)localObject4);
    this.counter.setId(300);
    this.counter.setText(R.string.configuration_neverUpdate);
    this.counter.setGravity(17);
    this.counter.setTextSize(18.0F);
    if (j != 0) {
      this.counter.setTextColor(-1);
    }
    this.counter.setTypeface(Typeface.DEFAULT_BOLD);
    localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject4).setMargins(0, convertDip(20), 0, 0);
    ((LinearLayout)localObject1).addView(this.counter, (ViewGroup.LayoutParams)localObject4);
    localObject4 = new SeekBar(this);
    this.minutes = ((SeekBar)localObject4);
    this.minutes.setProgress(0);
    this.minutes.setMax(60);
    this.minutes.setThumbOffset(convertDip(16));
    this.minutes.setMinimumHeight(convertDip(13));
    this.minutes.setPadding(convertDip(35), 0, convertDip(35), convertDip(6));
    localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject4).setMargins(0, convertDip(15), 0, 0);
    ((LinearLayout)localObject1).addView(this.minutes, (ViewGroup.LayoutParams)localObject4);
    ((LinearLayout.LayoutParams)localObject2).setMargins(convertDip(15), convertDip(40), 0, 0);
    ((LinearLayout.LayoutParams)localObject3).setMargins(0, convertDip(15), 0, 0);
    localObject3 = new TextView(this);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setGravity(3);
    ((TextView)localObject3).setTypeface(Typeface.DEFAULT_BOLD);
    ((TextView)localObject3).setText(R.string.configuration_widgetSkin);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(convertDip(15), convertDip(15), 0, 0);
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    this.skinsData = getSkins(this);
    localObject2 = this.skinsData.values().toArray();
    localObject2 = new ArrayAdapter(this, 17367048, (Object[])localObject2);
    this.spinner = ((ArrayAdapter)localObject2);
    this.spinner.setDropDownViewResource(17367049);
    localObject2 = new Spinner(this);
    this.skins = ((Spinner)localObject2);
    this.skins.setPromptId(R.string.configuration_selectSkin);
    this.skins.setAdapter(this.spinner);
    if (Build.VERSION.SDK_INT > 10) {
      this.skins.setBackgroundResource(this.spinnerBackground);
    }
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(convertDip(10), convertDip(5), convertDip(10), convertDip(10));
    ((LinearLayout)localObject1).addView(this.skins, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new CheckBox(this);
    ((CheckBox)localObject2).setTextColor(-1);
    ((CheckBox)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((CheckBox)localObject2).setButtonDrawable(R.drawable.btn_check_holo_light);
    ((CheckBox)localObject2).setText(R.string.widget_preference_transparent_title);
    ((CheckBox)localObject2).setChecked(this.isTransparent);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).setMargins(convertDip(10), convertDip(10), 0, convertDip(10));
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        ConfigurationActivity.access$002(ConfigurationActivity.this, paramAnonymousBoolean);
      }
    };
    ((CheckBox)localObject2).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)localObject3);
    localObject3 = getString(R.string.download_skins_title);
    localObject2 = new SpannableString((CharSequence)localObject3);
    ((SpannableString)localObject2).setSpan(new UnderlineSpan(), 0, ((String)localObject3).length(), 0);
    switch (RunTimeConfig.GetMarketTypeCode(this))
    {
    case 6: 
    default: 
      localObject3 = new Button(this);
      this.downloadSkins = ((Button)localObject3);
      this.downloadSkins.setWidth(-1);
      this.downloadSkins.setHeight(convertDip(48));
      this.downloadSkins.setText((CharSequence)localObject2);
      this.downloadSkins.setBackgroundResource(this.downloadBackground);
      this.downloadSkins.setTextColor(-1);
      this.downloadSkins.setTextSize(18.0F);
      this.downloadSkins.setTypeface(Typeface.DEFAULT_BOLD);
      localObject2 = this.downloadSkins;
      localObject3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!RunTimeConfig.isFullVersion(ConfigurationActivity.this)) {
            RunTimeConfig.showBuyDialog(ConfigurationActivity.this, false, R.string.skins_upgrade_message);
          } else {
            SettingsActivity.showDownloadSkinsDialog(ConfigurationActivity.this);
          }
        }
      };
      ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(convertDip(10), 0, convertDip(10), 0);
      ((LinearLayout)localObject1).addView(this.downloadSkins, (ViewGroup.LayoutParams)localObject2);
    }
    if (j == 0)
    {
      localObject2 = new Button(this);
      this.okButton = ((Button)localObject2);
    }
    else
    {
      localObject2 = new Button(this, null, 16842824);
      this.okButton = ((Button)localObject2);
    }
    this.okButton.setId(400);
    this.okButton.setWidth(0);
    this.okButton.setHeight(-2);
    localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
    this.okButton.setText(R.string.configuration_addWidget);
    localLinearLayout.addView(this.okButton, (ViewGroup.LayoutParams)localObject2);
    Button localButton;
    if (j == 0)
    {
      localButton = new Button(this);
      this.cancelButton = localButton;
    }
    else
    {
      localButton = new Button(this, null, 16842824);
      this.cancelButton = localButton;
    }
    this.cancelButton.setWidth(0);
    this.cancelButton.setHeight(-2);
    this.cancelButton.setText(R.string.cancel);
    localLinearLayout.addView(this.cancelButton, (ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView(localLinearLayout, localLayoutParams2);
    localScrollView.addView((View)localObject1, localLayoutParams);
    localRelativeLayout.addView(localScrollView);
    addContentView(localRelativeLayout, localLayoutParams1);
  }
  
  private void loadListeners()
  {
    this.minutes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousInt != 0)
        {
          String str = ConfigurationActivity.this.counter.getContext().getString(R.string.configuration_everyMin);
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousInt);
          str = String.format(str, arrayOfObject);
          ConfigurationActivity.this.counter.setText(str);
        }
        else
        {
          ConfigurationActivity.this.counter.setText(R.string.configuration_neverUpdate);
        }
        ConfigurationActivity.access$202(ConfigurationActivity.this, paramAnonymousInt);
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    this.okButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConfigurationActivity.this.settings.editTemp().putInt("widgetId", ConfigurationActivity.this.mAppWidgetId).commit();
        ConfigurationActivity.this.settings.edit().putInt("refreshRate", ConfigurationActivity.this.refreshRate).putString("widgetSkin", ConfigurationActivity.this.widgetSkin).putBoolean("widgetTransparent", ConfigurationActivity.this.isTransparent).commit();
        OldAPIHelper.dataChanged(jdField_this);
        String str = AppWidgetManager.getInstance(ConfigurationActivity.this).getAppWidgetInfo(ConfigurationActivity.this.mAppWidgetId).provider.getClassName().toString();
        boolean bool = false;
        if (str.equals(Mainsmall.class.getName())) {
          bool = true;
        }
        ConfigurationActivity.this.settings.editTemp().putBoolean("isSmall", bool).putBoolean("isNew", true).putBoolean("isNewSkin", true).commit();
        ConfigurationActivity.this.doWidgetAddTrack(bool, ConfigurationActivity.this.isTransparent);
        ConfigurationActivity.this.startService(new Intent(jdField_this, UpdateService.class));
        ConfigurationActivity.this.setConfigureResult(-1);
        ConfigurationActivity.this.finish();
      }
    });
    this.cancelButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConfigurationActivity.this.finish();
      }
    });
    if (this.skins != null) {
      this.skins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          ConfigurationActivity.access$502(ConfigurationActivity.this, (String)ConfigurationActivity.this.skinsData.keySet().toArray()[paramAnonymousInt]);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
    }
  }
  
  private void setLayoutTheme()
  {
    String str = new SettingsManager(this).getTheme();
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
              if (str.equals("darkPink"))
              {
                if (!MiscUtils.isAtLeastLargeHC(this)) {
                  setTheme(R.style.Theme_AudioManager_Dark_Pink);
                } else {
                  setTheme(R.style.Theme_AudioManager_Dark_Pink_DialogWhenLarge);
                }
                this.spinnerBackground = R.drawable.spinner_background_ab_am_pink;
                this.downloadBackground = R.drawable.selectable_background_am_pink;
              }
            }
            else
            {
              if (!MiscUtils.isAtLeastLargeHC(this)) {
                setTheme(R.style.Theme_AudioManager_Dark_Yellow);
              } else {
                setTheme(R.style.Theme_AudioManager_Dark_Yellow_DialogWhenLarge);
              }
              this.spinnerBackground = R.drawable.spinner_background_ab_am_yellow;
              this.downloadBackground = R.drawable.selectable_background_am_yellow;
            }
          }
          else
          {
            if (!MiscUtils.isAtLeastLargeHC(this)) {
              setTheme(R.style.Theme_AudioManager_Dark_Green);
            } else {
              setTheme(R.style.Theme_AudioManager_Dark_Green_DialogWhenLarge);
            }
            this.spinnerBackground = R.drawable.spinner_background_ab_am_green;
            this.downloadBackground = R.drawable.selectable_background_am_green;
          }
        }
        else
        {
          if (!MiscUtils.isAtLeastLargeHC(this)) {
            setTheme(R.style.Theme_AudioManager_Dark_Red);
          } else {
            setTheme(R.style.Theme_AudioManager_Dark_Red_DialogWhenLarge);
          }
          this.spinnerBackground = R.drawable.spinner_background_ab_am_red;
          this.downloadBackground = R.drawable.selectable_background_am_red;
        }
      }
      else
      {
        if (!MiscUtils.isAtLeastLargeHC(this)) {
          setTheme(R.style.Theme_AudioManager);
        } else {
          setTheme(R.style.Theme_AudioManager_DialogWhenLarge);
        }
        this.spinnerBackground = R.drawable.spinner_background_holo_light_green;
        this.downloadBackground = R.drawable.selectable_background_am_green;
      }
    }
    else
    {
      if (!MiscUtils.isAtLeastLargeHC(this)) {
        setTheme(R.style.Theme_AudioManager_Dark_Blue);
      } else {
        setTheme(R.style.Theme_AudioManager_Dark_Blue_DialogWhenLarge);
      }
      this.spinnerBackground = R.drawable.spinner_background_holo_dark_blue;
      this.downloadBackground = R.drawable.selectable_background_am_blue;
    }
  }
  
  public int convertDip(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    int j = localDisplayMetrics.widthPixels;
    if ((i <= 480) || (j <= 320))
    {
      if ((i < 480) && (j < 320)) {
        paramInt = (int)(paramInt / 1.5D);
      }
    }
    else {
      paramInt = (int)(1.5D * paramInt);
    }
    return paramInt;
  }
  
  protected void doWidgetAddTrack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setLayoutTheme();
    requestWindowFeature(1);
    setConfigureResult(0);
    this.settings = new SettingsManager(this);
    this.mAppWidgetId = this.settings.getInt("widgetId", this.mAppWidgetId);
    this.widgetSkin = this.settings.getString("widgetSkin", "Original");
    this.isTransparent = this.settings.getBoolean("widgetTransparent", false);
    this.refreshRate = 0;
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      this.mAppWidgetId = localBundle.getInt("appWidgetId", 0);
    }
    if (this.mAppWidgetId == 0) {
      finish();
    }
    loadLayout();
    loadListeners();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onStop()
  {
    finish();
    super.onStop();
  }
  
  public void setConfigureResult(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("appWidgetId", this.mAppWidgetId);
    setResult(paramInt, localIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.ConfigurationActivity
 * JD-Core Version:    0.7.0.1
 */
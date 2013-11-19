package com.sonyericsson.extras.liveware.preference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsTurnOffActivity;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class SettingsFragment
  extends PreferenceFragment
{
  private Activity mActivity;
  private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener()
  {
    public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
    {
      if (paramAnonymousString.equals(SettingsFragment.this.mActivity.getString(2131099736))) {
        SettingsFragment.this.reloadPreferences();
      }
    }
  };
  private SharedPreferences mSharedPreferences;
  
  private void reloadPreferences()
  {
    setPreferenceScreen(null);
    addPreferencesFromResource(2130968576);
    if (SmartConnectAnalytics.isSomcSettingAvailable(this.mActivity)) {
      ((PreferenceGroup)findPreference(getString(2131099734))).removePreference(findPreference(getString(2131099735)));
    }
    findPreference(getString(2131099736)).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
    {
      public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        Intent localIntent = new Intent(SettingsFragment.this.mActivity, TtsSmsTurnOffActivity.class);
        SettingsFragment.this.mActivity.startActivity(localIntent);
        return false;
      }
    });
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    UIUtils.applyDirectionality(localView);
    return localView;
  }
  
  public void onPause()
  {
    super.onPause();
    this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
  }
  
  public void onResume()
  {
    super.onResume();
    reloadPreferences();
    this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.preference.SettingsFragment
 * JD-Core Version:    0.7.0.1
 */
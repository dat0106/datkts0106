package com.sonyericsson.extras.liveware.actions.music;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.ui.BaseActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicSettings
  extends BaseActivity
{
  public static final String MUSIC_PATH = "music_path";
  public static final String MUSIC_TRACK = "music_track";
  public static final String PAUSE_SETTING = "pause";
  public static final String PLAY_NEXT_SETTING = "play_next";
  public static final String PLAY_SETTING = "play";
  public static final String PLAY_TRACK_SETTING = "play_track_setting";
  public static final String SETTINGS_KEY = "music_settings";
  private static final int TRACK_SETTING = 107701;
  private RadioGroup mRadioGroup;
  private String mRawSetting;
  
  public static String buildRawSetting(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("music_settings", paramString1);
      if ((paramString2 != null) && (paramString3 != null) && ("play_track_setting".equals(paramString1)))
      {
        localJSONObject.put("music_path", paramString2);
        localJSONObject.put("music_track", paramString3);
      }
      str = localJSONObject.toString();
      str = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
    return str;
  }
  
  private void initList()
  {
    this.mRadioGroup = ((RadioGroup)findViewById(2131558486));
    TextView localTextView = (TextView)findViewById(2131558490);
    if (TextUtils.isEmpty(this.mRawSetting)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      return;
      String str2;
      try
      {
        JSONObject localJSONObject = new JSONObject(this.mRawSetting);
        str2 = localJSONObject.getString("music_settings");
        if (!str2.equalsIgnoreCase("play")) {
          break label101;
        }
        this.mRadioGroup.check(2131558487);
        localTextView.setVisibility(8);
      }
      catch (JSONException localJSONException)
      {
        Dbg.e(localJSONException);
        localTextView.setVisibility(8);
      }
      continue;
      label101:
      if (str2.equalsIgnoreCase("play_next"))
      {
        this.mRadioGroup.check(2131558488);
        localTextView.setVisibility(8);
      }
      else if (str2.equalsIgnoreCase("pause"))
      {
        this.mRadioGroup.check(2131558489);
        localTextView.setVisibility(8);
      }
      else if (str2.equalsIgnoreCase("play_track_setting"))
      {
        String str1 = localJSONException.optString("music_track", "");
        if (TextUtils.isEmpty(str1))
        {
          this.mRadioGroup.check(2131558487);
          localTextView.setVisibility(8);
        }
        else
        {
          localTextView.setVisibility(0);
          localTextView.setText(str1);
          this.mRadioGroup.check(2131558491);
        }
      }
      else
      {
        localTextView.setVisibility(8);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 107701) {
      if (paramInt2 != -1)
      {
        initList();
      }
      else if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        if ((localBundle != null) && (localBundle.containsKey("setting_raw"))) {
          ActionUtils.finishActivityWithSetting(this, localBundle.getString("setting_raw"), localBundle.getString("setting_label"));
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    setContentView(2130903074);
    setTitle(2131099850);
    initList();
    getActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
  
  public void onPauseSelected(View paramView)
  {
    this.mRadioGroup.check(2131558489);
    String str = buildRawSetting("pause", null, null);
    ActionUtils.finishActivityWithSetting(this, str, PlayAction.getLabelByRawSetting(this, str));
  }
  
  public void onPlayNextSelected(View paramView)
  {
    this.mRadioGroup.check(2131558488);
    String str = buildRawSetting("play_next", null, null);
    ActionUtils.finishActivityWithSetting(this, str, PlayAction.getLabelByRawSetting(this, str));
  }
  
  public void onPlaySelected(View paramView)
  {
    this.mRadioGroup.check(2131558487);
    String str = buildRawSetting("play", null, null);
    ActionUtils.finishActivityWithSetting(this, str, PlayAction.getLabelByRawSetting(this, str));
  }
  
  public void onPlayTrackSelected(View paramView)
  {
    Intent localIntent = new Intent(this, TrackSettings.class);
    localIntent.putExtra("internal_content", false);
    localIntent.putExtra("setting_raw", this.mRawSetting);
    startActivityForResult(localIntent, 107701);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.MusicSettings
 * JD-Core Version:    0.7.0.1
 */
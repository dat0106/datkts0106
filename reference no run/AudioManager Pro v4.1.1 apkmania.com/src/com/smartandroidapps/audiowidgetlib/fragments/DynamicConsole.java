package com.smartandroidapps.audiowidgetlib.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.raw;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import com.smartandroidapps.audiowidgetlib.util.OldAPIHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicConsole
  extends SherlockFragment
  implements Constants
{
  private static ArrayList<Stream> streams;
  private int alarmIcon;
  private Button alarm_ringtone;
  private SeekBar alarmbar;
  private TextView alarmlevel;
  private SeekBar alertbar;
  private TextView alertlevel;
  private int alertsIcon;
  private AudioManager am;
  private int arrowIcon;
  private Context context;
  private RelativeLayout controlholder;
  private Typeface digit;
  private int labelColor;
  private SettingsManager mSettingsManager;
  private ToneGenerator mToneGenerator;
  private int mediaIcon;
  private SeekBar musicbar;
  private TextView musiclevel;
  private Button notification_ringtone;
  private int panelBackground;
  private RelativeLayout parent;
  private int placebelow = -1;
  private int ringerIcon;
  private Button ringer_ringtone;
  private SeekBar ringerbar;
  private TextView ringerlevel;
  private int spinnerBackground;
  private int systemIcon;
  private SeekBar systembar;
  private TextView systemlevel;
  private int viewids = 1;
  private int voiceIcon;
  private SeekBar voicebar;
  private TextView voicelevel;
  private boolean volumizer;
  
  private void addAlarm(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView1 = new TextView(getActivity());
    localTextView1.setText(R.string.alarmLabel);
    localTextView1.setTextColor(this.labelColor);
    localTextView1.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.alarmIcon), null, getActivity().getResources().getDrawable(this.arrowIcon), null);
    localTextView1.setCompoundDrawablePadding(5);
    localTextView1.setGravity(16);
    localTextView1.setTypeface(null, 1);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView1.setId(i);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    if (this.placebelow == -1)
    {
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(10), 0, 0);
    }
    else
    {
      localLayoutParams1.addRule(3, this.placebelow);
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView1, localLayoutParams1);
    this.alarm_ringtone = new Button(getActivity());
    this.alarm_ringtone.setTextSize(14.0F);
    this.alarm_ringtone.setSingleLine();
    this.alarm_ringtone.setEllipsize(TextUtils.TruncateAt.END);
    this.alarm_ringtone.setBackgroundResource(this.spinnerBackground);
    this.alarm_ringtone.setTextColor(this.labelColor);
    this.alarm_ringtone.setGravity(16);
    this.alarm_ringtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", DynamicConsole.this.getActivity().getText(R.string.alarm_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", RingtoneManager.getActualDefaultRingtoneUri(DynamicConsole.this.getActivity(), 4));
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 4);
        DynamicConsole.this.getActivity().startActivityForResult(localIntent, 1002);
      }
    });
    if (!areRingtonesAvailable()) {
      this.alarm_ringtone.setEnabled(false);
    }
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, dpToPx(33));
    localLayoutParams1.setMargins(dpToPx(6), 0, dpToPx(10), 0);
    localLayoutParams1.addRule(1, localTextView1.getId());
    localLayoutParams1.addRule(4, localTextView1.getId());
    paramRelativeLayout.addView(this.alarm_ringtone, localLayoutParams1);
    this.alarmlevel = new TextView(getActivity());
    this.alarmlevel.setGravity(5);
    this.alarmlevel.setMinimumWidth(dpToPx(35));
    this.alarmlevel.setTextColor(Color.parseColor("#999999"));
    this.alarmlevel.setTextSize(20.0F);
    this.alarmlevel.setTypeface(this.digit);
    TextView localTextView2 = this.alarmlevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    localTextView2.setId(j);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(11, -1);
    localLayoutParams2.setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.alarmlevel, localLayoutParams2);
    this.alarmbar = new SeekBar(getActivity());
    this.alarmbar.setFocusable(true);
    this.alarmbar.setIndeterminate(false);
    this.alarmbar.setMinimumHeight(dpToPx(13));
    this.alarmbar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.alarmbar.setSoundEffectsEnabled(true);
    this.alarmbar.setThumbOffset(dpToPx(16));
    this.alarmbar.setMax(this.am.getStreamMaxVolume(4));
    this.alarmbar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(4, this.alarmlevel));
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.setMargins(dpToPx(8), 0, 0, 0);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(0, this.alarmlevel.getId());
    paramRelativeLayout.addView(this.alarmbar, localLayoutParams2);
    streams.add(new Stream(4, 0, this.alarmbar, this.alarmlevel));
    this.placebelow = localTextView1.getId();
  }
  
  private void addAlert(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(R.string.alertsLabel);
    localTextView.setTextColor(this.labelColor);
    localTextView.setTypeface(null, 1);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.alertsIcon), null, getActivity().getResources().getDrawable(this.arrowIcon), null);
    localTextView.setCompoundDrawablePadding(5);
    localTextView.setGravity(16);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView.setId(i);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    if (this.placebelow == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(5), 0, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.placebelow);
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    this.notification_ringtone = new Button(getActivity());
    this.notification_ringtone.setTextSize(14.0F);
    this.notification_ringtone.setSingleLine();
    this.notification_ringtone.setEllipsize(TextUtils.TruncateAt.END);
    this.notification_ringtone.setBackgroundResource(this.spinnerBackground);
    this.notification_ringtone.setTextColor(this.labelColor);
    this.notification_ringtone.setGravity(16);
    this.notification_ringtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", DynamicConsole.this.getActivity().getText(R.string.notification_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", RingtoneManager.getActualDefaultRingtoneUri(DynamicConsole.this.getActivity(), 2));
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        DynamicConsole.this.getActivity().startActivityForResult(localIntent, 1001);
      }
    });
    if (!areRingtonesAvailable()) {
      this.notification_ringtone.setEnabled(false);
    }
    localObject = new RelativeLayout.LayoutParams(-2, dpToPx(33));
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(6), 0, dpToPx(10), 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(4, localTextView.getId());
    paramRelativeLayout.addView(this.notification_ringtone, (ViewGroup.LayoutParams)localObject);
    this.alertlevel = new TextView(getActivity());
    this.alertlevel.setGravity(5);
    this.alertlevel.setMinimumWidth(dpToPx(35));
    this.alertlevel.setTextColor(Color.parseColor("#999999"));
    this.alertlevel.setTextSize(20.0F);
    this.alertlevel.setTypeface(this.digit);
    localObject = this.alertlevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    ((TextView)localObject).setId(j);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.alertlevel, (ViewGroup.LayoutParams)localObject);
    this.alertbar = new SeekBar(getActivity());
    this.alertbar.setFocusable(true);
    this.alertbar.setIndeterminate(false);
    this.alertbar.setMinimumHeight(dpToPx(13));
    this.alertbar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.alertbar.setSoundEffectsEnabled(true);
    this.alertbar.setThumbOffset(dpToPx(16));
    this.alertbar.setMax(this.am.getStreamMaxVolume(5));
    this.alertbar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(5, this.alertlevel));
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(8), 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(0, this.alertlevel.getId());
    paramRelativeLayout.addView(this.alertbar, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(4, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(1, localTextView.getId());
    if (this.placebelow == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(10), dpToPx(5), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(10), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.placebelow);
    }
    streams.add(new Stream(5, 0, this.alertbar, this.alertlevel));
    this.placebelow = localTextView.getId();
  }
  
  private void addMusic(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView1 = new TextView(getActivity());
    localTextView1.setText(R.string.musicLabel);
    localTextView1.setTextColor(this.labelColor);
    localTextView1.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.mediaIcon), null, null, null);
    localTextView1.setCompoundDrawablePadding(5);
    localTextView1.setGravity(16);
    localTextView1.setTypeface(null, 1);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView1.setId(i);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    if (this.placebelow == -1)
    {
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(5), 0, 0);
    }
    else
    {
      localLayoutParams1.addRule(3, this.placebelow);
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView1, localLayoutParams1);
    this.musiclevel = new TextView(getActivity());
    this.musiclevel.setGravity(5);
    this.musiclevel.setMinimumWidth(dpToPx(35));
    this.musiclevel.setTextColor(Color.parseColor("#999999"));
    this.musiclevel.setTextSize(20.0F);
    this.musiclevel.setTypeface(this.digit);
    TextView localTextView2 = this.musiclevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    localTextView2.setId(j);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(11, -1);
    localLayoutParams2.setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.musiclevel, localLayoutParams2);
    this.musicbar = new SeekBar(getActivity());
    this.musicbar.setFocusable(true);
    this.musicbar.setIndeterminate(false);
    this.musicbar.setMinimumHeight(dpToPx(13));
    this.musicbar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.musicbar.setSoundEffectsEnabled(true);
    this.musicbar.setThumbOffset(dpToPx(16));
    this.musicbar.setMax(this.am.getStreamMaxVolume(3));
    this.musicbar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(3, this.musiclevel));
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.setMargins(dpToPx(8), 0, 0, 0);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(0, this.musiclevel.getId());
    paramRelativeLayout.addView(this.musicbar, localLayoutParams2);
    streams.add(new Stream(3, 0, this.musicbar, this.musiclevel));
    this.placebelow = localTextView1.getId();
  }
  
  private void addRinger(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(R.string.ringerLabel);
    localTextView.setTypeface(null, 1);
    localTextView.setTextColor(this.labelColor);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.ringerIcon), null, getActivity().getResources().getDrawable(this.arrowIcon), null);
    localTextView.setCompoundDrawablePadding(5);
    localTextView.setGravity(16);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView.setId(i);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    if (this.placebelow == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(5), 0, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.placebelow);
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    this.ringer_ringtone = new Button(getActivity());
    this.ringer_ringtone.setTextSize(14.0F);
    this.ringer_ringtone.setSingleLine();
    this.ringer_ringtone.setEllipsize(TextUtils.TruncateAt.END);
    this.ringer_ringtone.setBackgroundResource(this.spinnerBackground);
    this.ringer_ringtone.setTextColor(this.labelColor);
    this.ringer_ringtone.setGravity(16);
    this.ringer_ringtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", DynamicConsole.this.getActivity().getText(R.string.phone_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", RingtoneManager.getActualDefaultRingtoneUri(DynamicConsole.this.getActivity(), 1));
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 1);
        DynamicConsole.this.getActivity().startActivityForResult(localIntent, 1000);
      }
    });
    if (!areRingtonesAvailable()) {
      this.ringer_ringtone.setEnabled(false);
    }
    localObject = new RelativeLayout.LayoutParams(-2, dpToPx(33));
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(6), 0, dpToPx(10), 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(4, localTextView.getId());
    paramRelativeLayout.addView(this.ringer_ringtone, (ViewGroup.LayoutParams)localObject);
    this.ringerlevel = new TextView(getActivity());
    this.ringerlevel.setGravity(5);
    this.ringerlevel.setMinimumWidth(dpToPx(35));
    this.ringerlevel.setTextColor(Color.parseColor("#999999"));
    this.ringerlevel.setTextSize(20.0F);
    this.ringerlevel.setTypeface(this.digit);
    localObject = this.ringerlevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    ((TextView)localObject).setId(j);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.ringerlevel, (ViewGroup.LayoutParams)localObject);
    this.ringerbar = new SeekBar(getActivity());
    this.ringerbar.setFocusable(true);
    this.ringerbar.setIndeterminate(false);
    this.ringerbar.setMinimumHeight(dpToPx(13));
    this.ringerbar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.ringerbar.setSoundEffectsEnabled(true);
    this.ringerbar.setThumbOffset(dpToPx(16));
    this.ringerbar.setMax(this.am.getStreamMaxVolume(2));
    this.ringerbar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(2, this.ringerlevel));
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(8), 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localTextView.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(0, this.ringerlevel.getId());
    paramRelativeLayout.addView(this.ringerbar, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, localTextView.getId());
    if (this.placebelow == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(35), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(dpToPx(15), dpToPx(30), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.placebelow);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(4, localTextView.getId());
    if (this.placebelow == -1)
    {
      localLayoutParams.setMargins(dpToPx(15), dpToPx(5), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    }
    else
    {
      localLayoutParams.setMargins(dpToPx(15), 0, 0, 0);
      localLayoutParams.addRule(3, this.placebelow);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (this.placebelow == -1)
    {
      localLayoutParams.setMargins(dpToPx(15), dpToPx(30), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    }
    else
    {
      localLayoutParams.setMargins(dpToPx(15), dpToPx(25), 0, 0);
      localLayoutParams.addRule(3, this.placebelow);
    }
    streams.add(new Stream(2, 0, this.ringerbar, this.ringerlevel));
    this.placebelow = localTextView.getId();
  }
  
  private void addSystem(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView1 = new TextView(getActivity());
    localTextView1.setText(R.string.systemLabel);
    localTextView1.setTypeface(null, 1);
    localTextView1.setTextColor(this.labelColor);
    localTextView1.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.systemIcon), null, null, null);
    localTextView1.setCompoundDrawablePadding(5);
    localTextView1.setGravity(16);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView1.setId(i);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    if (this.placebelow == -1)
    {
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(5), 0, 0);
    }
    else
    {
      localLayoutParams1.addRule(3, this.placebelow);
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView1, localLayoutParams1);
    this.systemlevel = new TextView(getActivity());
    this.systemlevel.setGravity(5);
    this.systemlevel.setMinimumWidth(dpToPx(35));
    this.systemlevel.setTextColor(Color.parseColor("#999999"));
    this.systemlevel.setTextSize(20.0F);
    this.systemlevel.setTypeface(this.digit);
    TextView localTextView2 = this.systemlevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    localTextView2.setId(j);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(11, -1);
    localLayoutParams2.setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.systemlevel, localLayoutParams2);
    this.systembar = new SeekBar(getActivity());
    this.systembar.setFocusable(true);
    this.systembar.setIndeterminate(false);
    this.systembar.setMinimumHeight(dpToPx(13));
    this.systembar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.systembar.setSoundEffectsEnabled(true);
    this.systembar.setThumbOffset(dpToPx(16));
    this.systembar.setMax(this.am.getStreamMaxVolume(1));
    this.systembar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(1, this.systemlevel));
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.setMargins(dpToPx(8), 0, 0, 0);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(0, this.systemlevel.getId());
    paramRelativeLayout.addView(this.systembar, localLayoutParams2);
    streams.add(new Stream(1, 0, this.systembar, this.systemlevel));
    this.placebelow = localTextView1.getId();
  }
  
  private void addVoice(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView1 = new TextView(getActivity());
    localTextView1.setText(R.string.voicecallLabel);
    localTextView1.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(this.voiceIcon), null, null, null);
    localTextView1.setCompoundDrawablePadding(5);
    localTextView1.setTextColor(this.labelColor);
    localTextView1.setGravity(16);
    localTextView1.setTypeface(null, 1);
    int i = this.viewids;
    this.viewids = (i + 1);
    localTextView1.setId(i);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    if (this.placebelow == -1)
    {
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(5), 0, 0);
    }
    else
    {
      localLayoutParams1.addRule(3, this.placebelow);
      localLayoutParams1.setMargins(dpToPx(15), dpToPx(44), 0, 0);
    }
    paramRelativeLayout.addView(localTextView1, localLayoutParams1);
    this.voicelevel = new TextView(getActivity());
    this.voicelevel.setGravity(5);
    this.voicelevel.setMinimumWidth(dpToPx(35));
    this.voicelevel.setTextColor(Color.parseColor("#999999"));
    this.voicelevel.setTextSize(20.0F);
    this.voicelevel.setTypeface(this.digit);
    TextView localTextView2 = this.voicelevel;
    int j = this.viewids;
    this.viewids = (j + 1);
    localTextView2.setId(j);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(11, -1);
    localLayoutParams2.setMargins(dpToPx(2), dpToPx(4), dpToPx(14), 0);
    paramRelativeLayout.addView(this.voicelevel, localLayoutParams2);
    this.voicebar = new SeekBar(getActivity());
    this.voicebar.setFocusable(true);
    this.voicebar.setIndeterminate(false);
    this.voicebar.setMinimumHeight(dpToPx(13));
    this.voicebar.setPadding(dpToPx(16), 0, dpToPx(16), 0);
    this.voicebar.setSoundEffectsEnabled(true);
    this.voicebar.setThumbOffset(dpToPx(16));
    this.voicebar.setMax(this.am.getStreamMaxVolume(0));
    this.voicebar.setOnSeekBarChangeListener(new OnAudioSeekBarListener(0, this.voicelevel));
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.setMargins(dpToPx(8), 0, 0, 0);
    localLayoutParams2.addRule(3, localTextView1.getId());
    localLayoutParams2.addRule(0, this.voicelevel.getId());
    paramRelativeLayout.addView(this.voicebar, localLayoutParams2);
    streams.add(new Stream(0, 0, this.voicebar, this.voicelevel));
    this.placebelow = localTextView1.getId();
  }
  
  private boolean areRingtonesAvailable()
  {
    boolean bool;
    if (new RingtoneManager(getActivity()).getCursor().getCount() <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void createUI()
  {
    boolean bool2 = OldAPIHelper.hasSystemTelephony(getActivity().getPackageManager());
    boolean bool1 = MiscUtils.isNotificationAlwaysLinked(getActivity().getContentResolver(), getActivity(), true);
    this.digit = MiscUtils.CreateTypefaceFromRawResource(getActivity(), R.raw.digital);
    this.placebelow = -1;
    streams.clear();
    this.controlholder.removeAllViews();
    if (getActivity() != null)
    {
      addAlarm(this.controlholder);
      addMusic(this.controlholder);
      if (!bool2)
      {
        addAlert(this.controlholder);
      }
      else
      {
        addRinger(this.controlholder);
        if (!bool1) {
          addAlert(this.controlholder);
        }
      }
      addSystem(this.controlholder);
      addVoice(this.controlholder);
    }
  }
  
  private int dpToPx(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  private RelativeLayout generateLayout()
  {
    this.parent = new RelativeLayout(getActivity());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.parent.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(getActivity());
    int i = this.viewids;
    this.viewids = (i + 1);
    ((RelativeLayout)localObject1).setId(i);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    this.parent.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (MiscUtils.isAtLeastLargeHC(this.context))
    {
      this.parent.setBackgroundResource(this.panelBackground);
      localObject2 = new TextView(this.context);
      ((TextView)localObject2).setPadding(dpToPx(20), dpToPx(10), dpToPx(20), dpToPx(10));
      ((TextView)localObject2).setText(R.string.volume_menu_title);
      ((TextView)localObject2).setTypeface(null, 1);
      ((TextView)localObject2).setTextColor(this.labelColor);
      ((TextView)localObject2).setTextSize(18.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10, -1);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    }
    localObject2 = new ScrollView(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, ((RelativeLayout)localObject1).getId());
    this.parent.addView((View)localObject2, localLayoutParams);
    this.controlholder = new RelativeLayout(getActivity());
    this.controlholder.setPadding(0, 0, 0, dpToPx(10));
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((ScrollView)localObject2).addView(this.controlholder, (ViewGroup.LayoutParams)localObject1);
    return this.parent;
  }
  
  public static ArrayList<Integer> getActiveStreams(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (OldAPIHelper.hasSystemTelephony(paramContext.getPackageManager())) {
      i = 1;
    }
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    boolean bool = true;
    if (i != 0) {
      bool = MiscUtils.isNotificationAndRingerLinked(paramContext.getContentResolver(), paramContext, true);
    }
    if (localAudioManager.getRingerMode() != 2)
    {
      localArrayList.add(Integer.valueOf(4));
      if (i == 0)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          localArrayList.add(Integer.valueOf(3));
        }
      }
      else
      {
        localArrayList.add(Integer.valueOf(3));
        if (Build.VERSION.SDK_INT >= 14) {
          localArrayList.add(Integer.valueOf(2));
        }
      }
      localArrayList.add(Integer.valueOf(0));
    }
    else
    {
      localArrayList.add(Integer.valueOf(4));
      localArrayList.add(Integer.valueOf(3));
      if (i == 0)
      {
        localArrayList.add(Integer.valueOf(5));
      }
      else
      {
        localArrayList.add(Integer.valueOf(2));
        if (!bool) {
          localArrayList.add(Integer.valueOf(5));
        }
      }
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(0));
    }
    return localArrayList;
  }
  
  private void setAlarmRingtone()
  {
    String str;
    if (this.alarm_ringtone != null) {
      str = this.context.getString(R.string.profile_none_applied);
    }
    for (;;)
    {
      try
      {
        localObject = RingtoneManager.getActualDefaultRingtoneUri(getActivity(), 4);
        if (localObject != null) {
          continue;
        }
        str = this.context.getString(R.string.silent_button);
        str = str;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject;
        continue;
      }
      this.alarm_ringtone.setText(str);
      return;
      localObject = RingtoneManager.getRingtone(this.context, (Uri)localObject);
      if (localObject != null)
      {
        str = ((Ringtone)localObject).getTitle(this.context);
        str = str;
      }
    }
  }
  
  private void setLayoutTheme()
  {
    String str = new SettingsManager(getActivity()).getTheme();
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
                this.labelColor = Color.parseColor("#ffffff");
                this.alarmIcon = R.drawable.alarm_icon_dark;
                this.mediaIcon = R.drawable.media_icon_dark;
                this.ringerIcon = R.drawable.ringer_icon_dark;
                this.alertsIcon = R.drawable.alerts_icon_dark;
                this.systemIcon = R.drawable.system_icon_dark;
                this.voiceIcon = R.drawable.voice_icon_dark;
                this.arrowIcon = R.drawable.arrow_right_dark;
                this.spinnerBackground = R.drawable.spinner_background_ab_am_pink;
                this.panelBackground = R.drawable.panel_background;
              }
            }
            else
            {
              this.labelColor = Color.parseColor("#ffffff");
              this.alarmIcon = R.drawable.alarm_icon_dark;
              this.mediaIcon = R.drawable.media_icon_dark;
              this.ringerIcon = R.drawable.ringer_icon_dark;
              this.alertsIcon = R.drawable.alerts_icon_dark;
              this.systemIcon = R.drawable.system_icon_dark;
              this.voiceIcon = R.drawable.voice_icon_dark;
              this.arrowIcon = R.drawable.arrow_right_dark;
              this.spinnerBackground = R.drawable.spinner_background_ab_am_yellow;
              this.panelBackground = R.drawable.panel_background;
            }
          }
          else
          {
            this.labelColor = Color.parseColor("#ffffff");
            this.alarmIcon = R.drawable.alarm_icon_dark;
            this.mediaIcon = R.drawable.media_icon_dark;
            this.ringerIcon = R.drawable.ringer_icon_dark;
            this.alertsIcon = R.drawable.alerts_icon_dark;
            this.systemIcon = R.drawable.system_icon_dark;
            this.voiceIcon = R.drawable.voice_icon_dark;
            this.arrowIcon = R.drawable.arrow_right_dark;
            this.spinnerBackground = R.drawable.spinner_background_ab_am_green;
            this.panelBackground = R.drawable.panel_background;
          }
        }
        else
        {
          this.labelColor = Color.parseColor("#ffffff");
          this.alarmIcon = R.drawable.alarm_icon_dark;
          this.mediaIcon = R.drawable.media_icon_dark;
          this.ringerIcon = R.drawable.ringer_icon_dark;
          this.alertsIcon = R.drawable.alerts_icon_dark;
          this.systemIcon = R.drawable.system_icon_dark;
          this.voiceIcon = R.drawable.voice_icon_dark;
          this.arrowIcon = R.drawable.arrow_right_dark;
          this.spinnerBackground = R.drawable.spinner_background_ab_am_red;
          this.panelBackground = R.drawable.panel_background;
        }
      }
      else
      {
        this.labelColor = Color.parseColor("#000000");
        this.alarmIcon = R.drawable.alarm_icon;
        this.mediaIcon = R.drawable.media_icon;
        this.ringerIcon = R.drawable.ringer_icon;
        this.alertsIcon = R.drawable.alerts_icon;
        this.systemIcon = R.drawable.system_icon;
        this.voiceIcon = R.drawable.voice_icon;
        this.arrowIcon = R.drawable.arrow_right;
        this.spinnerBackground = R.drawable.spinner_background_holo_light_green;
        this.panelBackground = R.drawable.panel_bg_holo_light;
      }
    }
    else
    {
      this.labelColor = Color.parseColor("#ffffff");
      this.alarmIcon = R.drawable.alarm_icon_dark;
      this.mediaIcon = R.drawable.media_icon_dark;
      this.ringerIcon = R.drawable.ringer_icon_dark;
      this.alertsIcon = R.drawable.alerts_icon_dark;
      this.systemIcon = R.drawable.system_icon_dark;
      this.voiceIcon = R.drawable.voice_icon_dark;
      this.arrowIcon = R.drawable.arrow_right_dark;
      this.spinnerBackground = R.drawable.spinner_background_holo_dark_blue;
      this.panelBackground = R.drawable.panel_background;
    }
  }
  
  private void setNotificationRingtone()
  {
    String str;
    if (this.notification_ringtone != null) {
      str = this.context.getString(R.string.profile_none_applied);
    }
    for (;;)
    {
      try
      {
        localObject = RingtoneManager.getActualDefaultRingtoneUri(getActivity(), 2);
        if (localObject != null) {
          continue;
        }
        str = this.context.getString(R.string.silent_button);
        str = str;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject;
        continue;
      }
      this.notification_ringtone.setText(str);
      return;
      localObject = RingtoneManager.getRingtone(this.context, (Uri)localObject);
      if (localObject != null)
      {
        str = ((Ringtone)localObject).getTitle(this.context);
        str = str;
      }
    }
  }
  
  private void setPhoneRingtone()
  {
    String str;
    if (this.ringer_ringtone != null) {
      str = this.context.getString(R.string.profile_none_applied);
    }
    for (;;)
    {
      try
      {
        localObject = RingtoneManager.getActualDefaultRingtoneUri(getActivity(), 1);
        if (localObject != null) {
          continue;
        }
        str = this.context.getString(R.string.silent_button);
        str = str;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject;
        continue;
      }
      this.ringer_ringtone.setText(str);
      return;
      localObject = RingtoneManager.getRingtone(this.context, (Uri)localObject);
      if (localObject != null)
      {
        str = ((Ringtone)localObject).getTitle(this.context);
        str = str;
      }
    }
  }
  
  public void doUIUpdate()
  {
    boolean bool2 = false;
    boolean bool1 = MiscUtils.isNotificationAndRingerLinked(getActivity().getContentResolver(), getActivity(), true);
    boolean bool3 = OldAPIHelper.hasSystemTelephony(getActivity().getPackageManager());
    if (this.am.getRingerMode() != 2)
    {
      this.alarmbar.setEnabled(true);
      if (!bool3)
      {
        this.musicbar.setEnabled(false);
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 14) {
          this.ringerbar.setEnabled(true);
        } else {
          this.ringerbar.setEnabled(false);
        }
        this.musicbar.setEnabled(true);
      }
      if (this.alertbar != null) {
        this.alertbar.setEnabled(false);
      }
      this.systembar.setEnabled(false);
      this.voicebar.setEnabled(true);
    }
    else
    {
      this.alarmbar.setEnabled(true);
      this.musicbar.setEnabled(true);
      if (!bool3)
      {
        if (this.alertbar != null) {
          this.alertbar.setEnabled(true);
        }
      }
      else
      {
        this.ringerbar.setEnabled(true);
        if (this.alertbar != null)
        {
          SeekBar localSeekBar = this.alertbar;
          if (!bool1) {
            bool2 = true;
          }
          localSeekBar.setEnabled(bool2);
        }
      }
      this.systembar.setEnabled(true);
      this.voicebar.setEnabled(true);
    }
    Iterator localIterator = streams.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        setPhoneRingtone();
        setNotificationRingtone();
        setAlarmRingtone();
        return;
      }
      Stream localStream = (Stream)localIterator.next();
      localStream.volume = this.am.getStreamVolume(localStream.stream);
      localStream.sb.setProgress(localStream.volume);
      localStream.level.setText("" + localStream.volume + "/" + "" + this.am.getStreamMaxVolume(localStream.stream));
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.context = paramActivity;
    streams = new ArrayList();
    this.am = ((AudioManager)paramActivity.getSystemService("audio"));
    this.mSettingsManager = new SettingsManager(getActivity());
    super.onAttach(paramActivity);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setLayoutTheme();
    generateLayout();
    createUI();
    return this.parent;
  }
  
  public void onResume()
  {
    doUIUpdate();
    super.onResume();
  }
  
  public void onStart()
  {
    this.volumizer = this.mSettingsManager.getBoolean("volumizer", false);
    setHasOptionsMenu(true);
    super.onStart();
  }
  
  public void playBeepingTone(int paramInt)
  {
    if ((this.alarmbar.isPressed()) || (this.musicbar.isPressed()) || ((this.alertbar != null) && (this.alertbar.isPressed())) || ((this.ringerbar != null) && (this.ringerbar.isPressed())) || (this.systembar.isPressed()) || (this.voicebar.isPressed())) {}
    try
    {
      this.mToneGenerator = new ToneGenerator(paramInt, 100);
      this.mToneGenerator.startTone(24);
      this.mToneGenerator.release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.w("AudioManager", localRuntimeException.getMessage());
      }
    }
  }
  
  private class OnAudioSeekBarListener
    implements SeekBar.OnSeekBarChangeListener
  {
    private TextView progressTextView;
    private int stream;
    
    public OnAudioSeekBarListener(int paramInt, TextView paramTextView)
    {
      this.stream = paramInt;
      this.progressTextView = paramTextView;
    }
    
    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      this.progressTextView.setText(paramInt + "/" + DynamicConsole.this.am.getStreamMaxVolume(this.stream));
      if (paramBoolean)
      {
        DynamicConsole.this.am.setStreamVolume(this.stream, paramInt, 0);
        paramSeekBar.setProgress(DynamicConsole.this.am.getStreamVolume(this.stream));
        if ((OldAPIHelper.hasSystemTelephony(DynamicConsole.this.getActivity().getPackageManager())) && (this.stream == 2))
        {
          if (DynamicConsole.this.alertbar != null) {
            DynamicConsole.this.alertbar.setProgress(DynamicConsole.this.am.getStreamVolume(5));
          }
          if (DynamicConsole.this.systembar != null) {
            DynamicConsole.this.systembar.setProgress(DynamicConsole.this.am.getStreamVolume(1));
          }
        }
        if (DynamicConsole.this.volumizer) {
          DynamicConsole.this.playBeepingTone(this.stream);
        }
      }
    }
    
    public void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
  
  private class Stream
  {
    public TextView level;
    public SeekBar sb;
    public int stream;
    public int volume;
    
    public Stream(int paramInt1, int paramInt2, SeekBar paramSeekBar, TextView paramTextView)
    {
      this.stream = paramInt1;
      this.volume = paramInt2;
      this.sb = paramSeekBar;
      this.level = paramTextView;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.fragments.DynamicConsole
 * JD-Core Version:    0.7.0.1
 */
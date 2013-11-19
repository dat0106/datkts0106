package com.sonyericsson.extras.liveware.actions.volume;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VolumeActivity
  extends BaseDialogActivity
{
  private static final int VOLUME_DIALOG = 1;
  private Dialog mDialog;
  private View mLayout;
  private String mRawSetting;
  private List<Volume> mVolumes = new ArrayList();
  
  private void cancel()
  {
    finish();
  }
  
  private void initVolumes()
  {
    Dbg.d("making volumes");
    localObject1 = makeVolume(2131558503, 2, "ring");
    ((Volume)localObject1).addResourceTag("notif");
    this.mVolumes.add(localObject1);
    this.mVolumes.add(makeVolume(2131558499, 3, "media"));
    this.mVolumes.add(makeVolume(2131558505, 4, "alarm"));
    Dbg.d("initializing volumes");
    localObject1 = (AudioManager)getSystemService("audio");
    Object localObject3;
    if (Dbg.d())
    {
      localObject3 = new StringBuilder("init, audio manager is ");
      if (localObject1 != null) {
        break label168;
      }
    }
    label168:
    for (localObject2 = "null";; localObject2 = "not null")
    {
      Dbg.d((String)localObject2);
      localObject2 = null;
      if (!TextUtils.isEmpty(this.mRawSetting)) {}
      try
      {
        localObject2 = new JSONObject(this.mRawSetting);
        localObject2 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Dbg.e(localJSONException);
          continue;
          ((Volume)localJSONException.next()).init(this, (AudioManager)localObject1, (JSONObject)localObject2);
        }
      }
      localObject3 = this.mVolumes.iterator();
      if (((Iterator)localObject3).hasNext()) {
        break;
      }
      return;
    }
  }
  
  private Volume makeVolume(int paramInt1, int paramInt2, String paramString)
  {
    return new Volume((SeekBar)this.mLayout.findViewById(paramInt1), paramInt2, ((AudioManager)getSystemService("audio")).getStreamMaxVolume(paramInt2), paramString);
  }
  
  protected Dialog get()
  {
    Dbg.d("get");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    Dbg.d("get, getting view");
    init(localBuilder);
    localBuilder.setTitle(2131099879);
    StringBuilder localStringBuilder = new StringBuilder("get, end, dlg is ");
    String str;
    if (localBuilder != null) {
      str = "not null";
    } else {
      str = "null";
    }
    Dbg.d(str);
    return localBuilder.create();
  }
  
  public void init(AlertDialog.Builder paramBuilder)
  {
    Dbg.d("init dialog");
    this.mLayout = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903078, (ViewGroup)findViewById(2131558497));
    UIUtils.applyDirectionality(this.mLayout);
    paramBuilder.setView(this.mLayout);
    Dbg.d("makeDialogView, setting media image");
    ImageView localImageView = (ImageView)this.mLayout.findViewById(2131558498);
    if (localImageView == null) {
      Dbg.d("makeDialogView, media image is null");
    } else {
      localImageView.setImageResource(2130837597);
    }
    Dbg.d("setting ring image");
    localImageView = (ImageView)this.mLayout.findViewById(2131558502);
    if (localImageView == null) {
      Dbg.d("makeDialogView, ringImage is null");
    } else {
      localImageView.setImageResource(2130837596);
    }
    Dbg.d("setting alarm image");
    localImageView = (ImageView)this.mLayout.findViewById(2131558504);
    if (localImageView == null) {
      Dbg.d("makeDialogView, no alarm image");
    } else {
      localImageView.setImageResource(2130837595);
    }
    if (!getPackageManager().hasSystemFeature("android.hardware.telephony")) {
      ((TextView)this.mLayout.findViewById(2131558501)).setText(2131099945);
    }
    paramBuilder.setPositiveButton(getString(2131099767), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        try
        {
          String str = VolumeActivity.this.saveVolumes();
          ActionUtils.finishActivityWithSetting(VolumeActivity.this, str, VolumeAction.getLabelByRawSetting(VolumeActivity.this, str));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Dbg.e(localJSONException);
          }
        }
      }
    });
    paramBuilder.setNegativeButton(getString(2131099743), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VolumeActivity.this.cancel();
      }
    });
    paramBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        VolumeActivity.this.cancel();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Dbg.d("onCreate");
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    showDialog(1);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dbg.d("onCreateDialog");
    Dialog localDialog;
    switch (paramInt)
    {
    default: 
      Dbg.d("onCreateDialog, creating dialog");
      localDialog = super.onCreateDialog(paramInt);
      break;
    case 1: 
      this.mDialog = get();
      localDialog = this.mDialog;
    }
    return localDialog;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
    if (paramInt == 1) {
      initVolumes();
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle)
  {
    super.onPrepareDialog(paramInt, paramDialog, paramBundle);
    Dbg.d("onPrepareDialog, applying RTL, for real this time");
  }
  
  public String saveVolumes()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.mVolumes.iterator();
    while (localIterator.hasNext())
    {
      Volume localVolume = (Volume)localIterator.next();
      localVolume.save(this, localJSONObject);
      localJSONObject = localVolume.save(this, localJSONObject);
    }
    return localJSONObject.toString();
  }
  
  static class Volume
  {
    private final SeekBar mSeekBar;
    private final int mStreamType;
    private List<String> mTags = new ArrayList();
    private int mVol = 0;
    
    public Volume(SeekBar paramSeekBar, int paramInt1, int paramInt2, String paramString)
    {
      this.mSeekBar = paramSeekBar;
      this.mSeekBar.setMax(paramInt2);
      this.mStreamType = paramInt1;
      this.mVol = (paramInt2 / 2);
      this.mTags.add(paramString);
    }
    
    public void addResourceTag(String paramString)
    {
      this.mTags.add(paramString);
    }
    
    public void init(Context paramContext, AudioManager paramAudioManager, JSONObject paramJSONObject)
    {
      Dbg.d("Setting volume");
      i = -1;
      if (paramJSONObject != null) {}
      try
      {
        i = paramJSONObject.getInt((String)this.mTags.get(0));
        i = i;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Dbg.e(localJSONException);
          continue;
          i = (int)Math.round(i * this.mSeekBar.getMax() / 100.0D);
        }
      }
      if (i == -1)
      {
        i = paramAudioManager.getStreamVolume(this.mStreamType);
        setVolume(i);
        return;
      }
    }
    
    public JSONObject save(Context paramContext, JSONObject paramJSONObject)
      throws JSONException
    {
      int i = (int)Math.round(100.0D * this.mSeekBar.getProgress() / this.mSeekBar.getMax());
      Iterator localIterator = this.mTags.iterator();
      while (localIterator.hasNext()) {
        paramJSONObject.put((String)localIterator.next(), i);
      }
      return paramJSONObject;
    }
    
    public void setVolume(int paramInt)
    {
      this.mVol = paramInt;
      this.mSeekBar.setProgress(this.mVol);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.volume.VolumeActivity
 * JD-Core Version:    0.7.0.1
 */
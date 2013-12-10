package com.smartandroidapps.audiowidgetlib.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.receivers.CurrentProfileWidget;

public class WidgConfig
  extends Activity
{
  private int chosenMode = 1;
  private int mAppWidgetId = -1;
  private TextView mode;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.widgconfig);
    setResult(0);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.mAppWidgetId = ((Bundle)localObject).getInt("appWidgetId", 0);
    }
    localObject = (RadioGroup)findViewById(R.id.radioGroup1);
    this.mode = ((TextView)findViewById(R.id.mode_desc));
    Button localButton = (Button)findViewById(R.id.contbtn);
    ((RadioGroup)localObject).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        if (paramAnonymousInt != R.id.radio0)
        {
          WidgConfig.this.mode.setText(R.string.toggle_mode_desc);
          WidgConfig.access$102(WidgConfig.this, 2);
        }
        else
        {
          WidgConfig.this.mode.setText(R.string.prof_list_mode_desc);
          WidgConfig.access$102(WidgConfig.this, 1);
        }
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(WidgConfig.this, CurrentProfileWidget.class);
        localIntent.setAction("com.smartandroidapps.audiowidgetlib.SETUP");
        localIntent.putExtra("mode", WidgConfig.this.chosenMode);
        localIntent.putExtra("appWidgetId", WidgConfig.this.mAppWidgetId);
        WidgConfig.this.sendBroadcast(localIntent);
        localIntent = new Intent();
        localIntent.putExtra("appWidgetId", WidgConfig.this.mAppWidgetId);
        WidgConfig.this.setResult(-1, localIntent);
        WidgConfig.this.finish();
      }
    });
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.widget.WidgConfig
 * JD-Core Version:    0.7.0.1
 */
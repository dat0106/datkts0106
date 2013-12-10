package com.example.demoheadsetbutton;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
    private AudioManager audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        //        IntentFilter filter  = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
//        MediaButtonIntentReceiver r  = new MediaButtonIntentReceiver();
//        filter.setPriority(10000);
//        registerReceiver(r, filter);
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

//        MediaButtonIntentReceiver media = new MediaButtonIntentReceiver();
//        am.registerMediaButtonEventReceiver(media./);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
        case KeyEvent.KEYCODE_VOLUME_UP:
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            Toast.makeText(getBaseContext(), "KEYCODE_VOLUME_UP", Toast.LENGTH_SHORT).show();
            return true;
        case KeyEvent.KEYCODE_VOLUME_DOWN:
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            Toast.makeText(getBaseContext(), "KEYCODE_VOLUME_DOWN", Toast.LENGTH_SHORT).show();
            return true;
        default:
            Toast.makeText(getBaseContext(), KeyEvent.keyCodeToString(keyCode), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

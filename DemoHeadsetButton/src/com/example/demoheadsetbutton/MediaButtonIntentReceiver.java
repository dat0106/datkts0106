package com.example.demoheadsetbutton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Toast;

public class MediaButtonIntentReceiver extends BroadcastReceiver {

    public MediaButtonIntentReceiver() {
        super();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String intentAction = intent.getAction();
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)){
            return;
        }
        KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if(event == null){
            return;
        }
        int action =  event.getAction();
        if (action ==  KeyEvent.ACTION_DOWN) {
            Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
        }
        if (action ==  KeyEvent.ACTION_MULTIPLE) {
            Toast.makeText(context, "BUTTON ACTION_MULTIPLE!", Toast.LENGTH_SHORT).show();
        }
        if (action ==  KeyEvent.ACTION_UP) {
            Toast.makeText(context, "BUTTON ACTION_UP!", Toast.LENGTH_SHORT).show();
        }
        abortBroadcast();
    }

}

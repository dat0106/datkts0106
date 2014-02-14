package com.smartschedule.action;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.DrawAction;
import com.smartschedule.R;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;
import com.smartschedule.util.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class DialogWifiManager extends AlertDialog.Builder {

    private static Context context;
    private int event_id;
    private Action action;
    private String start_or_end;
    private DrawAction pst;
    private int currentItem;
    private WifiManager wifiManager;

    public DialogWifiManager(Context context, Intent intent) {
        super(context);
        this.context = context;

        this.event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);
        action = intent.getExtras().getParcelable(Constant.ACTION_PARAMS);
        String jString;
        if (action == null) {
            jString = "{}";
        } else {
            jString = action.getDrawAction();
        }

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        pst = gson.fromJson(jString, DrawAction.class);

        // currentItem maping dialog_wifi
        switch (Integer.parseInt(pst.wifi_mode)) {
        case 0:
            currentItem = 1;
            break;
        case 1:
            currentItem = 0;
            break;

        default:
            if(wifiManager.isWifiEnabled()){
                currentItem = 1;
            }else {
                currentItem = 0;
            }
            break;
        }

        start_or_end = intent.getExtras().getString(Constant.START_OR_END);
        // Set the dialog title
        this.setTitle(R.string.name_wifi)
        // Specify the list array, the items to be selected by
        // default (null for none),
        // and the listener through which to receive callbacks when
        // items are selected
                .setSingleChoiceItems(R.array.dialog_wifi, currentItem,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                // TODO Auto-generated method stub
                                Toast.makeText(DialogWifiManager.context, "choise item " + which, Toast.LENGTH_LONG).show();
                            }
                        })
                // Set the action buttons
                .setPositiveButton(R.string.done, new OnClickListener() {

                    @Override
                    public void onClick(android.content.DialogInterface arg0,
                            int arg1) {
                        // TODO Auto-generated method stub

                    }
                }).setNegativeButton(R.string.cancel, new OnClickListener() {

                    @Override
                    public void onClick(android.content.DialogInterface dialog,
                            int which) {
                        // TODO Auto-generated method stub

                    }
                });

    }

}

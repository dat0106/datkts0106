package com.smartschedule.action;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.DrawAction;
import com.smartschedule.EventDetailActivity;
import com.smartschedule.R;
import com.smartschedule.action.wifihotspotutils.WifiApManager;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.utils.Constant;
import com.smartschedule.utils.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.util.Log;
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

public class DialogWifiHotspotManager extends AlertDialog.Builder {

    private Activity context;
    private int event_id;
    private Action action;
    private String start_or_end;
    private DrawAction pst;
    private Boolean statusWifiHotspot;
    private WifiApManager wifiApManager;
    private Gson gson;
    private SmartSchedulerDatabase smartScheduleDb;

    public DialogWifiHotspotManager(final Activity context, Intent intent) {
        super(context);
        this.context = context;
        wifiApManager =  new WifiApManager(context);
        smartScheduleDb = new SmartSchedulerDatabase(
                context);
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
        gson = gsonb.create();
        pst = gson.fromJson(jString, DrawAction.class);

        // statusWifi maping dialog_wifi and
        if(pst.wifi_hotspot_mode == null){
            statusWifiHotspot = wifiApManager.isWifiApEnabled();
        }else {
            statusWifiHotspot = Boolean.parseBoolean(pst.wifi_hotspot_mode);
        }

        start_or_end = intent.getExtras().getString(Constant.START_OR_END);
        // Set the dialog title
        this.setTitle(R.string.name_wifi_hotspot)
                .setSingleChoiceItems(R.array.dialog_on_off, (statusWifiHotspot)? 0 : 1,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                statusWifiHotspot = fix_inteface(which);

                            }
                        })
                .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               Resources res = context.getResources();
                               String[] array   = res.getStringArray(R.array.dialog_on_off);
                               String status =  array[(statusWifiHotspot)? 0 : 1];
                               // get data to update database
                               ContentValues contentValue = new ContentValues();
                               pst.wifi_hotspot_mode = String.valueOf(statusWifiHotspot);
                               contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW,
                                       gson.toJson(pst));
                               contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATUS,
                                       status);
                               smartScheduleDb.open();
                               if (action == null) {
                                   if (Constant.START.equals(start_or_end)) {
                                       contentValue.put(
                                               SmartSchedulerDatabase.COLUMN_ACTION_START_ID,
                                               event_id);
                                   } else if (Constant.END.equals(start_or_end)) {
                                       contentValue.put(
                                               SmartSchedulerDatabase.COLUMN_ACTION_END_ID,
                                               event_id);
                                   } else {
                                       Log.d(((Object) this).toString(),
                                               "we can not check start or end ");
                                       throw new Error(
                                               "we can not check start or end");
                                   }
                                   contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATE,
                                           Constant.ROUTER_WIFI_HOTSPOT);
                                   contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_NAME,
                                           R.string.name_wifi_hotspot);
                                   smartScheduleDb.insert_action(contentValue);
                               } else {
                                   smartScheduleDb.update_action(contentValue, action.getId());
                               }
                               Intent intent = new Intent(context, EventDetailActivity.class);
                               intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

                               context.startActivity(intent);
                               dialog.dismiss();
                           }
                       })
                .setNegativeButton(R.string.cancel, new OnClickListener() {

                    @Override
                    public void onClick(android.content.DialogInterface dialog,
                            int which) {
                         dialog.cancel();

                    }
                });

    }

    private Boolean fix_inteface(int which2) {
        switch (which2) {
        case 0:
            return true;
        case 1:
            return false;
        default:
            return false;
        }
    }

}

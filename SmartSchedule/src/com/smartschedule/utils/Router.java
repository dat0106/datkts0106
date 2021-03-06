package com.smartschedule.utils;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

import com.smartschedule.R;
import com.smartschedule.action.*;
import com.smartschedule.database.Action;
import com.smartschedule.database.SmartSchedulerDatabase;

public class Router {

    public static HashMap<Integer, DetailActionViewer> routerUri() {
        HashMap<Integer, DetailActionViewer> router = new HashMap<Integer, DetailActionViewer>();

        DetailActionViewer r = new DetailActionViewer();
        r.id = Constant.ROUTER_SOUND_MANAGER;
        r.name = R.string.name_sound_manager;
        r.iconURI = R.drawable.ic_launcher;
        r.category = Constant.CATEGORY_SOUND;

        router.put(Constant.ROUTER_SOUND_MANAGER, r);

        DetailActionViewer r1 = new DetailActionViewer();
        r1.id = Constant.ROUTER_WIFI;
        r1.name = R.string.name_wifi;
        r1.iconURI = R.drawable.ic_launcher;
        r1.category = Constant.CATEGORY_WIRELESS_NETWORK;

        router.put(Constant.ROUTER_WIFI, r1);

        DetailActionViewer r2 = new DetailActionViewer();
        r2.id = Constant.ROUTER_BLUETOOTH;
        r2.name = R.string.name_bluetooth;
        r2.iconURI = R.drawable.ic_launcher;
        r2.category = Constant.CATEGORY_SOUND;

        router.put(Constant.ROUTER_BLUETOOTH, r2);

        DetailActionViewer r3 = new DetailActionViewer();
        r3.id = Constant.ROUTER_WIFI_HOTSPOT;
        r3.name = R.string.name_wifi_hotspot;
        r3.iconURI = R.drawable.ic_launcher;
        r3.category = Constant.CATEGORY_WIRELESS_NETWORK;

        router.put(Constant.ROUTER_WIFI_HOTSPOT, r3);

        DetailActionViewer r4 = new DetailActionViewer();
        r4.id = Constant.ROUTER_START_APPLICATION;
        r4.name = R.string.name_start_application;
        r4.iconURI = R.drawable.ic_launcher;
        r4.category = Constant.CATEGORY_APPLICATIONS;

        router.put(Constant.ROUTER_START_APPLICATION, r4);
        return router;
    }

    public static void routerActivity(Integer event_id, Integer router,
            Action childAction, Activity activity) {
        router(event_id, router, null, childAction, activity);
    }

    public static void routerSetting(Integer event_id, Integer router,
            String start_or_end, Activity activity) {
        router(event_id, router, start_or_end, null, activity);

    }

    private static void router(int event_id, int router, String start_or_end,
            Action childAction, Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

        if (childAction != null) {
            intent.putExtra(Constant.ACTION_PARAMS, childAction);
        }
        if (start_or_end != null) {
            intent.putExtra(Constant.START_OR_END, start_or_end);
        }

        AlertDialog dialog;
        switch (router) {
        case Constant.ROUTER_SOUND_MANAGER:
            intent.setClass(activity, ActivitySoundManager.class);
            activity.startActivity(intent);
            break;

        case Constant.ROUTER_BLUETOOTH:

            DialogBluetoothManager builderBluetooth = new DialogBluetoothManager(activity, intent);
            dialog = builderBluetooth.create();
            dialog.show();
            break;
        case Constant.ROUTER_WIFI:

            DialogWifiManager builder = new DialogWifiManager(activity, intent);
            dialog = builder.create();
            dialog.show();
            break;
        case Constant.ROUTER_WIFI_HOTSPOT:

            DialogWifiHotspotManager builderWifiHotspot = new DialogWifiHotspotManager(activity, intent);
            dialog = builderWifiHotspot.create();
            dialog.show();
            break;

        case Constant.ROUTER_START_APPLICATION:
            intent.setClass(activity, ActivityStartApplication.class);
            activity.startActivity(intent);
            break;
        default:
            break;
        }
    }


}

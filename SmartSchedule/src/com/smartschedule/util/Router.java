package com.smartschedule.util;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;

import com.smartschedule.R;
import com.smartschedule.action.ActivitySoundManager;
import com.smartschedule.database.Action;
import com.smartschedule.database.SmartSchedulerDatabase;

public class Router {


    public static final  HashMap<Integer,DetailActionViewer>  routerUri = routerURI();


    private static HashMap<Integer,DetailActionViewer> routerURI() {
        HashMap<Integer,DetailActionViewer> router =new HashMap<Integer, DetailActionViewer>();

        DetailActionViewer r = new DetailActionViewer();
        r.id = Constant.ROUTER_SOUND_MANAGER;
        r.name = R.string.app_name;
        r.iconURI =  R.drawable.ic_launcher;
        r.category = Constant.CATEGORY_SOUND;

        router.put(Constant.ROUTER_SOUND_MANAGER, r);

        r.id = Constant.ROUTER_WIFI;
        r.name = R.string.app_name;
        r.iconURI =  R.drawable.ic_launcher;
        r.category = Constant.CATEGORY_WIRELESS_NETWORK;

        router.put(Constant.ROUTER_WIFI, r);

        r.id = Constant.ROUTER_BLUETOOTH;
        r.name = R.string.app_name;
        r.iconURI =  R.drawable.ic_launcher;
        r.category = Constant.CATEGORY_SOUND;

        router.put(Constant.ROUTER_BLUETOOTH, r);
        return router;
    }


    public static void routerActivity(Integer event_id, Action childAction, Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

        intent.putExtra(Constant.ACTION_PARAMS, childAction);

        switch (childAction.getState()) {
        case Constant.ROUTER_SOUND_MANAGER:
            intent.setClass(activity, ActivitySoundManager.class);
            activity.startActivity(intent);
            break;

        default:
            break;
        }
    }

    public static void routerSetting(Integer event_id, DetailActionViewer childAction, Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

        intent.putExtra(Constant.ACTION_PARAMS, childAction);

        SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
                activity.getBaseContext());
        ContentValues contentValues = new ContentValues();
        if (StartOrEnd == 1) {
            contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_START_ID,
                    event_id);
        } else {
            contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_END_ID,
                    event_id);
        }
        contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_STATE, 1);
        contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_NAME, "demo");
        contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW, "{}");
        contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_STATUS,
                "demoStatus");
        smartScheduleDb.open();
        smartScheduleDb.insert_action(contentValues);
        smartScheduleDb.close();

        switch (childAction.getState()) {
        case Constant.ROUTER_SOUND_MANAGER:
            intent.setClass(activity, ActivitySoundManager.class);
            activity.startActivity(intent);
            break;

        default:
            break;
        }
    }
}

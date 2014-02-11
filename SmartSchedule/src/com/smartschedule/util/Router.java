package com.smartschedule.util;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;

import com.smartschedule.R;
import com.smartschedule.action.ActivitySoundManager;
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
        return router;
    }

    public static void routerActivity(Integer event_id, Integer router,
            Action childAction, Activity activity) {
        router(event_id, router, null,
                childAction, activity);
    }

    public static void routerSetting(Integer event_id, Integer router,
            String start_or_end, Activity activity) {
        router(event_id, router, start_or_end,
                null, activity);

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

        switch (router) {
        case Constant.ROUTER_SOUND_MANAGER:
            intent.setClass(activity, ActivitySoundManager.class);
            activity.startActivity(intent);
            break;

        default:
            break;
        }
    }
}

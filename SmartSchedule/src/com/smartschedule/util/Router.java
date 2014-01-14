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
        r.id = 1;
        r.name = R.string.app_name;
        r.iconURI =  R.drawable.ic_launcher;
        r.category = 1;

        router.put(1, r);
        return router;
    }


    public static void routerActivity(Integer event_id, Action childAction, Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

        intent.putExtra(Constant.ACTION_PARAMS, childAction);

        switch (childAction.getState()) {
        case 1:
            intent.setClass(activity, ActivitySoundManager.class);
            activity.startActivity(intent);
            break;

        default:
            break;
        }
    }

}

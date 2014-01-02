package com.smartschedule.util;

import com.smartschedule.action.ActivitySoundManager;
import com.smartschedule.database.Action;
import com.smartschedule.database.SmartSchedulerDatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

public class Util {
    public static String convertTime(Integer time){
        if(time == null) {
            return "-";
        }
        if(time < 10){
            return "0" +  time.toString();
        }
        return time.toString();
    }

    public static String getTime(String asString) {
        if(asString == null){
            return "--";
        }else if(asString.length() == 1){
            return "0" + asString;
        }
        return asString;
    }

    public  static boolean intToBool(Integer integer) {
        if (integer == 1) {
            return true;
        }
        return false;
    }

    public static void router(Integer event_id, Action childAction, Activity activity) {
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

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

    public static String getTime(Integer integer) {
        if(integer == null){
            return "--";
        }else if(integer  <=  9){
            return "0" + integer;
        }
        return integer.toString();
    }

    public  static boolean intToBool(Integer integer) {
        if (integer == 1) {
            return true;
        }
        return false;
    }


}

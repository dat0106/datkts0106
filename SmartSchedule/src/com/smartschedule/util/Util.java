package com.smartschedule.util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;

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

	public static void router(ContentValues contentValuesAction, Activity activity) {
		Intent intent = new Intent();
		
		
	}
    
    

}

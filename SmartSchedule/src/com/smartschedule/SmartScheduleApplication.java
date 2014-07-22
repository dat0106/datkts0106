package com.smartschedule;

import android.app.Application;
import android.content.Context;

/**
 * Created by dat on 7/21/2014.
 */
public class SmartScheduleApplication extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        SmartScheduleApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return SmartScheduleApplication.context;
    }
}

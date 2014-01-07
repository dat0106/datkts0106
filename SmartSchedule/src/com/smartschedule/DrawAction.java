package com.smartschedule;

import android.os.Parcel;
import android.os.Parcelable;

public class DrawAction implements Parcelable
{
    public String sound_mode;
    public String sound_alarm;
    public String sound_ring;
    public String sound_music;
    public String sound_notification;
    public String sound_system;
    public String sound_voice_call;
    public String ringtone_alarm;
    public String rimgtome_ringer;
    public String ringtone_notification;

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        if(ringtone_alarm != null){
//            dest.writeString(ringtone_alarm);
//        }
//        dest.writeString(rimgtome_ringer);
//
//        dest.writeString(ringtone_notification);

    }


}

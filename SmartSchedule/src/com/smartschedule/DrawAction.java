package com.smartschedule;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class DrawAction implements Parcelable
{
    String sound_mode;
    String sound_alarm;
    String sound_ring;
    String sound_music;
    String sound_notification;
    String sound_system;
    String sound_voice_call;
    String ringtone_alarm;
    String rimgtome_ringer;
    String ringtone_notification;

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

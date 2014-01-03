package com.smartschedule.database;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private Integer id;
    private Integer timeStartHour;
    private Integer timeStartMinute;
    private Integer timeEndHour;
    private Integer timeEndMinute;
    private Integer schedule;
    private Integer category;
    private Integer state;
    private String image;
    private String name;
    public Event(Parcel in) {
        id = in.readInt();
        timeStartHour = in.readInt();
        timeStartMinute = in.readInt();
        timeEndHour = in.readInt();
        timeEndMinute = in.readInt();
        schedule = in.readInt();
        category = in.readInt();
        state = in.readInt();
        image = in.readString();
        name = in.readString();

    }

    public Event() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int arg1) {
        parcel.writeInt(id);
        parcel.writeInt(timeStartHour);
        parcel.writeInt(timeStartMinute);
        parcel.writeInt(timeEndHour);
        parcel.writeInt(timeEndMinute);
        parcel.writeInt(schedule);
        parcel.writeInt(category);
        parcel.writeInt(state);
        parcel.writeString(image);
        parcel.writeString(name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimeStartHour() {
        return timeStartHour;
    }

    public void setTimeStartHour(Integer timeStartHour) {
        this.timeStartHour = timeStartHour;
    }

    public Integer getTimeStartMinute() {
        return timeStartMinute;
    }

    public void setTimeStartMinute(Integer timeStartMinute) {
        this.timeStartMinute = timeStartMinute;
    }

    public Integer getTimeEndHour() {
        return timeEndHour;
    }

    public void setTimeEndHour(Integer timeEndHour) {
        this.timeEndHour = timeEndHour;
    }

    public Integer getTimeEndMinute() {
        return timeEndMinute;
    }

    public void setTimeEndMinute(Integer timeEndMinute) {
        this.timeEndMinute = timeEndMinute;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Parcelable.Creator<Event> CREATOR
    = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public com.smartschedule.database.Event[] newArray(int size) {
            return new Event[size];
        }
    };
}

package com.smartschedule.database;

import android.os.Parcel;
import android.os.Parcelable;

public class Action implements Parcelable{

    private Integer id;
    private Integer actionStartId;
    private Integer actionEndId;
    private Integer state;
    private String name;
    private String drawAction;
    private String status;
    public Action(Parcel in) {
        id =  in.readInt();
        actionStartId =  in.readInt();
        actionEndId =  in.readInt();
        state =  in.readInt();
        name =  in.readString();
        drawAction =  in.readString();
        status =  in.readString();

    }

    public Action() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int arg1) {
        parcel.writeInt(id);
        parcel.writeInt(actionStartId);
        parcel.writeInt(actionEndId);
        parcel.writeInt(state);
        parcel.writeString(name);
        parcel.writeString(drawAction);
        parcel.writeString(status);
    }

    public static final Parcelable.Creator<Action> CREATOR
    = new Parcelable.Creator<Action>() {
        public Action createFromParcel(Parcel in) {
            return new Action(in);
        }

        @Override
        public com.smartschedule.database.Action[] newArray(int size) {
            return new Action[size];
        }
    };

    public Integer getActionStartId() {
        return actionStartId;
    }

    public void setActionStartId(Integer actionStartId) {
        this.actionStartId = actionStartId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getActionEndId() {
        return actionEndId;
    }

    public void setActionEndId(Integer actionEndId) {
        this.actionEndId = actionEndId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrawAction() {
        return drawAction;
    }

    public void setDrawAction(String drawAction) {
        this.drawAction = drawAction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

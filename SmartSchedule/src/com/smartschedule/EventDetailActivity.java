package com.smartschedule;

import java.util.ArrayList;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.utils.Constant;

import android.app.ExpandableListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class EventDetailActivity extends ExpandableListActivity implements
        OnChildClickListener {

    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);
    private int event_id;
    private ContentValues eventDetail;
    private ContentValues actionStart;
    private ContentValues actionEnd;
    EventDetailAdapter mNewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String jString = "{\"ringtone_alarm\": \"primal\", \"rimgtome_ringer\": \"Hi, I am Primal\"}  ";

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction pst = null;

        pst = gson.fromJson(jString, DrawAction.class);
//
//        Intent cv = new Intent();
//
//        cv.putExtra("fuck", pst);
//
//        DrawAction pst1 = cv.getExtras().getParcelable("fuck");
//
//        Log.d("TAggeD", pst1.ringtone_alarm + pst1.rimgtome_ringer);
//
//        Log.d("TAGGED", gson.toJson(pst1));

        this.event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);

        ExpandableListView expandbleLis = getExpandableListView();
        expandbleLis.setDividerHeight(2);
        expandbleLis.setGroupIndicator(null);
        expandbleLis.setClickable(true);

        setGroupData();
        setChildGroupData();

        mNewAdapter = new EventDetailAdapter(groupItem,
                childItem, event_id);
        mNewAdapter
                .setInflater(
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                        this);
        expandbleLis.setAdapter(mNewAdapter);
        expandbleLis.setDivider(null);
        expandbleLis.setDividerHeight(0);

        for (int i = 0; i < groupItem.size(); i++) {
            expandbleLis.expandGroup(i);
        }

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        setGroupData();
        setChildGroupData();
        mNewAdapter.UpdateDataChange(groupItem, childItem, event_id);
        mNewAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // when the user click start schedule
        case android.R.id.home:
            // Navigate "up" the demo structure to the launchpad activity.
            // for more.
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));

            return true;

        }
        return false;

    }

    public void setGroupData() {
        // TODO String chuyen da ngon ngu
        groupItem.clear();
        groupItem.add("Condition");
        groupItem.add("Start Event");
        groupItem.add("End Event");
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public  ArrayList<Object> setChildGroupData() {
        /**
         * Add Data For TecthNology
         */
        childItem.clear();
        ArrayList<Event> child = new ArrayList<Event>();
        smartScheduleDb.openRead();
        Event cv = smartScheduleDb.getData(event_id);

        child.add(cv);
        childItem.add(child);

        /**
         * Add Data For start
         */
        ArrayList<Action> childAction = new ArrayList<Action>();
        childAction = smartScheduleDb.getDataAction(event_id, Constant.START);
        childItem.add(childAction);
        /**
         * Add Data For end
         */
        childAction = smartScheduleDb.getDataAction(event_id, Constant.END);
        childItem.add(childAction);

        smartScheduleDb.close();

        return childItem;
    }

}

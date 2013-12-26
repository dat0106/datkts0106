package com.smartschedule;

import java.util.ArrayList;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();


        String jString = "{\"ringtone_alarm\": \"primal\", \"rimgtome_ringer\": \"Hi, I am Primal\"}  ";


        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction pst = null;

        pst = gson.fromJson(jString,  DrawAction.class);

        Intent cv =  new Intent();

        cv.putExtra("fuck", pst);

        DrawAction pst1 =  cv.getExtras().getParcelable("fuck");

        Log.d("TAggeD", pst1.ringtone_alarm + pst1.rimgtome_ringer);

        Log.d("TAGGED", gson.toJson(pst1));


        this.event_id =  intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);
        smartScheduleDb.openRead();
        eventDetail = smartScheduleDb.getData(event_id);
        actionStart = smartScheduleDb.getDataAction(event_id, Constant.ACTION_START_ID_KEY);
        actionEnd = smartScheduleDb.getDataAction(event_id, Constant.ACTION_END_ID_KEY);
        smartScheduleDb.close();

        ExpandableListView expandbleLis = getExpandableListView();
        expandbleLis.setDividerHeight(2);
        expandbleLis.setGroupIndicator(null);
        expandbleLis.setClickable(true);

        setGroupData();
        setChildGroupData();

        EventDetailAdapter mNewAdapter = new EventDetailAdapter(groupItem, childItem);
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
        groupItem.add("Condition");
        groupItem.add("Start Event");
        groupItem.add("End Event");
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public void setChildGroupData() {
        /**
         * Add Data For TecthNology
         */
        ArrayList<String> child = new ArrayList<String>();
        child.add("Java");
        child.add("Drupal");
        child.add(".Net Framework");
        child.add("PHP");
        childItem.add(child);

        /**
         * Add Data For Mobile
         */
        child = new ArrayList<String>();
        child.add("Android");
        child.add("Window Mobile");
        child.add("iPHone");
        child.add("Blackberry");
        childItem.add(child);
        /**
         * Add Data For Manufacture
         */
        child = new ArrayList<String>();
        child.add("HTC");
        child.add("Apple");
        child.add("Samsung");
        child.add("Nokia");
        childItem.add(child);
    }

}

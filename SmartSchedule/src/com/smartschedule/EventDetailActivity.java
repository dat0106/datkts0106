package com.smartschedule;

import java.util.ArrayList;

import com.smartschedule.database.SmartSchedulerDatabase;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class EventDetailActivity extends ExpandableListActivity implements
        OnChildClickListener {

    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        getExpandableListView().setAdapter(mNewAdapter);
        expandbleLis.setOnChildClickListener(this);

        getExpandableListView().setDivider(null);
        getExpandableListView().setDividerHeight(0);

        for (int i = 0; i < groupItem.size(); i++) {
            getExpandableListView().expandGroup(i);
        }
    }

    public void setGroupData() {
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

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
        Toast.makeText(EventDetailActivity.this, "Clicked On Child",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}

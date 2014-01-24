package com.smartschedule.setting;

import java.util.ArrayList;

import com.smartschedule.EventTimeActivity;
import com.smartschedule.R;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;
import com.smartschedule.util.DetailActionViewer;
import com.smartschedule.util.Router;
import com.smartschedule.util.Util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingAdapter extends BaseExpandableListAdapter {

    public ArrayList<String> groupItem;
    public ArrayList<Object> Childtem = new ArrayList<Object>();
    public LayoutInflater minflater;
    public Activity activity;
    public int event_id;

    public SettingAdapter(ArrayList<String> grList, ArrayList<Object> childItem, int event_id) {
        groupItem = grList;
        this.Childtem = childItem;
        this.event_id = event_id;
    }

    public void UpdateDataChange(ArrayList<String> grList, ArrayList<Object> childItem, int event_id) {
        groupItem = grList;
        this.Childtem = childItem;
        this.event_id = event_id;
    }

    public void setInflater(LayoutInflater mInflater, Activity act) {
        this.minflater = mInflater;
        activity = act;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.setting_child, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.childNameSetting);

        ArrayList<DetailActionViewer> tempChild = (ArrayList<DetailActionViewer>) Childtem.get(groupPosition);


        final DetailActionViewer Child =  tempChild.get(childPosition);
        text.setText(activity.getString(Child.name));

        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.routerSetting(event_id, Child, activity);

            }
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>) Childtem.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return groupItem.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {

        final int StartOrEnd =  groupPosition;
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.setting_group, null);
        }
        ((TextView) convertView.findViewById(R.id.group_setting)).setText(groupItem.get(groupPosition));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


}

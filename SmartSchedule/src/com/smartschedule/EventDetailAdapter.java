package com.smartschedule;

import java.util.ArrayList;

import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;
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

public class EventDetailAdapter extends BaseExpandableListAdapter {

    public ArrayList<String> groupItem;
    public ArrayList<Object> Childtem = new ArrayList<Object>();
    public LayoutInflater minflater;
    public Activity activity;
    public int event_id;

    public EventDetailAdapter(ArrayList<String> grList, ArrayList<Object> childItem, int event_id) {
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
            convertView = minflater.inflate(R.layout.childrow, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.childName);
        TextView textDetail = (TextView) convertView.findViewById(R.id.childDetail);
        if(groupPosition == 0){
            ArrayList<Event> tempChild = (ArrayList<Event>) Childtem.get(groupPosition);


            final Event Child =  tempChild.get(childPosition);

            text.setText(Child.getName());

            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                	Intent intent = new Intent(activity, EventTimeActivity.class);
                	intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);
                	activity.startActivity(intent);
                }
            });
        }else{
            ArrayList<Action> tempChild = (ArrayList<Action>) Childtem.get(groupPosition);


            final Action Child =  tempChild.get(childPosition);
            Router router = Constant.router.get(Child.getState());
            text.setText(activity.getString(router.name));

            textDetail.setText(Child.getDrawAction());
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Util.router(event_id, Child, activity);

                    Toast.makeText(activity, Child.getName(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
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
            convertView = minflater.inflate(R.layout.grouprow, null);
        }
        ((TextView) convertView.findViewById(R.id.group_row)).setText(groupItem.get(groupPosition));
        ((Button) convertView.findViewById(R.id.add_action)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO bat vao trang  lay lay setting
                SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
                        activity.getBaseContext());
                ContentValues contentValues = new ContentValues();
                if(StartOrEnd == 1){
                    contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_START_ID, event_id);
                }else {
                    contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_END_ID, event_id);
                }
                contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_STATE, 1);
                contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_NAME, "demo");
                contentValues.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW, "{}");
                smartScheduleDb.open();
                smartScheduleDb.insert_action(contentValues);
                smartScheduleDb.close();
                Toast.makeText(activity, "add action", Toast.LENGTH_LONG).show();
            }
        });

        if(groupPosition == 0) {
            ((Button) convertView.findViewById(R.id.add_action)).setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        Toast.makeText(activity, tempChild.get(childPosition),
//                Toast.LENGTH_SHORT).show();
        return false;
    }


}

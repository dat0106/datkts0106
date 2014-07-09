package com.smartschedule;

import java.util.ArrayList;

import android.util.Log;
import android.view.*;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.setting.SettingActivity;
import com.smartschedule.utils.Constant;
import com.smartschedule.utils.DetailActionViewer;
import com.smartschedule.utils.Router;
import com.smartschedule.utils.Util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.View.OnClickListener;
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
    protected Action ActionTemp;

    public EventDetailAdapter(ArrayList<String> grList,
            ArrayList<Object> childItem, int event_id) {
        groupItem = grList;
        this.Childtem = childItem;
        this.event_id = event_id;
    }

    public void UpdateDataChange(ArrayList<String> grList,
            ArrayList<Object> childItem, int event_id) {
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
            convertView = minflater.inflate(R.layout.event_detail_child, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.childName);
        TextView textDetail = (TextView) convertView
                .findViewById(R.id.childDetail);
        if (groupPosition == 0) {
            ArrayList<Event> tempChild = (ArrayList<Event>) Childtem
                    .get(groupPosition);

            final Event Child = tempChild.get(childPosition);

            text.setText(Child.getName());

            String timer = Util.getTime(Child.getTimeStartHour())

            + ":" + Util.getTime(Child.getTimeStartMinute()) + " ~ "
                    + Util.getTime(Child.getTimeEndHour()) + ":"
                    + Util.getTime(Child.getTimeEndMinute());

            textDetail.setText(timer);
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(activity,
                            EventTimeActivity.class);
                    intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID,
                            event_id);
                    activity.startActivity(intent);
                }
            });
        } else {
            ArrayList<Action> tempChild = (ArrayList<Action>) Childtem
                    .get(groupPosition);

            final Action Child = tempChild.get(childPosition);
            DetailActionViewer router = Router.routerUri().get(Child.getState());
            text.setText(activity.getString(router.name));

            textDetail.setText(Child.getStatus());
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Router.routerActivity(event_id, Child.getState(),  Child, activity);

                    Toast.makeText(activity, Child.getName(),
                            Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(activity, "delete",
                            Toast.LENGTH_SHORT).show();
                    ActionTemp =  Child;
                    activity.startActionMode(mActionModeCallback);
                    v.setSelected(true);
                    return true;
                }
            });
        }
        return convertView;
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            // Assumes that you have "contexual.xml" menu resources
            inflater.inflate(R.menu.rowselection, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after
        // onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem1_show:
//                    show();
//                    startEventActivity();
                    Router.routerActivity(event_id, ActionTemp.getState(),  ActionTemp, activity);
                    mode.finish();
                    return true;
                case R.id.menuitem2_delete:

//                    smartScheduleDb.open();
//                    int logDelete = smartScheduleDb.delete(contentValues.get(
//                            selectedItem).getId());
//
//                    if (logDelete != 1) {
//                        Log.e(MainActivity.this.toString(), "error delete event");
//                    }
//                    smartScheduleDb.close();
//
//                    contentValues = getData();
//                    mAdapter.notifyDataSetChanged();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        public void onDestroyActionMode(ActionMode mode) {
//            mActionMode = null;
//            selectedItem = -1;
        }
    };

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

        final int StartOrEnd = groupPosition;
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.event_detail_group, null);
        }
        ((TextView) convertView.findViewById(R.id.group_row)).setText(groupItem
                .get(groupPosition));
        ((Button) convertView.findViewById(R.id.add_action))
                .setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO bat vao trang lay lay setting
//                        SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
//                                activity.getBaseContext());
//                        ContentValues contentValues = new ContentValues();
//                        if (StartOrEnd == 1) {
//                            contentValues
//                                    .put(SmartSchedulerDatabase.COLUMN_ACTION_START_ID,
//                                            event_id);
//                        } else {
//                            contentValues
//                                    .put(SmartSchedulerDatabase.COLUMN_ACTION_END_ID,
//                                            event_id);
//                        }
//                        contentValues.put(
//                                SmartSchedulerDatabase.COLUMN_ACTION_STATE, 1);
//                        contentValues.put(
//                                SmartSchedulerDatabase.COLUMN_ACTION_NAME,
//                                "demo");
//                        contentValues
//                                .put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW,
//                                        "{}");
//                        contentValues.put(
//                                SmartSchedulerDatabase.COLUMN_ACTION_STATUS,
//                                "demoStatus");
//                        smartScheduleDb.open();
//                        smartScheduleDb.insert_action(contentValues);
//                        smartScheduleDb.close();

                        Intent intent = new Intent(activity, SettingActivity.class);

                        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);
                        if (StartOrEnd == 1) {
                            intent.putExtra(Constant.START_OR_END, Constant.START);
                        } else {
                            intent.putExtra(Constant.START_OR_END, Constant.END);
                        }

                        activity.startActivity(intent);
                        Toast.makeText(activity, "add action",
                                Toast.LENGTH_LONG).show();
                    }
                });

        if (groupPosition == 0) {
            ((Button) convertView.findViewById(R.id.add_action))
                    .setVisibility(View.INVISIBLE);
        }
        return convertView;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // Toast.makeText(activity, tempChild.get(childPosition),
        // Toast.LENGTH_SHORT).show();
        return false;
    }

}

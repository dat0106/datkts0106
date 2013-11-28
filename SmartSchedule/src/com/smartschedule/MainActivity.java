package com.smartschedule;

import java.util.ArrayList;

import com.smartschedule.database.SmartSchedulerDatabase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private SmartSchedulerDatabase smartScheduteDb = new SmartSchedulerDatabase(this);
    private EventAdapter mAdapter;
    private ListView listView;
    private ArrayList<ContentValues> contentValues ;

    private int selectedItem = -1;
    protected Object mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()

        smartScheduteDb.open();
        smartScheduteDb.createData("sample", "image", 123456, 1234567, 1, 1);
        smartScheduteDb.close();

        smartScheduteDb.open();
        mAdapter = new EventAdapter(this, smartScheduteDb.getData());
        smartScheduteDb.close();
        setListAdapter(mAdapter);

        getListView().setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {

                selectedItem =  position;
                // Launch the sample associated with this list position.
                Intent intent = new Intent(MainActivity.this, EventActivity.class);

                intent.putExtra(
                        SmartSchedulerDatabase.COLUMN_EVENT_ID,
                        contentValues.get(selectedItem).getAsInteger(
                                SmartSchedulerDatabase.COLUMN_EVENT_ID));

                MainActivity.this.startActivity(intent);
//                 Toast.makeText(getApplicationContext(), "setOnItemClickListener", Toast.LENGTH_LONG).show();

            }
        });

        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                    int position, long id) {

                if (mActionMode != null) {
                    return false;
                }
                selectedItem =  position;

                MainActivity.this.startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }

        });


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
                show();
                // Action picked, so close the CAB

                mode.finish();
                return true;
            case R.id.menuitem2_delete:
                // TODO remove in database
                contentValues.remove(selectedItem);

                mode.finish();
                return true;
            default:
                return false;
            }
        }

        // Called when the user exits the action mode
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
            selectedItem  = -1;
        }
    };

    private void show() {
        Toast.makeText(MainActivity.this,
                String.valueOf(selectedItem), Toast.LENGTH_LONG).show();
    }
   class EventAdapter extends BaseAdapter{
        private Activity mContext;

        public EventAdapter(Activity context, ArrayList<ContentValues> cV) {
            mContext =  context;
            contentValues = cV;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return contentValues.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row;
            row = inflater.inflate(R.layout.event_item, parent, false);
            TextView event_item_name = (TextView) row.findViewById(R.id.event_item_name);
            TextView event_item_initiator_time_hours = (TextView) row.findViewById(R.id.event_item_initiator_time_hours);
            Switch event_item_enable_switch = (Switch) row.findViewById(R.id.event_item_enable_switch);

            event_item_name.setText(contentValues.get(position).getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME));
            // TODO Chu y bien convert int sang boolean
            event_item_enable_switch.setChecked(
                    intToBool(contentValues.get(position).getAsInteger(
                            SmartSchedulerDatabase.COLUMN_ACTION_STATE)));

            event_item_enable_switch.setChecked(
                    intToBool(contentValues.get(position).getAsInteger(
                            SmartSchedulerDatabase.COLUMN_ACTION_STATE)));

            String  timer  =  contentValues.get(position).getAsString(
                    SmartSchedulerDatabase.COLUMN_EVENT_TIME_START )+ " : " +
                    contentValues.get(position).getAsString(
                    SmartSchedulerDatabase.COLUMN_EVENT_TIME_END);
            event_item_initiator_time_hours.setText(timer);
            return row;
        }
        private boolean intToBool(Integer integer) {
            if(integer == 1){
                return true;
            }
            return false;
        }

    }

}

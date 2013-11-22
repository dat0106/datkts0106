package com.smartschedule;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

public class EventActivity extends ListActivity {

    private EventAdapter mAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
//        ProgressBar progressBar = new ProgressBar(this);
//        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT));
//
//        getListView().setEmptyView(progressBar);
//        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
//        root.addView(progressBar);

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        String[]  name  =  {"1", "2", "3"};
        Boolean[] status = {true, false, true};
        mAdapter = new EventAdapter(name, status);
        setListAdapter(mAdapter);

    }

    private void setListAdapter(EventAdapter mAdapter2) {
        // TODO Auto-generated method stub

    }

    class EventAdapter extends BaseAdapter{

        private String[] name ;
        private Boolean[] status;

        public EventAdapter(String[] name, Boolean[] status) {
            this.name = name;
            this.status =  status;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 0;
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

            LayoutInflater inflater = getLayoutInflater();
            View row;
            row = inflater.inflate(R.layout.event_item, parent, false);
            TextView event_item_name = (TextView) row.findViewById(R.id.event_item_name);
            Switch event_item_enable_switch = (Switch) row.findViewById(R.id.event_item_enable_switch);

            event_item_name.setText(name[position]);
            event_item_enable_switch.setActivated(status[position]);;
            return row;
        }

    }
}

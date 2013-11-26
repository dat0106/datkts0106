package com.smartschedule;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));

        getListView().setEmptyView(progressBar);
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);


        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        String[]  name  =  {"1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3"};
        Boolean[] status = {true, false, true, true, false, true, true, false, true, true, false, true, true, false, true, true, false, true,true, false, true};
        mAdapter = new EventAdapter(this, name, status);
        setListAdapter(mAdapter);
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2" };
//
//        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
//        setListAdapter(adapter);


    }

   class EventAdapter extends BaseAdapter{
        private Activity mContext;
        private final String[] name ;
        private final Boolean[] status;


        public EventAdapter(Activity context, String[] name, Boolean[] status) {
            mContext =  context;
            this.name = name;
            this.status =  status;
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return name.length;
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

            try {
    			Thread.sleep(20);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		};
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row;
            row = inflater.inflate(R.layout.event_item, parent, false);
            TextView event_item_name = (TextView) row.findViewById(R.id.event_item_name);
            Switch event_item_enable_switch = (Switch) row.findViewById(R.id.event_item_enable_switch);

            event_item_name.setText(name[position]);
            event_item_enable_switch.setChecked(status[position]);
            return row;
        }

    }

}

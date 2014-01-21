package com.smartschedule;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Util;

public class MainActivity extends ListActivity {

    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);
    ScheduleServiceReceiver schedule = new ScheduleServiceReceiver();
    private EventAdapter mAdapter;
    private ArrayList<Event> contentValues;

    private int selectedItem = -1;
    protected Object mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        contentValues = getData();
        mAdapter = new EventAdapter(this);
        setListAdapter(mAdapter);

        getListView().setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

                selectedItem = position;
                // Launch the sample associated with this list position.
                startEventActivity();

            }
        });

        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                    int position, long id) {

                if (mActionMode != null) {
                    return false;
                }
                selectedItem = position;

                MainActivity.this.startActionMode(mActionModeCallback);
                view.setSelected(true);

                return true;
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // reload list view
        contentValues = getData();
        mAdapter.notifyDataSetChanged();

    }

    protected void startEventActivity() {
        Intent intent = new Intent(MainActivity.this, EventDetailActivity.class);
        intent.putExtra(
                SmartSchedulerDatabase.COLUMN_EVENT_ID,
                contentValues.get(selectedItem).getId());

        MainActivity.this.startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    // create add event
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case R.id.add_menu:
            final View View = android.view.View.inflate(this,
                    R.layout.dialog_add_event, null);

            final EditText textView = (EditText) View
                    .findViewById(R.id.dialog_add_event);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.title_dialog_add_event);
            builder.setView(View)
                    .setCancelable(false)
                    .setPositiveButton(R.string.create,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                    // get name to sent
                                    String checkDisableCreate = (String) textView
                                            .getText().toString();

                                    // TODO ADD event need more edit
                                    // image chua lam , state chua lam mac dinh
                                    // mang 0
                                    smartScheduleDb.open();
                                    smartScheduleDb.createData(
                                            checkDisableCreate, "image", 1, 2);
                                    smartScheduleDb.close();

                                    contentValues = getData();

                                    mAdapter.notifyDataSetChanged();

                                    dialog.dismiss();
                                }
                            })
                    .setNegativeButton(R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                    dialog.cancel();
                                }
                            });

            final AlertDialog dialog = builder.create();
            dialog.show();

            dialog.getButton(Dialog.BUTTON_POSITIVE).setEnabled(false);

            TextWatcher watcher = new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1,
                        int arg2, int arg3) {
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1,
                        int arg2, int arg3) {
                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    String checkDisableCreate = (String) textView.getText()
                            .toString();
                    if (checkDisableCreate.isEmpty()) {
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setEnabled(
                                false);
                    } else {
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setEnabled(
                                true);
                    }
                }
            };

            textView.addTextChangedListener(watcher);

            return true;
        }

        return super.onOptionsItemSelected(item);
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
                startEventActivity();
                mode.finish();
                return true;
            case R.id.menuitem2_delete:

                smartScheduleDb.open();
                int logDelete = smartScheduleDb.delete(contentValues.get(
                        selectedItem).getId());

                if (logDelete != 1) {
                    Log.e(MainActivity.this.toString(), "error delete event");
                }
                smartScheduleDb.close();

                contentValues = getData();
                mAdapter.notifyDataSetChanged();
                mode.finish();
                return true;
            default:
                return false;
            }
        }

        // Called when the user exits the action mode
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
            selectedItem = -1;
        }
    };

    private void show() {
        Toast.makeText(MainActivity.this, String.valueOf(selectedItem),
                Toast.LENGTH_LONG).show();
    }

    class EventAdapter extends BaseAdapter {
        private Activity mContext;

        public EventAdapter(Activity context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return contentValues.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // set selectedItem
            final int selected = position;

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row;
            row = inflater.inflate(R.layout.event_item, parent, false);
            TextView event_item_name = (TextView) row
                    .findViewById(R.id.event_item_name);
            TextView event_item_initiator_time_hours = (TextView) row
                    .findViewById(R.id.event_item_initiator_time_hours);
            Switch event_item_enable_switch = (Switch) row
                    .findViewById(R.id.event_item_enable_switch);

            event_item_name.setText(contentValues.get(selected).getName());
            // TODO Chu y bien convert int sang boolean

            int status = contentValues.get(selected).getState();

            if (status >= 2) {
                event_item_enable_switch.setEnabled(false);
            } else {
                event_item_enable_switch.setEnabled(true);
                event_item_enable_switch.setChecked(Util.intToBool(status));
            }

            event_item_enable_switch
                    .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,
                                boolean isChecked) {
                            if (isChecked) {
                                // update data
                                contentValues
                                        .get(selected)
                                        .setState(1);
                                update(contentValues.get(selected));
                                schedule.setSchedule(getApplicationContext(),
                                        contentValues.get(selected));
                            } else {
                                // update data
                                contentValues
                                        .get(selected)
                                        .setState(0);
                                update(contentValues.get(selected));
                                schedule.cancelSchedule(
                                        getApplicationContext(),
                                        contentValues.get(selected));
                            }
                        }
                    });

            String timer = Util
                    .getTime(contentValues
                            .get(selected)
                            .getTimeStartHour())

                    + ":"
                    + Util.getTime(contentValues
                            .get(selected)
                            .getTimeStartMinute())
                    + " ~ "
                    + Util.getTime(contentValues.get(selected).getTimeEndHour())
                    + ":"
                    + Util.getTime(contentValues
                            .get(selected)
                            .getTimeEndMinute());
            event_item_initiator_time_hours.setText(timer);
            return row;
        }

    }

    /* ----------------------- database ------------------------------ */
    /**
     * @return
     * @doc get content values in database
     */
    private ArrayList<Event> getData() {
        smartScheduleDb.openRead();
        ArrayList<Event> cV = smartScheduleDb.getData();
        smartScheduleDb.close();
        return cV;
    }

    private Event getData(int Id) {
        smartScheduleDb.openRead();
        Event cV = smartScheduleDb.getData(Id);
        smartScheduleDb.close();
        return cV;
    }

    private int update(Event cV) {
        ContentValues cv = new ContentValues();

        cv.put(SmartSchedulerDatabase.COLUMN_EVENT_STATE,
                cV.getState());

        smartScheduleDb.open();
        int result = smartScheduleDb.update_event(cv,
                cV.getId());
        smartScheduleDb.close();
        return result;
    }

}

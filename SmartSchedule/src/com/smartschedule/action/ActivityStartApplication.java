package com.smartschedule.action;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.DrawAction;
import com.smartschedule.EventDetailActivity;
import com.smartschedule.R;
import com.smartschedule.SmartScheduleApplication;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.utils.Constant;
import com.smartschedule.database.Action;

import java.util.ArrayList;
import java.util.List;

import static com.smartschedule.database.SmartSchedulerDatabase.COLUMN_ACTION_NAME;

/**
 * Created by ledat on 7/23/14.
 * @author ledat
 *
 */
public class ActivityStartApplication extends ListActivity {
    private StartApplicationAdapter mAdapter;
    private PackageManager packageManager;
    private List<ApplicationInfo> applist;
    private String packageLabelChoise;
    private String packageNameChoise;
    private int event_id;
    private SmartSchedulerDatabase smartScheduleDb;
    private Action action;
    private String start_or_end;
    private Gson gson;
    private DrawAction drawAction;

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(android.net.Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icon_text_checkbox_listview);


        smartScheduleDb = new SmartSchedulerDatabase(this);

        // xu ly intent
        Intent intent = getIntent();

        this.event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);

        action = intent.getExtras().getParcelable(Constant.ACTION_PARAMS);
        start_or_end = intent.getExtras().getString(Constant.START_OR_END);
        GsonBuilder gsonb = new GsonBuilder();
        gson = gsonb.create();
        if(action == null) {
            drawAction = gson.fromJson("{}", DrawAction.class);
        } else {
            drawAction = gson.fromJson(action.getDrawAction(), DrawAction.class);
        }

        packageLabelChoise = drawAction.package_label_application;
        packageNameChoise =  drawAction.package_name_application;

        packageManager = SmartScheduleApplication.getAppContext().getPackageManager();
        applist = checkForLaunchIntent(
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA));

        mAdapter = new StartApplicationAdapter(this, applist);
        setListAdapter(mAdapter);

        for(ApplicationInfo item : applist){
            String label = (String)item.loadLabel(packageManager);
            String name = item.packageName;
            if(label.equals(packageLabelChoise) && name.equals(packageNameChoise)){
                this.setSelection(applist.indexOf(item));
                break;
            }
        }

    }

    /**
     * This method will be called when an item in the list is selected.
     * Subclasses should override. Subclasses can call
     * getListView().getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param l        The ListView where the click happened
     * @param v        The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id       The row id of the item that was clicked
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        packageLabelChoise =  (String) applist.get(position).loadLabel(packageManager);
        packageNameChoise =  applist.get(position).packageName;
                // get data to update database
        ContentValues contentValue = new ContentValues();

        drawAction.package_name_application = packageNameChoise;
        drawAction.package_label_application = packageLabelChoise;

        contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW,
                gson.toJson(drawAction));
        contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATUS,
               packageLabelChoise);
        contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATE,
                Constant.ROUTER_START_APPLICATION);
        contentValue.put(COLUMN_ACTION_NAME,
                R.string.name_bluetooth);

        smartScheduleDb.open();
        if (action == null) {
            if (Constant.START.equals(start_or_end)) {
                contentValue.put(
                        SmartSchedulerDatabase.COLUMN_ACTION_START_ID,
                        event_id);
            } else if (Constant.END.equals(start_or_end)) {
                contentValue.put(
                        SmartSchedulerDatabase.COLUMN_ACTION_END_ID,
                        event_id);
            } else {
                Log.e(((Object) this).toString(),
                        "we can not check start or end");
                throw new Error(
                        "we can not check start or end");
            }

            smartScheduleDb.insert_action(contentValue);
        } else {
            smartScheduleDb.update_action(contentValue, action.getId());
        }
        Intent intent = new Intent(this, EventDetailActivity.class);
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

        this.startActivity(intent);

        finish();

    }

    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list)
    {
        ArrayList<ApplicationInfo> applist = new ArrayList<ApplicationInfo>();

        for(ApplicationInfo info: list)
        {
            try {
                if(null != SmartScheduleApplication.getAppContext().getPackageManager().getLaunchIntentForPackage(info.packageName))
                {
                    applist.add(info);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return applist;
    }
    private class StartApplicationAdapter extends BaseAdapter{
        private final Activity mContext;
        private final List<ApplicationInfo> mApplist;
        public StartApplicationAdapter(Activity context, List<ApplicationInfo> applist) {
            mContext = context;
            mApplist = applist;
        }

        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            return mApplist.size();
        }

        /**
         * Get the data item associated with the specified position in the data set.
         *
         * @param position Position of the item whose data we want within the adapter's
         *                 data set.
         * @return The data at the specified position.
         */
        @Override
        public Object getItem(int position) {
            return mApplist.get(position);
        }

        /**
         * Get the row id associated with the specified position in the list.
         *
         * @param position The position of the item within the adapter's data set whose row id we want.
         * @return The id of the item at the specified position.
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * Get a View that displays the data at the specified position in the data set. You can either
         * create a View manually or inflate it from an XML layout file. When the View is inflated, the
         * parent View (GridView, ListView...) will apply default layout parameters unless you use
         * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
         * to specify a root view and to prevent attachment to the root.
         *
         * @param position    The position of the item within the adapter's data set of the item whose view
         *                    we want.
         * @param convertView The old view to reuse, if possible. Note: You should check that this view
         *                    is non-null and of an appropriate type before using. If it is not possible to convert
         *                    this view to display the correct data, this method can create a new view.
         *                    Heterogeneous lists can specify their number of view types, so that this View is
         *                    always of the right type (see {@link #getViewTypeCount()} and
         *                    {@link #getItemViewType(int)}).
         * @param parent      The parent that this view will eventually be attached to
         * @return A View corresponding to the data at the specified position.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            LayoutInflater inflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.icon_text_checkbox_itemview, parent, false);

            ApplicationInfo data = mApplist.get(position);

            if(null != data)
            {
                TextView textName = (TextView)view.findViewById(R.id.applicationName);
                ImageView iconview = (ImageView)view.findViewById(R.id.applicationImageIcon);
                RadioButton radioButton = (RadioButton)view.findViewById(R.id.applicationRadioButton);
                String label = (String)data.loadLabel(packageManager);
                String pName =  data.packageName;
                textName.setText(label);
                iconview.setImageDrawable(data.loadIcon(packageManager));

                if(label.equals(packageLabelChoise) && pName.equals(packageNameChoise)) {
                    radioButton.setChecked(true);
                }else{
                    radioButton.setChecked(false);
                }
            }

            return view;

        }
    }


    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p/>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p/>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link android.view.Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p/>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p/>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // when the user click start schedule
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // for more.

                finish();
                return true;
            case R.id.cancel:
                // schedule.cancelSchedule(this, 1);
                // do nothing
                finish();
                return true;
        }
        return false;
    }
}

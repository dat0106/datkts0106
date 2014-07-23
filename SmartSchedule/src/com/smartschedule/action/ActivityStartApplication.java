package com.smartschedule.action;

import android.app.Activity;
import android.app.ListActivity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.smartschedule.R;
import com.smartschedule.SmartScheduleApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ledat on 7/23/14.
 * @author ledat
 *
 */
public class ActivityStartApplication extends ListActivity {
    private StartApplicationAdapter mAdapter;
    private PackageManager packageManager;

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


        List<ApplicationInfo> applist = checkForLaunchIntent(
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
        ApplicationInfo app = applist.get(1);

        Log.v(this.toString(), app.loadLabel(packageManager) + " (" + app.packageName + ")");
//        iconview.setImageDrawable(data.loadIcon(packageManager));
        mAdapter = new StartApplicationAdapter(this);
        setListAdapter(mAdapter);
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

        public StartApplicationAdapter(Activity context) {
            mContext = context;
        }

        /**
         * How many items are in the data set represented by this Adapter.
         *
         * @return Count of items.
         */
        @Override
        public int getCount() {
            return 0;
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
            return null;
        }

        /**
         * Get the row id associated with the specified position in the list.
         *
         * @param position The position of the item within the adapter's data set whose row id we want.
         * @return The id of the item at the specified position.
         */
        @Override
        public long getItemId(int position) {
            return 0;
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


            return null;
        }
    }


}

package com.smartschedule.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.DrawAction;
import com.smartschedule.EventDetailActivity;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;
import com.smartschedule.util.DetailActionViewer;
import com.smartschedule.util.Router;

import android.app.ExpandableListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class SettingActivity extends ExpandableListActivity implements
        OnChildClickListener {

    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);
    private int event_id;
    private ContentValues eventDetail;
    private ContentValues actionStart;
    private ContentValues actionEnd;
    SettingAdapter mNewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        this.event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);

        ExpandableListView expandbleLis = getExpandableListView();
        expandbleLis.setDividerHeight(2);
        expandbleLis.setGroupIndicator(null);
        expandbleLis.setClickable(true);

        setGroupData();
        setChildGroupData();

        mNewAdapter = new SettingAdapter(groupItem,
                childItem, event_id);
        mNewAdapter
                .setInflater(
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                        this);
        expandbleLis.setAdapter(mNewAdapter);
        expandbleLis.setDivider(null);
        expandbleLis.setDividerHeight(0);

        for (int i = 0; i < groupItem.size(); i++) {
            expandbleLis.expandGroup(i);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        setGroupData();
        setChildGroupData();
        mNewAdapter.UpdateDataChange(groupItem, childItem, event_id);
        mNewAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // when the user click start schedule
        case android.R.id.home:
            // Navigate "up" the demo structure to the launchpad activity.
            // for more.
            NavUtils.navigateUpTo(this, new Intent(this, EventDetailActivity.class));

            return true;

        }
        return false;

    }

    public void setGroupData() {
        // TODO String chuyen da ngon ngu
        groupItem.clear();
        groupItem.add("APPLICATIONS");
        groupItem.add("MEDIA");
        groupItem.add("SOUND");
        groupItem.add("COMMUNICATION");
        groupItem.add("WIRELESS & NETWORK");
        groupItem.add("DISPLAY");
        groupItem.add("TEXT TO SPEECH");
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    public void setChildGroupData() {
        HashMap<Integer,DetailActionViewer>  routerUri = Router.routerUri;

        ArrayList<Action> childAction = new ArrayList<Action>();
        childAction = smartScheduleDb.getDataAction(event_id, Constant.START);

        smartScheduleDb.close();

        ArrayList<DetailActionViewer> applications = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> media = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> sound = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> communication = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> wirelessAndNetwork = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> display = new ArrayList<DetailActionViewer>();
        ArrayList<DetailActionViewer> textToSpeech = new ArrayList<DetailActionViewer>();

        List<DetailActionViewer> list = new ArrayList<DetailActionViewer>(routerUri.values());

        for (DetailActionViewer detailActionViewer : list) {
            switch (detailActionViewer.category) {
            case Constant.CATEGORY_APPLICATIONS:
                applications.add(detailActionViewer);
                break;
            case Constant.CATEGORY_MEDIA:
                media.add(detailActionViewer);
                break;
            case Constant.CATEGORY_SOUND:
                sound.add(detailActionViewer);
            case Constant.CATEGORY_COMMUNICATION:
                communication.add(detailActionViewer);
            case Constant.CATEGORY_WIRELESS_NETWORK:
                wirelessAndNetwork.add(detailActionViewer);
            case Constant.CATEGORY_DISPLAY:
                display.add(detailActionViewer);
            case Constant.CATEGORY_TEXT_TO_SPEECH:
                textToSpeech.add(detailActionViewer);
                break;
            default:
                break;
            }
        }

        childItem.clear();


        /**
         * Add Data For APPLICATIONS
         */
        childItem.add(applications);
        /**
         * Add Data For MEDIA
         */
        childItem.add(media);

        /**
         * Add Data For sound
         */
        childItem.add(sound);
        /**
         * Add Data For communication
         */
        childItem.add(communication);
        /**
         * Add Data For wirelessAndNetwork
         */
        childItem.add(wirelessAndNetwork);
        /**
         * Add Data For DISPLAY
         */
        childItem.add(display);
        /**
         * Add Data For textToSpeech
         */
        childItem.add(textToSpeech);

    }

}

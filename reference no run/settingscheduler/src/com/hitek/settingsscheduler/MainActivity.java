package com.hitek.settingsscheduler;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ToggleButton;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity
  extends Activity
  implements AdapterView.OnItemClickListener, AdListener
{
  ListView listViewTasks;
  private ArrayList<ArrayList<String>> tasks;
  TasksAdapter tasksAdapter;
  
  private ArrayList<ArrayList<String>> getTaskList()
  {
    this.tasks = new ArrayList();
    for (;;)
    {
      try
      {
        localSharedPreferences = getSharedPreferences("Tasks", 4);
        localIterator = localSharedPreferences.getAll().keySet().iterator();
        boolean bool = localIterator.hasNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        SharedPreferences localSharedPreferences;
        Iterator localIterator;
        String str;
        ArrayList localArrayList;
        localException.printStackTrace();
        continue;
      }
      return this.tasks;
      str = (String)localIterator.next();
      if (str.contains("taskID_"))
      {
        localArrayList = new ArrayList();
        str = localSharedPreferences.getString(str, "");
        localArrayList.add(str);
        localArrayList.add(localSharedPreferences.getString("enabled_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("taskType_" + str, getResources().getString(2131034119)));
        localArrayList.add(localSharedPreferences.getString("value_" + str, new ToggleButton(this).getTextOn().toString()));
        localArrayList.add(localSharedPreferences.getString("hour_" + str, "12"));
        localArrayList.add(localSharedPreferences.getString("minute_" + str, "00"));
        localArrayList.add(localSharedPreferences.getString("sunday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("monday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("tuesday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("wednesday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("thursday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("friday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("saturday_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("week1_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("week2_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("week3_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("week4_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("week5_" + str, "true"));
        localArrayList.add(localSharedPreferences.getString("weekOdd_" + str, "false"));
        localArrayList.add(localSharedPreferences.getString("weekEven_" + str, "false"));
        this.tasks.add(localArrayList);
      }
    }
  }
  
  public void onAddTaskClick(View paramView)
  {
    Intent localIntent = new Intent(this, TaskSettingsActivity.class);
    localIntent.putExtra("taskID", "");
    startActivity(localIntent);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    int i = paramMenuItem.getItemId();
    String[] arrayOfString = getResources().getStringArray(2131165184);
    localObject = (String)((ArrayList)this.tasks.get(((AdapterView.AdapterContextMenuInfo)localObject).position)).get(0);
    if (arrayOfString[i].equals(getResources().getString(2131034116)))
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("Tasks", 4).edit();
      localEditor.remove("taskID_" + (String)localObject);
      localEditor.remove("enabled_" + (String)localObject);
      localEditor.remove("taskType_" + (String)localObject);
      localEditor.remove("value_" + (String)localObject);
      localEditor.remove("hour_" + (String)localObject);
      localEditor.remove("minute_" + (String)localObject);
      localEditor.remove("sunday_" + (String)localObject);
      localEditor.remove("monday_" + (String)localObject);
      localEditor.remove("tuesday_" + (String)localObject);
      localEditor.remove("wednesday_" + (String)localObject);
      localEditor.remove("thursday_" + (String)localObject);
      localEditor.remove("friday_" + (String)localObject);
      localEditor.remove("saturday_" + (String)localObject);
      localEditor.remove("week1_" + (String)localObject);
      localEditor.remove("week2_" + (String)localObject);
      localEditor.remove("week3_" + (String)localObject);
      localEditor.remove("week4_" + (String)localObject);
      localEditor.remove("week5_" + (String)localObject);
      localEditor.remove("weekOdd_" + (String)localObject);
      localEditor.remove("weekEven_" + (String)localObject);
      localEditor.commit();
      this.tasksAdapter.removeEntryFromTaskList((String)localObject);
      this.tasksAdapter.notifyDataSetChanged();
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (paramView.getId() == 2131296259)
    {
      String[] arrayOfString = getResources().getStringArray(2131165184);
      for (int i = 0; i < arrayOfString.length; i++) {
        paramContextMenu.add(0, i, i, arrayOfString[i]);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  public void onDismissScreen(Ad paramAd) {}
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this, TaskSettingsActivity.class);
    localIntent.putExtra("taskID", (String)((ArrayList)this.tasks.get(paramInt)).get(0));
    startActivity(localIntent);
  }
  
  public void onLeaveApplication(Ad paramAd) {}
  
  public void onPresentScreen(Ad paramAd) {}
  
  public void onReceiveAd(Ad paramAd) {}
  
  public void onResume()
  {
    super.onResume();
    this.listViewTasks = ((ListView)findViewById(2131296259));
    this.tasks = getTaskList();
    this.tasksAdapter = new TasksAdapter(this, this.tasks);
    this.listViewTasks.setAdapter(this.tasksAdapter);
    registerForContextMenu(this.listViewTasks);
    this.listViewTasks.setOnItemClickListener(this);
    new ScheduleManager(this).scheduleAllTasks();
    AdView localAdView = new AdView(this, AdSize.BANNER, "a150d239823e1fa");
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296256);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    localRelativeLayout.addView(localAdView, (ViewGroup.LayoutParams)localObject);
    localAdView.setAdListener(this);
    localObject = new AdRequest();
    ((AdRequest)localObject).addTestDevice(AdRequest.TEST_EMULATOR);
    ((AdRequest)localObject).addTestDevice("079375A20A34061F38A0100D6952E95B");
    localAdView.loadAd((AdRequest)localObject);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.MainActivity
 * JD-Core Version:    0.7.0.1
 */
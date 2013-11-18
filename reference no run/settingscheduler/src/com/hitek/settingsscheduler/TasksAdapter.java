package com.hitek.settingsscheduler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class TasksAdapter
  extends ArrayAdapter<ArrayList<String>>
{
  Activity context;
  private LayoutInflater inflater;
  private ArrayList<ArrayList<String>> taskList;
  
  public TasksAdapter(Activity paramActivity, ArrayList<ArrayList<String>> paramArrayList)
  {
    super(paramActivity, 2130903043, paramArrayList);
    this.context = paramActivity;
    this.taskList = paramArrayList;
    this.inflater = paramActivity.getLayoutInflater();
  }
  
  public ArrayList<String> getItem(int paramInt)
  {
    return (ArrayList)this.taskList.get(paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = getItem(paramInt);
    final String str1 = ((String)localArrayList.get(0)).toString();
    View localView = this.inflater.inflate(2130903043, null);
    Object localObject2 = this.context.getSharedPreferences("Tasks", 4);
    Object localObject1 = (ImageView)localView.findViewById(2131296286);
    final boolean bool = Boolean.valueOf(((SharedPreferences)localObject2).getString("enabled_" + str1, "true")).booleanValue();
    int j;
    if (bool)
    {
      ((ImageView)localObject1).setImageResource(2130837510);
      localObject2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SharedPreferences.Editor localEditor;
          if (!bool)
          {
            localEditor = this.val$prefs.edit();
            localEditor.putString("enabled_" + str1, "true");
            localEditor.commit();
            TasksAdapter.this.notifyDataSetChanged();
          }
          else
          {
            localEditor = this.val$prefs.edit();
            localEditor.putString("enabled_" + str1, "false");
            localEditor.commit();
            TasksAdapter.this.notifyDataSetChanged();
          }
        }
      };
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      localObject1 = (TextView)localView.findViewById(2131296288);
      j = 0;
    }
    try
    {
      int i = Integer.parseInt(((String)localArrayList.get(2)).toString());
      j = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label162:
      Object localObject4;
      String str3;
      Object localObject3;
      break label162;
    }
    localObject4 = new TaskTypes(this.context);
    str3 = ((TaskTypes)localObject4).getTaskTypeString(j);
    localObject3 = ((String)localArrayList.get(3)).toString();
    if (((String)localObject3).equals("on"))
    {
      localObject3 = this.context.getResources().getString(2131034117);
      label222:
      ((TextView)localObject1).setText(str3 + " " + (String)localObject3);
      ((ImageView)localView.findViewById(2131296287)).setImageResource(((TaskTypes)localObject4).getTaskTypeImage(j));
      localObject1 = (TextView)localView.findViewById(2131296289);
      localObject3 = ((String)localArrayList.get(4)).toString();
      if (Build.VERSION.SDK_INT < 9) {
        break label1108;
      }
      localObject4 = DateFormatSymbols.getInstance(Locale.getDefault()).getAmPmStrings();
    }
    for (;;)
    {
      String str2 = localObject4[0];
      int k = Integer.parseInt((String)localObject3);
      if (k > 12)
      {
        str2 = localObject4[1];
        localObject3 = Integer.toString(k - 12);
      }
      if (k == 12) {
        str2 = localObject4[1];
      }
      localObject4 = ((String)localArrayList.get(5)).toString();
      if (((String)localObject4).length() == 1) {
        localObject4 = "0" + (String)localObject4;
      }
      if (((String)localObject3).length() == 1) {
        localObject3 = "0" + (String)localObject3;
      }
      ((TextView)localObject1).setText(localObject3 + ":" + (String)localObject4 + " " + str2);
      localObject1 = new DateFormatSymbols().getShortWeekdays();
      localObject3 = (TextView)localView.findViewById(2131296290);
      String str8 = "<font color=\"#00FFFF\">" + localObject1[1] + "&nbsp;</font>";
      if (((String)localArrayList.get(6)).toString().equals("false")) {
        str8 = "<font color=\"#999999\">" + localObject1[1] + "&nbsp;</font>";
      }
      localObject4 = "<font color=\"#00FFFF\">" + localObject1[2] + "&nbsp;</font>";
      if (((String)localArrayList.get(7)).toString().equals("false")) {
        localObject4 = "<font color=\"#999999\">" + localObject1[2] + "&nbsp;</font>";
      }
      String str4 = "<font color=\"#00FFFF\">" + localObject1[3] + "&nbsp;</font>";
      if (((String)localArrayList.get(8)).toString().equals("false")) {
        str4 = "<font color=\"#999999\">" + localObject1[3] + "&nbsp;</font>";
      }
      String str5 = "<font color=\"#00FFFF\">" + localObject1[4] + "&nbsp;</font>";
      if (((String)localArrayList.get(9)).toString().equals("false")) {
        str5 = "<font color=\"#999999\">" + localObject1[4] + "&nbsp;</font>";
      }
      str2 = "<font color=\"#00FFFF\">" + localObject1[5] + "&nbsp;</font>";
      if (((String)localArrayList.get(10)).toString().equals("false")) {
        str2 = "<font color=\"#999999\">" + localObject1[5] + "&nbsp;</font>";
      }
      String str6 = "<font color=\"#00FFFF\">" + localObject1[6] + "&nbsp;</font>";
      if (((String)localArrayList.get(11)).toString().equals("false")) {
        str6 = "<font color=\"#999999\">" + localObject1[6] + "&nbsp;</font>";
      }
      String str7 = "<font color=\"#00FFFF\">" + localObject1[7] + "&nbsp;</font>";
      if (((String)localArrayList.get(12)).toString().equals("false")) {
        str7 = "<font color=\"#999999\">" + localObject1[7] + "&nbsp;</font>";
      }
      ((TextView)localObject3).setText(Html.fromHtml(str8 + (String)localObject4 + str4 + str5 + str2 + str6 + str7));
      return localView;
      ((ImageView)localObject1).setImageResource(2130837509);
      break;
      if (!((String)localObject3).equals("off")) {
        break label222;
      }
      localObject3 = this.context.getResources().getString(2131034118);
      break label222;
      label1108:
      localObject4 = new String[2];
      localObject4[0] = "AM";
      localObject4[1] = "PM";
    }
  }
  
  public void removeEntryFromTaskList(String paramString)
  {
    int i = 0;
    while (i < this.taskList.size()) {
      if (!((String)((ArrayList)this.taskList.get(i)).get(0)).toString().equals(paramString)) {
        i++;
      } else {
        this.taskList.remove(i);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.TasksAdapter
 * JD-Core Version:    0.7.0.1
 */
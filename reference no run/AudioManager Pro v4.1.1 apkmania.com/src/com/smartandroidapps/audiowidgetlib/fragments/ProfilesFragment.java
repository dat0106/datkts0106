package com.smartandroidapps.audiowidgetlib.fragments;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import com.mobeta.android.dslv.DragSortListView.RemoveListener;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;
import com.smartandroidapps.audiowidgetlib.activities.EditDialogActivity;
import com.smartandroidapps.audiowidgetlib.activities.MainActivity;
import com.smartandroidapps.audiowidgetlib.activities.ScheduleActivity;
import com.smartandroidapps.audiowidgetlib.activities.SettingsActivity;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.ui.CustomImageButton;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProfilesFragment
  extends SherlockFragment
  implements Constants
{
  public static boolean isProfilesActive = false;
  private final int CONTEXT_DELETE = 2;
  private final int CONTEXT_EDIT = 5;
  private final int CONTEXT_RENAME = 1;
  private final int CONTEXT_SCHEDULE = 4;
  private final int CONTEXT_SHORTCUT = 3;
  private int alarmIcon;
  private AudioManager am;
  private TextView anchor;
  private TextView anchor2;
  private int anchor2Color;
  private int anchorColor;
  private View.OnCreateContextMenuListener contextMenuListener = new View.OnCreateContextMenuListener()
  {
    public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
    {
      paramAnonymousContextMenu.setHeaderTitle(R.string.profile_options);
      paramAnonymousContextMenu.add(0, 1, 0, R.string.rename_title);
      paramAnonymousContextMenu.add(0, 5, 1, R.string.edit_title);
      paramAnonymousContextMenu.add(0, 2, 4, R.string.delete_title);
      paramAnonymousContextMenu.add(0, 3, 2, R.string.shortcut_title);
      paramAnonymousContextMenu.add(0, 4, 3, R.string.schedule_title);
    }
  };
  private boolean homeShortcut;
  private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      Object localObject = (Profile)ProfilesFragment.ProfilesAdapter.access$200(ProfilesFragment.this.mProfilesAdapter).get(paramAnonymousInt);
      if (!ProfilesFragment.this.homeShortcut)
      {
        ((Profile)localObject).changeStreamsToProfile();
        new SettingsManager(ProfilesFragment.this.getActivity()).editnew().putCurrentProfile(((Profile)localObject).getId()).commit();
        String str = ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter).getString(R.string.profile_applied);
        if (!str.contains("{0}")) {
          localObject = ((Profile)localObject).getName() + " " + str;
        } else {
          localObject = str.replace("{0}", ((Profile)localObject).getName());
        }
        Toast.makeText(ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter), (CharSequence)localObject, 0).show();
        ProfilesFragment.this.loadList();
        ProfilesFragment.this.updateConsoleUI();
      }
      else
      {
        localObject = MiscUtils.getProfileShortcutIntent(((Profile)localObject).getId(), ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter));
        ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter).startActivity((Intent)localObject);
        ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter).finish();
      }
    }
  };
  private AdapterView.OnItemClickListener itemClickListenerForShortcut = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      Profile localProfile = (Profile)ProfilesFragment.ProfilesAdapter.access$200(ProfilesFragment.this.mProfilesAdapter).get(paramAnonymousInt);
      ProfilesFragment.this.getActivity().setResult(-1, MiscUtils.getProfileCreateShortcutIntent(localProfile.getId(), localProfile.getName(), ProfilesFragment.this.getActivity()));
      ProfilesFragment.ProfilesAdapter.access$600(ProfilesFragment.this.mProfilesAdapter).finish();
    }
  };
  private int listColor;
  private int listSelectorColor;
  private int longPressedItem;
  private ProfilesAdapter mProfilesAdapter;
  private int moreBackground;
  private DragSortListView.DropListener onDrop = new DragSortListView.DropListener()
  {
    public void drop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 >= paramAnonymousInt2)
      {
        if (paramAnonymousInt2 >= paramAnonymousInt1) {
          break label50;
        }
        for (i = paramAnonymousInt1; i >= paramAnonymousInt2; i--) {
          ((Profile)ProfilesFragment.this.mProfilesAdapter.getItem(i)).setIndex(i + 1);
        }
      }
      label50:
      Profile localProfile;
      for (int i = paramAnonymousInt1;; localProfile++)
      {
        if (i > paramAnonymousInt2)
        {
          localProfile = (Profile)ProfilesFragment.this.mProfilesAdapter.getItem(paramAnonymousInt1);
          ProfilesFragment.this.mProfilesAdapter.remove(localProfile);
          ProfilesFragment.this.mProfilesAdapter.insert(localProfile, paramAnonymousInt2);
          localProfile.setIndex(paramAnonymousInt2);
          return;
        }
        ((Profile)ProfilesFragment.this.mProfilesAdapter.getItem(localProfile)).setIndex(localProfile - 1);
      }
    }
  };
  private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener()
  {
    public void remove(int paramAnonymousInt)
    {
      ProfilesFragment.this.mProfilesAdapter.remove(ProfilesFragment.this.mProfilesAdapter.getItem(paramAnonymousInt));
    }
  };
  private int profileIcon;
  private DragSortListView profileList;
  
  public static int checkProfileStreams(Context paramContext, boolean paramBoolean, AudioManager paramAudioManager)
  {
    SettingsManager localSettingsManager = new SettingsManager(paramContext);
    int i = -1;
    if (localSettingsManager != null) {
      i = localSettingsManager.getCurrentProfileID();
    }
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "ProfilesFragment.checkProfileStreams() start currProfileId: " + i);
    }
    int j = i;
    int k;
    Profile localProfile;
    ArrayList localArrayList;
    Iterator localIterator;
    if (i != -1)
    {
      k = 0;
      localProfile = Profile.getProfile(i, paramContext);
      if (localProfile == null)
      {
        j = -1;
        localSettingsManager.editnew().removeCurrentProfile().commit();
      }
      else
      {
        localArrayList = DynamicConsole.getActiveStreams(paramContext);
        localIterator = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (k < localArrayList.size())
        {
          j = -1;
          localSettingsManager.editnew().removeCurrentProfile().commit();
        }
        if (MiscUtils.isDebug()) {
          Log.d("AudioManager", "ProfilesFragment.checkProfileStreams() end currProfileId: " + j);
        }
        if ((j != i) || (paramBoolean))
        {
          SettingsActivity.updateProfileStatusAndNotification(paramContext);
          if ((localSettingsManager.getBoolean("statBar", false)) && (paramBoolean)) {
            SettingsActivity.nm.notify(1, SettingsActivity.console);
          }
        }
        return j;
      }
      Integer localInteger = (Integer)localIterator.next();
      if ((localProfile.getStreamValue(localInteger.intValue()) == paramAudioManager.getStreamVolume(localInteger.intValue())) || ((localProfile.getStreamValue(localInteger.intValue()) > paramAudioManager.getStreamMaxVolume(localInteger.intValue())) && (paramAudioManager.getStreamVolume(localInteger.intValue()) == paramAudioManager.getStreamMaxVolume(localInteger.intValue())))) {
        k++;
      }
    }
  }
  
  private void createProfileShortcut(int paramInt, String paramString)
  {
    MiscUtils.createProfileShortcut(paramInt, paramString, getActivity());
  }
  
  private void saveSortMode(int paramInt)
  {
    new SettingsManager(getActivity()).edit().putInt("sortMode", paramInt).commit();
    loadList();
  }
  
  private void setLayoutTheme()
  {
    String str = new SettingsManager(getActivity()).getTheme();
    if (!str.equals("darkBlue"))
    {
      if (!str.equals("normal"))
      {
        if (!str.equals("darkRed"))
        {
          if (!str.equals("darkGreen"))
          {
            if (!str.equals("darkYellow"))
            {
              if (str.equals("darkPink"))
              {
                this.anchorColor = Color.parseColor("#ffffff");
                this.anchor2Color = Color.parseColor("#e1e1e1");
                this.listSelectorColor = R.drawable.selectable_background_am_pink;
                this.listColor = Color.parseColor("#fb00ff");
                this.alarmIcon = R.drawable.alarm_dark;
                this.profileIcon = R.drawable.profile_dark;
                this.moreBackground = R.drawable.selectable_background_am_pink;
              }
            }
            else
            {
              this.anchorColor = Color.parseColor("#ffffff");
              this.anchor2Color = Color.parseColor("#e1e1e1");
              this.listSelectorColor = R.drawable.selectable_background_am_yellow;
              this.listColor = Color.parseColor("#ede20b");
              this.alarmIcon = R.drawable.alarm_dark;
              this.profileIcon = R.drawable.profile_dark;
              this.moreBackground = R.drawable.selectable_background_am_yellow;
            }
          }
          else
          {
            this.anchorColor = Color.parseColor("#ffffff");
            this.anchor2Color = Color.parseColor("#e1e1e1");
            this.listSelectorColor = R.drawable.selectable_background_am_green;
            this.listColor = Color.parseColor("#99cc00");
            this.alarmIcon = R.drawable.alarm_dark;
            this.profileIcon = R.drawable.profile_dark;
            this.moreBackground = R.drawable.selectable_background_am_green;
          }
        }
        else
        {
          this.anchorColor = Color.parseColor("#ffffff");
          this.anchor2Color = Color.parseColor("#e1e1e1");
          this.listSelectorColor = R.drawable.selectable_background_am_red;
          this.listColor = Color.parseColor("#cc0000");
          this.alarmIcon = R.drawable.alarm_dark;
          this.profileIcon = R.drawable.profile_dark;
          this.moreBackground = R.drawable.selectable_background_am_red;
        }
      }
      else
      {
        this.anchorColor = Color.parseColor("#000000");
        this.anchor2Color = Color.parseColor("#828282");
        this.listSelectorColor = R.drawable.selectable_background_am_green;
        this.listColor = Color.parseColor("#99cc00");
        this.alarmIcon = R.drawable.alarm;
        this.profileIcon = R.drawable.profile;
        this.moreBackground = R.drawable.selectable_background_am_green;
      }
    }
    else
    {
      this.anchorColor = Color.parseColor("#ffffff");
      this.anchor2Color = Color.parseColor("#e1e1e1");
      this.listSelectorColor = R.drawable.selectable_background_am_blue;
      this.listColor = Color.parseColor("#33b6e5");
      this.alarmIcon = R.drawable.alarm_dark;
      this.profileIcon = R.drawable.profile_dark;
      this.moreBackground = R.drawable.selectable_background_am_blue;
    }
  }
  
  private void showDeleteDialog(final Profile paramProfile, String paramString1, String paramString2)
  {
    String str3 = getString(R.string.delete_title);
    String str1 = getString(R.string.delete_message);
    final String str2 = getString(R.string.profile_deleted);
    final FragmentActivity localFragmentActivity = getActivity();
    new AlertDialog.Builder(localFragmentActivity).setTitle(str3).setMessage(str1).setPositiveButton(paramString1, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (((Profile)ProfilesFragment.this.mProfilesAdapter.getItem(ProfilesFragment.this.longPressedItem)).getId() == ProfilesFragment.checkProfileStreams(localFragmentActivity, false, ProfilesFragment.this.am)) {
          new SettingsManager(localFragmentActivity).editnew().removeCurrentProfile().commit();
        }
        paramProfile.Delete();
        Toast.makeText(ProfilesFragment.this.getActivity(), str2, 0).show();
        ProfilesFragment.this.loadList();
      }
    }).setNegativeButton(paramString2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  private void showRenameDialog(final Profile paramProfile, String paramString1, String paramString2)
  {
    String str2 = getString(R.string.rename_title);
    final String str1 = getString(R.string.profile_renamed);
    final View localView = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dialog_text_entry, null);
    ((TextView)localView.findViewById(R.id.ssid_description)).setText(R.string.rename_message);
    new AlertDialog.Builder(getActivity()).setTitle(str2).setView(localView).setPositiveButton(paramString1, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Object localObject = (EditText)localView.findViewById(R.id.profileName);
        CheckBox localCheckBox = (CheckBox)localView.findViewById(R.id.shortcut);
        localObject = ((EditText)localObject).getText().toString();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramProfile.setName((String)localObject);
          if (localCheckBox.isChecked()) {
            ProfilesFragment.this.createProfileShortcut(paramProfile.getId(), (String)localObject);
          }
          Toast.makeText(ProfilesFragment.this.getActivity(), str1, 0).show();
          ProfilesFragment.this.loadList();
        }
        else
        {
          Toast.makeText(ProfilesFragment.this.getActivity(), R.string.when_and_profile_fields_are_required, 0).show();
        }
      }
    }).setNegativeButton(paramString2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  private void showShortcutDialog(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(getActivity()).setTitle(R.string.shortcut_title).setMessage(R.string.shortcut_message).setPositiveButton(paramString1, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Profile localProfile = (Profile)ProfilesFragment.ProfilesAdapter.access$200(ProfilesFragment.this.mProfilesAdapter).get(ProfilesFragment.this.longPressedItem);
        MiscUtils.createProfileShortcut(localProfile.getId(), localProfile.getName(), ProfilesFragment.this.getActivity());
      }
    }).setNegativeButton(paramString2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
  }
  
  private void updateConsoleUI()
  {
    if ((getActivity() instanceof MainActivity)) {
      ((MainActivity)getActivity()).updateConsoleUI();
    }
  }
  
  public void loadList()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      checkProfileStreams(localFragmentActivity, false, this.am);
      int i = new SettingsManager(localFragmentActivity).getInt("sortMode", 0);
      this.mProfilesAdapter = new ProfilesAdapter(getActivity(), Profile.getProfiles(getActivity(), i));
      this.profileList.setAdapter(this.mProfilesAdapter);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.profileList.setDropListener(this.onDrop);
    this.profileList.setRemoveListener(this.onRemove);
    this.homeShortcut = getActivity().getIntent().getBooleanExtra("homeShortcut", false);
    String str = getActivity().getIntent().getAction();
    if ((str != null) && (str.equals("android.intent.action.CREATE_SHORTCUT")))
    {
      this.anchor2.setVisibility(8);
      this.profileList.setOnItemClickListener(this.itemClickListenerForShortcut);
    }
    else
    {
      this.profileList.setOnCreateContextMenuListener(this.contextMenuListener);
      this.profileList.setOnItemClickListener(this.itemClickListener);
      this.profileList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          ProfilesFragment.access$102(ProfilesFragment.this, paramAnonymousInt);
          return false;
        }
      });
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.am = ((AudioManager)paramActivity.getSystemService("audio"));
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Profile localProfile = (Profile)this.mProfilesAdapter.profiles.get(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position);
    String str2 = getString(R.string.ok);
    String str1 = getString(R.string.cancel);
    boolean bool1;
    Intent localIntent;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = super.onContextItemSelected(paramMenuItem);
      break;
    case 1: 
      if (!RunTimeConfig.isFullVersion(getActivity())) {
        RunTimeConfig.showBuyDialog(getActivity(), false, R.string.saving_profiles_upgrade_message);
      } else {
        showRenameDialog(localProfile, str2, bool1);
      }
      break;
    case 2: 
      if (!RunTimeConfig.isFullVersion(getActivity())) {
        RunTimeConfig.showBuyDialog(getActivity(), false, R.string.saving_profiles_upgrade_message);
      } else {
        showDeleteDialog(localProfile, str2, bool1);
      }
      break;
    case 3: 
      if (!RunTimeConfig.isFullVersion(getActivity())) {
        RunTimeConfig.showBuyDialog(getActivity(), false, R.string.saving_profiles_upgrade_message);
      } else {
        showShortcutDialog(str2, bool1);
      }
      break;
    case 4: 
      if (!RunTimeConfig.isFullVersion(getActivity()))
      {
        RunTimeConfig.showBuyDialog(getActivity(), false, R.string.saving_profiles_upgrade_message);
      }
      else
      {
        localIntent = new Intent(getActivity(), ScheduleActivity.class);
        localIntent.putExtra("profileId", ((Profile)this.mProfilesAdapter.profiles.get(this.longPressedItem)).getId());
        startActivity(localIntent);
      }
      break;
    case 5: 
      if (!RunTimeConfig.isFullVersion(getActivity()))
      {
        RunTimeConfig.showBuyDialog(getActivity(), false, R.string.saving_profiles_upgrade_message);
      }
      else
      {
        localIntent = new Intent(getActivity(), EditDialogActivity.class);
        localIntent.putExtra("editProfileId", ((Profile)this.mProfilesAdapter.profiles.get(this.longPressedItem)).getId());
        startActivity(localIntent);
      }
      break;
    }
    this.homeShortcut = false;
    boolean bool2 = true;
    return bool2;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setLayoutTheme();
    View localView = paramLayoutInflater.inflate(R.layout.profiles_fragment, null);
    this.profileList = ((DragSortListView)localView.findViewById(R.id.profile_list));
    this.profileList.setSelector(this.listSelectorColor);
    this.profileList.setDragBackgroundColor(this.listColor);
    this.anchor = ((TextView)localView.findViewById(R.id.anchor));
    this.anchor2 = ((TextView)localView.findViewById(R.id.anchor2));
    this.anchor.setTextColor(this.anchorColor);
    this.anchor2.setTextColor(this.anchor2Color);
    return localView;
  }
  
  public void onResume()
  {
    loadList();
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    isProfilesActive = true;
    setHasOptionsMenu(true);
  }
  
  public void onStop()
  {
    super.onStop();
    isProfilesActive = false;
  }
  
  private class ProfilesAdapter
    extends ArrayAdapter<Profile>
  {
    private SparseBooleanArray activeSchedules;
    private Activity context;
    private int currentProfileId;
    private String currentProfileTime;
    private boolean isLarge;
    private View.OnClickListener mOnClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ProfilesFragment.ProfilesAdapter.this.context.openContextMenu(paramAnonymousView);
      }
    };
    private List<Profile> profiles;
    
    ProfilesAdapter(List<Profile> paramList)
    {
      super(R.layout.list_layout, R.id.menuItem, localList);
      this.context = paramList;
      this.profiles = localList;
      this.currentProfileId = ProfilesFragment.checkProfileStreams(paramList, false, ProfilesFragment.this.am);
      this.currentProfileTime = getCurrentProfileTimeAsString();
      this.isLarge = MiscUtils.isAtLeastLargeHC(paramList);
      this.activeSchedules = Schedule.hasSchedules(paramList);
    }
    
    private String getCurrentProfileTimeAsString()
    {
      long l = new SettingsManager(this.context).getCurrentProfileTime();
      String str = "none";
      if (l != -1L)
      {
        Date localDate = new Date(l);
        str = android.text.format.DateFormat.getDateFormat(this.context).format(localDate) + " " + android.text.format.DateFormat.getTimeFormat(this.context).format(localDate);
      }
      return str;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(R.layout.list_layout, null);
      }
      TextView localTextView = (TextView)paramView.findViewById(R.id.menuItem);
      ImageView localImageView1 = (ImageView)paramView.findViewById(R.id.activeIcon);
      ImageView localImageView2 = (ImageView)paramView.findViewById(R.id.alarmIcon);
      CustomImageButton localCustomImageButton = (CustomImageButton)paramView.findViewById(R.id.moreIcon);
      localCustomImageButton.setBackgroundDrawable(this.context.getResources().getDrawable(ProfilesFragment.this.moreBackground));
      localCustomImageButton.setOnClickListener(this.mOnClickListener);
      int i = ((Profile)ProfilesFragment.this.mProfilesAdapter.getItem(paramInt)).getId();
      if (!this.activeSchedules.get(i)) {
        localImageView2.setImageDrawable(this.context.getResources().getDrawable(ProfilesFragment.this.profileIcon));
      } else {
        localImageView2.setImageDrawable(this.context.getResources().getDrawable(ProfilesFragment.this.alarmIcon));
      }
      if (i != this.currentProfileId) {
        localImageView1.setVisibility(8);
      } else {
        localImageView1.setVisibility(0);
      }
      localTextView.setText(((Profile)this.profiles.get(paramInt)).getName());
      localTextView.setTextColor(ProfilesFragment.this.anchorColor);
      return paramView;
    }
    
    public void notifyDataSetChanged()
    {
      this.currentProfileId = ProfilesFragment.checkProfileStreams(this.context, false, ProfilesFragment.this.am);
      this.currentProfileTime = getCurrentProfileTimeAsString();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment
 * JD-Core Version:    0.7.0.1
 */
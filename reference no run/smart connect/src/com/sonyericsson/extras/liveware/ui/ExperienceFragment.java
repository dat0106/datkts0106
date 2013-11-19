package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import com.example.android.bitmapfun.util.ImageWorker;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.asf.ExperienceService;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ActionSet.ActionSetEditor;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.ExperienceManager.EmException;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.ui.list.ListSeparator;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ImageGradientWorker;
import com.sonyericsson.extras.liveware.utils.PhotoUtils;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExperienceFragment
  extends Fragment
  implements ChooseImageTypeDialog.ChooseImageTypeListener, EditDialogFragment.EditDialogListener
{
  private static final int DEVICE_LOADER = 2;
  private static final String DIALOG_TAG_CHOOSE_IMAGE_TYPE = "dialog_choose_image_type";
  private static final String DIALOG_TAG_CREATE_EXPERIENCE = "dialog_create_experience";
  private static final String DIALOG_TAG_DELETE_EXPERIENCE = "dialog_delete_experience";
  private static final String DIALOG_TAG_RENAME_EXPERIENCE = "dialog_rename_experience";
  private static final String DIALOG_TAG_SELECT_TRIGGER = "dialog_select_trigger";
  private static final int EXPERIENCE_LOADER = 1;
  public static final String EXTRA_DEVICE_ID = "extra_device_id";
  public static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  public static final String EXTRA_IS_EDIT = "extra_is_edit";
  public static final String EXTRA_NEW_EXPERIENCE = "new_experience";
  public static final String KEY_ACTION_SET_UUID = "key_action_set_uuid";
  private static final String KEY_CURRENT_PHOTO_FILE = "key_current_photo_file";
  public static final String KEY_EXPERIENCE_ID = "key_experience_id";
  public static final String KEY_NEW_UUID = "key_new_uuid";
  private static final int REQUEST_CODE_CAMERA_WITH_DATA = 1;
  private static final int REQUEST_CODE_CHOOSE_DEVICE = 3;
  private static final int REQUEST_CODE_CREATE = 6;
  private static final int REQUEST_CODE_CREATE_ACTION = 8;
  public static final int REQUEST_CODE_EDIT_ACTION = 7;
  private static final int REQUEST_CODE_PHOTO_PICKED_WITH_DATA = 2;
  private static final int REQUEST_CODE_RENAME = 5;
  private static final int REQUEST_CODE_SET_TIME = 4;
  private String mActionSetUuid = null;
  private Activity mActivity;
  private ExperienceItemsAdapter mAdapter = null;
  private Object mContextMenuObject = null;
  private String mCurrentPhotoFile;
  private Device mDeviceToSet = null;
  private Experience mExperience = null;
  private long mExperienceId = -1L;
  private ExperienceManager mExperienceManager;
  private boolean mHasDeviceToSet = false;
  private boolean mHasTimeToSet = false;
  private ImageGradientWorker mImageWorker;
  private boolean mIsEdit = false;
  private ListView mListView = null;
  public UUID mNewUuid;
  private Uri mPictureUriToSet = null;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  private Time mTimeToSet = null;
  
  private void addStartActionRows(ArrayList<Object> paramArrayList)
  {
    paramArrayList.add(new ListSeparator(getString(2131099796)));
    paramArrayList.add(new ExperienceItemsAdapter.AddAction(2131099928, 0));
    if (this.mExperience != null)
    {
      List localList = this.mExperience.getAvailableStartActions();
      if (localList != null) {
        paramArrayList.addAll(localList);
      }
    }
  }
  
  private void addStopActionRows(ArrayList<Object> paramArrayList)
  {
    paramArrayList.add(new ListSeparator(getString(2131099797)));
    paramArrayList.add(new ExperienceItemsAdapter.AddAction(2131099929, 1));
    if (this.mExperience != null)
    {
      List localList = this.mExperience.getAvailableStopActions();
      if (localList != null) {
        paramArrayList.addAll(localList);
      }
    }
  }
  
  private void addTriggerRows(ArrayList<Object> paramArrayList)
  {
    Device localDevice = this.mExperience.getDevice();
    Time localTime = this.mExperience.getTime();
    paramArrayList.add(new ListSeparator(getString(2131099795)));
    if ((localTime == null) || (localDevice == null)) {
      paramArrayList.add(new ExperienceItemsAdapter.AddTrigger(2131099927));
    }
    if (localDevice != null) {
      paramArrayList.add(localDevice);
    }
    if (localTime != null) {
      paramArrayList.add(localTime);
    }
  }
  
  private int getActionSetIndex(ArrayList<Object> paramArrayList)
  {
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      Object localObject = paramArrayList.get(i);
      if (((localObject instanceof ActionSet)) && (((ActionSet)localObject).getUuid().equals(this.mNewUuid))) {
        return i;
      }
    }
    i = -1;
    return i;
  }
  
  private void initExperienceLoader(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_experience_id", paramLong);
    getLoaderManager().restartLoader(1, localBundle, new ExperienceLoaderCallbacks(null));
  }
  
  private boolean isEnabled()
  {
    boolean bool = false;
    if ((this.mExperience != null) && (this.mExperience.getEnabledState() == 2)) {
      bool = true;
    }
    return bool;
  }
  
  public static ExperienceFragment newInstance(long paramLong)
  {
    ExperienceFragment localExperienceFragment = new ExperienceFragment();
    Bundle localBundle = new Bundle();
    if (paramLong == -1L) {
      localBundle.putBoolean("new_experience", true);
    } else {
      localBundle.putLong("extra_experience_id", paramLong);
    }
    localExperienceFragment.setArguments(localBundle);
    return localExperienceFragment;
  }
  
  public static ExperienceFragment newInstance(Experience paramExperience)
  {
    ExperienceFragment localExperienceFragment = new ExperienceFragment();
    Bundle localBundle = new Bundle();
    if (paramExperience == null) {
      localBundle.putBoolean("new_experience", true);
    } else {
      localBundle.putLong("extra_experience_id", paramExperience.getId());
    }
    localExperienceFragment.setArguments(localBundle);
    return localExperienceFragment;
  }
  
  public static ExperienceFragment newInstanceWithDevice(long paramLong)
  {
    ExperienceFragment localExperienceFragment = new ExperienceFragment();
    Bundle localBundle = new Bundle();
    localBundle.putLong("extra_device_id", paramLong);
    localBundle.putBoolean("new_experience", true);
    localExperienceFragment.setArguments(localBundle);
    return localExperienceFragment;
  }
  
  private void onChooseImageSelected()
  {
    if (!this.mActivity.getPackageManager().hasSystemFeature("android.hardware.camera")) {
      onChooseAlbumImage();
    } else {
      showChooseImageTypeDialog();
    }
  }
  
  private void onDelete(Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    if (!(paramObject instanceof Time))
    {
      if (!(paramObject instanceof Device))
      {
        if ((paramObject instanceof ActionSet))
        {
          localObject1 = (ActionSet)paramObject;
          localObject2 = new DeleteActionSetTask(null);
          ActionSet[] arrayOfActionSet = new ActionSet[1];
          arrayOfActionSet[0] = localObject1;
          ((DeleteActionSetTask)localObject2).execute(arrayOfActionSet);
          if (this.mIsEdit) {
            SmartConnectAnalytics.trackEventAction(this.mActivity, "ActionRemove", ((ActionSet)localObject1).getAction());
          }
        }
      }
      else
      {
        updateExperienceDevice(null);
        localObject1 = new ExperienceUpdateTask(null);
        localObject2 = new Experience[1];
        localObject2[0] = this.mExperience;
        ((ExperienceUpdateTask)localObject1).execute((Object[])localObject2);
      }
    }
    else
    {
      setExperienceTime(null);
      localObject1 = new ExperienceUpdateTask(null);
      localObject2 = new Experience[1];
      localObject2[0] = this.mExperience;
      ((ExperienceUpdateTask)localObject1).execute((Object[])localObject2);
    }
  }
  
  private void onEdit(Object paramObject)
  {
    if (!(paramObject instanceof Time))
    {
      if (!(paramObject instanceof Device))
      {
        if ((paramObject instanceof ActionSet))
        {
          ActionSet localActionSet = (ActionSet)paramObject;
          this.mActionSetUuid = localActionSet.getUuid().toString();
          localActionSet.settingsUi(this, null, 7);
          if (this.mIsEdit) {
            SmartConnectAnalytics.trackEventAction(this.mActivity, "ActionEdit", localActionSet.getAction());
          }
        }
      }
      else {
        startActivityForResult(DeviceTriggerActivity.createIntent(this.mActivity, (Device)paramObject), 3);
      }
    }
    else {
      startActivityForResult(TimeTriggerActivity.createIntent(this.mActivity, (Time)paramObject), 4);
    }
  }
  
  private void onExperienceCreateCancel()
  {
    Dbg.d("onExperienceCreateCancel");
    if (((Boolean)this.mSaved.get()).booleanValue()) {
      Dbg.w("ExperienceFragment onExperienceCreateCancel ignored");
    } else {
      ((ExperienceFragmentContainer)this.mActivity).closeExperience();
    }
  }
  
  private void onExperienceCreated(String paramString)
  {
    Experience localExperience = new Experience(paramString, null, this.mDeviceToSet, null, null, 0L, 2, null);
    ExperienceCreateTask localExperienceCreateTask = new ExperienceCreateTask(null);
    Experience[] arrayOfExperience = new Experience[1];
    arrayOfExperience[0] = localExperience;
    localExperienceCreateTask.execute(arrayOfExperience);
    this.mHasDeviceToSet = false;
    this.mDeviceToSet = null;
  }
  
  private void onImageCropped(String paramString)
  {
    Object localObject = Uri.fromFile(new File(PhotoUtils.pathForCroppedPhoto(this.mActivity, paramString)));
    if (this.mExperience == null)
    {
      this.mPictureUriToSet = ((Uri)localObject);
    }
    else
    {
      this.mExperience.setPictureName(((Uri)localObject).toString());
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(null);
      localObject = new Experience[1];
      localObject[0] = this.mExperience;
      localExperienceUpdateTask.execute((Object[])localObject);
    }
    this.mCurrentPhotoFile = null;
  }
  
  private void onNewName(String paramString)
  {
    if (this.mExperience != null)
    {
      this.mExperience.setName(paramString);
      this.mExperience.setNameChangedByUser(true);
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(null);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      localExperienceUpdateTask.execute(arrayOfExperience);
    }
    else if (Dbg.e())
    {
      Dbg.e("onNewName: experience null");
    }
  }
  
  private void onPictureTaken(String paramString)
  {
    try
    {
      String str2 = PhotoUtils.pathForNewCameraPhoto(paramString);
      String str1 = PhotoUtils.pathForCroppedPhoto(this.mActivity, paramString);
      Activity localActivity = this.mActivity;
      Object localObject = new String[1];
      localObject[0] = str2;
      MediaScannerConnection.scanFile(localActivity, (String[])localObject, new String[1], null);
      localObject = PhotoUtils.getCropImageIntent(str2, str1);
      this.mCurrentPhotoFile = paramString;
      startActivityForResult((Intent)localObject, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Cannot crop image", localException);
        Toast.makeText(this.mActivity, 2131099942, 1).show();
      }
    }
  }
  
  private void renderBackgroundImage()
  {
    ImageView localImageView = (ImageView)getView().findViewById(2131558423);
    if (localImageView != null)
    {
      if ((localImageView.getDrawable() == null) || (!TextUtils.equals(ImageWorker.viewTagFromPictureName(this.mExperience.getPictureName()), (String)localImageView.getTag()))) {
        this.mImageWorker.loadImage(this.mExperience.getPictureName(), localImageView);
      }
      if ((BidiUtils.shouldMirror(localImageView)) || (UIUtils.isVanillaRtl(this.mActivity))) {
        localImageView.setScaleX(-1.0F);
      }
      localImageView.setAlpha(this.mExperience.getPictureAlpha());
    }
  }
  
  private void renderExperience()
  {
    boolean bool1 = true;
    Object localObject;
    if ((this.mExperience == null) || (this.mActivity == null))
    {
      if (Dbg.d())
      {
        StringBuilder localStringBuilder = new StringBuilder("ExperienceFragment renderExperience: ");
        boolean bool2;
        if (this.mExperience == null) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        localObject = localStringBuilder.append(bool2).append(" ");
        if (this.mActivity == null) {
          bool1 = false;
        }
        Dbg.d(bool1);
      }
    }
    else
    {
      View localView = this.mActivity.findViewById(2131558421);
      if (localView != null)
      {
        localView.setVisibility(0);
        localObject = new ArrayList();
        setTitle();
        renderHint();
        renderBackgroundImage();
        addTriggerRows((ArrayList)localObject);
        addStartActionRows((ArrayList)localObject);
        addStopActionRows((ArrayList)localObject);
        this.mAdapter.setData((List)localObject);
        scrollList((ArrayList)localObject);
        UIUtils.setViewEnabled(this.mActivity.findViewById(2131558421), isEnabled());
        UIUtils.applyDirectionality(localView);
      }
    }
  }
  
  private void renderHint()
  {
    View localView = getView().findViewById(2131558422);
    int i;
    if (!this.mExperience.isValid()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void setExperienceTime(Time paramTime)
  {
    Time localTime;
    if (this.mIsEdit)
    {
      localTime = this.mExperience.getTime();
      if ((localTime == null) || (paramTime == null))
      {
        if ((localTime != null) || (paramTime == null))
        {
          if ((localTime != null) && (paramTime == null)) {
            SmartConnectAnalytics.trackEvent(this.mActivity, "TriggerRemove", "None", "Time");
          }
        }
        else {
          SmartConnectAnalytics.trackEvent(this.mActivity, "TriggerAdd", "None", "Time");
        }
      }
      else {
        SmartConnectAnalytics.trackEvent(this.mActivity, "TriggerEdit", "None", "Time");
      }
    }
    if (paramTime != null)
    {
      localTime = this.mExperience.getTime();
      if (localTime != null)
      {
        localTime.setStartTime(paramTime.getStartTime());
        localTime.setStopTime(paramTime.getStopTime());
        localTime.setDaysRaw(paramTime.getDaysRaw());
        this.mExperience.setTime(localTime);
      }
      else
      {
        this.mExperience.setTime(paramTime);
      }
    }
    else
    {
      this.mExperience.setTime(null);
    }
  }
  
  private void setTitle()
  {
    this.mActivity.setTitle(this.mExperience.getName());
  }
  
  private void showChooseImageTypeDialog()
  {
    if (this.mExperience != null)
    {
      ChooseImageTypeDialog localChooseImageTypeDialog = ChooseImageTypeDialog.newInstance();
      localChooseImageTypeDialog.setTargetFragment(this, 0);
      showDialogFragment(localChooseImageTypeDialog, "dialog_choose_image_type");
    }
    else if (Dbg.e())
    {
      Dbg.e("showChooseImageTypeDialog: experience null");
    }
  }
  
  private void showDeleteDialog()
  {
    if (this.mExperience != null)
    {
      DeleteExperienceDialog localDeleteExperienceDialog = DeleteExperienceDialog.newInstance(this.mExperience.getName());
      localDeleteExperienceDialog.setTargetFragment(this, 0);
      showDialogFragment(localDeleteExperienceDialog, "dialog_delete_experience");
    }
    else if (Dbg.e())
    {
      Dbg.e("showDeleteDialog: experience null");
    }
  }
  
  private void showDeleteItems()
  {
    startActivity(DeleteItemsActivity.createIntent(this.mActivity, this.mExperience));
  }
  
  private void showDialogFragment(DialogFragment paramDialogFragment, String paramString)
  {
    if (!((Boolean)this.mSaved.get()).booleanValue())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      if (getFragmentManager().findFragmentByTag(paramString) == null)
      {
        localFragmentTransaction.addToBackStack(null);
        paramDialogFragment.show(localFragmentTransaction, paramString);
      }
    }
    else
    {
      Dbg.w("ExperienceFragment.showDialogFragment ignored");
    }
  }
  
  private void showRenameDialog()
  {
    if (this.mExperience != null)
    {
      EditDialogFragment localEditDialogFragment = new EditDialogFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_title_id", 2131099805);
      localBundle.putInt("extra_positive_button_id", 2131099806);
      localBundle.putString("extra_value", this.mExperience.getName());
      localBundle.putBoolean("extra_select_all_on_focus", true);
      localEditDialogFragment.setArguments(localBundle);
      localEditDialogFragment.setTargetFragment(this, 5);
      showDialogFragment(localEditDialogFragment, "dialog_rename_experience");
    }
    else if (Dbg.e())
    {
      Dbg.e("showRenameDialog: experience null");
    }
  }
  
  private boolean showStopAction()
  {
    boolean bool = false;
    if ((this.mExperience != null) && (this.mExperience.isStarted()) && (isEnabled())) {
      bool = this.mExperience.hasAvailableStopActions();
    }
    return bool;
  }
  
  private void startPickFromGalleryActivity(String paramString)
  {
    Intent localIntent = PhotoUtils.getPhotoPickIntent(this.mActivity, paramString);
    this.mCurrentPhotoFile = paramString;
    startActivityForResult(localIntent, 2);
  }
  
  private void startTakePhotoActivity(String paramString)
  {
    Intent localIntent = PhotoUtils.getTakePhotoIntent(paramString);
    this.mCurrentPhotoFile = paramString;
    startActivityForResult(localIntent, 1);
  }
  
  private void stopEvent()
  {
    Intent localIntent = ExperienceService.getTriggerIntent(this.mActivity, 2, false, this.mExperience.getId());
    this.mActivity.startService(localIntent);
  }
  
  private void toggleEnable(boolean paramBoolean)
  {
    if (this.mExperience != null)
    {
      if (paramBoolean) {
        this.mExperience.setEnabledState(2);
      } else {
        this.mExperience.setEnabledState(0);
      }
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(null);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      localExperienceUpdateTask.execute(arrayOfExperience);
      renderExperience();
    }
  }
  
  private void updateExperienceDevice(Device paramDevice)
  {
    if (this.mExperience == null)
    {
      this.mDeviceToSet = paramDevice;
      this.mHasDeviceToSet = true;
    }
    else
    {
      if (this.mIsEdit)
      {
        localObject = this.mExperience.getDevice();
        if ((localObject == null) || (paramDevice == null))
        {
          if ((localObject != null) || (paramDevice == null))
          {
            if ((localObject != null) && (paramDevice == null)) {
              SmartConnectAnalytics.trackEventDevice(this.mActivity, "TriggerRemove", (Device)localObject);
            }
          }
          else {
            SmartConnectAnalytics.trackEventDevice(this.mActivity, "TriggerAdd", paramDevice);
          }
        }
        else {
          SmartConnectAnalytics.trackEventDevice(this.mActivity, "TriggerEdit", paramDevice);
        }
      }
      this.mExperience.setDevice(paramDevice);
      getArguments().putLong("extra_device_id", -1L);
      Object localObject = new ExperienceUpdateTask(null);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      ((ExperienceUpdateTask)localObject).execute(arrayOfExperience);
      renderExperience();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject2;
      Object localObject1;
      switch (paramInt1)
      {
      case 5: 
      case 6: 
      default: 
        break;
      case 1: 
        onPictureTaken(this.mCurrentPhotoFile);
        break;
      case 2: 
        onImageCropped(this.mCurrentPhotoFile);
        break;
      case 3: 
        if (paramIntent.getLongExtra("selected_device_id", -1L) == -1L)
        {
          updateExperienceDevice(null);
        }
        else
        {
          localObject2 = getLoaderManager();
          localObject1 = paramIntent.getExtras();
          DeviceLoaderCallbacks localDeviceLoaderCallbacks = new DeviceLoaderCallbacks(null);
          ((LoaderManager)localObject2).restartLoader(2, (Bundle)localObject1, localDeviceLoaderCallbacks);
        }
        break;
      case 4: 
        localObject1 = null;
        if ((paramIntent.hasExtra("start_time")) && (paramIntent.hasExtra("stop_time")) && (paramIntent.hasExtra("weekdays"))) {
          localObject1 = new Time(paramIntent.getLongExtra("start_time", -1L), paramIntent.getLongExtra("stop_time", -1L), false, paramIntent.getIntExtra("weekdays", 254));
        }
        onTimeSet((Time)localObject1);
        break;
      case 7: 
        if (paramIntent != null)
        {
          localObject2 = paramIntent.getExtras();
          if (localObject2 != null)
          {
            localObject1 = ((Bundle)localObject2).getString("setting_raw");
            localObject2 = ((Bundle)localObject2).getString("setting_label");
            if ((paramInt2 != -1) || (localObject1 == null))
            {
              Dbg.e("Edit action result: resultCode: " + paramInt2 + " rawSetting: " + (String)localObject1);
            }
            else
            {
              localObject2 = new ActionSetUpdateTask(this.mActivity, this.mActionSetUuid.toString(), (String)localObject1, (String)localObject2);
              localObject1 = new String[1];
              localObject1[0] = this.mActionSetUuid.toString();
              ((ActionSetUpdateTask)localObject2).execute((Object[])localObject1);
            }
          }
          else
          {
            Dbg.e("Edit action result: null extras");
          }
        }
        else
        {
          Dbg.e("Edit action result: null intent");
        }
        break;
      case 8: 
        this.mNewUuid = UUID.fromString(paramIntent.getStringExtra("extra_uuid"));
        break;
      }
    }
    else
    {
      this.mCurrentPhotoFile = null;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCancel(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
      onExperienceCreateCancel();
    }
  }
  
  public void onChooseAlbumImage()
  {
    try
    {
      startPickFromGalleryActivity(PhotoUtils.generateFileName());
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        if (Dbg.w()) {
          Dbg.w("onChooseAlbumImage failed", localActivityNotFoundException);
        }
        Toast.makeText(this.mActivity, 2131099942, 1).show();
      }
    }
  }
  
  public void onChooseCameraImage()
  {
    try
    {
      startTakePhotoActivity(PhotoUtils.generateFileName());
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        if (Dbg.w()) {
          Dbg.w("onChooseCameraImage failed", localActivityNotFoundException);
        }
        Toast.makeText(this.mActivity, 2131099942, 1).show();
      }
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (this.mContextMenuObject != null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        if (!Dbg.e()) {
          return bool;
        }
        Dbg.e("onContextItemSelected item id: " + paramMenuItem.getItemId());
        break;
      case 2131558551: 
        onEdit(this.mContextMenuObject);
        break;
      case 2131558552: 
        onDelete(this.mContextMenuObject);
      }
      bool = true;
    }
    else
    {
      Dbg.e("onContextItemSelected object == null");
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = false;
    super.onCreate(paramBundle);
    Dbg.d("ExperienceFragment.onCreate");
    if (paramBundle == null)
    {
      if (!getArguments().getBoolean("new_experience")) {
        bool1 = true;
      }
      this.mIsEdit = bool1;
    }
    else
    {
      this.mExperienceId = paramBundle.getLong("key_experience_id", -1L);
      this.mActionSetUuid = paramBundle.getString("key_action_set_uuid");
      ParcelUuid localParcelUuid = (ParcelUuid)paramBundle.getParcelable("key_new_uuid");
      if (localParcelUuid != null) {
        this.mNewUuid = localParcelUuid.getUuid();
      }
      boolean bool2 = paramBundle.getBoolean("new_experience", false);
      getArguments().putBoolean("new_experience", bool2);
      this.mCurrentPhotoFile = paramBundle.getString("key_current_photo_file");
      this.mIsEdit = paramBundle.getBoolean("extra_is_edit");
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.mContextMenuObject = this.mAdapter.getItem(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if (!(this.mContextMenuObject instanceof ActionSet))
    {
      if (!(this.mContextMenuObject instanceof Device))
      {
        if ((this.mContextMenuObject instanceof Time))
        {
          this.mActivity.getMenuInflater().inflate(2131689474, paramContextMenu);
          paramContextMenu.setHeaderTitle(AsfTimeUtils.getFormattedTimeSpan((Time)this.mContextMenuObject, this.mActivity));
        }
      }
      else
      {
        this.mActivity.getMenuInflater().inflate(2131689474, paramContextMenu);
        paramContextMenu.setHeaderTitle(((Device)this.mContextMenuObject).getProductName());
      }
    }
    else
    {
      this.mActivity.getMenuInflater().inflate(2131689474, paramContextMenu);
      localObject = (ActionSet)this.mContextMenuObject;
      paramContextMenu.setHeaderTitle(((ActionSet)localObject).getFormattedString());
      if (TextUtils.isEmpty(((ActionSet)localObject).getAction().getActivityName())) {
        paramContextMenu.findItem(2131558551).setVisible(false);
      }
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = true;
    paramMenuInflater.inflate(2131689475, paramMenu);
    paramMenuInflater.inflate(2131689476, paramMenu);
    paramMenu.findItem(2131558553).setVisible(isEnabled());
    MenuItem localMenuItem = paramMenu.findItem(2131558555);
    boolean bool2;
    if ((this.mExperience == null) || (!isEnabled()) || (!this.mExperience.hasItems())) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    localMenuItem.setVisible(bool2);
    paramMenu.findItem(2131558554).setVisible(isEnabled());
    localMenuItem = paramMenu.findItem(2131558558);
    if (localMenuItem != null)
    {
      if ((this.mExperience == null) || ((!this.mExperience.isValid()) && (isEnabled()))) {
        bool1 = false;
      }
      localMenuItem.setVisible(bool1);
      if (localMenuItem.isVisible())
      {
        final Switch localSwitch = (Switch)localMenuItem.getActionView().findViewById(2131558404);
        new Handler().post(new Runnable()
        {
          public void run()
          {
            localSwitch.setChecked(ExperienceFragment.this.isEnabled());
            localSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
              public void onCheckedChanged(CompoundButton paramAnonymous2CompoundButton, boolean paramAnonymous2Boolean)
              {
                ExperienceFragment.this.toggleEnable(paramAnonymous2Boolean);
              }
            });
          }
        });
      }
    }
    paramMenu.findItem(2131558557).setVisible(showStopAction());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle == null) {
      this.mExperienceId = getArguments().getLong("extra_experience_id", -1L);
    }
    long l = getArguments().getLong("extra_device_id", -1L);
    Dbg.d("ExperienceFragment: onCreateView():" + this.mExperienceId);
    this.mExperienceManager = ExperienceManager.getInstance(this.mActivity);
    this.mImageWorker = new ImageGradientWorker(this.mActivity);
    if (this.mExperienceId != -1L) {
      initExperienceLoader(this.mExperienceId);
    }
    if (l != -1L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("selected_device_id", l);
      getLoaderManager().restartLoader(2, localBundle, new DeviceLoaderCallbacks(null));
    }
    setHasOptionsMenu(true);
    View localView = paramLayoutInflater.inflate(2130903055, null);
    UIUtils.applyDirectionality(localView);
    this.mListView = ((ListView)localView.findViewById(16908298));
    this.mAdapter = new ExperienceItemsAdapter(this.mActivity);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setOnItemClickListener(new ExperienceListListener());
    registerForContextMenu(this.mListView);
    return localView;
  }
  
  public void onDeleteExperience()
  {
    if (this.mExperience != null)
    {
      Dbg.d("onDeleteExperience");
      ((ExperienceFragmentContainer)this.mActivity).closeExperience();
      ExperienceDeleteTask localExperienceDeleteTask = new ExperienceDeleteTask(null);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      localExperienceDeleteTask.execute(arrayOfExperience);
    }
    else if (Dbg.e())
    {
      Dbg.e("onDeleteExperience: experience null");
    }
  }
  
  public void onDone(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
      onNewName(paramString);
      break;
    case 6: 
      onExperienceCreated(paramString);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      break;
    case 2131558553: 
      showRenameDialog();
      break;
    case 2131558554: 
      onChooseImageSelected();
      break;
    case 2131558555: 
      showDeleteItems();
      break;
    case 2131558556: 
      showDeleteDialog();
      break;
    case 2131558557: 
      stopEvent();
    }
    return bool;
  }
  
  public void onPause()
  {
    super.onPause();
    Dbg.d("ExperienceFragment: onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    Dbg.d("ExperienceFragment: onResume()");
    this.mSaved.set(Boolean.valueOf(false));
    boolean bool = getArguments().getBoolean("new_experience", false);
    getArguments().putBoolean("new_experience", false);
    if (!bool)
    {
      renderExperience();
    }
    else
    {
      EditDialogFragment localEditDialogFragment = new EditDialogFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_title_id", 2131099817);
      localBundle.putInt("extra_positive_button_id", 2131099819);
      localBundle.putInt("extra_hint_id", 2131099818);
      localEditDialogFragment.setArguments(localBundle);
      localEditDialogFragment.setTargetFragment(this, 6);
      showDialogFragment(localEditDialogFragment, "dialog_create_experience");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Dbg.d("ExperienceFragment: onSaveInstanceState");
    this.mSaved.set(Boolean.valueOf(true));
    if (this.mExperience == null)
    {
      if (this.mExperienceId != -1L) {
        paramBundle.putLong("key_experience_id", this.mExperienceId);
      }
    }
    else {
      paramBundle.putLong("key_experience_id", this.mExperience.getId());
    }
    paramBundle.putString("key_action_set_uuid", this.mActionSetUuid);
    paramBundle.putBoolean("new_experience", getArguments().getBoolean("new_experience", false));
    if (this.mCurrentPhotoFile != null) {
      paramBundle.putString("key_current_photo_file", this.mCurrentPhotoFile.toString());
    }
    if (this.mNewUuid != null) {
      paramBundle.putParcelable("key_new_uuid", new ParcelUuid(this.mNewUuid));
    }
    paramBundle.putBoolean("extra_is_edit", this.mIsEdit);
  }
  
  public void onTimeSet(Time paramTime)
  {
    if (this.mExperience == null)
    {
      this.mTimeToSet = paramTime;
      this.mHasTimeToSet = true;
    }
    else
    {
      setExperienceTime(paramTime);
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(null);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      localExperienceUpdateTask.execute(arrayOfExperience);
    }
  }
  
  public void onTriggerSelect(int paramInt)
  {
    Dbg.d("onTriggerSelect");
    if (paramInt != 1)
    {
      if (paramInt == 0) {
        startActivityForResult(DeviceTriggerActivity.createIntent(this.mActivity, null), 3);
      }
    }
    else {
      startActivityForResult(TimeTriggerActivity.createIntent(this.mActivity, null), 4);
    }
  }
  
  public void scrollList(ArrayList<Object> paramArrayList)
  {
    if (this.mNewUuid != null)
    {
      int i = getActionSetIndex(paramArrayList);
      if (i != -1)
      {
        this.mNewUuid = null;
        ((ListView)getView().findViewById(16908298)).setSelection(i);
      }
    }
  }
  
  private static class ActionSetUpdateTask
    extends AsyncTask<String, Void, Void>
  {
    private final String mActionSetUuid;
    private final String mLabel;
    private final ExperienceManager mManager;
    private final String mRawSetting;
    
    public ActionSetUpdateTask(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mActionSetUuid = paramString1;
      this.mLabel = paramString3;
      this.mRawSetting = paramString2;
    }
    
    protected Void doInBackground(String... paramVarArgs)
    {
      ActionSet localActionSet = this.mManager.getActionSetByUuid(this.mActionSetUuid);
      if (localActionSet != null)
      {
        if (this.mRawSetting.equals(localActionSet.getRawSetting()))
        {
          Dbg.d("ActionSetUpdateTask: not changed " + this.mRawSetting);
        }
        else
        {
          this.mManager.updateActionSet(localActionSet.edit().setRawSetting(this.mRawSetting).setSettingsLabel(this.mLabel));
          Dbg.d("ActionSetUpdateTask: updated to " + this.mRawSetting + " label: " + this.mLabel);
        }
      }
      else {
        Dbg.e("ActionSetUpdateTask: failed finding actionSet " + this.mActionSetUuid);
      }
      return null;
    }
  }
  
  private class DeleteActionSetTask
    extends AsyncTask<ActionSet, Void, Void>
  {
    private DeleteActionSetTask() {}
    
    protected Void doInBackground(ActionSet... paramVarArgs)
    {
      ExperienceFragment.this.mExperienceManager.deleteActionSet(paramVarArgs[0]);
      return null;
    }
  }
  
  private class DeviceLoaderCallbacks
    implements LoaderManager.LoaderCallbacks<Device>
  {
    private DeviceLoaderCallbacks() {}
    
    public Loader<Device> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      Dbg.d("DeviceLoaderCallbacks.onCreateLoader");
      long l = paramBundle.getLong("selected_device_id", -1L);
      return new DeviceLoader(ExperienceFragment.this.mActivity, l, false);
    }
    
    public void onLoadFinished(Loader<Device> paramLoader, Device paramDevice)
    {
      Dbg.d("DeviceLoaderCallbacks.onLoadFinished");
      ExperienceFragment.this.updateExperienceDevice(paramDevice);
      ExperienceFragment.this.getLoaderManager().destroyLoader(2);
    }
    
    public void onLoaderReset(Loader<Device> paramLoader)
    {
      Dbg.d("DeviceLoaderCallbacks.onLoaderReset");
    }
  }
  
  private class ExperienceCreateTask
    extends AsyncTask<Experience, Void, Experience>
  {
    private ExperienceCreateTask() {}
    
    protected Experience doInBackground(Experience... paramVarArgs)
    {
      return ExperienceFragment.this.mExperienceManager.addExperience(paramVarArgs[0]);
    }
    
    protected void onPostExecute(Experience paramExperience)
    {
      if (!((Boolean)ExperienceFragment.this.mSaved.get()).booleanValue()) {
        ExperienceFragment.this.initExperienceLoader(paramExperience.getId());
      } else {
        Dbg.w("ExperienceCreateTask onPostExecute ignored");
      }
    }
  }
  
  private class ExperienceDeleteTask
    extends AsyncTask<Experience, Void, Void>
  {
    private ExperienceDeleteTask() {}
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      try
      {
        ExperienceFragment.this.mExperienceManager.deleteExperience(paramVarArgs[0]);
        return null;
      }
      catch (ExperienceManager.EmException localEmException)
      {
        for (;;)
        {
          if (Dbg.e()) {
            Dbg.e("Delete experience failed", localEmException);
          }
        }
      }
    }
  }
  
  protected class ExperienceListListener
    implements AdapterView.OnItemClickListener
  {
    protected ExperienceListListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Object localObject;
      switch (ExperienceFragment.this.mAdapter.getItemViewType(paramInt))
      {
      case 0: 
        localObject = (Device)ExperienceFragment.this.mAdapter.getItem(paramInt);
        ExperienceFragment.this.startActivityForResult(DeviceTriggerActivity.createIntent(ExperienceFragment.this.mActivity, (Device)localObject), 3);
        break;
      case 1: 
        localObject = (Time)ExperienceFragment.this.mAdapter.getItem(paramInt);
        ExperienceFragment.this.startActivityForResult(TimeTriggerActivity.createIntent(ExperienceFragment.this.mActivity, (Time)localObject), 4);
        break;
      case 2: 
        localObject = (ActionSet)ExperienceFragment.this.mAdapter.getItem(paramInt);
        ExperienceFragment.this.mActionSetUuid = ((ActionSet)localObject).getUuid().toString();
        ((ActionSet)localObject).settingsUi(ExperienceFragment.this, null, 7);
        if (ExperienceFragment.this.mIsEdit) {
          SmartConnectAnalytics.trackEventAction(ExperienceFragment.this.mActivity, "ActionEdit", ((ActionSet)localObject).getAction());
        }
        break;
      case 4: 
        int i = ((ExperienceItemsAdapter.AddAction)ExperienceFragment.this.mAdapter.getItem(paramInt)).getActionType();
        Intent localIntent = ChooseActionActivity.getIntent(ExperienceFragment.this.mActivity, ExperienceFragment.this.mExperience, i, ExperienceFragment.this.mIsEdit);
        ExperienceFragment.this.startActivityForResult(localIntent, 8);
        break;
      case 5: 
        boolean bool2;
        if (ExperienceFragment.this.mExperience.getDevice() != null) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        boolean bool1;
        if (ExperienceFragment.this.mExperience.getTime() != null) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        SelectTriggerDialog localSelectTriggerDialog = SelectTriggerDialog.newInstance(bool2, bool1);
        localSelectTriggerDialog.setTargetFragment(ExperienceFragment.this, 0);
        ExperienceFragment.this.showDialogFragment(localSelectTriggerDialog, "dialog_select_trigger");
      }
    }
  }
  
  private class ExperienceLoaderCallbacks
    implements LoaderManager.LoaderCallbacks<Experience>
  {
    private ExperienceLoaderCallbacks() {}
    
    public Loader<Experience> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      Dbg.d("ExperienceLoaderCallbacks.onCreateLoader");
      return new ExperienceLoader(ExperienceFragment.this.mActivity, paramBundle.getLong("key_experience_id"));
    }
    
    public void onLoadFinished(Loader<Experience> paramLoader, Experience paramExperience)
    {
      if (paramExperience != null)
      {
        Dbg.d("ExperienceLoaderCallbacks.onLoadFinished");
        ExperienceFragment.this.mExperience = paramExperience;
        ExperienceFragment.this.mExperienceId = -1L;
        if ((ExperienceFragment.this.mHasTimeToSet) || (ExperienceFragment.this.mHasDeviceToSet) || (ExperienceFragment.this.mPictureUriToSet != null))
        {
          if (ExperienceFragment.this.mHasTimeToSet)
          {
            ExperienceFragment.this.setExperienceTime(ExperienceFragment.this.mTimeToSet);
            ExperienceFragment.this.mTimeToSet = null;
            ExperienceFragment.this.mHasTimeToSet = false;
          }
          if (ExperienceFragment.this.mHasDeviceToSet)
          {
            ExperienceFragment.this.mExperience.setDevice(ExperienceFragment.this.mDeviceToSet);
            ExperienceFragment.this.mDeviceToSet = null;
            ExperienceFragment.this.mHasDeviceToSet = false;
          }
          if (ExperienceFragment.this.mPictureUriToSet != null)
          {
            ExperienceFragment.this.mExperience.setPictureName(ExperienceFragment.this.mPictureUriToSet.toString());
            ExperienceFragment.this.mPictureUriToSet = null;
          }
          ExperienceFragment.ExperienceUpdateTask localExperienceUpdateTask = new ExperienceFragment.ExperienceUpdateTask(ExperienceFragment.this, null);
          localObject = new Experience[1];
          localObject[0] = ExperienceFragment.this.mExperience;
          localExperienceUpdateTask.execute((Object[])localObject);
        }
        ExperienceFragment.this.renderExperience();
        Object localObject = ExperienceFragment.this.getActivity();
        if (localObject != null) {
          ((Activity)localObject).invalidateOptionsMenu();
        }
      }
      else
      {
        Dbg.d("ExperienceLoaderCallback.onFinished data = null");
        if (!((Boolean)ExperienceFragment.this.mSaved.get()).booleanValue()) {
          ((ExperienceFragmentContainer)ExperienceFragment.this.mActivity).closeExperience();
        }
      }
    }
    
    public void onLoaderReset(Loader<Experience> paramLoader)
    {
      Dbg.d("ExperienceLoaderCallbacks.onLoaderReset");
      ExperienceFragment.this.mExperience = null;
    }
  }
  
  private class ExperienceUpdateTask
    extends AsyncTask<Experience, Void, Void>
  {
    private ExperienceUpdateTask() {}
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      ExperienceFragment.this.mExperienceManager.updateExperience(paramVarArgs[0]);
      return null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ExperienceFragment
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class FirstTimeDeviceDialog
  extends DialogFragment
{
  private static final String EXTRA_DEVICE_IS_TAG = "extra_device_is_tag";
  private static final String EXTRA_DEVICE_NAME = "extra_device_name";
  private static final String EXTRA_EXPERIENCE_NAME = "extra_experience_name";
  private static final String EXTRA_PICTURE_NAME = "extra_picture_name";
  private Activity mActivity;
  private CheckBox mShowAgainView;
  
  static FirstTimeDeviceDialog newInstance(Experience paramExperience)
  {
    FirstTimeDeviceDialog localFirstTimeDeviceDialog = new FirstTimeDeviceDialog();
    Bundle localBundle = new Bundle();
    Device localDevice = paramExperience.getDevice();
    String str;
    if (localDevice == null) {
      str = null;
    } else {
      str = localDevice.getProductName();
    }
    localBundle.putString("extra_device_name", str);
    localBundle.putString("extra_experience_name", paramExperience.getName());
    localBundle.putString("extra_picture_name", paramExperience.getPictureName());
    boolean bool;
    if (localDevice == null) {
      bool = false;
    } else if (localDevice.getBearerType() != 10) {
      bool = false;
    } else {
      bool = true;
    }
    localBundle.putBoolean("extra_device_is_tag", bool);
    localFirstTimeDeviceDialog.setArguments(localBundle);
    return localFirstTimeDeviceDialog;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ((FirstTimeActivity)this.mActivity).onDialogCancel(this.mShowAgainView.isChecked());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    View localView = this.mActivity.getLayoutInflater().inflate(2130903060, null);
    UIUtils.applyDirectionality(localView);
    Object localObject2 = this.mActivity.getLayoutInflater().inflate(2130903047, null);
    UIUtils.applyDirectionality((View)localObject2);
    String str = getArguments().getString("extra_device_name");
    Object localObject4 = getArguments().getString("extra_experience_name");
    Object localObject3 = getArguments().getString("extra_picture_name");
    boolean bool = getArguments().getBoolean("extra_device_is_tag", false);
    TextView localTextView = (TextView)localView.findViewById(2131558449);
    this.mShowAgainView = ((CheckBox)localView.findViewById(2131558451));
    Object localObject5;
    if (!bool)
    {
      localObject5 = getString(2131099842);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = localObject4;
      localTextView.setText(String.format((String)localObject5, arrayOfObject));
    }
    else
    {
      str = getString(2131099841);
      localObject5 = new Object[1];
      localObject5[0] = localObject4;
      localTextView.setText(String.format(str, (Object[])localObject5));
      localView.findViewById(2131558450).setVisibility(8);
    }
    localObject4 = (ImageView)localView.findViewById(2131558448);
    localObject3 = UIUtils.getBitmapWithGradient(this.mActivity, (String)localObject3);
    ((ImageView)localObject4).setImageBitmap((Bitmap)localObject3);
    if ((BidiUtils.shouldMirror((View)localObject4)) || (UIUtils.isVanillaRtl(this.mActivity))) {
      ((ImageView)localObject4).setScaleX(-1.0F);
    }
    localObject4 = new Rect();
    this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject4);
    localView.setMinimumWidth((int)Math.min(0.9F * ((Rect)localObject4).width(), ((Bitmap)localObject3).getWidth()));
    localObject3 = new AlertDialog.Builder(this.mActivity);
    ((AlertDialog.Builder)localObject3).setCustomTitle((View)localObject2);
    ((AlertDialog.Builder)localObject3).setView(localView);
    Object localObject1;
    if (!bool)
    {
      localObject1 = getString(2131099838);
      localObject2 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ((FirstTimeActivity)FirstTimeDeviceDialog.this.mActivity).onDialogNext();
        }
      };
      ((AlertDialog.Builder)localObject3).setPositiveButton((CharSequence)localObject1, (DialogInterface.OnClickListener)localObject2);
      localObject2 = getString(2131099943);
      localObject1 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (FirstTimeDeviceDialog.this.mShowAgainView == null) {
            ((FirstTimeActivity)FirstTimeDeviceDialog.this.mActivity).onDialogCancel(false);
          } else {
            ((FirstTimeActivity)FirstTimeDeviceDialog.this.mActivity).onDialogCancel(FirstTimeDeviceDialog.this.mShowAgainView.isChecked());
          }
        }
      };
      ((AlertDialog.Builder)localObject3).setNegativeButton((CharSequence)localObject2, (DialogInterface.OnClickListener)localObject1);
    }
    else
    {
      localObject2 = getString(2131099839);
      localObject1 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ((FirstTimeActivity)FirstTimeDeviceDialog.this.mActivity).onDialogNext();
        }
      };
      ((AlertDialog.Builder)localObject3).setPositiveButton((CharSequence)localObject2, (DialogInterface.OnClickListener)localObject1);
    }
    return ((AlertDialog.Builder)localObject3).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.FirstTimeDeviceDialog
 * JD-Core Version:    0.7.0.1
 */
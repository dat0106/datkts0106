package com.sonyericsson.extras.liveware.actions.sms;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.sonyericsson.extras.liveware.actions.PhoneNumberPickerDialog;
import com.sonyericsson.extras.liveware.actions.PhoneNumberPickerDialog.PhonePickerListener;
import com.sonyericsson.extras.liveware.ui.BaseActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PhoneUtils;
import com.sonyericsson.extras.liveware.utils.PhoneUtils.PhoneContactInfo;
import com.sonyericsson.extras.liveware.utils.PhoneUtils.PhoneNumber;
import org.json.JSONException;
import org.json.JSONObject;

public class SmsSettings
  extends BaseActivity
  implements PhoneNumberPickerDialog.PhonePickerListener
{
  private static final int CONTACT_PICKER_RESULT = 101;
  private static final String KEY_CONTACT_INFO = "key_contact_info";
  private static final String KEY_CONTACT_URI = "key_contact_uri";
  private static final int PHONE_NUMBER_PICKER = 102;
  public static final String SMS_CONTACT = "sms_contact";
  public static final String SMS_MESSAGE = "sms_message";
  public static final String SMS_NUMBER = "sms_number";
  private PhoneUtils.PhoneContactInfo mContactInfo;
  private Uri mContactUri = null;
  private MenuItem mOkActionItem;
  private Button mOkButton;
  private String mRawSetting;
  EmptyWatcher mWatcher;
  
  private void onOk()
  {
    EditText localEditText2 = (EditText)findViewById(2131558525);
    EditText localEditText1 = (EditText)findViewById(2131558526);
    saveAndFinish(localEditText2.getText().toString(), localEditText1.getText().toString());
  }
  
  private void saveAndFinish(String paramString1, String paramString2)
  {
    String str1 = null;
    String str2 = null;
    try
    {
      if ((this.mContactInfo != null) && (TextUtils.equals(this.mContactInfo.phoneNumber.number, paramString1))) {
        str2 = this.mContactInfo.name;
      }
      str1 = SmsAction.buildRawSetting(str2, paramString1, paramString2).toString();
      str1 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
    ActionUtils.finishActivityWithSetting(this, str1, SmsAction.getLabelByRawSetting(this, str1));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) || (paramInt1 != 101))
    {
      Dbg.d("Warning: activity result not ok");
    }
    else
    {
      this.mContactUri = paramIntent.getData();
      showDialog(102);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    setContentView(2130903085);
    setTitle(2131099851);
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool;
    Object localObject3;
    if (paramBundle != null)
    {
      this.mContactUri = ((Uri)paramBundle.getParcelable("key_contact_uri"));
      this.mContactInfo = ((PhoneUtils.PhoneContactInfo)paramBundle.getParcelable("key_contact_info"));
      bool = true;
      localObject3 = (EditText)findViewById(2131558525);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label312;
      }
      ((EditText)localObject3).setText((CharSequence)localObject2);
      label91:
      localObject2 = (EditText)findViewById(2131558526);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label318;
      }
      ((EditText)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        this.mOkButton = ((Button)findViewById(2131558457));
        if (this.mOkButton != null)
        {
          this.mOkButton.setEnabled(bool);
          this.mOkButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              SmsSettings.this.onOk();
            }
          });
        }
        localObject1 = findViewById(2131558456);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              SmsSettings.this.finish();
            }
          });
        }
        this.mWatcher = new EmptyWatcher((EditText)localObject3, (EditText)localObject2, bool);
        ((EditText)localObject3).addTextChangedListener(this.mWatcher);
        ((EditText)localObject2).addTextChangedListener(this.mWatcher);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        return;
        if (TextUtils.isEmpty(this.mRawSetting)) {
          break;
        }
        try
        {
          localObject3 = new JSONObject(this.mRawSetting);
          localObject2 = ((JSONObject)localObject3).getString("sms_number");
          localObject1 = ((JSONObject)localObject3).getString("sms_message");
          localObject3 = ((JSONObject)localObject3).optString("sms_contact");
          if (localObject3 == null) {
            break;
          }
          this.mContactInfo = new PhoneUtils.PhoneContactInfo((String)localObject3, new PhoneUtils.PhoneNumber((String)localObject2, null));
        }
        catch (JSONException localJSONException)
        {
          Dbg.e(localJSONException);
        }
      }
      break;
      label312:
      bool = false;
      break label91;
      label318:
      bool = false;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = super.onCreateDialog(paramInt);
      break;
    case 102: 
      localObject = new PhoneNumberPickerDialog(this, this).get(this.mContactUri);
    }
    return localObject;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689472, paramMenu);
    this.mOkActionItem = paramMenu.findItem(2131558549);
    if (this.mOkActionItem != null) {
      this.mOkActionItem.setEnabled(this.mWatcher.isComplete());
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      break;
    case 2131558548: 
      finish();
      break;
    case 2131558549: 
      onOk();
    }
    return bool;
  }
  
  public void onPhoneNumberCanceled() {}
  
  public void onPhoneNumberSelected(PhoneUtils.PhoneNumber paramPhoneNumber)
  {
    if ((paramPhoneNumber != null) && (paramPhoneNumber.number != null) && (paramPhoneNumber.number.length() > 0))
    {
      ((EditText)findViewById(2131558525)).setText(paramPhoneNumber.number);
      this.mContactInfo = new PhoneUtils.PhoneContactInfo(PhoneUtils.getContactName(this, this.mContactUri), paramPhoneNumber);
    }
  }
  
  public void onPickContact(View paramView)
  {
    removeDialog(102);
    startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 101);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("key_contact_uri", this.mContactUri);
    if (this.mContactInfo != null) {
      paramBundle.putParcelable("key_contact_info", this.mContactInfo);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  private class EmptyWatcher
    implements TextWatcher
  {
    boolean mEnabled;
    EditText mMessage;
    EditText mNumber;
    
    public EmptyWatcher(EditText paramEditText1, EditText paramEditText2, boolean paramBoolean)
    {
      this.mNumber = paramEditText1;
      this.mMessage = paramEditText2;
      this.mEnabled = paramBoolean;
    }
    
    private void activateButton(boolean paramBoolean)
    {
      if (SmsSettings.this.mOkButton != null) {
        SmsSettings.this.mOkButton.setEnabled(paramBoolean);
      }
      if (SmsSettings.this.mOkActionItem != null) {
        SmsSettings.this.mOkActionItem.setEnabled(paramBoolean);
      }
      this.mEnabled = paramBoolean;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    boolean isComplete()
    {
      boolean bool;
      if ((this.mNumber.getText().length() <= 0) || (this.mMessage.getText().length() <= 0)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (isComplete())
      {
        if (!this.mEnabled) {
          activateButton(true);
        }
      }
      else if (this.mEnabled) {
        activateButton(false);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.sms.SmsSettings
 * JD-Core Version:    0.7.0.1
 */
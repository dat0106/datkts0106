package com.sonyericsson.extras.liveware.actions.directcall;

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

public class DirectCallSettings
  extends BaseActivity
  implements PhoneNumberPickerDialog.PhonePickerListener
{
  private static final int CONTACT_PICKER_RESULT = 101;
  private static final String KEY_CONTACT_URI = "key_contact_uri";
  private static final String KEY_PHONE_NUMBER = "key_phone_number";
  private static final int PHONE_NUMBER_PICKER = 1;
  private Uri mContactUri = null;
  private EditText mNumberField;
  private MenuItem mOkActionItem;
  private Button mOkButton;
  private PhoneUtils.PhoneContactInfo mPhoneContactInfo = null;
  private String mRawSetting;
  
  private String save()
  {
    String str1 = null;
    try
    {
      String str2 = ((EditText)findViewById(2131558418)).getText().toString();
      if ((this.mPhoneContactInfo != null) && (TextUtils.equals(this.mPhoneContactInfo.phoneNumber.number, str2)))
      {
        str1 = DirectCallAction.getRawSetting(this, this.mPhoneContactInfo.name, this.mPhoneContactInfo.phoneNumber).toString();
      }
      else if (!TextUtils.isEmpty(str2))
      {
        str1 = DirectCallAction.getRawSetting(this, str2).toString();
        str1 = str1;
      }
    }
    catch (JSONException localJSONException)
    {
      Dbg.e(localJSONException);
    }
    return str1;
  }
  
  private void setOkEnabled(boolean paramBoolean)
  {
    if (this.mOkButton != null) {
      this.mOkButton.setEnabled(paramBoolean);
    }
    if (this.mOkActionItem != null) {
      this.mOkActionItem.setEnabled(paramBoolean);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Dbg.d("onActivityResult");
    if ((paramInt2 != -1) || (paramInt1 != 101))
    {
      Dbg.d("Warning: activity result not ok");
    }
    else
    {
      this.mContactUri = paramIntent.getData();
      showDialog(1);
    }
  }
  
  public void onContacts(View paramView)
  {
    removeDialog(1);
    startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 101);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    setContentView(2130903051);
    setTitle(2131099873);
    Object localObject1 = null;
    Object localObject2;
    if (paramBundle != null)
    {
      this.mContactUri = ((Uri)paramBundle.getParcelable("key_contact_uri"));
      this.mPhoneContactInfo = ((PhoneUtils.PhoneContactInfo)paramBundle.getParcelable("key_phone_number"));
      this.mNumberField = ((EditText)findViewById(2131558418));
      this.mOkButton = ((Button)findViewById(2131558457));
      if (this.mOkButton != null) {
        this.mOkButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            DirectCallSettings.this.onOk();
          }
        });
      }
      localObject2 = findViewById(2131558456);
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            DirectCallSettings.this.finish();
          }
        });
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label280;
      }
      this.mNumberField.setText((CharSequence)localObject1);
      setOkEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.mNumberField.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            if (DirectCallSettings.this.mNumberField.getText().length() != 0) {
              DirectCallSettings.this.setOkEnabled(true);
            } else {
              DirectCallSettings.this.setOkEnabled(false);
            }
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
        return;
        if (TextUtils.isEmpty(this.mRawSetting)) {
          break;
        }
        try
        {
          Object localObject3 = new JSONObject(this.mRawSetting);
          localObject1 = ((JSONObject)localObject3).getString(getString(2131099655));
          localObject2 = ((JSONObject)localObject3).optString(getString(2131099656));
          localObject3 = ((JSONObject)localObject3).optString(getString(2131099657));
          if ((localObject2 == null) || (localObject3 == null)) {
            break;
          }
          this.mPhoneContactInfo = new PhoneUtils.PhoneContactInfo((String)localObject3, new PhoneUtils.PhoneNumber((String)localObject1, (String)localObject2));
        }
        catch (JSONException localJSONException)
        {
          Dbg.e(localJSONException);
        }
      }
      break;
      label280:
      setOkEnabled(false);
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
    case 1: 
      localObject = new PhoneNumberPickerDialog(this, this).get(this.mContactUri);
    }
    return localObject;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689472, paramMenu);
    this.mOkActionItem = paramMenu.findItem(2131558549);
    if (this.mOkActionItem != null)
    {
      MenuItem localMenuItem = this.mOkActionItem;
      boolean bool;
      if (this.mNumberField.getText().length() <= 0) {
        bool = false;
      } else {
        bool = true;
      }
      localMenuItem.setEnabled(bool);
    }
    return true;
  }
  
  public void onOk()
  {
    String str1 = save();
    String str2 = null;
    if (str1 != null) {
      str2 = DirectCallAction.getLabelByRawSetting(this, str1);
    }
    ActionUtils.finishActivityWithSetting(this, str1, str2);
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
    Dbg.d("onPhoneNumberSelected");
    if ((paramPhoneNumber != null) && (paramPhoneNumber.number != null) && (paramPhoneNumber.number.length() > 0))
    {
      this.mPhoneContactInfo = new PhoneUtils.PhoneContactInfo(PhoneUtils.getContactName(this, this.mContactUri), paramPhoneNumber);
      ((EditText)findViewById(2131558418)).setText(paramPhoneNumber.number);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("key_contact_uri", this.mContactUri);
    if (this.mPhoneContactInfo != null) {
      paramBundle.putParcelable("key_phone_number", this.mPhoneContactInfo);
    }
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.directcall.DirectCallSettings
 * JD-Core Version:    0.7.0.1
 */
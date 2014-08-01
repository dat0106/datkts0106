package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException
  extends GoogleAuthException
{
  private final Intent mIntent;
  
  public UserRecoverableAuthException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    Intent localIntent;
    if (this.mIntent != null) {
      localIntent = new Intent(this.mIntent);
    } else {
      localIntent = null;
    }
    return localIntent;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.UserRecoverableAuthException
 * JD-Core Version:    0.7.0.1
 */
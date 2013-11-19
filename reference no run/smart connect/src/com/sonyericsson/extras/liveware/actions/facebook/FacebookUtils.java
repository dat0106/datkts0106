package com.sonyericsson.extras.liveware.actions.facebook;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import org.json.JSONException;

public class FacebookUtils
{
  public static final int ALL_FRIENDS = 3;
  public static final int EVERYONE = 0;
  private static final String EXPIRES = "expires_in";
  public static final String FACEBOOK_ERROR_INTENT_EXTRA = "facebook_error";
  private static final int FACEBOOK_NOTIFICATION_ID = 1;
  private static final String FACEBOOK_NOTIFICATION_TAG = "facebook_notification";
  private static final String[] FACEBOOK_PERMISSIONS;
  public static final boolean FACEBOOK_STATUS_FAIL = false;
  public static final String FACEBOOK_STATUS_INTENT_EXTRA = "facebook_status";
  public static final boolean FACEBOOK_STATUS_OK = true;
  public static final int FRIENDS_OF_FRIENDS = 2;
  private static final String KEY = "facebook-session";
  public static final int NETWORKS_FRIENDS = 1;
  public static final int SELF = 5;
  public static final int SOME_FRIENDS = 4;
  private static final String TOKEN = "access_token";
  private static FacebookUtils mInstance = null;
  private Context mContext;
  private Facebook mFacebook;
  private String mFacebookAPIKey;
  
  static
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "publish_stream";
    arrayOfString[1] = "read_stream";
    arrayOfString[2] = "offline_access";
    FACEBOOK_PERMISSIONS = arrayOfString;
  }
  
  public FacebookUtils(Context paramContext)
  {
    if (Dbg.d()) {
      Dbg.d("FacebookUtils() context=" + paramContext);
    }
    this.mFacebookAPIKey = paramContext.getApplicationContext().getString(2131099661);
    if (Dbg.d()) {
      Dbg.d("mFacebookAPIKey=" + this.mFacebookAPIKey);
    }
    this.mFacebook = new Facebook(this.mFacebookAPIKey);
    this.mContext = paramContext;
  }
  
  public static void clear(Facebook paramFacebook, Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("facebook-session", 0).edit();
    localEditor.clear();
    localEditor.commit();
    paramFacebook.setAccessToken(null);
    paramFacebook.setAccessExpires(0L);
  }
  
  private void extendAccessTokenIfNeeded()
  {
    Dbg.d("extendAccessTokenIfNeeded()");
    long l = this.mFacebook.getAccessExpires();
    Date localDate2 = new Date(this.mFacebook.getAccessExpires());
    if (Dbg.d())
    {
      Dbg.d("extendAccessTokenIfNeeded() mFacebook.getAccessExpires() = " + localDate2.toGMTString());
      Dbg.d("extendAccessTokenIfNeeded() mFacebook.extendAccessTokenIfNeeded()");
    }
    this.mFacebook.extendAccessTokenIfNeeded(this.mContext, null);
    if (l != this.mFacebook.getAccessExpires()) {
      save(this.mFacebook, this.mContext);
    }
    Date localDate1 = new Date(this.mFacebook.getAccessExpires());
    if (Dbg.d()) {
      Dbg.d("extendAccessTokenIfNeeded() mFacebook.getAccessExpires() = " + localDate1.toGMTString());
    }
  }
  
  /**
   * @deprecated
   */
  public static FacebookUtils getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new FacebookUtils(paramContext);
      }
      FacebookUtils localFacebookUtils = mInstance;
      return localFacebookUtils;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isAudienceValid(int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      bool = false;
      break;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
      bool = true;
    }
    return bool;
  }
  
  private static boolean restore(Facebook paramFacebook, Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("facebook-session", 0);
    String str = localSharedPreferences.getString("access_token", null);
    long l = localSharedPreferences.getLong("expires_in", 0L);
    if (Dbg.d())
    {
      Dbg.d("loadCredential() access_token=" + str);
      Dbg.d("loadCredential() expires_in=" + l);
    }
    if ((str != null) && (l != 0L))
    {
      paramFacebook.setAccessToken(str);
      paramFacebook.setAccessExpires(l);
    }
    return paramFacebook.isSessionValid();
  }
  
  private static boolean save(Facebook paramFacebook, Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("facebook-session", 0).edit();
    localEditor.putString("access_token", paramFacebook.getAccessToken());
    localEditor.putLong("expires_in", paramFacebook.getAccessExpires());
    return localEditor.commit();
  }
  
  private void sendbackStatusIntent(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      Intent localIntent = new Intent(paramString);
      if (!paramBoolean) {
        localIntent.putExtra("facebook_status", false);
      } else {
        localIntent.putExtra("facebook_status", true);
      }
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  protected void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFacebook.authorizeCallback(paramInt1, paramInt2, paramIntent);
  }
  
  public void facebookLogOut(Activity paramActivity)
  {
    try
    {
      this.mFacebook.logout(paramActivity);
      clear(this.mFacebook, paramActivity);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean facebookLogin(Activity paramActivity, String paramString)
  {
    Dbg.d("facebookLogin()");
    boolean bool;
    if (restore(this.mFacebook, this.mContext))
    {
      if (Dbg.d()) {
        Dbg.d("onCreate() mFacebook.isSessionValid()   = " + this.mFacebook.isSessionValid());
      }
      Date localDate = new Date(this.mFacebook.getAccessExpires());
      if (Dbg.d()) {
        Dbg.d("onCreate() mFacebook.getAccessExpires() = " + localDate.toGMTString());
      }
      extendAccessTokenIfNeeded();
      bool = false;
    }
    else
    {
      this.mFacebook.authorize(paramActivity, FACEBOOK_PERMISSIONS, new FacebookDialogListener(paramActivity, this.mFacebook, paramString));
      bool = true;
    }
    return bool;
  }
  
  public String getLocalizedAudience(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      str = null;
      break;
    case 0: 
      str = this.mContext.getString(2131099907);
      break;
    case 2: 
      str = this.mContext.getString(2131099906);
      break;
    case 3: 
      str = this.mContext.getString(2131099905);
      break;
    case 5: 
      str = this.mContext.getString(2131099904);
    }
    return str;
  }
  
  public String getLocalizedAudience(String paramString)
  {
    try
    {
      str = getLocalizedAudience(Integer.valueOf(paramString).intValue());
      str = str;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str = null;
      }
    }
    return str;
  }
  
  public boolean isSessionValid()
  {
    return this.mFacebook.isSessionValid();
  }
  
  public boolean loginAndPostMessageOnWall(Activity paramActivity, int paramInt, String paramString, Intent paramIntent)
  {
    facebookLogin(paramActivity, null);
    return postMessageOnWall(paramInt, paramString, paramIntent);
  }
  
  public void notifyUserOfError(String paramString)
  {
    if (Dbg.w()) {
      Dbg.w("FacebookUtils Facebook error=" + paramString);
    }
    Object localObject1 = new Intent(this.mContext, FacebookSettings.class);
    ((Intent)localObject1).putExtra("facebook_login", true);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject1, 0);
    if (paramString == null) {
      localObject2 = this.mContext.getString(2131099910);
    } else {
      localObject2 = paramString;
    }
    localObject1 = (NotificationManager)this.mContext.getSystemService("notification");
    Notification.Builder localBuilder = new Notification.Builder(this.mContext);
    localBuilder.setContentIntent(localPendingIntent);
    localBuilder.setSmallIcon(2130837605);
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setOngoing(false);
    localBuilder.setTicker(this.mContext.getString(2131099909));
    localBuilder.setContentTitle(this.mContext.getString(2131099909));
    localBuilder.setContentText((CharSequence)localObject2);
    Object localObject2 = localBuilder.getNotification();
    if (Dbg.w()) {
      Dbg.w("FacebookUtils Notification tag=facebook_notification id=1");
    }
    ((NotificationManager)localObject1).notify("facebook_notification", 1, (Notification)localObject2);
  }
  
  public boolean postMessageOnWall(int paramInt, String paramString, Intent paramIntent)
  {
    boolean bool;
    if (!restore(this.mFacebook, this.mContext))
    {
      int i = 0;
    }
    else
    {
      extendAccessTokenIfNeeded();
      Bundle localBundle = new Bundle();
      if (Dbg.d()) {
        Dbg.d("postMessageOnWall() message  = " + paramString);
      }
      localBundle.putString("message", paramString);
      String str = null;
      switch (paramInt)
      {
      default: 
        if (Dbg.w()) {
          Dbg.w("Facebook: Invalid privacy: " + paramInt);
        }
        break;
      case 0: 
        str = "EVERYONE";
        break;
      case 1: 
        str = "NETWORKS_FRIENDS";
        break;
      case 2: 
        str = "FRIENDS_OF_FRIENDS";
        break;
      case 3: 
        str = "ALL_FRIENDS";
        break;
      case 4: 
        str = "SOME_FRIENDS";
        break;
      case 5: 
        str = "SELF";
      }
      if (Dbg.d()) {
        Dbg.d("postMessageOnWall() privacy  = {\"value\": \"" + str + "\"}");
      }
      localBundle.putString("privacy", "{\"value\": \"" + str + "\"}");
      new AsyncFacebookRunner(this.mFacebook).request("me/feed", localBundle, "POST", new FacebookPostListener(this.mContext, paramIntent), null);
      bool = true;
    }
    return bool;
  }
  
  private final class FacebookDialogListener
    implements Facebook.DialogListener
  {
    Activity mActivity;
    Facebook mFacebook;
    final String mIntentString;
    
    public FacebookDialogListener(Activity paramActivity, Facebook paramFacebook, String paramString)
    {
      this.mActivity = paramActivity;
      this.mFacebook = paramFacebook;
      this.mIntentString = paramString;
    }
    
    public void onCancel()
    {
      Dbg.d("mFacebook.authorize() -> onCancel()");
    }
    
    public void onComplete(Bundle paramBundle)
    {
      if (Dbg.d())
      {
        Dbg.d("mFacebook.authorize() -> onCompleate()");
        Dbg.d("onCreate() mFacebook.isSessionValid()   = " + this.mFacebook.isSessionValid());
        Date localDate = new Date(this.mFacebook.getAccessExpires());
        Dbg.d("onCreate() mFacebook.getAccessExpires() = " + localDate.toGMTString());
      }
      FacebookUtils.save(this.mFacebook, this.mActivity);
      FacebookUtils.this.sendbackStatusIntent(this.mActivity, this.mIntentString, true);
    }
    
    public void onError(DialogError paramDialogError)
    {
      Dbg.d("mFacebook.authorize() -> onError()");
    }
    
    public void onFacebookError(FacebookError paramFacebookError)
    {
      Dbg.d("mFacebook.authorize() -> onFacebookError()");
    }
  }
  
  private static final class FacebookPostListener
    implements AsyncFacebookRunner.RequestListener
  {
    Context mContext;
    Intent mIntent;
    
    public FacebookPostListener(Context paramContext, Intent paramIntent)
    {
      this.mIntent = paramIntent;
      this.mContext = paramContext;
    }
    
    public void onComplete(String paramString, Object paramObject)
    {
      if (Dbg.d()) {
        Dbg.d("Got facebook response: " + paramString);
      }
      boolean bool = false;
      String str1 = "";
      try
      {
        Util.parseJson(paramString);
        Dbg.w("Facebook Post:Message in your log!!!");
        bool = true;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Dbg.w("Facebook Post: JSON Error in response");
          String str2 = localJSONException.getMessage();
        }
      }
      catch (FacebookError localFacebookError)
      {
        for (;;)
        {
          if (Dbg.d()) {
            Dbg.d("Facebook Post: error: " + localFacebookError.getMessage());
          }
          String str3 = localFacebookError.getMessage();
        }
      }
      this.mIntent.putExtra("facebook_status", bool);
      this.mIntent.putExtra("facebook_error", str1);
      this.mContext.sendBroadcast(this.mIntent);
    }
    
    public void onFacebookError(FacebookError paramFacebookError, Object paramObject)
    {
      if (Dbg.e()) {
        Dbg.e("Facebook: onFacebookError" + paramFacebookError.getMessage());
      }
      this.mIntent.putExtra("facebook_status", false);
      this.mIntent.putExtra("facebook_error", paramFacebookError.getMessage());
      this.mContext.sendBroadcast(this.mIntent);
    }
    
    public void onFileNotFoundException(FileNotFoundException paramFileNotFoundException, Object paramObject)
    {
      if (Dbg.e()) {
        Dbg.e("Facebook: onFileNotFoundException" + paramFileNotFoundException.getMessage());
      }
      this.mIntent.putExtra("facebook_status", false);
      this.mIntent.putExtra("facebook_error", paramFileNotFoundException.getMessage());
      this.mContext.sendBroadcast(this.mIntent);
    }
    
    public void onIOException(IOException paramIOException, Object paramObject)
    {
      if (Dbg.e()) {
        Dbg.e("Facebook: onIOException" + paramIOException.getMessage());
      }
      this.mIntent.putExtra("facebook_status", false);
      this.mIntent.putExtra("facebook_error", paramIOException.getMessage());
      this.mContext.sendBroadcast(this.mIntent);
    }
    
    public void onMalformedURLException(MalformedURLException paramMalformedURLException, Object paramObject)
    {
      if (Dbg.e()) {
        Dbg.e("Facebook: onMalformedURLException " + paramMalformedURLException.getMessage());
      }
      this.mIntent.putExtra("facebook_status", false);
      this.mIntent.putExtra("facebook_error", paramMalformedURLException.getMessage());
      this.mContext.sendBroadcast(this.mIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookUtils
 * JD-Core Version:    0.7.0.1
 */
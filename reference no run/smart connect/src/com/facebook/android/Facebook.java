package com.facebook.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Facebook
{
  public static final String CANCEL_URI = "fbconnect://cancel";
  private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
  protected static final String DIALOG_BASE_URL = "https://m.facebook.com/dialog/";
  public static final String EXPIRES = "expires_in";
  public static final String FB_APP_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
  public static final int FORCE_DIALOG_AUTH = -1;
  protected static final String GRAPH_BASE_URL = "https://graph.facebook.com/";
  private static final String LOGIN = "oauth";
  public static final String REDIRECT_URI = "fbconnect://success";
  private static final long REFRESH_TOKEN_BARRIER = 86400000L;
  protected static final String RESTSERVER_URL = "https://api.facebook.com/restserver.php";
  public static final String SINGLE_SIGN_ON_DISABLED = "service_disabled";
  public static final String TOKEN = "access_token";
  private long mAccessExpires = 0L;
  private String mAccessToken = null;
  private String mAppId;
  private Activity mAuthActivity;
  private int mAuthActivityCode;
  private DialogListener mAuthDialogListener;
  private String[] mAuthPermissions;
  private long mLastAccessUpdate = 0L;
  
  public Facebook(String paramString)
  {
    if (paramString != null)
    {
      this.mAppId = paramString;
      return;
    }
    throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
  }
  
  private void startDialogAuth(Activity paramActivity, String[] paramArrayOfString)
  {
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    CookieSyncManager.createInstance(paramActivity);
    dialog(paramActivity, "oauth", localBundle, new DialogListener()
    {
      public void onCancel()
      {
        Util.logd("Facebook-authorize", "Login canceled");
        Facebook.this.mAuthDialogListener.onCancel();
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        CookieSyncManager.getInstance().sync();
        Facebook.this.setAccessToken(paramAnonymousBundle.getString("access_token"));
        Facebook.this.setAccessExpiresIn(paramAnonymousBundle.getString("expires_in"));
        if (!Facebook.this.isSessionValid())
        {
          Facebook.this.mAuthDialogListener.onFacebookError(new FacebookError("Failed to receive access token."));
        }
        else
        {
          Util.logd("Facebook-authorize", "Login Success! access_token=" + Facebook.this.getAccessToken() + " expires=" + Facebook.this.getAccessExpires());
          Facebook.this.mAuthDialogListener.onComplete(paramAnonymousBundle);
        }
      }
      
      public void onError(DialogError paramAnonymousDialogError)
      {
        Util.logd("Facebook-authorize", "Login failed: " + paramAnonymousDialogError);
        Facebook.this.mAuthDialogListener.onError(paramAnonymousDialogError);
      }
      
      public void onFacebookError(FacebookError paramAnonymousFacebookError)
      {
        Util.logd("Facebook-authorize", "Login failed: " + paramAnonymousFacebookError);
        Facebook.this.mAuthDialogListener.onFacebookError(paramAnonymousFacebookError);
      }
    });
  }
  
  private boolean startSingleSignOn(Activity paramActivity, String paramString, String[] paramArrayOfString, int paramInt)
  {
    boolean bool2 = true;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
    localIntent.putExtra("client_id", paramString);
    if (paramArrayOfString.length > 0) {
      localIntent.putExtra("scope", TextUtils.join(",", paramArrayOfString));
    }
    boolean bool1;
    if (!validateActivityIntent(paramActivity, localIntent)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      this.mAuthActivity = paramActivity;
      this.mAuthPermissions = paramArrayOfString;
      this.mAuthActivityCode = paramInt;
      try
      {
        paramActivity.startActivityForResult(bool1, paramInt);
        bool1 = bool2;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        for (;;)
        {
          bool2 = false;
        }
      }
    }
  }
  
  private boolean validateActivityIntent(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
    if (localResolveInfo != null) {
      bool = validateAppSignatureForPackage(paramContext, localResolveInfo.activityInfo.packageName);
    }
    return bool;
  }
  
  private boolean validateAppSignatureForPackage(Context paramContext, String paramString)
  {
    bool = false;
    try
    {
      localObject = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      localObject = ((PackageInfo)localObject).signatures;
      j = localObject.length;
      i = 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject;
        int j;
        int i;
        continue;
        if (localObject[i].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
          bool = true;
        } else {
          i++;
        }
      }
    }
    if (i >= j) {
      return bool;
    }
  }
  
  private boolean validateServiceIntent(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if (localResolveInfo != null) {
      bool = validateAppSignatureForPackage(paramContext, localResolveInfo.serviceInfo.packageName);
    }
    return bool;
  }
  
  public void authorize(Activity paramActivity, DialogListener paramDialogListener)
  {
    authorize(paramActivity, new String[0], 32665, paramDialogListener);
  }
  
  public void authorize(Activity paramActivity, String[] paramArrayOfString, int paramInt, DialogListener paramDialogListener)
  {
    boolean bool = false;
    this.mAuthDialogListener = paramDialogListener;
    if (paramInt >= 0) {
      bool = startSingleSignOn(paramActivity, this.mAppId, paramArrayOfString, paramInt);
    }
    if (!bool) {
      startDialogAuth(paramActivity, paramArrayOfString);
    }
  }
  
  public void authorize(Activity paramActivity, String[] paramArrayOfString, DialogListener paramDialogListener)
  {
    authorize(paramActivity, paramArrayOfString, 32665, paramDialogListener);
  }
  
  public void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.mAuthActivityCode) {
      if (paramInt2 != -1)
      {
        if (paramInt2 == 0) {
          if (paramIntent == null)
          {
            Util.logd("Facebook-authorize", "Login canceled by user.");
            this.mAuthDialogListener.onCancel();
          }
          else
          {
            Util.logd("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
            this.mAuthDialogListener.onError(new DialogError(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          }
        }
      }
      else
      {
        String str2 = paramIntent.getStringExtra("error");
        if (str2 == null) {
          str2 = paramIntent.getStringExtra("error_type");
        }
        if (str2 == null)
        {
          setAccessToken(paramIntent.getStringExtra("access_token"));
          setAccessExpiresIn(paramIntent.getStringExtra("expires_in"));
          if (!isSessionValid())
          {
            this.mAuthDialogListener.onFacebookError(new FacebookError("Failed to receive access token."));
          }
          else
          {
            Util.logd("Facebook-authorize", "Login Success! access_token=" + getAccessToken() + " expires=" + getAccessExpires());
            this.mAuthDialogListener.onComplete(paramIntent.getExtras());
          }
        }
        else if ((!str2.equals("service_disabled")) && (!str2.equals("AndroidAuthKillSwitchException")))
        {
          if ((!str2.equals("access_denied")) && (!str2.equals("OAuthAccessDeniedException")))
          {
            String str1 = paramIntent.getStringExtra("error_description");
            if (str1 != null) {
              str2 = str2 + ":" + str1;
            }
            Util.logd("Facebook-authorize", "Login failed: " + str2);
            this.mAuthDialogListener.onFacebookError(new FacebookError(str2));
          }
          else
          {
            Util.logd("Facebook-authorize", "Login canceled by user.");
            this.mAuthDialogListener.onCancel();
          }
        }
        else
        {
          Util.logd("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
          startDialogAuth(this.mAuthActivity, this.mAuthPermissions);
        }
      }
    }
  }
  
  public void dialog(Context paramContext, String paramString, Bundle paramBundle, DialogListener paramDialogListener)
  {
    String str = "https://m.facebook.com/dialog/" + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (!paramString.equals("oauth"))
    {
      paramBundle.putString("app_id", this.mAppId);
    }
    else
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.mAppId);
    }
    if (isSessionValid()) {
      paramBundle.putString("access_token", getAccessToken());
    }
    str = str + "?" + Util.encodeUrl(paramBundle);
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
      new FbDialog(paramContext, str, paramDialogListener).show();
    } else {
      Util.showAlert(paramContext, "Error", "Application requires permission to access the Internet");
    }
  }
  
  public void dialog(Context paramContext, String paramString, DialogListener paramDialogListener)
  {
    dialog(paramContext, paramString, new Bundle(), paramDialogListener);
  }
  
  public boolean extendAccessToken(Context paramContext, ServiceListener paramServiceListener)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
    boolean bool;
    if (validateServiceIntent(paramContext, localIntent)) {
      bool = paramContext.bindService(localIntent, new TokenRefreshServiceConnection(paramContext, paramServiceListener), 1);
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean extendAccessTokenIfNeeded(Context paramContext, ServiceListener paramServiceListener)
  {
    boolean bool;
    if (!shouldExtendAccessToken()) {
      bool = true;
    } else {
      bool = extendAccessToken(paramContext, paramServiceListener);
    }
    return bool;
  }
  
  public long getAccessExpires()
  {
    return this.mAccessExpires;
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  public boolean isSessionValid()
  {
    boolean bool;
    if ((getAccessToken() == null) || ((getAccessExpires() != 0L) && (System.currentTimeMillis() >= getAccessExpires()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String logout(Context paramContext)
    throws MalformedURLException, IOException
  {
    Util.clearCookies(paramContext);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("method", "auth.expireSession");
    localObject = request((Bundle)localObject);
    setAccessToken(null);
    setAccessExpires(0L);
    return localObject;
  }
  
  public String request(Bundle paramBundle)
    throws MalformedURLException, IOException
  {
    if (paramBundle.containsKey("method")) {
      return request(null, paramBundle, "GET");
    }
    throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
  }
  
  public String request(String paramString)
    throws MalformedURLException, IOException
  {
    return request(paramString, new Bundle(), "GET");
  }
  
  public String request(String paramString, Bundle paramBundle)
    throws MalformedURLException, IOException
  {
    return request(paramString, paramBundle, "GET");
  }
  
  public String request(String paramString1, Bundle paramBundle, String paramString2)
    throws FileNotFoundException, MalformedURLException, IOException
  {
    paramBundle.putString("format", "json");
    if (isSessionValid()) {
      paramBundle.putString("access_token", getAccessToken());
    }
    String str;
    if (paramString1 == null) {
      str = "https://api.facebook.com/restserver.php";
    } else {
      str = "https://graph.facebook.com/" + paramString1;
    }
    return Util.openUrl(str, paramString2, paramBundle);
  }
  
  public void setAccessExpires(long paramLong)
  {
    this.mAccessExpires = paramLong;
  }
  
  public void setAccessExpiresIn(String paramString)
  {
    if (paramString != null)
    {
      long l;
      if (!paramString.equals("0")) {
        l = System.currentTimeMillis() + 1000L * Long.parseLong(paramString);
      } else {
        l = 0L;
      }
      setAccessExpires(l);
    }
  }
  
  public void setAccessToken(String paramString)
  {
    this.mAccessToken = paramString;
    this.mLastAccessUpdate = System.currentTimeMillis();
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public boolean shouldExtendAccessToken()
  {
    boolean bool;
    if ((!isSessionValid()) || (System.currentTimeMillis() - this.mLastAccessUpdate < 86400000L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static abstract interface DialogListener
  {
    public abstract void onCancel();
    
    public abstract void onComplete(Bundle paramBundle);
    
    public abstract void onError(DialogError paramDialogError);
    
    public abstract void onFacebookError(FacebookError paramFacebookError);
  }
  
  public static abstract interface ServiceListener
  {
    public abstract void onComplete(Bundle paramBundle);
    
    public abstract void onError(Error paramError);
    
    public abstract void onFacebookError(FacebookError paramFacebookError);
  }
  
  private class TokenRefreshServiceConnection
    implements ServiceConnection
  {
    final Context applicationsContext;
    final Messenger messageReceiver = new Messenger(new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        String str2 = paramAnonymousMessage.getData().getString("access_token");
        long l = 1000L * paramAnonymousMessage.getData().getLong("expires_in");
        Bundle localBundle = (Bundle)paramAnonymousMessage.getData().clone();
        localBundle.putLong("expires_in", l);
        String str1;
        if (str2 == null)
        {
          if (Facebook.TokenRefreshServiceConnection.this.serviceListener != null)
          {
            str1 = paramAnonymousMessage.getData().getString("error");
            if (!paramAnonymousMessage.getData().containsKey("error_code"))
            {
              Facebook.ServiceListener localServiceListener = Facebook.TokenRefreshServiceConnection.this.serviceListener;
              if (str1 == null) {
                str1 = "Unknown service error";
              }
              localServiceListener.onError(new Error(str1));
            }
            else
            {
              int i = paramAnonymousMessage.getData().getInt("error_code");
              Facebook.TokenRefreshServiceConnection.this.serviceListener.onFacebookError(new FacebookError(str1, null, i));
            }
          }
        }
        else
        {
          Facebook.this.setAccessToken(str2);
          Facebook.this.setAccessExpires(str1);
          if (Facebook.TokenRefreshServiceConnection.this.serviceListener != null) {
            Facebook.TokenRefreshServiceConnection.this.serviceListener.onComplete(localBundle);
          }
        }
        Facebook.TokenRefreshServiceConnection.this.applicationsContext.unbindService(Facebook.TokenRefreshServiceConnection.this);
      }
    });
    Messenger messageSender = null;
    final Facebook.ServiceListener serviceListener;
    
    public TokenRefreshServiceConnection(Context paramContext, Facebook.ServiceListener paramServiceListener)
    {
      this.applicationsContext = paramContext;
      this.serviceListener = paramServiceListener;
    }
    
    private void refreshToken()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("access_token", Facebook.this.mAccessToken);
      Message localMessage = Message.obtain();
      localMessage.setData(localBundle);
      localMessage.replyTo = this.messageReceiver;
      try
      {
        this.messageSender.send(localMessage);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          this.serviceListener.onError(new Error("Service connection error"));
        }
      }
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      this.messageSender = new Messenger(paramIBinder);
      refreshToken();
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      this.serviceListener.onError(new Error("Service disconnected"));
      this.applicationsContext.unbindService(this);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.facebook.android.Facebook
 * JD-Core Version:    0.7.0.1
 */
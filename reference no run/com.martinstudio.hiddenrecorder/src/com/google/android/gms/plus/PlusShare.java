package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.kt;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlusShare
{
  public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
  public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
  public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
  public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
  public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
  public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
  public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
  public static final String KEY_CALL_TO_ACTION_LABEL = "label";
  public static final String KEY_CALL_TO_ACTION_URL = "url";
  public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
  public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
  public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
  public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";
  
  @Deprecated
  protected PlusShare()
  {
    throw new AssertionError();
  }
  
  public static Bundle a(String paramString1, String paramString2, Uri paramUri)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("description", paramString2);
    if (paramUri != null) {
      localBundle.putString("thumbnailUrl", paramUri.toString());
    }
    return localBundle;
  }
  
  protected static boolean bv(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains(" ")) {
        bool = true;
      } else {
        Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
      }
    }
    else {
      Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
    }
    return bool;
  }
  
  public static Person createPerson(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        return new kt(paramString2, paramString1, null, 0, null);
      }
      throw new IllegalArgumentException("Display name must not be empty.");
    }
    throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
  }
  
  public static String getDeepLinkId(Intent paramIntent)
  {
    String str = null;
    if ((paramIntent != null) && (paramIntent.getData() != null)) {
      str = paramIntent.getData().getQueryParameter("deep_link_id");
    }
    return str;
  }
  
  public static class Builder
  {
    private boolean abE;
    private ArrayList<Uri> abF;
    private final Context mContext;
    private final Intent mIntent;
    
    public Builder(Activity paramActivity)
    {
      this.mContext = paramActivity;
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent.addFlags(524288);
      if ((paramActivity != null) && (paramActivity.getComponentName() != null)) {
        this.abE = true;
      }
    }
    
    @Deprecated
    public Builder(Activity paramActivity, PlusClient paramPlusClient)
    {
      this(paramActivity);
      boolean bool;
      if (paramPlusClient == null) {
        bool = false;
      } else {
        bool = true;
      }
      hn.a(bool, "PlusClient must not be null.");
      hn.a(paramPlusClient.isConnected(), "PlusClient must be connected to create an interactive post.");
      hn.a(paramPlusClient.jN().by("https://www.googleapis.com/auth/plus.login"), "Must request PLUS_LOGIN scope in PlusClient to create an interactive post.");
      Object localObject = paramPlusClient.getCurrentPerson();
      if (localObject == null) {
        localObject = "0";
      } else {
        localObject = ((Person)localObject).getId();
      }
      this.mIntent.putExtra("com.google.android.apps.plus.SENDER_ID", (String)localObject);
    }
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
    }
    
    public Builder addCallToAction(String paramString1, Uri paramUri, String paramString2)
    {
      hn.a(this.abE, "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
      boolean bool;
      if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString()))) {
        bool = false;
      } else {
        bool = true;
      }
      hn.b(bool, "Must provide a call to action URL");
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(paramString1)) {
        localBundle.putString("label", paramString1);
      }
      localBundle.putString("url", paramUri.toString());
      if (!TextUtils.isEmpty(paramString2))
      {
        hn.a(PlusShare.bv(paramString2), "The specified deep-link ID was malformed.");
        localBundle.putString("deepLinkId", paramString2);
      }
      this.mIntent.putExtra("com.google.android.apps.plus.CALL_TO_ACTION", localBundle);
      this.mIntent.putExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", true);
      this.mIntent.setType("text/plain");
      return this;
    }
    
    public Builder addStream(Uri paramUri)
    {
      Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (localUri != null)
      {
        if (this.abF == null) {
          this.abF = new ArrayList();
        }
        this.abF.add(localUri);
        this.abF.add(paramUri);
      }
      else
      {
        this = setStream(paramUri);
      }
      return this;
    }
    
    public Intent getIntent()
    {
      int i = 1;
      int j;
      if ((this.abF == null) || (this.abF.size() <= i)) {
        j = 0;
      } else {
        j = i;
      }
      boolean bool1 = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
      boolean bool2 = this.mIntent.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
      boolean bool3;
      if ((j != 0) && (bool2)) {
        bool3 = false;
      } else {
        bool3 = i;
      }
      hn.a(bool3, "Call-to-action buttons are only available for URLs.");
      if ((bool2) && (!this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL"))) {
        bool3 = false;
      } else {
        bool3 = i;
      }
      hn.a(bool3, "The content URL is required for interactive posts.");
      if ((bool2) && (!this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_URL")) && (!this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID"))) {
        i = 0;
      }
      hn.a(i, "Must set content URL or content deep-link ID to use a call-to-action button.");
      if (this.mIntent.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
        hn.a(PlusShare.bv(this.mIntent.getStringExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")), "The specified deep-link ID was malformed.");
      }
      if ((j == 0) && (bool1))
      {
        this.mIntent.setAction("android.intent.action.SEND");
        if ((this.abF == null) || (this.abF.isEmpty())) {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } else {
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.abF.get(0));
        }
        this.abF = null;
      }
      if ((j != 0) && (!bool1))
      {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if ((this.abF == null) || (this.abF.isEmpty())) {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } else {
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.abF);
        }
      }
      Intent localIntent;
      if (!"com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction()))
      {
        if (this.mIntent.hasExtra("android.intent.extra.STREAM"))
        {
          this.mIntent.setPackage("com.google.android.apps.plus");
          localIntent = this.mIntent;
        }
        else
        {
          this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
          this.mIntent.setPackage("com.google.android.gms");
          localIntent = this.mIntent;
        }
      }
      else
      {
        this.mIntent.setPackage("com.google.android.gms");
        localIntent = this.mIntent;
      }
      return localIntent;
    }
    
    public Builder setContentDeepLinkId(String paramString)
    {
      return setContentDeepLinkId(paramString, null, null, null);
    }
    
    public Builder setContentDeepLinkId(String paramString1, String paramString2, String paramString3, Uri paramUri)
    {
      hn.b(this.abE, "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
      boolean bool;
      if (TextUtils.isEmpty(paramString1)) {
        bool = false;
      } else {
        bool = true;
      }
      hn.b(bool, "The deepLinkId parameter is required.");
      Bundle localBundle = PlusShare.a(paramString2, paramString3, paramUri);
      this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID", paramString1);
      this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA", localBundle);
      this.mIntent.setType("text/plain");
      return this;
    }
    
    public Builder setContentUrl(Uri paramUri)
    {
      String str = null;
      if (paramUri != null) {
        str = paramUri.toString();
      }
      if (!TextUtils.isEmpty(str)) {
        this.mIntent.putExtra("com.google.android.apps.plus.CONTENT_URL", str);
      } else {
        this.mIntent.removeExtra("com.google.android.apps.plus.CONTENT_URL");
      }
      return this;
    }
    
    public Builder setRecipients(Person paramPerson, List<Person> paramList)
    {
      Intent localIntent = this.mIntent;
      String str;
      if (paramPerson == null) {
        str = "0";
      } else {
        str = paramPerson.getId();
      }
      localIntent.putExtra("com.google.android.apps.plus.SENDER_ID", str);
      return setRecipients(paramList);
    }
    
    @Deprecated
    public Builder setRecipients(List<Person> paramList)
    {
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      if (i != 0)
      {
        ArrayList localArrayList1 = new ArrayList(i);
        ArrayList localArrayList2 = new ArrayList(i);
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", localArrayList1);
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", localArrayList2);
            break;
          }
          Person localPerson = (Person)localIterator.next();
          localArrayList1.add(localPerson.getId());
          localArrayList2.add(localPerson.getDisplayName());
        }
      }
      this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
      this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
      return this;
    }
    
    public Builder setStream(Uri paramUri)
    {
      this.abF = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
      return this;
    }
    
    public Builder setText(CharSequence paramCharSequence)
    {
      this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.mIntent.setType(paramString);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.PlusShare
 * JD-Core Version:    0.7.0.1
 */
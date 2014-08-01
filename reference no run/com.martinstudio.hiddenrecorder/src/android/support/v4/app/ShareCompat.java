package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class ShareCompat
{
  public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  private static ShareCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (Build.VERSION.SDK_INT < 14) {
        IMPL = new ShareCompatImplBase();
      } else {
        IMPL = new ShareCompatImplICS();
      }
    }
    else {
      IMPL = new ShareCompatImplJB();
    }
  }
  
  public static void configureMenuItem(Menu paramMenu, int paramInt, IntentBuilder paramIntentBuilder)
  {
    MenuItem localMenuItem = paramMenu.findItem(paramInt);
    if (localMenuItem != null)
    {
      configureMenuItem(localMenuItem, paramIntentBuilder);
      return;
    }
    throw new IllegalArgumentException("Could not find menu item with id " + paramInt + " in the supplied menu");
  }
  
  public static void configureMenuItem(MenuItem paramMenuItem, IntentBuilder paramIntentBuilder)
  {
    IMPL.configureMenuItem(paramMenuItem, paramIntentBuilder);
  }
  
  public static ComponentName getCallingActivity(Activity paramActivity)
  {
    ComponentName localComponentName = paramActivity.getCallingActivity();
    if (localComponentName == null) {
      localComponentName = (ComponentName)paramActivity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
    }
    return localComponentName;
  }
  
  public static String getCallingPackage(Activity paramActivity)
  {
    String str = paramActivity.getCallingPackage();
    if (str == null) {
      str = paramActivity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
    }
    return str;
  }
  
  public static class IntentReader
  {
    private static final String TAG = "IntentReader";
    private Activity mActivity;
    private ComponentName mCallingActivity;
    private String mCallingPackage;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    
    private IntentReader(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      this.mIntent = paramActivity.getIntent();
      this.mCallingPackage = ShareCompat.getCallingPackage(paramActivity);
      this.mCallingActivity = ShareCompat.getCallingActivity(paramActivity);
    }
    
    public static IntentReader from(Activity paramActivity)
    {
      return new IntentReader(paramActivity);
    }
    
    public ComponentName getCallingActivity()
    {
      return this.mCallingActivity;
    }
    
    public Drawable getCallingActivityIcon()
    {
      Drawable localDrawable = null;
      if (this.mCallingActivity == null) {}
      for (;;)
      {
        return localDrawable;
        PackageManager localPackageManager = this.mActivity.getPackageManager();
        try
        {
          localDrawable = localPackageManager.getActivityIcon(this.mCallingActivity);
          localDrawable = localDrawable;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.e("IntentReader", "Could not retrieve icon for calling activity", localNameNotFoundException);
        }
      }
    }
    
    public Drawable getCallingApplicationIcon()
    {
      Drawable localDrawable = null;
      if (this.mCallingPackage == null) {}
      for (;;)
      {
        return localDrawable;
        PackageManager localPackageManager = this.mActivity.getPackageManager();
        try
        {
          localDrawable = localPackageManager.getApplicationIcon(this.mCallingPackage);
          localDrawable = localDrawable;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.e("IntentReader", "Could not retrieve icon for calling application", localNameNotFoundException);
        }
      }
    }
    
    public CharSequence getCallingApplicationLabel()
    {
      CharSequence localCharSequence = null;
      if (this.mCallingPackage == null) {}
      for (;;)
      {
        return localCharSequence;
        PackageManager localPackageManager = this.mActivity.getPackageManager();
        try
        {
          localCharSequence = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(this.mCallingPackage, 0));
          localCharSequence = localCharSequence;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.e("IntentReader", "Could not retrieve label for calling application", localNameNotFoundException);
        }
      }
    }
    
    public String getCallingPackage()
    {
      return this.mCallingPackage;
    }
    
    public String[] getEmailBcc()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }
    
    public String[] getEmailCc()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }
    
    public String[] getEmailTo()
    {
      return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }
    
    public String getHtmlText()
    {
      String str = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
      if (str == null)
      {
        CharSequence localCharSequence = getText();
        if (!(localCharSequence instanceof Spanned))
        {
          if (localCharSequence != null) {
            str = ShareCompat.IMPL.escapeHtml(localCharSequence);
          }
        }
        else {
          str = Html.toHtml((Spanned)localCharSequence);
        }
      }
      return str;
    }
    
    public Uri getStream()
    {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    
    public Uri getStream(int paramInt)
    {
      if ((this.mStreams == null) && (isMultipleShare())) {
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }
      Uri localUri;
      if (this.mStreams == null)
      {
        if (paramInt != 0) {
          throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + paramInt);
        }
        localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      }
      else
      {
        localUri = (Uri)this.mStreams.get(paramInt);
      }
      return localUri;
    }
    
    public int getStreamCount()
    {
      if ((this.mStreams == null) && (isMultipleShare())) {
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      }
      int i;
      if (this.mStreams == null)
      {
        if (!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
          i = 0;
        } else {
          i = 1;
        }
      }
      else {
        i = this.mStreams.size();
      }
      return i;
    }
    
    public String getSubject()
    {
      return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    
    public CharSequence getText()
    {
      return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }
    
    public String getType()
    {
      return this.mIntent.getType();
    }
    
    public boolean isMultipleShare()
    {
      return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }
    
    public boolean isShareIntent()
    {
      String str = this.mIntent.getAction();
      boolean bool;
      if ((!"android.intent.action.SEND".equals(str)) && (!"android.intent.action.SEND_MULTIPLE".equals(str))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isSingleShare()
    {
      return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }
  }
  
  public static class IntentBuilder
  {
    private Activity mActivity;
    private ArrayList<String> mBccAddresses;
    private ArrayList<String> mCcAddresses;
    private CharSequence mChooserTitle;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
      this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList)
    {
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
      int i;
      if (arrayOfString1 == null) {
        i = 0;
      } else {
        i = arrayOfString1.length;
      }
      String[] arrayOfString2 = new String[i + paramArrayList.size()];
      paramArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
      }
      this.mIntent.putExtra(paramString, arrayOfString2);
    }
    
    private void combineArrayExtra(String paramString, String[] paramArrayOfString)
    {
      Intent localIntent = getIntent();
      String[] arrayOfString2 = localIntent.getStringArrayExtra(paramString);
      int i;
      if (arrayOfString2 == null) {
        i = 0;
      } else {
        i = arrayOfString2.length;
      }
      String[] arrayOfString1 = new String[i + paramArrayOfString.length];
      if (arrayOfString2 != null) {
        System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, i);
      }
      System.arraycopy(paramArrayOfString, 0, arrayOfString1, i, paramArrayOfString.length);
      localIntent.putExtra(paramString, arrayOfString1);
    }
    
    public static IntentBuilder from(Activity paramActivity)
    {
      return new IntentBuilder(paramActivity);
    }
    
    public IntentBuilder addEmailBcc(String paramString)
    {
      if (this.mBccAddresses == null) {
        this.mBccAddresses = new ArrayList();
      }
      this.mBccAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailBcc(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailCc(String paramString)
    {
      if (this.mCcAddresses == null) {
        this.mCcAddresses = new ArrayList();
      }
      this.mCcAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailCc(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailTo(String paramString)
    {
      if (this.mToAddresses == null) {
        this.mToAddresses = new ArrayList();
      }
      this.mToAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailTo(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addStream(Uri paramUri)
    {
      Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (localUri != null)
      {
        if (this.mStreams == null) {
          this.mStreams = new ArrayList();
        }
        if (localUri != null)
        {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
          this.mStreams.add(localUri);
        }
        this.mStreams.add(paramUri);
      }
      else
      {
        this = setStream(paramUri);
      }
      return this;
    }
    
    public Intent createChooserIntent()
    {
      return Intent.createChooser(getIntent(), this.mChooserTitle);
    }
    
    Activity getActivity()
    {
      return this.mActivity;
    }
    
    public Intent getIntent()
    {
      int i = 1;
      if (this.mToAddresses != null)
      {
        combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
        this.mToAddresses = null;
      }
      if (this.mCcAddresses != null)
      {
        combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
        this.mCcAddresses = null;
      }
      if (this.mBccAddresses != null)
      {
        combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
        this.mBccAddresses = null;
      }
      if ((this.mStreams == null) || (this.mStreams.size() <= i)) {
        i = 0;
      }
      boolean bool = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if ((i == 0) && (bool))
      {
        this.mIntent.setAction("android.intent.action.SEND");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } else {
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        }
        this.mStreams = null;
      }
      if ((i != 0) && (!bool))
      {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } else {
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
        }
      }
      return this.mIntent;
    }
    
    public IntentBuilder setChooserTitle(int paramInt)
    {
      return setChooserTitle(this.mActivity.getText(paramInt));
    }
    
    public IntentBuilder setChooserTitle(CharSequence paramCharSequence)
    {
      this.mChooserTitle = paramCharSequence;
      return this;
    }
    
    public IntentBuilder setEmailBcc(String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailCc(String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailTo(String[] paramArrayOfString)
    {
      if (this.mToAddresses != null) {
        this.mToAddresses = null;
      }
      this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setHtmlText(String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
      if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
        setText(Html.fromHtml(paramString));
      }
      return this;
    }
    
    public IntentBuilder setStream(Uri paramUri)
    {
      if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
        this.mIntent.setAction("android.intent.action.SEND");
      }
      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
      return this;
    }
    
    public IntentBuilder setSubject(String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
      return this;
    }
    
    public IntentBuilder setText(CharSequence paramCharSequence)
    {
      this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
      return this;
    }
    
    public IntentBuilder setType(String paramString)
    {
      this.mIntent.setType(paramString);
      return this;
    }
    
    public void startChooser()
    {
      this.mActivity.startActivity(createChooserIntent());
    }
  }
  
  static class ShareCompatImplJB
    extends ShareCompat.ShareCompatImplICS
  {
    public String escapeHtml(CharSequence paramCharSequence)
    {
      return ShareCompatJB.escapeHtml(paramCharSequence);
    }
    
    boolean shouldAddChooserIntent(MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  static class ShareCompatImplICS
    extends ShareCompat.ShareCompatImplBase
  {
    public void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
    {
      ShareCompatICS.configureMenuItem(paramMenuItem, paramIntentBuilder.getActivity(), paramIntentBuilder.getIntent());
      if (shouldAddChooserIntent(paramMenuItem)) {
        paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
      }
    }
    
    boolean shouldAddChooserIntent(MenuItem paramMenuItem)
    {
      boolean bool;
      if (paramMenuItem.hasSubMenu()) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  static class ShareCompatImplBase
    implements ShareCompat.ShareCompatImpl
  {
    private static void withinStyle(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      for (int i = paramInt1;; i++)
      {
        if (i >= paramInt2) {
          return;
        }
        char c = paramCharSequence.charAt(i);
        if (c != '<')
        {
          if (c != '>')
          {
            if (c != '&')
            {
              if ((c <= '~') && (c >= ' '))
              {
                if (c != ' ') {
                  paramStringBuilder.append(c);
                } else {
                  for (;;)
                  {
                    if ((i + 1 >= paramInt2) || (paramCharSequence.charAt(i + 1) != ' '))
                    {
                      paramStringBuilder.append(' ');
                      break;
                    }
                    paramStringBuilder.append("&nbsp;");
                    i++;
                  }
                }
              }
              else {
                paramStringBuilder.append("&#" + c + ";");
              }
            }
            else {
              paramStringBuilder.append("&amp;");
            }
          }
          else {
            paramStringBuilder.append("&gt;");
          }
        }
        else {
          paramStringBuilder.append("&lt;");
        }
      }
    }
    
    public void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
    {
      paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
    }
    
    public String escapeHtml(CharSequence paramCharSequence)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      withinStyle(localStringBuilder, paramCharSequence, 0, paramCharSequence.length());
      return localStringBuilder.toString();
    }
  }
  
  static abstract interface ShareCompatImpl
  {
    public abstract void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder);
    
    public abstract String escapeHtml(CharSequence paramCharSequence);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat
 * JD-Core Version:    0.7.0.1
 */
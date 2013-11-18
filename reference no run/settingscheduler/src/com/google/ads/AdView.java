package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.internal.j;
import com.google.ads.util.AdUtil;
import com.google.ads.util.i.c;
import java.util.HashSet;
import java.util.Set;

public class AdView
  extends RelativeLayout
  implements Ad
{
  private d a;
  
  public AdView(Activity paramActivity, AdSize paramAdSize, String paramString)
  {
    super(paramActivity.getApplicationContext());
    try
    {
      a(paramActivity, paramAdSize, null);
      b(paramActivity, paramAdSize, null);
      a(paramActivity, paramAdSize, paramString);
      return;
    }
    catch (com.google.ads.internal.b localb)
    {
      for (;;)
      {
        a(paramActivity, localb.c("Could not initialize AdView"), paramAdSize, null);
        localb.a("Could not initialize AdView");
      }
    }
  }
  
  protected AdView(Activity paramActivity, AdSize[] paramArrayOfAdSize, String paramString)
  {
    this(paramActivity, new AdSize(0, 0), paramString);
    a(paramArrayOfAdSize);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  private int a(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  private void a(Activity paramActivity, AdSize paramAdSize, String paramString)
    throws com.google.ads.internal.b
  {
    FrameLayout localFrameLayout = new FrameLayout(paramActivity);
    localFrameLayout.setFocusable(false);
    this.a = new d(this, paramActivity, paramAdSize, paramString, localFrameLayout, false);
    setGravity(17);
    try
    {
      ViewGroup localViewGroup = j.a(paramActivity, this.a);
      if (localViewGroup != null)
      {
        localViewGroup.addView(localFrameLayout, -2, -2);
        addView(localViewGroup, -2, -2);
      }
      else
      {
        addView(localFrameLayout, -2, -2);
      }
    }
    catch (VerifyError localVerifyError)
    {
      com.google.ads.util.b.a("Gestures disabled: Not supported on this version of Android.", localVerifyError);
      addView(localFrameLayout, -2, -2);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    try
    {
      String str1 = b("adSize", paramContext, paramAttributeSet, true);
      localObject1 = a(str1);
      if (localObject1 != null) {}
      try
      {
        if (localObject1.length != 0) {
          break label128;
        }
        throw new com.google.ads.internal.b("Attribute \"adSize\" invalid: " + str1, true);
      }
      catch (com.google.ads.internal.b localb2)
      {
        localb3 = localb2;
        localObject3 = localObject1;
      }
    }
    catch (com.google.ads.internal.b localb1)
    {
      for (;;)
      {
        Object localObject1;
        com.google.ads.internal.b localb3;
        Object localObject3 = null;
        Object localObject2 = localb1;
      }
    }
    localObject1 = localb3.c("Could not initialize AdView");
    if ((localObject3 != null) && (localObject3.length > 0)) {}
    for (localObject3 = localObject3[0];; localObject3 = AdSize.BANNER)
    {
      a(paramContext, (String)localObject1, (AdSize)localObject3, paramAttributeSet);
      localb3.a("Could not initialize AdView");
      if (isInEditMode()) {
        break;
      }
      localb3.b("Could not initialize AdView");
      break;
      label128:
      if (!a("adUnitId", paramAttributeSet)) {
        throw new com.google.ads.internal.b("Required XML attribute \"adUnitId\" missing", true);
      }
      if (isInEditMode())
      {
        a(paramContext, "Ads by Google", -1, localObject1[0], paramAttributeSet);
        break;
      }
      String str2 = b("adUnitId", paramContext, paramAttributeSet, true);
      boolean bool = a("loadAdOnCreate", paramContext, paramAttributeSet, false);
      if ((paramContext instanceof Activity))
      {
        localObject3 = (Activity)paramContext;
        a((Context)localObject3, localObject1[0], paramAttributeSet);
        b((Context)localObject3, localObject1[0], paramAttributeSet);
        if (localObject1.length == 1) {
          a((Activity)localObject3, localObject1[0], str2);
        }
        for (;;)
        {
          if (!bool) {
            break label349;
          }
          localObject2 = c("testDevices", paramContext, paramAttributeSet, false);
          if (((Set)localObject2).contains("TEST_EMULATOR"))
          {
            ((Set)localObject2).remove("TEST_EMULATOR");
            ((Set)localObject2).add(AdRequest.TEST_EMULATOR);
          }
          loadAd(new AdRequest().setTestDevices((Set)localObject2).setKeywords(c("keywords", paramContext, paramAttributeSet, false)));
          break;
          a((Activity)localObject3, new AdSize(0, 0), str2);
          a((AdSize[])localObject1);
        }
        label349:
        break;
      }
      throw new com.google.ads.internal.b("AdView was initialized with a Context that wasn't an Activity.", true);
    }
  }
  
  private void a(Context paramContext, String paramString, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    com.google.ads.util.b.b(paramString);
    a(paramContext, paramString, -65536, paramAdSize, paramAttributeSet);
  }
  
  private void a(AdSize... paramVarArgs)
  {
    AdSize[] arrayOfAdSize = new AdSize[paramVarArgs.length];
    for (int i = 0;; i++)
    {
      if (i >= paramVarArgs.length)
      {
        this.a.h().l.a(arrayOfAdSize);
        return;
      }
      arrayOfAdSize[i] = AdSize.createAdSize(paramVarArgs[i], getContext());
    }
  }
  
  private boolean a(Context paramContext, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    boolean bool;
    if (AdUtil.c(paramContext))
    {
      bool = true;
    }
    else
    {
      a(paramContext, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", paramAdSize, paramAttributeSet);
      bool = false;
    }
    return bool;
  }
  
  private boolean a(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    String str1 = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString);
    boolean bool2 = paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", paramString, paramBoolean);
    String str2;
    String str3;
    TypedValue localTypedValue;
    if (str1 != null)
    {
      str2 = paramContext.getPackageName();
      if (str1.matches("^@([^:]+)\\:(.*)$"))
      {
        str2 = str1.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
        str1 = str1.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
      }
      if (str1.startsWith("@bool/"))
      {
        str3 = str1.substring("@bool/".length());
        localTypedValue = new TypedValue();
      }
    }
    for (;;)
    {
      try
      {
        getResources().getValue(str2 + ":bool/" + str3, localTypedValue, true);
        if (localTypedValue.type != 18) {
          break label215;
        }
        if (localTypedValue.data != 0)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        throw new com.google.ads.internal.b("Could not find resource for " + paramString + ": " + bool1, true, localNotFoundException);
      }
      boolean bool1 = false;
      continue;
      label215:
      throw new com.google.ads.internal.b("Resource " + paramString + " was not a boolean: " + localTypedValue, true);
      bool1 = localTypedValue;
    }
  }
  
  private boolean a(String paramString, AttributeSet paramAttributeSet)
  {
    boolean bool;
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private String b(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    String str1 = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString);
    String str2;
    String str3;
    TypedValue localTypedValue;
    if (str1 != null)
    {
      str2 = paramContext.getPackageName();
      if (str1.matches("^@([^:]+)\\:(.*)$"))
      {
        str2 = str1.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
        str1 = str1.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
      }
      if (str1.startsWith("@string/"))
      {
        str3 = str1.substring("@string/".length());
        localTypedValue = new TypedValue();
      }
    }
    try
    {
      getResources().getValue(str2 + ":string/" + str3, localTypedValue, true);
      if (localTypedValue.string != null)
      {
        str1 = localTypedValue.string.toString();
        if ((!paramBoolean) || (str1 != null)) {
          break label275;
        }
        throw new com.google.ads.internal.b("Required XML attribute \"" + paramString + "\" missing", true);
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      throw new com.google.ads.internal.b("Could not find resource for " + paramString + ": " + str1, true, localNotFoundException);
    }
    throw new com.google.ads.internal.b("Resource " + paramString + " was not a string: " + localTypedValue, true);
    label275:
    return str1;
  }
  
  private boolean b(Context paramContext, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    boolean bool;
    if (AdUtil.b(paramContext))
    {
      bool = true;
    }
    else
    {
      a(paramContext, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", paramAdSize, paramAttributeSet);
      bool = false;
    }
    return bool;
  }
  
  private Set<String> c(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    String str = b(paramString, paramContext, paramAttributeSet, paramBoolean);
    HashSet localHashSet = new HashSet();
    String[] arrayOfString;
    int j;
    if (str != null)
    {
      arrayOfString = str.split(",");
      j = arrayOfString.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return localHashSet;
      }
      str = arrayOfString[i].trim();
      if (str.length() != 0) {
        localHashSet.add(str);
      }
    }
  }
  
  void a(Context paramContext, String paramString, int paramInt, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    if (paramAdSize == null) {
      paramAdSize = AdSize.BANNER;
    }
    AdSize localAdSize = AdSize.createAdSize(paramAdSize, paramContext.getApplicationContext());
    if (getChildCount() == 0)
    {
      TextView localTextView;
      if (paramAttributeSet != null) {
        localTextView = new TextView(paramContext, paramAttributeSet);
      } else {
        localTextView = new TextView(paramContext);
      }
      localTextView.setGravity(17);
      localTextView.setText(paramString);
      localTextView.setTextColor(paramInt);
      localTextView.setBackgroundColor(-16777216);
      LinearLayout localLinearLayout2;
      if (paramAttributeSet != null) {
        localLinearLayout2 = new LinearLayout(paramContext, paramAttributeSet);
      } else {
        localLinearLayout2 = new LinearLayout(paramContext);
      }
      localLinearLayout2.setGravity(17);
      LinearLayout localLinearLayout1;
      if (paramAttributeSet != null) {
        localLinearLayout1 = new LinearLayout(paramContext, paramAttributeSet);
      } else {
        localLinearLayout1 = new LinearLayout(paramContext);
      }
      localLinearLayout1.setGravity(17);
      localLinearLayout1.setBackgroundColor(paramInt);
      int i = a(paramContext, localAdSize.getWidth());
      int j = a(paramContext, localAdSize.getHeight());
      localLinearLayout2.addView(localTextView, i - 2, j - 2);
      localLinearLayout1.addView(localLinearLayout2);
      addView(localLinearLayout1, i, j);
    }
  }
  
  AdSize[] a(String paramString)
  {
    Object localObject = null;
    String[] arrayOfString1 = paramString.split(",");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString1.length];
    int i = 0;
    String[] arrayOfString2;
    if (i < arrayOfString1.length)
    {
      String str = arrayOfString1[i].trim();
      if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
    }
    for (;;)
    {
      try
      {
        if (!"FULL_WIDTH".equals(arrayOfString2[0])) {
          continue;
        }
        int j = -1;
        boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
        if (!bool) {
          continue;
        }
        m = -2;
        AdSize localAdSize1 = new AdSize(j, m);
        if (localAdSize1 != null) {
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int m;
        int k;
        AdSize localAdSize2;
        continue;
      }
      return localObject;
      k = Integer.parseInt(m[0]);
      continue;
      m = Integer.parseInt(m[1]);
      m = m;
      continue;
      if ("BANNER".equals(k))
      {
        localAdSize2 = AdSize.BANNER;
      }
      else if ("SMART_BANNER".equals(localAdSize2))
      {
        localAdSize2 = AdSize.SMART_BANNER;
      }
      else if ("IAB_MRECT".equals(localAdSize2))
      {
        localAdSize2 = AdSize.IAB_MRECT;
      }
      else if ("IAB_BANNER".equals(localAdSize2))
      {
        localAdSize2 = AdSize.IAB_BANNER;
      }
      else if ("IAB_LEADERBOARD".equals(localAdSize2))
      {
        localAdSize2 = AdSize.IAB_LEADERBOARD;
      }
      else if ("IAB_WIDE_SKYSCRAPER".equals(localAdSize2))
      {
        localAdSize2 = AdSize.IAB_WIDE_SKYSCRAPER;
      }
      else
      {
        localAdSize2 = null;
        continue;
        arrayOfAdSize[i] = localAdSize2;
        i++;
        break;
        localObject = arrayOfAdSize;
      }
    }
  }
  
  public void destroy()
  {
    this.a.b();
  }
  
  public boolean isReady()
  {
    boolean bool;
    if (this.a != null) {
      bool = this.a.r();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRefreshing()
  {
    boolean bool;
    if (this.a != null) {
      bool = this.a.s();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    if (this.a != null)
    {
      if (isRefreshing()) {
        this.a.e();
      }
      this.a.a(paramAdRequest);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AdWebView localAdWebView = this.a.k();
    if (localAdWebView != null) {
      localAdWebView.setVisibility(0);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.a.h().m.a(paramAdListener);
  }
  
  protected void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.a.h().n.a(paramAppEventListener);
  }
  
  protected void setSupportedAdSizes(AdSize... paramVarArgs)
  {
    if (this.a.h().l.a() != null) {
      a(paramVarArgs);
    } else {
      com.google.ads.util.b.b("Error: Tried to set supported ad sizes on a single-size AdView.");
    }
  }
  
  public void stopLoading()
  {
    if (this.a != null) {
      this.a.A();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdView
 * JD-Core Version:    0.7.0.1
 */
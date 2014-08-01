package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.ads.AdSize;

public final class ap
{
  private final AdSize[] mg;
  private final String mh;
  
  public ap(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.AdsAttrs);
    String str2 = localTypedArray.getString(0);
    String str1 = localTypedArray.getString(i);
    int j;
    if (TextUtils.isEmpty(str2)) {
      j = 0;
    } else {
      j = i;
    }
    if (TextUtils.isEmpty(str1)) {
      i = 0;
    }
    if ((j == 0) || (i != 0))
    {
      if ((j != 0) || (i == 0))
      {
        if ((j == 0) || (i == 0)) {
          throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
      }
      this.mg = f(str1);
    }
    else
    {
      this.mg = f(str2);
    }
    this.mh = localTypedArray.getString(2);
    if (!TextUtils.isEmpty(this.mh)) {
      return;
    }
    throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
  }
  
  private static AdSize[] f(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString1.length];
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String str = arrayOfString1[i].trim();
      String[] arrayOfString2;
      if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
      for (;;)
      {
        try
        {
          if ("FULL_WIDTH".equals(arrayOfString2[0]))
          {
            j = -1;
            boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
            if (!bool) {
              continue;
            }
            k = -2;
            arrayOfAdSize[i] = new AdSize(j, k);
            i++;
            break;
          }
          int j = Integer.parseInt(arrayOfString2[0]);
          continue;
          int k = Integer.parseInt(arrayOfString2[1]);
          k = k;
          continue;
          if (!"BANNER".equals(str)) {
            break label203;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        arrayOfAdSize[i] = AdSize.BANNER;
        continue;
        label203:
        if ("LARGE_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LARGE_BANNER;
        }
        else if ("FULL_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.FULL_BANNER;
        }
        else if ("LEADERBOARD".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LEADERBOARD;
        }
        else if ("MEDIUM_RECTANGLE".equals(str))
        {
          arrayOfAdSize[i] = AdSize.MEDIUM_RECTANGLE;
        }
        else if ("SMART_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.SMART_BANNER;
        }
        else
        {
          if (!"WIDE_SKYSCRAPER".equals(str)) {
            break label317;
          }
          arrayOfAdSize[i] = AdSize.WIDE_SKYSCRAPER;
        }
      }
      label317:
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }
    if (arrayOfAdSize.length == 0) {
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + paramString);
    }
    return arrayOfAdSize;
  }
  
  public AdSize[] f(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mg.length == 1)) {
      return this.mg;
    }
    throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
  }
  
  public String getAdUnitId()
  {
    return this.mh;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ap
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class fs
  implements SafeParcelable
{
  public static final ft CREATOR = new ft();
  public final String mN;
  final int xJ;
  final fj yn;
  final long yo;
  final int yp;
  final fh yq;
  
  fs(int paramInt1, fj paramfj, long paramLong, int paramInt2, String paramString, fh paramfh)
  {
    this.xJ = paramInt1;
    this.yn = paramfj;
    this.yo = paramLong;
    this.yp = paramInt2;
    this.mN = paramString;
    this.yq = paramfh;
  }
  
  public fs(fj paramfj, long paramLong, int paramInt)
  {
    this(1, paramfj, paramLong, paramInt, null, null);
  }
  
  public fs(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList)
  {
    this(1, a(paramString1, paramIntent), System.currentTimeMillis(), 0, null, a(paramIntent, paramString2, paramUri, paramString3, paramList));
  }
  
  static fh a(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ab(paramString1));
    if (paramUri != null) {
      localArrayList.add(e(paramUri));
    }
    if (paramList != null) {
      localArrayList.add(a(paramList));
    }
    Object localObject = paramIntent.getAction();
    if (localObject != null) {
      localArrayList.add(f("intent_action", (String)localObject));
    }
    localObject = paramIntent.getDataString();
    if (localObject != null) {
      localArrayList.add(f("intent_data", (String)localObject));
    }
    localObject = paramIntent.getComponent();
    if (localObject != null) {
      localArrayList.add(f("intent_activity", ((ComponentName)localObject).getClassName()));
    }
    localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("intent_extra_data_key");
      if (localObject != null) {
        localArrayList.add(f("intent_extra_data", (String)localObject));
      }
    }
    return new fh(paramString2, true, (fl[])localArrayList.toArray(new fl[localArrayList.size()]));
  }
  
  public static fj a(String paramString, Intent paramIntent)
  {
    return new fj(paramString, "", f(paramIntent));
  }
  
  private static fl a(List<AppIndexApi.AppIndexingLink> paramList)
  {
    iw.a locala = new iw.a();
    iw.a.a[] arrayOfa = new iw.a.a[paramList.size()];
    for (int i = 0;; i++)
    {
      if (i >= arrayOfa.length)
      {
        locala.Uv = arrayOfa;
        return new fl(mf.d(locala), new fq.a("outlinks").w(true).aa(".private:outLinks").Z("blob").dL());
      }
      arrayOfa[i] = new iw.a.a();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfa[i].Ux = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfa[i].Uy = localAppIndexingLink.webUrl.toString();
      arrayOfa[i].viewId = localAppIndexingLink.viewId;
    }
  }
  
  private static fl ab(String paramString)
  {
    return new fl(paramString, new fq.a("title").I(1).x(true).aa("name").dL(), "text1");
  }
  
  private static fl e(Uri paramUri)
  {
    return new fl(paramUri.toString(), new fq.a("web_url").I(4).w(true).aa("url").dL());
  }
  
  private static fl f(String paramString1, String paramString2)
  {
    return new fl(paramString2, new fq.a(paramString1).w(true).dL(), paramString1);
  }
  
  private static String f(Intent paramIntent)
  {
    String str = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(str.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException(localUnsupportedEncodingException);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.yn;
    arrayOfObject[1] = Long.valueOf(this.yo);
    arrayOfObject[2] = Integer.valueOf(this.yp);
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ft.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fs
 * JD-Core Version:    0.7.0.1
 */
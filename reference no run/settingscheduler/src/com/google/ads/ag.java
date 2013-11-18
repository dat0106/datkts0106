package com.google.ads;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.a;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Locale;

public final class ag
{
  private static final a a = (a)a.a.b();
  
  public static void a(Activity paramActivity)
  {
    new Thread(new a(paramActivity)).start();
  }
  
  public static void a(Activity paramActivity, WebView paramWebView, String paramString)
  {
    new Thread(new b(paramActivity, paramWebView, paramString)).start();
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    a locala = a;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    locala.a(paramWebView, String.format(localLocale, "(G_resizeIframe(%s))", arrayOfObject));
  }
  
  public static void a(WebView paramWebView, boolean paramBoolean)
  {
    a locala = a;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    locala.a(paramWebView, String.format(localLocale, "(G_updatePlusOne(%b))", arrayOfObject));
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()));
  }
  
  static boolean a(Context paramContext, long paramLong, SharedPreferences paramSharedPreferences)
  {
    boolean bool;
    if ((!ah.a(paramContext)) || ((paramSharedPreferences.contains("drt")) && (paramSharedPreferences.contains("drt_ts")) && (paramSharedPreferences.getLong("drt_ts", 0L) >= new Date().getTime() - paramLong))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  static class c
    implements Runnable
  {
    private final boolean a;
    private final WebView b;
    
    public c(WebView paramWebView, boolean paramBoolean)
    {
      this.b = paramWebView;
      this.a = paramBoolean;
    }
    
    public void run()
    {
      ag.a(this.b, this.a);
    }
  }
  
  private static class b
    implements Runnable
  {
    private final WeakReference<Activity> a;
    private final WebView b;
    private final String c;
    
    public b(Activity paramActivity, WebView paramWebView, String paramString)
    {
      this.a = new WeakReference(paramActivity);
      this.c = paramString;
      this.b = paramWebView;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          Uri localUri = Uri.withAppendedPath(af.a, this.c);
          Object localObject = (Activity)this.a.get();
          if (localObject == null)
          {
            b.a("Activity was null while getting the +1 button state.");
          }
          else
          {
            localObject = ((Activity)localObject).getContentResolver().query(localUri, af.c, null, null, null);
            if ((localObject != null) && (((Cursor)localObject).moveToFirst())) {
              if (((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("has_plus1")) == 1)
              {
                boolean bool = true;
                this.b.post(new ag.c(this.b, bool));
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          b.b("An unknown error occurred while updating the +1 state.", localThrowable);
        }
        int i = 0;
        continue;
        b.a("Google+ app not installed, showing ad as not +1'd");
        i = 0;
      }
    }
  }
  
  private static class a
    implements Runnable
  {
    private final WeakReference<Activity> a;
    private final SharedPreferences.Editor b;
    
    public a(Activity paramActivity)
    {
      this(paramActivity, null);
    }
    
    a(Activity paramActivity, SharedPreferences.Editor paramEditor)
    {
      this.a = new WeakReference(paramActivity);
      this.b = paramEditor;
    }
    
    private SharedPreferences.Editor a(Activity paramActivity)
    {
      SharedPreferences.Editor localEditor;
      if (this.b != null) {
        localEditor = this.b;
      } else {
        localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit();
      }
      return localEditor;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          Object localObject1 = (Activity)this.a.get();
          if (localObject1 == null)
          {
            b.a("Activity was null while making a doritos cookie request.");
          }
          else
          {
            localObject2 = ((Activity)localObject1).getContentResolver().query(af.b, af.d, null, null, null);
            if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()) && (((Cursor)localObject2).getColumnNames().length > 0))
            {
              localObject2 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex(((Cursor)localObject2).getColumnName(0)));
              localObject1 = a((Activity)localObject1);
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label155;
              }
              ((SharedPreferences.Editor)localObject1).putString("drt", (String)localObject2);
              ((SharedPreferences.Editor)localObject1).putLong("drt_ts", new Date().getTime());
              ((SharedPreferences.Editor)localObject1).commit();
            }
          }
        }
        catch (Throwable localThrowable)
        {
          b.b("An unknown error occurred while sending a doritos request.", localThrowable);
        }
        b.a("Google+ app not installed, not storing doritos cookie");
        Object localObject2 = null;
        continue;
        label155:
        localThrowable.putString("drt", "");
        localThrowable.putLong("drt_ts", 0L);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.ag
 * JD-Core Version:    0.7.0.1
 */
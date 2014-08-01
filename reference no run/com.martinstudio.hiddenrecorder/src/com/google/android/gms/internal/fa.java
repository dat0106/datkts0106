package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class fa
  extends WebChromeClient
{
  private final ey lL;
  
  public fa(ey paramey)
  {
    this.lL = paramey;
  }
  
  private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        fa.this.confirm();
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        fa.this.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        fa.this.cancel();
      }
    }).create().show();
  }
  
  private static void a(Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    final EditText localEditText = new EditText(paramContext);
    localEditText.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(localEditText);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        fa.this.confirm(localEditText.getText().toString());
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        fa.this.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        fa.this.cancel();
      }
    }).create().show();
  }
  
  protected final void a(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    cg localcg = this.lL.bV();
    if (localcg != null)
    {
      localcg.a(paramView, paramCustomViewCallback);
      localcg.setRequestedOrientation(paramInt);
    }
    else
    {
      ev.D("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
    }
  }
  
  protected boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString1);
      if (paramBoolean) {
        a(paramContext, localBuilder, paramString2, paramString3, paramJsPromptResult);
      } else {
        a(localBuilder, paramString2, paramJsResult);
      }
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      ev.c("Fail to display Dialog.", localBadTokenException);
    }
    return true;
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if ((paramWebView instanceof ey))
    {
      cg localcg = ((ey)paramWebView).bV();
      if (localcg != null) {
        localcg.close();
      } else {
        ev.D("Tried to close an AdWebView not associated with an overlay.");
      }
    }
    else
    {
      ev.D("Tried to close a WebView that wasn't an AdWebView.");
    }
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    switch (7.sP[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      ev.B(str);
      break;
    case 1: 
      ev.A(str);
      break;
    case 2: 
      ev.D(str);
      break;
    case 3: 
    case 4: 
      ev.B(str);
      break;
    case 5: 
      ev.z(str);
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    WebView localWebView = new WebView(paramWebView.getContext());
    localWebView.setWebViewClient(this.lL.bW());
    localWebViewTransport.setWebView(localWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l > 0L)
    {
      if (paramLong1 != 0L)
      {
        if (paramLong2 != 0L)
        {
          if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
            paramLong1 += paramLong2;
          }
          paramLong2 = paramLong1;
        }
        else
        {
          paramLong2 = Math.min(paramLong1 + Math.min(131072L, l), 1048576L);
        }
      }
      else if ((paramLong2 > l) || (paramLong2 > 1048576L)) {
        paramLong2 = 0L;
      }
      paramQuotaUpdater.updateQuota(paramLong2);
    }
    else
    {
      paramQuotaUpdater.updateQuota(paramLong1);
    }
  }
  
  public final void onHideCustomView()
  {
    cg localcg = this.lL.bV();
    if (localcg != null) {
      localcg.aM();
    } else {
      ev.D("Could not get ad overlay when hiding custom view.");
    }
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    boolean bool;
    if ((!(paramWebView instanceof ey)) || (((ey)paramWebView).ca() == null)) {
      bool = a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
    } else {
      bool = a(((ey)paramWebView).ca(), paramString1, paramString2, null, paramJsResult, null, false);
    }
    return bool;
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l2 = 5242880L - paramLong2;
    long l1 = 131072L + paramLong1;
    if (l2 >= l1) {
      paramQuotaUpdater.updateQuota(l1);
    } else {
      paramQuotaUpdater.updateQuota(0L);
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, -1, paramCustomViewCallback);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fa
 * JD-Core Version:    0.7.0.1
 */
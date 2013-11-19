package com.facebook.android;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FbDialog
  extends Dialog
{
  static final float[] DIMENSIONS_DIFF_LANDSCAPE;
  static final float[] DIMENSIONS_DIFF_PORTRAIT;
  static final String DISPLAY_STRING = "touch";
  static final int FB_BLUE = -9599820;
  static final String FB_ICON = "icon.png";
  static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
  static final int MARGIN = 4;
  static final int PADDING = 2;
  private FrameLayout mContent;
  private ImageView mCrossImage;
  private boolean mDetached = false;
  private Facebook.DialogListener mListener;
  private ProgressDialog mSpinner;
  private String mUrl;
  private WebView mWebView;
  
  static
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 20.0F;
    arrayOfFloat[1] = 60.0F;
    DIMENSIONS_DIFF_LANDSCAPE = arrayOfFloat;
    arrayOfFloat = new float[2];
    arrayOfFloat[0] = 40.0F;
    arrayOfFloat[1] = 60.0F;
    DIMENSIONS_DIFF_PORTRAIT = arrayOfFloat;
  }
  
  public FbDialog(Context paramContext, String paramString, Facebook.DialogListener paramDialogListener)
  {
    super(paramContext, 16973840);
    this.mUrl = paramString;
    this.mListener = paramDialogListener;
  }
  
  private void createCrossImage()
  {
    this.mCrossImage = new ImageView(getContext());
    this.mCrossImage.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FbDialog.this.mListener.onCancel();
        FbDialog.this.dismiss();
      }
    });
    Drawable localDrawable = getContext().getResources().getDrawable(2130837559);
    this.mCrossImage.setImageDrawable(localDrawable);
    this.mCrossImage.setVisibility(4);
  }
  
  private void setUpWebView(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.mWebView = new WebView(getContext());
    this.mWebView.setVerticalScrollBarEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    this.mWebView.setWebViewClient(new FbWebViewClient(null));
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.loadUrl(this.mUrl);
    this.mWebView.setLayoutParams(FILL);
    this.mWebView.setVisibility(4);
    this.mWebView.getSettings().setSavePassword(false);
    localLinearLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
    localLinearLayout.addView(this.mWebView);
    this.mContent.addView(localLinearLayout);
  }
  
  public void dismiss()
  {
    if (!this.mDetached) {
      super.dismiss();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSpinner = new ProgressDialog(getContext());
    this.mSpinner.requestWindowFeature(1);
    this.mSpinner.setMessage("Loading...");
    requestWindowFeature(1);
    this.mContent = new FrameLayout(getContext());
    createCrossImage();
    setUpWebView(this.mCrossImage.getDrawable().getIntrinsicWidth() / 2);
    this.mContent.addView(this.mCrossImage, new ViewGroup.LayoutParams(-2, -2));
    addContentView(this.mContent, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void onDetachedFromWindow()
  {
    Util.logd("Facebook SDK", "onDetachedFromWindow()");
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  private class FbWebViewClient
    extends WebViewClient
  {
    private FbWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!FbDialog.this.mDetached) {
        FbDialog.this.mSpinner.dismiss();
      }
      FbDialog.this.mContent.setBackgroundColor(0);
      FbDialog.this.mWebView.setVisibility(0);
      FbDialog.this.mCrossImage.setVisibility(0);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      Util.logd("Facebook-WebView", "Webview loading URL: " + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!FbDialog.this.mDetached) {
        FbDialog.this.mSpinner.show();
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      FbDialog.this.mListener.onError(new DialogError(paramString1, paramInt, paramString2));
      FbDialog.this.dismiss();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = true;
      Util.logd("Facebook-WebView", "Redirect URL: " + paramString);
      if (!paramString.startsWith("fbconnect://success"))
      {
        if (!paramString.startsWith("fbconnect://cancel"))
        {
          if (!paramString.contains("touch")) {
            FbDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
          } else {
            bool = false;
          }
        }
        else
        {
          FbDialog.this.mListener.onCancel();
          FbDialog.this.dismiss();
        }
      }
      else
      {
        Bundle localBundle = Util.parseUrl(paramString);
        String str = localBundle.getString("error");
        if (str == null) {
          str = localBundle.getString("error_type");
        }
        if (str != null)
        {
          if ((!str.equals("access_denied")) && (!str.equals("OAuthAccessDeniedException"))) {
            FbDialog.this.mListener.onFacebookError(new FacebookError(str));
          } else {
            FbDialog.this.mListener.onCancel();
          }
        }
        else {
          FbDialog.this.mListener.onComplete(localBundle);
        }
        FbDialog.this.dismiss();
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.facebook.android.FbDialog
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class CustomDialog
{
  private static final int LEFT_PADDING_DIPS = 20;
  private static final int RIGHT_PADDING_DIPS = 12;
  private static final int VERTICAL_PADDING_DIPS = 8;
  private String mBody = null;
  private Runnable mCancelAction = null;
  private Context mContext = null;
  private Drawable mIcon = null;
  private Runnable mNegativeAction = null;
  private String mNegativeText = null;
  private Runnable mNeutralAction = null;
  private String mNeutralText = null;
  private Runnable mPositiveAction = null;
  private String mPositiveText = null;
  private String mTitle = null;
  
  public CustomDialog(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private AlertDialog build()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle(this.mTitle);
    if (this.mIcon != null) {
      localBuilder.setIcon(this.mIcon);
    }
    if (this.mBody != null)
    {
      TextView localTextView = new TextView(this.mContext);
      int i = dipsToPixels(20.0F);
      int k = dipsToPixels(12.0F);
      int j = dipsToPixels(8.0F);
      localTextView.setPadding(i, j, k, j);
      localTextView.setText(this.mBody);
      localBuilder.setView(localTextView);
    }
    if (this.mPositiveText != null) {
      localBuilder.setPositiveButton(this.mPositiveText, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (CustomDialog.this.mPositiveAction != null) {
            CustomDialog.this.mPositiveAction.run();
          }
        }
      });
    }
    if (this.mNegativeText != null) {
      localBuilder.setNegativeButton(this.mNegativeText, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (CustomDialog.this.mNegativeAction != null) {
            CustomDialog.this.mNegativeAction.run();
          }
        }
      });
    }
    if (this.mNeutralText != null) {
      localBuilder.setNeutralButton(this.mNeutralText, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (CustomDialog.this.mNeutralAction != null) {
            CustomDialog.this.mNeutralAction.run();
          }
        }
      });
    }
    if (this.mCancelAction != null) {
      localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (CustomDialog.this.mCancelAction != null) {
            CustomDialog.this.mCancelAction.run();
          }
        }
      });
    }
    return localBuilder.create();
  }
  
  private int dipsToPixels(float paramFloat)
  {
    return (int)(paramFloat * this.mContext.getResources().getDisplayMetrics().density);
  }
  
  public AlertDialog get()
  {
    return build();
  }
  
  public void setBody(String paramString)
  {
    this.mBody = paramString;
  }
  
  public void setCancelAction(Runnable paramRunnable)
  {
    this.mCancelAction = paramRunnable;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
  }
  
  public void setNegativeButton(String paramString, Runnable paramRunnable)
  {
    this.mNegativeText = paramString;
    this.mNegativeAction = paramRunnable;
  }
  
  public void setNeutralButton(String paramString, Runnable paramRunnable)
  {
    this.mNeutralText = paramString;
    this.mNeutralAction = paramRunnable;
  }
  
  public void setPositiveButton(String paramString, Runnable paramRunnable)
  {
    this.mPositiveText = paramString;
    this.mPositiveAction = paramRunnable;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.CustomDialog
 * JD-Core Version:    0.7.0.1
 */
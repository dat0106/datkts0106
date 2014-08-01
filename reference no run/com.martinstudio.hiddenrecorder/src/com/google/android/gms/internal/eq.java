package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class eq
{
  private final Context mContext;
  private int mState = 0;
  private String sl;
  private final float sm;
  private float sn;
  private float so;
  private float sp;
  
  public eq(Context paramContext)
  {
    this.mContext = paramContext;
    this.sm = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public eq(Context paramContext, String paramString)
  {
    this(paramContext);
    this.sl = paramString;
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt != 0)
    {
      if (this.mState != -1) {
        if (paramInt != 2)
        {
          if ((paramInt == 1) && (this.mState == 4)) {
            showDialog();
          }
        }
        else
        {
          if (paramFloat2 <= this.so)
          {
            if (paramFloat2 < this.sp) {
              this.sp = paramFloat2;
            }
          }
          else {
            this.so = paramFloat2;
          }
          if (this.so - this.sp <= 30.0F * this.sm)
          {
            if ((this.mState != 0) && (this.mState != 2))
            {
              if (((this.mState == 1) || (this.mState == 3)) && (paramFloat1 - this.sn <= -50.0F * this.sm))
              {
                this.sn = paramFloat1;
                this.mState = (1 + this.mState);
              }
            }
            else if (paramFloat1 - this.sn >= 50.0F * this.sm)
            {
              this.sn = paramFloat1;
              this.mState = (1 + this.mState);
            }
            if ((this.mState != 1) && (this.mState != 3))
            {
              if ((this.mState == 2) && (paramFloat1 < this.sn)) {
                this.sn = paramFloat1;
              }
            }
            else if (paramFloat1 > this.sn) {
              this.sn = paramFloat1;
            }
          }
          else
          {
            this.mState = -1;
          }
        }
      }
    }
    else
    {
      this.mState = 0;
      this.sn = paramFloat1;
      this.so = paramFloat2;
      this.sp = paramFloat2;
    }
  }
  
  private void showDialog()
  {
    Object localObject1;
    Object localObject2;
    Map localMap;
    if (TextUtils.isEmpty(this.sl))
    {
      localObject1 = "No debug information";
    }
    else
    {
      localObject2 = new Uri.Builder().encodedQuery(this.sl).build();
      localObject1 = new StringBuilder();
      localMap = ep.b((Uri)localObject2);
      localObject2 = localMap.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        localObject1 = ((StringBuilder)localObject1).toString().trim();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = "No debug information";
        }
        localObject2 = new AlertDialog.Builder(this.mContext);
        ((AlertDialog.Builder)localObject2).setMessage((CharSequence)localObject1);
        ((AlertDialog.Builder)localObject2).setTitle("Ad Information");
        ((AlertDialog.Builder)localObject2).setPositiveButton("Share", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            eq.a(eq.this).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.sq), "Share via"));
          }
        });
        ((AlertDialog.Builder)localObject2).setNegativeButton("Close", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        ((AlertDialog.Builder)localObject2).create().show();
        return;
      }
      String str = (String)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(str).append(" = ").append((String)localMap.get(str)).append("\n\n");
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
        return;
      }
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
    }
  }
  
  public void x(String paramString)
  {
    this.sl = paramString;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eq
 * JD-Core Version:    0.7.0.1
 */
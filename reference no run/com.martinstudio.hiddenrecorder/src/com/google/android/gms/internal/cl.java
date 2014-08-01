package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class cl
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton oP;
  private final Activity oe;
  
  public cl(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.oe = paramActivity;
    setOnClickListener(this);
    this.oP = new ImageButton(paramActivity);
    this.oP.setImageResource(17301527);
    this.oP.setBackgroundColor(0);
    this.oP.setOnClickListener(this);
    this.oP.setPadding(0, 0, 0, 0);
    int i = eu.a(paramActivity, paramInt);
    addView(this.oP, new FrameLayout.LayoutParams(i, i, 17));
  }
  
  public void j(boolean paramBoolean)
  {
    ImageButton localImageButton = this.oP;
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localImageButton.setVisibility(i);
  }
  
  public void onClick(View paramView)
  {
    this.oe.finish();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cl
 * JD-Core Version:    0.7.0.1
 */
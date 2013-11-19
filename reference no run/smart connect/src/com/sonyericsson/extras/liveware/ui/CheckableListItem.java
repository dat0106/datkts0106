package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckableListItem
  extends LinearLayout
  implements Checkable
{
  private boolean mIsChecked = false;
  
  public CheckableListItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public CheckableListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CheckableListItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void hideDescription()
  {
    ((TextView)findViewById(2131558478)).setVisibility(8);
  }
  
  public void hideIcon()
  {
    ((ImageView)findViewById(2131558476)).setVisibility(8);
  }
  
  public boolean isChecked()
  {
    return this.mIsChecked;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mIsChecked = paramBoolean;
    ((Checkable)findViewById(2131558475)).setChecked(this.mIsChecked);
  }
  
  public void setDescription(int paramInt)
  {
    TextView localTextView = (TextView)findViewById(2131558478);
    localTextView.setVisibility(0);
    localTextView.setText(paramInt);
  }
  
  public void setDescription(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131558478);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
    }
    else
    {
      localTextView.setVisibility(0);
      localTextView.setText(paramString);
    }
  }
  
  public void setIcon(int paramInt)
  {
    ImageView localImageView = (ImageView)findViewById(2131558476);
    localImageView.setVisibility(0);
    localImageView.setImageResource(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    ImageView localImageView = (ImageView)findViewById(2131558476);
    localImageView.setVisibility(0);
    localImageView.setImageDrawable(paramDrawable);
  }
  
  public void setName(int paramInt)
  {
    ((TextView)findViewById(2131558477)).setText(paramInt);
  }
  
  public void setName(String paramString)
  {
    ((TextView)findViewById(2131558477)).setText(paramString);
  }
  
  public void showCheckable()
  {
    findViewById(2131558475).setVisibility(0);
  }
  
  public void showCheckable(boolean paramBoolean)
  {
    View localView = findViewById(2131558475);
    int i;
    if (!paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
  }
  
  public void toggle()
  {
    boolean bool;
    if (!this.mIsChecked) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsChecked = bool;
    ((Checkable)findViewById(2131558475)).setChecked(this.mIsChecked);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.CheckableListItem
 * JD-Core Version:    0.7.0.1
 */
package com.smartandroidapps.audiowidgetlib.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.style;
import java.util.ArrayList;

public class QuickAction
  extends CustomPopupWindow
{
  protected static final int ANIM_AUTO = 5;
  protected static final int ANIM_GROW_FROM_CENTER = 3;
  protected static final int ANIM_GROW_FROM_LEFT = 1;
  protected static final int ANIM_GROW_FROM_RIGHT = 2;
  protected static final int ANIM_REFLECT = 4;
  private ArrayList<ActionItem> actionList = new ArrayList();
  private int animStyle;
  private final Context context;
  private final LayoutInflater inflater;
  private ViewGroup mTrack;
  private final View root;
  private ScrollView scroller;
  
  public QuickAction(View paramView)
  {
    super(paramView);
    this.context = paramView.getContext();
    this.inflater = ((LayoutInflater)this.context.getSystemService("layout_inflater"));
    this.root = ((ViewGroup)this.inflater.inflate(R.layout.popup, null));
    setContentView(this.root);
    this.mTrack = ((ViewGroup)this.root.findViewById(R.id.tracks));
    this.scroller = ((ScrollView)this.root.findViewById(R.id.scroller));
    this.animStyle = 5;
  }
  
  private void createActionList()
  {
    for (int i = 0;; i++)
    {
      if (i >= this.actionList.size()) {
        return;
      }
      View localView = getActionItem(((ActionItem)this.actionList.get(i)).getTitle(), ((ActionItem)this.actionList.get(i)).getIcon(), ((ActionItem)this.actionList.get(i)).getListener());
      localView.setFocusable(true);
      localView.setClickable(true);
      this.mTrack.addView(localView);
    }
  }
  
  private View getActionItem(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.inflater.inflate(R.layout.action_item, null);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(R.id.icon);
    TextView localTextView = (TextView)localLinearLayout.findViewById(R.id.title);
    localTextView.setTextSize(18.0F);
    localTextView.setGravity(19);
    if (paramDrawable != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
    if (paramString != null) {
      localTextView.setText(paramString);
    }
    if (paramOnClickListener != null) {
      localLinearLayout.setOnClickListener(paramOnClickListener);
    }
    return localLinearLayout;
  }
  
  private void setAnimationStyle(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    PopupWindow localPopupWindow1;
    int k;
    PopupWindow localPopupWindow3;
    int i;
    switch (this.animStyle)
    {
    case 1: 
      localPopupWindow1 = this.window;
      if (!paramBoolean) {
        k = R.style.Animations_PopDownMenu_Left;
      } else {
        k = R.style.Animations_PopUpMenu_Left;
      }
      localPopupWindow1.setAnimationStyle(k);
      break;
    case 2: 
      localPopupWindow1 = this.window;
      if (!paramBoolean) {
        k = R.style.Animations_PopDownMenu_Right;
      } else {
        k = R.style.Animations_PopUpMenu_Right;
      }
      localPopupWindow1.setAnimationStyle(k);
      break;
    case 3: 
      localPopupWindow1 = this.window;
      if (!paramBoolean) {
        k = R.style.Animations_PopDownMenu_Center;
      } else {
        k = R.style.Animations_PopUpMenu_Center;
      }
      localPopupWindow1.setAnimationStyle(k);
      break;
    case 4: 
      localPopupWindow3 = this.window;
      if (!paramBoolean) {
        i = R.style.Animations_PopDownMenu_Reflect;
      } else {
        i = R.style.Animations_PopUpMenu_Reflect;
      }
      localPopupWindow3.setAnimationStyle(i);
      break;
    case 5: 
      if (paramInt2 > paramInt1 / 4)
      {
        if ((paramInt2 <= paramInt1 / 4) || (paramInt2 >= 3 * (paramInt1 / 4)))
        {
          localPopupWindow3 = this.window;
          if (!paramBoolean) {
            i = R.style.Animations_PopDownMenu_Right;
          } else {
            i = R.style.Animations_PopUpMenu_Right;
          }
          localPopupWindow3.setAnimationStyle(i);
        }
        else
        {
          PopupWindow localPopupWindow2 = this.window;
          int m;
          if (!paramBoolean) {
            m = R.style.Animations_PopDownMenu_Center;
          } else {
            m = R.style.Animations_PopUpMenu_Center;
          }
          localPopupWindow2.setAnimationStyle(m);
        }
      }
      else
      {
        PopupWindow localPopupWindow4 = this.window;
        int j;
        if (!paramBoolean) {
          j = R.style.Animations_PopDownMenu_Left;
        } else {
          j = R.style.Animations_PopUpMenu_Left;
        }
        localPopupWindow4.setAnimationStyle(j);
      }
      break;
    }
  }
  
  public void addActionItem(ActionItem paramActionItem)
  {
    this.actionList.add(paramActionItem);
  }
  
  public void setAnimStyle(int paramInt)
  {
    this.animStyle = paramInt;
  }
  
  public void show()
  {
    preShow();
    Object localObject = new int[2];
    this.anchor.getLocationOnScreen((int[])localObject);
    localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.anchor.getWidth(), localObject[1] + this.anchor.getHeight());
    createActionList();
    this.root.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.root.measure(-2, -2);
    int j = this.root.getMeasuredHeight();
    int k = this.root.getMeasuredWidth();
    int i = this.windowManager.getDefaultDisplay().getWidth();
    int n = this.windowManager.getDefaultDisplay().getHeight();
    int m;
    if (k + ((Rect)localObject).left <= i)
    {
      if (this.anchor.getWidth() <= k) {
        m = ((Rect)localObject).left;
      } else {
        m = ((Rect)localObject).centerX() - k / 2;
      }
    }
    else {
      m = ((Rect)localObject).left - (k - this.anchor.getWidth());
    }
    k = ((Rect)localObject).top;
    int i1 = n - ((Rect)localObject).bottom;
    boolean bool;
    if (k <= i1) {
      bool = false;
    } else {
      bool = true;
    }
    if (!bool)
    {
      n = ((Rect)localObject).bottom;
      if (j > i1) {
        this.scroller.getLayoutParams().height = i1;
      }
    }
    else if (j <= k)
    {
      n = ((Rect)localObject).top - j;
    }
    else
    {
      n = 15;
      this.scroller.getLayoutParams().height = (k - this.anchor.getHeight());
    }
    setAnimationStyle(i, ((Rect)localObject).centerX(), bool);
    this.window.showAtLocation(this.anchor, 0, m, n);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.QuickAction
 * JD-Core Version:    0.7.0.1
 */
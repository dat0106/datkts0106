package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;

public class ListMenuItemView
  extends LinearLayout
  implements MenuView.ItemView
{
  private Drawable mBackground;
  private CheckBox mCheckBox;
  final Context mContext;
  private boolean mForceShowIcon;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuView, paramInt, 0);
    this.mBackground = localTypedArray.getDrawable(4);
    this.mTextAppearance = localTypedArray.getResourceId(0, -1);
    this.mPreserveIconSpacing = localTypedArray.getBoolean(7, false);
    this.mTextAppearanceContext = paramContext;
    localTypedArray.recycle();
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    return this.mInflater;
  }
  
  private void insertCheckBox()
  {
    this.mCheckBox = ((CheckBox)getInflater().inflate(R.layout.abs__list_menu_item_checkbox, this, false));
    addView(this.mCheckBox);
  }
  
  private void insertIconView()
  {
    this.mIconView = ((ImageView)getInflater().inflate(R.layout.abs__list_menu_item_icon, this, false));
    addView(this.mIconView, 0);
  }
  
  private void insertRadioButton()
  {
    this.mRadioButton = ((RadioButton)getInflater().inflate(R.layout.abs__list_menu_item_radio, this, false));
    addView(this.mRadioButton);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    int i;
    if (!paramMenuItemImpl.isVisible()) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(this.mBackground);
    this.mTitleView = ((TextView)findViewById(R.id.abs__title));
    if (this.mTextAppearance != -1) {
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
    }
    this.mShortcutView = ((TextView)findViewById(R.id.abs__shortcut));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mIconView != null) && (this.mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams1 = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if ((localLayoutParams1.height > 0) && (localLayoutParams.width <= 0)) {
        localLayoutParams.width = localLayoutParams1.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mRadioButton != null) || (this.mCheckBox != null))
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      Object localObject2;
      Object localObject1;
      if (!this.mItemData.isExclusiveCheckable())
      {
        localObject2 = this.mCheckBox;
        localObject1 = this.mRadioButton;
      }
      else
      {
        localObject2 = this.mRadioButton;
        localObject1 = this.mCheckBox;
      }
      if (!paramBoolean)
      {
        this.mCheckBox.setVisibility(8);
        this.mRadioButton.setVisibility(8);
      }
      else
      {
        ((CompoundButton)localObject2).setChecked(this.mItemData.isChecked());
        int i;
        if (!paramBoolean) {
          i = 8;
        } else {
          i = 0;
        }
        if (((CompoundButton)localObject2).getVisibility() != i) {
          ((CompoundButton)localObject2).setVisibility(i);
        }
        if (((CompoundButton)localObject1).getVisibility() != 8) {
          ((CompoundButton)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (!this.mItemData.isExclusiveCheckable())
    {
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      localObject = this.mCheckBox;
    }
    else
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      localObject = this.mRadioButton;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    this.mPreserveIconSpacing = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((!this.mItemData.shouldShowIcon()) && (!this.mForceShowIcon)) {
      i = 0;
    } else {
      i = 1;
    }
    if (((i != 0) || (this.mPreserveIconSpacing)) && ((this.mIconView != null) || (paramDrawable != null) || (this.mPreserveIconSpacing)))
    {
      if (this.mIconView == null) {
        insertIconView();
      }
      if ((paramDrawable == null) && (!this.mPreserveIconSpacing))
      {
        this.mIconView.setVisibility(8);
      }
      else
      {
        ImageView localImageView = this.mIconView;
        if (i == 0) {
          paramDrawable = null;
        }
        localImageView.setImageDrawable(paramDrawable);
        if (this.mIconView.getVisibility() != 0) {
          this.mIconView.setVisibility(0);
        }
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    int i;
    if ((!paramBoolean) || (!this.mItemData.shouldShowShortcut())) {
      i = 8;
    } else {
      i = 0;
    }
    if (i == 0) {
      this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    }
    if (this.mShortcutView.getVisibility() != i) {
      this.mShortcutView.setVisibility(i);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
    {
      if (this.mTitleView.getVisibility() != 8) {
        this.mTitleView.setVisibility(8);
      }
    }
    else
    {
      this.mTitleView.setText(paramCharSequence);
      if (this.mTitleView.getVisibility() != 0) {
        this.mTitleView.setVisibility(0);
      }
    }
  }
  
  public boolean showsIcon()
  {
    return this.mForceShowIcon;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.widget.CapitalizingButton;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActionMenuItemView
  extends LinearLayout
  implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView, View_HasStateListenerSupport
{
  private boolean mAllowTextWithIcon;
  private boolean mExpandedFormat;
  private ImageButton mImageButton;
  private MenuItemImpl mItemData;
  private MenuBuilder.ItemInvoker mItemInvoker;
  private final Set<View_OnAttachStateChangeListener> mListeners = new HashSet();
  private int mMinWidth;
  private CapitalizingButton mTextButton;
  private CharSequence mTitle;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mAllowTextWithIcon = ResourcesCompat.getResources_getBoolean(paramContext, R.bool.abs__config_allowActionMenuItemTextWithIcon);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionMenuItemView, 0, 0);
    this.mMinWidth = localTypedArray.getDimensionPixelSize(0, 0);
    localTypedArray.recycle();
  }
  
  private void updateTextButtonVisibility()
  {
    int k = 1;
    int i = 0;
    int j;
    if (TextUtils.isEmpty(this.mTextButton.getText())) {
      j = 0;
    } else {
      j = k;
    }
    if ((this.mImageButton.getDrawable() != null) && ((!this.mItemData.showsTextAsAction()) || ((!this.mAllowTextWithIcon) && (!this.mExpandedFormat)))) {
      k = 0;
    }
    j &= k;
    CapitalizingButton localCapitalizingButton = this.mTextButton;
    if (j == 0) {
      i = 8;
    }
    localCapitalizingButton.setVisibility(i);
  }
  
  public void addOnAttachStateChangeListener(View_OnAttachStateChangeListener paramView_OnAttachStateChangeListener)
  {
    this.mListeners.add(paramView_OnAttachStateChangeListener);
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 14) {
      bool = false;
    } else {
      bool = onHoverEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public boolean hasText()
  {
    boolean bool;
    if (this.mTextButton.getVisibility() == 8) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setId(paramMenuItemImpl.getItemId());
    int i;
    if (!paramMenuItemImpl.isVisible()) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
    setEnabled(paramMenuItemImpl.isEnabled());
  }
  
  public boolean needsDividerAfter()
  {
    return hasText();
  }
  
  public boolean needsDividerBefore()
  {
    boolean bool;
    if ((!hasText()) || (this.mItemData.getIcon() != null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((View_OnAttachStateChangeListener)localIterator.next()).onViewAttachedToWindow(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mItemInvoker != null) {
      this.mItemInvoker.invokeItem(this.mItemData);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((View_OnAttachStateChangeListener)localIterator.next()).onViewDetachedFromWindow(this);
    }
  }
  
  public void onFinishInflate()
  {
    this.mImageButton = ((ImageButton)findViewById(R.id.abs__imageButton));
    this.mTextButton = ((CapitalizingButton)findViewById(R.id.abs__textButton));
    this.mImageButton.setOnClickListener(this);
    this.mTextButton.setOnClickListener(this);
    this.mImageButton.setOnLongClickListener(this);
    setOnClickListener(this);
    setOnLongClickListener(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    if (!hasText())
    {
      int[] arrayOfInt = new int[2];
      Rect localRect = new Rect();
      getLocationOnScreen(arrayOfInt);
      getWindowVisibleDisplayFrame(localRect);
      Object localObject = getContext();
      i = getWidth();
      int m = getHeight();
      int k = arrayOfInt[1] + m / 2;
      int j = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      localObject = Toast.makeText((Context)localObject, this.mItemData.getTitle(), 0);
      if (k >= localRect.height()) {
        ((Toast)localObject).setGravity(81, 0, m);
      } else {
        ((Toast)localObject).setGravity(53, j - arrayOfInt[0] - i / 2, m);
      }
      ((Toast)localObject).show();
      i = 1;
    }
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = getMeasuredWidth();
    if (j != -2147483648) {
      k = this.mMinWidth;
    } else {
      k = Math.min(k, this.mMinWidth);
    }
    if ((j != 1073741824) && (this.mMinWidth > 0) && (i < k)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), paramInt2);
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    CharSequence localCharSequence = getContentDescription();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramAccessibilityEvent.getText().add(localCharSequence);
    }
  }
  
  public boolean prefersCondensedTitle()
  {
    return true;
  }
  
  public void removeOnAttachStateChangeListener(View_OnAttachStateChangeListener paramView_OnAttachStateChangeListener)
  {
    this.mListeners.remove(paramView_OnAttachStateChangeListener);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mImageButton.setEnabled(paramBoolean);
    this.mTextButton.setEnabled(paramBoolean);
  }
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.mExpandedFormat != paramBoolean)
    {
      this.mExpandedFormat = paramBoolean;
      if (this.mItemData != null) {
        this.mItemData.actionFormatChanged();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mImageButton.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      this.mImageButton.setVisibility(8);
    } else {
      this.mImageButton.setVisibility(0);
    }
    updateTextButtonVisibility();
  }
  
  public void setItemInvoker(MenuBuilder.ItemInvoker paramItemInvoker)
  {
    this.mItemInvoker = paramItemInvoker;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    this.mTextButton.setTextCompat(this.mTitle);
    setContentDescription(this.mTitle);
    updateTextButtonVisibility();
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.actionbarsherlock.R.dimen;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.string;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import com.actionbarsherlock.view.ActionProvider;

class ActivityChooserView
  extends ViewGroup
  implements ActivityChooserModel.ActivityChooserModelClient
{
  private static final boolean IS_HONEYCOMB;
  private final IcsLinearLayout mActivityChooserContent;
  private final Drawable mActivityChooserContentBackground;
  private final ActivityChooserViewAdapter mAdapter;
  private final Callbacks mCallbacks;
  private final Context mContext;
  private int mDefaultActionButtonContentDescription;
  private final FrameLayout mDefaultActivityButton;
  private final ImageView mDefaultActivityButtonImage;
  private final FrameLayout mExpandActivityOverflowButton;
  private final ImageView mExpandActivityOverflowButtonImage;
  private int mInitialActivityCount = 4;
  private boolean mIsAttachedToWindow;
  private boolean mIsSelectingDefaultActivity;
  private final int mListPopupMaxWidth;
  private IcsListPopupWindow mListPopupWindow;
  private final DataSetObserver mModelDataSetOberver = new DataSetObserver()
  {
    public void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.mAdapter.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
    }
  };
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ActivityChooserView.this.isShowingPopup()) {
        if (ActivityChooserView.this.isShown())
        {
          ActivityChooserView.this.getListPopupWindow().show();
          if (ActivityChooserView.this.mProvider != null) {
            ActivityChooserView.this.mProvider.subUiVisibilityChanged(true);
          }
        }
        else
        {
          ActivityChooserView.this.getListPopupWindow().dismiss();
        }
      }
    }
  };
  ActionProvider mProvider;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = false;
    } else {
      bool = true;
    }
    IS_HONEYCOMB = bool;
  }
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActivityChooserView, paramInt, 0);
    this.mInitialActivityCount = localTypedArray.getInt(1, 4);
    Object localObject = localTypedArray.getDrawable(2);
    localTypedArray.recycle();
    LayoutInflater.from(this.mContext).inflate(R.layout.abs__activity_chooser_view, this, true);
    this.mCallbacks = new Callbacks(null);
    this.mActivityChooserContent = ((IcsLinearLayout)findViewById(R.id.abs__activity_chooser_view_content));
    this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
    this.mDefaultActivityButton = ((FrameLayout)findViewById(R.id.abs__default_activity_button));
    this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
    this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
    this.mDefaultActivityButtonImage = ((ImageView)this.mDefaultActivityButton.findViewById(R.id.abs__image));
    this.mExpandActivityOverflowButton = ((FrameLayout)findViewById(R.id.abs__expand_activities_button));
    this.mExpandActivityOverflowButton.setOnClickListener(this.mCallbacks);
    this.mExpandActivityOverflowButtonImage = ((ImageView)this.mExpandActivityOverflowButton.findViewById(R.id.abs__image));
    this.mExpandActivityOverflowButtonImage.setImageDrawable((Drawable)localObject);
    this.mAdapter = new ActivityChooserViewAdapter(null);
    this.mAdapter.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        ActivityChooserView.this.updateAppearance();
      }
    });
    localObject = paramContext.getResources();
    this.mListPopupMaxWidth = Math.max(((Resources)localObject).getDisplayMetrics().widthPixels / 2, ((Resources)localObject).getDimensionPixelSize(R.dimen.abs__config_prefDialogWidth));
  }
  
  private IcsListPopupWindow getListPopupWindow()
  {
    if (this.mListPopupWindow == null)
    {
      this.mListPopupWindow = new IcsListPopupWindow(getContext());
      this.mListPopupWindow.setAdapter(this.mAdapter);
      this.mListPopupWindow.setAnchorView(this);
      this.mListPopupWindow.setModal(true);
      this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
      this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    }
    return this.mListPopupWindow;
  }
  
  private void showPopupUnchecked(int paramInt)
  {
    if (this.mAdapter.getDataModel() != null)
    {
      getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
      boolean bool;
      if (this.mDefaultActivityButton.getVisibility() != 0) {
        bool = false;
      } else {
        bool = true;
      }
      int j = this.mAdapter.getActivityCount();
      int i;
      if (!bool) {
        i = 0;
      } else {
        i = 1;
      }
      if ((paramInt == 2147483647) || (j <= paramInt + i))
      {
        this.mAdapter.setShowFooterView(false);
        this.mAdapter.setMaxActivityCount(paramInt);
      }
      else
      {
        this.mAdapter.setShowFooterView(true);
        this.mAdapter.setMaxActivityCount(paramInt - 1);
      }
      IcsListPopupWindow localIcsListPopupWindow = getListPopupWindow();
      if (!localIcsListPopupWindow.isShowing())
      {
        if ((!this.mIsSelectingDefaultActivity) && (bool)) {
          this.mAdapter.setShowDefaultActivity(false, false);
        } else {
          this.mAdapter.setShowDefaultActivity(true, bool);
        }
        localIcsListPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        localIcsListPopupWindow.show();
        if (this.mProvider != null) {
          this.mProvider.subUiVisibilityChanged(true);
        }
        localIcsListPopupWindow.getListView().setContentDescription(this.mContext.getString(R.string.abs__activitychooserview_choose_application));
      }
      return;
    }
    throw new IllegalStateException("No data model. Did you call #setDataModel?");
  }
  
  private void updateAppearance()
  {
    if (this.mAdapter.getCount() <= 0) {
      this.mExpandActivityOverflowButton.setEnabled(false);
    } else {
      this.mExpandActivityOverflowButton.setEnabled(true);
    }
    int j = this.mAdapter.getActivityCount();
    int i = this.mAdapter.getHistorySize();
    if ((j <= 0) || (i <= 0))
    {
      this.mDefaultActivityButton.setVisibility(8);
    }
    else
    {
      this.mDefaultActivityButton.setVisibility(0);
      Object localObject2 = this.mAdapter.getDefaultActivity();
      Object localObject1 = this.mContext.getPackageManager();
      this.mDefaultActivityButtonImage.setImageDrawable(((ResolveInfo)localObject2).loadIcon((PackageManager)localObject1));
      if (this.mDefaultActionButtonContentDescription != 0)
      {
        localObject1 = ((ResolveInfo)localObject2).loadLabel((PackageManager)localObject1);
        localObject2 = this.mContext;
        int k = this.mDefaultActionButtonContentDescription;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localObject1;
        localObject1 = ((Context)localObject2).getString(k, arrayOfObject);
        this.mDefaultActivityButton.setContentDescription((CharSequence)localObject1);
      }
    }
    if (this.mDefaultActivityButton.getVisibility() != 0) {
      this.mActivityChooserContent.setBackgroundDrawable(null);
    } else {
      this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
    }
  }
  
  public boolean dismissPopup()
  {
    if (isShowingPopup())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
      }
    }
    return true;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.mAdapter.getDataModel();
  }
  
  public boolean isShowingPopup()
  {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = this.mAdapter.getDataModel();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(this.mModelDataSetOberver);
    }
    this.mIsAttachedToWindow = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mAdapter.getDataModel();
    if (localObject != null) {
      ((ActivityChooserModel)localObject).unregisterObserver(this.mModelDataSetOberver);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    }
    this.mIsAttachedToWindow = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!getListPopupWindow().isShowing()) {
      dismissPopup();
    } else {
      showPopupUnchecked(this.mAdapter.getMaxActivityCount());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    IcsLinearLayout localIcsLinearLayout = this.mActivityChooserContent;
    if (this.mDefaultActivityButton.getVisibility() != 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localIcsLinearLayout, paramInt1, paramInt2);
    setMeasuredDimension(localIcsLinearLayout.getMeasuredWidth(), localIcsLinearLayout.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    this.mAdapter.setDataModel(paramActivityChooserModel);
    if (isShowingPopup())
    {
      dismissPopup();
      showPopup();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.mDefaultActionButtonContentDescription = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = this.mContext.getString(paramInt);
    this.mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.mInitialActivityCount = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.mProvider = paramActionProvider;
  }
  
  public boolean showPopup()
  {
    boolean bool = false;
    if ((!isShowingPopup()) && (this.mIsAttachedToWindow))
    {
      this.mIsSelectingDefaultActivity = false;
      showPopupUnchecked(this.mInitialActivityCount);
      bool = true;
    }
    return bool;
  }
  
  private class ActivityChooserViewAdapter
    extends BaseAdapter
  {
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 2147483647;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount = 4;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    
    private ActivityChooserViewAdapter() {}
    
    public int getActivityCount()
    {
      return this.mDataModel.getActivityCount();
    }
    
    public int getCount()
    {
      int i = this.mDataModel.getActivityCount();
      if ((!this.mShowDefaultActivity) && (this.mDataModel.getDefaultActivity() != null)) {
        i--;
      }
      i = Math.min(i, this.mMaxActivityCount);
      if (this.mShowFooterView) {
        i++;
      }
      return i;
    }
    
    public ActivityChooserModel getDataModel()
    {
      return this.mDataModel;
    }
    
    public ResolveInfo getDefaultActivity()
    {
      return this.mDataModel.getDefaultActivity();
    }
    
    public int getHistorySize()
    {
      return this.mDataModel.getHistorySize();
    }
    
    public Object getItem(int paramInt)
    {
      ResolveInfo localResolveInfo;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        if ((!this.mShowDefaultActivity) && (this.mDataModel.getDefaultActivity() != null)) {
          paramInt++;
        }
        localResolveInfo = this.mDataModel.getActivity(paramInt);
        break;
      case 1: 
        localResolveInfo = null;
      }
      return localResolveInfo;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      int i;
      if ((!this.mShowFooterView) || (paramInt != -1 + getCount())) {
        i = 0;
      } else {
        i = 1;
      }
      return i;
    }
    
    public int getMaxActivityCount()
    {
      return this.mMaxActivityCount;
    }
    
    public boolean getShowDefaultActivity()
    {
      return this.mShowDefaultActivity;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        if ((paramView == null) || (paramView.getId() != R.id.abs__list_item)) {
          paramView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abs__activity_chooser_view_list_item, paramViewGroup, false);
        }
        PackageManager localPackageManager = ActivityChooserView.this.mContext.getPackageManager();
        localObject = (ImageView)paramView.findViewById(R.id.abs__icon);
        ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
        ((ImageView)localObject).setImageDrawable(localResolveInfo.loadIcon(localPackageManager));
        ((TextView)paramView.findViewById(R.id.abs__title)).setText(localResolveInfo.loadLabel(localPackageManager));
        if (ActivityChooserView.IS_HONEYCOMB) {
          if ((!this.mShowDefaultActivity) || (paramInt != 0) || (!this.mHighlightDefaultActivity)) {
            ActivityChooserView.SetActivated.invoke(paramView, false);
          } else {
            ActivityChooserView.SetActivated.invoke(paramView, true);
          }
        }
        localObject = paramView;
        break;
      case 1: 
        if ((paramView == null) || (paramView.getId() != 1))
        {
          paramView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abs__activity_chooser_view_list_item, paramViewGroup, false);
          paramView.setId(1);
          ((TextView)paramView.findViewById(R.id.abs__title)).setText(ActivityChooserView.this.mContext.getString(R.string.abs__activity_chooser_view_see_all));
        }
        localObject = paramView;
      }
      return localObject;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public int measureContentWidth()
    {
      int n = this.mMaxActivityCount;
      this.mMaxActivityCount = 2147483647;
      int m = 0;
      View localView = null;
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = getCount();
      for (int k = 0;; k++)
      {
        if (k >= j)
        {
          this.mMaxActivityCount = n;
          return m;
        }
        localView = getView(k, localView, null);
        localView.measure(i1, i);
        m = Math.max(m, localView.getMeasuredWidth());
      }
    }
    
    public void setDataModel(ActivityChooserModel paramActivityChooserModel)
    {
      ActivityChooserModel localActivityChooserModel = ActivityChooserView.this.mAdapter.getDataModel();
      if ((localActivityChooserModel != null) && (ActivityChooserView.this.isShown())) {
        localActivityChooserModel.unregisterObserver(ActivityChooserView.this.mModelDataSetOberver);
      }
      this.mDataModel = paramActivityChooserModel;
      if ((paramActivityChooserModel != null) && (ActivityChooserView.this.isShown())) {
        paramActivityChooserModel.registerObserver(ActivityChooserView.this.mModelDataSetOberver);
      }
      notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(int paramInt)
    {
      if (this.mMaxActivityCount != paramInt)
      {
        this.mMaxActivityCount = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mShowDefaultActivity != paramBoolean1) || (this.mHighlightDefaultActivity != paramBoolean2))
      {
        this.mShowDefaultActivity = paramBoolean1;
        this.mHighlightDefaultActivity = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public void setShowFooterView(boolean paramBoolean)
    {
      if (this.mShowFooterView != paramBoolean)
      {
        this.mShowFooterView = paramBoolean;
        notifyDataSetChanged();
      }
    }
  }
  
  private static class SetActivated
  {
    public static void invoke(View paramView, boolean paramBoolean)
    {
      paramView.setActivated(paramBoolean);
    }
  }
  
  private class Callbacks
    implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
  {
    private Callbacks() {}
    
    private void notifyOnDismissListener()
    {
      if (ActivityChooserView.this.mOnDismissListener != null) {
        ActivityChooserView.this.mOnDismissListener.onDismiss();
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView != ActivityChooserView.this.mDefaultActivityButton)
      {
        if (paramView != ActivityChooserView.this.mExpandActivityOverflowButton) {
          throw new IllegalArgumentException();
        }
        ActivityChooserView.access$602(ActivityChooserView.this, false);
        ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
      }
      else
      {
        ActivityChooserView.this.dismissPopup();
        ResolveInfo localResolveInfo = ActivityChooserView.this.mAdapter.getDefaultActivity();
        int i = ActivityChooserView.this.mAdapter.getDataModel().getActivityIndex(localResolveInfo);
        Intent localIntent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(i);
        if (localIntent != null) {
          ActivityChooserView.this.mContext.startActivity(localIntent);
        }
      }
    }
    
    public void onDismiss()
    {
      notifyOnDismissListener();
      if (ActivityChooserView.this.mProvider != null) {
        ActivityChooserView.this.mProvider.subUiVisibilityChanged(false);
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        ActivityChooserView.this.dismissPopup();
        if (!ActivityChooserView.this.mIsSelectingDefaultActivity)
        {
          if (!ActivityChooserView.this.mAdapter.getShowDefaultActivity()) {
            paramInt++;
          }
          Intent localIntent = ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(paramInt);
          if (localIntent != null) {
            ActivityChooserView.this.mContext.startActivity(localIntent);
          }
        }
        else if (paramInt > 0)
        {
          ActivityChooserView.this.mAdapter.getDataModel().setDefaultActivity(paramInt);
        }
        break;
      case 1: 
        ActivityChooserView.this.showPopupUnchecked(2147483647);
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (paramView != ActivityChooserView.this.mDefaultActivityButton) {
        throw new IllegalArgumentException();
      }
      if (ActivityChooserView.this.mAdapter.getCount() > 0)
      {
        ActivityChooserView.access$602(ActivityChooserView.this, true);
        ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
      }
      return true;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */
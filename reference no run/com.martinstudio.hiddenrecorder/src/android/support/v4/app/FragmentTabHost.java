package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private boolean mAttached;
  private int mContainerId;
  private Context mContext;
  private FragmentManager mFragmentManager;
  private TabInfo mLastTab;
  private TabHost.OnTabChangeListener mOnTabChangeListener;
  private FrameLayout mRealTabContent;
  private final ArrayList<TabInfo> mTabs = new ArrayList();
  
  public FragmentTabHost(Context paramContext)
  {
    super(paramContext, null);
    initFragmentTabHost(paramContext, null);
  }
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initFragmentTabHost(paramContext, paramAttributeSet);
  }
  
  private FragmentTransaction doTabChanged(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject = null;
    for (int i = 0;; i++)
    {
      if (i >= this.mTabs.size())
      {
        if (localObject != null)
        {
          if (this.mLastTab != localObject)
          {
            if (paramFragmentTransaction == null) {
              paramFragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            if ((this.mLastTab != null) && (this.mLastTab.fragment != null)) {
              paramFragmentTransaction.detach(this.mLastTab.fragment);
            }
            if (localObject != null) {
              if (((TabInfo)localObject).fragment != null)
              {
                paramFragmentTransaction.attach(((TabInfo)localObject).fragment);
              }
              else
              {
                TabInfo.access$102((TabInfo)localObject, Fragment.instantiate(this.mContext, ((TabInfo)localObject).clss.getName(), ((TabInfo)localObject).args));
                paramFragmentTransaction.add(this.mContainerId, ((TabInfo)localObject).fragment, ((TabInfo)localObject).tag);
              }
            }
            this.mLastTab = ((TabInfo)localObject);
          }
          return paramFragmentTransaction;
        }
        throw new IllegalStateException("No tab known for tag " + paramString);
      }
      TabInfo localTabInfo = (TabInfo)this.mTabs.get(i);
      if (localTabInfo.tag.equals(paramString)) {
        localObject = localTabInfo;
      }
    }
  }
  
  private void ensureContent()
  {
    if (this.mRealTabContent == null)
    {
      this.mRealTabContent = ((FrameLayout)findViewById(this.mContainerId));
      if (this.mRealTabContent == null) {}
    }
    else
    {
      return;
    }
    throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
  }
  
  private void ensureHierarchy(Context paramContext)
  {
    if (findViewById(16908307) == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      Object localObject = new TabWidget(paramContext);
      ((TabWidget)localObject).setId(16908307);
      ((TabWidget)localObject).setOrientation(0);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 0.0F));
      localObject = new FrameLayout(paramContext);
      ((FrameLayout)localObject).setId(16908305);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(0, 0, 0.0F));
      localObject = new FrameLayout(paramContext);
      this.mRealTabContent = ((FrameLayout)localObject);
      this.mRealTabContent.setId(this.mContainerId);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, 0, 1.0F));
    }
  }
  
  private void initFragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = new int[1];
    localObject[0] = 16842995;
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, 0);
    this.mContainerId = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    super.setOnTabChangedListener(this);
  }
  
  public void addTab(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle)
  {
    paramTabSpec.setContent(new DummyTabFactory(this.mContext));
    Object localObject = paramTabSpec.getTag();
    TabInfo localTabInfo = new TabInfo((String)localObject, paramClass, paramBundle);
    if (this.mAttached)
    {
      TabInfo.access$102(localTabInfo, this.mFragmentManager.findFragmentByTag((String)localObject));
      if ((localTabInfo.fragment != null) && (!localTabInfo.fragment.isDetached()))
      {
        localObject = this.mFragmentManager.beginTransaction();
        ((FragmentTransaction)localObject).detach(localTabInfo.fragment);
        ((FragmentTransaction)localObject).commit();
      }
    }
    this.mTabs.add(localTabInfo);
    addTab(paramTabSpec);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getCurrentTabTag();
    FragmentTransaction localFragmentTransaction = null;
    for (int i = 0;; i++)
    {
      if (i >= this.mTabs.size())
      {
        this.mAttached = true;
        localObject = doTabChanged((String)localObject, localFragmentTransaction);
        if (localObject != null)
        {
          ((FragmentTransaction)localObject).commit();
          this.mFragmentManager.executePendingTransactions();
        }
        return;
      }
      TabInfo localTabInfo = (TabInfo)this.mTabs.get(i);
      TabInfo.access$102(localTabInfo, this.mFragmentManager.findFragmentByTag(localTabInfo.tag));
      if ((localTabInfo.fragment != null) && (!localTabInfo.fragment.isDetached())) {
        if (!localTabInfo.tag.equals(localObject))
        {
          if (localFragmentTransaction == null) {
            localFragmentTransaction = this.mFragmentManager.beginTransaction();
          }
          localFragmentTransaction.detach(localTabInfo.fragment);
        }
        else
        {
          this.mLastTab = localTabInfo;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setCurrentTabByTag(localSavedState.curTab);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.curTab = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.mAttached)
    {
      FragmentTransaction localFragmentTransaction = doTabChanged(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.mOnTabChangeListener != null) {
      this.mOnTabChangeListener.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.mOnTabChangeListener = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  public void setup(Context paramContext, FragmentManager paramFragmentManager)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    ensureContent();
  }
  
  public void setup(Context paramContext, FragmentManager paramFragmentManager, int paramInt)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    this.mContainerId = paramInt;
    ensureContent();
    this.mRealTabContent.setId(paramInt);
    if (getId() == -1) {
      setId(16908306);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public FragmentTabHost.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FragmentTabHost.SavedState(paramAnonymousParcel, null);
      }
      
      public FragmentTabHost.SavedState[] newArray(int paramAnonymousInt)
      {
        return new FragmentTabHost.SavedState[paramAnonymousInt];
      }
    };
    String curTab;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.curTab = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.curTab);
    }
  }
  
  static class DummyTabFactory
    implements TabHost.TabContentFactory
  {
    private final Context mContext;
    
    public DummyTabFactory(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public View createTabContent(String paramString)
    {
      View localView = new View(this.mContext);
      localView.setMinimumWidth(0);
      localView.setMinimumHeight(0);
      return localView;
    }
  }
  
  static final class TabInfo
  {
    private final Bundle args;
    private final Class<?> clss;
    private Fragment fragment;
    private final String tag;
    
    TabInfo(String paramString, Class<?> paramClass, Bundle paramBundle)
    {
      this.tag = paramString;
      this.clss = paramClass;
      this.args = paramBundle;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment
  extends Fragment
{
  static final int INTERNAL_EMPTY_ID = 16711681;
  static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
  static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
  ListAdapter mAdapter;
  CharSequence mEmptyText;
  View mEmptyView;
  private final Handler mHandler = new Handler();
  ListView mList;
  View mListContainer;
  boolean mListShown;
  private final AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      ListFragment.this.onListItemClick((ListView)paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
    }
  };
  View mProgressContainer;
  private final Runnable mRequestFocus = new Runnable()
  {
    public void run()
    {
      ListFragment.this.mList.focusableViewAvailable(ListFragment.this.mList);
    }
  };
  TextView mStandardEmptyView;
  
  private void ensureList()
  {
    if (this.mList == null)
    {
      Object localObject = getView();
      if (localObject != null)
      {
        if (!(localObject instanceof ListView))
        {
          this.mStandardEmptyView = ((TextView)((View)localObject).findViewById(16711681));
          if (this.mStandardEmptyView != null) {
            this.mStandardEmptyView.setVisibility(8);
          } else {
            this.mEmptyView = ((View)localObject).findViewById(16908292);
          }
          this.mProgressContainer = ((View)localObject).findViewById(16711682);
          this.mListContainer = ((View)localObject).findViewById(16711683);
          localObject = ((View)localObject).findViewById(16908298);
          if ((localObject instanceof ListView))
          {
            this.mList = ((ListView)localObject);
            if (this.mEmptyView == null)
            {
              if (this.mEmptyText != null)
              {
                this.mStandardEmptyView.setText(this.mEmptyText);
                this.mList.setEmptyView(this.mStandardEmptyView);
              }
            }
            else {
              this.mList.setEmptyView(this.mEmptyView);
            }
          }
          else
          {
            if (localObject != null) {
              throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
            }
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          }
        }
        else
        {
          this.mList = ((ListView)localObject);
        }
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        if (this.mAdapter == null)
        {
          if (this.mProgressContainer != null) {
            setListShown(false, false);
          }
        }
        else
        {
          localObject = this.mAdapter;
          this.mAdapter = null;
          setListAdapter((ListAdapter)localObject);
        }
        this.mHandler.post(this.mRequestFocus);
      }
    }
    else
    {
      return;
    }
    throw new IllegalStateException("Content view not yet created");
  }
  
  private void setListShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureList();
    if (this.mProgressContainer != null)
    {
      if (this.mListShown != paramBoolean1)
      {
        this.mListShown = paramBoolean1;
        if (!paramBoolean1)
        {
          if (!paramBoolean2)
          {
            this.mProgressContainer.clearAnimation();
            this.mListContainer.clearAnimation();
          }
          else
          {
            this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
            this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
          }
          this.mProgressContainer.setVisibility(0);
          this.mListContainer.setVisibility(8);
        }
        else
        {
          if (!paramBoolean2)
          {
            this.mProgressContainer.clearAnimation();
            this.mListContainer.clearAnimation();
          }
          else
          {
            this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
          }
          this.mProgressContainer.setVisibility(8);
          this.mListContainer.setVisibility(0);
        }
      }
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public ListAdapter getListAdapter()
  {
    return this.mAdapter;
  }
  
  public ListView getListView()
  {
    ensureList();
    return this.mList;
  }
  
  public long getSelectedItemId()
  {
    ensureList();
    return this.mList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    ensureList();
    return this.mList.getSelectedItemPosition();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject2 = getActivity();
    FrameLayout localFrameLayout = new FrameLayout((Context)localObject2);
    Object localObject1 = new LinearLayout((Context)localObject2);
    ((LinearLayout)localObject1).setId(16711682);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setVisibility(8);
    ((LinearLayout)localObject1).setGravity(17);
    ((LinearLayout)localObject1).addView(new ProgressBar((Context)localObject2, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    localObject1 = new FrameLayout((Context)localObject2);
    ((FrameLayout)localObject1).setId(16711683);
    localObject2 = new TextView(getActivity());
    ((TextView)localObject2).setId(16711681);
    ((TextView)localObject2).setGravity(17);
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
    localObject2 = new ListView(getActivity());
    ((ListView)localObject2).setId(16908298);
    ((ListView)localObject2).setDrawSelectorOnTop(false);
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  public void onDestroyView()
  {
    this.mHandler.removeCallbacks(this.mRequestFocus);
    this.mList = null;
    this.mListShown = false;
    this.mListContainer = null;
    this.mProgressContainer = null;
    this.mEmptyView = null;
    this.mStandardEmptyView = null;
    super.onDestroyView();
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ensureList();
  }
  
  public void setEmptyText(CharSequence paramCharSequence)
  {
    ensureList();
    if (this.mStandardEmptyView != null)
    {
      this.mStandardEmptyView.setText(paramCharSequence);
      if (this.mEmptyText == null) {
        this.mList.setEmptyView(this.mStandardEmptyView);
      }
      this.mEmptyText = paramCharSequence;
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    int i;
    if (this.mAdapter == null) {
      i = 0;
    } else {
      i = 1;
    }
    this.mAdapter = paramListAdapter;
    if (this.mList != null)
    {
      this.mList.setAdapter(paramListAdapter);
      if ((!this.mListShown) && (i == 0))
      {
        if (getView().getWindowToken() != null) {
          bool = true;
        }
        setListShown(true, bool);
      }
    }
  }
  
  public void setListShown(boolean paramBoolean)
  {
    setListShown(paramBoolean, true);
  }
  
  public void setListShownNoAnimation(boolean paramBoolean)
  {
    setListShown(paramBoolean, false);
  }
  
  public void setSelection(int paramInt)
  {
    ensureList();
    this.mList.setSelection(paramInt);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */
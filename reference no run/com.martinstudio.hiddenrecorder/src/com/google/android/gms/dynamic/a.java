package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a<T extends LifecycleDelegate>
{
  private T LU;
  private Bundle LV;
  private LinkedList<a> LW;
  private final f<T> LX = new f()
  {
    public void a(T paramAnonymousT)
    {
      a.a(a.this, paramAnonymousT);
      Iterator localIterator = a.a(a.this).iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          a.a(a.this).clear();
          a.a(a.this, null);
          return;
        }
        ((a.a)localIterator.next()).b(a.b(a.this));
      }
    }
  };
  
  private void a(Bundle paramBundle, a parama)
  {
    if (this.LU == null)
    {
      if (this.LW == null) {
        this.LW = new LinkedList();
      }
      this.LW.add(parama);
      if (paramBundle != null) {
        if (this.LV != null) {
          this.LV.putAll(paramBundle);
        } else {
          this.LV = ((Bundle)paramBundle.clone());
        }
      }
      a(this.LX);
    }
    else
    {
      parama.b(this.LU);
    }
  }
  
  public static void b(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    final int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(localContext);
    String str2 = GooglePlayServicesUtil.d(localContext, i);
    String str1 = GooglePlayServicesUtil.e(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    Object localObject = new TextView(paramFrameLayout.getContext());
    ((TextView)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    ((TextView)localObject).setText(str2);
    localLinearLayout.addView((View)localObject);
    if (str1 != null)
    {
      localObject = new Button(localContext);
      ((Button)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((Button)localObject).setText(str1);
      localLinearLayout.addView((View)localObject);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.this.startActivity(GooglePlayServicesUtil.c(a.this, i));
        }
      });
    }
  }
  
  private void ca(int paramInt)
  {
    for (;;)
    {
      if ((this.LW.isEmpty()) || (((a)this.LW.getLast()).getState() < paramInt)) {
        return;
      }
      this.LW.removeLast();
    }
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    b(paramFrameLayout);
  }
  
  protected abstract void a(f<T> paramf);
  
  public T gC()
  {
    return this.LU;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    a(paramBundle, new a()
    {
      public void b(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onCreate(paramBundle);
      }
      
      public int getState()
      {
        return 1;
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    a(paramBundle, new a()
    {
      public void b(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(a.b(a.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
      
      public int getState()
      {
        return 2;
      }
    });
    if (this.LU == null) {
      a(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.LU == null) {
      ca(1);
    } else {
      this.LU.onDestroy();
    }
  }
  
  public void onDestroyView()
  {
    if (this.LU == null) {
      ca(2);
    } else {
      this.LU.onDestroyView();
    }
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    a(paramBundle2, new a()
    {
      public void b(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
      
      public int getState()
      {
        return 0;
      }
    });
  }
  
  public void onLowMemory()
  {
    if (this.LU != null) {
      this.LU.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.LU == null) {
      ca(5);
    } else {
      this.LU.onPause();
    }
  }
  
  public void onResume()
  {
    a(null, new a()
    {
      public void b(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onResume();
      }
      
      public int getState()
      {
        return 5;
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.LU == null)
    {
      if (this.LV != null) {
        paramBundle.putAll(this.LV);
      }
    }
    else {
      this.LU.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    a(null, new a()
    {
      public void b(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onStart();
      }
      
      public int getState()
      {
        return 4;
      }
    });
  }
  
  public void onStop()
  {
    if (this.LU == null) {
      ca(4);
    } else {
      this.LU.onStop();
    }
  }
  
  private static abstract interface a
  {
    public abstract void b(LifecycleDelegate paramLifecycleDelegate);
    
    public abstract int getState();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.a
 * JD-Core Version:    0.7.0.1
 */
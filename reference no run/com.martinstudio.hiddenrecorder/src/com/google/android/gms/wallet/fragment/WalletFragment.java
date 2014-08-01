package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lm.a;
import com.google.android.gms.internal.lt;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private final Fragment Mg = this;
  private WalletFragmentOptions akh;
  private WalletFragmentInitParams aki;
  private MaskedWalletRequest akj;
  private MaskedWallet akk;
  private Boolean akl;
  private b akq;
  private final b akr = b.a(this);
  private final c aks = new c(null);
  private a akt = new a(this);
  private boolean mCreated = false;
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.Mg.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    int i;
    if (this.akq == null) {
      i = 0;
    } else {
      i = b.a(this.akq);
    }
    return i;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.akq == null)
    {
      if (this.aki != null)
      {
        Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
      }
      else
      {
        this.aki = paramWalletFragmentInitParams;
        if (this.akj != null) {
          Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
        }
        if (this.akk != null) {
          Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
        }
      }
    }
    else
    {
      b.a(this.akq, paramWalletFragmentInitParams);
      this.aki = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.akq != null) {
      b.a(this.akq, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    if (paramBundle == null)
    {
      if (this.Mg.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.Mg.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).N(this.Mg.getActivity());
          this.akh = ((WalletFragmentOptions)localObject);
        }
      }
    }
    else
    {
      paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      localObject = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
      if (localObject != null)
      {
        if (this.aki != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.aki = ((WalletFragmentInitParams)localObject);
      }
      if (this.akj == null) {
        this.akj = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.akk == null) {
        this.akk = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.akh = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.akl = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    this.mCreated = true;
    this.aks.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aks.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.akh == null) {
      this.akh = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("attrKeyWalletFragmentOptions", this.akh);
    this.aks.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.aks.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.aks.onResume();
    FragmentManager localFragmentManager = this.Mg.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mg.getActivity()), this.Mg.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.aks.onSaveInstanceState(paramBundle);
    if (this.aki != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.aki);
      this.aki = null;
    }
    if (this.akj != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.akj);
      this.akj = null;
    }
    if (this.akk != null)
    {
      paramBundle.putParcelable("maskedWallet", this.akk);
      this.akk = null;
    }
    if (this.akh != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.akh);
      this.akh = null;
    }
    if (this.akl != null)
    {
      paramBundle.putBoolean("enabled", this.akl.booleanValue());
      this.akl = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.aks.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.aks.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.akq == null)
    {
      this.akl = Boolean.valueOf(paramBoolean);
    }
    else
    {
      b.a(this.akq, paramBoolean);
      this.akl = null;
    }
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.akt.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.akq == null)
    {
      this.akk = paramMaskedWallet;
    }
    else
    {
      b.a(this.akq, paramMaskedWallet);
      this.akk = null;
    }
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.akq == null)
    {
      this.akj = paramMaskedWalletRequest;
    }
    else
    {
      b.a(this.akq, paramMaskedWalletRequest);
      this.akj = null;
    }
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(WalletFragment paramWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends lm.a
  {
    private WalletFragment.OnStateChangedListener aku;
    private final WalletFragment akv;
    
    a(WalletFragment paramWalletFragment)
    {
      this.akv = paramWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.aku != null) {
        this.aku.onStateChanged(this.akv, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.aku = paramOnStateChangedListener;
    }
  }
  
  private static class b
    implements LifecycleDelegate
  {
    private final ll ako;
    
    private b(ll paramll)
    {
      this.ako = paramll;
    }
    
    private int getState()
    {
      try
      {
        int i = this.ako.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.ako.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.ako.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.ako.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.ako.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.ako.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.ako.onCreate(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        View localView = (View)e.e(this.ako.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle));
        return localView;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onDestroy() {}
    
    public void onDestroyView() {}
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      WalletFragmentOptions localWalletFragmentOptions = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
      try
      {
        this.ako.a(e.h(paramActivity), localWalletFragmentOptions, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onLowMemory() {}
    
    public void onPause()
    {
      try
      {
        this.ako.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.ako.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.ako.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStart()
    {
      try
      {
        this.ako.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStop()
    {
      try
      {
        this.ako.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class c
    extends a<WalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(WalletFragment.a(WalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int j = -1;
      int i = -2;
      if (WalletFragment.e(WalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = WalletFragment.e(WalletFragment.this).getFragmentStyle();
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = WalletFragment.a(WalletFragment.this).getResources().getDisplayMetrics();
          j = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, j);
          i = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, i);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(j, i));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<WalletFragment.b> paramf)
    {
      Object localObject = WalletFragment.a(WalletFragment.this).getActivity();
      if ((WalletFragment.b(WalletFragment.this) == null) && (WalletFragment.c(WalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = lt.a((Activity)localObject, WalletFragment.d(WalletFragment.this), WalletFragment.e(WalletFragment.this), WalletFragment.f(WalletFragment.this));
        WalletFragment.a(WalletFragment.this, new WalletFragment.b((ll)localObject, null));
        WalletFragment.a(WalletFragment.this, null);
        paramf.a(WalletFragment.b(WalletFragment.this));
        if (WalletFragment.g(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.g(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.h(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.h(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.i(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.i(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.j(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.j(WalletFragment.this).booleanValue());
          WalletFragment.a(WalletFragment.this, null);
        }
        label247:
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        break label247;
      }
    }
    
    public void onClick(View paramView)
    {
      Activity localActivity = WalletFragment.a(WalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(localActivity), localActivity, -1);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragment
 * JD-Core Version:    0.7.0.1
 */
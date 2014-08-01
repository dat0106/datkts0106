package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.dynamic.h;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lm.a;
import com.google.android.gms.internal.lt;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment
  extends Fragment
{
  private final Fragment FS = this;
  private b akd;
  private final h ake = h.a(this);
  private final c akf = new c(null);
  private a akg = new a(this);
  private WalletFragmentOptions akh;
  private WalletFragmentInitParams aki;
  private MaskedWalletRequest akj;
  private MaskedWallet akk;
  private Boolean akl;
  private boolean mCreated = false;
  
  public static SupportWalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    SupportWalletFragment localSupportWalletFragment = new SupportWalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localSupportWalletFragment.FS.setArguments(localBundle);
    return localSupportWalletFragment;
  }
  
  public int getState()
  {
    int i;
    if (this.akd == null) {
      i = 0;
    } else {
      i = b.a(this.akd);
    }
    return i;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.akd == null)
    {
      if (this.aki != null)
      {
        Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
      }
      else
      {
        this.aki = paramWalletFragmentInitParams;
        if (this.akj != null) {
          Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
        }
        if (this.akk != null) {
          Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
        }
      }
    }
    else
    {
      b.a(this.akd, paramWalletFragmentInitParams);
      this.aki = null;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.akd != null) {
      b.a(this.akd, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    if (paramBundle == null)
    {
      if (this.FS.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.FS.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).N(this.FS.getActivity());
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
          Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
    this.akf.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.akf.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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
    this.akf.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.akf.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.akf.onResume();
    FragmentManager localFragmentManager = this.FS.getActivity().getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.FS.getActivity()), this.FS.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.akf.onSaveInstanceState(paramBundle);
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
    this.akf.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.akf.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.akd == null)
    {
      this.akl = Boolean.valueOf(paramBoolean);
    }
    else
    {
      b.a(this.akd, paramBoolean);
      this.akl = null;
    }
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.akg.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.akd == null)
    {
      this.akk = paramMaskedWallet;
    }
    else
    {
      b.a(this.akd, paramMaskedWallet);
      this.akk = null;
    }
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.akd == null)
    {
      this.akj = paramMaskedWalletRequest;
    }
    else
    {
      b.a(this.akd, paramMaskedWalletRequest);
      this.akj = null;
    }
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(SupportWalletFragment paramSupportWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends lm.a
  {
    private SupportWalletFragment.OnStateChangedListener akm;
    private final SupportWalletFragment akn;
    
    a(SupportWalletFragment paramSupportWalletFragment)
    {
      this.akn = paramSupportWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.akm != null) {
        this.akm.onStateChanged(this.akn, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.akm = paramOnStateChangedListener;
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
    extends a<SupportWalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(SupportWalletFragment.a(SupportWalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int i = -1;
      int j = -2;
      if (SupportWalletFragment.e(SupportWalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.e(SupportWalletFragment.this).getFragmentStyle();
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = SupportWalletFragment.a(SupportWalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, i);
          j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, j);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<SupportWalletFragment.b> paramf)
    {
      Object localObject = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      if ((SupportWalletFragment.b(SupportWalletFragment.this) == null) && (SupportWalletFragment.c(SupportWalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = lt.a((Activity)localObject, SupportWalletFragment.d(SupportWalletFragment.this), SupportWalletFragment.e(SupportWalletFragment.this), SupportWalletFragment.f(SupportWalletFragment.this));
        SupportWalletFragment.a(SupportWalletFragment.this, new SupportWalletFragment.b((ll)localObject, null));
        SupportWalletFragment.a(SupportWalletFragment.this, null);
        paramf.a(SupportWalletFragment.b(SupportWalletFragment.this));
        if (SupportWalletFragment.g(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.g(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.h(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.h(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.i(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.i(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.j(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.j(SupportWalletFragment.this).booleanValue());
          SupportWalletFragment.a(SupportWalletFragment.this, null);
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
      FragmentActivity localFragmentActivity = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(localFragmentActivity), localFragmentActivity, -1);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.SupportWalletFragment
 * JD-Core Version:    0.7.0.1
 */
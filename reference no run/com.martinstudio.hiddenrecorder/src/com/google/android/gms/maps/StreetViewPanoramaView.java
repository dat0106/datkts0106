package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama ZQ;
  private final a ZZ;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.ZZ = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ZZ = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ZZ = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.ZZ = new a(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  public final StreetViewPanorama getStreetViewPanorama()
  {
    StreetViewPanorama localStreetViewPanorama;
    if (this.ZQ != null) {
      localStreetViewPanorama = this.ZQ;
    }
    for (;;)
    {
      return localStreetViewPanorama;
      this.ZZ.ju();
      if (this.ZZ.gC() == null)
      {
        localStreetViewPanorama = null;
        continue;
      }
      try
      {
        this.ZQ = new StreetViewPanorama(((b)this.ZZ.gC()).jB().getStreetViewPanorama());
        localStreetViewPanorama = this.ZQ;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.ZZ.onCreate(paramBundle);
    if (this.ZZ.gC() == null) {
      a.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.ZZ.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.ZZ.onLowMemory();
  }
  
  public final void onPause()
  {
    this.ZZ.onPause();
  }
  
  public final void onResume()
  {
    this.ZZ.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.ZZ.onSaveInstanceState(paramBundle);
  }
  
  static class a
    extends a<StreetViewPanoramaView.b>
  {
    protected f<StreetViewPanoramaView.b> ZC;
    private final ViewGroup ZH;
    private final StreetViewPanoramaOptions aaa;
    private final Context mContext;
    
    a(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.ZH = paramViewGroup;
      this.mContext = paramContext;
      this.aaa = paramStreetViewPanoramaOptions;
    }
    
    protected void a(f<StreetViewPanoramaView.b> paramf)
    {
      this.ZC = paramf;
      ju();
    }
    
    public void ju()
    {
      if ((this.ZC != null) && (gC() == null)) {}
      try
      {
        IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = u.E(this.mContext).a(e.h(this.mContext), this.aaa);
        this.ZC.a(new StreetViewPanoramaView.b(this.ZH, localIStreetViewPanoramaViewDelegate));
        label59:
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        break label59;
      }
    }
  }
  
  static class b
    implements LifecycleDelegate
  {
    private final ViewGroup ZE;
    private final IStreetViewPanoramaViewDelegate aab;
    private View aac;
    
    public b(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.aab = ((IStreetViewPanoramaViewDelegate)hn.f(paramIStreetViewPanoramaViewDelegate));
      this.ZE = ((ViewGroup)hn.f(paramViewGroup));
    }
    
    public IStreetViewPanoramaViewDelegate jB()
    {
      return this.aab;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.aab.onCreate(paramBundle);
        this.aac = ((View)e.e(this.aab.getView()));
        this.ZE.removeAllViews();
        this.ZE.addView(this.aac);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.aab.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.aab.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.aab.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.aab.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.aab.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaView
 * JD-Core Version:    0.7.0.1
 */
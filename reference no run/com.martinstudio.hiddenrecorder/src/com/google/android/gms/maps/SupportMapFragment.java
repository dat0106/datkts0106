package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment
  extends Fragment
{
  private GoogleMap ZA;
  private final b aad = new b(this);
  
  public static SupportMapFragment newInstance()
  {
    return new SupportMapFragment();
  }
  
  public static SupportMapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localSupportMapFragment.setArguments(localBundle);
    return localSupportMapFragment;
  }
  
  public final GoogleMap getMap()
  {
    GoogleMap localGoogleMap = null;
    Object localObject = jt();
    if (localObject == null) {}
    for (;;)
    {
      return localGoogleMap;
      try
      {
        localObject = ((IMapFragmentDelegate)localObject).getMap();
        if (localObject == null) {
          continue;
        }
        if ((this.ZA == null) || (this.ZA.jk().asBinder() != ((IGoogleMapDelegate)localObject).asBinder())) {
          this.ZA = new GoogleMap((IGoogleMapDelegate)localObject);
        }
        localGoogleMap = this.ZA;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  protected IMapFragmentDelegate jt()
  {
    this.aad.ju();
    IMapFragmentDelegate localIMapFragmentDelegate;
    if (this.aad.gC() != null) {
      localIMapFragmentDelegate = ((a)this.aad.gC()).jt();
    } else {
      localIMapFragmentDelegate = null;
    }
    return localIMapFragmentDelegate;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.aad, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aad.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aad.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.aad.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.aad.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.aad, paramActivity);
    GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", localGoogleMapOptions);
    this.aad.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.aad.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.aad.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.aad.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.aad.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  static class b
    extends a<SupportMapFragment.a>
  {
    private final Fragment FS;
    protected f<SupportMapFragment.a> ZC;
    private Activity oe;
    
    b(Fragment paramFragment)
    {
      this.FS = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.oe = paramActivity;
      ju();
    }
    
    protected void a(f<SupportMapFragment.a> paramf)
    {
      this.ZC = paramf;
      ju();
    }
    
    public void ju()
    {
      if ((this.oe != null) && (this.ZC != null) && (gC() == null)) {}
      try
      {
        MapsInitializer.initialize(this.oe);
        IMapFragmentDelegate localIMapFragmentDelegate = u.E(this.oe).i(e.h(this.oe));
        this.ZC.a(new SupportMapFragment.a(this.FS, localIMapFragmentDelegate));
        label70:
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        break label70;
      }
    }
  }
  
  static class a
    implements LifecycleDelegate
  {
    private final Fragment FS;
    private final IMapFragmentDelegate ZB;
    
    public a(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.ZB = ((IMapFragmentDelegate)hn.f(paramIMapFragmentDelegate));
      this.FS = ((Fragment)hn.f(paramFragment));
    }
    
    public IMapFragmentDelegate jt()
    {
      return this.ZB;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      if (paramBundle == null) {}
      try
      {
        paramBundle = new Bundle();
        Bundle localBundle = this.FS.getArguments();
        if ((localBundle != null) && (localBundle.containsKey("MapOptions"))) {
          t.a(paramBundle, "MapOptions", localBundle.getParcelable("MapOptions"));
        }
        this.ZB.onCreate(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        d locald = this.ZB.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle);
        return (View)e.e(locald);
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        this.ZB.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      try
      {
        this.ZB.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      GoogleMapOptions localGoogleMapOptions = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        this.ZB.onInflate(e.h(paramActivity), localGoogleMapOptions, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onLowMemory()
    {
      try
      {
        this.ZB.onLowMemory();
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
        this.ZB.onPause();
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
        this.ZB.onResume();
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
        this.ZB.onSaveInstanceState(paramBundle);
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
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment
 * JD-Core Version:    0.7.0.1
 */
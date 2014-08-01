package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

public class MapFragment
  extends Fragment
{
  private GoogleMap ZA;
  private final b Zz = new b(this);
  
  public static MapFragment newInstance()
  {
    return new MapFragment();
  }
  
  public static MapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    MapFragment localMapFragment = new MapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localMapFragment.setArguments(localBundle);
    return localMapFragment;
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
    this.Zz.ju();
    IMapFragmentDelegate localIMapFragmentDelegate;
    if (this.Zz.gC() != null) {
      localIMapFragmentDelegate = ((a)this.Zz.gC()).jt();
    } else {
      localIMapFragmentDelegate = null;
    }
    return localIMapFragmentDelegate;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.Zz, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Zz.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.Zz.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.Zz.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.Zz.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.Zz, paramActivity);
    GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", localGoogleMapOptions);
    this.Zz.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.Zz.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.Zz.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.Zz.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.Zz.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  static class b
    extends a<MapFragment.a>
  {
    private final Fragment Mg;
    protected f<MapFragment.a> ZC;
    private Activity oe;
    
    b(Fragment paramFragment)
    {
      this.Mg = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.oe = paramActivity;
      ju();
    }
    
    protected void a(f<MapFragment.a> paramf)
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
        this.ZC.a(new MapFragment.a(this.Mg, localIMapFragmentDelegate));
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
    private final Fragment Mg;
    private final IMapFragmentDelegate ZB;
    
    public a(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.ZB = ((IMapFragmentDelegate)hn.f(paramIMapFragmentDelegate));
      this.Mg = ((Fragment)hn.f(paramFragment));
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
        Bundle localBundle = this.Mg.getArguments();
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
 * Qualified Name:     com.google.android.gms.maps.MapFragment
 * JD-Core Version:    0.7.0.1
 */
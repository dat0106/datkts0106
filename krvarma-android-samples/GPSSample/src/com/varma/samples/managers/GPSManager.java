package com.varma.samples.managers;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.varma.samples.interfaces.GPSCallback;

public class GPSManager
{
	private static final int gpsMinTime = 500;
	private static final int gpsMinDistance = 0;
	
	private LocationManager locationManager = null;
	private LocationListener locationListener = null;
	private GPSCallback gpsCallback = null;
	
	public GPSManager()
	{
		locationListener = new LocationListener()
		{
			public void onProviderDisabled(final String provider)
			{
			}
			
			public void onProviderEnabled(final String provider)
			{
			}
			
			public void onStatusChanged(final String provider, final int status, final Bundle extras)
			{
			}
			
			public void onLocationChanged(final Location location)
			{
				if (location != null && gpsCallback != null)
				{
					gpsCallback.onGPSUpdate(location);
				}
			}
		};
	}
	
	public void startListening(final Activity activity)
	{
		if (locationManager == null)
		{
			locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
		}
		
		final Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		
		final String bestProvider = locationManager.getBestProvider(criteria, true);
		
		if (bestProvider != null && bestProvider.length() > 0)
		{
			locationManager.requestLocationUpdates(bestProvider, GPSManager.gpsMinTime,
					GPSManager.gpsMinDistance, locationListener);
		}
		else
		{
			final List<String> providers = locationManager.getProviders(true);
			
			for (final String provider : providers)
			{
				locationManager.requestLocationUpdates(provider, GPSManager.gpsMinTime,
						GPSManager.gpsMinDistance, locationListener);
			}
		}
	}
	
	public void stopListening()
	{
		try
		{
			if (locationManager != null && locationListener != null)
			{
				locationManager.removeUpdates(locationListener);
			}
			
			locationManager = null;
		}
		catch (final Exception ex)
		{
			
		}
	}
	
	public void setGPSCallback(final GPSCallback gpsCallback)
	{
		this.gpsCallback = gpsCallback;
	}
	
	public GPSCallback getGPSCallback()
	{
		return gpsCallback;
	}
}

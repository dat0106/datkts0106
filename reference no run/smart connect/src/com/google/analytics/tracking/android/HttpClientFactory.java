package com.google.analytics.tracking.android;

import org.apache.http.client.HttpClient;

abstract interface HttpClientFactory
{
  public abstract HttpClient newInstance();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.HttpClientFactory
 * JD-Core Version:    0.7.0.1
 */
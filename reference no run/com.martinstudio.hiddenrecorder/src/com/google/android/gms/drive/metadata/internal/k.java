package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class k
  extends b<String>
{
  public k(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public static final Collection<String> aO(String paramString)
    throws JSONException
  {
    if (paramString != null)
    {
      localObject = new ArrayList();
      JSONArray localJSONArray = new JSONArray(paramString);
      for (int i = 0;; i++)
      {
        if (i >= localJSONArray.length())
        {
          localObject = Collections.unmodifiableCollection((Collection)localObject);
          break;
        }
        ((Collection)localObject).add(localJSONArray.getString(i));
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  protected void a(Bundle paramBundle, Collection<String> paramCollection)
  {
    paramBundle.putStringArrayList(getName(), new ArrayList(paramCollection));
  }
  
  protected Collection<String> c(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    try
    {
      Collection localCollection = aO(paramDataHolder.c(getName(), paramInt1, paramInt2));
      return localCollection;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException("DataHolder supplied invalid JSON", localJSONException);
    }
  }
  
  protected Collection<String> k(Bundle paramBundle)
  {
    return paramBundle.getStringArrayList(getName());
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.k
 * JD-Core Version:    0.7.0.1
 */
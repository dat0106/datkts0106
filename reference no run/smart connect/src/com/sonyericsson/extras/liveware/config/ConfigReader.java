package com.sonyericsson.extras.liveware.config;

import android.content.Context;
import android.content.res.Resources;
import com.sonyericsson.extras.liveware.experience.Experience;
import java.util.ArrayList;

public class ConfigReader
{
  private ArrayList<Experience> readPreConfiguredExperinces(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject : paramContext.getResources().getStringArray(paramInt))
    {
      localObject = new ExperienceParser(paramContext).parse((String)localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> readPreConfiguredDevices(Context paramContext)
  {
    try
    {
      ArrayList localArrayList = readPreConfiguredExperinces(paramContext, 2131165185);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> readPreConfiguredExperinces(Context paramContext)
  {
    try
    {
      ArrayList localArrayList = readPreConfiguredExperinces(paramContext, 2131165186);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.config.ConfigReader
 * JD-Core Version:    0.7.0.1
 */
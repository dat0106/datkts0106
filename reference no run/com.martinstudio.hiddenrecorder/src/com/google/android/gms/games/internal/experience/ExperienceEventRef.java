package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class ExperienceEventRef
  extends d
  implements ExperienceEvent
{
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.experience.ExperienceEventRef
 * JD-Core Version:    0.7.0.1
 */
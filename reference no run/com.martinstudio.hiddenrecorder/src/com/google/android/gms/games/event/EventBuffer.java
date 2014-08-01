package com.google.android.gms.games.event;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class EventBuffer
  extends DataBuffer<Event>
{
  public EventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Event get(int paramInt)
  {
    return new EventRef(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.EventBuffer
 * JD-Core Version:    0.7.0.1
 */
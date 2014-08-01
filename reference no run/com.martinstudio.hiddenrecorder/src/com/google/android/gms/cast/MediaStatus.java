package com.google.android.gms.cast;

import com.google.android.gms.internal.gj;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus
{
  public static final long COMMAND_PAUSE = 1L;
  public static final long COMMAND_SEEK = 2L;
  public static final long COMMAND_SET_VOLUME = 4L;
  public static final long COMMAND_SKIP_BACKWARD = 32L;
  public static final long COMMAND_SKIP_FORWARD = 16L;
  public static final long COMMAND_TOGGLE_MUTE = 8L;
  public static final int IDLE_REASON_CANCELED = 2;
  public static final int IDLE_REASON_ERROR = 4;
  public static final int IDLE_REASON_FINISHED = 1;
  public static final int IDLE_REASON_INTERRUPTED = 3;
  public static final int IDLE_REASON_NONE = 0;
  public static final int PLAYER_STATE_BUFFERING = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_PAUSED = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  public static final int PLAYER_STATE_UNKNOWN;
  private long AG;
  private double AH;
  private int AI;
  private int AJ;
  private long AK;
  private long AL;
  private double AM;
  private boolean AN;
  private long[] AO;
  private JSONObject Ax;
  private MediaInfo Ay;
  
  public MediaStatus(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject, 0);
  }
  
  public int a(JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int n = 2;
    int m = 0;
    int j = 1;
    long l2 = paramJSONObject.getLong("mediaSessionId");
    int i;
    if (l2 == this.AG)
    {
      i = 0;
    }
    else
    {
      this.AG = l2;
      i = j;
    }
    if (paramJSONObject.has("playerState"))
    {
      String str1 = paramJSONObject.getString("playerState");
      int i1;
      if (!str1.equals("IDLE"))
      {
        if (!str1.equals("PLAYING"))
        {
          if (!str1.equals("PAUSED"))
          {
            if (!str1.equals("BUFFERING")) {
              i1 = 0;
            } else {
              i1 = 4;
            }
          }
          else {
            i1 = 3;
          }
        }
        else {
          i1 = n;
        }
      }
      else {
        i1 = j;
      }
      if (i1 != this.AI)
      {
        this.AI = i1;
        i |= 0x2;
      }
      if ((i1 == j) && (paramJSONObject.has("idleReason")))
      {
        String str2 = paramJSONObject.getString("idleReason");
        if (!str2.equals("CANCELLED")) {
          if (!str2.equals("INTERRUPTED"))
          {
            if (!str2.equals("FINISHED"))
            {
              if (!str2.equals("ERROR")) {
                n = 0;
              } else {
                n = 4;
              }
            }
            else {
              n = j;
            }
          }
          else {
            n = 3;
          }
        }
        if (n != this.AJ)
        {
          this.AJ = n;
          i |= 0x2;
        }
      }
    }
    if (paramJSONObject.has("playbackRate"))
    {
      double d1 = paramJSONObject.getDouble("playbackRate");
      if (this.AH != d1)
      {
        this.AH = d1;
        i |= 0x2;
      }
    }
    long l1;
    if ((paramJSONObject.has("currentTime")) && ((paramInt & 0x2) == 0))
    {
      l1 = gj.b(paramJSONObject.getDouble("currentTime"));
      if (l1 != this.AK)
      {
        this.AK = l1;
        i |= 0x2;
      }
    }
    if (paramJSONObject.has("supportedMediaCommands"))
    {
      l1 = paramJSONObject.getLong("supportedMediaCommands");
      if (l1 != this.AL)
      {
        this.AL = l1;
        i |= 0x2;
      }
    }
    Object localObject3;
    if ((paramJSONObject.has("volume")) && ((paramInt & 0x1) == 0))
    {
      localObject3 = paramJSONObject.getJSONObject("volume");
      double d2 = ((JSONObject)localObject3).getDouble("level");
      if (d2 != this.AM)
      {
        this.AM = d2;
        i |= 0x2;
      }
      boolean bool = ((JSONObject)localObject3).getBoolean("muted");
      if (bool != this.AN)
      {
        this.AN = bool;
        i |= 0x2;
      }
    }
    long[] arrayOfLong;
    if (!paramJSONObject.has("activeTrackIds"))
    {
      Object localObject1;
      if (this.AO == null)
      {
        localObject1 = null;
      }
      else
      {
        m = localObject1;
        localObject1 = null;
      }
    }
    else
    {
      localObject3 = paramJSONObject.getJSONArray("activeTrackIds");
      m = ((JSONArray)localObject3).length();
      arrayOfLong = new long[m];
    }
    for (int i2 = 0;; i2++)
    {
      if (i2 >= m)
      {
        if ((this.AO != null) && (this.AO.length == m)) {}
        for (i2 = 0;; i2++)
        {
          int k;
          if (i2 >= m) {
            k = 0;
          } else {
            if (this.AO[i2] == arrayOfLong[i2]) {
              continue;
            }
          }
          if (k != 0) {
            this.AO = arrayOfLong;
          }
          m = k;
          Object localObject2 = arrayOfLong;
          if (m != 0)
          {
            this.AO = ((long[])localObject2);
            i |= 0x2;
          }
          if (paramJSONObject.has("customData"))
          {
            this.Ax = paramJSONObject.getJSONObject("customData");
            i |= 0x2;
          }
          if (paramJSONObject.has("media"))
          {
            localObject2 = paramJSONObject.getJSONObject("media");
            this.Ay = new MediaInfo((JSONObject)localObject2);
            i |= 0x2;
            if (((JSONObject)localObject2).has("metadata")) {
              i |= 0x4;
            }
          }
          return i;
        }
      }
      arrayOfLong[i2] = ((JSONArray)localObject3).getLong(i2);
    }
  }
  
  public long dV()
  {
    return this.AG;
  }
  
  public long[] getActiveTrackIds()
  {
    return this.AO;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ax;
  }
  
  public int getIdleReason()
  {
    return this.AJ;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.Ay;
  }
  
  public double getPlaybackRate()
  {
    return this.AH;
  }
  
  public int getPlayerState()
  {
    return this.AI;
  }
  
  public long getStreamPosition()
  {
    return this.AK;
  }
  
  public double getStreamVolume()
  {
    return this.AM;
  }
  
  public boolean isMediaCommandSupported(long paramLong)
  {
    boolean bool;
    if ((paramLong & this.AL) == 0L) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isMute()
  {
    return this.AN;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaStatus
 * JD-Core Version:    0.7.0.1
 */
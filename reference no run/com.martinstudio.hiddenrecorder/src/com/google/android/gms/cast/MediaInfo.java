package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE;
  private final String Aq;
  private int Ar;
  private String As;
  private MediaMetadata At;
  private long Au;
  private List<MediaTrack> Av;
  private TextTrackStyle Aw;
  private JSONObject Ax;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.Aq = paramString;
      this.Ar = -1;
      return;
    }
    throw new IllegalArgumentException("content ID cannot be null or empty");
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.Aq = paramJSONObject.getString("contentId");
    Object localObject = paramJSONObject.getString("streamType");
    if (!"NONE".equals(localObject))
    {
      if (!"BUFFERED".equals(localObject))
      {
        if (!"LIVE".equals(localObject)) {
          this.Ar = -1;
        } else {
          this.Ar = 2;
        }
      }
      else {
        this.Ar = 1;
      }
    }
    else {
      this.Ar = 0;
    }
    this.As = paramJSONObject.getString("contentType");
    if (paramJSONObject.has("metadata"))
    {
      localObject = paramJSONObject.getJSONObject("metadata");
      this.At = new MediaMetadata(((JSONObject)localObject).getInt("metadataType"));
      this.At.b((JSONObject)localObject);
    }
    this.Au = gj.b(paramJSONObject.optDouble("duration", 0.0D));
    if (!paramJSONObject.has("tracks"))
    {
      this.Av = null;
    }
    else
    {
      this.Av = new ArrayList();
      localObject = paramJSONObject.getJSONArray("tracks");
    }
    for (;;)
    {
      JSONObject localJSONObject;
      if (i >= ((JSONArray)localObject).length())
      {
        if (!paramJSONObject.has("textTrackStyle"))
        {
          this.Aw = null;
        }
        else
        {
          localJSONObject = paramJSONObject.getJSONObject("textTrackStyle");
          localObject = new TextTrackStyle();
          ((TextTrackStyle)localObject).b(localJSONObject);
          this.Aw = ((TextTrackStyle)localObject);
        }
        this.Ax = paramJSONObject.optJSONObject("customData");
        return;
      }
      MediaTrack localMediaTrack = new MediaTrack(((JSONArray)localObject).getJSONObject(localJSONObject));
      this.Av.add(localMediaTrack);
      localJSONObject++;
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.At = paramMediaMetadata;
  }
  
  void b(List<MediaTrack> paramList)
  {
    this.Av = paramList;
  }
  
  void dT()
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(this.Aq))
    {
      if (!TextUtils.isEmpty(this.As))
      {
        if (this.Ar != -1) {
          return;
        }
        throw new IllegalArgumentException("a valid stream type must be specified");
      }
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    throw new IllegalArgumentException("content ID cannot be null or empty");
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.Aq);
        switch (this.Ar)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.As != null) {
            localJSONObject.put("contentType", this.As);
          }
          if (this.At != null) {
            localJSONObject.put("metadata", this.At.dU());
          }
          localJSONObject.put("duration", gj.o(this.Au));
          if (this.Av != null)
          {
            JSONArray localJSONArray = new JSONArray();
            localObject = this.Av.iterator();
            if (((Iterator)localObject).hasNext())
            {
              localJSONArray.put(((MediaTrack)((Iterator)localObject).next()).dU());
              continue;
            }
            localJSONObject.put("tracks", localJSONArray);
          }
          if (this.Aw != null) {
            localJSONObject.put("textTrackStyle", this.Aw.dU());
          }
          if (this.Ax == null) {
            break label216;
          }
          localJSONObject.put("customData", this.Ax);
        }
      }
      catch (JSONException localJSONException) {}
      Object localObject = "NONE";
      continue;
      label216:
      return localJSONObject;
      localObject = "BUFFERED";
      continue;
      localObject = "LIVE";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this != paramObject)
    {
      if ((paramObject instanceof MediaInfo))
      {
        MediaInfo localMediaInfo = (MediaInfo)paramObject;
        int j;
        if (this.Ax != null) {
          j = 0;
        } else {
          j = bool1;
        }
        int i;
        if (localMediaInfo.Ax != null) {
          i = 0;
        } else {
          i = bool1;
        }
        if ((j == i) && ((this.Ax == null) || (localMediaInfo.Ax == null) || (io.d(this.Ax, localMediaInfo.Ax))))
        {
          if ((!gj.a(this.Aq, localMediaInfo.Aq)) || (this.Ar != localMediaInfo.Ar) || (!gj.a(this.As, localMediaInfo.As)) || (!gj.a(this.At, localMediaInfo.At)) || (this.Au != localMediaInfo.Au)) {
            bool1 = false;
          }
          bool2 = bool1;
        }
      }
    }
    else {
      bool2 = bool1;
    }
    return bool2;
  }
  
  public String getContentId()
  {
    return this.Aq;
  }
  
  public String getContentType()
  {
    return this.As;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ax;
  }
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.Av;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.At;
  }
  
  public long getStreamDuration()
  {
    return this.Au;
  }
  
  public int getStreamType()
  {
    return this.Ar;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.Aw;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.Aq;
    arrayOfObject[1] = Integer.valueOf(this.Ar);
    arrayOfObject[2] = this.As;
    arrayOfObject[3] = this.At;
    arrayOfObject[4] = Long.valueOf(this.Au);
    arrayOfObject[5] = String.valueOf(this.Ax);
    return hl.hashCode(arrayOfObject);
  }
  
  void m(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong >= 0L)
    {
      this.Au = paramLong;
      return;
    }
    throw new IllegalArgumentException("Stream duration cannot be negative");
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.As = paramString;
      return;
    }
    throw new IllegalArgumentException("content type cannot be null or empty");
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt >= -1) && (paramInt <= 2))
    {
      this.Ar = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid stream type");
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.Aw = paramTextTrackStyle;
  }
  
  public static class Builder
  {
    private final MediaInfo Ay;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.Ay = new MediaInfo(paramString);
        return;
      }
      throw new IllegalArgumentException("Content ID cannot be empty");
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.Ay.dT();
      return this.Ay;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.Ay.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.Ay.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setMediaTracks(List<MediaTrack> paramList)
    {
      this.Ay.b(paramList);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.Ay.a(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.Ay.m(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.Ay.setStreamType(paramInt);
      return this;
    }
    
    public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
    {
      this.Ay.setTextTrackStyle(paramTextTrackStyle);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaInfo
 * JD-Core Version:    0.7.0.1
 */
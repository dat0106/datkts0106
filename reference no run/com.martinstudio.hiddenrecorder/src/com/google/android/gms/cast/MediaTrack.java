package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
  public static final int SUBTYPE_CAPTIONS = 2;
  public static final int SUBTYPE_CHAPTERS = 4;
  public static final int SUBTYPE_DESCRIPTIONS = 3;
  public static final int SUBTYPE_METADATA = 5;
  public static final int SUBTYPE_NONE = 0;
  public static final int SUBTYPE_SUBTITLES = 1;
  public static final int SUBTYPE_UNKNOWN = -1;
  public static final int TYPE_AUDIO = 2;
  public static final int TYPE_TEXT = 1;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_VIDEO = 3;
  private long AP;
  private int AQ;
  private int AR;
  private String Ao;
  private String Aq;
  private String As;
  private JSONObject Ax;
  private String mName;
  
  MediaTrack(long paramLong, int paramInt)
    throws IllegalArgumentException
  {
    clear();
    this.AP = paramLong;
    if ((paramInt > 0) && (paramInt <= 3))
    {
      this.AQ = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid type " + paramInt);
  }
  
  MediaTrack(JSONObject paramJSONObject)
    throws JSONException
  {
    b(paramJSONObject);
  }
  
  private void b(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.AP = paramJSONObject.getLong("trackId");
    String str = paramJSONObject.getString("type");
    if (!"TEXT".equals(str))
    {
      if (!"AUDIO".equals(str))
      {
        if (!"VIDEO".equals(str)) {
          throw new JSONException("invalid type: " + str);
        }
        this.AQ = 3;
      }
      else
      {
        this.AQ = 2;
      }
    }
    else {
      this.AQ = 1;
    }
    this.Aq = paramJSONObject.optString("trackContentId", null);
    this.As = paramJSONObject.optString("trackContentType", null);
    this.mName = paramJSONObject.optString("name", null);
    this.Ao = paramJSONObject.optString("language", null);
    if (!paramJSONObject.has("subtype"))
    {
      this.AR = 0;
    }
    else
    {
      str = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str))
      {
        if (!"CAPTIONS".equals(str))
        {
          if (!"DESCRIPTIONS".equals(str))
          {
            if (!"CHAPTERS".equals(str))
            {
              if (!"METADATA".equals(str)) {
                throw new JSONException("invalid subtype: " + str);
              }
              this.AR = 5;
            }
            else
            {
              this.AR = 4;
            }
          }
          else {
            this.AR = 3;
          }
        }
        else {
          this.AR = 2;
        }
      }
      else {
        this.AR = 1;
      }
    }
    this.Ax = paramJSONObject.optJSONObject("customData");
  }
  
  private void clear()
  {
    this.AP = 0L;
    this.AQ = 0;
    this.Aq = null;
    this.mName = null;
    this.Ao = null;
    this.AR = -1;
    this.Ax = null;
  }
  
  void R(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt > -1) && (paramInt <= 5))
    {
      if ((paramInt == 0) || (this.AQ == 1))
      {
        this.AR = paramInt;
        return;
      }
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    throw new IllegalArgumentException("invalid subtype " + paramInt);
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.AP);
      switch (this.AQ)
      {
      default: 
        if (this.Aq != null) {
          localJSONObject.put("trackContentId", this.Aq);
        }
        if (this.As != null) {
          localJSONObject.put("trackContentType", this.As);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.Ao)) {
          localJSONObject.put("language", this.Ao);
        }
        switch (this.AR)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.Ax == null) {
          break label277;
        }
        localJSONObject.put("customData", this.Ax);
        break label277;
        localJSONObject.put("type", "TEXT");
        break;
        localJSONObject.put("type", "AUDIO");
        break;
        localJSONObject.put("type", "VIDEO");
        break;
        localJSONObject.put("subtype", "SUBTITLES");
        continue;
        localJSONObject.put("subtype", "CAPTIONS");
        continue;
        localJSONObject.put("subtype", "DESCRIPTIONS");
        continue;
        localJSONObject.put("subtype", "CHAPTERS");
        continue;
        localJSONObject.put("subtype", "METADATA");
      }
    }
    catch (JSONException localJSONException)
    {
      label277:
      break label277;
    }
    return localJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (this != paramObject)
    {
      if ((paramObject instanceof MediaTrack))
      {
        MediaTrack localMediaTrack = (MediaTrack)paramObject;
        int j;
        if (this.Ax != null) {
          j = 0;
        } else {
          j = bool2;
        }
        int i;
        if (localMediaTrack.Ax != null) {
          i = 0;
        } else {
          i = bool2;
        }
        if ((j == i) && ((this.Ax == null) || (localMediaTrack.Ax == null) || (io.d(this.Ax, localMediaTrack.Ax))))
        {
          if ((this.AP != localMediaTrack.AP) || (this.AQ != localMediaTrack.AQ) || (!gj.a(this.Aq, localMediaTrack.Aq)) || (!gj.a(this.As, localMediaTrack.As)) || (!gj.a(this.mName, localMediaTrack.mName)) || (!gj.a(this.Ao, localMediaTrack.Ao)) || (this.AR != localMediaTrack.AR)) {
            bool2 = false;
          }
          bool1 = bool2;
        }
      }
    }
    else {
      bool1 = bool2;
    }
    return bool1;
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
  
  public long getId()
  {
    return this.AP;
  }
  
  public String getLanguage()
  {
    return this.Ao;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.AR;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = Long.valueOf(this.AP);
    arrayOfObject[1] = Integer.valueOf(this.AQ);
    arrayOfObject[2] = this.Aq;
    arrayOfObject[3] = this.As;
    arrayOfObject[4] = this.mName;
    arrayOfObject[5] = this.Ao;
    arrayOfObject[6] = Integer.valueOf(this.AR);
    arrayOfObject[7] = this.Ax;
    return hl.hashCode(arrayOfObject);
  }
  
  public void setContentId(String paramString)
  {
    this.Aq = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.As = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.Ao = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public static class Builder
  {
    private final MediaTrack AS;
    
    public Builder(long paramLong, int paramInt)
      throws IllegalArgumentException
    {
      this.AS = new MediaTrack(paramLong, paramInt);
    }
    
    public MediaTrack build()
    {
      return this.AS;
    }
    
    public Builder setContentId(String paramString)
    {
      this.AS.setContentId(paramString);
      return this;
    }
    
    public Builder setContentType(String paramString)
    {
      this.AS.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.AS.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setLanguage(String paramString)
    {
      this.AS.setLanguage(paramString);
      return this;
    }
    
    public Builder setLanguage(Locale paramLocale)
    {
      this.AS.setLanguage(gj.b(paramLocale));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.AS.setName(paramString);
      return this;
    }
    
    public Builder setSubtype(int paramInt)
      throws IllegalArgumentException
    {
      this.AS.R(paramInt);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaTrack
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.iq;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{
  public static final int COLOR_UNSPECIFIED = 0;
  public static final float DEFAULT_FONT_SCALE = 1.0F;
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int EDGE_TYPE_UNSPECIFIED = -1;
  public static final int FONT_FAMILY_CASUAL = 4;
  public static final int FONT_FAMILY_CURSIVE = 5;
  public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
  public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
  public static final int FONT_FAMILY_SANS_SERIF = 0;
  public static final int FONT_FAMILY_SERIF = 2;
  public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
  public static final int FONT_FAMILY_UNSPECIFIED = -1;
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_BOLD_ITALIC = 3;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  public static final int FONT_STYLE_UNSPECIFIED = -1;
  public static final int WINDOW_TYPE_NONE = 0;
  public static final int WINDOW_TYPE_NORMAL = 1;
  public static final int WINDOW_TYPE_ROUNDED = 2;
  public static final int WINDOW_TYPE_UNSPECIFIED = -1;
  private JSONObject Ax;
  private float Bp;
  private int Bq;
  private int Br;
  private int Bs;
  private int Bt;
  private int Bu;
  private int Bv;
  private String Bw;
  private int Bx;
  private int By;
  private int ta;
  
  public TextTrackStyle()
  {
    clear();
  }
  
  private int ah(String paramString)
  {
    int k = 0;
    if ((paramString != null) && (paramString.length() == 9) && (paramString.charAt(0) == '#')) {}
    try
    {
      int i = Integer.parseInt(paramString.substring(1, 3), 16);
      int j = Integer.parseInt(paramString.substring(3, 5), 16);
      int m = Integer.parseInt(paramString.substring(5, 7), 16);
      i = Color.argb(Integer.parseInt(paramString.substring(7, 9), 16), i, j, m);
      k = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label88:
      break label88;
    }
    return k;
  }
  
  private void clear()
  {
    this.Bp = 1.0F;
    this.Bq = 0;
    this.ta = 0;
    this.Br = -1;
    this.Bs = 0;
    this.Bt = -1;
    this.Bu = 0;
    this.Bv = 0;
    this.Bw = null;
    this.Bx = -1;
    this.By = -1;
    this.Ax = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (iq.gd())
    {
      Object localObject = (CaptioningManager)paramContext.getSystemService("captioning");
      localTextTrackStyle.setFontScale(((CaptioningManager)localObject).getFontScale());
      localObject = ((CaptioningManager)localObject).getUserStyle();
      localTextTrackStyle.setBackgroundColor(((CaptioningManager.CaptionStyle)localObject).backgroundColor);
      localTextTrackStyle.setForegroundColor(((CaptioningManager.CaptionStyle)localObject).foregroundColor);
      switch (((CaptioningManager.CaptionStyle)localObject).edgeType)
      {
      default: 
        localTextTrackStyle.setEdgeType(0);
        break;
      case 1: 
        localTextTrackStyle.setEdgeType(1);
        break;
      case 2: 
        localTextTrackStyle.setEdgeType(2);
      }
      localTextTrackStyle.setEdgeColor(((CaptioningManager.CaptionStyle)localObject).edgeColor);
      Typeface localTypeface = ((CaptioningManager.CaptionStyle)localObject).getTypeface();
      if (localTypeface != null)
      {
        if (!Typeface.MONOSPACE.equals(localTypeface))
        {
          if (!Typeface.SANS_SERIF.equals(localTypeface))
          {
            if (!Typeface.SERIF.equals(localTypeface)) {
              localTextTrackStyle.setFontGenericFamily(0);
            } else {
              localTextTrackStyle.setFontGenericFamily(2);
            }
          }
          else {
            localTextTrackStyle.setFontGenericFamily(0);
          }
        }
        else {
          localTextTrackStyle.setFontGenericFamily(1);
        }
        boolean bool1 = localTypeface.isBold();
        boolean bool2 = localTypeface.isItalic();
        if ((!bool1) || (!bool2))
        {
          if (!bool1)
          {
            if (!bool2) {
              localTextTrackStyle.setFontStyle(0);
            } else {
              localTextTrackStyle.setFontStyle(2);
            }
          }
          else {
            localTextTrackStyle.setFontStyle(1);
          }
        }
        else {
          localTextTrackStyle.setFontStyle(3);
        }
      }
      localTextTrackStyle = localTextTrackStyle;
    }
    else
    {
      localTextTrackStyle = localTextTrackStyle;
    }
    return localTextTrackStyle;
  }
  
  private String o(int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(Color.red(paramInt));
    arrayOfObject[1] = Integer.valueOf(Color.green(paramInt));
    arrayOfObject[2] = Integer.valueOf(Color.blue(paramInt));
    arrayOfObject[3] = Integer.valueOf(Color.alpha(paramInt));
    return String.format("#%02X%02X%02X%02X", arrayOfObject);
  }
  
  public void b(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.Bp = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.Bq = ah(paramJSONObject.optString("foregroundColor"));
    this.ta = ah(paramJSONObject.optString("backgroundColor"));
    String str;
    if (paramJSONObject.has("edgeType"))
    {
      str = paramJSONObject.getString("edgeType");
      if (!"NONE".equals(str))
      {
        if (!"OUTLINE".equals(str))
        {
          if (!"DROP_SHADOW".equals(str))
          {
            if (!"RAISED".equals(str))
            {
              if ("DEPRESSED".equals(str)) {
                this.Br = 4;
              }
            }
            else {
              this.Br = 3;
            }
          }
          else {
            this.Br = 2;
          }
        }
        else {
          this.Br = 1;
        }
      }
      else {
        this.Br = 0;
      }
    }
    this.Bs = ah(paramJSONObject.optString("edgeColor"));
    if (paramJSONObject.has("windowType"))
    {
      str = paramJSONObject.getString("windowType");
      if (!"NONE".equals(str))
      {
        if (!"NORMAL".equals(str))
        {
          if ("ROUNDED_CORNERS".equals(str)) {
            this.Bt = 2;
          }
        }
        else {
          this.Bt = 1;
        }
      }
      else {
        this.Bt = 0;
      }
    }
    this.Bu = ah(paramJSONObject.optString("windowColor"));
    if (this.Bt == 2) {
      this.Bv = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
    }
    this.Bw = paramJSONObject.optString("fontFamily", null);
    if (paramJSONObject.has("fontGenericFamily"))
    {
      str = paramJSONObject.getString("fontGenericFamily");
      if (!"SANS_SERIF".equals(str))
      {
        if (!"MONOSPACED_SANS_SERIF".equals(str))
        {
          if (!"SERIF".equals(str))
          {
            if (!"MONOSPACED_SERIF".equals(str))
            {
              if (!"CASUAL".equals(str))
              {
                if (!"CURSIVE".equals(str))
                {
                  if ("SMALL_CAPITALS".equals(str)) {
                    this.Bx = 6;
                  }
                }
                else {
                  this.Bx = 5;
                }
              }
              else {
                this.Bx = 4;
              }
            }
            else {
              this.Bx = 3;
            }
          }
          else {
            this.Bx = 2;
          }
        }
        else {
          this.Bx = 1;
        }
      }
      else {
        this.Bx = 0;
      }
    }
    if (paramJSONObject.has("fontStyle"))
    {
      str = paramJSONObject.getString("fontStyle");
      if (!"NORMAL".equals(str))
      {
        if (!"BOLD".equals(str))
        {
          if (!"ITALIC".equals(str))
          {
            if ("BOLD_ITALIC".equals(str)) {
              this.By = 3;
            }
          }
          else {
            this.By = 2;
          }
        }
        else {
          this.By = 1;
        }
      }
      else {
        this.By = 0;
      }
    }
    this.Ax = paramJSONObject.optJSONObject("customData");
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.Bp);
      if (this.Bq != 0) {
        localJSONObject.put("foregroundColor", o(this.Bq));
      }
      if (this.ta != 0) {
        localJSONObject.put("backgroundColor", o(this.ta));
      }
      switch (this.Br)
      {
      default: 
        if (this.Bs != 0) {
          localJSONObject.put("edgeColor", o(this.Bs));
        }
        switch (this.Bt)
        {
        default: 
          label156:
          if (this.Bu != 0) {
            localJSONObject.put("windowColor", o(this.Bu));
          }
          if (this.Bt == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.Bv);
          }
          if (this.Bw != null) {
            localJSONObject.put("fontFamily", this.Bw);
          }
          switch (this.Bx)
          {
          default: 
            label264:
            switch (this.By)
            {
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (this.Ax == null) {
          break label583;
        }
        localJSONObject.put("customData", this.Ax);
        break label583;
        localJSONObject.put("edgeType", "NONE");
        break;
        localJSONObject.put("edgeType", "OUTLINE");
        break;
        localJSONObject.put("edgeType", "DROP_SHADOW");
        break;
        localJSONObject.put("edgeType", "RAISED");
        break;
        localJSONObject.put("edgeType", "DEPRESSED");
        break;
        localJSONObject.put("windowType", "NONE");
        break label156;
        localJSONObject.put("windowType", "NORMAL");
        break label156;
        localJSONObject.put("windowType", "ROUNDED_CORNERS");
        break label156;
        localJSONObject.put("fontGenericFamily", "SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "CASUAL");
        break label264;
        localJSONObject.put("fontGenericFamily", "CURSIVE");
        break label264;
        localJSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
        break label264;
        localJSONObject.put("fontStyle", "NORMAL");
        continue;
        localJSONObject.put("fontStyle", "BOLD");
        continue;
        localJSONObject.put("fontStyle", "ITALIC");
        continue;
        localJSONObject.put("fontStyle", "BOLD_ITALIC");
      }
    }
    catch (JSONException localJSONException)
    {
      label583:
      break label583;
    }
    return localJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this != paramObject)
    {
      if ((paramObject instanceof TextTrackStyle))
      {
        TextTrackStyle localTextTrackStyle = (TextTrackStyle)paramObject;
        int j;
        if (this.Ax != null) {
          j = 0;
        } else {
          j = bool1;
        }
        int i;
        if (localTextTrackStyle.Ax != null) {
          i = 0;
        } else {
          i = bool1;
        }
        if ((j == i) && ((this.Ax == null) || (localTextTrackStyle.Ax == null) || (io.d(this.Ax, localTextTrackStyle.Ax))))
        {
          if ((this.Bp != localTextTrackStyle.Bp) || (this.Bq != localTextTrackStyle.Bq) || (this.ta != localTextTrackStyle.ta) || (this.Br != localTextTrackStyle.Br) || (this.Bs != localTextTrackStyle.Bs) || (this.Bt != localTextTrackStyle.Bt) || (this.Bv != localTextTrackStyle.Bv) || (!gj.a(this.Bw, localTextTrackStyle.Bw)) || (this.Bx != localTextTrackStyle.Bx) || (this.By != localTextTrackStyle.By)) {
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
  
  public int getBackgroundColor()
  {
    return this.ta;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ax;
  }
  
  public int getEdgeColor()
  {
    return this.Bs;
  }
  
  public int getEdgeType()
  {
    return this.Br;
  }
  
  public String getFontFamily()
  {
    return this.Bw;
  }
  
  public int getFontGenericFamily()
  {
    return this.Bx;
  }
  
  public float getFontScale()
  {
    return this.Bp;
  }
  
  public int getFontStyle()
  {
    return this.By;
  }
  
  public int getForegroundColor()
  {
    return this.Bq;
  }
  
  public int getWindowColor()
  {
    return this.Bu;
  }
  
  public int getWindowCornerRadius()
  {
    return this.Bv;
  }
  
  public int getWindowType()
  {
    return this.Bt;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[12];
    arrayOfObject[0] = Float.valueOf(this.Bp);
    arrayOfObject[1] = Integer.valueOf(this.Bq);
    arrayOfObject[2] = Integer.valueOf(this.ta);
    arrayOfObject[3] = Integer.valueOf(this.Br);
    arrayOfObject[4] = Integer.valueOf(this.Bs);
    arrayOfObject[5] = Integer.valueOf(this.Bt);
    arrayOfObject[6] = Integer.valueOf(this.Bu);
    arrayOfObject[7] = Integer.valueOf(this.Bv);
    arrayOfObject[8] = this.Bw;
    arrayOfObject[9] = Integer.valueOf(this.Bx);
    arrayOfObject[10] = Integer.valueOf(this.By);
    arrayOfObject[11] = this.Ax;
    return hl.hashCode(arrayOfObject);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.ta = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.Ax = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.Bs = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4))
    {
      this.Br = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid edgeType");
  }
  
  public void setFontFamily(String paramString)
  {
    this.Bw = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 6))
    {
      this.Bx = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid fontGenericFamily");
  }
  
  public void setFontScale(float paramFloat)
  {
    this.Bp = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      this.By = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid fontStyle");
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.Bq = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.Bu = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.Bv = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid windowCornerRadius");
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.Bt = paramInt;
      return;
    }
    throw new IllegalArgumentException("invalid windowType");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.TextTrackStyle
 * JD-Core Version:    0.7.0.1
 */
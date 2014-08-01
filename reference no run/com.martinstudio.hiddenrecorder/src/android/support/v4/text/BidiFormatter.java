package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter
{
  private static final int DEFAULT_FLAGS = 2;
  private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
  private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  private static final int DIR_LTR = -1;
  private static final int DIR_RTL = 1;
  private static final int DIR_UNKNOWN = 0;
  private static final String EMPTY_STRING = "";
  private static final int FLAG_STEREO_RESET = 2;
  private static final char LRE = '‪';
  private static final char LRM = '‎';
  private static final String LRM_STRING = Character.toString('‎');
  private static final char PDF = '‬';
  private static final char RLE = '‫';
  private static final char RLM = '‏';
  private static final String RLM_STRING = Character.toString('‏');
  private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
  private final int mFlags;
  private final boolean mIsRtlContext;
  
  private BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mIsRtlContext = paramBoolean;
    this.mFlags = paramInt;
    this.mDefaultTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
  }
  
  private static int getEntryDir(String paramString)
  {
    return new DirectionalityEstimator(paramString, false).getEntryDir();
  }
  
  private static int getExitDir(String paramString)
  {
    return new DirectionalityEstimator(paramString, false).getExitDir();
  }
  
  public static BidiFormatter getInstance()
  {
    return new Builder().build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale)
  {
    return new Builder(paramLocale).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean)
  {
    return new Builder(paramBoolean).build();
  }
  
  private static boolean isRtlLocale(Locale paramLocale)
  {
    int i = 1;
    if (TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) != i) {
      i = 0;
    }
    return i;
  }
  
  private String markAfter(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    String str;
    if ((this.mIsRtlContext) || ((!bool) && (getExitDir(paramString) != 1)))
    {
      if ((!this.mIsRtlContext) || ((bool) && (getExitDir(paramString) != -1))) {
        str = "";
      } else {
        str = RLM_STRING;
      }
    }
    else {
      str = LRM_STRING;
    }
    return str;
  }
  
  private String markBefore(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    String str;
    if ((this.mIsRtlContext) || ((!bool) && (getEntryDir(paramString) != 1)))
    {
      if ((!this.mIsRtlContext) || ((bool) && (getEntryDir(paramString) != -1))) {
        str = "";
      } else {
        str = RLM_STRING;
      }
    }
    else {
      str = LRM_STRING;
    }
    return str;
  }
  
  public boolean getStereoReset()
  {
    boolean bool;
    if ((0x2 & this.mFlags) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRtl(String paramString)
  {
    return this.mDefaultTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
  }
  
  public boolean isRtlContext()
  {
    return this.mIsRtlContext;
  }
  
  public String unicodeWrap(String paramString)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean)
  {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramString, 0, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    if ((getStereoReset()) && (paramBoolean))
    {
      TextDirectionHeuristicCompat localTextDirectionHeuristicCompat2;
      if (!bool) {
        localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.LTR;
      } else {
        localTextDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.RTL;
      }
      localStringBuilder.append(markBefore(paramString, localTextDirectionHeuristicCompat2));
    }
    if (bool == this.mIsRtlContext)
    {
      localStringBuilder.append(paramString);
    }
    else
    {
      int i;
      if (!bool) {
        i = 8234;
      } else {
        i = 8235;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(paramString);
      localStringBuilder.append('‬');
    }
    if (paramBoolean)
    {
      TextDirectionHeuristicCompat localTextDirectionHeuristicCompat1;
      if (!bool) {
        localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.LTR;
      } else {
        localTextDirectionHeuristicCompat1 = TextDirectionHeuristicsCompat.RTL;
      }
      localStringBuilder.append(markAfter(paramString, localTextDirectionHeuristicCompat1));
    }
    return localStringBuilder.toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean)
  {
    return unicodeWrap(paramString, this.mDefaultTextDirectionHeuristicCompat, paramBoolean);
  }
  
  private static class DirectionalityEstimator
  {
    private static final byte[] DIR_TYPE_CACHE = new byte[1792];
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final String text;
    
    static
    {
      for (int i = 0;; i++)
      {
        if (i >= 1792) {
          return;
        }
        DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
      }
    }
    
    DirectionalityEstimator(String paramString, boolean paramBoolean)
    {
      this.text = paramString;
      this.isHtml = paramBoolean;
      this.length = paramString.length();
    }
    
    private static byte getCachedDirectionality(char paramChar)
    {
      byte b;
      if (paramChar >= '܀') {
        b = Character.getDirectionality(paramChar);
      } else {
        b = DIR_TYPE_CACHE[paramChar];
      }
      return b;
    }
    
    private byte skipEntityBackward()
    {
      int i = this.charIndex;
      do
      {
        if (this.charIndex <= 0) {
          break;
        }
        String str = this.text;
        int j = -1 + this.charIndex;
        this.charIndex = j;
        this.lastChar = str.charAt(j);
        if (this.lastChar == '&') {
          break label74;
        }
      } while (this.lastChar != ';');
      this.charIndex = i;
      this.lastChar = ';';
      return 13;
      label74:
      i = 12;
      return i;
    }
    
    private byte skipEntityForward()
    {
      int i;
      do
      {
        if (this.charIndex >= this.length) {
          break;
        }
        String str = this.text;
        i = this.charIndex;
        this.charIndex = (i + 1);
        i = str.charAt(i);
        this.lastChar = i;
      } while (i != 59);
      return 12;
    }
    
    private byte skipTagBackward()
    {
      int i = this.charIndex;
      label124:
      while (this.charIndex > 0)
      {
        String str1 = this.text;
        int j = -1 + this.charIndex;
        this.charIndex = j;
        this.lastChar = str1.charAt(j);
        if (this.lastChar == '<') {
          break label143;
        }
        if (this.lastChar == '>') {
          break;
        }
        if ((this.lastChar == '"') || (this.lastChar == '\''))
        {
          j = this.lastChar;
          for (;;)
          {
            if (this.charIndex <= 0) {
              break label124;
            }
            String str2 = this.text;
            int k = -1 + this.charIndex;
            this.charIndex = k;
            k = str2.charAt(k);
            this.lastChar = k;
            if (k == j) {
              break;
            }
          }
        }
      }
      this.charIndex = i;
      this.lastChar = '>';
      return 13;
      label143:
      i = 12;
      return i;
    }
    
    private byte skipTagForward()
    {
      int i = this.charIndex;
      label138:
      for (;;)
      {
        if (this.charIndex >= this.length)
        {
          this.charIndex = i;
          this.lastChar = '<';
          return 13;
        }
        String str1 = this.text;
        int j = this.charIndex;
        this.charIndex = (j + 1);
        this.lastChar = str1.charAt(j);
        if (this.lastChar == '>') {
          break;
        }
        if ((this.lastChar == '"') || (this.lastChar == '\''))
        {
          j = this.lastChar;
          for (;;)
          {
            if (this.charIndex >= this.length) {
              break label138;
            }
            String str2 = this.text;
            int k = this.charIndex;
            this.charIndex = (k + 1);
            k = str2.charAt(k);
            this.lastChar = k;
            if (k == j) {
              break;
            }
          }
        }
      }
      i = 12;
      return i;
    }
    
    byte dirTypeBackward()
    {
      this.lastChar = this.text.charAt(-1 + this.charIndex);
      int i;
      if (!Character.isLowSurrogate(this.lastChar))
      {
        this.charIndex = (-1 + this.charIndex);
        i = getCachedDirectionality(this.lastChar);
        if (this.isHtml) {
          if (this.lastChar != '>')
          {
            if (this.lastChar == ';') {
              i = skipEntityBackward();
            }
          }
          else {
            i = skipTagBackward();
          }
        }
      }
      else
      {
        i = Character.codePointBefore(this.text, this.charIndex);
        this.charIndex -= Character.charCount(i);
        i = Character.getDirectionality(i);
      }
      return i;
    }
    
    byte dirTypeForward()
    {
      this.lastChar = this.text.charAt(this.charIndex);
      int i;
      if (!Character.isHighSurrogate(this.lastChar))
      {
        this.charIndex = (1 + this.charIndex);
        i = getCachedDirectionality(this.lastChar);
        if (this.isHtml) {
          if (this.lastChar != '<')
          {
            if (this.lastChar == '&') {
              i = skipEntityForward();
            }
          }
          else {
            i = skipTagForward();
          }
        }
      }
      else
      {
        i = Character.codePointAt(this.text, this.charIndex);
        this.charIndex += Character.charCount(i);
        i = Character.getDirectionality(i);
      }
      return i;
    }
    
    int getEntryDir()
    {
      this.charIndex = 0;
      int k = 0;
      int i = 0;
      int j = 0;
      for (;;)
      {
        if ((this.charIndex >= this.length) || (j != 0)) {
          if (j != 0)
          {
            if (i == 0) {
              for (;;)
              {
                if (this.charIndex <= 0)
                {
                  i = 0;
                  break;
                }
                switch (dirTypeBackward())
                {
                default: 
                  break;
                case 14: 
                case 15: 
                  if (j != k) {
                    k--;
                  } else {
                    i = -1;
                  }
                  break;
                case 16: 
                case 17: 
                  if (j != k) {
                    k--;
                  } else {
                    i = 1;
                  }
                  break;
                case 18: 
                  k++;
                }
              }
            }
          }
          else {
            i = 0;
          }
        }
        switch (dirTypeForward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          j = k;
          break;
        case 0: 
          if (k != 0) {
            j = k;
          } else {
            i = -1;
          }
          break;
        case 1: 
        case 2: 
          if (k != 0)
          {
            j = k;
          }
          else
          {
            i = 1;
            return i;
          }
          break;
        case 14: 
        case 15: 
          k++;
          i = -1;
          break;
        case 16: 
        case 17: 
          k++;
          i = 1;
          break;
        case 18: 
          k--;
          i = 0;
        }
      }
    }
    
    int getExitDir()
    {
      int k = -1;
      this.charIndex = this.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        if (this.charIndex <= 0) {
          k = 0;
        }
        switch (dirTypeBackward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (i == 0) {
            i = j;
          }
          break;
        case 0: 
          if (j != 0)
          {
            if (i != 0) {
              continue;
            }
            i = j;
          }
          break;
        case 1: 
        case 2: 
          if (j != 0)
          {
            if (i == 0) {
              i = j;
            }
          }
          else {
            k = 1;
          }
          break;
        case 14: 
        case 15: 
          if (i != j) {
            j--;
          }
          break;
        case 16: 
        case 17: 
          if (i != j)
          {
            j--;
          }
          else
          {
            k = 1;
            return k;
          }
          break;
        case 18: 
          j++;
        }
      }
    }
  }
  
  public static final class Builder
  {
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public Builder()
    {
      initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
    }
    
    public Builder(Locale paramLocale)
    {
      initialize(BidiFormatter.isRtlLocale(paramLocale));
    }
    
    public Builder(boolean paramBoolean)
    {
      initialize(paramBoolean);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean)
    {
      BidiFormatter localBidiFormatter;
      if (!paramBoolean) {
        localBidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
      } else {
        localBidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
      }
      return localBidiFormatter;
    }
    
    private void initialize(boolean paramBoolean)
    {
      this.mIsRtlContext = paramBoolean;
      this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
      this.mFlags = 2;
    }
    
    public BidiFormatter build()
    {
      BidiFormatter localBidiFormatter;
      if ((this.mFlags != 2) || (this.mTextDirectionHeuristicCompat != BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC)) {
        localBidiFormatter = new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null);
      } else {
        localBidiFormatter = getDefaultInstanceFromContext(this.mIsRtlContext);
      }
      return localBidiFormatter;
    }
    
    public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
    {
      this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
      return this;
    }
    
    public Builder stereoReset(boolean paramBoolean)
    {
      if (!paramBoolean) {
        this.mFlags = (0xFFFFFFFD & this.mFlags);
      } else {
        this.mFlags = (0x2 | this.mFlags);
      }
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter
 * JD-Core Version:    0.7.0.1
 */
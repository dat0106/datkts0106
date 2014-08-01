package android.support.v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

public class TextDirectionHeuristicsCompat
{
  public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false, null);
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
  public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
  public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
  public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false, null);
  public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true, null);
  private static final int STATE_FALSE = 1;
  private static final int STATE_TRUE = 0;
  private static final int STATE_UNKNOWN = 2;
  
  static
  {
    FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false, null);
    FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true, null);
  }
  
  private static int isRtlText(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 2;
      break;
    case 0: 
      i = 1;
      break;
    case 1: 
    case 2: 
      i = 0;
    }
    return i;
  }
  
  private static int isRtlTextOrFormat(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 2;
      break;
    case 0: 
    case 14: 
    case 15: 
      i = 1;
      break;
    case 1: 
    case 2: 
    case 16: 
    case 17: 
      i = 0;
    }
    return i;
  }
  
  private static class TextDirectionHeuristicLocale
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
    
    public TextDirectionHeuristicLocale()
    {
      super();
    }
    
    protected boolean defaultIsRtl()
    {
      int i = 1;
      if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != i) {
        i = 0;
      }
      return i;
    }
  }
  
  private static class AnyStrong
    implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
  {
    public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
    public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
    private final boolean mLookForRtl;
    
    private AnyStrong(boolean paramBoolean)
    {
      this.mLookForRtl = paramBoolean;
    }
    
    public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int k = 1;
      int m = 0;
      int i = paramInt1;
      int j = paramInt1 + paramInt2;
      for (;;)
      {
        if (i >= j) {
          if (m == 0) {
            k = 2;
          } else if (!this.mLookForRtl) {
            k = 0;
          }
        }
        switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(paramCharSequence.charAt(i))))
        {
        case 0: 
          if (!this.mLookForRtl) {
            m = 1;
          } else {
            k = 0;
          }
          break;
        case 1: 
          if (!this.mLookForRtl) {
            return k;
          }
          m = 1;
        }
        i++;
      }
    }
  }
  
  private static class FirstStrong
    implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
  {
    public static final FirstStrong INSTANCE = new FirstStrong();
    
    public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int i = 2;
      int j = paramInt1;
      int k = paramInt1 + paramInt2;
      for (;;)
      {
        if ((j >= k) || (i != 2)) {
          return i;
        }
        i = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(paramCharSequence.charAt(j)));
        j++;
      }
    }
  }
  
  private static abstract interface TextDirectionAlgorithm
  {
    public abstract int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }
  
  private static class TextDirectionHeuristicInternal
    extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
  {
    private final boolean mDefaultIsRtl;
    
    private TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean)
    {
      super();
      this.mDefaultIsRtl = paramBoolean;
    }
    
    protected boolean defaultIsRtl()
    {
      return this.mDefaultIsRtl;
    }
  }
  
  private static abstract class TextDirectionHeuristicImpl
    implements TextDirectionHeuristicCompat
  {
    private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
    
    public TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm)
    {
      this.mAlgorithm = paramTextDirectionAlgorithm;
    }
    
    private boolean doCheck(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      boolean bool;
      switch (this.mAlgorithm.checkRtl(paramCharSequence, paramInt1, paramInt2))
      {
      default: 
        bool = defaultIsRtl();
        break;
      case 0: 
        bool = true;
        break;
      case 1: 
        bool = false;
      }
      return bool;
    }
    
    protected abstract boolean defaultIsRtl();
    
    public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramCharSequence.length() - paramInt2 >= paramInt1))
      {
        boolean bool;
        if (this.mAlgorithm != null) {
          bool = doCheck(paramCharSequence, paramInt1, paramInt2);
        } else {
          bool = defaultIsRtl();
        }
        return bool;
      }
      throw new IllegalArgumentException();
    }
    
    public boolean isRtl(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      return isRtl(CharBuffer.wrap(paramArrayOfChar), paramInt1, paramInt2);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs
{
  public static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new SingleLineAllCapsTransform(paramTextView.getContext()));
  }
  
  private static class SingleLineAllCapsTransform
    extends SingleLineTransformationMethod
  {
    private static final String TAG = "SingleLineAllCapsTransform";
    private Locale mLocale;
    
    public SingleLineAllCapsTransform(Context paramContext)
    {
      this.mLocale = paramContext.getResources().getConfiguration().locale;
    }
    
    public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      Object localObject = super.getTransformation(paramCharSequence, paramView);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = localObject.toString().toUpperCase(this.mLocale);
      }
      return localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStripIcs
 * JD-Core Version:    0.7.0.1
 */
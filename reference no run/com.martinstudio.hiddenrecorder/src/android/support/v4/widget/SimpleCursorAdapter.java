package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter
  extends ResourceCursorAdapter
{
  private CursorToStringConverter mCursorToStringConverter;
  protected int[] mFrom;
  String[] mOriginalFrom;
  private int mStringConversionColumn = -1;
  protected int[] mTo;
  private ViewBinder mViewBinder;
  
  @Deprecated
  public SimpleCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramCursor);
    this.mTo = paramArrayOfInt;
    this.mOriginalFrom = paramArrayOfString;
    findColumns(paramArrayOfString);
  }
  
  public SimpleCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    this.mTo = paramArrayOfInt;
    this.mOriginalFrom = paramArrayOfString;
    findColumns(paramArrayOfString);
  }
  
  private void findColumns(String[] paramArrayOfString)
  {
    int i;
    if (this.mCursor == null)
    {
      this.mFrom = null;
    }
    else
    {
      i = paramArrayOfString.length;
      if ((this.mFrom == null) || (this.mFrom.length != i)) {
        this.mFrom = new int[i];
      }
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      this.mFrom[j] = this.mCursor.getColumnIndexOrThrow(paramArrayOfString[j]);
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ViewBinder localViewBinder = this.mViewBinder;
    int j = this.mTo.length;
    int[] arrayOfInt2 = this.mFrom;
    int[] arrayOfInt1 = this.mTo;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      View localView = paramView.findViewById(arrayOfInt1[i]);
      if (localView != null)
      {
        boolean bool = false;
        if (localViewBinder != null) {
          bool = localViewBinder.setViewValue(localView, paramCursor, arrayOfInt2[i]);
        }
        if (!bool)
        {
          String str = paramCursor.getString(arrayOfInt2[i]);
          if (str == null) {
            str = "";
          }
          if (!(localView instanceof TextView))
          {
            if (!(localView instanceof ImageView)) {
              throw new IllegalStateException(localView.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
            }
            setViewImage((ImageView)localView, str);
          }
          else
          {
            setViewText((TextView)localView, str);
          }
        }
      }
    }
  }
  
  public void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mOriginalFrom = paramArrayOfString;
    this.mTo = paramArrayOfInt;
    super.changeCursor(paramCursor);
    findColumns(this.mOriginalFrom);
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    Object localObject;
    if (this.mCursorToStringConverter == null)
    {
      if (this.mStringConversionColumn <= -1) {
        localObject = super.convertToString(paramCursor);
      } else {
        localObject = paramCursor.getString(this.mStringConversionColumn);
      }
    }
    else {
      localObject = this.mCursorToStringConverter.convertToString(paramCursor);
    }
    return localObject;
  }
  
  public CursorToStringConverter getCursorToStringConverter()
  {
    return this.mCursorToStringConverter;
  }
  
  public int getStringConversionColumn()
  {
    return this.mStringConversionColumn;
  }
  
  public ViewBinder getViewBinder()
  {
    return this.mViewBinder;
  }
  
  public void setCursorToStringConverter(CursorToStringConverter paramCursorToStringConverter)
  {
    this.mCursorToStringConverter = paramCursorToStringConverter;
  }
  
  public void setStringConversionColumn(int paramInt)
  {
    this.mStringConversionColumn = paramInt;
  }
  
  public void setViewBinder(ViewBinder paramViewBinder)
  {
    this.mViewBinder = paramViewBinder;
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    try
    {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        paramImageView.setImageURI(Uri.parse(paramString));
      }
    }
  }
  
  public void setViewText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor = super.swapCursor(paramCursor);
    findColumns(this.mOriginalFrom);
    return localCursor;
  }
  
  public static abstract interface CursorToStringConverter
  {
    public abstract CharSequence convertToString(Cursor paramCursor);
  }
  
  public static abstract interface ViewBinder
  {
    public abstract boolean setViewValue(View paramView, Cursor paramCursor, int paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SimpleCursorAdapter
 * JD-Core Version:    0.7.0.1
 */
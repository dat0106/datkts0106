package com.smartandroidapps.audiowidgetlib.ui;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.Formatter;

public class NumberPicker
  extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener
{
  private static final int DEFAULT_MAX = 200;
  private static final int DEFAULT_MIN = 0;
  private static final char[] DIGIT_CHARACTERS;
  private static final String TAG = "NumberPicker";
  public static final Formatter TWO_DIGIT_FORMATTER = new Formatter()
  {
    final Object[] mArgs = new Object[1];
    final StringBuilder mBuilder = new StringBuilder();
    final Formatter mFmt = new Formatter(this.mBuilder);
    
    public String toString(int paramAnonymousInt)
    {
      this.mArgs[0] = Integer.valueOf(paramAnonymousInt);
      this.mBuilder.delete(0, this.mBuilder.length());
      this.mFmt.format("%02d", this.mArgs);
      return this.mFmt.toString();
    }
  };
  protected int mCurrent;
  private boolean mDecrement;
  private NumberPickerButton mDecrementButton;
  private String[] mDisplayedValues;
  protected int mEnd;
  private Formatter mFormatter;
  private final Handler mHandler;
  private boolean mIncrement;
  private NumberPickerButton mIncrementButton;
  private OnChangedListener mListener;
  private final InputFilter mNumberInputFilter;
  protected int mPrevious;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      if (!NumberPicker.this.mIncrement)
      {
        if (NumberPicker.this.mDecrement)
        {
          NumberPicker.this.changeCurrent(-1 + NumberPicker.this.mCurrent);
          NumberPicker.this.mHandler.postDelayed(this, NumberPicker.this.mSpeed);
        }
      }
      else
      {
        NumberPicker.this.changeCurrent(1 + NumberPicker.this.mCurrent);
        NumberPicker.this.mHandler.postDelayed(this, NumberPicker.this.mSpeed);
      }
    }
  };
  private long mSpeed = 300L;
  protected int mStart;
  private final EditText mText;
  
  static
  {
    char[] arrayOfChar = new char[10];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    DIGIT_CHARACTERS = arrayOfChar;
  }
  
  public NumberPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    if (!MiscUtils.isAtLeastLargeHC(paramContext)) {
      ((LayoutInflater)localObject).inflate(R.layout.number_picker_phone, this, true);
    } else {
      ((LayoutInflater)localObject).inflate(R.layout.number_picker, this, true);
    }
    this.mHandler = new Handler();
    NumberPickerInputFilter localNumberPickerInputFilter = new NumberPickerInputFilter(null);
    this.mNumberInputFilter = new NumberRangeKeyListener(null);
    this.mIncrementButton = ((NumberPickerButton)findViewById(R.id.increment));
    this.mIncrementButton.setOnClickListener(this);
    this.mIncrementButton.setOnLongClickListener(this);
    this.mIncrementButton.setNumberPicker(this);
    this.mDecrementButton = ((NumberPickerButton)findViewById(R.id.decrement));
    this.mDecrementButton.setOnClickListener(this);
    this.mDecrementButton.setOnLongClickListener(this);
    this.mDecrementButton.setNumberPicker(this);
    this.mText = ((EditText)findViewById(R.id.timepicker_input));
    this.mText.setOnFocusChangeListener(this);
    EditText localEditText = this.mText;
    localObject = new InputFilter[1];
    localObject[0] = localNumberPickerInputFilter;
    localEditText.setFilters((InputFilter[])localObject);
    this.mText.setRawInputType(2);
    if (!isEnabled()) {
      setEnabled(false);
    }
    this.mStart = 0;
    this.mEnd = 200;
  }
  
  private String formatNumber(int paramInt)
  {
    String str;
    if (this.mFormatter == null) {
      str = String.valueOf(paramInt);
    } else {
      str = this.mFormatter.toString(paramInt);
    }
    return str;
  }
  
  private int getSelectedPos(String paramString)
  {
    int i;
    if (this.mDisplayedValues == null) {
      i = Integer.parseInt(paramString);
    }
    for (;;)
    {
      return i;
      for (i = 0;; i++)
      {
        if (i >= this.mDisplayedValues.length) {
          break label62;
        }
        paramString = paramString.toLowerCase();
        if (this.mDisplayedValues[i].toLowerCase().startsWith(paramString))
        {
          i += this.mStart;
          break;
        }
      }
      try
      {
        label62:
        i = Integer.parseInt(paramString);
        i = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i = this.mStart;
      }
    }
  }
  
  private void validateCurrentView(CharSequence paramCharSequence)
  {
    int i = getSelectedPos(paramCharSequence.toString());
    if ((i >= this.mStart) && (i <= this.mEnd) && (this.mCurrent != i))
    {
      this.mPrevious = this.mCurrent;
      this.mCurrent = i;
      notifyChange();
    }
    updateView();
  }
  
  private void validateInput(View paramView)
  {
    String str = String.valueOf(((TextView)paramView).getText());
    if (!"".equals(str)) {
      validateCurrentView(str);
    } else {
      updateView();
    }
  }
  
  public void cancelDecrement()
  {
    this.mDecrement = false;
  }
  
  public void cancelIncrement()
  {
    this.mIncrement = false;
  }
  
  protected void changeCurrent(int paramInt)
  {
    if (paramInt <= this.mEnd)
    {
      if (paramInt < this.mStart) {
        paramInt = this.mEnd;
      }
    }
    else {
      paramInt = this.mStart;
    }
    this.mPrevious = this.mCurrent;
    this.mCurrent = paramInt;
    notifyChange();
    updateView();
  }
  
  public int getCurrent()
  {
    return this.mCurrent;
  }
  
  protected void notifyChange()
  {
    if (this.mListener != null) {
      this.mListener.onChanged(this, this.mPrevious, this.mCurrent);
    }
  }
  
  public void onClick(View paramView)
  {
    validateInput(this.mText);
    if (!this.mText.hasFocus()) {
      this.mText.requestFocus();
    }
    if (R.id.increment != paramView.getId())
    {
      if (R.id.decrement == paramView.getId()) {
        changeCurrent(-1 + this.mCurrent);
      }
    }
    else {
      changeCurrent(1 + this.mCurrent);
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      validateInput(paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.mText.clearFocus();
    if (R.id.increment != paramView.getId())
    {
      if (R.id.decrement == paramView.getId())
      {
        this.mDecrement = true;
        this.mHandler.post(this.mRunnable);
      }
    }
    else
    {
      this.mIncrement = true;
      this.mHandler.post(this.mRunnable);
    }
    return true;
  }
  
  public void setCurrent(int paramInt)
  {
    this.mCurrent = paramInt;
    updateView();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mIncrementButton.setEnabled(paramBoolean);
    this.mDecrementButton.setEnabled(paramBoolean);
    this.mText.setEnabled(paramBoolean);
  }
  
  public void setFormatter(Formatter paramFormatter)
  {
    this.mFormatter = paramFormatter;
  }
  
  public void setOnChangeListener(OnChangedListener paramOnChangedListener)
  {
    this.mListener = paramOnChangedListener;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mCurrent = paramInt1;
    updateView();
  }
  
  public void setRange(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.mDisplayedValues = paramArrayOfString;
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mCurrent = paramInt1;
    updateView();
  }
  
  public void setSpeed(long paramLong)
  {
    this.mSpeed = paramLong;
  }
  
  protected void updateView()
  {
    if (this.mDisplayedValues != null) {
      this.mText.setText(this.mDisplayedValues[(this.mCurrent - this.mStart)]);
    } else {
      this.mText.setText(formatNumber(this.mCurrent));
    }
    this.mText.setSelection(this.mText.getText().length());
  }
  
  private class NumberRangeKeyListener
    extends NumberKeyListener
  {
    private NumberRangeKeyListener() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      CharSequence localCharSequence = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      if (localCharSequence == null) {
        localCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
      }
      Object localObject = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence + paramSpanned.subSequence(paramInt4, paramSpanned.length());
      if (!"".equals(localObject)) {
        if (NumberPicker.this.getSelectedPos((String)localObject) <= NumberPicker.this.mEnd) {
          localObject = localCharSequence;
        } else {
          localObject = "";
        }
      }
      return localObject;
    }
    
    protected char[] getAcceptedChars()
    {
      return NumberPicker.DIGIT_CHARACTERS;
    }
    
    public int getInputType()
    {
      return 2;
    }
  }
  
  private class NumberPickerInputFilter
    implements InputFilter
  {
    private NumberPickerInputFilter() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (NumberPicker.this.mDisplayedValues != null)
      {
        localObject = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
        String str = String.valueOf(String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localObject + paramSpanned.subSequence(paramInt4, paramSpanned.length())).toLowerCase();
        String[] arrayOfString = NumberPicker.this.mDisplayedValues;
        int i = arrayOfString.length;
        for (int j = 0;; j++)
        {
          if (j >= i)
          {
            localObject = "";
            break;
          }
          if (arrayOfString[j].toLowerCase().startsWith(str)) {
            break;
          }
        }
      }
      Object localObject = NumberPicker.this.mNumberInputFilter.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      return localObject;
    }
  }
  
  public static abstract interface Formatter
  {
    public abstract String toString(int paramInt);
  }
  
  public static abstract interface OnChangedListener
  {
    public abstract void onChanged(NumberPicker paramNumberPicker, int paramInt1, int paramInt2);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.NumberPicker
 * JD-Core Version:    0.7.0.1
 */
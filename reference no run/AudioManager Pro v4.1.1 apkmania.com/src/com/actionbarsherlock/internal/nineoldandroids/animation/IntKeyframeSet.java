package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet
  extends KeyframeSet
{
  private int deltaValue;
  private boolean firstTime = true;
  private int firstValue;
  private int lastValue;
  
  public IntKeyframeSet(Keyframe.IntKeyframe... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public IntKeyframeSet clone()
  {
    ArrayList localArrayList = this.mKeyframes;
    int i = this.mKeyframes.size();
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[i];
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return new IntKeyframeSet(arrayOfIntKeyframe);
      }
      arrayOfIntKeyframe[j] = ((Keyframe.IntKeyframe)((Keyframe)localArrayList.get(j)).clone());
    }
  }
  
  public int getIntValue(float paramFloat)
  {
    int j;
    if (this.mNumKeyframes != 2)
    {
      int k;
      Object localObject2;
      float f4;
      if (paramFloat > 0.0F)
      {
        if (paramFloat < 1.0F)
        {
          Object localObject1 = (Keyframe.IntKeyframe)this.mKeyframes.get(0);
          Keyframe.IntKeyframe localIntKeyframe1;
          for (int m = 1;; m++)
          {
            if (m >= this.mNumKeyframes)
            {
              int i = ((Number)((Keyframe)this.mKeyframes.get(-1 + this.mNumKeyframes)).getValue()).intValue();
              return ???;
            }
            localIntKeyframe1 = (Keyframe.IntKeyframe)this.mKeyframes.get(m);
            if (paramFloat < localIntKeyframe1.getFraction()) {
              break;
            }
            localObject1 = localIntKeyframe1;
          }
          Interpolator localInterpolator = localIntKeyframe1.getInterpolator();
          if (localInterpolator != null) {
            paramFloat = localInterpolator.getInterpolation(paramFloat);
          }
          float f1 = (paramFloat - ((Keyframe.IntKeyframe)localObject1).getFraction()) / (localIntKeyframe1.getFraction() - ((Keyframe.IntKeyframe)localObject1).getFraction());
          k = ((Keyframe.IntKeyframe)localObject1).getIntValue();
          j = localIntKeyframe1.getIntValue();
          if (this.mEvaluator != null) {
            j = ((Number)this.mEvaluator.evaluate(f1, Integer.valueOf(k), Integer.valueOf(j))).intValue();
          } else {
            j = k + (int)(f1 * (j - k));
          }
        }
        else
        {
          Keyframe.IntKeyframe localIntKeyframe2 = (Keyframe.IntKeyframe)this.mKeyframes.get(-2 + this.mNumKeyframes);
          localObject2 = (Keyframe.IntKeyframe)this.mKeyframes.get(-1 + this.mNumKeyframes);
          j = localIntKeyframe2.getIntValue();
          k = ((Keyframe.IntKeyframe)localObject2).getIntValue();
          f4 = localIntKeyframe2.getFraction();
          float f2 = ((Keyframe.IntKeyframe)localObject2).getFraction();
          localObject2 = ((Keyframe.IntKeyframe)localObject2).getInterpolator();
          if (localObject2 != null) {
            paramFloat = ((Interpolator)localObject2).getInterpolation(paramFloat);
          }
          f2 = (paramFloat - f4) / (f2 - f4);
          if (this.mEvaluator != null) {
            j = ((Number)this.mEvaluator.evaluate(f2, Integer.valueOf(j), Integer.valueOf(k))).intValue();
          } else {
            j += (int)(f2 * (k - j));
          }
        }
      }
      else
      {
        Keyframe.IntKeyframe localIntKeyframe3 = (Keyframe.IntKeyframe)this.mKeyframes.get(0);
        localObject2 = (Keyframe.IntKeyframe)this.mKeyframes.get(1);
        j = localIntKeyframe3.getIntValue();
        k = ((Keyframe.IntKeyframe)localObject2).getIntValue();
        float f3 = localIntKeyframe3.getFraction();
        f4 = ((Keyframe.IntKeyframe)localObject2).getFraction();
        localObject2 = ((Keyframe.IntKeyframe)localObject2).getInterpolator();
        if (localObject2 != null) {
          paramFloat = ((Interpolator)localObject2).getInterpolation(paramFloat);
        }
        f3 = (paramFloat - f3) / (f4 - f3);
        if (this.mEvaluator != null) {
          j = ((Number)this.mEvaluator.evaluate(f3, Integer.valueOf(j), Integer.valueOf(k))).intValue();
        } else {
          j += (int)(f3 * (k - j));
        }
      }
    }
    else
    {
      if (this.firstTime)
      {
        this.firstTime = false;
        this.firstValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(0)).getIntValue();
        this.lastValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(1)).getIntValue();
        this.deltaValue = (this.lastValue - this.firstValue);
      }
      if (this.mInterpolator != null) {
        paramFloat = this.mInterpolator.getInterpolation(paramFloat);
      }
      if (this.mEvaluator != null) {
        j = ((Number)this.mEvaluator.evaluate(paramFloat, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
      } else {
        j = this.firstValue + (int)(paramFloat * this.deltaValue);
      }
    }
    return j;
  }
  
  public Object getValue(float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramFloat));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.animation.IntKeyframeSet
 * JD-Core Version:    0.7.0.1
 */
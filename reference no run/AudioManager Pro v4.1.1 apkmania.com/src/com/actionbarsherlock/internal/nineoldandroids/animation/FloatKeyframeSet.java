package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class FloatKeyframeSet
  extends KeyframeSet
{
  private float deltaValue;
  private boolean firstTime = true;
  private float firstValue;
  private float lastValue;
  
  public FloatKeyframeSet(Keyframe.FloatKeyframe... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public FloatKeyframeSet clone()
  {
    ArrayList localArrayList = this.mKeyframes;
    int j = this.mKeyframes.size();
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[j];
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return new FloatKeyframeSet(arrayOfFloatKeyframe);
      }
      arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)((Keyframe)localArrayList.get(i)).clone());
    }
  }
  
  public float getFloatValue(float paramFloat)
  {
    float f2;
    if (this.mNumKeyframes != 2)
    {
      float f3;
      Object localObject2;
      float f7;
      if (paramFloat > 0.0F)
      {
        if (paramFloat < 1.0F)
        {
          Object localObject1 = (Keyframe.FloatKeyframe)this.mKeyframes.get(0);
          Keyframe.FloatKeyframe localFloatKeyframe1;
          for (int i = 1;; i++)
          {
            if (i >= this.mNumKeyframes)
            {
              float f1 = ((Number)((Keyframe)this.mKeyframes.get(-1 + this.mNumKeyframes)).getValue()).floatValue();
              return ???;
            }
            localFloatKeyframe1 = (Keyframe.FloatKeyframe)this.mKeyframes.get(i);
            if (paramFloat < localFloatKeyframe1.getFraction()) {
              break;
            }
            localObject1 = localFloatKeyframe1;
          }
          Interpolator localInterpolator = localFloatKeyframe1.getInterpolator();
          if (localInterpolator != null) {
            paramFloat = localInterpolator.getInterpolation(paramFloat);
          }
          f3 = (paramFloat - ((Keyframe.FloatKeyframe)localObject1).getFraction()) / (localFloatKeyframe1.getFraction() - ((Keyframe.FloatKeyframe)localObject1).getFraction());
          float f4 = ((Keyframe.FloatKeyframe)localObject1).getFloatValue();
          f2 = localFloatKeyframe1.getFloatValue();
          if (this.mEvaluator != null) {
            f2 = ((Number)this.mEvaluator.evaluate(f3, Float.valueOf(f4), Float.valueOf(f2))).floatValue();
          } else {
            f2 = f4 + f3 * (f2 - f4);
          }
        }
        else
        {
          Keyframe.FloatKeyframe localFloatKeyframe2 = (Keyframe.FloatKeyframe)this.mKeyframes.get(-2 + this.mNumKeyframes);
          localObject2 = (Keyframe.FloatKeyframe)this.mKeyframes.get(-1 + this.mNumKeyframes);
          f2 = localFloatKeyframe2.getFloatValue();
          f3 = ((Keyframe.FloatKeyframe)localObject2).getFloatValue();
          float f5 = localFloatKeyframe2.getFraction();
          f7 = ((Keyframe.FloatKeyframe)localObject2).getFraction();
          localObject2 = ((Keyframe.FloatKeyframe)localObject2).getInterpolator();
          if (localObject2 != null) {
            paramFloat = ((Interpolator)localObject2).getInterpolation(paramFloat);
          }
          f5 = (paramFloat - f5) / (f7 - f5);
          if (this.mEvaluator != null) {
            f2 = ((Number)this.mEvaluator.evaluate(f5, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
          } else {
            f2 += f5 * (f3 - f2);
          }
        }
      }
      else
      {
        Keyframe.FloatKeyframe localFloatKeyframe3 = (Keyframe.FloatKeyframe)this.mKeyframes.get(0);
        localObject2 = (Keyframe.FloatKeyframe)this.mKeyframes.get(1);
        f3 = localFloatKeyframe3.getFloatValue();
        f2 = ((Keyframe.FloatKeyframe)localObject2).getFloatValue();
        f7 = localFloatKeyframe3.getFraction();
        float f6 = ((Keyframe.FloatKeyframe)localObject2).getFraction();
        localObject2 = ((Keyframe.FloatKeyframe)localObject2).getInterpolator();
        if (localObject2 != null) {
          paramFloat = ((Interpolator)localObject2).getInterpolation(paramFloat);
        }
        f6 = (paramFloat - f7) / (f6 - f7);
        if (this.mEvaluator != null) {
          f2 = ((Number)this.mEvaluator.evaluate(f6, Float.valueOf(f3), Float.valueOf(f2))).floatValue();
        } else {
          f2 = f3 + f6 * (f2 - f3);
        }
      }
    }
    else
    {
      if (this.firstTime)
      {
        this.firstTime = false;
        this.firstValue = ((Keyframe.FloatKeyframe)this.mKeyframes.get(0)).getFloatValue();
        this.lastValue = ((Keyframe.FloatKeyframe)this.mKeyframes.get(1)).getFloatValue();
        this.deltaValue = (this.lastValue - this.firstValue);
      }
      if (this.mInterpolator != null) {
        paramFloat = this.mInterpolator.getInterpolation(paramFloat);
      }
      if (this.mEvaluator != null) {
        f2 = ((Number)this.mEvaluator.evaluate(paramFloat, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
      } else {
        f2 = this.firstValue + paramFloat * this.deltaValue;
      }
    }
    return f2;
  }
  
  public Object getValue(float paramFloat)
  {
    return Float.valueOf(getFloatValue(paramFloat));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.animation.FloatKeyframeSet
 * JD-Core Version:    0.7.0.1
 */
package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PropertyValuesHolder
  implements Cloneable
{
  private static Class[] DOUBLE_VARIANTS;
  private static Class[] FLOAT_VARIANTS;
  private static Class[] INTEGER_VARIANTS;
  private static final TypeEvaluator sFloatEvaluator;
  private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap();
  private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
  private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap;
  private Object mAnimatedValue;
  private TypeEvaluator mEvaluator;
  private Method mGetter = null;
  KeyframeSet mKeyframeSet = null;
  final ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
  String mPropertyName;
  Method mSetter = null;
  final Object[] mTmpValueArray = new Object[1];
  Class mValueType;
  
  static
  {
    sFloatEvaluator = new FloatEvaluator();
    Class[] arrayOfClass = new Class[6];
    arrayOfClass[0] = Float.TYPE;
    arrayOfClass[1] = Float.class;
    arrayOfClass[2] = Double.TYPE;
    arrayOfClass[3] = Integer.TYPE;
    arrayOfClass[4] = Double.class;
    arrayOfClass[5] = Integer.class;
    FLOAT_VARIANTS = arrayOfClass;
    arrayOfClass = new Class[6];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Integer.class;
    arrayOfClass[2] = Float.TYPE;
    arrayOfClass[3] = Double.TYPE;
    arrayOfClass[4] = Float.class;
    arrayOfClass[5] = Double.class;
    INTEGER_VARIANTS = arrayOfClass;
    arrayOfClass = new Class[6];
    arrayOfClass[0] = Double.TYPE;
    arrayOfClass[1] = Double.class;
    arrayOfClass[2] = Float.TYPE;
    arrayOfClass[3] = Integer.TYPE;
    arrayOfClass[4] = Float.class;
    arrayOfClass[5] = Integer.class;
    DOUBLE_VARIANTS = arrayOfClass;
    sSetterPropertyMap = new HashMap();
  }
  
  private PropertyValuesHolder(String paramString)
  {
    this.mPropertyName = paramString;
  }
  
  static String getMethodName(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() != 0))
    {
      char c = Character.toUpperCase(paramString2.charAt(0));
      String str = paramString2.substring(1);
      paramString1 = paramString1 + c + str;
    }
    return paramString1;
  }
  
  private Method getPropertyFunction(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod = null;
    String str = getMethodName(paramString, this.mPropertyName);
    if (paramClass2 == null) {}
    for (;;)
    {
      try
      {
        localMethod = paramClass1.getMethod(str, null);
        localMethod = localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Log.e("PropertyValuesHolder", paramClass1.getSimpleName() + " - " + "Couldn't find no-arg method for property " + this.mPropertyName + ": " + localNoSuchMethodException1);
        continue;
      }
      localMethod = localMethod;
      return localMethod;
      Class[] arrayOfClass1 = new Class[1];
      Class[] arrayOfClass2;
      label115:
      Class[] arrayOfClass3;
      int i;
      int j;
      if (this.mValueType.equals(Float.class))
      {
        arrayOfClass2 = FLOAT_VARIANTS;
        arrayOfClass3 = arrayOfClass2;
        i = arrayOfClass3.length;
        j = 0;
      }
      for (;;)
      {
        for (;;)
        {
          if (j >= i) {
            break label234;
          }
          arrayOfClass2 = arrayOfClass3[j];
          arrayOfClass1[0] = arrayOfClass2;
          try
          {
            localMethod = paramClass1.getMethod(str, arrayOfClass1);
            this.mValueType = arrayOfClass2;
            localMethod = localMethod;
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            j++;
          }
        }
        if (this.mValueType.equals(Integer.class))
        {
          arrayOfClass2 = INTEGER_VARIANTS;
          break label115;
        }
        if (this.mValueType.equals(Double.class))
        {
          arrayOfClass2 = DOUBLE_VARIANTS;
          break label115;
        }
        arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = this.mValueType;
        break label115;
      }
      label234:
      Log.e("PropertyValuesHolder", "Couldn't find " + paramString + "ter property " + this.mPropertyName + " for " + paramClass1.getSimpleName() + " with value type " + this.mValueType);
    }
  }
  
  public static PropertyValuesHolder ofFloat(String paramString, float... paramVarArgs)
  {
    return new FloatPropertyValuesHolder(paramString, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofInt(String paramString, int... paramVarArgs)
  {
    return new IntPropertyValuesHolder(paramString, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofKeyframe(String paramString, Keyframe... paramVarArgs)
  {
    KeyframeSet localKeyframeSet = KeyframeSet.ofKeyframe(paramVarArgs);
    Object localObject;
    if (!(localKeyframeSet instanceof IntKeyframeSet))
    {
      if (!(localKeyframeSet instanceof FloatKeyframeSet))
      {
        localObject = new PropertyValuesHolder(paramString);
        ((PropertyValuesHolder)localObject).mKeyframeSet = localKeyframeSet;
        ((PropertyValuesHolder)localObject).mValueType = paramVarArgs[0].getType();
      }
      else
      {
        localObject = new FloatPropertyValuesHolder(paramString, (FloatKeyframeSet)localKeyframeSet);
      }
    }
    else {
      localObject = new IntPropertyValuesHolder(paramString, (IntKeyframeSet)localKeyframeSet);
    }
    return localObject;
  }
  
  public static PropertyValuesHolder ofObject(String paramString, TypeEvaluator paramTypeEvaluator, Object... paramVarArgs)
  {
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramString);
    localPropertyValuesHolder.setObjectValues(paramVarArgs);
    localPropertyValuesHolder.setEvaluator(paramTypeEvaluator);
    return localPropertyValuesHolder;
  }
  
  private void setupGetter(Class paramClass)
  {
    this.mGetter = setupSetterOrGetter(paramClass, sGetterPropertyMap, "get", null);
  }
  
  private Method setupSetterOrGetter(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    Method localMethod = null;
    try
    {
      this.mPropertyMapLock.writeLock().lock();
      HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
      if (localHashMap != null) {
        localMethod = (Method)localHashMap.get(this.mPropertyName);
      }
      if (localMethod == null)
      {
        localMethod = getPropertyFunction(paramClass1, paramString, paramClass2);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          paramHashMap.put(paramClass1, localHashMap);
        }
        localHashMap.put(this.mPropertyName, localMethod);
      }
      return localMethod;
    }
    finally
    {
      this.mPropertyMapLock.writeLock().unlock();
    }
  }
  
  private void setupValue(Object paramObject, Keyframe paramKeyframe)
  {
    try
    {
      if (this.mGetter == null) {
        setupGetter(paramObject.getClass());
      }
      paramKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
      }
    }
  }
  
  void calculateValue(float paramFloat)
  {
    this.mAnimatedValue = this.mKeyframeSet.getValue(paramFloat);
  }
  
  public PropertyValuesHolder clone()
  {
    try
    {
      localPropertyValuesHolder = (PropertyValuesHolder)super.clone();
      localPropertyValuesHolder.mPropertyName = this.mPropertyName;
      localPropertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
      localPropertyValuesHolder.mEvaluator = this.mEvaluator;
      return localPropertyValuesHolder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        PropertyValuesHolder localPropertyValuesHolder = null;
      }
    }
  }
  
  Object getAnimatedValue()
  {
    return this.mAnimatedValue;
  }
  
  public String getPropertyName()
  {
    return this.mPropertyName;
  }
  
  void init()
  {
    if (this.mEvaluator == null)
    {
      TypeEvaluator localTypeEvaluator;
      if (this.mValueType != Integer.class)
      {
        if (this.mValueType != Float.class) {
          localTypeEvaluator = null;
        } else {
          localTypeEvaluator = sFloatEvaluator;
        }
      }
      else {
        localTypeEvaluator = sIntEvaluator;
      }
      this.mEvaluator = localTypeEvaluator;
    }
    if (this.mEvaluator != null) {
      this.mKeyframeSet.setEvaluator(this.mEvaluator);
    }
  }
  
  void setAnimatedValue(Object paramObject)
  {
    if (this.mSetter != null) {}
    try
    {
      this.mTmpValueArray[0] = getAnimatedValue();
      this.mSetter.invoke(paramObject, this.mTmpValueArray);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
      }
    }
  }
  
  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    this.mEvaluator = paramTypeEvaluator;
    this.mKeyframeSet.setEvaluator(paramTypeEvaluator);
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = KeyframeSet.ofFloat(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = KeyframeSet.ofInt(paramVarArgs);
  }
  
  public void setKeyframes(Keyframe... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe[] arrayOfKeyframe = new Keyframe[Math.max(j, 2)];
    this.mValueType = paramVarArgs[0].getType();
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        this.mKeyframeSet = new KeyframeSet(arrayOfKeyframe);
        return;
      }
      arrayOfKeyframe[i] = paramVarArgs[i];
    }
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    this.mValueType = paramVarArgs[0].getClass();
    this.mKeyframeSet = KeyframeSet.ofObject(paramVarArgs);
  }
  
  public void setPropertyName(String paramString)
  {
    this.mPropertyName = paramString;
  }
  
  void setupEndValue(Object paramObject)
  {
    setupValue(paramObject, (Keyframe)this.mKeyframeSet.mKeyframes.get(-1 + this.mKeyframeSet.mKeyframes.size()));
  }
  
  void setupSetter(Class paramClass)
  {
    this.mSetter = setupSetterOrGetter(paramClass, sSetterPropertyMap, "set", this.mValueType);
  }
  
  void setupSetterAndGetter(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    if (this.mSetter == null) {
      setupSetter(localClass);
    }
    Iterator localIterator = this.mKeyframeSet.mKeyframes.iterator();
    while (localIterator.hasNext())
    {
      Keyframe localKeyframe = (Keyframe)localIterator.next();
      if (!localKeyframe.hasValue())
      {
        if (this.mGetter == null) {
          setupGetter(localClass);
        }
        try
        {
          localKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
      }
    }
  }
  
  void setupStartValue(Object paramObject)
  {
    setupValue(paramObject, (Keyframe)this.mKeyframeSet.mKeyframes.get(0));
  }
  
  public String toString()
  {
    return this.mPropertyName + ": " + this.mKeyframeSet.toString();
  }
  
  static class FloatPropertyValuesHolder
    extends PropertyValuesHolder
  {
    float mFloatAnimatedValue;
    FloatKeyframeSet mFloatKeyframeSet;
    
    public FloatPropertyValuesHolder(String paramString, FloatKeyframeSet paramFloatKeyframeSet)
    {
      super(null);
      this.mValueType = Float.TYPE;
      this.mKeyframeSet = paramFloatKeyframeSet;
      this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
    }
    
    public FloatPropertyValuesHolder(String paramString, float... paramVarArgs)
    {
      super(null);
      setFloatValues(paramVarArgs);
    }
    
    void calculateValue(float paramFloat)
    {
      this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(paramFloat);
    }
    
    public FloatPropertyValuesHolder clone()
    {
      FloatPropertyValuesHolder localFloatPropertyValuesHolder = (FloatPropertyValuesHolder)super.clone();
      localFloatPropertyValuesHolder.mFloatKeyframeSet = ((FloatKeyframeSet)localFloatPropertyValuesHolder.mKeyframeSet);
      return localFloatPropertyValuesHolder;
    }
    
    Object getAnimatedValue()
    {
      return Float.valueOf(this.mFloatAnimatedValue);
    }
    
    void setAnimatedValue(Object paramObject)
    {
      if (this.mSetter != null) {}
      try
      {
        this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
        this.mSetter.invoke(paramObject, this.mTmpValueArray);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
      }
    }
    
    public void setFloatValues(float... paramVarArgs)
    {
      super.setFloatValues(paramVarArgs);
      this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
    }
    
    void setupSetter(Class paramClass)
    {
      super.setupSetter(paramClass);
    }
  }
  
  static class IntPropertyValuesHolder
    extends PropertyValuesHolder
  {
    int mIntAnimatedValue;
    IntKeyframeSet mIntKeyframeSet;
    
    public IntPropertyValuesHolder(String paramString, IntKeyframeSet paramIntKeyframeSet)
    {
      super(null);
      this.mValueType = Integer.TYPE;
      this.mKeyframeSet = paramIntKeyframeSet;
      this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
    }
    
    public IntPropertyValuesHolder(String paramString, int... paramVarArgs)
    {
      super(null);
      setIntValues(paramVarArgs);
    }
    
    void calculateValue(float paramFloat)
    {
      this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(paramFloat);
    }
    
    public IntPropertyValuesHolder clone()
    {
      IntPropertyValuesHolder localIntPropertyValuesHolder = (IntPropertyValuesHolder)super.clone();
      localIntPropertyValuesHolder.mIntKeyframeSet = ((IntKeyframeSet)localIntPropertyValuesHolder.mKeyframeSet);
      return localIntPropertyValuesHolder;
    }
    
    Object getAnimatedValue()
    {
      return Integer.valueOf(this.mIntAnimatedValue);
    }
    
    void setAnimatedValue(Object paramObject)
    {
      if (this.mSetter != null) {}
      try
      {
        this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
        this.mSetter.invoke(paramObject, this.mTmpValueArray);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
      }
    }
    
    public void setIntValues(int... paramVarArgs)
    {
      super.setIntValues(paramVarArgs);
      this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
    }
    
    void setupSetter(Class paramClass)
    {
      super.setupSetter(paramClass);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.animation.PropertyValuesHolder
 * JD-Core Version:    0.7.0.1
 */
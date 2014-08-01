package com.google.android.gms.dynamic;

import java.lang.reflect.Field;

public final class e<T>
  extends d.a
{
  private final T Mh;
  
  private e(T paramT)
  {
    this.Mh = paramT;
  }
  
  public static <T> T e(d paramd)
  {
    Object localObject1;
    if ((paramd instanceof e)) {
      localObject1 = ((e)paramd).Mh;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = paramd.asBinder();
      Object localObject2 = localObject1.getClass().getDeclaredFields();
      if (localObject2.length != 1) {
        break label111;
      }
      localObject2 = localObject2[0];
      if (!((Field)localObject2).isAccessible())
      {
        ((Field)localObject2).setAccessible(true);
        try
        {
          localObject1 = ((Field)localObject2).get(localObject1);
          localObject1 = localObject1;
        }
        catch (NullPointerException localNullPointerException)
        {
          throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", localIllegalArgumentException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
        }
      }
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    label111:
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
  
  public static <T> d h(T paramT)
  {
    return new e(paramT);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.e
 * JD-Core Version:    0.7.0.1
 */
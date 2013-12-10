package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  private static final AccessibilityNodeProviderImpl IMPL;
  private final Object mProvider;
  
  static
  {
    if (Build.VERSION.SDK_INT < 16) {
      IMPL = new AccessibilityNodeProviderStubImpl();
    } else {
      IMPL = new AccessibilityNodeProviderJellyBeanImpl();
    }
  }
  
  public AccessibilityNodeProviderCompat()
  {
    this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.mProvider = paramObject;
  }
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return this.mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  static class AccessibilityNodeProviderJellyBeanImpl
    extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
  {
    public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge()
      {
        public Object createAccessibilityNodeInfo(int paramAnonymousInt)
        {
          Object localObject = paramAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
          if (localObject != null) {
            localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo();
          } else {
            localObject = null;
          }
          return localObject;
        }
        
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          List localList = paramAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = localList.size();
          for (int j = 0;; j++)
          {
            if (j >= i) {
              return localArrayList;
            }
            localArrayList.add(((AccessibilityNodeInfoCompat)localList.get(j)).getInfo());
          }
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  static class AccessibilityNodeProviderStubImpl
    implements AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
  {
    public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      return null;
    }
  }
  
  static abstract interface AccessibilityNodeProviderImpl
  {
    public abstract Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class AccessibilityNodeProviderCompatKitKat
{
  public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge)
  {
    new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)AccessibilityNodeProviderCompatKitKat.this.createAccessibilityNodeInfo(paramAnonymousInt);
      }
      
      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return AccessibilityNodeProviderCompatKitKat.this.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
      }
      
      public AccessibilityNodeInfo findFocus(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)AccessibilityNodeProviderCompatKitKat.this.findFocus(paramAnonymousInt);
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return AccessibilityNodeProviderCompatKitKat.this.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
  
  static abstract interface AccessibilityNodeInfoBridge
  {
    public abstract Object createAccessibilityNodeInfo(int paramInt);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);
    
    public abstract Object findFocus(int paramInt);
    
    public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat
 * JD-Core Version:    0.7.0.1
 */
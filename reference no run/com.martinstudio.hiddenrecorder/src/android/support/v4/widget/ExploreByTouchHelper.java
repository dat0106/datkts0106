package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = View.class.getName();
  public static final int INVALID_ID = -2147483648;
  private int mFocusedVirtualViewId = -2147483648;
  private int mHoveredVirtualViewId = -2147483648;
  private final AccessibilityManager mManager;
  private ExploreByTouchNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  private final View mView;
  
  public ExploreByTouchHelper(View paramView)
  {
    if (paramView != null)
    {
      this.mView = paramView;
      this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      return;
    }
    throw new IllegalArgumentException("View may not be null");
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    boolean bool;
    if (!isAccessibilityFocused(paramInt))
    {
      bool = false;
    }
    else
    {
      this.mFocusedVirtualViewId = -2147483648;
      this.mView.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      bool = true;
    }
    return bool;
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent;
    switch (paramInt1)
    {
    default: 
      localAccessibilityEvent = createEventForChild(paramInt1, paramInt2);
      break;
    case -1: 
      localAccessibilityEvent = createEventForHost(paramInt2);
    }
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName(DEFAULT_CLASS_NAME);
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((!localAccessibilityEvent.getText().isEmpty()) || (localAccessibilityEvent.getContentDescription() != null))
    {
      localAccessibilityEvent.setPackageName(this.mView.getContext().getPackageName());
      AccessibilityEventCompat.asRecord(localAccessibilityEvent).setSource(this.mView, paramInt1);
      return localAccessibilityEvent;
    }
    throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.mView, localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private AccessibilityNodeInfoCompat createNode(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat;
    switch (paramInt)
    {
    default: 
      localAccessibilityNodeInfoCompat = createNodeForChild(paramInt);
      break;
    case -1: 
      localAccessibilityNodeInfoCompat = createNodeForHost();
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.setClassName(DEFAULT_CLASS_NAME);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() != null) || (localAccessibilityNodeInfoCompat.getContentDescription() != null))
    {
      localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
      if (!this.mTempParentRect.isEmpty())
      {
        int i = localAccessibilityNodeInfoCompat.getActions();
        if ((i & 0x40) == 0)
        {
          if ((i & 0x80) == 0)
          {
            localAccessibilityNodeInfoCompat.setPackageName(this.mView.getContext().getPackageName());
            localAccessibilityNodeInfoCompat.setSource(this.mView, paramInt);
            localAccessibilityNodeInfoCompat.setParent(this.mView);
            if (this.mFocusedVirtualViewId != paramInt)
            {
              localAccessibilityNodeInfoCompat.setAccessibilityFocused(false);
              localAccessibilityNodeInfoCompat.addAction(64);
            }
            else
            {
              localAccessibilityNodeInfoCompat.setAccessibilityFocused(true);
              localAccessibilityNodeInfoCompat.addAction(128);
            }
            if (intersectVisibleToUser(this.mTempParentRect))
            {
              localAccessibilityNodeInfoCompat.setVisibleToUser(true);
              localAccessibilityNodeInfoCompat.setBoundsInParent(this.mTempParentRect);
            }
            this.mView.getLocationOnScreen(this.mTempGlobalRect);
            int j = this.mTempGlobalRect[0];
            i = this.mTempGlobalRect[1];
            this.mTempScreenRect.set(this.mTempParentRect);
            this.mTempScreenRect.offset(j, i);
            localAccessibilityNodeInfoCompat.setBoundsInScreen(this.mTempScreenRect);
            return localAccessibilityNodeInfoCompat;
          }
          throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
  }
  
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mView);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, localAccessibilityNodeInfoCompat);
    Object localObject = new LinkedList();
    getVisibleVirtualViews((List)localObject);
    localObject = ((LinkedList)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return localAccessibilityNodeInfoCompat;
      }
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localAccessibilityNodeInfoCompat.addChild(this.mView, localInteger.intValue());
    }
  }
  
  private boolean intersectVisibleToUser(Rect paramRect)
  {
    boolean bool = false;
    if ((paramRect != null) && (!paramRect.isEmpty()) && (this.mView.getWindowVisibility() == 0)) {}
    for (Object localObject = this.mView.getParent();; localObject = ((View)localObject).getParent())
    {
      if (!(localObject instanceof View))
      {
        if ((localObject != null) && (this.mView.getLocalVisibleRect(this.mTempVisibleRect))) {
          bool = paramRect.intersect(this.mTempVisibleRect);
        }
      }
      else
      {
        localObject = (View)localObject;
        if ((ViewCompat.getAlpha((View)localObject) > 0.0F) && (((View)localObject).getVisibility() == 0)) {
          continue;
        }
      }
      return bool;
    }
  }
  
  private boolean isAccessibilityFocused(int paramInt)
  {
    boolean bool;
    if (this.mFocusedVirtualViewId != paramInt) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean manageFocusForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool;
    switch (paramInt2)
    {
    default: 
      bool = false;
      break;
    case 64: 
      bool = requestAccessibilityFocus(paramInt1);
      break;
    case 128: 
      bool = clearAccessibilityFocus(paramInt1);
    }
    return bool;
  }
  
  private boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = performActionForChild(paramInt1, paramInt2, paramBundle);
      break;
    case -1: 
      bool = performActionForHost(paramInt2, paramBundle);
    }
    return bool;
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool;
    switch (paramInt2)
    {
    default: 
      bool = onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
      break;
    case 64: 
    case 128: 
      bool = manageFocusForChild(paramInt1, paramInt2, paramBundle);
    }
    return bool;
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mView, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    boolean bool = false;
    if ((this.mManager.isEnabled()) && (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) && (!isAccessibilityFocused(paramInt)))
    {
      this.mFocusedVirtualViewId = paramInt;
      this.mView.invalidate();
      sendEventForVirtualView(paramInt, 32768);
      bool = true;
    }
    return bool;
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId != paramInt)
    {
      int i = this.mHoveredVirtualViewId;
      this.mHoveredVirtualViewId = paramInt;
      sendEventForVirtualView(paramInt, 128);
      sendEventForVirtualView(i, 256);
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 0;
    if ((this.mManager.isEnabled()) && (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager))) {
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        break;
      case 7: 
      case 9: 
        j = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        updateHoveredVirtualView(j);
        if (j == -2147483648) {
          i = 0;
        }
        j = i;
        break;
      case 10: 
        if (this.mFocusedVirtualViewId != -2147483648)
        {
          updateHoveredVirtualView(-2147483648);
          j = i;
        }
        break;
      }
    }
    return j;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new ExploreByTouchNodeProvider(null);
    }
    return this.mNodeProvider;
  }
  
  public int getFocusedVirtualView()
  {
    return this.mFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public void invalidateRoot()
  {
    invalidateVirtualView(-1);
  }
  
  public void invalidateVirtualView(int paramInt)
  {
    sendEventForVirtualView(paramInt, 2048);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected abstract void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent);
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  public boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool;
    if ((paramInt1 != -2147483648) && (this.mManager.isEnabled()))
    {
      ViewParent localViewParent = this.mView.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
        bool = ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mView, localAccessibilityEvent);
      }
    }
    return bool;
  }
  
  private class ExploreByTouchNodeProvider
    extends AccessibilityNodeProviderCompat
  {
    private ExploreByTouchNodeProvider() {}
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
    {
      return ExploreByTouchHelper.this.createNode(paramInt);
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return ExploreByTouchHelper.this.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */
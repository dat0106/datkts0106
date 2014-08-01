package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  FragmentActivity mActivity;
  boolean mCreatingLoader;
  final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.mWho = paramString;
    this.mActivity = paramFragmentActivity;
    this.mStarted = paramBoolean;
  }
  
  private LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.mCreatingLoader = true;
      LoaderInfo localLoaderInfo = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(localLoaderInfo);
      return localLoaderInfo;
    }
    finally
    {
      this.mCreatingLoader = false;
    }
  }
  
  private LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderInfo localLoaderInfo = new LoaderInfo(paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localLoaderInfo;
  }
  
  public void destroyLoader(int paramInt)
  {
    if (!this.mCreatingLoader)
    {
      if (DEBUG) {
        Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
      }
      int i = this.mLoaders.indexOfKey(paramInt);
      if (i >= 0)
      {
        LoaderInfo localLoaderInfo2 = (LoaderInfo)this.mLoaders.valueAt(i);
        this.mLoaders.removeAt(i);
        localLoaderInfo2.destroy();
      }
      int j = this.mInactiveLoaders.indexOfKey(paramInt);
      if (j >= 0)
      {
        LoaderInfo localLoaderInfo1 = (LoaderInfo)this.mInactiveLoaders.valueAt(j);
        this.mInactiveLoaders.removeAt(j);
        localLoaderInfo1.destroy();
      }
      if ((this.mActivity != null) && (!hasRunningLoaders())) {
        this.mActivity.mFragments.startPendingDeferredFragments();
      }
      return;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  void doDestroy()
  {
    if (!this.mRetaining) {
      if (DEBUG) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
    }
    for (int i = -1 + this.mLoaders.size();; i--)
    {
      if (i < 0)
      {
        this.mLoaders.clear();
        if (DEBUG) {
          Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (i = -1 + this.mInactiveLoaders.size();; i--)
        {
          if (i < 0)
          {
            this.mInactiveLoaders.clear();
            return;
          }
          ((LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy();
        }
      }
      ((LoaderInfo)this.mLoaders.valueAt(i)).destroy();
    }
  }
  
  void doReportNextStart()
  {
    for (int i = -1 + this.mLoaders.size();; i--)
    {
      if (i < 0) {
        return;
      }
      ((LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true;
    }
  }
  
  void doReportStart()
  {
    for (int i = -1 + this.mLoaders.size();; i--)
    {
      if (i < 0) {
        return;
      }
      ((LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
    }
  }
  
  void doRetain()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    if (this.mStarted)
    {
      this.mRetaining = true;
      this.mStarted = false;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).retain();
      }
    }
    RuntimeException localRuntimeException = new RuntimeException("here");
    localRuntimeException.fillInStackTrace();
    Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
  }
  
  void doStart()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    if (!this.mStarted)
    {
      this.mStarted = true;
      for (int i = -1 + this.mLoaders.size(); i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).start();
      }
    }
    RuntimeException localRuntimeException = new RuntimeException("here");
    localRuntimeException.fillInStackTrace();
    Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
  }
  
  void doStop()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (this.mStarted) {
      for (int i = -1 + this.mLoaders.size();; i--)
      {
        if (i < 0)
        {
          this.mStarted = false;
          break;
        }
        ((LoaderInfo)this.mLoaders.valueAt(i)).stop();
      }
    }
    RuntimeException localRuntimeException = new RuntimeException("here");
    localRuntimeException.fillInStackTrace();
    Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str;
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
    }
    LoaderInfo localLoaderInfo2;
    for (int j = 0;; localLoaderInfo2++)
    {
      if (j >= this.mLoaders.size())
      {
        if (this.mInactiveLoaders.size() > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Inactive Loaders:");
          str = paramString + "    ";
        }
        for (int i = 0;; i++)
        {
          if (i >= this.mInactiveLoaders.size()) {
            return;
          }
          localLoaderInfo2 = (LoaderInfo)this.mInactiveLoaders.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localLoaderInfo2.toString());
          localLoaderInfo2.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
      LoaderInfo localLoaderInfo1 = (LoaderInfo)this.mLoaders.valueAt(localLoaderInfo2);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(this.mLoaders.keyAt(localLoaderInfo2));
      paramPrintWriter.print(": ");
      paramPrintWriter.println(localLoaderInfo1.toString());
      localLoaderInfo1.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if (DEBUG) {
        Log.v("LoaderManager", "Finished Retaining in " + this);
      }
      this.mRetaining = false;
    }
    for (int i = -1 + this.mLoaders.size();; i--)
    {
      if (i < 0) {
        return;
      }
      ((LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
    }
  }
  
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (!this.mCreatingLoader)
    {
      Object localObject = (LoaderInfo)this.mLoaders.get(paramInt);
      if (localObject == null) {
        localObject = null;
      } else if (((LoaderInfo)localObject).mPendingLoader == null) {
        localObject = ((LoaderInfo)localObject).mLoader;
      } else {
        localObject = ((LoaderInfo)localObject).mPendingLoader.mLoader;
      }
      return localObject;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public boolean hasRunningLoaders()
  {
    boolean bool1 = false;
    int i = this.mLoaders.size();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return bool1;
      }
      LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(j);
      boolean bool2;
      if ((!localLoaderInfo.mStarted) || (localLoaderInfo.mDeliveredData)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      bool1 |= bool2;
    }
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (!this.mCreatingLoader)
    {
      LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
      if (DEBUG) {
        Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
      }
      if (localLoaderInfo != null)
      {
        if (DEBUG) {
          Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
        }
        localLoaderInfo.mCallbacks = paramLoaderCallbacks;
      }
      else
      {
        localLoaderInfo = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks);
        if (DEBUG) {
          Log.v("LoaderManager", "  Created new loader " + localLoaderInfo);
        }
      }
      if ((localLoaderInfo.mHaveData) && (this.mStarted)) {
        localLoaderInfo.callOnLoadFinished(localLoaderInfo.mLoader, localLoaderInfo.mData);
      }
      return localLoaderInfo.mLoader;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  void installLoader(LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted) {
      paramLoaderInfo.start();
    }
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (!this.mCreatingLoader)
    {
      Object localObject = (LoaderInfo)this.mLoaders.get(paramInt);
      if (DEBUG) {
        Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
      }
      if (localObject != null)
      {
        LoaderInfo localLoaderInfo = (LoaderInfo)this.mInactiveLoaders.get(paramInt);
        if (localLoaderInfo == null)
        {
          if (DEBUG) {
            Log.v("LoaderManager", "  Making last loader inactive: " + localObject);
          }
          ((LoaderInfo)localObject).mLoader.abandon();
          this.mInactiveLoaders.put(paramInt, localObject);
        }
        else if (!((LoaderInfo)localObject).mHaveData)
        {
          if (((LoaderInfo)localObject).mStarted)
          {
            if (((LoaderInfo)localObject).mPendingLoader != null)
            {
              if (DEBUG) {
                Log.v("LoaderManager", "  Removing pending loader: " + ((LoaderInfo)localObject).mPendingLoader);
              }
              ((LoaderInfo)localObject).mPendingLoader.destroy();
              ((LoaderInfo)localObject).mPendingLoader = null;
            }
            if (DEBUG) {
              Log.v("LoaderManager", "  Enqueuing as new pending loader");
            }
            ((LoaderInfo)localObject).mPendingLoader = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
            localObject = ((LoaderInfo)localObject).mPendingLoader.mLoader;
            break label358;
          }
          if (DEBUG) {
            Log.v("LoaderManager", "  Current loader is stopped; replacing");
          }
          this.mLoaders.put(paramInt, null);
          ((LoaderInfo)localObject).destroy();
        }
        else
        {
          if (DEBUG) {
            Log.v("LoaderManager", "  Removing last inactive loader: " + localObject);
          }
          localLoaderInfo.mDeliveredData = false;
          localLoaderInfo.destroy();
          ((LoaderInfo)localObject).mLoader.abandon();
          this.mInactiveLoaders.put(paramInt, localObject);
        }
      }
      localObject = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks).mLoader;
      label358:
      return localObject;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void updateActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
  
  final class LoaderInfo
    implements Loader.OnLoadCompleteListener<Object>
  {
    final Bundle mArgs;
    LoaderManager.LoaderCallbacks<Object> mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader<Object> mLoader;
    LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    
    public LoaderInfo(Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
    {
      this.mId = paramBundle;
      this.mArgs = paramLoaderCallbacks;
      Object localObject;
      this.mCallbacks = localObject;
    }
    
    void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
    {
      String str;
      if (this.mCallbacks != null)
      {
        str = null;
        if (LoaderManagerImpl.this.mActivity != null)
        {
          str = LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause;
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
        }
      }
      try
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  onLoadFinished in " + paramLoader + ": " + paramLoader.dataToString(paramObject));
        }
        this.mCallbacks.onLoadFinished(paramLoader, paramObject);
        if (LoaderManagerImpl.this.mActivity != null) {
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
        }
        this.mDeliveredData = true;
        return;
      }
      finally
      {
        if (LoaderManagerImpl.this.mActivity != null) {
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
        }
      }
    }
    
    void destroy()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Destroying: " + this);
      }
      this.mDestroyed = true;
      boolean bool = this.mDeliveredData;
      this.mDeliveredData = false;
      String str;
      if ((this.mCallbacks != null) && (this.mLoader != null) && (this.mHaveData) && (bool))
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Reseting: " + this);
        }
        str = null;
        if (LoaderManagerImpl.this.mActivity != null)
        {
          str = LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause;
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
        }
      }
      try
      {
        this.mCallbacks.onLoaderReset(this.mLoader);
        if (LoaderManagerImpl.this.mActivity != null) {
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
        }
        this.mCallbacks = null;
        this.mData = null;
        this.mHaveData = false;
        if (this.mLoader != null)
        {
          if (this.mListenerRegistered)
          {
            this.mListenerRegistered = false;
            this.mLoader.unregisterListener(this);
          }
          this.mLoader.reset();
        }
        if (this.mPendingLoader != null) {
          this.mPendingLoader.destroy();
        }
        return;
      }
      finally
      {
        if (LoaderManagerImpl.this.mActivity != null) {
          LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
        }
      }
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.mCallbacks);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.mLoader);
      if (this.mLoader != null) {
        this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      if ((this.mHaveData) || (this.mDeliveredData))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(this.mHaveData);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(this.mDeliveredData);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(this.mData);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.mStarted);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(this.mReportNextStart);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.mDestroyed);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(this.mRetaining);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(this.mRetainingStarted);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(this.mListenerRegistered);
      if (this.mPendingLoader != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(this.mPendingLoader);
        paramPrintWriter.println(":");
        this.mPendingLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    
    void finishRetain()
    {
      if (this.mRetaining)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Finished Retaining: " + this);
        }
        this.mRetaining = false;
        if ((this.mStarted != this.mRetainingStarted) && (!this.mStarted)) {
          stop();
        }
      }
      if ((this.mStarted) && (this.mHaveData) && (!this.mReportNextStart)) {
        callOnLoadFinished(this.mLoader, this.mData);
      }
    }
    
    public void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "onLoadComplete: " + this);
      }
      if (!this.mDestroyed)
      {
        if (LoaderManagerImpl.this.mLoaders.get(this.mId) == this)
        {
          LoaderInfo localLoaderInfo = this.mPendingLoader;
          if (localLoaderInfo == null)
          {
            if ((this.mData != paramObject) || (!this.mHaveData))
            {
              this.mData = paramObject;
              this.mHaveData = true;
              if (this.mStarted) {
                callOnLoadFinished(paramLoader, paramObject);
              }
            }
            localLoaderInfo = (LoaderInfo)LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
            if ((localLoaderInfo != null) && (localLoaderInfo != this))
            {
              localLoaderInfo.mDeliveredData = false;
              localLoaderInfo.destroy();
              LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
            }
            if ((LoaderManagerImpl.this.mActivity != null) && (!LoaderManagerImpl.this.hasRunningLoaders())) {
              LoaderManagerImpl.this.mActivity.mFragments.startPendingDeferredFragments();
            }
          }
          else
          {
            if (LoaderManagerImpl.DEBUG) {
              Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
            }
            this.mPendingLoader = null;
            LoaderManagerImpl.this.mLoaders.put(this.mId, null);
            destroy();
            LoaderManagerImpl.this.installLoader(localLoaderInfo);
          }
        }
        else if (LoaderManagerImpl.DEBUG)
        {
          Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
      }
      else if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
      }
    }
    
    void reportStart()
    {
      if ((this.mStarted) && (this.mReportNextStart))
      {
        this.mReportNextStart = false;
        if (this.mHaveData) {
          callOnLoadFinished(this.mLoader, this.mData);
        }
      }
    }
    
    void retain()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Retaining: " + this);
      }
      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
    }
    
    void start()
    {
      if ((!this.mRetaining) || (!this.mRetainingStarted))
      {
        if (!this.mStarted)
        {
          this.mStarted = true;
          if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Starting: " + this);
          }
          if ((this.mLoader == null) && (this.mCallbacks != null)) {
            this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
          }
          if (this.mLoader != null) {
            if ((!this.mLoader.getClass().isMemberClass()) || (Modifier.isStatic(this.mLoader.getClass().getModifiers())))
            {
              if (!this.mListenerRegistered)
              {
                this.mLoader.registerListener(this.mId, this);
                this.mListenerRegistered = true;
              }
              this.mLoader.startLoading();
            }
            else
            {
              throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
            }
          }
        }
      }
      else {
        this.mStarted = true;
      }
    }
    
    void stop()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Stopping: " + this);
      }
      this.mStarted = false;
      if ((!this.mRetaining) && (this.mLoader != null) && (this.mListenerRegistered))
      {
        this.mListenerRegistered = false;
        this.mLoader.unregisterListener(this);
        this.mLoader.stopLoading();
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mId);
      localStringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */
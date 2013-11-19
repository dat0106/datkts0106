

android.app.Activity
android.content.Context
android.content.res.Configuration
android.content.res.Resources
android.graphics.Bitmap
android.util.Log
android.util.LruCache
com.sonyericsson.extras.liveware.utils.Dbg
java.util.Locale

ImageCache

  DEFAULT_CLEAR_DISK_CACHE_ON_START = 
  DEFAULT_MEM_CACHE_ENABLED = 
  DEFAULT_MEM_CACHE_SIZE = 5242880
  TAG = "ImageCache"
  mCurrentLocale
  , mMemoryCache
  
  ImageCache, 
  
    init, 
  
  
  findOrCreateCache
  
    findOrCreateCache, ()
  
  
  findOrCreateCache, 
  
     = findOrCreateRetainFragmentgetFragmentManager()
     = getObject()
     (!=
    
      checkLocaleChange
    
    
    
       = , 
      setObject
    
    
  
  
  init, 
  
     (memoryCacheEnabled) {
      this.mMemoryCache = new LruCache(paramImageCacheParams.memCacheSize)
      {
        protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          return Utils.getBitmapSize(paramAnonymousBitmap);
        }
      };
    }
    this.mCurrentLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public void addBitmapToCache(String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramBitmap != null) && (this.mMemoryCache != null) && (this.mMemoryCache.get(paramString) == null)) {
      this.mMemoryCache.put(paramString, paramBitmap);
    }
  }
  
  public void checkLocaleChange(Context paramContext)
  {
    Locale localLocale = paramContext.getResources().getConfiguration().locale;
    if (!localLocale.equals(this.mCurrentLocale))
    {
      this.mCurrentLocale = localLocale;
      clearCaches();
    }
  }
  
  public void clearCaches()
  {
    if (this.mMemoryCache != null) {
      this.mMemoryCache.evictAll();
    }
  }
  
  public Bitmap getBitmapFromMemCache(String paramString)
  {
    Bitmap localBitmap;
    if (this.mMemoryCache != null)
    {
      localBitmap = (Bitmap)this.mMemoryCache.get(paramString);
      if (localBitmap != null) {}
    }
    else
    {
      return null;
    }
    if (Dbg.d()) {
      Log.d("ImageCache", "Memory cache hit");
    }
    return localBitmap;
  }
  
  public static class ImageCacheParams
  {
    public boolean clearDiskCacheOnStart = false;
    public int memCacheSize = 5242880;
    public boolean memoryCacheEnabled = true;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.example.android.bitmapfun.util.ImageCache
 * JD-Core Version:    0.7.0.1
 */
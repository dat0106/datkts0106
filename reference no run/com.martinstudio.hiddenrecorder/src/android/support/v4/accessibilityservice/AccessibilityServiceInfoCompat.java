

android.accessibilityservice.AccessibilityServiceInfo
android.content.pm.ResolveInfo
android.os.Build.VERSION

AccessibilityServiceInfoCompat

  CAPABILITY_CAN_FILTER_KEY_EVENTS = 8
  CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4
  CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2
  CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1
  DEFAULT = 1
  FEEDBACK_ALL_MASK = -1
  FEEDBACK_BRAILLE = 32
  FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2
  FLAG_REPORT_VIEW_IDS = 16
  FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8
  FLAG_REQUEST_FILTER_KEY_EVENTS = 32
  FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4
  IMPL
  
  static
  
     (SDK_INT<18
    
       (SDK_INT<14 {
        IMPL = ()
       {
        IMPL = ()
      
    
     {
      IMPL = ()
    
  
  
  capabilityToString
  
    
     (
    
    3: 
    5: 
    6: 
    7: 
    : 
       = "UNKNOWN"
      
    1: 
       = "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT"
      
    2: 
       = "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION"
      
    4: 
       = "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY"
      
    8: 
       = "CAPABILITY_CAN_FILTER_KEY_EVENTS"
    
    
  
  
  feedbackTypeToString
  
     = ()
    append"["
     (;;)
    
       (<=0
      
        append"]"
        toString()
      
       = 1numberOfTrailingZeros
      0xFFFFFFFF
       (length()>1 {
        append", "
      
       (
      
      : 
        
      1: 
        append"FEEDBACK_SPOKEN"
        
      2: 
        append"FEEDBACK_HAPTIC"
        
      4: 
        append"FEEDBACK_AUDIBLE"
        
      8: 
        append"FEEDBACK_VISUAL"
        
      16: 
        append"FEEDBACK_GENERIC"
      
    
  
  
  flagToString
  
    
     (
    
    : 
       = 
      
    1: 
       = "DEFAULT"
      
    2: 
       = "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS"
      
    4: 
       = "FLAG_REQUEST_TOUCH_EXPLORATION_MODE"
      
    8: 
       = "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY"
      
    16: 
       = "FLAG_REPORT_VIEW_IDS"
      
    32: 
       = "FLAG_REQUEST_FILTER_KEY_EVENTS"
    
    
  
  
  getCanRetrieveWindowContent
  
    IMPLgetCanRetrieveWindowContent
  
  
  getCapabilities
  
    IMPLgetCapabilities
  
  
  getDescription
  
    IMPLgetDescription
  
  
  getId
  
    IMPLgetId
  
  
  getResolveInfo
  
    IMPLgetResolveInfo
  
  
  getSettingsActivityName
  
    IMPLgetSettingsActivityName
  
  
  AccessibilityServiceInfoJellyBeanMr2
    
  
    getCapabilities
    
      getCapabilities
    
  
  
  AccessibilityServiceInfoIcsImpl
    
  
    getCanRetrieveWindowContent
    
      getCanRetrieveWindowContent
    
    
    getCapabilities
    
      
       (getCanRetrieveWindowContent {
         = 0
       {
         = 1
      
      
    
    
    getDescription
    
      getDescription
    
    
    getId
    
      getId
    
    
    getResolveInfo
    
      getResolveInfo
    
    
    getSettingsActivityName
    
      getSettingsActivityName
    
  
  
  AccessibilityServiceInfoStubImpl
    
  
    getCanRetrieveWindowContent
    
      
    
    
    getCapabilities
    
      0
    
    
    getDescription
    
      
    
    
    getId
    
      
    
    
    getResolveInfo
    
      
    
    
    getSettingsActivityName
    
      
    
  
  
  AccessibilityServiceInfoVersionImpl
  
    getCanRetrieveWindowContent
    
    getCapabilities
    
    getDescription
    
    getId
    
    getResolveInfo
    
    getSettingsActivityName
  



/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat
 * JD-Core Version:    0.7.0.1
 */
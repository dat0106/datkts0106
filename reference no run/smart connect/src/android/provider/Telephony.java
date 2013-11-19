

android.content.ContentResolver
android.content.ContentValues
android.content.Context
android.database.Cursor
android.net.Uri

Telephony

  Sms
    , 
  
    CONTENT_URI = parse"content://sms"
    DEFAULT_SORT_ORDER = "date DESC"
    
    addMessageToUri, , , , , , , 
    
      addMessageToUri, , , , , , , , -1L
    
    
    addMessageToUri, , , , , , , , 
    
       = 7
      put"address", 
       (!= {
        put"date", 
      
      
       ( {
         = valueOf0
       {
         = valueOf1
      
      put"read", 
      put"subject", 
      put"body", 
       ( {
        put"status", valueOf32
      
       (!=-1L {
        put"thread_id", valueOf
      
      insert, 
    
    
    isOutgoingFolder
    
      
       (==5==4==2==6 {
         = 
       {
         = 
      
      
    
    
    moveMessageToFolder, , , 
    
       = 
       (!=
      
         = 0
         = 0
         (
        
        : 
          
        2: 
        4: 
           = 1
          
        5: 
        6: 
           = 1
        
         = 3
        put"type", valueOf
         (==0
        
           (!=0 {
            put"read", valueOf1
          
        
         {
          put"read", valueOf0
        
        put"error_code", valueOf
         (1==getContentResolver()update, , ,  {
           = 
        
      
      
    
    
    query, []
    
      queryCONTENT_URI, , , , "date DESC"
    
    
    query, [], , 
    
       = CONTENT_URI
      
       (!= {
         = 
       {
         = "date DESC"
      
      query, , , , 
    
    
    Conversations
      , 
    
      CONTENT_URI = parse"content://sms/conversations"
      DEFAULT_SORT_ORDER = "date DESC"
      MESSAGE_COUNT = "msg_count"
      SNIPPET = "snippet"
    
    
    Draft
      , 
    
      CONTENT_URI = parse"content://sms/draft"
      DEFAULT_SORT_ORDER = "date DESC"
      
      addMessage, , , , 
      
        addMessageToUri, CONTENT_URI, , , , , , 
      
      
      saveMessage, , 
      
         = 1
         = 2
        put"body", 
        put"date", valueOfcurrentTimeMillis()
         (update, , , != {
           = 0
        
        
      
    
    
    Inbox
      , 
    
      CONTENT_URI = parse"content://sms/inbox"
      DEFAULT_SORT_ORDER = "date DESC"
      
      addMessage, , , , , 
      
        addMessageToUri, CONTENT_URI, , , , , , 
      
    
    
    Outbox
      , 
    
      CONTENT_URI = parse"content://sms/outbox"
      DEFAULT_SORT_ORDER = "date DESC"
      
      addMessage, , , , , , 
      
        addMessageToUri, CONTENT_URI, , , , , , , 
      
    
    
    Sent
      , 
    
      CONTENT_URI = parse"content://sms/sent"
      DEFAULT_SORT_ORDER = "date DESC"
      
      addMessage, , , , 
      
        addMessageToUri, CONTENT_URI, , , , , , 
      
    
  
  
  TextBasedSmsColumns
  
    ADDRESS = "address"
    BODY = "body"
    DATE = "date"
    DATE_SENT = "date_sent"
    ERROR_CODE = "error_code"
    LOCKED = "locked"
    MESSAGE_TYPE_ALL = 0
    MESSAGE_TYPE_DRAFT = 3
    MESSAGE_TYPE_FAILED = 5
    MESSAGE_TYPE_INBOX = 1
    MESSAGE_TYPE_OUTBOX = 4
    MESSAGE_TYPE_QUEUED = 6
    MESSAGE_TYPE_SENT = 2
    META_DATA = "meta_data"
    PERSON = "person"
    PERSON_ID = "person"
    PROTOCOL = "protocol"
    READ = "read"
    REPLY_PATH_PRESENT = "reply_path_present"
    SEEN = "seen"
    SERVICE_CENTER = "service_center"
    STATUS = "status"
    STATUS_COMPLETE = 0
    STATUS_FAILED = 64
    STATUS_NONE = -1
    STATUS_PENDING = 32
    SUBJECT = "subject"
    THREAD_ID = "thread_id"
    TYPE = "type"
  



/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.provider.Telephony
 * JD-Core Version:    0.7.0.1
 */
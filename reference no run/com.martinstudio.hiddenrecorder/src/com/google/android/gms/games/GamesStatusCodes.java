package com.google.android.gms.games;

public final class GamesStatusCodes
{
  public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
  public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
  public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
  public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
  public static final int STATUS_APP_MISCONFIGURED = 8;
  public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
  public static final int STATUS_GAME_NOT_FOUND = 9;
  public static final int STATUS_INTERNAL_ERROR = 1;
  public static final int STATUS_INTERRUPTED = 14;
  public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
  public static final int STATUS_LICENSE_CHECK_FAILED = 7;
  public static final int STATUS_MATCH_ERROR_ALREADY_REMATCHED = 6505;
  public static final int STATUS_MATCH_ERROR_INACTIVE_MATCH = 6501;
  public static final int STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS = 6504;
  public static final int STATUS_MATCH_ERROR_INVALID_MATCH_STATE = 6502;
  public static final int STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE = 6500;
  public static final int STATUS_MATCH_ERROR_LOCALLY_MODIFIED = 6507;
  public static final int STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION = 6503;
  public static final int STATUS_MATCH_NOT_FOUND = 6506;
  public static final int STATUS_MILESTONE_CLAIMED_PREVIOUSLY = 8000;
  public static final int STATUS_MILESTONE_CLAIM_FAILED = 8001;
  public static final int STATUS_MULTIPLAYER_DISABLED = 6003;
  public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
  public static final int STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 6002;
  public static final int STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION = 6004;
  public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
  public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
  public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
  public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
  public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
  public static final int STATUS_OK = 0;
  public static final int STATUS_OPERATION_IN_FLIGHT = 7007;
  public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
  public static final int STATUS_QUEST_NOT_STARTED = 8003;
  public static final int STATUS_QUEST_NO_LONGER_AVAILABLE = 8002;
  public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
  public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
  public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
  public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;
  public static final int STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS = 2000;
  public static final int STATUS_REQUEST_UPDATE_TOTAL_FAILURE = 2001;
  public static final int STATUS_SNAPSHOT_COMMIT_FAILED = 4003;
  public static final int STATUS_SNAPSHOT_CONFLICT = 4004;
  public static final int STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE = 4002;
  public static final int STATUS_SNAPSHOT_CREATION_FAILED = 4001;
  public static final int STATUS_SNAPSHOT_FOLDER_UNAVAILABLE = 4005;
  public static final int STATUS_SNAPSHOT_NOT_FOUND = 4000;
  public static final int STATUS_TIMEOUT = 15;
  
  public static String getStatusString(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Object[1];
      localObject[0] = Integer.valueOf(paramInt);
      localObject = String.format("Status code (%d) not found!", (Object[])localObject);
      break;
    case 0: 
      localObject = "STATUS_OK";
      break;
    case 1: 
      localObject = "STATUS_INTERNAL_ERROR";
      break;
    case 2: 
      localObject = "STATUS_CLIENT_RECONNECT_REQUIRED";
      break;
    case 3: 
      localObject = "STATUS_NETWORK_ERROR_STALE_DATA";
      break;
    case 4: 
      localObject = "STATUS_NETWORK_ERROR_NO_DATA";
      break;
    case 5: 
      localObject = "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
      break;
    case 6: 
      localObject = "STATUS_NETWORK_ERROR_OPERATION_FAILED";
      break;
    case 7: 
      localObject = "STATUS_LICENSE_CHECK_FAILED";
      break;
    case 8: 
      localObject = "STATUS_APP_MISCONFIGURED";
      break;
    case 9: 
      localObject = "STATUS_GAME_NOT_FOUND";
      break;
    case 14: 
      localObject = "STATUS_INTERRUPTED";
      break;
    case 15: 
      localObject = "STATUS_TIMEOUT";
      break;
    case 500: 
      localObject = "STATUS_RESOLVE_STALE_OR_NO_DATA";
      break;
    case 1000: 
      localObject = "STATUS_AUTH_ERROR_HARD";
      break;
    case 1001: 
      localObject = "STATUS_AUTH_ERROR_USER_RECOVERABLE";
      break;
    case 1002: 
      localObject = "STATUS_AUTH_ERROR_UNREGISTERED_CLIENT_ID";
      break;
    case 1003: 
      localObject = "STATUS_AUTH_ERROR_API_ACCESS_DENIED";
      break;
    case 1500: 
      localObject = "STATUS_PLAYER_OOB_REQUIRED";
      break;
    case 2000: 
      localObject = "STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS";
      break;
    case 2001: 
      localObject = "STATUS_REQUEST_UPDATE_TOTAL_FAILURE";
      break;
    case 3000: 
      localObject = "STATUS_ACHIEVEMENT_UNLOCK_FAILURE";
      break;
    case 3001: 
      localObject = "STATUS_ACHIEVEMENT_UNKNOWN";
      break;
    case 3002: 
      localObject = "STATUS_ACHIEVEMENT_NOT_INCREMENTAL";
      break;
    case 3003: 
      localObject = "STATUS_ACHIEVEMENT_UNLOCKED";
      break;
    case 4000: 
      localObject = "STATUS_SNAPSHOT_NOT_FOUND";
      break;
    case 4001: 
      localObject = "STATUS_SNAPSHOT_CREATION_FAILED";
      break;
    case 4002: 
      localObject = "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
      break;
    case 4003: 
      localObject = "STATUS_SNAPSHOT_COMMIT_FAILED";
      break;
    case 4004: 
      localObject = "STATUS_SNAPSHOT_CONFLICT";
      break;
    case 6000: 
      localObject = "STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
      break;
    case 6001: 
      localObject = "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
      break;
    case 6002: 
      localObject = "STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE";
      break;
    case 6003: 
      localObject = "STATUS_MULTIPLAYER_DISABLED";
      break;
    case 6500: 
      localObject = "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
      break;
    case 6501: 
      localObject = "STATUS_MATCH_ERROR_INACTIVE_MATCH";
      break;
    case 6503: 
      localObject = "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
      break;
    case 6504: 
      localObject = "STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS";
      break;
    case 6505: 
      localObject = "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
      break;
    case 6506: 
      localObject = "STATUS_MATCH_NOT_FOUND";
      break;
    case 6507: 
      localObject = "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
      break;
    case 7000: 
      localObject = "STATUS_REAL_TIME_CONNECTION_FAILED";
      break;
    case 7001: 
      localObject = "STATUS_REAL_TIME_MESSAGE_SEND_FAILED";
      break;
    case 7002: 
      localObject = "STATUS_INVALID_REAL_TIME_ROOM_ID";
      break;
    case 7003: 
      localObject = "STATUS_PARTICIPANT_NOT_CONNECTED";
      break;
    case 7004: 
      localObject = "STATUS_REAL_TIME_ROOM_NOT_JOINED";
      break;
    case 7005: 
      localObject = "STATUS_REAL_TIME_INACTIVE_ROOM";
      break;
    case 7006: 
      localObject = "STATUS_REAL_TIME_SERVICE_NOT_CONNECTED";
      break;
    case 7007: 
      localObject = "STATUS_OPERATION_IN_FLIGHT";
      break;
    case 8000: 
      localObject = "STATUS_MILESTONE_CLAIMED_PREVIOUSLY";
      break;
    case 8001: 
      localObject = "STATUS_MILESTONE_CLAIM_FAILED";
      break;
    case 8002: 
      localObject = "STATUS_QUEST_NO_LONGER_AVAILABLE";
      break;
    case 8003: 
      localObject = "STATUS_QUEST_NOT_STARTED";
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GamesStatusCodes
 * JD-Core Version:    0.7.0.1
 */
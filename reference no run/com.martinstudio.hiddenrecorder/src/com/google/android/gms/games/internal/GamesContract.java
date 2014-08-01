package com.google.android.gms.games.internal;

public final class GamesContract
{
  public static abstract interface SnapshotColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[16];
      arrayOfString[0] = "game_id";
      arrayOfString[1] = "owner_id";
      arrayOfString[2] = "external_snapshot_id";
      arrayOfString[3] = "drive_resolved_id_string";
      arrayOfString[4] = "drive_resource_id_string";
      arrayOfString[5] = "cover_icon_image_id";
      arrayOfString[6] = "cover_icon_image_uri";
      arrayOfString[7] = "cover_icon_image_url";
      arrayOfString[8] = "cover_icon_image_width";
      arrayOfString[9] = "cover_icon_image_height";
      arrayOfString[10] = "title";
      arrayOfString[11] = "description";
      arrayOfString[12] = "last_modified_timestamp";
      arrayOfString[13] = "duration";
      arrayOfString[14] = "unique_name";
      arrayOfString[15] = "visible";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface RequestSummaryColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "wish_count";
      arrayOfString[1] = "gift_count";
      arrayOfString[2] = "player_count";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface RequestRecipientsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "request_id";
      arrayOfString[1] = "player_id";
      arrayOfString[2] = "recipient_status";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface RequestsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "external_request_id";
      arrayOfString[1] = "game_id";
      arrayOfString[2] = "sender_id";
      arrayOfString[3] = "data";
      arrayOfString[4] = "type";
      arrayOfString[5] = "creation_timestamp";
      arrayOfString[6] = "expiration_timestamp";
      arrayOfString[7] = "status";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ParticipantsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[15];
      arrayOfString[0] = "match_id";
      arrayOfString[1] = "invitation_id";
      arrayOfString[2] = "external_participant_id";
      arrayOfString[3] = "player_id";
      arrayOfString[4] = "default_display_image_id";
      arrayOfString[5] = "default_display_image_url";
      arrayOfString[6] = "default_display_hi_res_image_id";
      arrayOfString[7] = "default_display_hi_res_image_url";
      arrayOfString[8] = "default_display_name";
      arrayOfString[9] = "player_status";
      arrayOfString[10] = "client_address";
      arrayOfString[11] = "result_type";
      arrayOfString[12] = "placing";
      arrayOfString[13] = "connected";
      arrayOfString[14] = "capabilities";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface NotificationsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[12];
      arrayOfString[0] = "notification_id";
      arrayOfString[1] = "game_id";
      arrayOfString[2] = "external_sub_id";
      arrayOfString[3] = "type";
      arrayOfString[4] = "image_id";
      arrayOfString[5] = "ticker";
      arrayOfString[6] = "title";
      arrayOfString[7] = "text";
      arrayOfString[8] = "coalesced_text";
      arrayOfString[9] = "timestamp";
      arrayOfString[10] = "acknowledged";
      arrayOfString[11] = "alert_level";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface MatchesPendingOpsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "client_context_id";
      arrayOfString[1] = "type";
      arrayOfString[2] = "external_game_id";
      arrayOfString[3] = "external_match_id";
      arrayOfString[4] = "pending_participant_id";
      arrayOfString[5] = "version";
      arrayOfString[6] = "is_turn";
      arrayOfString[7] = "results";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface MatchesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[24];
      arrayOfString[0] = "game_id";
      arrayOfString[1] = "external_match_id";
      arrayOfString[2] = "creator_external";
      arrayOfString[3] = "creation_timestamp";
      arrayOfString[4] = "last_updater_external";
      arrayOfString[5] = "last_updated_timestamp";
      arrayOfString[6] = "pending_participant_external";
      arrayOfString[7] = "data";
      arrayOfString[8] = "status";
      arrayOfString[9] = "description";
      arrayOfString[10] = "version";
      arrayOfString[11] = "variant";
      arrayOfString[12] = "notification_text";
      arrayOfString[13] = "user_match_status";
      arrayOfString[14] = "has_automatch_criteria";
      arrayOfString[15] = "automatch_min_players";
      arrayOfString[16] = "automatch_max_players";
      arrayOfString[17] = "automatch_bit_mask";
      arrayOfString[18] = "automatch_wait_estimate_sec";
      arrayOfString[19] = "rematch_id";
      arrayOfString[20] = "match_number";
      arrayOfString[21] = "previous_match_data";
      arrayOfString[22] = "upsync_required";
      arrayOfString[23] = "description_participant_id";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface InvitationsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[12];
      arrayOfString[0] = "game_id";
      arrayOfString[1] = "external_invitation_id";
      arrayOfString[2] = "external_inviter_id";
      arrayOfString[3] = "creation_timestamp";
      arrayOfString[4] = "last_modified_timestamp";
      arrayOfString[5] = "description";
      arrayOfString[6] = "type";
      arrayOfString[7] = "variant";
      arrayOfString[8] = "has_automatch_criteria";
      arrayOfString[9] = "automatch_min_players";
      arrayOfString[10] = "automatch_max_players";
      arrayOfString[11] = "inviter_in_circles";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ImagesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "url";
      arrayOfString[1] = "local";
      arrayOfString[2] = "filesize";
      arrayOfString[3] = "download_timestamp";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ContactSettingsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "mobile_notifications_enabled";
      arrayOfString[1] = "match_notifications_enabled";
      arrayOfString[2] = "quest_notifications_enabled";
      arrayOfString[3] = "request_notifications_enabled";
      arrayOfString[4] = "level_notifications_enabled";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface AclsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "specified_by_user";
      arrayOfString[1] = "pacl";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface LeaderboardScoresColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[13];
      arrayOfString[0] = "instance_id";
      arrayOfString[1] = "page_type";
      arrayOfString[2] = "player_id";
      arrayOfString[3] = "default_display_name";
      arrayOfString[4] = "default_display_image_id";
      arrayOfString[5] = "default_display_image_uri";
      arrayOfString[6] = "default_display_image_url";
      arrayOfString[7] = "rank";
      arrayOfString[8] = "display_rank";
      arrayOfString[9] = "raw_score";
      arrayOfString[10] = "display_score";
      arrayOfString[11] = "achieved_timestamp";
      arrayOfString[12] = "score_tag";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface PageType {}
  
  public static abstract interface LeaderboardInstancesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[12];
      arrayOfString[0] = "leaderboard_id";
      arrayOfString[1] = "timespan";
      arrayOfString[2] = "collection";
      arrayOfString[3] = "player_raw_score";
      arrayOfString[4] = "player_display_score";
      arrayOfString[5] = "player_rank";
      arrayOfString[6] = "player_display_rank";
      arrayOfString[7] = "player_score_tag";
      arrayOfString[8] = "total_scores";
      arrayOfString[9] = "top_page_token_next";
      arrayOfString[10] = "window_page_token_prev";
      arrayOfString[11] = "window_page_token_next";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface LeaderboardsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "game_id";
      arrayOfString[1] = "external_leaderboard_id";
      arrayOfString[2] = "name";
      arrayOfString[3] = "board_icon_image_id";
      arrayOfString[4] = "board_icon_image_uri";
      arrayOfString[5] = "board_icon_image_url";
      arrayOfString[6] = "sorting_rank";
      arrayOfString[7] = "score_order";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ClientContextsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "package_name";
      arrayOfString[1] = "package_uid";
      arrayOfString[2] = "account_name";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface AchievementPendingOpsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "client_context_id";
      arrayOfString[1] = "external_achievement_id";
      arrayOfString[2] = "achievement_type";
      arrayOfString[3] = "new_state";
      arrayOfString[4] = "steps_to_increment";
      arrayOfString[5] = "min_steps_to_set";
      arrayOfString[6] = "external_game_id";
      arrayOfString[7] = "external_player_id";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface AchievementInstancesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[7];
      arrayOfString[0] = "definition_id";
      arrayOfString[1] = "player_id";
      arrayOfString[2] = "state";
      arrayOfString[3] = "current_steps";
      arrayOfString[4] = "formatted_current_steps";
      arrayOfString[5] = "last_updated_timestamp";
      arrayOfString[6] = "instance_xp_value";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface AchievementDefinitionsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[16];
      arrayOfString[0] = "game_id";
      arrayOfString[1] = "external_achievement_id";
      arrayOfString[2] = "type";
      arrayOfString[3] = "name";
      arrayOfString[4] = "description";
      arrayOfString[5] = "unlocked_icon_image_id";
      arrayOfString[6] = "unlocked_icon_image_uri";
      arrayOfString[7] = "unlocked_icon_image_url";
      arrayOfString[8] = "revealed_icon_image_id";
      arrayOfString[9] = "revealed_icon_image_uri";
      arrayOfString[10] = "revealed_icon_image_url";
      arrayOfString[11] = "total_steps";
      arrayOfString[12] = "formatted_total_steps";
      arrayOfString[13] = "initial_state";
      arrayOfString[14] = "sorting_rank";
      arrayOfString[15] = "definition_xp_value";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface EventPendingOpsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "client_context_id";
      arrayOfString[1] = "instance_id";
      arrayOfString[2] = "window_start_time";
      arrayOfString[3] = "window_end_time";
      arrayOfString[4] = "increment";
      arrayOfString[5] = "request_id";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface EventInstancesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "definition_id";
      arrayOfString[1] = "player_id";
      arrayOfString[2] = "formatted_value";
      arrayOfString[3] = "last_updated_timestamp";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface EventDefinitionColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[9];
      arrayOfString[0] = "event_definitions_game_id";
      arrayOfString[1] = "external_event_id";
      arrayOfString[2] = "name";
      arrayOfString[3] = "description";
      arrayOfString[4] = "visibility";
      arrayOfString[5] = "icon_image_id";
      arrayOfString[6] = "icon_image_uri";
      arrayOfString[7] = "icon_image_url";
      arrayOfString[8] = "sorting_rank";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface AccountMetadataColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[11];
      arrayOfString[0] = "account_name";
      arrayOfString[1] = "external_player_id";
      arrayOfString[2] = "match_sync_token";
      arrayOfString[3] = "last_package_scan_timestamp";
      arrayOfString[4] = "quest_sync_token";
      arrayOfString[5] = "quest_sync_metadata_token";
      arrayOfString[6] = "request_sync_token";
      arrayOfString[7] = "xp_sync_token";
      arrayOfString[8] = "cover_photo_image_id";
      arrayOfString[9] = "cover_photo_image_uri";
      arrayOfString[10] = "cover_photo_image_url";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface QuestsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[18];
      arrayOfString[0] = "accepted_ts";
      arrayOfString[1] = "quest_banner_image_id";
      arrayOfString[2] = "quest_banner_image_uri";
      arrayOfString[3] = "quest_banner_image_url";
      arrayOfString[4] = "quest_description";
      arrayOfString[5] = "quest_end_ts";
      arrayOfString[6] = "external_quest_id";
      arrayOfString[7] = "game_id";
      arrayOfString[8] = "quest_icon_image_id";
      arrayOfString[9] = "quest_icon_image_uri";
      arrayOfString[10] = "quest_icon_image_url";
      arrayOfString[11] = "quest_last_updated_ts";
      arrayOfString[12] = "quest_name";
      arrayOfString[13] = "notified";
      arrayOfString[14] = "notification_ts";
      arrayOfString[15] = "quest_start_ts";
      arrayOfString[16] = "quest_state";
      arrayOfString[17] = "quest_type";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface MilestoneColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "completion_reward_data";
      arrayOfString[1] = "event_instance_id";
      arrayOfString[2] = "external_milestone_id";
      arrayOfString[3] = "initial_value";
      arrayOfString[4] = "quest_id";
      arrayOfString[5] = "milestones_sorting_rank";
      arrayOfString[6] = "milestone_state";
      arrayOfString[7] = "target_value";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ExperienceEventColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[10];
      arrayOfString[0] = "external_experience_id";
      arrayOfString[1] = "game_id";
      arrayOfString[2] = "created_timestamp";
      arrayOfString[3] = "current_xp";
      arrayOfString[4] = "xp_earned";
      arrayOfString[5] = "display_string";
      arrayOfString[6] = "type";
      arrayOfString[7] = "icon_id";
      arrayOfString[8] = "icon_url";
      arrayOfString[9] = "icon_uri";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface PlayersColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[28];
      arrayOfString[0] = "external_player_id";
      arrayOfString[1] = "profile_icon_image_id";
      arrayOfString[2] = "profile_hi_res_image_id";
      arrayOfString[3] = "profile_icon_image_uri";
      arrayOfString[4] = "profile_icon_image_url";
      arrayOfString[5] = "profile_hi_res_image_uri";
      arrayOfString[6] = "profile_hi_res_image_url";
      arrayOfString[7] = "profile_name";
      arrayOfString[8] = "last_updated";
      arrayOfString[9] = "is_in_circles";
      arrayOfString[10] = "has_all_public_acls";
      arrayOfString[11] = "current_xp_total";
      arrayOfString[12] = "current_level";
      arrayOfString[13] = "current_level_min_xp";
      arrayOfString[14] = "current_level_max_xp";
      arrayOfString[15] = "next_level";
      arrayOfString[16] = "next_level_max_xp";
      arrayOfString[17] = "last_level_up_timestamp";
      arrayOfString[18] = "player_title";
      arrayOfString[19] = "most_recent_external_game_id";
      arrayOfString[20] = "most_recent_game_name";
      arrayOfString[21] = "most_recent_activity_timestamp";
      arrayOfString[22] = "most_recent_game_icon_id";
      arrayOfString[23] = "most_recent_game_icon_uri";
      arrayOfString[24] = "most_recent_game_hi_res_id";
      arrayOfString[25] = "most_recent_game_hi_res_uri";
      arrayOfString[26] = "most_recent_game_featured_id";
      arrayOfString[27] = "most_recent_game_featured_uri";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface PlayerLevelColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "level_value";
      arrayOfString[1] = "level_min_xp";
      arrayOfString[2] = "level_max_xp";
      arrayOfString[3] = "version";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface ApplicationSessionColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "client_context_id";
      arrayOfString[1] = "end_time";
      arrayOfString[2] = "external_game_id";
      arrayOfString[3] = "session_id";
      arrayOfString[4] = "start_time";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface GameInstancesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[9];
      arrayOfString[0] = "instance_game_id";
      arrayOfString[1] = "real_time_support";
      arrayOfString[2] = "turn_based_support";
      arrayOfString[3] = "platform_type";
      arrayOfString[4] = "instance_display_name";
      arrayOfString[5] = "package_name";
      arrayOfString[6] = "piracy_check";
      arrayOfString[7] = "installed";
      arrayOfString[8] = "preferred";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface GameBadgesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "badge_game_id";
      arrayOfString[1] = "badge_type";
      arrayOfString[2] = "badge_title";
      arrayOfString[3] = "badge_description";
      arrayOfString[4] = "badge_icon_image_id";
      arrayOfString[5] = "badge_icon_image_uri";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface GameSearchSuggestionsColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "suggestion";
      HO = arrayOfString;
    }
  }
  
  public static abstract interface GamesColumns
  {
    public static final String[] HO;
    
    static
    {
      String[] arrayOfString = new String[27];
      arrayOfString[0] = "external_game_id";
      arrayOfString[1] = "display_name";
      arrayOfString[2] = "primary_category";
      arrayOfString[3] = "secondary_category";
      arrayOfString[4] = "developer_name";
      arrayOfString[5] = "game_description";
      arrayOfString[6] = "game_icon_image_id";
      arrayOfString[7] = "game_icon_image_uri";
      arrayOfString[8] = "game_icon_image_url";
      arrayOfString[9] = "game_hi_res_image_id";
      arrayOfString[10] = "game_hi_res_image_uri";
      arrayOfString[11] = "game_hi_res_image_url";
      arrayOfString[12] = "featured_image_id";
      arrayOfString[13] = "featured_image_uri";
      arrayOfString[14] = "featured_image_url";
      arrayOfString[15] = "play_enabled_game";
      arrayOfString[16] = "last_played_server_time";
      arrayOfString[17] = "last_connection_local_time";
      arrayOfString[18] = "last_synced_local_time";
      arrayOfString[19] = "metadata_version";
      arrayOfString[20] = "target_instance";
      arrayOfString[21] = "gameplay_acl_status";
      arrayOfString[22] = "achievement_total_count";
      arrayOfString[23] = "leaderboard_count";
      arrayOfString[24] = "muted";
      arrayOfString[25] = "identity_sharing_confirmed";
      arrayOfString[26] = "snapshots_enabled";
      HO = arrayOfString;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesContract
 * JD-Core Version:    0.7.0.1
 */
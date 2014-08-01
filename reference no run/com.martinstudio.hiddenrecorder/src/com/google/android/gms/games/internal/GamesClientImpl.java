package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.b;
import com.google.android.gms.internal.hc.d;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl
  extends hc<IGamesService>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final String NA;
  EventIncrementManager Nm = new EventIncrementManager()
  {
    public EventIncrementCache hs()
    {
      return new GamesClientImpl.GameClientEventIncrementCache(GamesClientImpl.this);
    }
  };
  private final String Nn;
  private final Map<String, RealTimeSocket> No;
  private PlayerEntity Np;
  private GameEntity Nq;
  private final PopupManager Nr;
  private boolean Ns = false;
  private boolean Nt = false;
  private int Nu;
  private final Binder Nv;
  private final long Nw;
  private final boolean Nx;
  private final int Ny;
  private final boolean Nz;
  private final String yN;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, int paramInt3, String paramString3)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Nn = paramString1;
    this.yN = ((String)hn.f(paramString2));
    this.Nv = new Binder();
    this.No = new HashMap();
    this.Nr = PopupManager.a(this, paramInt1);
    f(paramView);
    this.Nt = paramBoolean2;
    this.Nu = paramInt2;
    this.Nw = hashCode();
    this.Nx = paramBoolean1;
    this.Nz = paramBoolean3;
    this.Ny = paramInt3;
    this.NA = paramString3;
    registerConnectionCallbacks(this);
    registerConnectionFailedListener(this);
  }
  
  private Room Q(DataHolder paramDataHolder)
  {
    RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
    Room localRoom = null;
    try
    {
      if (localRoomBuffer.getCount() > 0) {
        localRoom = (Room)((Room)localRoomBuffer.get(0)).freeze();
      }
      return localRoom;
    }
    finally
    {
      localRoomBuffer.close();
    }
  }
  
  private RealTimeSocket aT(String paramString)
  {
    try
    {
      Object localObject = ((IGamesService)fo()).bb(paramString);
      LocalSocket localLocalSocket;
      if (localObject != null)
      {
        GamesLog.i("GamesClientImpl", "Created native libjingle socket.");
        localObject = new LibjingleNativeSocket((ParcelFileDescriptor)localObject);
        this.No.put(paramString, localObject);
      }
      else
      {
        GamesLog.i("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
        localObject = ((IGamesService)fo()).aW(paramString);
        if (localObject == null) {
          localObject = null;
        } else {
          localLocalSocket = new LocalSocket();
        }
      }
      RealTimeSocket localRealTimeSocket;
      return localRealTimeSocket;
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        localLocalSocket.connect(new LocalSocketAddress((String)localObject));
        localObject = new RealTimeSocketImpl(localLocalSocket, paramString);
        this.No.put(paramString, localObject);
      }
      catch (IOException localIOException)
      {
        GamesLog.k("GamesClientImpl", "connect() call failed on socket: " + localIOException.getMessage());
        localRealTimeSocket = null;
      }
      localRemoteException;
      GamesLog.k("GamesClientImpl", "Unable to create socket. Service died.");
      localObject = null;
    }
  }
  
  private void gT()
  {
    this.Np = null;
  }
  
  private void hq()
  {
    Iterator localIterator = this.No.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)localIterator.next();
      try
      {
        localRealTimeSocket.close();
      }
      catch (IOException localIOException)
      {
        GamesLog.b("GamesClientImpl", "IOException:", localIOException);
      }
    }
    this.No.clear();
  }
  
  public int a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      i = ((IGamesService)fo()).a(new RealTimeReliableMessageBinderCallbacks(paramReliableMessageSentCallback), paramArrayOfByte, paramString1, paramString2);
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    hn.b(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      i = ((IGamesService)fo()).b(paramArrayOfByte, paramString, paramArrayOfString);
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      localIntent = ((IGamesService)fo()).a(paramInt1, paramInt2, paramBoolean);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      localIntent = ((IGamesService)fo()).a(paramInt1, paramArrayOfByte, paramInt2, paramString);
      hn.b(paramBitmap, "Must provide a non null icon");
      localIntent.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
  }
  
  public Intent a(Room paramRoom, int paramInt)
  {
    try
    {
      localIntent = ((IGamesService)fo()).a((RoomEntity)paramRoom.freeze(), paramInt);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      localIntent = ((IGamesService)fo()).a(paramString, paramBoolean1, paramBoolean2, paramInt);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent a(int[] paramArrayOfInt)
  {
    try
    {
      localIntent = ((IGamesService)fo()).a(paramArrayOfInt);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null)) {
      this.Ns = paramBundle.getBoolean("show_welcome_popup");
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)fo()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Requests.LoadRequestsResult> paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestsLoadedBinderCallbacks(paramd), paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).a(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)fo()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramd), paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)fo()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramLeaderboardScoreBuffer.iv().iw(), paramInt1, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    try
    {
      ((IGamesService)fo()).a(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.iC(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Snapshots.CommitSnapshotResult> paramd, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    Contents localContents = paramSnapshot.getContents();
    hn.b(localContents, "Must provide a previously opened Snapshot");
    a locala = paramSnapshotMetadataChange.iI();
    if (locala != null) {
      locala.a(getContext().getCacheDir());
    }
    paramSnapshot.iH();
    try
    {
      ((IGamesService)fo()).a(new SnapshotCommittedBinderCallbacks(paramd), paramSnapshot.getMetadata().getSnapshotId(), paramSnapshotMetadataChange, localContents);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).a(new PlayersLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = new AchievementUpdatedBinderCallback(paramd)) {
      try
      {
        ((IGamesService)fo()).a((IGamesCallbacks)localObject, paramString, paramInt, this.Nr.hI(), this.Nr.hH());
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramString.equals("played_with")) {
      throw new IllegalArgumentException("Invalid player collection: " + paramString);
    }
    try
    {
      ((IGamesService)fo()).d(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      ((IGamesService)fo()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)fo()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramd), paramString, paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.SubmitScoreResult> paramd, String paramString1, long paramLong, String paramString2)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = new SubmitScoreBinderCallbacks(paramd)) {
      try
      {
        ((IGamesService)fo()).a((IGamesCallbacks)localObject, paramString1, paramLong, paramString2);
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)fo()).c(new TurnBasedMatchLeftBinderCallbacks(paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LoadPlayerScoreResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)fo()).a(new PlayerLeaderboardScoreLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Requests.LoadRequestsResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestsLoadedBinderCallbacks(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramString1.equals("played_with")) && (!paramString1.equals("circled"))) {
      throw new IllegalArgumentException("Invalid player collection: " + paramString1);
    }
    try
    {
      ((IGamesService)fo()).a(new PlayersLoadedBinderCallback(paramd), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Snapshots.OpenSnapshotResult> paramd, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
  {
    a locala = paramSnapshotMetadataChange.iI();
    if (locala != null) {
      locala.a(getContext().getCacheDir());
    }
    try
    {
      ((IGamesService)fo()).a(new SnapshotOpenedBinderCallbacks(paramd), paramString1, paramString2, paramSnapshotMetadataChange, paramContents);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).b(new LeaderboardsLoadedBinderCallback(paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).a(new QuestsLoadedBinderCallbacks(paramd), paramString1, paramString2, paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new QuestsLoadedBinderCallbacks(paramd), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Requests.UpdateRequestsResult> paramd, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestsUpdatedBinderCallbacks(paramd), paramString1, paramString2, paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).c(new LeaderboardsLoadedBinderCallback(paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)fo()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramd), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)fo()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramd), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Requests.SendRequestResult> paramd, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestSentBinderCallbacks(paramd), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).c(new PlayersLoadedBinderCallback(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Status> paramd, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((IGamesService)fo()).a(new ContactSettingsUpdatedBinderCallback(paramd), paramBoolean, paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Events.LoadEventsResult> paramd, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).a(new EventsLoadedBinderCallback(paramd), paramBoolean, paramVarArgs);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).a(new QuestsLoadedBinderCallbacks(paramd), paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).c(new PlayersLoadedBinderCallback(paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    try
    {
      InvitationReceivedBinderCallback localInvitationReceivedBinderCallback = new InvitationReceivedBinderCallback(paramOnInvitationReceivedListener);
      ((IGamesService)fo()).a(localInvitationReceivedBinderCallback, this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(RoomConfig paramRoomConfig)
  {
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)fo()).a(localRoomBinderCallbacks, this.Nv, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    try
    {
      ((IGamesService)fo()).c(new RoomBinderCallbacks(paramRoomUpdateListener), paramString);
      hq();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    try
    {
      MatchUpdateReceivedBinderCallback localMatchUpdateReceivedBinderCallback = new MatchUpdateReceivedBinderCallback(paramOnTurnBasedMatchUpdateReceivedListener);
      ((IGamesService)fo()).b(localMatchUpdateReceivedBinderCallback, this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(QuestUpdateListener paramQuestUpdateListener)
  {
    try
    {
      QuestUpdateBinderCallback localQuestUpdateBinderCallback = new QuestUpdateBinderCallback(paramQuestUpdateListener);
      ((IGamesService)fo()).d(localQuestUpdateBinderCallback, this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    try
    {
      RequestReceivedBinderCallback localRequestReceivedBinderCallback = new RequestReceivedBinderCallback(paramOnRequestReceivedListener);
      ((IGamesService)fo()).c(localRequestReceivedBinderCallback, this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(Snapshot paramSnapshot)
  {
    Contents localContents = paramSnapshot.getContents();
    hn.b(localContents, "Must provide a previously opened Snapshot");
    paramSnapshot.iH();
    try
    {
      ((IGamesService)fo()).a(localContents);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    String str = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Nx);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Nt);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Nu);
    localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Nz);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Ny);
    localBundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.NA);
    paramhj.a(parame, 5077000, getContext().getPackageName(), this.yN, fn(), this.Nn, this.Nr.hI(), str, localBundle);
  }
  
  public Intent aR(String paramString)
  {
    try
    {
      localIntent = ((IGamesService)fo()).aR(paramString);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public void aS(String paramString)
  {
    try
    {
      ((IGamesService)fo()).ba(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public Intent aU(String paramString)
  {
    try
    {
      localIntent = ((IGamesService)fo()).aU(paramString);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  protected IGamesService ah(IBinder paramIBinder)
  {
    return IGamesService.Stub.aj(paramIBinder);
  }
  
  public Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      localIntent = ((IGamesService)fo()).b(paramInt1, paramInt2, paramBoolean);
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public void b(a.d<Status> paramd)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).a(new SignOutCompleteBinderCallbacks(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).b(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = localObject)
    {
      try
      {
        ((IGamesService)fo()).a((IGamesCallbacks)localObject, paramString, this.Nr.hI(), this.Nr.hH());
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
      localObject = new AchievementUpdatedBinderCallback(paramd);
    }
  }
  
  public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = new AchievementUpdatedBinderCallback(paramd)) {
      try
      {
        ((IGamesService)fo()).b((IGamesCallbacks)localObject, paramString, paramInt, this.Nr.hI(), this.Nr.hH());
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).b(new LeaderboardScoresLoadedBinderCallback(paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Quests.ClaimMilestoneResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).f(new QuestMilestoneClaimBinderCallbacks(paramd, paramString2), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).b(new LeaderboardScoresLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Achievements.LoadAchievementsResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new AchievementsLoadedBinderCallback(paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Snapshots.OpenSnapshotResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).e(new SnapshotOpenedBinderCallbacks(paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Leaderboards.LeaderboardMetadataResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).b(new LeaderboardsLoadedBinderCallback(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Quests.LoadQuestsResult> paramd, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).a(new QuestsLoadedBinderCallbacks(paramd), paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestsUpdatedBinderCallbacks(paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(RoomConfig paramRoomConfig)
  {
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)fo()).a(localRoomBinderCallbacks, this.Nv, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  protected void b(String... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      if (k >= paramVarArgs.length)
      {
        if (j == 0)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = "https://www.googleapis.com/auth/games";
          hn.a(bool1, "Games APIs requires %s to function.", arrayOfObject2);
        }
        else
        {
          if (bool1) {
            bool2 = false;
          } else {
            bool2 = true;
          }
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = "https://www.googleapis.com/auth/games";
          arrayOfObject1[1] = "https://www.googleapis.com/auth/games.firstparty";
          hn.a(bool2, "Cannot have both %s and %s!", arrayOfObject1);
        }
        return;
      }
      String str = paramVarArgs[k];
      if (!str.equals("https://www.googleapis.com/auth/games"))
      {
        if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
          bool2 = true;
        }
      }
      else {
        int i = 1;
      }
      k++;
    }
  }
  
  protected String bp()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void c(a.d<Invitations.LoadInvitationsResult> paramd, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).a(new InvitationsLoadedBinderCallback(paramd), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).c(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Achievements.UpdateAchievementResult> paramd, String paramString)
  {
    if (paramd == null) {}
    for (Object localObject = null;; localObject = localObject)
    {
      try
      {
        ((IGamesService)fo()).b((IGamesCallbacks)localObject, paramString, this.Nr.hI(), this.Nr.hH());
      }
      catch (RemoteException localRemoteException)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
      localObject = new AchievementUpdatedBinderCallback(paramd);
    }
  }
  
  public void c(a.d<Players.LoadXpStreamResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).b(new PlayerXpStreamLoadedBinderCallback(paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).e(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)fo()).d(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Snapshots.LoadSnapshotsResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).c(new SnapshotsLoadedBinderCallbacks(paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).d(new LeaderboardsLoadedBinderCallback(paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Achievements.LoadAchievementsResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new AchievementsLoadedBinderCallback(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)fo()).b(new RequestsUpdatedBinderCallbacks(paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void cg(int paramInt)
  {
    this.Nr.setGravity(paramInt);
  }
  
  public void ch(int paramInt)
  {
    try
    {
      ((IGamesService)fo()).ch(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void connect()
  {
    gT();
    super.connect();
  }
  
  public int d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      i = ((IGamesService)fo()).b(paramArrayOfByte, paramString, null);
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public void d(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).e(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).l(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<Players.LoadXpStreamResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).c(new PlayerXpStreamLoadedBinderCallback(paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).f(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)fo()).e(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<Notifications.GameMuteStatusChangeResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).a(new GameMuteStatusChangedBinderCallback(paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void d(a.d<Events.LoadEventsResult> paramd, boolean paramBoolean)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).f(new EventsLoadedBinderCallback(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void disconnect()
  {
    this.Ns = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)fo();
      localIGamesService.hr();
      this.Nm.flush();
      localIGamesService.q(this.Nw);
      hq();
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void e(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).d(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void e(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).m(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void e(a.d<Invitations.LoadInvitationsResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).b(new InvitationsLoadedBinderCallback(paramd), paramString, paramInt, false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void e(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).c(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void e(a.d<Snapshots.LoadSnapshotsResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).d(new SnapshotsLoadedBinderCallbacks(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public Bundle ea()
  {
    try
    {
      localBundle = ((IGamesService)fo()).ea();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Bundle localBundle = null;
      }
    }
  }
  
  public void f(View paramView)
  {
    this.Nr.g(paramView);
  }
  
  public void f(a.d<GamesMetadata.LoadGamesResult> paramd)
  {
    try
    {
      ((IGamesService)fo()).d(new GamesLoadedBinderCallback(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void f(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).o(new TurnBasedMatchLeftBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void f(a.d<Requests.LoadRequestSummariesResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).a(new RequestSummariesLoadedBinderCallbacks(paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void f(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).b(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void f(a.d<Notifications.ContactSettingLoadResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)fo()).e(new ContactSettingsLoadedBinderCallback(paramd), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void g(a.d<Players.LoadOwnerCoverPhotoUrisResult> paramd)
  {
    try
    {
      ((IGamesService)fo()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void g(a.d<TurnBasedMultiplayer.CancelMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).n(new TurnBasedMatchCanceledBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void g(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)fo()).b(new PlayersLoadedBinderCallback(paramd), paramString, null, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public String gU()
  {
    try
    {
      str = ((IGamesService)fo()).gU();
      str = str;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        String str = null;
      }
    }
    return str;
  }
  
  public String gV()
  {
    try
    {
      str = ((IGamesService)fo()).gV();
      str = str;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        String str = null;
      }
    }
    return str;
  }
  
  /* Error */
  public com.google.android.gms.games.Player gW()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1245	com/google/android/gms/games/internal/GamesClientImpl:ci	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 568	com/google/android/gms/games/internal/GamesClientImpl:Np	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1247	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 494	com/google/android/gms/games/internal/GamesClientImpl:fo	()Landroid/os/IInterface;
    //   23: checkcast 496	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1251 1 0
    //   31: invokespecial 1252	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 1253	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_2
    //   44: iconst_0
    //   45: invokevirtual 1256	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1259 1 0
    //   53: checkcast 1261	com/google/android/gms/games/PlayerEntity
    //   56: putfield 568	com/google/android/gms/games/internal/GamesClientImpl:Np	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_2
    //   60: invokevirtual 1262	com/google/android/gms/games/PlayerBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 568	com/google/android/gms/games/internal/GamesClientImpl:Np	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_1
    //   71: aload_2
    //   72: invokevirtual 1262	com/google/android/gms/games/PlayerBuffer:close	()V
    //   75: aload_1
    //   76: athrow
    //   77: pop
    //   78: ldc_w 502
    //   81: ldc_w 609
    //   84: invokestatic 612	com/google/android/gms/games/internal/GamesLog:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	GamesClientImpl
    //   10	2	1	localPlayerEntity	PlayerEntity
    //   70	6	1	localObject1	Object
    //   90	4	1	localObject2	Object
    //   34	38	2	localPlayerBuffer	PlayerBuffer
    //   77	1	5	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	90	finally
    //   15	35	90	finally
    //   59	63	90	finally
    //   63	65	90	finally
    //   71	77	90	finally
    //   78	93	90	finally
  }
  
  /* Error */
  public com.google.android.gms.games.Game gX()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1245	com/google/android/gms/games/internal/GamesClientImpl:ci	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 1266	com/google/android/gms/games/internal/GamesClientImpl:Nq	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1268	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 494	com/google/android/gms/games/internal/GamesClientImpl:fo	()Landroid/os/IInterface;
    //   23: checkcast 496	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1271 1 0
    //   31: invokespecial 1272	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1273	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1276	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1279 1 0
    //   53: checkcast 1281	com/google/android/gms/games/GameEntity
    //   56: putfield 1266	com/google/android/gms/games/internal/GamesClientImpl:Nq	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 1282	com/google/android/gms/games/GameBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 1266	com/google/android/gms/games/internal/GamesClientImpl:Nq	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1282	com/google/android/gms/games/GameBuffer:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: pop
    //   78: ldc_w 502
    //   81: ldc_w 609
    //   84: invokestatic 612	com/google/android/gms/games/internal/GamesLog:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   90	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    //   77	1	4	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	90	finally
    //   15	35	90	finally
    //   59	63	90	finally
    //   63	65	90	finally
    //   71	77	90	finally
    //   78	93	90	finally
  }
  
  public Intent gY()
  {
    try
    {
      localIntent = ((IGamesService)fo()).gY();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent gZ()
  {
    try
    {
      localIntent = ((IGamesService)fo()).gZ();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public void h(a.d<Acls.LoadAclResult> paramd)
  {
    try
    {
      ((IGamesService)fo()).h(new NotifyAclLoadedBinderCallback(paramd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void h(a.d<TurnBasedMultiplayer.LoadMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).p(new TurnBasedMatchLoadedBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public Intent ha()
  {
    try
    {
      localIntent = ((IGamesService)fo()).ha();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent hb()
  {
    try
    {
      localIntent = ((IGamesService)fo()).hb();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public void hc()
  {
    try
    {
      ((IGamesService)fo()).r(this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void hd()
  {
    try
    {
      ((IGamesService)fo()).s(this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void he()
  {
    try
    {
      ((IGamesService)fo()).u(this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void hf()
  {
    try
    {
      ((IGamesService)fo()).t(this.Nw);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public Intent hg()
  {
    try
    {
      localIntent = ((IGamesService)fo()).hg();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public Intent hh()
  {
    try
    {
      localIntent = ((IGamesService)fo()).hh();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public int hi()
  {
    try
    {
      i = ((IGamesService)fo()).hi();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = 4368;
      }
    }
    return i;
  }
  
  public String hj()
  {
    try
    {
      str = ((IGamesService)fo()).hj();
      str = str;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        String str = null;
      }
    }
    return str;
  }
  
  public int hk()
  {
    try
    {
      i = ((IGamesService)fo()).hk();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public Intent hl()
  {
    try
    {
      localIntent = ((IGamesService)fo()).hl();
      localIntent = localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        Intent localIntent = null;
      }
    }
    return localIntent;
  }
  
  public int hm()
  {
    try
    {
      i = ((IGamesService)fo()).hm();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public int hn()
  {
    try
    {
      i = ((IGamesService)fo()).hn();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public int ho()
  {
    try
    {
      i = ((IGamesService)fo()).ho();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public int hp()
  {
    try
    {
      i = ((IGamesService)fo()).hp();
      i = i;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
        int i = -1;
      }
    }
    return i;
  }
  
  public void hr()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)fo()).hr();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  @Deprecated
  public void i(a.d<Notifications.ContactSettingLoadResult> paramd)
  {
    try
    {
      ((IGamesService)fo()).e(new ContactSettingsLoadedBinderCallback(paramd), false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void i(a.d<Quests.AcceptQuestResult> paramd, String paramString)
  {
    try
    {
      this.Nm.flush();
      ((IGamesService)fo()).u(new QuestAcceptedBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void j(a.d<Notifications.InboxCountResult> paramd)
  {
    try
    {
      ((IGamesService)fo()).t(new InboxCountsLoadedBinderCallback(paramd), null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void j(a.d<Snapshots.DeleteSnapshotResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).r(new SnapshotDeletedBinderCallbacks(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void k(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).e(new ExtendedGamesLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public RealTimeSocket l(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (ParticipantUtils.bn(paramString2)))
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)this.No.get(paramString2);
      if ((localRealTimeSocket == null) || (localRealTimeSocket.isClosed())) {
        localRealTimeSocket = aT(paramString2);
      }
      return localRealTimeSocket;
    }
    throw new IllegalArgumentException("Bad participant ID");
  }
  
  public void l(a.d<GamesMetadata.LoadGameInstancesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).f(new GameInstancesLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void l(String paramString, int paramInt)
  {
    this.Nm.l(paramString, paramInt);
  }
  
  public void m(a.d<GamesMetadata.LoadGameSearchSuggestionsResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).q(new GameSearchSuggestionsLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void m(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).m(paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void n(a.d<Players.LoadXpForGameCategoriesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).s(new PlayerXpForGameCategoriesLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void n(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)fo()).n(paramString, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void o(a.d<Invitations.LoadInvitationsResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).k(new InvitationsLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (this.Ns)
    {
      this.Nr.hG();
      this.Ns = false;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Ns = false;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void p(a.d<Status> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).j(new NotifyAclUpdatedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void q(a.d<Notifications.GameMuteStatusLoadResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)fo()).i(new GameMuteStatusLoadedBinderCallback(paramd), paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  private static final class DeleteSnapshotResultImpl
    implements Snapshots.DeleteSnapshotResult
  {
    private final String NH;
    private final Status yw;
    
    DeleteSnapshotResultImpl(int paramInt, String paramString)
    {
      this.yw = new Status(paramInt);
      this.NH = paramString;
    }
    
    public String getSnapshotId()
    {
      return this.NH;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class CommitSnapshotResultImpl
    extends b
    implements Snapshots.CommitSnapshotResult
  {
    private final SnapshotMetadata NG;
    
    /* Error */
    CommitSnapshotResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 22	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
      //   25: dup
      //   26: aload_2
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   31: invokespecial 31	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:NG	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   37: aload_2
      //   38: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:close	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:NG	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   47: goto -10 -> 37
      //   50: astore_3
      //   51: aload_2
      //   52: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:close	()V
      //   55: aload_3
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	CommitSnapshotResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   13	39	2	localSnapshotMetadataBuffer	SnapshotMetadataBuffer
      //   50	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public SnapshotMetadata getSnapshotMetadata()
    {
      return this.NG;
    }
  }
  
  private static final class OpenSnapshotResultImpl
    extends b
    implements Snapshots.OpenSnapshotResult
  {
    private final Snapshot Oj;
    private final String Ok;
    private final Snapshot Ol;
    private final Contents Om;
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, Contents paramContents)
    {
      this(paramDataHolder, null, paramContents, null, null);
    }
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      super();
      SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
      for (;;)
      {
        try
        {
          if (localSnapshotMetadataBuffer.getCount() == 0)
          {
            this.Oj = null;
            this.Ol = null;
            localSnapshotMetadataBuffer.close();
            this.Ok = paramString;
            this.Om = paramContents3;
            return;
          }
          if (localSnapshotMetadataBuffer.getCount() != i) {
            break label127;
          }
          if (paramDataHolder.getStatusCode() != 4004)
          {
            gy.A(i);
            this.Oj = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), paramContents1);
            this.Ol = null;
            continue;
          }
          int j = 0;
        }
        finally
        {
          localSnapshotMetadataBuffer.close();
        }
        continue;
        label127:
        this.Oj = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), paramContents1);
        this.Ol = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), paramContents2);
      }
    }
    
    public String getConflictId()
    {
      return this.Ok;
    }
    
    public Snapshot getConflictingSnapshot()
    {
      return this.Ol;
    }
    
    public Contents getResolutionContents()
    {
      return this.Om;
    }
    
    public Snapshot getSnapshot()
    {
      return this.Oj;
    }
  }
  
  private static final class LoadSnapshotsResultImpl
    extends b
    implements Snapshots.LoadSnapshotsResult
  {
    LoadSnapshotsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
    
    public SnapshotMetadataBuffer getSnapshots()
    {
      return new SnapshotMetadataBuffer(this.DD);
    }
  }
  
  private static final class LoadQuestsResultImpl
    extends b
    implements Quests.LoadQuestsResult
  {
    private final DataHolder DD;
    
    LoadQuestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.DD = paramDataHolder;
    }
    
    public QuestBuffer getQuests()
    {
      return new QuestBuffer(this.DD);
    }
  }
  
  private static final class ClaimMilestoneResultImpl
    extends b
    implements Quests.ClaimMilestoneResult
  {
    private final Quest ND;
    private final Milestone NF;
    
    /* Error */
    ClaimMilestoneResultImpl(DataHolder paramDataHolder, String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 4
      //   3: aload_0
      //   4: aload_1
      //   5: invokespecial 18	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   8: new 20	com/google/android/gms/games/quest/QuestBuffer
      //   11: dup
      //   12: aload_1
      //   13: invokespecial 21	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   16: astore_3
      //   17: aload_3
      //   18: invokevirtual 25	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   21: ifle +112 -> 133
      //   24: aload_0
      //   25: new 27	com/google/android/gms/games/quest/QuestEntity
      //   28: dup
      //   29: aload_3
      //   30: iconst_0
      //   31: invokevirtual 31	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   34: checkcast 33	com/google/android/gms/games/quest/Quest
      //   37: invokespecial 36	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   40: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:ND	Lcom/google/android/gms/games/quest/Quest;
      //   43: aload_0
      //   44: getfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:ND	Lcom/google/android/gms/games/quest/Quest;
      //   47: invokeinterface 42 1 0
      //   52: astore 6
      //   54: aload 6
      //   56: invokeinterface 47 1 0
      //   61: istore 5
      //   63: iload 4
      //   65: iload 5
      //   67: if_icmpge +54 -> 121
      //   70: aload 6
      //   72: iload 4
      //   74: invokeinterface 48 2 0
      //   79: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   82: invokeinterface 54 1 0
      //   87: aload_2
      //   88: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   91: ifeq +24 -> 115
      //   94: aload_0
      //   95: aload 6
      //   97: iload 4
      //   99: invokeinterface 48 2 0
      //   104: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   107: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:NF	Lcom/google/android/gms/games/quest/Milestone;
      //   110: aload_3
      //   111: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:close	()V
      //   114: return
      //   115: iinc 4 1
      //   118: goto -55 -> 63
      //   121: aload_0
      //   122: aconst_null
      //   123: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:NF	Lcom/google/android/gms/games/quest/Milestone;
      //   126: aload_3
      //   127: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:close	()V
      //   130: goto -16 -> 114
      //   133: aload_0
      //   134: aconst_null
      //   135: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:NF	Lcom/google/android/gms/games/quest/Milestone;
      //   138: aload_0
      //   139: aconst_null
      //   140: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:ND	Lcom/google/android/gms/games/quest/Quest;
      //   143: goto -17 -> 126
      //   146: astore 4
      //   148: aload_3
      //   149: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:close	()V
      //   152: aload 4
      //   154: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	155	0	this	ClaimMilestoneResultImpl
      //   0	155	1	paramDataHolder	DataHolder
      //   0	155	2	paramString	String
      //   16	133	3	localQuestBuffer	QuestBuffer
      //   1	115	4	i	int
      //   146	7	4	localObject	Object
      //   61	7	5	j	int
      //   52	44	6	localList	List
      // Exception table:
      //   from	to	target	type
      //   17	110	146	finally
      //   121	126	146	finally
      //   133	143	146	finally
    }
    
    public Milestone getMilestone()
    {
      return this.NF;
    }
    
    public Quest getQuest()
    {
      return this.ND;
    }
  }
  
  private static final class AcceptQuestResultImpl
    extends b
    implements Quests.AcceptQuestResult
  {
    private final Quest ND;
    
    /* Error */
    AcceptQuestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/quest/QuestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   18: ifle +27 -> 45
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/quest/QuestEntity
      //   25: dup
      //   26: aload_2
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   31: checkcast 30	com/google/android/gms/games/quest/Quest
      //   34: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   37: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:ND	Lcom/google/android/gms/games/quest/Quest;
      //   40: aload_2
      //   41: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:close	()V
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:ND	Lcom/google/android/gms/games/quest/Quest;
      //   50: goto -10 -> 40
      //   53: astore_3
      //   54: aload_2
      //   55: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:close	()V
      //   58: aload_3
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	AcceptQuestResultImpl
      //   0	60	1	paramDataHolder	DataHolder
      //   13	42	2	localQuestBuffer	QuestBuffer
      //   53	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	40	53	finally
      //   45	50	53	finally
    }
    
    public Quest getQuest()
    {
      return this.ND;
    }
  }
  
  private static final class LoadRequestSummariesResultImpl
    extends b
    implements Requests.LoadRequestSummariesResult
  {
    LoadRequestSummariesResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadRequestsResultImpl
    implements Requests.LoadRequestsResult
  {
    private final Bundle NZ;
    private final Status yw;
    
    LoadRequestsResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.yw = paramStatus;
      this.NZ = paramBundle;
    }
    
    public GameRequestBuffer getRequests(int paramInt)
    {
      Object localObject = RequestType.cm(paramInt);
      if (this.NZ.containsKey((String)localObject)) {
        localObject = new GameRequestBuffer((DataHolder)this.NZ.get((String)localObject));
      } else {
        localObject = null;
      }
      return localObject;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public void release()
    {
      Iterator localIterator = this.NZ.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        Object localObject = (String)localIterator.next();
        localObject = (DataHolder)this.NZ.getParcelable((String)localObject);
        if (localObject != null) {
          ((DataHolder)localObject).close();
        }
      }
    }
  }
  
  private static final class UpdateRequestsResultImpl
    extends b
    implements Requests.UpdateRequestsResult
  {
    private final RequestUpdateOutcomes OR;
    
    UpdateRequestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.OR = RequestUpdateOutcomes.U(paramDataHolder);
    }
    
    public Set<String> getRequestIds()
    {
      return this.OR.getRequestIds();
    }
    
    public int getRequestOutcome(String paramString)
    {
      return this.OR.getRequestOutcome(paramString);
    }
  }
  
  private static final class SendRequestResultImpl
    extends b
    implements Requests.SendRequestResult
  {
    private final GameRequest Ox;
    
    /* Error */
    SendRequestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/request/GameRequestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_3
      //   14: aload_3
      //   15: invokevirtual 22	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_3
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   30: invokeinterface 32 1 0
      //   35: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   38: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Ox	Lcom/google/android/gms/games/request/GameRequest;
      //   41: aload_3
      //   42: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:close	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Ox	Lcom/google/android/gms/games/request/GameRequest;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_3
      //   56: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:close	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SendRequestResultImpl
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      //   13	43	3	localGameRequestBuffer	GameRequestBuffer
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
  }
  
  private static final class InboxCountResultImpl
    implements Notifications.InboxCountResult
  {
    private final Bundle NK;
    private final Status yw;
    
    InboxCountResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.yw = paramStatus;
      this.NK = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class ContactSettingLoadResultImpl
    extends b
    implements Notifications.ContactSettingLoadResult
  {
    ContactSettingLoadResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class GameMuteStatusLoadResultImpl
    implements Notifications.GameMuteStatusLoadResult
  {
    private final String NI;
    private final boolean NJ;
    private final Status yw;
    
    /* Error */
    public GameMuteStatusLoadResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 20	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: new 22	com/google/android/gms/common/api/Status
      //   8: dup
      //   9: aload_1
      //   10: invokevirtual 28	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   13: invokespecial 31	com/google/android/gms/common/api/Status:<init>	(I)V
      //   16: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:yw	Lcom/google/android/gms/common/api/Status;
      //   19: aload_1
      //   20: invokevirtual 36	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   23: ifle +32 -> 55
      //   26: aload_0
      //   27: aload_1
      //   28: ldc 38
      //   30: iconst_0
      //   31: iconst_0
      //   32: invokevirtual 42	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
      //   35: putfield 44	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:NI	Ljava/lang/String;
      //   38: aload_0
      //   39: aload_1
      //   40: ldc 46
      //   42: iconst_0
      //   43: iconst_0
      //   44: invokevirtual 50	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   47: putfield 52	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:NJ	Z
      //   50: aload_1
      //   51: invokevirtual 55	com/google/android/gms/common/data/DataHolder:close	()V
      //   54: return
      //   55: aload_0
      //   56: aconst_null
      //   57: putfield 44	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:NI	Ljava/lang/String;
      //   60: aload_0
      //   61: iconst_0
      //   62: putfield 52	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:NJ	Z
      //   65: goto -15 -> 50
      //   68: astore_2
      //   69: aload_1
      //   70: invokevirtual 55	com/google/android/gms/common/data/DataHolder:close	()V
      //   73: aload_2
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	GameMuteStatusLoadResultImpl
      //   0	75	1	paramDataHolder	DataHolder
      //   68	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	50	68	finally
      //   55	65	68	finally
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class GameMuteStatusChangeResultImpl
    implements Notifications.GameMuteStatusChangeResult
  {
    private final String NI;
    private final boolean NJ;
    private final Status yw;
    
    public GameMuteStatusChangeResultImpl(int paramInt, String paramString, boolean paramBoolean)
    {
      this.yw = new Status(paramInt);
      this.NI = paramString;
      this.NJ = paramBoolean;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class LoadAclResultImpl
    extends b
    implements Acls.LoadAclResult
  {
    LoadAclResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class CancelMatchResultImpl
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final String NE;
    private final Status yw;
    
    CancelMatchResultImpl(Status paramStatus, String paramString)
    {
      this.yw = paramStatus;
      this.NE = paramString;
    }
    
    public String getMatchId()
    {
      return this.NE;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class LeaveMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    LeaveMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class UpdateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    UpdateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class InitiateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    InitiateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    LoadMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static abstract class TurnBasedMatchResult
    extends b
  {
    final TurnBasedMatch Oh;
    
    /* Error */
    TurnBasedMatchResult(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 15	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 16	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 20	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_2
      //   23: iconst_0
      //   24: invokevirtual 24	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   30: invokeinterface 30 1 0
      //   35: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   38: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:Oh	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   41: aload_2
      //   42: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:Oh	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   51: goto -10 -> 41
      //   54: astore_3
      //   55: aload_2
      //   56: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
      //   59: aload_3
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	TurnBasedMatchResult
      //   0	61	1	paramDataHolder	DataHolder
      //   13	43	2	localTurnBasedMatchBuffer	TurnBasedMatchBuffer
      //   54	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.Oh;
    }
  }
  
  private static final class SubmitScoreResultImpl
    extends b
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData OJ;
    
    public SubmitScoreResultImpl(DataHolder paramDataHolder)
    {
      super();
      try
      {
        this.OJ = new ScoreSubmissionData(paramDataHolder);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.OJ;
    }
  }
  
  private static final class LoadOwnerCoverPhotoUrisResultImpl
    implements Players.LoadOwnerCoverPhotoUrisResult
  {
    private final Bundle HJ;
    private final Status yw;
    
    LoadOwnerCoverPhotoUrisResultImpl(int paramInt, Bundle paramBundle)
    {
      this.yw = new Status(paramInt);
      this.HJ = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class LoadXpStreamResultImpl
    extends b
    implements Players.LoadXpStreamResult
  {
    private final ExperienceEventBuffer Oe;
    
    LoadXpStreamResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.Oe = new ExperienceEventBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadXpForGameCategoriesResultImpl
    implements Players.LoadXpForGameCategoriesResult
  {
    private final List<String> Oc;
    private final Bundle Od;
    private final Status yw;
    
    LoadXpForGameCategoriesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.yw = paramStatus;
      this.Oc = paramBundle.getStringArrayList("game_category_list");
      this.Od = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class LoadPlayersResultImpl
    extends b
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer NY;
    
    LoadPlayersResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NY = new PlayerBuffer(paramDataHolder);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.NY;
    }
  }
  
  private static final class LoadMatchesResultImpl
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final LoadMatchesResponse NW;
    private final Status yw;
    
    LoadMatchesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.yw = paramStatus;
      this.NW = new LoadMatchesResponse(paramBundle);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.NW;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public void release()
    {
      this.NW.close();
    }
  }
  
  private static final class LoadInvitationsResultImpl
    extends b
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer NV;
    
    LoadInvitationsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NV = new InvitationBuffer(paramDataHolder);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.NV;
    }
  }
  
  private static final class LoadPlayerScoreResultImpl
    extends b
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final LeaderboardScoreEntity NX;
    
    /* Error */
    LoadPlayerScoreResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_3
      //   14: aload_3
      //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   18: ifle +25 -> 43
      //   21: aload_0
      //   22: aload_3
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   27: invokeinterface 32 1 0
      //   32: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
      //   35: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:NX	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   38: aload_3
      //   39: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:NX	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   48: goto -10 -> 38
      //   51: astore_2
      //   52: aload_3
      //   53: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
      //   56: aload_2
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	LoadPlayerScoreResultImpl
      //   0	58	1	paramDataHolder	DataHolder
      //   51	6	2	localObject	Object
      //   13	40	3	localLeaderboardScoreBuffer	LeaderboardScoreBuffer
      // Exception table:
      //   from	to	target	type
      //   14	38	51	finally
      //   43	48	51	finally
    }
    
    public LeaderboardScore getScore()
    {
      return this.NX;
    }
  }
  
  private static final class LoadScoresResultImpl
    extends b
    implements Leaderboards.LoadScoresResult
  {
    private final LeaderboardEntity Oa;
    private final LeaderboardScoreBuffer Ob;
    
    /* Error */
    LoadScoresResultImpl(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: invokespecial 18	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 20	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 21	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore 4
      //   15: aload 4
      //   17: invokevirtual 25	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   20: ifle +42 -> 62
      //   23: aload_0
      //   24: aload 4
      //   26: iconst_0
      //   27: invokevirtual 29	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   30: checkcast 31	com/google/android/gms/games/leaderboard/Leaderboard
      //   33: invokeinterface 35 1 0
      //   38: checkcast 37	com/google/android/gms/games/leaderboard/LeaderboardEntity
      //   41: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:Oa	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   44: aload 4
      //   46: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
      //   49: aload_0
      //   50: new 45	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   53: dup
      //   54: aload_2
      //   55: invokespecial 46	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   58: putfield 48	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:Ob	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   61: return
      //   62: aload_0
      //   63: aconst_null
      //   64: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:Oa	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   67: goto -23 -> 44
      //   70: astore_3
      //   71: aload 4
      //   73: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
      //   76: aload_3
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	LoadScoresResultImpl
      //   0	78	1	paramDataHolder1	DataHolder
      //   0	78	2	paramDataHolder2	DataHolder
      //   70	7	3	localObject	Object
      //   13	59	4	localLeaderboardBuffer	LeaderboardBuffer
      // Exception table:
      //   from	to	target	type
      //   15	44	70	finally
      //   62	67	70	finally
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.Oa;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.Ob;
    }
  }
  
  private static final class LeaderboardMetadataResultImpl
    extends b
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer NO;
    
    LeaderboardMetadataResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NO = new LeaderboardBuffer(paramDataHolder);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.NO;
    }
  }
  
  private static final class LoadGameSearchSuggestionsResultImpl
    extends b
    implements GamesMetadata.LoadGameSearchSuggestionsResult
  {
    LoadGameSearchSuggestionsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadGameInstancesResultImpl
    extends b
    implements GamesMetadata.LoadGameInstancesResult
  {
    private final GameInstanceBuffer NT;
    
    LoadGameInstancesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NT = new GameInstanceBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadExtendedGamesResultImpl
    extends b
    implements GamesMetadata.LoadExtendedGamesResult
  {
    private final ExtendedGameBuffer NS;
    
    LoadExtendedGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NS = new ExtendedGameBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGamesResultImpl
    extends b
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer NU;
    
    LoadGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NU = new GameBuffer(paramDataHolder);
    }
    
    public GameBuffer getGames()
    {
      return this.NU;
    }
  }
  
  private static final class LoadEventResultImpl
    extends b
    implements Events.LoadEventsResult
  {
    private final EventBuffer NR;
    
    LoadEventResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NR = new EventBuffer(paramDataHolder);
    }
    
    public EventBuffer getEvents()
    {
      return this.NR;
    }
  }
  
  private static final class UpdateAchievementResultImpl
    implements Achievements.UpdateAchievementResult
  {
    private final String OQ;
    private final Status yw;
    
    UpdateAchievementResultImpl(int paramInt, String paramString)
    {
      this.yw = new Status(paramInt);
      this.OQ = paramString;
    }
    
    public String getAchievementId()
    {
      return this.OQ;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class LoadAchievementsResultImpl
    extends b
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer NQ;
    
    LoadAchievementsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.NQ = new AchievementBuffer(paramDataHolder);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.NQ;
    }
  }
  
  private final class RealTimeMessageSentCallback
    extends hc<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int CQ;
    private final String Ot;
    private final int Ou;
    
    RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, int paramInt1, int paramInt2, String paramString)
    {
      super(paramReliableMessageSentCallback);
      this.CQ = paramInt1;
      this.Ou = paramInt2;
      this.Ot = paramString;
    }
    
    public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.CQ, this.Ou, this.Ot);
      }
    }
    
    protected void fp() {}
  }
  
  private final class MessageReceivedCallback
    extends hc<IGamesService>.b<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage Oi;
    
    MessageReceivedCallback(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener, RealTimeMessage paramRealTimeMessage)
    {
      super(paramRealTimeMessageReceivedListener);
      this.Oi = paramRealTimeMessage;
    }
    
    public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      if (paramRealTimeMessageReceivedListener != null) {
        paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.Oi);
      }
    }
    
    protected void fp() {}
  }
  
  private final class P2PDisconnectedCallback
    extends hc<IGamesService>.b<RoomStatusUpdateListener>
  {
    private final String On;
    
    P2PDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.On = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PDisconnected(this.On);
      }
    }
    
    protected void fp() {}
  }
  
  private final class P2PConnectedCallback
    extends hc<IGamesService>.b<RoomStatusUpdateListener>
  {
    private final String On;
    
    P2PConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.On = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PConnected(this.On);
      }
    }
    
    protected void fp() {}
  }
  
  private final class PeerDisconnectedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerConnectedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerDeclinedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerDeclinedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerLeftRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerLeftRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerJoinedRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerJoinedRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerInvitedToRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerInvitedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  private final class DisconnectedFromRoomCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    DisconnectedFromRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  private final class ConnectedToRoomCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    ConnectedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  private final class RoomAutoMatchingCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    RoomAutoMatchingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  private final class RoomConnectingCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    RoomConnectingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  private final class RoomConnectedCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    RoomConnectedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  private final class LeftRoomCallback
    extends hc<IGamesService>.b<RoomUpdateListener>
  {
    private final int CQ;
    private final String NP;
    
    LeftRoomCallback(RoomUpdateListener paramRoomUpdateListener, int paramInt, String paramString)
    {
      super(paramRoomUpdateListener);
      this.CQ = paramInt;
      this.NP = paramString;
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.CQ, this.NP);
    }
    
    protected void fp() {}
  }
  
  private final class JoinedRoomCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    public JoinedRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  private final class RoomCreatedCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    public RoomCreatedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  private abstract class AbstractPeerStatusCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    private final ArrayList<String> NC = new ArrayList();
    
    AbstractPeerStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
      int i = 0;
      int j = paramArrayOfString.length;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        this.NC.add(paramArrayOfString[i]);
        i++;
      }
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      a(paramRoomStatusUpdateListener, paramRoom, this.NC);
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  private abstract class AbstractRoomStatusCallback
    extends hc<IGamesService>.d<RoomStatusUpdateListener>
  {
    AbstractRoomStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomStatusUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder));
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  private abstract class AbstractRoomCallback
    extends hc<IGamesService>.d<RoomUpdateListener>
  {
    AbstractRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  private final class RequestRemovedCallback
    extends hc<IGamesService>.b<OnRequestReceivedListener>
  {
    private final String Oy;
    
    RequestRemovedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, String paramString)
    {
      super(paramOnRequestReceivedListener);
      this.Oy = paramString;
    }
    
    protected void b(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestRemoved(this.Oy);
    }
    
    protected void fp() {}
  }
  
  private final class RequestReceivedCallback
    extends hc<IGamesService>.b<OnRequestReceivedListener>
  {
    private final GameRequest Ox;
    
    RequestReceivedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, GameRequest paramGameRequest)
    {
      super(paramOnRequestReceivedListener);
      this.Ox = paramGameRequest;
    }
    
    protected void b(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestReceived(this.Ox);
    }
    
    protected void fp() {}
  }
  
  private final class QuestCompletedCallback
    extends hc<IGamesService>.b<QuestUpdateListener>
  {
    private final Quest ND;
    
    QuestCompletedCallback(QuestUpdateListener paramQuestUpdateListener, Quest paramQuest)
    {
      super(paramQuestUpdateListener);
      this.ND = paramQuest;
    }
    
    protected void b(QuestUpdateListener paramQuestUpdateListener)
    {
      paramQuestUpdateListener.onQuestCompleted(this.ND);
    }
    
    protected void fp() {}
  }
  
  private final class MatchRemovedCallback
    extends hc<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String Of;
    
    MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, String paramString)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.Of = paramString;
    }
    
    protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Of);
    }
    
    protected void fp() {}
  }
  
  private final class MatchUpdateReceivedCallback
    extends hc<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch Oh;
    
    MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, TurnBasedMatch paramTurnBasedMatch)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.Oh = paramTurnBasedMatch;
    }
    
    protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Oh);
    }
    
    protected void fp() {}
  }
  
  private final class InvitationRemovedCallback
    extends hc<IGamesService>.b<OnInvitationReceivedListener>
  {
    private final String NN;
    
    InvitationRemovedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, String paramString)
    {
      super(paramOnInvitationReceivedListener);
      this.NN = paramString;
    }
    
    protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.NN);
    }
    
    protected void fp() {}
  }
  
  private final class InvitationReceivedCallback
    extends hc<IGamesService>.b<OnInvitationReceivedListener>
  {
    private final Invitation NM;
    
    InvitationReceivedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, Invitation paramInvitation)
    {
      super(paramOnInvitationReceivedListener);
      this.NM = paramInvitation;
    }
    
    protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.NM);
    }
    
    protected void fp() {}
  }
  
  final class SnapshotDeletedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Snapshots.DeleteSnapshotResult> yO;
    
    public SnapshotDeletedBinderCallbacks()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void g(int paramInt, String paramString)
    {
      this.yO.a(new GamesClientImpl.DeleteSnapshotResultImpl(paramInt, paramString));
    }
  }
  
  private final class SnapshotCommittedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Snapshots.CommitSnapshotResult> OG;
    
    public SnapshotCommittedBinderCallbacks()
    {
      Object localObject;
      this.OG = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void J(DataHolder paramDataHolder)
    {
      this.OG.a(new GamesClientImpl.CommitSnapshotResultImpl(paramDataHolder));
    }
  }
  
  private final class SnapshotOpenedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Snapshots.OpenSnapshotResult> OH;
    
    public SnapshotOpenedBinderCallbacks()
    {
      Object localObject;
      this.OH = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder, Contents paramContents)
    {
      this.OH.a(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramContents));
    }
    
    public void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      this.OH.a(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
    }
  }
  
  private final class SnapshotsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Snapshots.LoadSnapshotsResult> OI;
    
    public SnapshotsLoadedBinderCallbacks()
    {
      Object localObject;
      this.OI = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void I(DataHolder paramDataHolder)
    {
      this.OI.a(new GamesClientImpl.LoadSnapshotsResultImpl(paramDataHolder));
    }
  }
  
  private final class QuestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Quests.LoadQuestsResult> Os;
    
    public QuestsLoadedBinderCallbacks()
    {
      Object localObject;
      this.Os = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void O(DataHolder paramDataHolder)
    {
      this.Os.a(new GamesClientImpl.LoadQuestsResultImpl(paramDataHolder));
    }
  }
  
  private final class QuestMilestoneClaimBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Quests.ClaimMilestoneResult> Op;
    private final String Oq;
    
    public QuestMilestoneClaimBinderCallbacks(String paramString)
    {
      this.Op = ((a.d)hn.b(paramString, "Holder must not be null"));
      Object localObject;
      this.Oq = ((String)hn.b(localObject, "MilestoneId must not be null"));
    }
    
    public void K(DataHolder paramDataHolder)
    {
      this.Op.a(new GamesClientImpl.ClaimMilestoneResultImpl(paramDataHolder, this.Oq));
    }
  }
  
  private final class QuestAcceptedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Quests.AcceptQuestResult> Oo;
    
    public QuestAcceptedBinderCallbacks()
    {
      Object localObject;
      this.Oo = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void L(DataHolder paramDataHolder)
    {
      this.Oo.a(new GamesClientImpl.AcceptQuestResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestSummariesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Requests.LoadRequestSummariesResult> OA;
    
    public RequestSummariesLoadedBinderCallbacks()
    {
      Object localObject;
      this.OA = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void H(DataHolder paramDataHolder)
    {
      this.OA.a(new GamesClientImpl.LoadRequestSummariesResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Requests.LoadRequestsResult> OB;
    
    public RequestsLoadedBinderCallbacks()
    {
      Object localObject;
      this.OB = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void c(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.OB.a(new GamesClientImpl.LoadRequestsResultImpl(localStatus, paramBundle));
    }
  }
  
  private final class RequestSentBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Requests.SendRequestResult> Oz;
    
    public RequestSentBinderCallbacks()
    {
      Object localObject;
      this.Oz = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void G(DataHolder paramDataHolder)
    {
      this.Oz.a(new GamesClientImpl.SendRequestResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestsUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Requests.UpdateRequestsResult> OC;
    
    public RequestsUpdatedBinderCallbacks()
    {
      Object localObject;
      this.OC = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void F(DataHolder paramDataHolder)
    {
      this.OC.a(new GamesClientImpl.UpdateRequestsResultImpl(paramDataHolder));
    }
  }
  
  private final class SignOutCompleteBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Status> yO;
    
    public SignOutCompleteBinderCallbacks()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void dO()
    {
      Status localStatus = new Status(0);
      this.yO.a(localStatus);
    }
  }
  
  private final class InboxCountsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Notifications.InboxCountResult> yO;
    
    InboxCountsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void f(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.yO.a(new GamesClientImpl.InboxCountResultImpl(localStatus, paramBundle));
    }
  }
  
  private final class ContactSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Status> yO;
    
    ContactSettingsUpdatedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void ce(int paramInt)
    {
      this.yO.a(new Status(paramInt));
    }
  }
  
  private final class ContactSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Notifications.ContactSettingLoadResult> yO;
    
    ContactSettingsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void D(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.ContactSettingLoadResultImpl(paramDataHolder));
    }
  }
  
  private final class GameMuteStatusLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Notifications.GameMuteStatusLoadResult> yO;
    
    GameMuteStatusLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void B(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.GameMuteStatusLoadResultImpl(paramDataHolder));
    }
  }
  
  private final class GameMuteStatusChangedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Notifications.GameMuteStatusChangeResult> yO;
    
    GameMuteStatusChangedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void a(int paramInt, String paramString, boolean paramBoolean)
    {
      this.yO.a(new GamesClientImpl.GameMuteStatusChangeResultImpl(paramInt, paramString, paramBoolean));
    }
  }
  
  private final class NotifyAclUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Status> yO;
    
    NotifyAclUpdatedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void cd(int paramInt)
    {
      this.yO.a(new Status(paramInt));
    }
  }
  
  private final class NotifyAclLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Acls.LoadAclResult> yO;
    
    NotifyAclLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void C(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadAclResultImpl(paramDataHolder));
    }
  }
  
  private final class RealTimeReliableMessageBinderCallbacks
    extends AbstractGamesCallbacks
  {
    final RealTimeMultiplayer.ReliableMessageSentCallback Ov;
    
    public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      this.Ov = paramReliableMessageSentCallback;
    }
    
    public void b(int paramInt1, int paramInt2, String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RealTimeMessageSentCallback(GamesClientImpl.this, this.Ov, paramInt1, paramInt2, paramString));
    }
  }
  
  private final class RoomBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final RoomUpdateListener OD;
    private final RoomStatusUpdateListener OE;
    private final RealTimeMessageReceivedListener OF;
    
    public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener)
    {
      this.OD = ((RoomUpdateListener)hn.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.OE = null;
      this.OF = null;
    }
    
    public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener, RoomStatusUpdateListener paramRoomStatusUpdateListener, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.OD = ((RoomUpdateListener)hn.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.OE = paramRoomStatusUpdateListener;
      this.OF = paramRealTimeMessageReceivedListener;
    }
    
    public void A(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.DisconnectedFromRoomCallback(GamesClientImpl.this, this.OE, paramDataHolder));
    }
    
    public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerInvitedToRoomCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerJoinedRoomCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerLeftRoomCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerDeclinedCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerConnectedCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerDisconnectedCallback(GamesClientImpl.this, this.OE, paramDataHolder, paramArrayOfString));
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.LeftRoomCallback(GamesClientImpl.this, this.OD, paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.P2PConnectedCallback(GamesClientImpl.this, this.OE, paramString));
    }
    
    public void onP2PDisconnected(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.P2PDisconnectedCallback(GamesClientImpl.this, this.OE, paramString));
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      GamesClientImpl.this.a(new GamesClientImpl.MessageReceivedCallback(GamesClientImpl.this, this.OF, paramRealTimeMessage));
    }
    
    public void u(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomCreatedCallback(GamesClientImpl.this, this.OD, paramDataHolder));
    }
    
    public void v(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.JoinedRoomCallback(GamesClientImpl.this, this.OD, paramDataHolder));
    }
    
    public void w(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomConnectingCallback(GamesClientImpl.this, this.OE, paramDataHolder));
    }
    
    public void x(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomAutoMatchingCallback(GamesClientImpl.this, this.OE, paramDataHolder));
    }
    
    public void y(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomConnectedCallback(GamesClientImpl.this, this.OD, paramDataHolder));
    }
    
    public void z(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.ConnectedToRoomCallback(GamesClientImpl.this, this.OE, paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchCanceledBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.CancelMatchResult> OK;
    
    public TurnBasedMatchCanceledBinderCallbacks()
    {
      Object localObject;
      this.OK = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void f(int paramInt, String paramString)
    {
      Status localStatus = new Status(paramInt);
      this.OK.a(new GamesClientImpl.CancelMatchResultImpl(localStatus, paramString));
    }
  }
  
  private final class TurnBasedMatchLeftBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.LeaveMatchResult> OM;
    
    public TurnBasedMatchLeftBinderCallbacks()
    {
      Object localObject;
      this.OM = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void s(DataHolder paramDataHolder)
    {
      this.OM.a(new GamesClientImpl.LeaveMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.UpdateMatchResult> OO;
    
    public TurnBasedMatchUpdatedBinderCallbacks()
    {
      Object localObject;
      this.OO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void r(DataHolder paramDataHolder)
    {
      this.OO.a(new GamesClientImpl.UpdateMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchInitiatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.InitiateMatchResult> OL;
    
    public TurnBasedMatchInitiatedBinderCallbacks()
    {
      Object localObject;
      this.OL = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void q(DataHolder paramDataHolder)
    {
      this.OL.a(new GamesClientImpl.InitiateMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.LoadMatchResult> ON;
    
    public TurnBasedMatchLoadedBinderCallbacks()
    {
      Object localObject;
      this.ON = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void p(DataHolder paramDataHolder)
    {
      this.ON.a(new GamesClientImpl.LoadMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<TurnBasedMultiplayer.LoadMatchesResult> OP;
    
    public TurnBasedMatchesLoadedBinderCallbacks()
    {
      Object localObject;
      this.OP = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void b(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.OP.a(new GamesClientImpl.LoadMatchesResultImpl(localStatus, paramBundle));
    }
  }
  
  private final class SubmitScoreBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final a.d<Leaderboards.SubmitScoreResult> yO;
    
    public SubmitScoreBinderCallbacks()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void f(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.SubmitScoreResultImpl(paramDataHolder));
    }
  }
  
  private final class OwnerCoverPhotoUrisLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Players.LoadOwnerCoverPhotoUrisResult> yO;
    
    OwnerCoverPhotoUrisLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void d(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.yO.a(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(paramInt, paramBundle));
    }
  }
  
  final class PlayerXpStreamLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Players.LoadXpStreamResult> yO;
    
    PlayerXpStreamLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void P(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadXpStreamResultImpl(paramDataHolder));
    }
  }
  
  private final class PlayerXpForGameCategoriesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Players.LoadXpForGameCategoriesResult> yO;
    
    PlayerXpForGameCategoriesLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void e(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.yO.a(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(localStatus, paramBundle));
    }
  }
  
  private final class PlayersLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Players.LoadPlayersResult> yO;
    
    PlayersLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void g(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
    
    public void h(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnRequestReceivedListener Ow;
    
    RequestReceivedBinderCallback(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      this.Ow = paramOnRequestReceivedListener;
    }
    
    public void o(DataHolder paramDataHolder)
    {
      GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
      GameRequest localGameRequest = null;
      try
      {
        if (localGameRequestBuffer.getCount() > 0) {
          localGameRequest = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
        }
        localGameRequestBuffer.close();
        if (localGameRequest != null) {
          GamesClientImpl.this.a(new GamesClientImpl.RequestReceivedCallback(GamesClientImpl.this, this.Ow, localGameRequest));
        }
        return;
      }
      finally
      {
        localGameRequestBuffer.close();
      }
    }
    
    public void onRequestRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RequestRemovedCallback(GamesClientImpl.this, this.Ow, paramString));
    }
  }
  
  private final class QuestUpdateBinderCallback
    extends AbstractGamesCallbacks
  {
    private final QuestUpdateListener Or;
    
    QuestUpdateBinderCallback(QuestUpdateListener paramQuestUpdateListener)
    {
      this.Or = paramQuestUpdateListener;
    }
    
    private Quest R(DataHolder paramDataHolder)
    {
      QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
      Quest localQuest = null;
      try
      {
        if (localQuestBuffer.getCount() > 0) {
          localQuest = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
        }
        return localQuest;
      }
      finally
      {
        localQuestBuffer.close();
      }
    }
    
    public void M(DataHolder paramDataHolder)
    {
      Quest localQuest = R(paramDataHolder);
      if (localQuest != null) {
        GamesClientImpl.this.a(new GamesClientImpl.QuestCompletedCallback(GamesClientImpl.this, this.Or, localQuest));
      }
    }
  }
  
  private final class MatchUpdateReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnTurnBasedMatchUpdateReceivedListener Og;
    
    MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      this.Og = paramOnTurnBasedMatchUpdateReceivedListener;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.MatchRemovedCallback(GamesClientImpl.this, this.Og, paramString));
    }
    
    public void t(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      TurnBasedMatch localTurnBasedMatch = null;
      try
      {
        if (localTurnBasedMatchBuffer.getCount() > 0) {
          localTurnBasedMatch = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.close();
        if (localTurnBasedMatch != null) {
          GamesClientImpl.this.a(new GamesClientImpl.MatchUpdateReceivedCallback(GamesClientImpl.this, this.Og, localTurnBasedMatch));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.close();
      }
    }
  }
  
  private final class InvitationReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnInvitationReceivedListener NL;
    
    InvitationReceivedBinderCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      this.NL = paramOnInvitationReceivedListener;
    }
    
    public void n(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      Invitation localInvitation = null;
      try
      {
        if (localInvitationBuffer.getCount() > 0) {
          localInvitation = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.close();
        if (localInvitation != null) {
          GamesClientImpl.this.a(new GamesClientImpl.InvitationReceivedCallback(GamesClientImpl.this, this.NL, localInvitation));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.close();
      }
    }
    
    public void onInvitationRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.InvitationRemovedCallback(GamesClientImpl.this, this.NL, paramString));
    }
  }
  
  private final class InvitationsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Invitations.LoadInvitationsResult> yO;
    
    InvitationsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void m(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadInvitationsResultImpl(paramDataHolder));
    }
  }
  
  private final class PlayerLeaderboardScoreLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Leaderboards.LoadPlayerScoreResult> yO;
    
    PlayerLeaderboardScoreLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void E(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadPlayerScoreResultImpl(paramDataHolder));
    }
  }
  
  private final class LeaderboardScoresLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Leaderboards.LoadScoresResult> yO;
    
    LeaderboardScoresLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      this.yO.a(new GamesClientImpl.LoadScoresResultImpl(paramDataHolder1, paramDataHolder2));
    }
  }
  
  private final class LeaderboardsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Leaderboards.LeaderboardMetadataResult> yO;
    
    LeaderboardsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void e(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LeaderboardMetadataResultImpl(paramDataHolder));
    }
  }
  
  private final class GameSearchSuggestionsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<GamesMetadata.LoadGameSearchSuggestionsResult> yO;
    
    GameSearchSuggestionsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void l(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(paramDataHolder));
    }
  }
  
  private final class GameInstancesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<GamesMetadata.LoadGameInstancesResult> yO;
    
    GameInstancesLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void k(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadGameInstancesResultImpl(paramDataHolder));
    }
  }
  
  private final class ExtendedGamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<GamesMetadata.LoadExtendedGamesResult> yO;
    
    ExtendedGamesLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void j(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadExtendedGamesResultImpl(paramDataHolder));
    }
  }
  
  private final class EventsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Events.LoadEventsResult> yO;
    
    EventsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void d(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadEventResultImpl(paramDataHolder));
    }
  }
  
  private final class GamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<GamesMetadata.LoadGamesResult> yO;
    
    GamesLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void i(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadGamesResultImpl(paramDataHolder));
    }
  }
  
  private final class AchievementUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Achievements.UpdateAchievementResult> yO;
    
    AchievementUpdatedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void e(int paramInt, String paramString)
    {
      this.yO.a(new GamesClientImpl.UpdateAchievementResultImpl(paramInt, paramString));
    }
  }
  
  private final class AchievementsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final a.d<Achievements.LoadAchievementsResult> yO;
    
    AchievementsLoadedBinderCallback()
    {
      Object localObject;
      this.yO = ((a.d)hn.b(localObject, "Holder must not be null"));
    }
    
    public void c(DataHolder paramDataHolder)
    {
      this.yO.a(new GamesClientImpl.LoadAchievementsResultImpl(paramDataHolder));
    }
  }
  
  private class GameClientEventIncrementCache
    extends EventIncrementCache
  {
    public GameClientEventIncrementCache()
    {
      super(1000);
    }
    
    protected void o(String paramString, int paramInt)
    {
      try
      {
        ((IGamesService)GamesClientImpl.this.fo()).l(paramString, paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          GamesLog.j("GamesClientImpl", "service died");
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesClientImpl
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.games.multiplayer.realtime;

import java.util.List;

public abstract interface RoomStatusUpdateListener
{
  public abstract void onConnectedToRoom(Room paramRoom);
  
  public abstract void onDisconnectedFromRoom(Room paramRoom);
  
  public abstract void onP2PConnected(String paramString);
  
  public abstract void onP2PDisconnected(String paramString);
  
  public abstract void onPeerDeclined(Room paramRoom, List<String> paramList);
  
  public abstract void onPeerInvitedToRoom(Room paramRoom, List<String> paramList);
  
  public abstract void onPeerJoined(Room paramRoom, List<String> paramList);
  
  public abstract void onPeerLeft(Room paramRoom, List<String> paramList);
  
  public abstract void onPeersConnected(Room paramRoom, List<String> paramList);
  
  public abstract void onPeersDisconnected(Room paramRoom, List<String> paramList);
  
  public abstract void onRoomAutoMatching(Room paramRoom);
  
  public abstract void onRoomConnecting(Room paramRoom);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
 * JD-Core Version:    0.7.0.1
 */
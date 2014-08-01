package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

public final class ParticipantUtils
{
  public static boolean bn(String paramString)
  {
    hn.b(paramString, "Participant ID must not be null");
    return paramString.startsWith("p_");
  }
  
  public static String getParticipantId(ArrayList<Participant> paramArrayList, String paramString)
  {
    int j = paramArrayList.size();
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return null;
      }
      localObject = (Participant)paramArrayList.get(i);
      Player localPlayer = ((Participant)localObject).getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        break;
      }
    }
    Object localObject = ((Participant)localObject).getParticipantId();
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantUtils
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
  private final ArrayList<InvitationEntity> RE;
  private final int xJ;
  
  ZInvitationCluster(int paramInt, ArrayList<InvitationEntity> paramArrayList)
  {
    this.xJ = paramInt;
    this.RE = paramArrayList;
    id();
  }
  
  private void id()
  {
    boolean bool;
    if (this.RE.isEmpty()) {
      bool = false;
    } else {
      bool = true;
    }
    gy.A(bool);
    Invitation localInvitation2 = (Invitation)this.RE.get(0);
    int j = this.RE.size();
    int i = 1;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Invitation localInvitation1 = (Invitation)this.RE.get(i);
      gy.a(localInvitation2.getInviter().equals(localInvitation1.getInviter()), "All the invitations must be from the same inviter");
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    int i;
    if ((paramObject instanceof ZInvitationCluster))
    {
      if (this != paramObject)
      {
        ZInvitationCluster localZInvitationCluster = (ZInvitationCluster)paramObject;
        if (localZInvitationCluster.RE.size() == this.RE.size())
        {
          int j = this.RE.size();
          for (i = 0;; i++)
          {
            if (i >= j) {
              return 1;
            }
            if (!((Invitation)this.RE.get(i)).equals((Invitation)localZInvitationCluster.RE.get(i))) {
              break;
            }
          }
          i = 0;
        }
        else
        {
          i = 0;
        }
      }
      else
      {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getInvitationId()
  {
    return ((InvitationEntity)this.RE.get(0)).getInvitationId();
  }
  
  public int getInvitationType()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Participant getInviter()
  {
    return ((InvitationEntity)this.RE.get(0)).getInviter();
  }
  
  public ArrayList<Participant> getParticipants()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVariant()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(this.RE.toArray());
  }
  
  public ArrayList<Invitation> ie()
  {
    return new ArrayList(this.RE);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    InvitationClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.ZInvitationCluster
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class InvitationBuffer
  extends g<Invitation>
{
  public InvitationBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String eU()
  {
    return "external_invitation_id";
  }
  
  protected Invitation g(int paramInt1, int paramInt2)
  {
    return new InvitationRef(this.DD, paramInt1, paramInt2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationBuffer
 * JD-Core Version:    0.7.0.1
 */
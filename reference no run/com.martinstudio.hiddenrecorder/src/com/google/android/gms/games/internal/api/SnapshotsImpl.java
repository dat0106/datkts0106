package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl
  implements Snapshots
{
  public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient paramGoogleApiClient, final Snapshot paramSnapshot, final SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    paramGoogleApiClient.b(new CommitImpl(paramSnapshot)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramSnapshot, paramSnapshotMetadataChange);
      }
    });
  }
  
  public PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient paramGoogleApiClient, final SnapshotMetadata paramSnapshotMetadata)
  {
    paramGoogleApiClient.b(new DeleteImpl(paramSnapshotMetadata)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.j(this, paramSnapshotMetadata.getSnapshotId());
      }
    });
  }
  
  public void discardAndClose(GoogleApiClient paramGoogleApiClient, Snapshot paramSnapshot)
  {
    Games.c(paramGoogleApiClient).a(paramSnapshot);
  }
  
  public int getMaxCoverImageSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hp();
  }
  
  public int getMaxDataSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).ho();
  }
  
  public Intent getSelectSnapshotIntent(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return Games.c(paramGoogleApiClient).a(paramString, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public SnapshotMetadata getSnapshotFromBundle(Bundle paramBundle)
  {
    SnapshotMetadata localSnapshotMetadata;
    if ((paramBundle != null) && (paramBundle.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA"))) {
      localSnapshotMetadata = (SnapshotMetadata)paramBundle.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA");
    } else {
      localSnapshotMetadata = null;
    }
    return localSnapshotMetadata;
  }
  
  public PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadImpl(paramBoolean)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.e(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, SnapshotMetadata paramSnapshotMetadata)
  {
    return open(paramGoogleApiClient, paramSnapshotMetadata.getUniqueName(), false);
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, final String paramString, final boolean paramBoolean)
  {
    paramGoogleApiClient.b(new OpenImpl(paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.b(this, paramString, paramBoolean);
      }
    });
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, String paramString, Snapshot paramSnapshot)
  {
    SnapshotMetadata localSnapshotMetadata = paramSnapshot.getMetadata();
    SnapshotMetadataChange localSnapshotMetadataChange = new SnapshotMetadataChange.Builder().fromMetadata(localSnapshotMetadata).build();
    return resolveConflict(paramGoogleApiClient, paramString, localSnapshotMetadata.getSnapshotId(), localSnapshotMetadataChange, paramSnapshot.getContents());
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final SnapshotMetadataChange paramSnapshotMetadataChange, final Contents paramContents)
  {
    paramGoogleApiClient.b(new OpenImpl(paramString1)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.a(this, paramString1, paramString2, paramSnapshotMetadataChange, paramContents);
      }
    });
  }
  
  private static abstract class DeleteImpl
    extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult>
  {
    public Snapshots.DeleteSnapshotResult aa(final Status paramStatus)
    {
      new Snapshots.DeleteSnapshotResult()
      {
        public String getSnapshotId()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class CommitImpl
    extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult>
  {
    public Snapshots.CommitSnapshotResult Z(final Status paramStatus)
    {
      new Snapshots.CommitSnapshotResult()
      {
        public SnapshotMetadata getSnapshotMetadata()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class OpenImpl
    extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult>
  {
    public Snapshots.OpenSnapshotResult ac(final Status paramStatus)
    {
      new Snapshots.OpenSnapshotResult()
      {
        public String getConflictId()
        {
          return null;
        }
        
        public Snapshot getConflictingSnapshot()
        {
          return null;
        }
        
        public Contents getResolutionContents()
        {
          return null;
        }
        
        public Snapshot getSnapshot()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadImpl
    extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult>
  {
    public Snapshots.LoadSnapshotsResult ab(final Status paramStatus)
    {
      new Snapshots.LoadSnapshotsResult()
      {
        public SnapshotMetadataBuffer getSnapshots()
        {
          return new SnapshotMetadataBuffer(DataHolder.af(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.SnapshotsImpl
 * JD-Core Version:    0.7.0.1
 */
package com.sonyericsson.extras.liveware.actions.music;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sonyericsson.extras.liveware.ui.BaseListActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackSettings
  extends BaseListActivity
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private static final int DLG_NO_MUSIC = 1;
  private static final int EXTERNAL_TRACKS = 1;
  private static final int INTERNAL_TRACKS = 0;
  public static final String SHOW_INTERNAL_CONTENT = "internal_content";
  private String mSelectedTrackPath;
  private boolean mShowInternalContent;
  private List<Track> mTracks = new ArrayList();
  
  private Dialog createInfoDialog()
  {
    UIUtils.createCommonDialog(this, getString(2131099850), getString(2131099857), new Runnable()
    {
      public void run()
      {
        TrackSettings.this.finish();
      }
    });
  }
  
  private String setTrack(Track paramTrack)
  {
    return MusicSettings.buildRawSetting("play_track_setting", paramTrack.getPathName(), paramTrack.getName());
  }
  
  private List<Track> tracksFromCursor(Cursor paramCursor)
  {
    ArrayList localArrayList = null;
    if ((paramCursor != null) && (!paramCursor.isClosed()) && (paramCursor.moveToFirst()))
    {
      localArrayList = new ArrayList();
      int m = 0;
      int i = paramCursor.getColumnIndex("_data");
      int k = paramCursor.getColumnIndex("title");
      int j = paramCursor.getColumnIndex("artist");
      if ((i != -1) && (k != -1) && (j != -1)) {
        do
        {
          String str2 = paramCursor.getString(i);
          String str1 = paramCursor.getString(j);
          String str3 = paramCursor.getString(k);
          if ((str3 != null) && (!str3.equals("")))
          {
            localArrayList.add(new Track(m, str2, str1 + " - " + str3));
            m++;
          }
        } while (paramCursor.moveToNext());
      }
    }
    return localArrayList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    setTitle(2131099850);
    Object localObject = getIntent();
    this.mShowInternalContent = ((Intent)localObject).getBooleanExtra("internal_content", false);
    localObject = ((Intent)localObject).getStringExtra("setting_raw");
    this.mSelectedTrackPath = "";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      this.mSelectedTrackPath = new JSONObject((String)localObject).optString("music_path");
      getLoaderManager().initLoader(1, null, this);
      if (this.mShowInternalContent) {
        getLoaderManager().initLoader(0, null, this);
      }
      getActionBar().setDisplayHomeAsUpEnabled(true);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e();
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog;
    switch (paramInt)
    {
    default: 
      localDialog = super.onCreateDialog(paramInt);
      break;
    case 1: 
      localDialog = createInfoDialog();
    }
    return localDialog;
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    Object localObject = new String[5];
    localObject[0] = "_id";
    localObject[1] = "_data";
    localObject[2] = "artist";
    localObject[3] = "title";
    localObject[4] = "_display_name";
    switch (paramInt)
    {
    default: 
      localObject = null;
      break;
    case 0: 
      localObject = new CursorLoader(this, MediaStore.Audio.Media.INTERNAL_CONTENT_URI, (String[])localObject, null, null, "artist ASC");
      break;
    case 1: 
      localObject = new CursorLoader(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (String[])localObject, null, null, "artist ASC");
    }
    return localObject;
  }
  
  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    String str = setTrack((Track)getListAdapter().getItem(paramInt));
    ActionUtils.finishActivityWithSetting(this, str, PlayAction.getLabelByRawSetting(this, str));
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    List localList = tracksFromCursor(paramCursor);
    if (localList != null)
    {
      this.mTracks.addAll(localList);
      setListAdapter(new TrackAdapter(this, this.mTracks));
    }
    if ((this.mTracks.size() == 0) && (paramLoader.getId() == 1))
    {
      Dbg.d("onCreate, no music");
      showDialog(1);
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
  
  private static class Track
  {
    private int mId;
    private String mName;
    private String mPathName;
    
    public Track(int paramInt, String paramString1, String paramString2)
    {
      this.mPathName = paramString1;
      this.mId = paramInt;
      this.mName = paramString2;
    }
    
    public int getId()
    {
      return this.mId;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getPathName()
    {
      return this.mPathName;
    }
  }
  
  class TrackAdapter
    extends BaseAdapter
  {
    private Context mContext;
    private final List<TrackSettings.Track> mTracks;
    
    public TrackAdapter(List<TrackSettings.Track> paramList)
    {
      Object localObject;
      this.mTracks = localObject;
      this.mContext = paramList;
    }
    
    public int getCount()
    {
      return this.mTracks.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mTracks.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return ((TrackSettings.Track)this.mTracks.get(paramInt)).getId();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TrackSettings.Track localTrack = (TrackSettings.Track)this.mTracks.get(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2130903080, paramViewGroup, false);
      CheckedTextView localCheckedTextView = (CheckedTextView)localView.findViewById(2131558506);
      localCheckedTextView.setMaxLines(2);
      localCheckedTextView.setText(localTrack.getName());
      localCheckedTextView.setChecked(localTrack.getPathName().equalsIgnoreCase(TrackSettings.this.mSelectedTrackPath));
      UIUtils.applyDirectionality(localView);
      return localView;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.TrackSettings
 * JD-Core Version:    0.7.0.1
 */
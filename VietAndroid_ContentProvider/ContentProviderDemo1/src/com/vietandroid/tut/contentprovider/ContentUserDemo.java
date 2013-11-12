package com.vietandroid.tut.contentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class ContentUserDemo extends Activity {
    private static final String TAG = "ContentUserDemo";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      // Get content provider and cursor
      ContentResolver cr = getContentResolver();
      Cursor cursor = cr.query(Settings.System.CONTENT_URI, null, null, null, null);

      // Let activity manage the cursor
      startManagingCursor(cursor);
      Log.d(TAG, "cursor.getCount()=" + cursor.getCount());

      // Get the list view
      ListView listView = (ListView) findViewById(R.id.listView);
      String[] from = { Settings.System.NAME, Settings.System.VALUE };
      int[] to = { R.id.textName, R.id.textValue };
      SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, from, to);
      listView.setAdapter(adapter);
    }
}
package com.vietandroid.tut.contentprovider;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class ReadingCPData extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    	Uri uriGetListTitles = Uri.parse("content://com.vietandroid.provider.Books/books");
    	Cursor c = managedQuery(uriGetListTitles, null, null, null, "title desc");
    	if(c != null)
    	{
	    	if(c.moveToFirst()){
	    		do{
	    			String bookRecord = "ID = " + c.getString(c.getColumnIndex("_id")) + " Title = " + 
					c.getString(c.getColumnIndex("title"));
	    			Toast.makeText(this, bookRecord , Toast.LENGTH_LONG).show();
	    		}while(c.moveToNext());
	    	}
    	}
    	else {
    		Toast.makeText(this, "Database is emtpy", Toast.LENGTH_SHORT).show();
    	}
    }
}
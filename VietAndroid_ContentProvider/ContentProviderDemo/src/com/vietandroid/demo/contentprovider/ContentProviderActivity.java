package com.vietandroid.demo.contentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ContentProviderActivity extends Activity {

	Button btnAddBook;
	Button btnViewList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnAddBook = (Button)findViewById(R.id.addBook);
        btnAddBook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					addBook("book1");
			}
        });
        btnViewList = (Button) findViewById(R.id.viewBook);
        btnViewList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getAllBooks();
			}
        });
    }
    
    public void addBook(String title)
    {
    	ContentValues values = new ContentValues();
    	values.put(BookProvider.TITLE, title);
    	Uri uriInsert = getContentResolver().insert(BookProvider.CONTENT_URI, values);
    	if(uriInsert != null)
    	{
    		Toast.makeText(this, "Book's added", Toast.LENGTH_SHORT).show();
    	}
    	Log.d(getClass().getSimpleName(),uriInsert.toString());
    }
    public void getAllBooks()
    {
    	Uri uriGetListTitles = Uri.parse("content://com.vietandroid.provider.Books/books");
    	Cursor c = managedQuery(uriGetListTitles, null, null, null, "title desc");
    	if(c.moveToFirst()){
    		do{
    			String bookRecord = "ID = " + c.getString(c.getColumnIndex(BookProvider._ID)) + " Title = " + 
				c.getString(c.getColumnIndex(BookProvider.TITLE));
    			Toast.makeText(this, bookRecord , Toast.LENGTH_LONG).show();
    		}while(c.moveToNext());
    	}
    }
}
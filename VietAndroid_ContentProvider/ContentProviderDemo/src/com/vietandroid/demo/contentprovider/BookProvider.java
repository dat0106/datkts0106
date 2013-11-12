package com.vietandroid.demo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class BookProvider extends ContentProvider {
	
	public static final String PROVIDER_NAME = "com.vietandroid.provider.Books";
	public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/books");
	public static final String _ID = "_id";
	public static final String TITLE = "title";
	
	public static final int BOOKS = 1;
	public static final int BOOK_ID = 2;
	
	public static final UriMatcher uriMatcher;
	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "books", BOOKS);
		uriMatcher.addURI(PROVIDER_NAME, "books/#", BOOK_ID);
	}
	
	//Using SQLiteDatabase to store all content provider data
	
	private SQLiteDatabase bookDB;
	private static final String DATABASE_NAME = "Books";
	private static final String DATABASE_TABLE = "titles";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_CREATE = 
		"create table " + DATABASE_TABLE + 
		" (_id integer primary key autoincrement, "
		+ "title text not null);";
	
	//using DatabaseHelper Class to help manage your database
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME , null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long rowID = bookDB.insert(DATABASE_TABLE, "", values);
		if(rowID > 0)
		{
			Uri mUri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(mUri, null);
			return mUri;
			
		}
		throw new SQLException("Failed to insert new row into " + uri);
	}

	@Override
	public boolean onCreate() {
		
		Context context = getContext();
		DatabaseHelper dbHelper = new DatabaseHelper(context);
		bookDB = dbHelper.getWritableDatabase();
		return (bookDB == null) ? false :true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
		sqlBuilder.setTables(DATABASE_TABLE);
		if(uriMatcher.match(uri) == BOOK_ID)
			sqlBuilder.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
		if(sortOrder == null || sortOrder == "")
			sortOrder = TITLE;
		Cursor c = sqlBuilder.query(bookDB, projection, selection, selectionArgs, null, null, sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}

}

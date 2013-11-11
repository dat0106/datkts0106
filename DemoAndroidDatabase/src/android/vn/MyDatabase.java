package android.vn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase {
	private static final String DATABASE_NAME = "DB_USER";
	private static final int DATABASE_VERSION = 1;	
	private static final String TABLE_ACCOUNT = "ACCOUNT";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_ACC = "tentaikhoan";
	public static final String COLUMN_PASSWORD = "matkhau";
	public static final String COLUMN_NAME = "hoten";
	
	private static Context context;	
	static SQLiteDatabase db;
	private OpenHelper openHelper;
	
	public MyDatabase(Context c){
		MyDatabase.context = c;
	}
	
	public MyDatabase open() throws SQLException{
		openHelper = new OpenHelper(context);
		db = openHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		 openHelper.close();
	}
	
	public long createData(String tenDN, String matKhau) {		
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_ACC, tenDN);
		cv.put(COLUMN_PASSWORD, matKhau);
		cv.put(COLUMN_NAME, "nodata");
		return db.insert(TABLE_ACCOUNT, null, cv);
	}
	
	public String getData() {
		String[] columns = new String[] {COLUMN_ID,COLUMN_ACC,COLUMN_PASSWORD,COLUMN_NAME};
		Cursor c = db.query(TABLE_ACCOUNT, columns, null, null, null, null, null);
		/*if(c==null)
			Log.v("Cursor", "C is NULL");*/
		String result="";
		int iRow = c.getColumnIndex(COLUMN_ID);
		int iN = c.getColumnIndex(COLUMN_ACC);
		int iMK = c.getColumnIndex(COLUMN_PASSWORD);
		int iHoTen = c.getColumnIndex(COLUMN_NAME);
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){			
			result = result +" "+ c.getString(iRow)
					+ " - id:" + c.getString(iN)
					+ " - pw:" + c.getString(iMK)
					+ " - ten:" + c.getString(iHoTen) + "\n";
		}
		c.close();
		//Log.v("Result", result);
		return result;
	}
	
	/*Hàm đăng nhập với đối số đầu vào là tên acc và mật khẩu*/
	public boolean kiemTraLogin(String acc,String mk){	
		Cursor c = db.rawQuery("select * from "+TABLE_ACCOUNT+" where "+COLUMN_ACC+" = ? and "+COLUMN_PASSWORD+" = ?", new String[] { acc,mk });		
		if(c.getCount()==1){
			c.close();
			return true;			
		}else{
			c.close();
			return false;
		}
	}
		
	/*Hàm xóa một tài khoản với đối số đầu vào là acc cần xóa*/
	public int deleteAcc(String acc) {
		return db.delete(TABLE_ACCOUNT, COLUMN_ACC + "='" + acc + "'", null);
	}

	/*Hàm xóa toàn bộ table ACCOUNT*/
	public int deleteAccountAll() {
		return db.delete(TABLE_ACCOUNT, null, null);
	}
	
	/*Hàm cập nhật tên người dùng với đầu vào là acc, mật khẩu và tên cần thay đổi*/
	public boolean setNameHienThi(String acc,String mk,String data){
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_NAME,data);
		long kq = db.update(TABLE_ACCOUNT,cv,COLUMN_ACC+"='"+acc+"'", null);
		if (kq==0)
			return false;
		else 
			return true;
	}
	
	/*Hàm lấy về chuỗi String là tên của tài khoản với đối số đầu vào là acc và mật khẩu*/
	public String getNameHienThi(String acc,String mk) {
		Cursor c = db.rawQuery("select * from "+TABLE_ACCOUNT+" where "+COLUMN_ACC+" = ? and "+COLUMN_PASSWORD+" = ?", new String[] { acc,mk });
		String data = "";
		if(c.getCount()==1){
			int i = c.getColumnIndex(COLUMN_NAME);
			c.moveToFirst();
			data=c.getString(i);
			c.close();
			return data;		
		}else{
			c.close();
			return "Ko Gi Ca";
		}
	}
	//---------------- class OpenHelper ------------------
	private static class OpenHelper extends SQLiteOpenHelper {
		public OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			arg0.execSQL("CREATE TABLE " + TABLE_ACCOUNT + " ("
					+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ COLUMN_ACC + " TEXT NOT NULL, "
					+ COLUMN_PASSWORD + " TEXT NOT NULL, "
					+ COLUMN_NAME + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
			onCreate(arg0);
		}
	}
}

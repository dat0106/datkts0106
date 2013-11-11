package android.vn;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button dangKyTK, hienThi, xoaHetDuLieu;
	private TextView danhSachTK;
	private MyDatabase database = new MyDatabase(this);
	private int i = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dangKyTK = (Button) findViewById(R.id.button1);
		hienThi = (Button) findViewById(R.id.button2);
		xoaHetDuLieu = (Button) findViewById(R.id.button3);
		danhSachTK = (TextView) findViewById(R.id.textView2);
		
		dangKyTK.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				database.open();
				database.createData("thanhlong90.it-" + i, "111");
				i++;
				database.close();
			}
		});
		
		hienThi.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				database.open();
				String ds = database.getData();
				database.close();
				danhSachTK.setText(ds);
			}
		});
		
		xoaHetDuLieu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				database.open();
				database.deleteAccountAll();
				database.close();
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.main, menu);		
		menu.findItem(R.id.i1).setTitle("Đăng Nhập");
		menu.findItem(R.id.i2).setTitle("Thoát");
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.i1:
			Intent intent = new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.i2:
			finish();
			break;
		
		}
		return false;
	}
}
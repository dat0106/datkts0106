package android.vn;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button btn;
    private static final String MYBROADCAST_INTENTFILTER = "android.vn";
    private Intent broadcastIntent;
    //Khởi tạo đối tượng BroadcastReceiver
    private BroadcastReceiver myBroadcastReceiver1 = new BroadcastReceiver() {
        //Định nghĩa lại hàm thực hiện nhận một sóng đã được phát đi
        @Override
        public void onReceive(Context context, Intent intent) {
            //Thực hiện việc hiển thị Toast trên thiết bị
            showToast(intent.getExtras().get("android.vn").toString());
        }
    };

    //Khởi tạo đối tượng BroadcastReceiver khác
    private BroadcastReceiver myBroadcastReceiver2 = new BroadcastReceiver() {
        //Định nghĩa lại hàm thực hiện nhận một sóng đã được phát đi
        @Override
        public void onReceive(Context context, Intent intent) {
            //Thực hiện việc hiển thị kết quả trong LogCat
            Log.v("", "Giá trị hiển thị: " + intent.getExtras().get("android.vn").toString());
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button1);

        //Đăng ký BroadcastReceiver
        registerReceiver(myBroadcastReceiver1, new IntentFilter(MYBROADCAST_INTENTFILTER));
        registerReceiver(myBroadcastReceiver2, new IntentFilter(MYBROADCAST_INTENTFILTER));

        //Tạo 1 intent có chức năng phát sóng, phát dữ liệu đi
        broadcastIntent = new Intent(MYBROADCAST_INTENTFILTER);
        broadcastIntent.putExtra("android.vn", "Đây là hướng dẫn sử dụng BroadcastReciver của thanhlong90.it!");

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Thực hiện gửi đi Broadcast
                sendBroadcast(broadcastIntent);
            }
        });
    }

    //Thực hiện việc hiển thị toast
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Hủy đăng ký BroadcastReceiver
        unregisterReceiver(myBroadcastReceiver1);
        unregisterReceiver(myBroadcastReceiver2);
    }
}

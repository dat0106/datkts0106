package android.vn;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	public final static String MUSIC_LINK = "http://mp3.zing.vn/html5/song/LmcHyknNBalVCzJyybGLm";
	public static ImageView btnPlay, btnForward, btnBackward;
	public static SeekBar songProgressBar;
	public static TextView songCurrentDurationLabel, songTotalDurationLabel;
	private EditText linkFileEdt;
	private Intent playerService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		playerService = new Intent(MainActivity.this, PlayerService.class);
		if (linkFileEdt.getText().toString().compareTo("") != 0) {
			playerService.putExtra("songLink", linkFileEdt.getText().toString());
		} else {
			playerService.putExtra("songLink", MUSIC_LINK);
			linkFileEdt.setText(MUSIC_LINK);
		}
		startService(playerService);
	}

	private void initViews() {
		btnPlay = (ImageView) findViewById(R.id.btn_play);
		btnForward = (ImageView) findViewById(R.id.btn_forward);
		btnBackward = (ImageView) findViewById(R.id.btn_backward);
		songProgressBar = (SeekBar) findViewById(R.id.song_playing_progressbar);
		songCurrentDurationLabel = (TextView) findViewById(R.id.current_time_txt);
		songTotalDurationLabel = (TextView) findViewById(R.id.total_time_txt);

		btnPlay.setOnClickListener(this);
		btnForward.setOnClickListener(this);
		btnBackward.setOnClickListener(this);
		songProgressBar.setOnClickListener(this);
		songCurrentDurationLabel.setOnClickListener(this);
		songTotalDurationLabel.setOnClickListener(this);
		linkFileEdt = (EditText) findViewById(R.id.linkfile_edt);
	}

	//Dialog xử lý tiến trình tải giữa PlayerService và MainActivity
	private ProgressDialog pdBuff = null;
	boolean mBufferBroadcastIsRegistered;
	// Thiết lập BroadcastReceiver
	private BroadcastReceiver broadcastBufferReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent bufferIntent) {
			showPD(bufferIntent);
		}
	};

	private void showPD(Intent bufferIntent) {
		String bufferValue = bufferIntent.getStringExtra("buffering");
		int bufferIntValue = Integer.parseInt(bufferValue);
		//Nếu giá trị bufferIntValue bằng 1 thì cho dialog chạy
		//Nếu giá trị bufferIntValue bằng 2 thì cho dismiss dialog
		switch (bufferIntValue) {
		case 0:
			if (pdBuff != null) {
				pdBuff.dismiss();
			}
			break;
		case 1:
			BufferDialogue();
			break;
		}
	}

	private void BufferDialogue() {
		pdBuff = ProgressDialog.show(this, "Vui lòng chờ...", "Đang tải dữ liệu...", true);
		pdBuff.setCancelable(true);
	}

	@Override
	protected void onResume() {
		//Đăng ký broadcast receiver
		if (!mBufferBroadcastIsRegistered) {
			registerReceiver(broadcastBufferReceiver, new IntentFilter(PlayerService.BROADCAST_BUFFER));
			mBufferBroadcastIsRegistered = true;
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		//Hủy đăng ký broadcast receiver
		if (mBufferBroadcastIsRegistered) {
			unregisterReceiver(broadcastBufferReceiver);
			mBufferBroadcastIsRegistered = false;
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (!PlayerService.mp.isPlaying()) {
			stopService(playerService);
		}

	}

	public void onClick(View v) {

	}
}

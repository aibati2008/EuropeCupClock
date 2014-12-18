package aray.com.clock;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import aray.com.R;

public class SetClock_Activity extends Activity {
	// Properties
	private Button msetButton;
	private Button mcancelButton;
	private Button checkButton;
	private Button ringButton;
	private TextView mTextView;
	// 就用了Java的日历
	private Calendar calendar;
	// 闹钟的id
	static int id = 0;
	// 闹钟的方法类
	private AlarmHelper helper;
	String s;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_alarm);
		s = getIntent().getStringExtra("match time");
		setTitle("闹钟设置");
		calendar = Calendar.getInstance();
		mTextView = (TextView) this.findViewById(R.id.mText);
		mTextView.setText(s);
		msetButton = (Button) this.findViewById(R.id.setTimeButton);
		mcancelButton = (Button) this.findViewById(R.id.cancelButton);
		checkButton = (Button) this.findViewById(R.id.checkButton);
		ringButton= (Button) this.findViewById(R.id.setalarm);
		helper = new AlarmHelper(this);

		msetButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calendar.setTimeInMillis(System.currentTimeMillis());
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int minute = calendar.get(Calendar.MINUTE);
				new TimePickerDialog(SetClock_Activity.this,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								calendar.setTimeInMillis(System
										.currentTimeMillis());
								// set(f, value) changes field f to value.
								calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
								calendar.set(Calendar.MINUTE, minute);
								calendar.set(Calendar.SECOND, 0);
								calendar.set(Calendar.MILLISECOND, 0);

								helper.openAlarm(id, s,
										calendar.getTimeInMillis());
								
								AlarmList.alarmSet.put(id,s);
								id++;
								Date date = new java.util.Date(System.currentTimeMillis());
								int m, h;
								if (hourOfDay < date.getHours())
									h = hourOfDay + 24 - date.getHours();
								else
									h = hourOfDay - date.getHours();
								if (minute < date.getMinutes()) {
									m = minute + 60 - date.getMinutes();
									h--;
								} else
									m = minute - date.getMinutes();

								String tmps = "距离闹钟还有： " + h+"小时 "
										+ m+"分钟";
								mTextView.setText(tmps);

							}
						}, hour, minute, true).show();

			}
		});
		mcancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// helper.closeAlarm(id-1, s);
				Intent intent = new Intent(SetClock_Activity.this,
						AlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						SetClock_Activity.this, id - 1, intent, 0);
				AlarmManager am;

				// 获取系统进程
				am = (AlarmManager) getSystemService(ALARM_SERVICE);

				// cancel
				am.cancel(pendingIntent);
				AlarmList.alarmSet.remove(id-1);
				mTextView.setText("取消了！");
			}
		});

		 checkButton.setOnClickListener(new OnClickListener() {
		
		 @Override
		 public void onClick(View v) {
		 Intent intent = new Intent("myaction8");
		 startActivity(intent);
		 overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		 }
		 });
		 
		 ringButton.setOnClickListener(new OnClickListener() {
				
			 @Override
			 public void onClick(View v) {
					new AlertDialog.Builder(SetClock_Activity.this)
					.setTitle("友情提示")
					.setMessage("功能还在完善中，敬请期待！")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
			 }
			 });

	}

	public void ringsetOnclick(View view) {
//		Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
//		intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,
//				RingtoneManager.TYPE_ALARM);
//		intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "设置闹铃声音");
//		startActivityForResult(intent, 2);

	};

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != RESULT_OK) {
			return;
		}
		Uri uri = data
				.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

		RingtoneManager.setActualDefaultRingtoneUri(this,
				RingtoneManager.TYPE_ALARM, uri);

	}

	private String format(int x) {
		String s = "" + x;
		if (s.length() == 1)
			s = "0" + s;
		return s;
	}
}
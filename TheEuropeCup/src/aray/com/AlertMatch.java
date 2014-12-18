package aray.com;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import aray.com.clock.AlarmReceiver;

public class AlertMatch extends Activity implements OnItemSelectedListener,
		OnItemClickListener {
	// private static List<String> data = new ArrayList<String>();

	private static String[] d = new String[] { "6��9�� 00:00 A��С���� ���� VS ϣ�� ",
			"6��9�� 02:45 A��С���� ����˹ VS �ݿ� ", "6��10�� 00:00 B��С���� ���� VS ���� ",
			"6��10�� 02:45 B��С���� �¹� VS ������ ", "6��11�� 00:00 C��С���� ������ VS ����� ",
			"6��11�� 02:45 C��С���� ������ VS ���޵��� ", "6��12�� 00:00 D��С���� ���� VS Ӣ���� ",
			"6��12�� 02:45 D��С���� �ڿ��� VS ��� ", "6��13�� 00:00 A��С���� ϣ�� VS �ݿ� ",
			"6��13�� 02:45 A��С���� ���� VS ����˹ ", "6��14�� 00:00 B��С���� ���� VS ������ ",
			"6��14�� 02:45 B��С���� ���� VS �¹� ", "6��15�� 00:00 C��С���� ����� VS ���޵��� ",
			"6��15�� 02:45 C��С���� ������ VS ������ ", "6��16�� 00:00 D��С���� �ڿ��� VS ���� ",
			"6��16�� 02:45 D��С���� ��� VS Ӣ���� ", "6��17�� 02:45 A��С���� ϣ�� VS ����˹ ",
			"6��17�� 02:45 A��С���� �ݿ� VS ���� ", "6��18�� 02:45 B��С���� ������ VS ���� ",
			"6��18�� 02:45 B��С���� ���� VS �¹� ", "6��19�� 02:45 C��С���� ���޵��� VS ������ ",
			"6��19�� 02:45 C��С���� ����� VS ������ ", "6��20�� 02:45 D��С���� ��� VS ���� ",
			"6��20�� 02:45 D��С���� Ӣ���� VS �ڿ��� ", "", "",
			"6��22�� 02:45 1/4���� A��С���1 VS B��С���2 ",
			"6��23�� 02:45 1/4���� B��С���1 VS A��С���2 ",
			"6��24�� 02:45 1/4���� C��С���1 VS D��С���2 ",
			"6��25�� 02:45 1/4���� D��С���1 VS C��С���2 ",
			"6��28�� 02:45 ����� 1/4������1սʤ�� VS 1/4������3սʤ�� ",
			"6��29�� 02:45 ����� 1/4������2սʤ�� VS 1/4������4սʤ�� ",
			"7��2�� 02:45 ���� �������1սʤ�� VS �������2սʤ�� " };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertinfo);
		mp3Input();
		new AlertDialog.Builder(this)
				.setMessage(R.string.alert1)
				.setPositiveButton("֪����",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();
		ListView lvCommonListView = (ListView) findViewById(R.id.lvCommonListView);

		// ��ArrayAdapter���췽�������һ�������ĳ�dataList��ϵͳ�ͻ����List���������
		// List<String> dataList = new ArrayList<String>();
		setTitle("���̰���");
		ArrayAdapter<String> aaData = new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, d);
//		mTextView.setTextColor(Color.RED);// ����������ɫ
//		mTextView.setTextSize(15);
		lvCommonListView.setAdapter(aaData);
		lvCommonListView.setOnItemClickListener(this);
		lvCommonListView.setOnItemSelectedListener(this);

	}

	private void mp3Input() {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos = new FileOutputStream(
					android.os.Environment.getExternalStorageDirectory()
							+ "/music/alarms/cuplife.mp3");
			InputStream is = getResources().getAssets().open("cuplife.mp3");

			byte[] buffer = new byte[8192];
			int count = 0;
			while ((count = is.read(buffer)) >= 0)
			{
				fos.write(buffer, 0, count);
			}
			fos.close();
			is.close();
		}
		catch (Exception e)
		{
		}
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent=new Intent("myaction6");
		intent.putExtra("match time", d[position]);
		startActivity(intent);
	 
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		Log.d("itemselected", "select " + position + " item");
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		Log.d("nothingselected", "nothing selected");

	}

	private String format(int x) {
		String s = "" + x;
		if (s.length() == 1)
			s = "0" + s;
		return s;
	}
	
	
}

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

	private static String[] d = new String[] { "6月9日 00:00 A组小组赛 波兰 VS 希腊 ",
			"6月9日 02:45 A组小组赛 俄罗斯 VS 捷克 ", "6月10日 00:00 B组小组赛 荷兰 VS 丹麦 ",
			"6月10日 02:45 B组小组赛 德国 VS 葡萄牙 ", "6月11日 00:00 C组小组赛 西班牙 VS 意大利 ",
			"6月11日 02:45 C组小组赛 爱尔兰 VS 克罗地亚 ", "6月12日 00:00 D组小组赛 法国 VS 英格兰 ",
			"6月12日 02:45 D组小组赛 乌克兰 VS 瑞典 ", "6月13日 00:00 A组小组赛 希腊 VS 捷克 ",
			"6月13日 02:45 A组小组赛 波兰 VS 俄罗斯 ", "6月14日 00:00 B组小组赛 丹麦 VS 葡萄牙 ",
			"6月14日 02:45 B组小组赛 荷兰 VS 德国 ", "6月15日 00:00 C组小组赛 意大利 VS 克罗地亚 ",
			"6月15日 02:45 C组小组赛 西班牙 VS 爱尔兰 ", "6月16日 00:00 D组小组赛 乌克兰 VS 法国 ",
			"6月16日 02:45 D组小组赛 瑞典 VS 英格兰 ", "6月17日 02:45 A组小组赛 希腊 VS 俄罗斯 ",
			"6月17日 02:45 A组小组赛 捷克 VS 波兰 ", "6月18日 02:45 B组小组赛 葡萄牙 VS 荷兰 ",
			"6月18日 02:45 B组小组赛 丹麦 VS 德国 ", "6月19日 02:45 C组小组赛 克罗地亚 VS 西班牙 ",
			"6月19日 02:45 C组小组赛 意大利 VS 爱尔兰 ", "6月20日 02:45 D组小组赛 瑞典 VS 法国 ",
			"6月20日 02:45 D组小组赛 英格兰 VS 乌克兰 ", "", "",
			"6月22日 02:45 1/4决赛 A组小组第1 VS B组小组第2 ",
			"6月23日 02:45 1/4决赛 B组小组第1 VS A组小组第2 ",
			"6月24日 02:45 1/4决赛 C组小组第1 VS D组小组第2 ",
			"6月25日 02:45 1/4决赛 D组小组第1 VS C组小组第2 ",
			"6月28日 02:45 半决赛 1/4决赛第1战胜者 VS 1/4决赛第3战胜者 ",
			"6月29日 02:45 半决赛 1/4决赛第2战胜者 VS 1/4决赛第4战胜者 ",
			"7月2日 02:45 决赛 半决赛第1战胜者 VS 半决赛第2战胜者 " };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertinfo);
		mp3Input();
		new AlertDialog.Builder(this)
				.setMessage(R.string.alert1)
				.setPositiveButton("知道了",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();
		ListView lvCommonListView = (ListView) findViewById(R.id.lvCommonListView);

		// 将ArrayAdapter构造方法的最后一个参数改成dataList，系统就会加载List对象的数据
		// List<String> dataList = new ArrayList<String>();
		setTitle("赛程安排");
		ArrayAdapter<String> aaData = new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, d);
//		mTextView.setTextColor(Color.RED);// 设置字体颜色
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

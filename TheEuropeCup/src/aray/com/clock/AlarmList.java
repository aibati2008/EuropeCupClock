package aray.com.clock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import aray.com.R;

public class AlarmList extends Activity {
	private static String[] d;
	public static HashMap<Integer, String> alarmSet = new HashMap<Integer, String>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarmlist);
		ListView listView = (ListView) findViewById(R.id.list);
		Collection<String> keys = alarmSet.values();
		Iterator<String> it = keys.iterator();
		String sb = "";
		while (it.hasNext())
			sb += it.next() + ",";
		d = sb.split(",");
		ArrayAdapter<String> Data = new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, d);
		listView.setAdapter(Data);
	}

	// 加载更新界面布局
	private void updateLayout() {

		// AlarmTimeAdapter adapter = new AlarmTimeAdapter(this, mCursor);
		// listView.setAdapter(adapter);
		// listView.setVerticalScrollBarEnabled(true);
		// listView.setOnCreateContextMenuListener(this);

	}

	private void alarm_ok() {
		// TODO Auto-generated method stub
//		finish();
		
	}

}
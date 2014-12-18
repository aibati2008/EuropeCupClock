package aray.com;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MatchInfo_Activity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matchinfo);


		Button button5 = (Button) findViewById(R.id.button5);
		Button button6 = (Button) findViewById(R.id.button6);
		Button button7 = (Button) findViewById(R.id.button7);
		Button button4 = (Button) findViewById(R.id.button8);
		setTitle("赛事信息");

		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button4.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.button5:
			intent = new Intent("myaction4");
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
			break;

		case R.id.button6:
		   Uri uri = Uri.parse("http://goal.euro2012.163.com/stat/standings.html");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
			break;

		case R.id.button7:
			uri = Uri.parse("http://goal.euro2012.163.com/stat/playerrank/goals.html");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
			break;

		case R.id.button8:
			uri = Uri.parse("http://euro2012.sina.com.cn/video/");
			intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout); 
			break;
		}

	}

}

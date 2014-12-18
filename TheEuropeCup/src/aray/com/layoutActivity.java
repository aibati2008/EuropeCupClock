package aray.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class layoutActivity extends Activity implements
		OnMenuItemClickListener, OnClickListener {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView1.setVisibility(imageView1.GONE);
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		Button button4 = (Button) findViewById(R.id.button4);
		setTitle("欧洲杯球迷必备");

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.button1:
			intent = new Intent("myaction1");
			startActivity(intent);
			overridePendingTransition(R.anim.fade, R.anim.fade);
			break;

		case R.id.button2:
			intent = new Intent("myaction5");
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			break;

		case R.id.button3:
			intent = new Intent("myaction3");
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

			break;

		case R.id.button4:
			intent = new Intent("myaction9");
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

			break;
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {

		case 1:
			Uri uri = Uri.parse("smsto:");
			Intent it = new Intent(Intent.ACTION_SENDTO, uri);
			it.putExtra("sms_body", "我正在使用欧洲杯闹钟，看球必备哦，下载地址：");
			startActivity(it); 
			break;
		case 2:
			Intent intent = new Intent("myaction10");
			startActivity(intent);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
			break;
		case 3:
			intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			System.exit(0);
			android.os.Process.killProcess(android.os.Process.myPid());
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			break;
		}
		return true;
	}

	// 单击Menu按钮时调用该方法来建立Activity菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 1, 0, "推荐给好友");
		menu.add(0, 2, 0, "关于我们");
		menu.add(0, 3, 0, "退出");
		// menu.getItem(0).setTitle("推荐给好友");
		// menu.getItem(1).setTitle("关于我们");
		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

}
package aray.com;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class MatchGuess_Activity extends Activity implements
		OnRatingBarChangeListener {
	private String[] team = new String[] { "波兰", "俄罗斯", "捷克", "希腊", "荷兰", "德国",
			"葡萄牙", "丹麦", "西班牙", "意大利", "爱尔兰", "克罗地亚", "法国", "英格兰", "乌克兰", "瑞典" };
	private int ability_1 = 0, ability_2 = 0;
	private int name1, name2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teamchoice);
		new AlertDialog.Builder(this)
				.setTitle("竞猜提示")
				.setMessage(R.string.readme)
				.setPositiveButton("知道了",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();
		RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingbar1);
		RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingbar2);
		RatingBar ratingBar3 = (RatingBar) findViewById(R.id.ratingbar3);
		RatingBar ratingBar4 = (RatingBar) findViewById(R.id.ratingbar4);
		RatingBar ratingBar5 = (RatingBar) findViewById(R.id.ratingbar5);
		RatingBar ratingBar6 = (RatingBar) findViewById(R.id.ratingbar6);
		RatingBar ratingBar7 = (RatingBar) findViewById(R.id.ratingbar7);
		RatingBar ratingBar8 = (RatingBar) findViewById(R.id.ratingbar8);
		ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

		ratingBar1.setOnRatingBarChangeListener(this);
		ratingBar2.setOnRatingBarChangeListener(this);
		ratingBar3.setOnRatingBarChangeListener(this);
		ratingBar4.setOnRatingBarChangeListener(this);
		ratingBar5.setOnRatingBarChangeListener(this);
		ratingBar6.setOnRatingBarChangeListener(this);
		ratingBar7.setOnRatingBarChangeListener(this);
		ratingBar8.setOnRatingBarChangeListener(this);
		setTitle("比赛竞猜");
	}

	public void onClick_pk(View view) {
		final TextView textview11 = (TextView) findViewById(R.id.textview11);
		final TextView textview12 = (TextView) findViewById(R.id.textview12);
		final ProgressBar pb = (ProgressBar) findViewById(R.id.ProBar);
		textview11.setVisibility(View.INVISIBLE);
		pb.setVisibility(View.VISIBLE);
		textview12.setVisibility(View.VISIBLE);
		Vibrate(MatchGuess_Activity.this);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {

				pb.setVisibility(View.INVISIBLE);
				textview12.setVisibility(View.INVISIBLE);
				textview11.setVisibility(View.VISIBLE);

			}
		}, 4000);

		String score = getScore(ability_1, ability_2);
		String html = "<font color='red'>全场比分为：</font><br>";
		html += "<font color='#0000FF' ><big><b>" + score
				+ "</b></big></font><p>";
		CharSequence charSequence = Html.fromHtml(html);
		textview11.setText(charSequence);
	}

	private String getScore(int a, int b) {
		String s;
		Random r = new Random();
		if (ability_1 > ability_2)
			s = r.nextInt(4) + ":" + r.nextInt(2);
		else
			s = r.nextInt(2) + ":" + r.nextInt(4);
		return s;
		// TODO Auto-generated method stub

	}

	public void onClick_team1(View view) {
		new AlertDialog.Builder(this).setTitle("选择球队")
				.setSingleChoiceItems(team, -1, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Button button9 = (Button) findViewById(R.id.button9);
						button9.setText(team[which]);
						name1 = which;
						dialog.cancel();
					}
				}).show();
	}

	public void onClick_team2(View view) {
		new AlertDialog.Builder(this).setTitle("选择球队")
				.setSingleChoiceItems(team, -1, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Button button10 = (Button) findViewById(R.id.button10);
						button10.setText(team[which]);
						name2 = which;
						dialog.cancel();
					}
				}).show();
	}

	public void onClick_share(View view) {

		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/jpeg"); // 分享的数据类型
		intent.putExtra(Intent.EXTRA_SUBJECT, "subject"); // 主题
		intent.putExtra(Intent.EXTRA_STREAM,Uri.parse("/sdcard/share.jpg")); // 内容
		startActivity(Intent.createChooser(intent, "title")); // 目标应用选择对话框的标题
		// TODO Auto-generated method stub

	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		TextView textview1 = (TextView) findViewById(R.id.textView1);
		TextView textview2 = (TextView) findViewById(R.id.textView2);
		TextView textview3 = (TextView) findViewById(R.id.textView3);
		TextView textview4 = (TextView) findViewById(R.id.textView4);
		TextView textview5 = (TextView) findViewById(R.id.textView5);
		TextView textview6 = (TextView) findViewById(R.id.textView6);
		TextView textview7 = (TextView) findViewById(R.id.textView7);
		TextView textview8 = (TextView) findViewById(R.id.textView8);
		switch (ratingBar.getId()) {
		case R.id.ratingbar1:
			textview1.setText(team[name1] + "的进攻" + getLevel(rating));
			ability_1 += rating;
			break;

		case R.id.ratingbar2:
			textview2.setText(team[name1] + "的防守" + getLevel(rating));
			ability_1 += rating;
			break;

		case R.id.ratingbar3:
			textview3.setText(team[name2] + "的进攻" + getLevel(rating));
			ability_2 += rating;
			break;

		case R.id.ratingbar4:
			textview4.setText(team[name2] + "的防守" + getLevel(rating));
			ability_2 += rating;
			break;
		case R.id.ratingbar5:
			textview5.setText(team[name1] + "的配合" + getLevel(rating));
			ability_1 += rating;
			break;

		case R.id.ratingbar6:
			textview6.setText(team[name2] + "的配合" + getLevel(rating));
			ability_2 += rating;
			break;
		case R.id.ratingbar7:
			textview7.setText(team[name1] + "的技术" + getLevel(rating));
			ability_1 += rating;
			break;

		case R.id.ratingbar8:
			textview8.setText(team[name2] + "的技术" + getLevel(rating));
			ability_2 += rating;
			break;
		}
	}

	private String getLevel(float rating) {
		// TODO Auto-generated method stub
		String s;
		if (rating > 3.5)
			s = "很强";
		else if (rating < 2)
			s = "很弱";
		else
			s = "一般";
		return s;
	}

	public static void Vibrate(final Activity activity) {

		Vibrator vib = (Vibrator) activity
				.getSystemService(Service.VIBRATOR_SERVICE);

		long[] pattern = { 800, 50, 400, 30, 800, 50, 400, 30, 800, 50, 400, 30 }; // OFF/ON/OFF/ON...
		vib.vibrate(pattern, -1);// -1不重复，非-1为从pattern的指定下标开始重复

	}
}
/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aray.com.clock;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.WindowManager;
import aray.com.R;
import aray.com.clock.AlarmReceiver;

public class AlarmAlert extends Activity {
	
	MediaPlayer mp = new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String s = getIntent().getStringExtra("match time");

    	mp = MediaPlayer.create(this, R.raw.cuplife);
		mp.start();
		new AlertDialog.Builder(AlarmAlert.this)
				.setTitle("比赛提醒")
				.setMessage(s)
				.setPositiveButton("已经醒了 - -!",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								mp.stop();
								System.exit(0);
								android.os.Process
										.killProcess(android.os.Process.myPid());
								getWindow()
										.setFlags(
												WindowManager.LayoutParams.FLAG_FULLSCREEN,
												WindowManager.LayoutParams.FLAG_FULLSCREEN);
							}
						}).show();
	}

	
}

package aray.com.clock;

import java.io.IOException;
import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import aray.com.R;

public class AlarmReceiver extends BroadcastReceiver {

	private MediaPlayer mMediaPlayer;
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
    	 intent.setClass(context, AlarmAlert.class);
         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//         mp=MediaPlayer.create(context, R.raw.cuplife);
//         mp.start();
         context.startActivity(intent);
        //在这里是播放不了的！！
        //playAlarmRing();
    }

    public void playAlarmRing() {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(context, uri);
            final AudioManager audioManager = (AudioManager) context
                    .getSystemService(Context.AUDIO_SERVICE);
            if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
                mMediaPlayer.setLooping(true);
                mMediaPlayer.prepare();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.start();
    }

    private void StopAlarmRing() {
        mMediaPlayer.stop();
    }

}

package aray.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.Gallery;
import android.widget.ImageView;;

public class EuropeClockActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
       
       // ȫ��
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**ȫ�����ã����ش�������װ��*/ 
     
        setContentView(R.layout.main);
        
        
    }
    
    public  void onClick_Connect(View view) {
    	Intent intent=null;
    	intent=new Intent("myaction0");
    	startActivity(intent);      
		// TODO Auto-generated method stub

	}
}
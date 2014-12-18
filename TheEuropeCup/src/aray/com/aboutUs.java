package aray.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

public class aboutUs extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.textprint);
        TextView textview=(TextView) findViewById(R.id.textview);
        textview.setMovementMethod(ScrollingMovementMethod.getInstance());
//		StringBuffer sb = new StringBuffer();
//		sb.append("made by£ºaray");
//		sb.append("\n");
//		sb.append("version:1.0");
		
    }
    
  
}
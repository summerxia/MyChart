package com.voodoo.mychart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	Button btnChart;
	Button btnTable;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnChart = (Button) findViewById(R.id.btn_chart);
        btnTable = (Button) findViewById(R.id.btn_table);
        
        btnChart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, LineActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getApplication().startActivity(intent);
			}
		});
       
        
    }
    @Override  
    protected void onResume() {
//    	if(getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//		}
    	super.onResume();
    }
}

package com.voodoo.mychart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.voodoo.entity.LineEntity;
import com.voodoo.view.LineChart;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<String> xTitle = new ArrayList<String>();
        List<String> yTitle = new ArrayList<String>();
        
        for(int i = 200; i < 240; i+=10){
        	yTitle.add("" + i);
        }
        for(int i = 0; i < 10; i++){
        	xTitle.add("" + i);
        }
        
        Map<Float,Integer> map = new TreeMap<Float,Integer>();
        map.put(1.0f, 200);
        map.put(1.0f, 210);
        map.put(1.3f, 227);
        map.put(2.4f, 215);
        map.put(3.0f, 230);
        map.put(8.5f, 220);
        
        
        Map<Float,Integer> map1 = new TreeMap<Float,Integer>();
        map1.put(0.0f, 200);
        map1.put(1.2f, 220);
//        map1.put(1.5f, 217);
//        map1.put(2.0f, 230);
//        map1.put(3.5f, 225);
//        map1.put(8.5f, 220);
        
//        for(Float f : map.keySet()){
//        	Log.d("--------", f.toString());
//        }
//        for(Integer i : map.values()){
//        	Log.d("-----------", i.toString());
//        }
        
        
        LineChart chart = (LineChart) findViewById(R.id.view_line_chart);
        LineEntity entity = new LineEntity(map, ""	, Color.GREEN);
		LineEntity entity1 = new LineEntity(map1, "", Color.YELLOW);
        
        List<LineEntity> lines = new ArrayList<LineEntity>();
        lines.add(entity);
        lines.add(entity1);
        chart.setLines(lines);
        chart.setAxisXTitles(xTitle);
        chart.setAxisYTitles(yTitle);
    }
    @Override
    protected void onResume() {
//    	if(getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
//			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//		}
    	super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

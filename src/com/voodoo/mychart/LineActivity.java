package com.voodoo.mychart;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.voodoo.entity.LineEntity;
import com.voodoo.view.LineChart;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class LineActivity extends ActionBarActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_line);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.line, menu);
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

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			
			return new PlaceholderFragment(position);
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public  class PlaceholderFragment extends Fragment {
		
		int position;

		public PlaceholderFragment(int position) {
			this.position = position;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			switch (position) {
			case 0:
				return createChartNormalView(inflater, container);
			case 1:
				return createChart24HView(inflater, container);
			}
			return null;
		}
		
		private View createChartNormalView(LayoutInflater inflater, ViewGroup container){
			View chartNormal = inflater.inflate(R.layout.fragment_chart_normal, container, false);
	        List<String> xTitle = new ArrayList<String>();
	        List<String> yTitle = new ArrayList<String>();
	        
	        for(int i = 200; i < 240; i+=10){
	        	yTitle.add("" + i);
	        }
	        for(int i = 0; i < 10; i++){
	        	xTitle.add("" + i);
	        }
	        
	        Map<Float,Integer> map = new TreeMap<Float,Integer>();
	        map.put(0.5f, 210);
	        map.put(1.0f, 210);
	        map.put(1.3f, 227);
	        map.put(2.4f, 215);
	        map.put(3.0f, 230);
	        map.put(8.5f, 220);
	        
	        
	        Map<Float,Integer> map1 = new TreeMap<Float,Integer>();
	        map1.put(0.0f, 200);
	        map1.put(1.2f, 190);
	        map1.put(1.5f, 217);
	        map1.put(2.0f, 230);
	        map1.put(3.5f, 225);
	        map1.put(8.5f, 220);
	        
	        LineChart chart = (LineChart) chartNormal.findViewById(R.id.view_line_chart);
	        LineEntity entity = new LineEntity(map, ""	, Color.GREEN);
			LineEntity entity1 = new LineEntity(map1, "", Color.YELLOW);
	        
	        List<LineEntity> lines = new ArrayList<LineEntity>();
	        lines.add(entity);
	        lines.add(entity1);
	        chart.setLines(lines);
	        chart.setAxisXTitles(xTitle);
	        chart.setAxisYTitles(yTitle);
			return chartNormal;
			
		}
		private View createChart24HView(LayoutInflater inflater, ViewGroup container){
			View chart24H = inflater.inflate(R.layout.fragment_chart_24h, container, false);
	        List<String> xTitle = new ArrayList<String>();
	        List<String> yTitle = new ArrayList<String>();
	        
	        for(int i = 200; i < 240; i+=10){
	        	yTitle.add("" + i);
	        }
	        for(int i = 0; i < 15; i++){
	        	xTitle.add("" + i);
	        }
	        
	        Map<Float,Integer> map = new TreeMap<Float,Integer>();
	        map.put(0.3f, 100);
	        map.put(1.0f, 115);
	        map.put(1.5f, 123);
	        map.put(2.4f, 140);
	        map.put(3.0f, 150);
	        map.put(8.5f, 134);
	        map.put(10.5f, 144);
	        
	        LineChart chart = (LineChart) chart24H.findViewById(R.id.view_line_chart_24);
	        LineEntity entity = new LineEntity(map, ""	, Color.BLUE);
	        List<LineEntity> lines = new ArrayList<LineEntity>();
	        lines.add(entity);
	        chart.setAlertBloodPressure(140);
	        chart.setLines(lines);
	        chart.setAxisXTitles(xTitle);
	        chart.setAxisYTitles(yTitle);
			return chart24H;
		}
	}
}

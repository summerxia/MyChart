package com.voodoo.entity;

import java.util.Map;
import java.util.TreeMap;

public class LineEntity {
	
	/** 线表示数据 */
	private Map<Float,Integer> lineData;
	
	/** 线标题*/
	private String title;
	
	/** 线表示颜色 */
	private int lineColor;
	
	
	public LineEntity(Map<Float,Integer> lineData, String title, int lineColor) {
		super();
		this.lineData = lineData;
		this.title = title;
		this.lineColor = lineColor;
	}
	
	public void put(Float key, Integer value){
		if (null == lineData){
			lineData = new TreeMap<Float,Integer>();
		}
		lineData.put(key, value);
	}

	public Map<Float,Integer> getLineData() {
		return lineData;
	}

	public void setLineData(Map<Float,Integer> lineData) {
		this.lineData = lineData;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLineColor() {
		return lineColor;
	}

	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}
	
}

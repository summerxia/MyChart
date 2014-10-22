package com.voodoo.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.voodoo.entity.LineEntity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class LineChart extends View{
	
	// ////////////默认值////////////////
	/** 默认背景色 */
	public static final int DEFAULT_BACKGROUD_COLOR = Color.BLACK;

	/** 默认X坐标轴颜色 */
	public static final int DEFAULT_AXIS_X_COLOR = Color.GRAY;

	/** 默认Y坐标轴颜色 */
	public static final int DEFAULT_AXIS_Y_COLOR = Color.GRAY;

	/** 默认经线颜色 */
	public static final int DEFAULT_LONGITUDE_COLOR = Color.GRAY;

	/** 默认纬线颜色 */
	public static final int DEFAULT_LAITUDE_COLOR = Color.GRAY;

	/** 默认轴线左边距离*/
	public static final float DEFAULT_AXIS_MARGIN_LEFT = 30f;

	/** 默认轴线底边距离*/
	public static final float DEFAULT_AXIS_MARGIN_BOTTOM = 16f;

	/** 默认轴线上边距离*/
	public static final float DEFAULT_AXIS_MARGIN_TOP = 5f;

	/** 默认轴线右边距离*/
	public static final float DEFAULT_AXIS_MARGIN_RIGHT = 5f;

	/** 默认经线是否显示刻度 */
	public static final boolean DEFAULT_DISPLAY_LONGTITUDE = Boolean.TRUE;

	/** 默认经线是否使用虚线 */
	public static final boolean DEFAULT_DASH_LONGTITUDE = Boolean.TRUE;

	/** 默认纬线是否显示刻度 */
	public static final boolean DEFAULT_DISPLAY_LATITUDE = Boolean.TRUE;

	/** 默认纬线是否使用虚线 */
	public static final boolean DEFAULT_DASH_LATITUDE = Boolean.TRUE;

	/** 默认是否显示X轴刻度 */
	public static final boolean DEFAULT_DISPLAY_AXIS_X_TITLE = Boolean.TRUE;

	/** 默认是否显示X轴刻度 */
	public static final boolean DEFAULT_DISPLAY_AXIS_Y_TITLE = Boolean.TRUE;

	/** 默认经线刻度字体颜色 **/
	private int DEFAULT_LONGTITUDE_FONT_COLOR = Color.GRAY;

	/** 默认经线刻度字体大小**/
	private int DEFAULT_LONGTITUDE_FONT_SIZE = 12;

	/** 默认经线刻度字体颜色 **/
	private int DEFAULT_LATITUDE_FONT_COLOR = Color.GRAY;;

	/** 默认经线刻度字体颜色 **/
	private int DEFAULT_LATITUDE_FONT_SIZE = 12;
	
	/** 默认虚线效果 */
	public static final PathEffect DEFAULT_DASH_EFFECT = new DashPathEffect(
			new float[] { 3, 3, 3, 3 }, 1);
	
	/**背景色**/
	private int backgroudColor = DEFAULT_BACKGROUD_COLOR;

	/**  x轴颜色**/
	private int axisXColor = DEFAULT_AXIS_X_COLOR;

	/**  y轴颜色**/
	private int axisYColor = DEFAULT_AXIS_Y_COLOR;

	/** 经线颜色 */
	private int longitudeColor = DEFAULT_LONGITUDE_COLOR;

	/** 纬线颜色 */
	private int latitudeColor = DEFAULT_LAITUDE_COLOR;

	/** 轴线左边*/
	private float axisMarginLeft = DEFAULT_AXIS_MARGIN_LEFT;

	/** 轴线底边*/
	private float axisMarginBottom = DEFAULT_AXIS_MARGIN_BOTTOM;

	/** 轴线上边*/
	private float axisMarginTop = DEFAULT_AXIS_MARGIN_TOP;

	/** 轴线右边*/
	private float axisMarginRight = DEFAULT_AXIS_MARGIN_RIGHT;

	/** 经线是否显示 */
	private boolean displayAxisXTitle = DEFAULT_DISPLAY_AXIS_X_TITLE;

	/** 经线是否显示 */
	private boolean displayAxisYTitle = DEFAULT_DISPLAY_AXIS_Y_TITLE;

	/** 经线是否显示 */
	private boolean displayLongitude = DEFAULT_DISPLAY_LONGTITUDE;

	/** 经线是否使用虚线 */
	private boolean dashLongitude = DEFAULT_DASH_LONGTITUDE;

	/** 纬线是否显示 */
	private boolean displayLatitude = DEFAULT_DISPLAY_LATITUDE;

	/** 纬线是否使用虚线 */
	private boolean dashLatitude = DEFAULT_DASH_LATITUDE;

	/** 虚线效果 */
	private PathEffect dashEffect = DEFAULT_DASH_EFFECT;

	/** 经线刻度字体颜色 **/
	private int longtitudeFontColor = DEFAULT_LONGTITUDE_FONT_COLOR;

	/** 经线刻度字体颜色 **/
	private int longtitudeFontSize = DEFAULT_LONGTITUDE_FONT_SIZE;

	/** 经线刻度字体颜色 **/
	private int latitudeFontColor = DEFAULT_LATITUDE_FONT_COLOR;

	/** 经线刻度字体颜色 **/
	private int latitudeFontSize = DEFAULT_LATITUDE_FONT_SIZE;

	/** 横轴刻度**/
	private List<String> axisXTitles;

	/** 纵轴刻度**/
	private List<String> axisYTitles;

	
	

	private final String TAG = "-------LineChart-----------";
	
	private List<LineEntity> lines;
	
	public LineChart(Context context) {
		super(context);
	}
	
	public LineChart(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public LineChart(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	Paint paint = new Paint();
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		drawXAxis(canvas);
		drawYAxis(canvas);
		drawAxisGridX(canvas);
		drawAxisGridY(canvas);
		drawLine(canvas);
		
	}
	
	/**
	 * 绘制X轴
	 * 
	 * @param canvas
	 */
	private void drawXAxis(Canvas canvas) {

		float length = super.getWidth();
		float postY = super.getHeight() - axisMarginBottom - 1;

		Paint mPaint = new Paint();
		mPaint.setColor(axisXColor);

		canvas.drawLine(0f, postY, length, postY, mPaint);
	}

	/**
	 * 绘制Y轴
	 * 
	 * @param canvas
	 */
	private void drawYAxis(Canvas canvas) {

		float length = super.getHeight() - axisMarginBottom;
		float postX = axisMarginLeft + 1;

		Paint mPaint = new Paint();
		mPaint.setColor(axisXColor);

		canvas.drawLine(postX, 0f, postX, length, mPaint);
	}
	
	
	/**
	 * 绘制经线(竖线)
	 * 
	 * @param canvas
	 */
	private void drawAxisGridX(Canvas canvas) {

		if (null != axisXTitles) {

			int counts = axisXTitles.size();
			float length = super.getHeight() - axisMarginBottom;
			Paint mPaintLine = new Paint();
			mPaintLine.setColor(longitudeColor);
			if (dashLongitude) {
				mPaintLine.setPathEffect(dashEffect);
			}

			// 绘制字体paint
			Paint mPaintFont = new Paint();
			mPaintFont.setColor(longtitudeFontColor);
			mPaintFont.setTextSize(longtitudeFontSize);
			mPaintFont.setAntiAlias(true);
			if (counts > 1) {
				float postOffset = (super.getWidth() - axisMarginLeft - 2 * axisMarginRight) / (counts - 1);
				float offset = axisMarginLeft;
				for (int i = 1; i <= counts; i++) {
					// 绘制线条
					if (displayLongitude) {
						canvas.drawLine(offset + i * postOffset, 0f, offset + i * postOffset, length, mPaintLine);
					}
					// 绘制刻度
					if (displayAxisXTitle) {
						if (i < counts && i > 0) {
							canvas.drawText(axisXTitles.get(i), offset + i
									* postOffset
									- (axisXTitles.get(i).length())
									* longtitudeFontSize / 2f, super
									.getHeight()
									- axisMarginBottom + longtitudeFontSize,
									mPaintFont);
						} else if (0 == i) {
							canvas.drawText(axisXTitles.get(i),
									this.axisMarginLeft + 2f, super.getHeight()
											- axisMarginBottom
											+ longtitudeFontSize, mPaintFont);
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 绘制纬线
	 * 
	 * @param canvas
	 */
	private void drawAxisGridY(Canvas canvas) {
		if (null != axisYTitles) {
			int counts = axisYTitles.size();
			float length = super.getWidth() - axisMarginLeft;
			// 线条Paint
			Paint mPaintLine = new Paint();
			mPaintLine.setColor(latitudeColor);
			if (dashLatitude) {
				mPaintLine.setPathEffect(dashEffect);
			}
			// 字体Paint
			Paint mPaintFont = new Paint();
			mPaintFont.setColor(latitudeFontColor);
			mPaintFont.setTextSize(latitudeFontSize);
			mPaintFont.setAntiAlias(true);

			
			if (counts > 1) {
				float postOffset = (super.getHeight() - axisMarginBottom - 2 * axisMarginTop) / (counts - 1);
				float offset = super.getHeight() - axisMarginBottom;
				for (int i = 1; i <= counts; i++) {
					// 绘制线条
					if (displayLatitude) {
						canvas.drawLine(axisMarginLeft,offset - i * postOffset, axisMarginLeft+ length, offset - i * postOffset, mPaintLine);
					}
					// 绘制刻度
					if (displayAxisYTitle) {
						if (i < counts && i > 0) {
							canvas.drawText(axisYTitles.get(i), 0f, offset - i
									* postOffset + latitudeFontSize / 2f,
									mPaintFont);
						} else if (0 == i) {
							canvas.drawText(axisYTitles.get(i), 0f, super
									.getHeight()
									- this.axisMarginBottom - 2f, mPaintFont);
						}
					}
				}
			}
		}
	}
	/**
	 * 绘制折线
	 * @param canvas
	 */
	private void drawLine(Canvas canvas){
		
		Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

		float xLength = super.getWidth() - axisMarginLeft - 2 * axisMarginRight;
		float yLength = super.getHeight() - axisMarginBottom - 2 * axisMarginTop;
		float startX = axisMarginLeft;
		float startY = super.getHeight() - axisMarginBottom;
		float stopX = 0f;
		float stopY =0f;
		
		for(int i = 0; i < lines.size(); i++){
			LineEntity line = lines.get(i);
			mPaint.setColor(line.getLineColor());
			Map<Float,Integer> data = line.getLineData();
			List<Integer> values = new ArrayList<Integer>(data.values());
			float max = 0.0f, min = Float.MAX_VALUE;
			for(int j = 0; j < values.size(); j++){
				float element = (float)values.get(j);
				if(element > max)
					max = element;
				if(element < min)
					min = element;
			}
			//Log.d(TAG, "max " + max);
			float range = max - min;
			Log.d(TAG, "range" + range);
			for(Float key : data.keySet()){
				//Log.d("key", key.toString());
				float value = (float)data.get(key);
				//Log.d("value", value + "");
				stopX = axisMarginLeft + (key / ((float)axisXTitles.size() - 1.0f)) * xLength;
				//Log.d("stopX", value + "");
				stopY = super.getHeight() - axisMarginBottom - ((value - min) / range) * yLength;
				//Log.d("stopY", value + "");
				canvas.drawLine(startX, startY, stopX, stopY, mPaint);
				startX = stopX;
				startY = stopY;
			}
		}
	}
	
	

	
	
	
	/**
	 * 重新控件大小
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(measureWidth(widthMeasureSpec),
				measureHeight(heightMeasureSpec));
	}

	private int measureWidth(int measureSpec) {
		int result = 0;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
			//Log.d(TAG, "exactly "+result);
		} else if (specMode == MeasureSpec.AT_MOST) {
			result = Math.min(result, specSize);
			//Log.d(TAG, "at_most "+result);
		}
		return result;
	}

	private int measureHeight(int measureSpec) {
		int result = 0;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		} else if (specMode == MeasureSpec.AT_MOST) {
			result = Math.min(result, specSize);
		}
		return result;
	}
	
	


	public void setLines(List<LineEntity> lines) {
		this.lines = lines;
	}

	public List<String> getAxisXTitles() {
		return axisXTitles;
	}

	public void setAxisXTitles(List<String> axisYTitles) {
		this.axisXTitles = axisYTitles;
	}
	
	
	public List<String> getAxisYTitles() {
		return axisYTitles;
	}

	public void setAxisYTitles(List<String> axisYTitles) {
		this.axisYTitles = axisYTitles;
	}

	public int getBackgroudColor() {
		return backgroudColor;
	}

	public void setBackgroudColor(int backgroudColor) {
		this.backgroudColor = backgroudColor;
	}

	public int getAxisYColor() {
		return axisYColor;
	}

	public void setAxisYColor(int axisYColor) {
		this.axisYColor = axisYColor;
	}
	
	
	
}

package com.cyq.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyViewPager  extends ViewPager{
	  public MyViewPager(Context paramContext){
	    super(paramContext);
	  }
	  
	  public MyViewPager(Context paramContext, AttributeSet paramAttributeSet){
	    super(paramContext, paramAttributeSet);
	  }
	  
	  private float mLastMotionX;
	  @Override
	public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
		final float x = paramMotionEvent.getRawX();
		int i = paramMotionEvent.getAction();
		boolean bool = super.onInterceptTouchEvent(paramMotionEvent);

		switch (i) {
		case MotionEvent.ACTION_DOWN:
			mLastMotionX = x;
		case MotionEvent.ACTION_MOVE:
			Log.e("x--->"+x,"mLastMotionX--->"+ mLastMotionX+"x-mLastMotionX--->"+(x-mLastMotionX));
			Log.e("getCurrentItem()-->",""+ getCurrentItem());
			if (x-mLastMotionX > 0 && getCurrentItem() == 0) {
				Log.e("11111111111111->",""+ getCurrentItem());
				getParent().requestDisallowInterceptTouchEvent(false);
				return bool;
			}
			break;
		}
		Log.e("22222222222-->",""+ getCurrentItem());
		getParent().requestDisallowInterceptTouchEvent(true);
		return bool;
	}

}

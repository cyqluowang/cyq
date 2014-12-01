package com.cyq.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.cyq.fragment.OneFragment;
import com.cyq.fragment.TwoFragment;
import com.cyq.view.PagerSlidingTabStrip;
import com.example.viewpageindicator.R;

public class MainActivity extends FragmentActivity {
	/** 上面的导航栏  **/
	private PagerSlidingTabStrip tabs;
	/** ViewPager **/
	private ViewPager mPager;
	/** 适配器   **/
	private PagerAdapter  mAdapter;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		mPager = (ViewPager) findViewById(R.id.view_pager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);	
		mAdapter = new PagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		tabs.setViewPager(mPager);
		tabs.setShowDirver(false);
		tabs.setTextColorResource(R.color.tab_text_color);
		tabs.setTextSize(sp2px(MainActivity.this,15));
		
	}
	

	/** ViewPager适配器   **/
	public class PagerAdapter extends FragmentPagerAdapter {
		private final String[] TITLES = { "话题", "小组", "精选" };
		
		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public Fragment getItem(int arg0) {
			if(arg0 == 2){
				return new TwoFragment();
			}
			
			if(arg0 == 0){
				return OneFragment.newInstance(R.color.A);
			}
			if(arg0 == 1){
				return OneFragment.newInstance(R.color.B);
			}
			return null;
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}
	}


	 public static int sp2px(Context context, float spValue) {  
	        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;  
	        return (int) (spValue * fontScale + 0.5f);  
	    }  

}

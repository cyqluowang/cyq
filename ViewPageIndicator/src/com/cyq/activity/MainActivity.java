package com.cyq.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.cyq.fragment.OneFragment;
import com.cyq.fragment.TwoFragment;
import com.cyq.sherlock.TestActivity;
import com.cyq.view.PagerSlidingTabStrip;
import com.example.viewpageindicator.R;

public class MainActivity extends FragmentActivity {
	/** 上面的导航栏  **/
	private PagerSlidingTabStrip tabs;
	/** ViewPager **/
	private ViewPager mPager;
	/** 适配器   **/
	private PagerAdapter  mAdapter;

	private PopupWindow popupWindow; 
	private View mPopupWindowView; 
	private View pivot; 
	
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
		
		
		pivot = findViewById(R.id.pivot);
		mPopupWindowView = LayoutInflater.from(this).inflate(R.layout.home_pop,null);
		RelativeLayout post= (RelativeLayout) mPopupWindowView.findViewById(R.id.layout_post);
		popupWindow = new PopupWindow(mPopupWindowView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(0000000000));
	      
		post.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				popupWindow.dismiss();  
				Intent i =new Intent(MainActivity.this, TestActivity.class);
				startActivity(i);
				
			}
		});
		
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


	@SuppressLint({ "NewApi", "InflateParams" })
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home_menu, menu);
		
		ActionBar actionBar=getActionBar();
		actionBar.setCustomView(LayoutInflater.from(this).inflate(R.layout.actionbar_title, null)); 
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
		
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		return super.onCreateOptionsMenu(menu);
	}

	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.e("--->", item.getItemId()+"");
		if(item.getItemId() == R.id.info){
			if (!popupWindow.isShowing()) {  
				popupWindow.showAsDropDown(pivot,getWindowManager().getDefaultDisplay().getWidth()-mPopupWindowView.getWidth(),0);  
	        } else {  
	        	popupWindow.dismiss();  
	        }  
		}
		
		if(item.getItemId() == R.id.message){
			Intent i =new Intent(this, TestActivity.class);
			startActivity(i);
			
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	 public static int sp2px(Context context, float spValue) {  
	        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;  
	        return (int) (spValue * fontScale + 0.5f);  
	    }  

}

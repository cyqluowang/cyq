package com.cyq.sherlock;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.viewpageindicator.R;

public class TestActivity extends Activity {
	private PopupWindow popupWindow; 
	private View mPopupWindowView; 
	private View pivot; 
	
	@SuppressLint("InflateParams")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
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
				Intent i =new Intent(TestActivity.this, TestActivity.class);
				startActivity(i);
				
			}
		});

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
}

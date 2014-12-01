package com.cyq.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.viewpageindicator.R;
import com.viewpagerindicator.TabPageIndicator;

public class TwoFragment extends Fragment {

	private static final String[] TITLE = new String[] { "��ѡ", "�Ļ�", "����", "����",
														"ʱ��", "����", "�Ƽ�" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View contextView = inflater.inflate(R.layout.two_fragment, container, false);
		
		//ViewPager��adapter
		FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getChildFragmentManager());
		com.cyq.view.MyViewPager pager = (com.cyq.view.MyViewPager)contextView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //ʵ����TabPageIndicatorȻ������ViewPager��֮����
        TabPageIndicator indicator = (TabPageIndicator)contextView.findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        
        //�������Ҫ��ViewPager���ü�������indicator���þ�����
        indicator.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				Toast.makeText(getActivity().getApplicationContext(), TITLE[arg0], Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
        return contextView;
	}

	
	/**
	 * ViewPager������
	 * @author len
	 *
	 */
    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	//�½�һ��Fragment��չʾViewPager item�����ݣ������ݲ���
        	Fragment fragment = new ThreeFragment();  
            Bundle args = new Bundle();  
            args.putString("arg", TITLE[position]);  
            fragment.setArguments(args);  
        	
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }

}

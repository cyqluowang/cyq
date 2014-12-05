package com.cyq.fragment;

import com.example.viewpageindicator.R;
import com.example.viewpageindicator.R.id;
import com.example.viewpageindicator.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OneFragment extends Fragment {


	
	private static final String ARG_POSITION = "position";

	private int position;

	public static OneFragment newInstance(int position) {
		OneFragment f = new OneFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v= inflater.inflate(R.layout.one_fragment, null);
		LinearLayout l = (LinearLayout) v.findViewById(R.id.bg);
		l.setBackgroundResource(position);
		l.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(), "≤‚ ‘"+position, Toast.LENGTH_LONG).show();
			}
		});
		return v;
	}


}

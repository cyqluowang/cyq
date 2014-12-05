package com.cyq.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.viewpageindicator.R;
import com.example.viewpageindicator.R.id;
import com.example.viewpageindicator.R.layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeFragment extends Fragment {


	
	private static final String ARG_POSITION = "position";

	private int position;
	private ListView list;
	private List listData = new ArrayList();

	public static ThreeFragment newInstance(int position) {
		ThreeFragment f = new ThreeFragment();
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

		View v= inflater.inflate(R.layout.three_fragment, null);
		Button b= (Button) v.findViewById(R.id.button1);
		list = (ListView) v.findViewById(R.id.list);
		for (int i = 0; i < 10; i++) {
			
			listData.add(new Bean());
		}
		list.setAdapter(new MyAdapter(getActivity().getApplicationContext()));
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(), "²âÊÔ-2222222222------", Toast.LENGTH_LONG).show();
			}
		});

		return v;
	}
	
	class MyAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
        
        
        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
		@Override
		public int getCount() {
			return listData.size();
		}

		@Override
		public Object getItem(int position) {
			return listData.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();  
                 
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder.name = (TextView)convertView.findViewById(R.id.TextView1);
                holder.hi = (TextView)convertView.findViewById(R.id.TextView2);
                convertView.setTag(holder);
                 
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
             
             
            holder.name.setText(((Bean) listData.get(position)).getName());
            holder.hi.setText(((Bean) listData.get(position)).getHi());
            convertView.setOnClickListener(new View.OnClickListener() {
                 
                @Override
                public void onClick(View v) {
                	Toast.makeText(getActivity().getApplicationContext(), "²âÊÔ-333333333333333------"+position, Toast.LENGTH_LONG).show();             
                }
            });
        
             
            return convertView;
		}
		
		class ViewHolder{
			private  TextView name;
			private TextView hi;
		}
		
	}
	
	class Bean{
		private  String name="kkkkkk";
		private String hi = "111111";
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getHi() {
			return hi;
		}
		public void setHi(String hi) {
			this.hi = hi;
		}
		
	}


}

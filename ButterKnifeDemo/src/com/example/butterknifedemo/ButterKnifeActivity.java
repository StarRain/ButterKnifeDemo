package com.example.butterknifedemo;

import java.util.ArrayList;
import java.util.List;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;

public class ButterKnifeActivity extends Activity {
	private final List<String> mDatas = new ArrayList<String>();
	private BKAdapter mAdapter;
	@Bind(R.id.demo_listView)
	ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_butterknife);
		ButterKnife.bind(this);
		initDatas();
		initModel();
	}
	
	private void initModel() {
		// TODO Auto-generated method stub
		mAdapter = new BKAdapter();
		mListView.setAdapter(mAdapter);
	}

	private void initDatas() {
		// TODO Auto-generated method stub
		for (int i = 'A'; i < 'z'; i++) {
			mDatas.add(String.valueOf((char) i));
		}
	}
	
	@OnItemClick(R.id.demo_listView) void onItemClickListener(View view, int position){
		TextView textView = ButterKnife.findById(view, R.id.demo_listView_item);
		Toast.makeText(ButterKnifeActivity.this, "点击事件\nposition = " + position + ", content = " + textView.getText().toString(), Toast.LENGTH_SHORT).show();
	}
	
	@OnItemLongClick(R.id.demo_listView) boolean onItemLongClickListener(View view, int position){
		TextView textView = ButterKnife.findById(view, R.id.demo_listView_item);
		Toast.makeText(ButterKnifeActivity.this, "长按事件\nposition = " + position + ", content = " + textView.getText().toString(), Toast.LENGTH_SHORT).show();
		return false;
	}

	class BKAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mDatas.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return mDatas.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder= null;
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.item_butterknife_text, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.mTextView.setText(getItem(position));
			return convertView;
		}
	}
	
	class ViewHolder {
		@Bind(R.id.demo_listView_item) 
		TextView mTextView;
		public ViewHolder(View view){
			ButterKnife.bind(this, view);
		}
	}
}

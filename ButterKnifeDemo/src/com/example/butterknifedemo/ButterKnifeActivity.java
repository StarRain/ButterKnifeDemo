package com.example.butterknifedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_butterknife);
		ButterKnife.bind(this);
		initDatas();
		initModel();
	}
	
	private void initModel() {
		mAdapter = new BKAdapter();
		mListView.setAdapter(mAdapter);
	}

	private void initDatas() {
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
			return mDatas.size();
		}

		@Override
		public String getItem(int position) {
			return mDatas.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
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

package com.example.androiddemo;

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	private ListView mLstView;
	private MyAdapter mAdpater;
	private List<FileData> mFileList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLstView = (ListView)findViewById(android.R.id.list);
		mFileList = StaticDataManager.getFileList();
		mAdpater = new MyAdapter(getApplicationContext(), 
				R.layout.individual_item, mFileList);
		mLstView.setAdapter(mAdpater);
		mLstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		mLstView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				mAdpater.setSelectedIndex(position);
				mAdpater.notifyDataSetChanged();
			}
		});
	}
}

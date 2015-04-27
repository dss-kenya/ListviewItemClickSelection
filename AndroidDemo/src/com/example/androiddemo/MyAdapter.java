package com.example.androiddemo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<FileData>{
	private Context mContext;
	private int RESOURCE;
	private LayoutInflater mInflater;
	private List<FileData> mFileList;
	private ViewHolder vh;
	private int selectedIndex = -1;
	
	public MyAdapter(Context context, int resource, List<FileData> objects) {
		super(context, resource, objects);
		mContext = context;
		RESOURCE = resource;
		mFileList = objects;
	}
	
	public void setSelectedIndex(int index){
	    selectedIndex = index;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		vh = null;
		
		if(view == null) {
			mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(RESOURCE, parent, false);
			vh = new ViewHolder();
			vh.txtId = (TextView)view.findViewById(R.id.txtId);
			vh.txtFileName = (TextView)view.findViewById(R.id.txtFileName);
			vh.relTop = (RelativeLayout)view.findViewById(R.id.relTop);
			vh.relDetails = (RelativeLayout)view.findViewById(R.id.relDetails);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		FileData fileData = mFileList.get(position);
		vh.txtId.setText(fileData.getFileId());
		vh.txtFileName.setText(fileData.getFileName());
		
		if(selectedIndex != position) {
			vh.relDetails.setVisibility(View.GONE);
		}else {
			vh.relDetails.setVisibility(View.VISIBLE);
		}
		
		return view;
	}
	
	static class ViewHolder {
		TextView txtId;
		TextView txtFileName;
		RelativeLayout relTop;
		RelativeLayout relDetails;
	}
}

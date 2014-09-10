package com.mw.am.adapter;

import java.util.List;

import com.mw.am.activity.R;
import com.mw.am.adapter.TaskAdapter.ViewHolder;
import com.mw.am.model.Task;
import com.mw.am.model.TaskDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TaskDetailAdapter extends BaseAdapter {

	Context context;
	List<TaskDetail> listTaskDetails;

	// MyApp myApp;
	LayoutInflater inflater;

	public TaskDetailAdapter(Context context, List<TaskDetail> listTaskDetails) {
		super();
		this.context = context;
		this.listTaskDetails = listTaskDetails;
		// myApp = (MyApp) context.getApplicationContext();
	}

	static class ViewHolder {
		protected TextView productTypeTV;
		protected TextView serialNoTV;
		protected TextView accessoriesTV;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.element_task_detail,
					parent, false);

			viewHolder.productTypeTV = (TextView) convertView
					.findViewById(R.id.productType_TV);
			viewHolder.serialNoTV = (TextView) convertView
					.findViewById(R.id.serialNo_TV);
			viewHolder.accessoriesTV = (TextView) convertView
					.findViewById(R.id.accessories_TV);

			// viewHolder.nameTV.setTypeface(myApp.getTypefaceBold());
			// viewHolder.designationTV.setTypeface(myApp.getTypefaceRegular());
			// viewHolder.companyTV.setTypeface(myApp.getTypefaceRegular());
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// viewHolder.rl.setClickable(false);
		TaskDetail tempTaskDetail = listTaskDetails.get(position);

		 viewHolder.productTypeTV.setText(tempTaskDetail.getProductType());
		 viewHolder.serialNoTV.setText(Integer.toString(tempTaskDetail.getSerialNo()));
		 viewHolder.accessoriesTV.setText(tempTaskDetail.getAccessories());
		return convertView;
	}

	@Override
	public int getCount() {
		return listTaskDetails.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}

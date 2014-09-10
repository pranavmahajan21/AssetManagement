package com.mw.am.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mw.am.activity.R;
import com.mw.am.model.Task;

public class TaskAdapter extends BaseAdapter {

	Context context;
	List<Task> listTask;

	// MyApp myApp;
	LayoutInflater inflater;

	public TaskAdapter(Context context, List<Task> listTask) {
		super();
		this.context = context;
		this.listTask = listTask;
		// myApp = (MyApp) context.getApplicationContext();
	}

	static class ViewHolder {
		protected TextView clientNameTV;
		 protected TextView emailTV;
		 protected TextView addressTV;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewHolder = new ViewHolder();
			convertView = inflater
					.inflate(R.layout.element_task, parent, false);

			viewHolder.clientNameTV = (TextView) convertView
					.findViewById(R.id.clientName_TV);
			 viewHolder.emailTV = (TextView) convertView
			 .findViewById(R.id.email_TV);
			 viewHolder.addressTV = (TextView) convertView
			 .findViewById(R.id.address_TV);

//			viewHolder.nameTV.setTypeface(myApp.getTypefaceBold());
			// viewHolder.designationTV.setTypeface(myApp.getTypefaceRegular());
			// viewHolder.companyTV.setTypeface(myApp.getTypefaceRegular());
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// viewHolder.rl.setClickable(false);
		Task tempTask = listTask.get(position);

		viewHolder.clientNameTV.setText(tempTask.getClientName());
		viewHolder.emailTV.setText(tempTask.getEmail());
		viewHolder.addressTV.setText(tempTask.getAddress());
		return convertView;
	}

	@Override
	public int getCount() {
		return listTask.size();
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

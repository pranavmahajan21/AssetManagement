package com.mw.am.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mw.am.adapter.TaskDetailAdapter;
import com.mw.am.extra.MyApp;
import com.mw.am.model.Task;
import com.mw.am.model.TaskDetail;

public class DisplayTaskActivity extends Activity {

	MyApp myApp;
	Gson gson;
	List<TaskDetail> listTaskDetailAll;

	String tag_json_arry = "json_array_req";

	Intent previousIntent;
	Intent nextIntent;

	Task selectedTask;

	ListView taskDetailsLV;

	TextView notificationTV;
	TextView clientNameTV, departmentNameTV, purchaseOrderTV, transactionTV,
			addressTV, cityTV, stateTV, zipTV, emailTV, phoneNoTV;
	TextView clientNameHeaderTV, departmentNameHeaderTV, purchaseOrderHeaderTV,
			transactionHeaderTV, addressHeaderTV, cityHeaderTV, stateHeaderTV,
			zipHeaderTV, emailHeaderTV, phoneNoHeaderTV;

	TaskDetailAdapter adapter;
	List<TaskDetail> listTaskDetails = new ArrayList<TaskDetail>();

	private void intiThings() {
		gson = new Gson();
		previousIntent = getIntent();
		myApp = (MyApp) getApplicationContext();
		nextIntent = new Intent(this, DisplayTaskDetailsActivity.class);
		selectedTask = myApp.getListTask().get(
				previousIntent.getIntExtra("position", 0));
	}

	private void findThings() {
		taskDetailsLV = (ListView) findViewById(R.id.taskDetails_LV);

		notificationTV = (TextView) findViewById(R.id.notification_TV);

		clientNameTV = (TextView) findViewById(R.id.clientName_TV);
		departmentNameTV = (TextView) findViewById(R.id.departmentName_TV);
		purchaseOrderTV = (TextView) findViewById(R.id.purchaseOrder_TV);
		transactionTV = (TextView) findViewById(R.id.transaction_TV);
		addressTV = (TextView) findViewById(R.id.address_TV);
		cityTV = (TextView) findViewById(R.id.city_TV);
		stateTV = (TextView) findViewById(R.id.state_TV);
		emailTV = (TextView) findViewById(R.id.email_TV);
		zipTV = (TextView) findViewById(R.id.zip_TV);
		phoneNoTV = (TextView) findViewById(R.id.phoneNo_TV);

		clientNameHeaderTV = (TextView) findViewById(R.id.clientNameHeader_TV);
		departmentNameHeaderTV = (TextView) findViewById(R.id.departmentNameHeader_TV);
		purchaseOrderHeaderTV = (TextView) findViewById(R.id.purchaseOrderHeader_TV);
		transactionHeaderTV = (TextView) findViewById(R.id.transactionHeader_TV);
		addressHeaderTV = (TextView) findViewById(R.id.addressHeader_TV);
		cityHeaderTV = (TextView) findViewById(R.id.cityHeader_TV);
		stateHeaderTV = (TextView) findViewById(R.id.stateHeader_TV);
		emailHeaderTV = (TextView) findViewById(R.id.emailHeader_TV);
		zipHeaderTV = (TextView) findViewById(R.id.zipHeader_TV);
		phoneNoHeaderTV = (TextView) findViewById(R.id.phoneNoHeader_TV);

	}

	private void initView() {
		clientNameTV.setText(selectedTask.getClientName());
		departmentNameTV.setText(selectedTask.getDepartmentName());
		purchaseOrderTV.setText(Integer.toString(selectedTask.getPoNumber()));
		transactionTV
				.setText(Integer.toString(selectedTask.getTransactionId()));
		addressTV.setText(selectedTask.getAddress());
		cityTV.setText(selectedTask.getCity());
		stateTV.setText(selectedTask.getState());
		emailTV.setText(selectedTask.getEmail());
		zipTV.setText(selectedTask.getZip());
		phoneNoTV.setText(selectedTask.getPhoneNo());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_task);

		intiThings();
		findThings();
		initView();

		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();

		taskDetailsLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				nextIntent.putExtra("position", position);
				startActivity(nextIntent);
			}

		});

		String url = MyApp.URL + MyApp.TASK_DETAILS;

		JsonArrayRequest req = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						// gson.fromJson(response.toString(), Task.class);

						Type listType = (Type) new TypeToken<ArrayList<TaskDetail>>() {
						}.getType();
						listTaskDetailAll = gson.fromJson(response.toString(),
								listType);
						myApp.setListTaskDetail(listTaskDetailAll);
						
						System.out.println(listTaskDetailAll.size());

						for (int i = 0; i < listTaskDetailAll.size(); i++) {
							if (listTaskDetailAll.get(i).getTaskId() == selectedTask
									.getId()) {
								listTaskDetails.add(listTaskDetailAll.get(i));
							}
						}
						System.out.println(listTaskDetails.size());
						if (listTaskDetails.size() > 0) {
							adapter = new TaskDetailAdapter(
									DisplayTaskActivity.this, listTaskDetails);
							taskDetailsLV.setAdapter(adapter);
						} else {
							notificationTV.setVisibility(View.VISIBLE);
						}
						pDialog.hide();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println("<><>error");
						pDialog.hide();
					}
				});

		// Adding request to request queue
		MyApp.getInstance().addToRequestQueue(req, tag_json_arry);

	}

}

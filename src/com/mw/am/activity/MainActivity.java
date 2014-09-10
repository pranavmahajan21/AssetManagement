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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mw.am.adapter.TaskAdapter;
import com.mw.am.extra.MyApp;
import com.mw.am.model.Task;

public class MainActivity extends Activity {
	Gson gson;

	List<Task> listTask;
	ListView tasksLV;

	TaskAdapter adapter;

	Intent nextIntent;

	MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myApp = (MyApp) getApplicationContext();
		tasksLV = (ListView) findViewById(R.id.tasks_LV);
		nextIntent = new Intent(this, DisplayTaskActivity.class);

		String tag_json_arry = "json_array_req";

		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();

		String url = MyApp.URL + MyApp.TASKS;

		tasksLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				nextIntent.putExtra("position", position);
				startActivity(nextIntent);
			}

		});

		JsonArrayRequest req = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						gson = new Gson();
						// gson.fromJson(response.toString(), Task.class);

						Type listType = (Type) new TypeToken<ArrayList<Task>>() {
						}.getType();
						listTask = gson.fromJson(response.toString(), listType);

						for (int i = 0; i < listTask.size(); i++) {
							System.out.println(listTask.get(i).toString());
						}
						myApp.setListTask(listTask);
						adapter = new TaskAdapter(MainActivity.this, listTask);

						tasksLV.setAdapter(adapter);

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
		
//		listTask = myApp.getListTask();
//		adapter = new TaskAdapter(MainActivity.this, listTask);
//		tasksLV.setAdapter(adapter);
	}
}

package com.mw.am.extra;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import android.app.Application;
import android.app.ProgressDialog;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mw.am.activity.MainActivity;
import com.mw.am.adapter.TaskAdapter;
import com.mw.am.model.Task;
import com.mw.am.model.TaskDetail;

public class MyApp extends Application {

	public static final String TAG = MyApp.class.getSimpleName();

	public static final String URL = "http://asset-manage.cloudapp.net:3000/";
	public static final String TASKS = "tasks.json";
	public static final String TASK_DETAILS = "task_details.json";

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	private static MyApp mInstance;

	List<Task> listTask;
	List<TaskDetail> listTaskDetail;

	Gson gson;

	private void intiThings() {
		mInstance = this;
		listTask = new ArrayList<Task>();
		listTaskDetail = new ArrayList<TaskDetail>();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		intiThings();

//		String tag_json_arry = "json_array_req";
//		String url = MyApp.URL + MyApp.TASKS;
//
//		JsonArrayRequest req = new JsonArrayRequest(url,
//				new Response.Listener<JSONArray>() {
//					@Override
//					public void onResponse(JSONArray response) {
//						gson = new Gson();
//						// gson.fromJson(response.toString(), Task.class);
//
//						Type listType = (Type) new TypeToken<ArrayList<Task>>() {
//						}.getType();
//						listTask = gson.fromJson(response.toString(), listType);
//
//						for (int i = 0; i < listTask.size(); i++) {
//							System.out.println(listTask.get(i).toString());
//						}
//					}
//				}, new Response.ErrorListener() {
//					@Override
//					public void onErrorResponse(VolleyError error) {
//						System.out.println("<><>error");
//					}
//				});
//
//		MyApp.getInstance().addToRequestQueue(req, tag_json_arry);
//		// Adding request to request queue
//		url = MyApp.URL + MyApp.TASK_DETAILS;
//
//		JsonArrayRequest req2 = new JsonArrayRequest(url,
//				new Response.Listener<JSONArray>() {
//					@Override
//					public void onResponse(JSONArray response) {
//						gson = new Gson();
//
//						Type listType = (Type) new TypeToken<ArrayList<TaskDetail>>() {
//						}.getType();
//						listTaskDetail = gson.fromJson(response.toString(),
//								listType);
//
//					}
//				}, new Response.ErrorListener() {
//					@Override
//					public void onErrorResponse(VolleyError error) {
//						System.out.println("<><>error");
//					}
//				});
//
//		// Adding request to request queue
//		MyApp.getInstance().addToRequestQueue(req2, tag_json_arry);
	}

	public static synchronized MyApp getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		getRequestQueue();
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(this.mRequestQueue,
					new LruBitmapCache());
		}
		return this.mImageLoader;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		// set the default tag if tag is empty
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

	public List<Task> getListTask() {
		return listTask;
	}

	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}

	public List<TaskDetail> getListTaskDetail() {
		return listTaskDetail;
	}

	public void setListTaskDetail(List<TaskDetail> listTaskDetail) {
		this.listTaskDetail = listTaskDetail;
	}
	
}

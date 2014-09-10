package com.mw.am.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mw.am.extra.MyApp;
import com.mw.am.model.TaskDetail;

public class DisplayTaskDetailsActivity extends Activity {

	MyApp myApp;
	Intent previousIntent;

	TaskDetail selectedTaskDetail;

	private void intiThings() {
		previousIntent = getIntent();
		myApp = (MyApp) getApplicationContext();
		selectedTaskDetail = myApp.getListTaskDetail().get(
				previousIntent.getIntExtra("position", 0));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_task_details);

		intiThings();

	}

	public void onEdit(View view) {

	}
}

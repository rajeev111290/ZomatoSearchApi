package com.singh.rajeev.zomatotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.singh.rajeev.zomatotest.search.SearchActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        startActivity(SearchActivity.getLaunchIntent(this));
    }
}

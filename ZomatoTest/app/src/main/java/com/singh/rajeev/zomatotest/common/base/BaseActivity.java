package com.singh.rajeev.zomatotest.common.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.LogHelper;
import com.singh.rajeev.zomatotest.common.MyApplication;
import com.singh.rajeev.zomatotest.common.dependencyinjection.components.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor(this);
    }

    private void setStatusBarColor(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(activity.getResources().getColor(R.color.colorPrimaryDark));
            }
        } catch (RuntimeException e) {
            LogHelper.log(e.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            this.overridePendingTransition(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.overridePendingTransition(0, 0);

    }
}

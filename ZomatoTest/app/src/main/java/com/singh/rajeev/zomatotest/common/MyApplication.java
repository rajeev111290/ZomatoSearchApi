package com.singh.rajeev.zomatotest.common;

import android.app.Application;

import com.singh.rajeev.zomatotest.common.dependencyinjection.components.ApplicationComponent;
import com.singh.rajeev.zomatotest.common.dependencyinjection.components.DaggerApplicationComponent;
import com.singh.rajeev.zomatotest.common.dependencyinjection.module.ApplicationModule;

public class MyApplication extends Application {

    private ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        intializeDagger();
    }

    public void intializeDagger() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}

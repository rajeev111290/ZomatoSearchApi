package com.singh.rajeev.zomatotest.common.dependencyinjection.components;

import com.singh.rajeev.zomatotest.search.SearchActivity;
import com.singh.rajeev.zomatotest.common.dependencyinjection.module.ApplicationModule;
import com.singh.rajeev.zomatotest.common.dependencyinjection.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class, UserModule.class})
@Singleton
public interface ApplicationComponent {

    void doInjection(SearchActivity searchActivity);


}

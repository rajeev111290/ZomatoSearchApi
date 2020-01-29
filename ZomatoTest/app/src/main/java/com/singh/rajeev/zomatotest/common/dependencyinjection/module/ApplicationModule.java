package com.singh.rajeev.zomatotest.common.dependencyinjection.module;

import android.app.Application;
import android.content.Context;

import com.singh.rajeev.zomatotest.BuildConfig;
import com.singh.rajeev.zomatotest.common.BuildConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

//    private Application application;
//
//    public ApplicationModule(Application application) {
//        this.application = application;
//    }
//
//    @Provides
//    @Singleton
//    Context provideApplicationContext() {
//        return application;
//    }
//
//    @Provides
//    @Singleton
//    Retrofit getRetrofit(OkHttpClient client) {
//        return new Retrofit.Builder()
//                .baseUrl(BuildConstants.BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    OkHttpClient getClient() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(chain -> {
//            Request originalRequest = chain.request();
//            Request.Builder builder2 = originalRequest.newBuilder();
//
//            Request request = builder2
//                    .header("user-key", String.valueOf(BuildConfig.ZAMATO_API_KEY))
//                    .header("Accept", "application/json")
//                    .method(originalRequest.method(), originalRequest.body())
//                    .url(originalRequest.url())
//                    .build();
//            return chain.proceed(request);
//        });
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(BuildConstants.DEBUG ? HttpLoggingInterceptor.Level.BODY :
//                HttpLoggingInterceptor.Level.NONE);
//
//        return builder.addInterceptor(interceptor).build();
//    }

}

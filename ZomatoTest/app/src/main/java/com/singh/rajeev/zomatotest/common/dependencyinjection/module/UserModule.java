package com.singh.rajeev.zomatotest.common.dependencyinjection.module;

import android.arch.lifecycle.ViewModelProvider;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.singh.rajeev.zomatotest.BuildConfig;
import com.singh.rajeev.zomatotest.common.BuildConstants;
import com.singh.rajeev.zomatotest.search.ViewModelFactory;
import com.singh.rajeev.zomatotest.networking.ZomatoApiInterface;
import com.singh.rajeev.zomatotest.search.SearchRepository;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class UserModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.setLenient().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(BuildConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ZomatoApiInterface getApiCallInterface(Retrofit retrofit) {
        return retrofit.create(ZomatoApiInterface.class);
    }

    @Provides
    @Singleton
    OkHttpClient getRequestHeader() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("user-key", BuildConfig.ZAMATO_API_KEY)
                    .header("Accept", "application/json")
                    .build();
            return chain.proceed(request);
        })
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);


        //For logging http request
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConstants.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        httpClient.addInterceptor(interceptor);

        return httpClient.build();
    }

    @Provides
    @Singleton
    SearchRepository getRepository(ZomatoApiInterface apiCallInterface) {
        return new SearchRepository(apiCallInterface);
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory getViewModelFactory(SearchRepository myRepository) {
        return new ViewModelFactory(myRepository);
    }

}

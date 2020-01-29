package com.singh.rajeev.zomatotest.networking;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.singh.rajeev.zomatotest.networking.model.Restaurant;
import com.singh.rajeev.zomatotest.networking.model.SearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ZomatoApiInterface {

    @GET("v2.1/search")
    Single<SearchResponse> listRepos(
            @Query("q") String text,
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("radius") int radius,
            @Query("sort") String sort,
            @Query("order") String order
            );

}

package com.singh.rajeev.zomatotest.networking;

import com.singh.rajeev.zomatotest.networking.model.SearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
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

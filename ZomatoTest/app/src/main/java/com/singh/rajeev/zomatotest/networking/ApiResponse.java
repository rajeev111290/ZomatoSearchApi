package com.singh.rajeev.zomatotest.networking;

import com.singh.rajeev.zomatotest.networking.model.SearchResponse;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import static com.singh.rajeev.zomatotest.networking.Status.ERROR;
import static com.singh.rajeev.zomatotest.networking.Status.LOADING;
import static com.singh.rajeev.zomatotest.networking.Status.SUCCESS;


public class ApiResponse {

    public final Status status;

    @Nullable
    public final SearchResponse data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable SearchResponse data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull SearchResponse data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }

}

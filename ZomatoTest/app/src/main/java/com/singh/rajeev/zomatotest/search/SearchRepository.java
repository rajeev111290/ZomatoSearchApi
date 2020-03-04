package com.singh.rajeev.zomatotest.search;

import com.singh.rajeev.zomatotest.common.model.SearchBarModel;
import com.singh.rajeev.zomatotest.networking.ZomatoApiInterface;
import com.singh.rajeev.zomatotest.networking.model.SearchResponse;
import io.reactivex.Single;

public class SearchRepository {

    private ZomatoApiInterface apiCallInterface;

    public SearchRepository(ZomatoApiInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    /*
     * method to call login api
     * */
    Single<SearchResponse> executeLogin(SearchBarModel searchBarModel) {
        return apiCallInterface.listRepos(
                searchBarModel.getQueryText(),
                28.682940,
                77.313067,
                200,
                searchBarModel.getSortString(),
                searchBarModel.getOrderString()
        );
    }

}

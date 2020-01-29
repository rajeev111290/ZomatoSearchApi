package com.singh.rajeev.zomatotest.search;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.singh.rajeev.zomatotest.common.base.BaseModel;
import com.singh.rajeev.zomatotest.common.model.SearchBarModel;
import com.singh.rajeev.zomatotest.networking.ApiResponse;
import com.singh.rajeev.zomatotest.networking.model.SearchResponse;
import com.singh.rajeev.zomatotest.networking.model.SearchResult;
import com.singh.rajeev.zomatotest.search.model.CustomSearchData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends ViewModel {

    private SearchRepository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();


    ArrayList<BaseModel> data = new ArrayList<>();
    SearchBarModel searchModel;


    public SearchViewModel(SearchRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ApiResponse> searchResponse() {
        return responseLiveData;
    }

    public void hitSearchApi(SearchBarModel searchBarModel) {

        disposables.add(repository.executeLogin(searchBarModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> responseLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> {
                            updateData(result);
                            responseLiveData.setValue(ApiResponse.success(result));
                        },
                        throwable -> responseLiveData.setValue(ApiResponse.error(throwable))
                ));

    }

    @Override
    protected void onCleared() {
        disposables.clear();
        data = null;
        searchModel = null;
    }

    private void updateData(SearchResponse searchResponse) {
        data.clear();

        if (searchModel != null && searchModel.isGroupByCuisine()) {
            dataOrdering(searchResponse.getRestaurants());
        } else {
            data.addAll(searchResponse.getRestaurants());
        }
    }


    private void dataOrdering(List<SearchResult> data) {

        ArrayList<CustomSearchData> customSearchData = new ArrayList<>();
        HashMap<String, Integer> cuisineSet = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            String[] a = data.get(i).getRestaurant().getCuisines().split(",");
            for (String s : a) {
                s = s.trim();
                CustomSearchData entry;
                if (cuisineSet.containsKey(s)) {
                    entry = customSearchData.get(cuisineSet.get(s));
                    entry.getRestaurants().add(data.get(i));
                } else {
                    cuisineSet.put(s, customSearchData.size());
                    entry = new CustomSearchData(s);
                    entry.getRestaurants().add(data.get(i));
                    customSearchData.add(entry);
                }
            }
        }
        this.data.clear();

        for (CustomSearchData customSearchData1 : customSearchData) {
            this.data.add(customSearchData1);
            this.data.addAll(customSearchData1.getRestaurants());
        }
    }
}

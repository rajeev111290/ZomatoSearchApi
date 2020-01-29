package com.singh.rajeev.zomatotest.search;

import android.arch.lifecycle.ViewModelProviders;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.MyApplication;
import com.singh.rajeev.zomatotest.common.Utils;
import com.singh.rajeev.zomatotest.common.base.BaseActivity;
import com.singh.rajeev.zomatotest.common.model.SearchBarModel;
import com.singh.rajeev.zomatotest.networking.ApiResponse;
import com.singh.rajeev.zomatotest.networking.model.SearchResponse;
import com.singh.rajeev.zomatotest.search.recycleview.SearchListAdapter;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

public class SearchActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    private SearchViewModel viewModel;

    private ProgressDialog progressDialog;

    private SearchListAdapter adapter;
    private PublishSubject<SearchBarModel> searchBarModelPublishSubject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        progressDialog = Utils.getProgressDialog(this, "Please wait...");

        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getComponent().doInjection(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);

        viewModel.searchResponse().observe(this, this::consumeResponse);


        searchBarModelPublishSubject = PublishSubject.create();

        searchBarModelPublishSubject.subscribe(new DisposableObserver<SearchBarModel>() {
            @Override
            public void onNext(SearchBarModel searchBarModel) {
                viewModel.searchModel = searchBarModel;

                if (isValid(searchBarModel.getQueryText())) {
                    if (!Utils.checkInternetConnection(SearchActivity.this)) {
                        Toast.makeText(SearchActivity.this, getResources().getString(R.string.network_error), Toast.LENGTH_SHORT).show();
                    } else {
                        viewModel.hitSearchApi(searchBarModel);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

        setRecyclerView();

    }

    protected void setRecyclerView() {
        if (recyclerView != null) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapter = new SearchListAdapter(viewModel.data, searchBarModelPublishSubject);
            recyclerView.setAdapter(adapter);
        }
    }

    private boolean isValid(String queryText) {
        if (queryText.trim().isEmpty()) {
            Toast.makeText(SearchActivity.this, getResources().getString(R.string.enter_something_to_search), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void consumeResponse(ApiResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:
                progressDialog.show();
                break;

            case SUCCESS:
                progressDialog.dismiss();
                renderSuccessResponse(apiResponse.data);
                break;

            case ERROR:
                progressDialog.dismiss();
                Log.d("response=", apiResponse.error.toString());
                Toast.makeText(SearchActivity.this, getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    /*
     * method to handle success response
     * */
    private void renderSuccessResponse(SearchResponse searchResponse) {
        if (searchResponse != null) {
            adapter.notifyAllExceptHeader();
            Toast.makeText(SearchActivity.this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SearchActivity.this, getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }



    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

}

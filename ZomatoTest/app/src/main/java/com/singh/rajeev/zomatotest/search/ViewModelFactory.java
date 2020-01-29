package com.singh.rajeev.zomatotest.search;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private SearchRepository repository;

    @Inject
    public ViewModelFactory(SearchRepository repository) {
        this.repository = repository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}

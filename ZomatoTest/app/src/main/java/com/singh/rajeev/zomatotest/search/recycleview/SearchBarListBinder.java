package com.singh.rajeev.zomatotest.search.recycleview;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.base.DataBindAdapter;
import com.singh.rajeev.zomatotest.common.base.DataBinder;
import com.singh.rajeev.zomatotest.common.model.SearchBarModel;
import com.singh.rajeev.zomatotest.search.SearchActivity;

import java.util.ArrayList;

import io.reactivex.subjects.PublishSubject;

public class SearchBarListBinder extends DataBinder<SearchBarListBinder.ViewHolder> {

    PublishSubject<SearchBarModel> searchBarModelPublishSubject;
    SearchBarModel searchBarModel;

    SearchBarListBinder(DataBindAdapter dataBindAdapter, PublishSubject<SearchBarModel> searchBarModelPublishSubject) {
        super(dataBindAdapter);
        this.searchBarModelPublishSubject = searchBarModelPublishSubject;
        searchBarModel = new SearchBarModel("", null, true);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.search_bar_list_card,
                parent, false));
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {

        holder.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!s.equals(searchBarModel.getQueryText())) {
                    searchBarModel.setQueryText(s);
                    searchBarModelPublishSubject.onNext(searchBarModel);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        holder.groupByBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                searchBarModel.setGroupByCuisine(isChecked);
                searchBarModelPublishSubject.onNext(searchBarModel);
            }
        });

        holder.sortBySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        searchBarModel.setSortBy(null);
                        break;
                    case 1:
                        searchBarModel.setSortBy(SearchBarModel.SortBy.cost);
                        break;
                    case 2:
                        searchBarModel.setSortBy(SearchBarModel.SortBy.rating);
                        break;
                    case 3:
                        searchBarModel.setSortBy(SearchBarModel.SortBy.distance);
                        break;
                }
                searchBarModelPublishSubject.onNext(searchBarModel);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        SearchView searchView;
        SwitchCompat groupByBtn;
        AppCompatSpinner sortBySpinner;

        ViewHolder(View itemView) {
            super(itemView);
            searchView = itemView.findViewById(R.id.searchView);
            groupByBtn = itemView.findViewById(R.id.groupByBtn);
            sortBySpinner = itemView.findViewById(R.id.sortBySpinner);
            setupSpinner();
        }

        private void setupSpinner() {

            ArrayList<String> sortList = new ArrayList<>();
            sortList.add("Sort By: Default");
            sortList.add("Sort By: Cost");
            sortList.add("Sort By: Rating");
            sortList.add("Sort By: Distance");

            ArrayAdapter adapter = new ArrayAdapter(sortBySpinner.getContext(), android.R.layout.simple_spinner_item, sortList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            sortBySpinner.setAdapter(adapter);

        }
    }
}

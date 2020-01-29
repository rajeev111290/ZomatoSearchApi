package com.singh.rajeev.zomatotest.common.model;

public class SearchBarModel {

    private String queryText;
    private SortBy sortBy;
    private boolean groupByCuisine;

    public enum SortBy {
        cost,
        rating,
        distance
    }

    public SearchBarModel(String queryText, SortBy sortBy, boolean groupByCuisine) {
        this.queryText = queryText;
        this.sortBy = sortBy;
        this.groupByCuisine = groupByCuisine;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isGroupByCuisine() {
        return groupByCuisine;
    }

    public void setGroupByCuisine(boolean groupByCuisine) {
        this.groupByCuisine = groupByCuisine;
    }

    public String getSortString() {
        if (sortBy != null) {
            return sortBy.name();
        } else {
            return "";
        }
    }

    public String getOrderString() {
        if (sortBy != null) {
            return sortBy==SortBy.rating?"desc":"asc";
        } else {
            return "asc";
        }
    }
}

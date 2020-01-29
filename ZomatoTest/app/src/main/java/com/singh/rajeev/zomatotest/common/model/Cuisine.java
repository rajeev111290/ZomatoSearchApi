package com.singh.rajeev.zomatotest.common.model;

import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.base.BaseModel;

public class Cuisine implements BaseModel {

    String name;

    @Override
    public int getModelType() {
        return Constants.CUISINE_HEADER;
    }
}

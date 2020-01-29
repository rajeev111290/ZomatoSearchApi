package com.singh.rajeev.zomatotest.common.binders;

import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.base.BaseModel;

public class GenericCardDividerModel implements BaseModel {

    private int topMargin;
    private int height;

    @Override
    public int getModelType() {
        return Constants.GENERIC_CARD_DIVIDER;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
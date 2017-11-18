package com.sch.nova.sample;

import com.sch.nova.BasePresenter;

class ClickCounterPresenter extends BasePresenter<ClickCounterView> {
    private int clickCount;

    ClickCounterPresenter() {
        super(ClickCounterView.class);
    }

    void loadClickCount() {
        getView().setClickCount(clickCount);
    }

    void buttonClicked() {
        clickCount++;
        getView().setClickCount(clickCount);
    }
}

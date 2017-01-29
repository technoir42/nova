package com.sch.nova.sample;

import com.sch.nova.BasePresenter;

class ClickCounterPresenterImpl extends BasePresenter<ClickCounterView> implements ClickCounterPresenter {
    private int clickCount;

    ClickCounterPresenterImpl() {
        super(ClickCounterView.class);
    }

    @Override
    public void loadClickCount() {
        getView().setClickCount(clickCount);
    }

    @Override
    public void buttonClicked() {
        clickCount++;
        getView().setClickCount(clickCount);
    }
}

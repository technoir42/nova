package com.sch.nova.sample;

import com.sch.nova.BasePresenter;

public class ClickCounterPresenterImpl extends BasePresenter<ClickCounterView> implements ClickCounterPresenter {
    private int clickCount;

    public ClickCounterPresenterImpl() {
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

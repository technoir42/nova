package com.sch.nova.sample;

import com.sch.nova.Presenter;

interface ClickCounterPresenter extends Presenter<ClickCounterView> {
    void loadClickCount();

    void buttonClicked();
}

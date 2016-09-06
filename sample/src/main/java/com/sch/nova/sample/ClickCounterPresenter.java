package com.sch.nova.sample;

import com.sch.nova.Presenter;

public interface ClickCounterPresenter extends Presenter<ClickCounterView> {
    void loadClickCount();

    void buttonClicked();
}

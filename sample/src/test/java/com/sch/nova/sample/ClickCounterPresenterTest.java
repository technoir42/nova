package com.sch.nova.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class ClickCounterPresenterTest {
    private final ClickCounterView view = mock(ClickCounterView.class);
    private final ClickCounterPresenter presenter = new ClickCounterPresenter();

    @BeforeEach
    void setUp() {
        presenter.attachView(view);
    }

    @Test
    void loadClickCount_callsSetClickCount() {
        presenter.loadClickCount();

        verify(view).setClickCount(0);
        verifyNoMoreInteractions(view);
    }

    @Test
    void buttonClicked_incrementsCountAndCallsSetClickCount() {
        presenter.buttonClicked();

        verify(view).setClickCount(1);
        verifyNoMoreInteractions(view);
    }
}

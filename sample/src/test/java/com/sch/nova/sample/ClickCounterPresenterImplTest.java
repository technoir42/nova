package com.sch.nova.sample;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ClickCounterPresenterImplTest {
    private final ClickCounterView view = mock(ClickCounterView.class);
    private final ClickCounterPresenter presenter = new ClickCounterPresenterImpl();

    @Before
    public void setUp() {
        presenter.attachView(view);
    }

    @Test
    public void loadClickCount_callsSetClickCount() {
        presenter.loadClickCount();

        verify(view).setClickCount(0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void buttonClicked_incrementsCountAndCallsSetClickCount() {
        presenter.buttonClicked();

        verify(view).setClickCount(1);
        verifyNoMoreInteractions(view);
    }
}

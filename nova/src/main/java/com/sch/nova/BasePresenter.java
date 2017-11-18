package com.sch.nova;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

/**
 * Base class of MVP presenter.
 */
public abstract class BasePresenter<V> implements Presenter<V> {
    private final V dummyView;
    private V view;

    /**
     * Constructor.
     *
     * @param dummyViewClass view interface to create a dummy view that will be returned
     *                       from {@link #getView()} when there is no view attached to this presenter.
     */
    protected BasePresenter(@NonNull Class<V> dummyViewClass) {
        dummyView = Utils.createStub(dummyViewClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @CallSuper
    public void attachView(@NonNull V view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @CallSuper
    public void detachView(boolean isFinishing) {
        view = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewShown() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewHidden() {
    }

    /**
     * Returns the attached view or a dummy view if no view is attached to this presenter.
     */
    @NonNull
    public final V getView() {
        return view != null ? view : dummyView;
    }
}

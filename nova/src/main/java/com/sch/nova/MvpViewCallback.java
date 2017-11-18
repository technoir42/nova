package com.sch.nova;

import android.support.annotation.NonNull;

/**
 * Interface that all view implementations should implement.
 */
public interface MvpViewCallback<V, P extends Presenter<V>> {
    /**
     * Returns a presenter for a view that implements this interface or {@code null} if it hasn't been created yet.
     */
    @NonNull
    P getPresenter();

    /**
     * Creates a new presenter for a view that implements this interface.
     */
    @NonNull
    P createPresenter();

    /**
     * Returns instance of the view. Typical implementation should just return {@code this}.
     */
    @NonNull
    V getMvpView();

    /**
     * Returns an object that will host the view that implements this interface.
     */
    @NonNull
    MvpHost getMvpHost();
}

package com.sch.nova;

import android.support.annotation.NonNull;

/**
 * Represents MVP presenter.
 */
public interface Presenter<V> {
    /**
     * Attaches view to the presenter.
     *
     * @param view the view
     */
    void attachView(@NonNull V view);

    /**
     * Detaches view from the presenter.
     */
    void detachView();

    /**
     * Called when this {@link Presenter} is no longer needed.
     */
    void destroy();

    /**
     * Called right after the attached view has been shown.
     */
    void onViewShown();

    /**
     * Called right after the attached view has been hidden.
     */
    void onViewHidden();
}

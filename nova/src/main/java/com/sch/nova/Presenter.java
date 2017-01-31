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
     *
     * @param isFinishing {@code true} if view's activity is being finished or view is being removed from its activity.
     */
    void detachView(boolean isFinishing);

    /**
     * Called right after the attached view has been shown.
     */
    void onViewShown();

    /**
     * Called right after the attached view has been hidden.
     */
    void onViewHidden();
}

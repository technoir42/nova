package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Helper class for implementing MVP view.
 */
public final class MvpViewHelper<V, P extends Presenter<V>> {
    private static final String STATE_PRESENTER_ID = "nova.presenter_id";
    private static final int NO_ID = -1;

    private final MvpViewCallback<V, P> callback;
    private P presenter;
    private int presenterId;

    public MvpViewHelper(MvpViewCallback<V, P> callback) {
        this.callback = callback;
    }

    public void onCreate(@Nullable Bundle savedState) {
        if (savedState != null) {
            presenterId = savedState.getInt(STATE_PRESENTER_ID, NO_ID);
        } else {
            presenterId = NO_ID;
        }

        if (presenterId != NO_ID) {
            presenter = getPresenterCache().getPresenter(presenterId);
        }

        if (presenter == null) {
            presenter = callback.createPresenter();
            if (presenterId != NO_ID) {
                getPresenterCache().addPresenter(presenterId, presenter);
            } else {
                presenterId = getPresenterCache().addPresenter(presenter);
            }
        }

        presenter.attachView(callback.getMvpView());
    }

    public void onDestroy(boolean isFinishing) {
        presenter.detachView();
        if (isFinishing) {
            presenter.destroy();
            getPresenterCache().removePresenter(presenterId);
        }
    }

    public void onStart() {
        presenter.onViewShown();
    }

    public void onStop() {
        presenter.onViewHidden();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (presenterId != NO_ID) {
            outState.putInt(STATE_PRESENTER_ID, presenterId);
        }
    }

    public P getPresenter() {
        return presenter;
    }

    private PresenterCache getPresenterCache() {
        return callback.getMvpHost().getPresenterCache();
    }
}

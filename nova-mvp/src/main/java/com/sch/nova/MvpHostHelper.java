package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Helper class for implementing {@link MvpHost}.
 */
public final class MvpHostHelper {
    private static final String STATE_NEXT_PRESENTER_ID = "nova.next_presenter_id";

    private PresenterCache presenterCache;

    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable Object lastNonConfigurationInstance) {
        presenterCache = (PresenterCache) lastNonConfigurationInstance;
        if (presenterCache == null) {
            final int nextPresenterId = savedInstanceState != null ? savedInstanceState.getInt(STATE_NEXT_PRESENTER_ID) : 0;
            presenterCache = new PresenterCache(nextPresenterId);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_NEXT_PRESENTER_ID, presenterCache.getNextPresenterId());
    }

    public PresenterCache getPresenterCache() {
        if (presenterCache == null) {
            throw new IllegalStateException("getPresenterCache() called before onCreate()");
        }
        return presenterCache;
    }

    @Nullable
    public Object onRetainCustomNonConfigurationInstance() {
        return presenterCache;
    }
}

package com.sch.nova;

import android.support.annotation.NonNull;

/**
 * Something that can host MVP views.
 */
public interface MvpHost {
    /**
     * Returns {@link PresenterCache} that contains all presenters within this host.
     */
    @NonNull
    PresenterCache getPresenterCache();
}

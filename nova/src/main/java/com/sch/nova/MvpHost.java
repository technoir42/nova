package com.sch.nova;

/**
 * Something that can host MVP views.
 */
public interface MvpHost {
    /**
     * Returns {@link PresenterCache} that contains all presenters within this host.
     */
    PresenterCache getPresenterCache();
}

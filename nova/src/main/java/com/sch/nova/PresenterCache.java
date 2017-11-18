package com.sch.nova;

import android.util.SparseArray;

/**
 * A cache that stores presenters by assigning each presenter a unique id that can be used to retrieve
 * it back.
 */
public final class PresenterCache {
    private final SparseArray<Presenter<?>> presenters = new SparseArray<>();
    private int nextPresenterId;

    /**
     * Constructor.
     *
     * @param startPresenterId id that will be assigned to a first presenter.
     */
    public PresenterCache(int startPresenterId) {
        nextPresenterId = startPresenterId;
    }

    /**
     * Returns {@link Presenter} with a specific id or {@code null} if there is no such presenter.
     *
     * @param id id of the presenter
     */
    @SuppressWarnings("unchecked")
    public <P extends Presenter<?>> P getPresenter(int id) {
        return (P) presenters.get(id);
    }

    /**
     * Adds presenter to the cache with a generated id.
     *
     * @param presenter instance of the presenter
     * @return id that can be used to retrieve the presenter using {@link #getPresenter(int)}.
     */
    public int addPresenter(Presenter<?> presenter) {
        final int id = nextPresenterId++;
        addPresenter(id, presenter);
        return id;
    }

    /**
     * Adds presenter to the cache with the specified id.
     *
     * @param id unique id of the presenter
     * @param presenter instance of the presenter
     * @throws IllegalStateException if presenter with such id already exists.
     */
    public void addPresenter(int id, Presenter<?> presenter) {
        if (presenter == null) {
            throw new NullPointerException("presenter is null");
        }
        if (presenters.get(id) != null) {
            throw new IllegalStateException("Presenter with id " + id + " already exists");
        }
        presenters.put(id, presenter);
    }

    /**
     * Removes presenter with a specific id.
     *
     * @param id id of the presenter to remove.
     */
    public void removePresenter(int id) {
        presenters.remove(id);
    }

    /**
     * Returns id that will be assigned to a next presenter added through {@link #addPresenter(Presenter)}.
     */
    public int getNextPresenterId() {
        return nextPresenterId;
    }
}

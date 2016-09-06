package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Base class for fragments that follow MVP pattern.
 */
public abstract class MvpFragment<V, P extends Presenter<V>> extends Fragment implements MvpViewCallback<V, P> {
    private final MvpViewHelper<V, P> helper = new MvpViewHelper<>(this);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        final boolean isFinishing = isRemoving() || getActivity().isFinishing();
        helper.onDestroy(isFinishing);
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSaveInstanceState(outState);
    }

    @Override
    public P getPresenter() {
        return helper.getPresenter();
    }

    @Override
    @SuppressWarnings("unchecked")
    public V getMvpView() {
        return (V) this;
    }

    @Override
    public MvpHost getMvpHost() {
        return (MvpHost) getActivity();
    }
}

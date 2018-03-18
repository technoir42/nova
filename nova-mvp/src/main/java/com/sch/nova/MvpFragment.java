package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

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
        final boolean isFinishing = isRemoving() || requireActivity().isFinishing();
        helper.onDestroy(isFinishing);
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        helper.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        helper.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public final P getPresenter() {
        return helper.getPresenter();
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public V getMvpView() {
        return (V) this;
    }

    @NonNull
    @Override
    public MvpHost getMvpHost() {
        return (MvpHost) requireActivity();
    }
}

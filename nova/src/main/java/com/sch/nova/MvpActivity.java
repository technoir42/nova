package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Base class for activities that follow MVP pattern.
 */
public abstract class MvpActivity<V, P extends Presenter<V>> extends MvpHostActivity implements MvpViewCallback<V, P> {
    private final MvpViewHelper<V, P> helper = new MvpViewHelper<>(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        helper.onDestroy(isFinishing());
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        helper.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
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
        return this;
    }
}

package com.sch.nova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Base class for activities that can contain MVP views but does not necessarily follow MVP pattern themselves.
 */
public abstract class MvpHostActivity extends AppCompatActivity implements MvpHost {
    private final MvpHostHelper helper = new MvpHostHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        helper.onCreate(savedInstanceState, getLastCustomNonConfigurationInstance());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        helper.onSaveInstanceState(outState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return helper.onRetainCustomNonConfigurationInstance();
    }

    @NonNull
    @Override
    public final PresenterCache getPresenterCache() {
        return helper.getPresenterCache();
    }
}

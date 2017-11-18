package com.sch.nova.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.sch.nova.MvpActivity;

public class ClickCounterActivity extends MvpActivity<ClickCounterView, ClickCounterPresenter> implements ClickCounterView {
    private TextView clickCountView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_counter);

        clickCountView = findViewById(R.id.click_count);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> getPresenter().buttonClicked());

        getPresenter().loadClickCount();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setClickCount(int clickCount) {
        clickCountView.setText(getString(R.string.click_count, clickCount));
    }

    @NonNull
    @Override
    public ClickCounterPresenter createPresenter() {
        return new ClickCounterPresenter();
    }
}

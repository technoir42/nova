package com.sch.nova.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sch.nova.MvpActivity;

public class ClickCounterActivity extends MvpActivity<ClickCounterView, ClickCounterPresenter> implements ClickCounterView {
    private TextView clickCountView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_counter);

        final Button button = (Button) findViewById(R.id.button);
        clickCountView = (TextView) findViewById(R.id.click_count);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().buttonClicked();
            }
        });

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

    @Override
    public ClickCounterPresenter createPresenter() {
        return new ClickCounterPresenterImpl();
    }
}

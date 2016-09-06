package com.sch.nova.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sch.nova.MvpFragment;

public class ClickCounterFragment extends MvpFragment<ClickCounterView, ClickCounterPresenter> implements ClickCounterView {
    public static final String ARG_TITLE = "title";

    private TextView clickCountView;

    public static ClickCounterFragment newInstance(String title) {
        final Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);;

        final ClickCounterFragment fragment = new ClickCounterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_click_counter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final TextView titleView = (TextView) view.findViewById(R.id.title);
        final Button button = (Button) view.findViewById(R.id.button);
        clickCountView = (TextView) view.findViewById(R.id.click_count);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().buttonClicked();
            }
        });
        titleView.setText(getTitle());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getPresenter().loadClickCount();
    }

    @Override
    public void setClickCount(int clickCount) {
        clickCountView.setText(getString(R.string.click_count, clickCount));
    }

    @Override
    public ClickCounterPresenter createPresenter() {
        return new ClickCounterPresenterImpl();
    }

    private String getTitle() {
        return getArguments().getString(ARG_TITLE);
    }
}

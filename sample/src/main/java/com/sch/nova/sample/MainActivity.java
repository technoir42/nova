package com.sch.nova.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.sch.nova.MvpHostActivity;

import java.util.List;

public class MainActivity extends MvpHostActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ClickCounterFragment.newInstance("Fragment"))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_fragment:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, ClickCounterFragment.newInstance("Fragment"))
                        .commit();
                return true;
            case R.id.action_add_nested_fragment:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new WrapperFragment())
                        .commit();
                return true;
            case R.id.action_remove_fragment:
                final Fragment fragment = getLastFragment();
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .commit();
                }
                return true;
            case R.id.action_start_activity:
                startActivity(new Intent(this, ClickCounterActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Fragment getLastFragment() {
        final List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (int index = fragments.size() - 1; index >= 0; index--) {
            final Fragment fragment = fragments.get(index);
            if (fragment != null) {
                return fragment;
            }
        }
        return null;
    }
}

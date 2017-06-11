package com.sdos.android.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.R2;
import com.sdos.android.sample.presentation.view.di.HasComponent;
import com.sdos.android.sample.presentation.view.di.components.DaggerMainComponent;
import com.sdos.android.sample.presentation.view.di.components.MainComponent;
import com.sdos.android.sample.presentation.view.fragment.AdminFragment;
import com.sdos.android.sample.presentation.view.fragment.TechnicalFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity with navigation drawer
 */
public class MainActivity extends BaseActivity implements HasComponent<MainComponent>,AdminFragment.AdminInterface{


    public static Intent getCallingIntent(Context context, int option) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("INTENT_MAIN_OPTION_VALUE",option);
        return intent;
    }


    private MainComponent mainComponent;

    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_toolbar);

        ButterKnife.bind(this);
        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.mainComponent = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        toolbar.setTitle("");
        setActionBar(toolbar);
        if (savedInstanceState == null) {
            //addFragment(R.id.content_frame, new AdminFragment());
            addFragment(R.id.content_frame, new TechnicalFragment());
        }
    }

    @Override
    public MainComponent getComponent() {
        return mainComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Do something that differs the Activity's menu here
        getMenuInflater().inflate(R.menu.filter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                navigator.navigateToWebService(this);
                return true;

            default:
                break;
        }

        return false;
    }

    @Override
    public void onCloseSesion() {
        navigator.navigateToLogin(this);
    }
}

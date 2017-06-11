package com.sdos.android.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sdos.android.sample.presentation.R;
import com.irozon.library.HideKey;
import com.sdos.android.sample.presentation.view.di.HasComponent;
import com.sdos.android.sample.presentation.view.di.components.DaggerLoginComponent;
import com.sdos.android.sample.presentation.view.di.components.LoginComponent;
import com.sdos.android.sample.presentation.view.fragment.LoginFragment;

import butterknife.ButterKnife;

/**
 * Main application screen. This is the app entry point.
 */
public class LoginActivity extends BaseActivity implements HasComponent<LoginComponent>,LoginFragment.LoginInterface {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    private LoginComponent loginComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
        HideKey.initialize(this);

        initializeInjector();
        initializeActivity(savedInstanceState);
    }

    private void initializeInjector() {
        this.loginComponent = DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public LoginComponent getComponent() {
        return loginComponent;
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.content_frame, new LoginFragment());
        }
    }

    @Override
    public void onLogin() {
        navigator.navigateToMain(this,0);
    }
}

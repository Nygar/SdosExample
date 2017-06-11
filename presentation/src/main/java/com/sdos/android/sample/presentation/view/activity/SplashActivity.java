package com.sdos.android.sample.presentation.view.activity;

import android.os.Bundle;
import android.os.Handler;

import com.sdos.android.sample.presentation.R;

/**
 * Main application screen. This is the app entry point.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        new Handler().postDelayed(() -> navigator.navigateToLogin(this), 2000);
    }

}

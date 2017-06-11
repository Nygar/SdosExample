package com.sdos.android.sample.presentation;

import android.app.Application;

import com.sdos.android.sample.presentation.view.di.components.ApplicationComponent;
import com.sdos.android.sample.presentation.view.di.components.DaggerApplicationComponent;
import com.sdos.android.sample.presentation.view.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  
}

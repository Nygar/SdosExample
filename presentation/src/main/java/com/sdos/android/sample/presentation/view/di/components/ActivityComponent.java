package com.sdos.android.sample.presentation.view.di.components;

import com.sdos.android.sample.presentation.view.di.PerActivity;
import com.sdos.android.sample.presentation.view.di.modules.ActivityModule;
import com.sdos.android.sample.presentation.view.activity.BaseActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  BaseActivity activity();
}

package com.sdos.android.sample.presentation.view.di.components;

import com.sdos.android.sample.presentation.view.di.PerActivity;
import com.sdos.android.sample.presentation.view.di.modules.ActivityModule;
import com.sdos.android.sample.presentation.view.fragment.LoginFragment;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface LoginComponent extends ActivityComponent {

    void inject(LoginFragment loginFragment);
}

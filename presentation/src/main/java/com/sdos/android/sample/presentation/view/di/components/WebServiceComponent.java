package com.sdos.android.sample.presentation.view.di.components;

import com.sdos.android.sample.presentation.view.di.PerActivity;
import com.sdos.android.sample.presentation.view.di.modules.ActivityModule;
import com.sdos.android.sample.presentation.view.di.modules.ProductModule;
import com.sdos.android.sample.presentation.view.fragment.WSListFragment;
import com.sdos.android.sample.presentation.view.fragment.WSSearchFragment;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ProductModule.class})
public interface WebServiceComponent extends ActivityComponent {
    void inject(WSSearchFragment wsSearchFragment);
    void inject(WSListFragment wsListFragment);

}

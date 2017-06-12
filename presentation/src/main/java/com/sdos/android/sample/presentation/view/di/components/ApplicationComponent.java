package com.sdos.android.sample.presentation.view.di.components;

import android.content.Context;

import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;
import com.sdos.android.sample.presentation.presenter.interactor.GetTaskUseCase;
import com.sdos.android.sample.presentation.presenter.interactor.GetUserUseCase;
import com.sdos.android.sample.presentation.view.di.modules.ApplicationModule;
import com.sdos.android.sample.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();

  GetProductUseCase.ProductRepository productRepository();
  GetUserUseCase.UserRepository userRepository();
  GetTaskUseCase.TaskRepository taskRepository();
}

package com.sdos.android.sample.presentation.view.di.modules;

import com.sdos.android.sample.presentation.presenter.interactor.GetUserUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class LoginModule {

  public LoginModule() {}

  @Provides
  GetUserUseCase provideGetProductUseCase(GetUserUseCase.UserRepository repository) {
    return new GetUserUseCase(repository);
  }
}
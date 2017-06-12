package com.sdos.android.sample.presentation.view.di.modules;

import com.sdos.android.sample.presentation.presenter.interactor.GetTaskUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class TaskModule {

  public TaskModule() {}

  @Provides
  GetTaskUseCase provideGetTaskUseCase(GetTaskUseCase.TaskRepository repository) {
    return new GetTaskUseCase(repository);
  }
}
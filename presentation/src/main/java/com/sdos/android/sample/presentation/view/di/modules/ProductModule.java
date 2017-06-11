package com.sdos.android.sample.presentation.view.di.modules;

import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class ProductModule {

  public ProductModule() {}

  @Provides
  GetProductUseCase provideGetProductUseCase(GetProductUseCase.ProductRepository repository) {
    return new GetProductUseCase(repository);
  }
}
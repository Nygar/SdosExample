package com.sdos.android.sample.presentation.data.repository;


import com.sdos.android.sample.presentation.data.repository.datasource.UserDataStoreFactory;
import com.sdos.android.sample.presentation.data.repository.datasource.source.UserDataStore;
import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;
import com.sdos.android.sample.presentation.presenter.interactor.GetUserUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link  GetProductUseCase.ProductRepository} for retrieving user logged data.
 */
@Singleton
public class UserDataRepository implements GetUserUseCase.UserRepository {

  private final UserDataStoreFactory userDataStoreFactory;

  /**
   * Constructs a {@link GetUserUseCase.UserRepository}.
   *
   * @param dataStoreFactory A factory to construct different data source implementations.
   */
  @Inject
  public UserDataRepository(UserDataStoreFactory dataStoreFactory) {
    this.userDataStoreFactory = dataStoreFactory;
  }

  @Override
  public void users(String name, String pass) {
    final UserDataStore userDataStore = this.userDataStoreFactory.create();
    userDataStore.userEntity(name, pass);
  }
}

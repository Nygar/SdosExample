package com.sdos.android.sample.presentation.data.repository;


import com.sdos.android.sample.presentation.data.repository.datasource.ProductDataStoreFactory;
import com.sdos.android.sample.presentation.data.repository.datasource.source.ProductDataStore;
import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link  GetProductUseCase.ProductRepository} for retrieving user logged data.
 */
@Singleton
public class ProductsDataRepository implements GetProductUseCase.ProductRepository {

  private final ProductDataStoreFactory productDataStoreFactory;

  /**
   * Constructs a {@link GetProductUseCase.ProductRepository}.
   *
   * @param dataStoreFactory A factory to construct different data source implementations.
   */
  @Inject
  public ProductsDataRepository(ProductDataStoreFactory dataStoreFactory) {
    this.productDataStoreFactory = dataStoreFactory;
  }

  @Override
  public void products(String category, String item) {
    final ProductDataStore productDataStore = this.productDataStoreFactory.create(category, item);
    productDataStore.productEntityList(category, item);
  }
}

package com.sdos.android.sample.presentation.data.repository.datasource.source.cloud;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.net.RestApi;
import com.sdos.android.sample.presentation.data.repository.datasource.source.ProductDataStore;
/**
 * {@link ProductDataStore} implementation based on connections to the api (Cloud).
 */
public class CloudProductDataStore implements ProductDataStore {

  private final RestApi restApi;
  private final ProductCache productCache;

  /**
   * Construct a {@link ProductDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link RestApi} implementation to use.
   */
  public CloudProductDataStore(RestApi restApi, ProductCache productCache) {
    this.restApi = restApi;
    this.productCache = productCache;
  }

  @Override
  public void productEntityList(String category, String item) {
    this.restApi.getProductsFromApi(productCache,category, item);
  }
}

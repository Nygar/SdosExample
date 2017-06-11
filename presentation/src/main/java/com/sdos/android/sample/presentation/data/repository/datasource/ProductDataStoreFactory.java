package com.sdos.android.sample.presentation.data.repository.datasource;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.net.RestApi;
import com.sdos.android.sample.presentation.data.net.RestApiImpl;
import com.sdos.android.sample.presentation.data.repository.datasource.source.ProductDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.cloud.CloudProductDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.disk.DiskProductDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link ProductDataStore}.
 */
@Singleton
public class ProductDataStoreFactory {

  private final Context context;
  private final ProductCache productCache;

  @Inject
  public ProductDataStoreFactory(Context context, ProductCache productCache) {
    if (context == null || productCache == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
    this.productCache = productCache;
  }

  /**
   * Create {@link ProductDataStore} from a message id.
   */
  public ProductDataStore create(String category, String item) {
    ProductDataStore productDataStore;

    if (!this.productCache.isExpired(category,item) && this.productCache.isCached(category,item)) {
      productDataStore = new DiskProductDataStore(this.productCache);
    } else {
      productDataStore = createCloudDataStore();
    }

    return productDataStore;
  }

  /**
   * Create {@link ProductDataStore} to retrieve data from the Cloud.
   */
  public ProductDataStore createCloudDataStore() {
    RestApi restApi = new RestApiImpl(this.context);

    return new CloudProductDataStore(restApi,productCache);
  }
}

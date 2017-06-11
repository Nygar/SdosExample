package com.sdos.android.sample.presentation.data.repository.datasource.source.disk;

import android.os.Handler;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.entity.ProductEntity;
import com.sdos.android.sample.presentation.data.repository.datasource.source.ProductDataStore;
import com.sdos.android.sample.presentation.presenter.ProductEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ProductDataStore} implementation based on file system data store.
 */
public class DiskProductDataStore implements ProductDataStore {

  private final ProductCache productCache;

  /**
   * Construct a {@link ProductDataStore} based file system data store.
   *
   * @param productCache A {@link ProductCache} to cache data retrieved from the api.
   */
  public DiskProductDataStore(ProductCache productCache) {
    this.productCache = productCache;
  }


  @Override
  public void productEntityList(String category, String item) {

    ProductEvent res = new ProductEvent();
    List<ProductEntity> entities = new ArrayList<>();

    for (ProductEntity entity: productCache.get(category,item)) {
      entities.add(entity.getPojo());
    }

    res.setEntities(entities);

    new Handler().post(() -> EventBus.getDefault().post(res));

  }
}

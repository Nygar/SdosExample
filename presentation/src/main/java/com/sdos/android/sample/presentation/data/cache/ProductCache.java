package com.sdos.android.sample.presentation.data.cache;


import com.sdos.android.sample.presentation.data.entity.ProductEntity;

import java.util.List;

/**
 * An interface representing a user Cache.
 */
public interface ProductCache {
  /**
   * Gets an {@link List} which will emit a {@link ProductEntity}.
   *
   * @param category The category used to get data.
   * @param item The item used to get data.
   */
  List<ProductEntity> get(final String category, final String item);

  /**
   * Puts and element into the cache.
   *
   * @param productEntities Element to insert in the cache.
   */
  void put(List<ProductEntity> productEntities);

  /**
   * Checks if an element (User) exists in the cache.
   *
   * @param category The category used to get data.
   * @param item The item used to get data.
   * @return true if the element is cached, otherwise false.
   */
  boolean isCached(final String category, final String item);

  /**
   * Checks if the cache is expired.
   * @param category The category used to get data.
   * @param item The item used to get data.
   * @return true, the cache is expired, otherwise false.
   */
  boolean isExpired(final String category, final String item);

  /**
   * Evict all elements of the cache.
   *
   * @param category The category used to get data.
   * @param item The item used to get data.
   */
  void evictAll(final String category, final String item);
}

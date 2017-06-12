package com.sdos.android.sample.presentation.data.cache;


import com.sdos.android.sample.presentation.data.entity.TaskEntity;

import java.util.List;


/**
 * An interface representing a user Cache.
 */
public interface TaskCache {
  /**
   * Gets an {@link Object} which will emit a {@link TaskEntity}.
   *
   * @param userId The id used to get data.
   */
  List<TaskEntity> get(int userId);

  /**
   * Puts and element into the cache.
   *
   * @param userId The id used to get data.
   */
  void put(TaskEntity userEntity, int userId);

  /**
   * Checks if an element (User) exists in the cache.
   *
   * @param userId The id used to get data.
   * @return true if the element is cached, otherwise false.
   */
  boolean isCached(int userId);

  /**
   * Checks if the cache is expired.
   * @param userId The id used to get data.
   * @return true, the cache is expired, otherwise false.
   */
  boolean isExpired(int userId);

  /**
   * Evict all elements of the cache.
   *
   * @param userId The id used to get data.
   */
  void evictAll(int userId);
}

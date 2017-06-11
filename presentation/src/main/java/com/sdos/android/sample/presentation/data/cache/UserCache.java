package com.sdos.android.sample.presentation.data.cache;


import com.sdos.android.sample.presentation.data.entity.UserEntity;


/**
 * An interface representing a user Cache.
 */
public interface UserCache {
  /**
   * Gets an {@link Object} which will emit a {@link UserEntity}.
   *
   * @param username The username used to get data.
   * @param pass The pass used to get data.
   */
  UserEntity get(final String username, final String pass);

  /**
   * Puts and element into the cache.
   *
   * @param userEntity Element to insert in the cache.
   */
  void put(UserEntity userEntity);

  /**
   * Checks if an element (User) exists in the cache.
   *
   * @param username The username used to get data.
   * @param pass The pass used to get data.
   * @return true if the element is cached, otherwise false.
   */
  boolean isCached(final String username, final String pass);

  /**
   * Checks if the cache is expired.
   * @param username The username used to get data.
   * @param pass The pass used to get data.
   * @return true, the cache is expired, otherwise false.
   */
  boolean isExpired(final String username, final String pass);

  /**
   * Evict all elements of the cache.
   *
   * @param username The username used to get data.
   * @param pass The pass used to get data.
   */
  void evictAll(final String username, final String pass);
}

package com.sdos.android.sample.presentation.data.cache.impl;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.FileManager;
import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.cache.TaskCache;
import com.sdos.android.sample.presentation.data.cache.UserCache;
import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.data.entity.UserEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * {@link ProductCache} implementation.
 */
@Singleton
public class TaskCacheImpl implements TaskCache {

  private static final String SETTINGS_KEY = "USER";

  private static final long EXPIRATION_TIME = 60 * 10 * 1000;

  private final Context context;
  private final FileManager fileManager;

  private Realm realm;

  /**
   * Constructor of the class {@link TaskCacheImpl}.
   *
   * @param context A
   * @param fileManager {@link FileManager} for saving serialized objects to the file system.
   */
  @Inject
  public TaskCacheImpl(Context context, FileManager fileManager) {
    if (context == null || fileManager == null) {
      throw new IllegalArgumentException("Invalid null parameter");
    }
    this.context = context.getApplicationContext();
    this.fileManager = fileManager;
    realm= Realm.getDefaultInstance();
  }

  /**
   * Set in millis, the last time the cache was accessed.
   */
  private void setLastCacheUpdateTimeMillis() {
    long currentMillis = System.currentTimeMillis();
    this.fileManager.writeToPreferences(this.context, SETTINGS_KEY, currentMillis);
  }

  /**
   * Get in millis, the last time the cache was accessed.
   */
  private long getLastCacheUpdateTimeMillis() {
    return this.fileManager.getFromPreferences(this.context, SETTINGS_KEY);
  }

  @Override
  public List<TaskEntity> get(int userId) {
    realm= Realm.getDefaultInstance();
    RealmResults<TaskEntity> result = realm.where(TaskEntity.class).equalTo("userId", String.valueOf(userId)).findAll();

    realm.close();

    return result;
  }

  @Override
  public void put(TaskEntity userEntity, int userId) {
    if (userEntity != null) {
      realm= Realm.getDefaultInstance();
      realm.executeTransaction(bgRealm -> bgRealm.copyToRealmOrUpdate(userEntity));
      realm.close();
      setLastCacheUpdateTimeMillis();
    }
  }

  @Override
  public boolean isCached(int userId) {
    boolean res = false;
    realm= Realm.getDefaultInstance();
    RealmResults<TaskEntity> result = realm.where(TaskEntity.class).equalTo("userId",String.valueOf(userId)).findAll();
    if(result.size()>0){
      res=true;
    }
    realm.close();
    return res;
  }

  @Override
  public boolean isExpired(int userId) {
    long currentTime = System.currentTimeMillis();
    long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

    boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

    if (expired) {
      this.evictAll(userId);
    }
    return expired;
  }

  @Override
  public void evictAll(int userId) {
    realm= Realm.getDefaultInstance();
    RealmResults<TaskEntity> result = realm.where(TaskEntity.class).equalTo("userId",String.valueOf(userId)).findAll();
    realm.executeTransaction(bgRealm -> result.deleteAllFromRealm());
    realm.close();
  }
}

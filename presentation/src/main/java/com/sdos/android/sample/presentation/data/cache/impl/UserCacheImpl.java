package com.sdos.android.sample.presentation.data.cache.impl;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.FileManager;
import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.cache.UserCache;
import com.sdos.android.sample.presentation.data.entity.ProductEntity;
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
public class UserCacheImpl implements UserCache {

  private static final String SETTINGS_KEY = "USER";

  private static final long EXPIRATION_TIME = 60 * 10 * 1000;

  private final Context context;
  private final FileManager fileManager;

  private Realm realm;

  /**
   * Constructor of the class {@link UserCacheImpl}.
   *
   * @param context A
   * @param fileManager {@link FileManager} for saving serialized objects to the file system.
   */
  @Inject
  public UserCacheImpl(Context context, FileManager fileManager) {
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
  public UserEntity get(String username, String pass) {

    realm= Realm.getDefaultInstance();
    UserEntity result = realm.where(UserEntity.class).equalTo("name",username).equalTo("pass",pass).findFirst();

    realm.close();

    return result;
  }

  @Override
  public void put(UserEntity userEntity) {
    if (userEntity != null) {
      realm= Realm.getDefaultInstance();
      realm.executeTransaction(bgRealm -> bgRealm.copyToRealmOrUpdate(userEntity));
      realm.close();
      setLastCacheUpdateTimeMillis();
    }
  }

  @Override
  public boolean isCached(String username, String pass) {
    boolean res = false;
    realm= Realm.getDefaultInstance();
    RealmResults<UserEntity> result = realm.where(UserEntity.class).equalTo("username",username).equalTo("pass",pass).findAll();
    if(result.size()>0){
      res=true;
    }
    realm.close();
    return res;
  }

  @Override
  public boolean isExpired(String category, String item) {
    long currentTime = System.currentTimeMillis();
    long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

    boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

    if (expired) {
      this.evictAll(category,item);
    }
    return expired;
  }

  @Override
  public void evictAll(String username, String pass) {
    realm= Realm.getDefaultInstance();
    RealmResults<UserEntity> result = realm.where(UserEntity.class).equalTo("username",username).equalTo("pass",pass).findAll();
    realm.executeTransaction(bgRealm -> result.deleteAllFromRealm());
    realm.close();
  }
}

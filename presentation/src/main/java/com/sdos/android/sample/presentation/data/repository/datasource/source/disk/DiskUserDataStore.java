package com.sdos.android.sample.presentation.data.repository.datasource.source.disk;

import android.os.Handler;

import com.sdos.android.sample.presentation.data.cache.UserCache;
import com.sdos.android.sample.presentation.data.repository.datasource.source.UserDataStore;
import com.sdos.android.sample.presentation.presenter.events.UserEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
public class DiskUserDataStore implements UserDataStore {

  private final UserCache userCache;

  /**
   * Construct a {@link UserDataStore} based file system data store.
   *
   * @param userCache A {@link UserCache} to cache data retrieved from the api.
   */
  public DiskUserDataStore(UserCache userCache) {
    this.userCache = userCache;
  }

  @Override
  public void userEntity(String name, String pass) {
    UserEvent res = new UserEvent();
    res.setEntities(userCache.get( name, pass));

    new Handler().post(() -> EventBus.getDefault().post(res));
  }
}

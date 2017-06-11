package com.sdos.android.sample.presentation.data.repository.datasource;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.UserCache;
import com.sdos.android.sample.presentation.data.net.RestApi;
import com.sdos.android.sample.presentation.data.net.RestApiImpl;
import com.sdos.android.sample.presentation.data.repository.datasource.source.ProductDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.UserDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.cloud.CloudProductDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.disk.DiskProductDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.disk.DiskUserDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

  private final Context context;
  private final UserCache userCache;

  @Inject
  public UserDataStoreFactory(Context context, UserCache userCache) {
    if (context == null || userCache == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
    this.userCache = userCache;
  }

  /**
   * Create {@link UserDataStore} from a message id.
   */
  public UserDataStore create() {
    UserDataStore userDataStore;

    userDataStore = new DiskUserDataStore(this.userCache);

    return userDataStore;
  }
}

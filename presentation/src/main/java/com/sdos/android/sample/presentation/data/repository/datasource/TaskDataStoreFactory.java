package com.sdos.android.sample.presentation.data.repository.datasource;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.TaskCache;
import com.sdos.android.sample.presentation.data.cache.UserCache;
import com.sdos.android.sample.presentation.data.repository.datasource.source.TaskDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.UserDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.disk.DiskTaskDataStore;
import com.sdos.android.sample.presentation.data.repository.datasource.source.disk.DiskUserDataStore;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link TaskDataStore}.
 */
@Singleton
public class TaskDataStoreFactory {

  private final Context context;
  private final TaskCache taskCache;

  @Inject
  public TaskDataStoreFactory(Context context, TaskCache taskCache) {
    if (context == null || taskCache == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
    this.taskCache = taskCache;
  }

  /**
   * Create {@link UserDataStore} from a message id.
   */
  public TaskDataStore create() {
    TaskDataStore taskDataStore;

    taskDataStore = new DiskTaskDataStore(this.taskCache);

    return taskDataStore;
  }
}

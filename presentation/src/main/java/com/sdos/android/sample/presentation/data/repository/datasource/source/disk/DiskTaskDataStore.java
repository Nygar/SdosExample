package com.sdos.android.sample.presentation.data.repository.datasource.source.disk;

import android.os.Handler;

import com.sdos.android.sample.presentation.data.cache.TaskCache;
import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.data.repository.datasource.source.TaskDataStore;
import com.sdos.android.sample.presentation.presenter.events.PostEvent;
import com.sdos.android.sample.presentation.presenter.events.TaskEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * {@link TaskDataStore} implementation based on file system data store.
 */
public class DiskTaskDataStore implements TaskDataStore {

  private final TaskCache cache;

  /**
   * Construct a {@link TaskDataStore} based file system data store.
   *
   * @param cache A {@link TaskCache} to cache data retrieved from the api.
   */
  public DiskTaskDataStore(TaskCache cache) {
    this.cache = cache;
  }


  @Override
  public void getTask(int idUser) {
    TaskEvent res = new TaskEvent();
    res.setEntities(cache.get(idUser));

    new Handler().post(() -> EventBus.getDefault().post(res));
  }

  @Override
  public void postTask(TaskEntity taskEntity, int idUser) {
    PostEvent res = new PostEvent();
    cache.put(taskEntity, idUser);

    new Handler().post(() -> EventBus.getDefault().post(res));
  }
}

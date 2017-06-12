package com.sdos.android.sample.presentation.data.repository.datasource.source;


import com.sdos.android.sample.presentation.data.entity.TaskEntity;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface TaskDataStore {

  void getTask(int idUser);

  void postTask(TaskEntity taskEntity, int idUser);

}

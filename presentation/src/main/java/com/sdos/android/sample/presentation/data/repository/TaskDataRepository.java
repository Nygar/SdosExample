package com.sdos.android.sample.presentation.data.repository;


import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.data.repository.datasource.TaskDataStoreFactory;
import com.sdos.android.sample.presentation.data.repository.datasource.source.TaskDataStore;
import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;
import com.sdos.android.sample.presentation.presenter.interactor.GetTaskUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link  GetProductUseCase.ProductRepository} for retrieving user logged data.
 */
@Singleton
public class TaskDataRepository implements GetTaskUseCase.TaskRepository {

  private final TaskDataStoreFactory taskDataStoreFactory;

  /**
   * Constructs a {@link GetProductUseCase.ProductRepository}.
   *
   * @param dataStoreFactory A factory to construct different data source implementations.
   */
  @Inject
  public TaskDataRepository(TaskDataStoreFactory dataStoreFactory) {
    this.taskDataStoreFactory = dataStoreFactory;
  }

  @Override
  public void getTask(int idUser) {
    final TaskDataStore taskDataStore = this.taskDataStoreFactory.create();
    taskDataStore.getTask(idUser);
  }

  @Override
  public void updateTask(int idTask) {
    final TaskDataStore taskDataStore = this.taskDataStoreFactory.create();
    taskDataStore.updateTask(idTask);
  }

  @Override
  public void postTask(TaskEntity taskEntity) {
    final TaskDataStore taskDataStore = this.taskDataStoreFactory.create();
    taskDataStore.postTask(taskEntity);
  }
}

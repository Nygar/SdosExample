package com.sdos.android.sample.presentation.presenter.interactor;

import com.sdos.android.sample.presentation.data.entity.TaskEntity;

import javax.inject.Inject;

import amitkma.stitch.annotations.CallOnAnyThread;


/**
 * This class is an implementation that represents a use case for
 * retrieving data related.
 */
public class GetTaskUseCase {

  /**
   * Interface for listening events.
   */
  public interface TaskRepository {
    void getTask(int idUser);
    void postTask(TaskEntity taskEntity);
    void updateTask(int idTask);
  }

  public static final int PRIORITY = 1;
  private TaskRepository taskRepository;

  @Inject
  public GetTaskUseCase(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }


  @CallOnAnyThread
  public void setParamsForGetTask(int idUser){
    taskRepository.getTask(idUser);
  }
  @CallOnAnyThread
  public void setParamsForPostTask(TaskEntity taskEntity){
    taskRepository.postTask(taskEntity);
  }
  @CallOnAnyThread
  public void setParamsForUpdateTask(int idTask){
      taskRepository.updateTask(idTask);
  }
}

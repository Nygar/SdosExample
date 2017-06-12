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
    void postTask(TaskEntity taskEntity,int idUser);
  }

  private TaskEntity taskEntity;
  private int idUser;

  public static final int PRIORITY = 1;
  private TaskRepository productRepository;

  @Inject
  public GetTaskUseCase(TaskRepository productRepository) {
    this.productRepository = productRepository;
  }

  @CallOnAnyThread
  public void execute(){
    if(taskEntity!=null) {
      productRepository.postTask(taskEntity,idUser);
    }else{
      productRepository.getTask(idUser);
    }
  }

  public void setParams(TaskEntity taskEntity,int idUser){
    this.taskEntity=taskEntity;
    this.idUser=idUser;
  }
}

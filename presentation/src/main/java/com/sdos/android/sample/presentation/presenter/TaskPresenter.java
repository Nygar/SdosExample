package com.sdos.android.sample.presentation.presenter;


import android.support.annotation.NonNull;

import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.data.entity.mapper.TaskEntityDataMapper;
import com.sdos.android.sample.presentation.model.ProductModel;
import com.sdos.android.sample.presentation.model.TaskModel;
import com.sdos.android.sample.presentation.presenter.events.PostEvent;
import com.sdos.android.sample.presentation.presenter.events.TaskEvent;
import com.sdos.android.sample.presentation.presenter.interactor.GetTaskUseCase;
import com.sdos.android.sample.presentation.view.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class TaskPresenter implements Presenter {

  private MainView view;

  private final GetTaskUseCase getTaskUseCase;
  private final TaskEntityDataMapper taskEntityDataMapper;

  @Inject
  public TaskPresenter(GetTaskUseCase getTaskUseCase
          , TaskEntityDataMapper taskEntityDataMapper
                           ) {
    this.getTaskUseCase = getTaskUseCase;
    this.taskEntityDataMapper = taskEntityDataMapper;
  }

  public void setView(@NonNull MainView view) {
    this.view = view;
  }

  @Override public void resume() {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }

  }

  @Override public void pause() {}

  @Override public void destroy() {
    EventBus.getDefault().unregister(this);
  }


  private void showViewLoading() {
    this.view.showLoading();
  }

  private void hideViewLoading() {
    this.view.hideLoading();
  }

  private void showViewRetry() {
    this.view.showRetry();
  }

  private void hideViewRetry() {
    this.view.hideRetry();
  }

  private void showCollectionInView(List<TaskModel> taskEntities) {
    this.view.renderTaskList(taskEntities);
  }

  private void onTaskResponse(String response) {
    this.view.responseTask(response);
  }

  public void getTaskList(int idUser) {
    hideViewRetry();
    getTaskUseCase.setParamsForGetTask(idUser);
  }

  public void postTask(TaskModel taskModel) {
    getTaskUseCase.setParamsForPostTask(taskEntityDataMapper.transform(taskModel));
  }

  public void updateTask(int idTask) {
    getTaskUseCase.setParamsForUpdateTask(idTask);
  }

  @Subscribe
  public void onEvent(TaskEvent event) {
    if(event.getEntities().size()>0) {
      showCollectionInView(taskEntityDataMapper.transform(event.getEntities()));
    }else{
      showViewRetry();
    }
  }

  @Subscribe
  public void onEvent(PostEvent event) {
    onTaskResponse(event.getEntities());
  }
}

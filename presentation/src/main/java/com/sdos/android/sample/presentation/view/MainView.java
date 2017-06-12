package com.sdos.android.sample.presentation.view;

import com.sdos.android.sample.presentation.model.TaskModel;

import java.util.List;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a user logged.
 */
public interface MainView extends LoadDataView{


  void renderTaskList(List<TaskModel> taskModels);
  void responseTask(String response);
}

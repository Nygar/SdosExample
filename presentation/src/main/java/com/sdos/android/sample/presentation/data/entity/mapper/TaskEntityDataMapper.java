package com.sdos.android.sample.presentation.data.entity.mapper;

import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.model.TaskModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link TaskEntity} (in the data layer) to {@link TaskModel} in the
 * domain layer.
 */
public class TaskEntityDataMapper {

  @Inject
  public TaskEntityDataMapper() {}

  /**
   * Transform a {@link TaskEntity} into an {@link TaskModel}.
   *
   * @param taskEntity Object to be transformed.
   * @return {@link TaskModel} if valid {@link TaskEntity} otherwise null.
   */
  public TaskModel transform(TaskEntity taskEntity) {
    TaskModel res = new TaskModel();
    if (taskEntity != null) {
      res.setEnd(taskEntity.isEnd());
      res.setName(taskEntity.getName());
      res.setDescription(taskEntity.getDescription());
      res.setDuration(taskEntity.getDuration());
      res.setTypeTask(taskEntity.getTypeTask());
      res.setIdTask(taskEntity.getIdTask());
      res.setUserId(taskEntity.getUserId());
    }

    return res;
  }

  /**
   * Transform a List of {@link TaskEntity} into a Collection of {@link TaskModel}.
   *
   * @param inputEntityCollection Object Collection to be transformed.
   * @return {@link TaskModel} if valid {@link TaskEntity} otherwise null.
   */
  public List<TaskModel> transform(Collection<TaskEntity> inputEntityCollection) {
    List outputlist = new ArrayList();
    for (TaskEntity entity : inputEntityCollection) {
      TaskModel in = transform(entity);
      if (in != null) {
        outputlist.add(in);
      }
    }
    return outputlist;
  }

  /**
   * Transform a {@link TaskModel} into an {@link TaskEntity}.
   *
   * @param taskEntity Object to be transformed.
   * @return {@link TaskEntity} if valid {@link TaskModel} otherwise null.
   */
  public TaskEntity  transform( TaskModel taskEntity) {
    TaskEntity res = new TaskEntity();
    if (taskEntity != null) {
      res.setEnd(taskEntity.isEnd());
      res.setName(taskEntity.getName());
      res.setDescription(taskEntity.getDescription());
      res.setDuration(taskEntity.getDuration());
      res.setTypeTask(taskEntity.getTypeTask());
      res.setIdTask(taskEntity.getIdTask());
      res.setUserId(taskEntity.getUserId());
    }

    return res;
  }

}

package com.sdos.android.sample.presentation.data.entity;

import io.realm.RealmObject;

/**
 * Class that represents a task in the presentation layer.
 */
public class TaskEntity extends RealmObject {

  private String name;
  private int typeTask;
  private String description;
  private int duration;
  private boolean end;
  private String idTask;
  private String userId;

  public TaskEntity() {
  }

  public TaskEntity(String name, int typeTask, String description, int duration, boolean end) {
    this.name = name;
    this.typeTask = typeTask;
    this.description = description;
    this.duration = duration;
    this.end = end;
  }

  public TaskEntity(String name, int typeTask, String description, int duration, boolean end, String idTask, String userId) {
    this.name = name;
    this.typeTask = typeTask;
    this.description = description;
    this.duration = duration;
    this.end = end;
    this.idTask = idTask;
    this.userId = userId;
  }

  public TaskEntity(String name, boolean end) {
    this.name = name;
    this.end = end;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTypeTask() {
    return typeTask;
  }

  public void setTypeTask(int typeTask) {
    this.typeTask = typeTask;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }

  public String getIdTask() {
    return idTask;
  }

  public void setIdTask(String idTask) {
    this.idTask = idTask;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}

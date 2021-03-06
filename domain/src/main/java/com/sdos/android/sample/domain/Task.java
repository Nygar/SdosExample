package com.sdos.android.sample.domain;

/**
 * Class that represents a task in the presentation layer.
 */
public class Task {

  private String name;
  private int typeTask;
  private String description;
  private int duration;
  private boolean end;

  public Task() {
  }

  public Task(String name, boolean end) {
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
}

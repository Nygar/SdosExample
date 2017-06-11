package com.sdos.android.sample.domain;

import java.util.List;

/**
 * Class that represents a user in the presentation layer.
 */
public class User {

  private String name;
  private String codeUser;
  private int typeUser;
  private List taskList;

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCodeUser() {
    return codeUser;
  }

  public void setCodeUser(String codeUser) {
    this.codeUser = codeUser;
  }

  public int getTypeUser() {
    return typeUser;
  }

  public void setTypeUser(int typeUser) {
    this.typeUser = typeUser;
  }

  public List getTaskList() {
    return taskList;
  }

  public void setTaskList(List taskList) {
    this.taskList = taskList;
  }
}

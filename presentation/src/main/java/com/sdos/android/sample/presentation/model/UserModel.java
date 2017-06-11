package com.sdos.android.sample.presentation.model;

import java.util.List;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserModel {

  private String name;
  private String pass;
  private String codeUser;
  private int typeUser;
  private List taskList;

  public UserModel() {
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

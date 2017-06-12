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
  private List<Integer> taskList;
  private int id;


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

  public List<Integer> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<Integer> taskList) {
    this.taskList = taskList;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

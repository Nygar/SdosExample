package com.sdos.android.sample.presentation.data.entity;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserEntity extends RealmObject{

  private int id;
  private String name;
  private String pass;
  private String codeUser;
  private int typeUser;
  private RealmList<IntegerRealmObject> taskList;

  public UserEntity() {
  }

  public UserEntity(int id,String name, String pass, String codeUser, int typeUser, List<IntegerRealmObject>integerRealmObjects) {
    this.id=id;
    this.name = name;
    this.pass = pass;
    this.codeUser = codeUser;
    this.typeUser = typeUser;
    this.taskList = new RealmList<>();
    if(integerRealmObjects!=null) {
      this.taskList.addAll(integerRealmObjects);
    }
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

  public List<IntegerRealmObject> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<IntegerRealmObject> taskList) {
      this.taskList.addAll(taskList);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
}

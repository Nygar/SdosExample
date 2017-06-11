package com.sdos.android.sample.presentation.data.entity;

import io.realm.RealmObject;

/**
 * Class that represents a task in the presentation layer.
 */
public class IntegerRealmObject extends RealmObject {

  private Integer integer;

  public IntegerRealmObject( int i) {
    integer=i;
  }

  public IntegerRealmObject() {
  }

  public IntegerRealmObject(Integer integer) {
    this.integer = integer;
  }

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }
}

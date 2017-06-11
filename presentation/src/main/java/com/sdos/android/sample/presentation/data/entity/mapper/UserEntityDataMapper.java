package com.sdos.android.sample.presentation.data.entity.mapper;

import com.sdos.android.sample.presentation.data.entity.UserEntity;
import com.sdos.android.sample.presentation.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link UserModel} in the
 * domain layer.
 */
public class UserEntityDataMapper {

  @Inject
  public UserEntityDataMapper() {}

  /**
   * Transform a {@link UserEntity} into an {@link UserModel}.
   *
   * @param userEntity Object to be transformed.
   * @return {@link UserModel} if valid {@link UserEntity} otherwise null.
   */
  public UserModel transform(UserEntity userEntity) {
    UserModel res = new UserModel();
    if (userEntity != null) {
      res.setCodeUser(userEntity.getCodeUser());
      res.setName(userEntity.getName());
      res.setTaskList(userEntity.getTaskList());
      res.setTypeUser(userEntity.getTypeUser());
    }

    return res;
  }

  /**
   * Transform a List of {@link UserEntity} into a Collection of {@link UserModel}.
   *
   * @param inputEntityCollection Object Collection to be transformed.
   * @return {@link UserModel} if valid {@link UserEntity} otherwise null.
   */
  public List<UserModel> transform(Collection<UserEntity> inputEntityCollection) {
    List outputlist = new ArrayList();
    for (UserEntity entity : inputEntityCollection) {
      UserModel in = transform(entity);
      if (in != null) {
        outputlist.add(in);
      }
    }
    return outputlist;
  }

}

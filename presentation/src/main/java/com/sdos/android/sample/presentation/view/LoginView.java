package com.sdos.android.sample.presentation.view;

import com.sdos.android.sample.presentation.model.UserModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a user logged.
 */
public interface LoginView extends LoadDataView{


  void renderUserLogin(UserModel userModel);
}

package com.sdos.android.sample.presentation.presenter;


import android.support.annotation.NonNull;

import com.sdos.android.sample.presentation.data.entity.mapper.ProductEntityDataMapper;
import com.sdos.android.sample.presentation.data.entity.mapper.UserEntityDataMapper;
import com.sdos.android.sample.presentation.model.UserModel;
import com.sdos.android.sample.presentation.presenter.events.UserEvent;
import com.sdos.android.sample.presentation.presenter.interactor.GetUserUseCase;
import com.sdos.android.sample.presentation.view.LoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class UserPresenter implements Presenter {

  private LoginView loginView;

  private final GetUserUseCase getUserUseCase;
  private final UserEntityDataMapper userEntityDataMapper;

  @Inject
  public UserPresenter(GetUserUseCase getUserUseCase
          , UserEntityDataMapper userEntityDataMapper
                           ) {
    this.getUserUseCase = getUserUseCase;
    this.userEntityDataMapper = userEntityDataMapper;
  }

  public void setView(@NonNull LoginView view) {
    this.loginView = view;
  }

  @Override public void resume() {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }

  }

  @Override public void pause() {}

  @Override public void destroy() {
    EventBus.getDefault().unregister(this);
  }

  /**
   * Initializes the presenter by start retrieving the message list.
   */
  public void initialize(String name, String pass) {
    this.loadUsers(name,pass);
  }

  /**
   * Loads all message.
   */
  private void loadUsers(String category, String item) {
    this.hideViewRetry();
    this.showViewLoading();
    this.getUser(category, item);
  }

  private void showViewLoading() {
    this.loginView.showLoading();
  }

  private void hideViewLoading() {
    this.loginView.hideLoading();
  }

  private void showViewRetry() {
    this.loginView.showRetry();
  }

  private void hideViewRetry() {
    this.loginView.hideRetry();
  }

  private void showCollectionInView(UserModel userModel) {
    this.loginView.renderUserLogin(userModel);
  }

  private void getUser(String name, String pass) {
    getUserUseCase.setParams(name, pass);

    getUserUseCase.execute();
  }

  @Subscribe
  public void onEvent(UserEvent event) {
    showCollectionInView(userEntityDataMapper.transform(event.getEntities()));
  }
}

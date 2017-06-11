package com.sdos.android.sample.presentation.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;
import com.sdos.android.sample.presentation.data.entity.mapper.ProductEntityDataMapper;
import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;
import com.sdos.android.sample.presentation.model.ProductModel;
import com.sdos.android.sample.presentation.view.WSView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class WServicePresenter implements Presenter {

  private WSView wsView;

  private final GetProductUseCase getProductUseCase;
  private final ProductEntityDataMapper productEntityDataMapper;

  @Inject
  public WServicePresenter(GetProductUseCase getProductUseCase
          , ProductEntityDataMapper productEntityDataMapper
                           ) {
    this.getProductUseCase = getProductUseCase;
    this.productEntityDataMapper = productEntityDataMapper;
  }

  public void setView(@NonNull WSView view) {
    this.wsView = view;
  }

  @Override public void resume() {
    EventBus.getDefault().register(this);

  }

  @Override public void pause() {}

  @Override public void destroy() {
    EventBus.getDefault().unregister(this);
  }

  /**
   * Initializes the presenter by start retrieving the message list.
   */
  public void initialize(String category, String item) {
    this.loadMessageList(category,item);
  }

  /**
   * Loads all message.
   */
  private void loadMessageList(String category, String item) {
    this.hideViewRetry();
    this.showViewLoading();
    this.getProductList(category, item);
  }

  private void showViewLoading() {
    this.wsView.showLoading();
  }

  private void hideViewLoading() {
    this.wsView.hideLoading();
  }

  private void showViewRetry() {
    this.wsView.showRetry();
  }

  private void hideViewRetry() {
    this.wsView.hideRetry();
  }

  private void showMessageCollectionInView(List<ProductModel> productModels) {
    this.wsView.renderProducts(productModels);
  }

  private void getProductList(String category, String item) {
    getProductUseCase.setParams(category, item);

    getProductUseCase.execute();
  }

  @Subscribe
  public void onEvent(ProductEvent event) {
    showMessageCollectionInView(productEntityDataMapper.transform(event.getEntities()));
  }
}
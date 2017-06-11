package com.sdos.android.sample.presentation.view.di.modules;

import android.content.Context;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.cache.impl.ProductCacheImpl;
import com.sdos.android.sample.presentation.AndroidApplication;
import com.sdos.android.sample.presentation.data.repository.ProductsDataRepository;
import com.sdos.android.sample.presentation.presenter.interactor.GetProductUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    Realm.init(this.application);
    RealmConfiguration config = new RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .initialData(new Realm.Transaction() {
              @Override
              public void execute(Realm realm) {

              }
            })
            .build();
    Realm.setDefaultConfiguration(config);
    return this.application;
  }

  @Provides @Singleton
  ProductCache provideUserCache(ProductCacheImpl userCache) {
    return userCache;
  }

  @Provides @Singleton
  GetProductUseCase.ProductRepository provideUserRepository(ProductsDataRepository productsDataRepository) {
    return productsDataRepository;
  }
}

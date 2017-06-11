package com.sdos.android.sample.presentation.data.repository.datasource.source;


/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface ProductDataStore {

  void productEntityList(String category,String item);

}

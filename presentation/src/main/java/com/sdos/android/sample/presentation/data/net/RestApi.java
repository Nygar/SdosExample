package com.sdos.android.sample.presentation.data.net;

import java.util.List;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.entity.ProductEntity;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
    /**
     * Retrieves an {@link List} which will emit a {@link ProductEntity}.
     * Api url for getting example data
     *
     * @param category The category used to get data.
     * @param item The item used to get data.
     */
    void getProductsFromApi(ProductCache productCache,String category, String item);

}

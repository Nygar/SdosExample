package com.sdos.android.sample.presentation.data.net;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestEndPoint {
    String API_BASE_URL = "https://data.ct.gov/resource/";

    /**
     * Retrieves an {@link Call} which will emit a {@link ProductEntity}.
     * Api url for getting example data: Remember to concatenate id + 'json'
     *
     * @param category The category used to get data.
     * @param item The item used to get data.
     */
    @GET("hma6-9xbg.json")
    Call<List<ProductEntity>> getProducts(@Query("category") String category, @Query("item") String item);

}

package com.sdos.android.sample.presentation.data.net;

import android.content.Context;
import android.util.Log;

import com.sdos.android.sample.presentation.data.cache.ProductCache;
import com.sdos.android.sample.presentation.data.entity.ProductEntity;
import com.sdos.android.sample.presentation.presenter.ProductEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sdos.android.sample.presentation.data.net.RestEndPoint.API_BASE_URL;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

    private final Context context;
    private RestEndPoint retrofitAPI;

    /**
     * Constructor of the class
     *
     * @param context {@link Context}.
     */
    public RestApiImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RestEndPoint.class);
    }

    @Override
    public void getProductsFromApi(ProductCache productCache,String category, String item) {
         retrofitAPI.getProducts(category, item).enqueue(new Callback<List<ProductEntity>>() {
            @Override
            public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {
                productCache.put(response.body());
                ProductEvent event = new ProductEvent();
                event.setEntities(response.body());
                EventBus.getDefault().post(event);
            }

            @Override
            public void onFailure(Call<List<ProductEntity>> call, Throwable t) {
                Log.d("","");
            }
        });
    }
}

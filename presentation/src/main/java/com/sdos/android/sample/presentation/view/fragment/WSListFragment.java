package com.sdos.android.sample.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.view.di.components.WebServiceComponent;
import com.sdos.android.sample.presentation.model.ProductModel;
import com.sdos.android.sample.presentation.presenter.WServicePresenter;
import com.sdos.android.sample.presentation.view.WSView;
import com.sdos.android.sample.presentation.view.adapter.ItemModelAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment for login users.
 */
@FragmentWithArgs
public class WSListFragment extends BaseFragment implements WSView {

    @Arg
    private String category;

    @Arg
    private String items;

    @BindView(R.id.wslist_recycleview)
    RecyclerView recyclerView;

    @Inject
    ItemModelAdapter itemModelAdapter;

    @Inject
    WServicePresenter wServicePresenter;

    public WSListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
        this.getComponent(WebServiceComponent.class).inject(this);
        wServicePresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_wslist, container, false);
        ButterKnife.bind(this, fragmentView);

        inicializeFragment();
        return fragmentView;
    }

    private void inicializeFragment(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemModelAdapter);

        wServicePresenter.initialize(category,items);

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public void onResume() {
        super.onResume();
        wServicePresenter.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wServicePresenter.destroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void renderProducts(List<ProductModel> productModels) {
        itemModelAdapter.setCollection(productModels);
    }
}

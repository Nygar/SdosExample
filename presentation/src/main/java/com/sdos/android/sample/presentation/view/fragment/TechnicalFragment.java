package com.sdos.android.sample.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;
import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.presenter.TaskPresenter;
import com.sdos.android.sample.presentation.view.MainView;
import com.sdos.android.sample.presentation.view.di.components.MainComponent;
import com.sdos.android.sample.presentation.model.TaskModel;
import com.sdos.android.sample.presentation.view.adapter.TaskModelAdapter;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment for login users.
 */
@FragmentWithArgs
public class TechnicalFragment extends BaseFragment implements MainView {

    @Arg
    private int idUser;

    @BindView(R.id.technical_recycleview)
    RecyclerView recyclerView;

    @Inject
    TaskModelAdapter taskModelAdapter;

    @Inject
    TaskPresenter taskPresenter;

    public TechnicalFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
        this.getComponent(MainComponent.class).inject(this);
        taskPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_technical, container, false);
        ButterKnife.bind(this, fragmentView);

        inicializeFragment();
        return fragmentView;
    }

    private void inicializeFragment(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskModelAdapter.setOnItemClickListener(tasAdapterInterface);
        recyclerView.setAdapter(taskModelAdapter);
        taskModelAdapter.setMode(Attributes.Mode.Single);

        taskPresenter.getTaskList(idUser);
    }

    @Override
    public void onResume() {
        super.onResume();
        taskPresenter.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        taskPresenter.destroy();
    }

    //Listener for TasAdapter click
    private TaskModelAdapter.TasAdapterInterface tasAdapterInterface = model -> taskPresenter.updateTask(model.getIdTask());

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public void renderTaskList(List<TaskModel> taskModels) {
        taskModelAdapter.setCollection(taskModels);
    }

    @Override
    public void responseTask(String response) {

    }
}

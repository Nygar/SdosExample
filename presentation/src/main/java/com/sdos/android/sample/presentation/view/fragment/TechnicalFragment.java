package com.sdos.android.sample.presentation.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;
import com.sdos.android.sample.presentation.R;
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
public class TechnicalFragment extends BaseFragment  {

    @BindView(R.id.technical_recycleview)
    RecyclerView recyclerView;

    @Inject
    TaskModelAdapter taskModelAdapter;

    public TechnicalFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MainComponent.class).inject(this);
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
        taskModelAdapter.setCollection(testModel());
    }

    private List<TaskModel> testModel(){
        List<TaskModel> tasklist = new ArrayList<>();
        tasklist.add(new TaskModel("a",false));
        tasklist.add(new TaskModel("b",false));
        tasklist.add(new TaskModel("c",false));
        tasklist.add(new TaskModel("d",true));
        tasklist.add(new TaskModel("a",false));
        tasklist.add(new TaskModel("b",false));
        tasklist.add(new TaskModel("c",true));
        tasklist.add(new TaskModel("d",false));
        tasklist.add(new TaskModel("a",false));
        tasklist.add(new TaskModel("b",true));
        tasklist.add(new TaskModel("c",false));
        tasklist.add(new TaskModel("d",false));
        tasklist.add(new TaskModel("a",true));
        tasklist.add(new TaskModel("b",false));
        tasklist.add(new TaskModel("c",false));
        tasklist.add(new TaskModel("d",false));
        return  tasklist;
    }

    //Listener for TasAdapter click
    private TaskModelAdapter.TasAdapterInterface tasAdapterInterface = model -> {

    };

}

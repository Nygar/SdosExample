package com.sdos.android.sample.presentation.presenter.events;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;
import com.sdos.android.sample.presentation.data.entity.TaskEntity;

import java.util.List;

public class TaskEvent {

    private List<TaskEntity> entities;

    public TaskEvent() {
    }

    public List<TaskEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<TaskEntity> entities) {
        this.entities = entities;
    }
}

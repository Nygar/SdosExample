package com.sdos.android.sample.presentation.presenter.events;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;

import java.util.List;

public class PostEvent {

    private String entities;

    public PostEvent() {
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }
}

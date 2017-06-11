package com.sdos.android.sample.presentation.presenter;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;

import java.util.List;

public class ProductEvent {

    private List<ProductEntity> entities;

    public ProductEvent() {
    }

    public List<ProductEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<ProductEntity> entities) {
        this.entities = entities;
    }
}

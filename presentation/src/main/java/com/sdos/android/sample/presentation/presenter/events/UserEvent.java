package com.sdos.android.sample.presentation.presenter.events;

import com.sdos.android.sample.presentation.data.entity.UserEntity;


public class UserEvent {

    private UserEntity entities;

    public UserEvent() {
    }

    public UserEntity getEntities() {
        return entities;
    }

    public void setEntities(UserEntity entities) {
        this.entities = entities;
    }
}

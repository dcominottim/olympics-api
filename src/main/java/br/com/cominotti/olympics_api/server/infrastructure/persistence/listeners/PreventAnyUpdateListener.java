package br.com.cominotti.olympics_api.server.infrastructure.persistence.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class PreventAnyUpdateListener {

    @PrePersist
    void onPrePersist(Object o) {
        throw new RuntimeException();
    }

    @PreUpdate
    void onPreUpdate(Object o) {
        throw new RuntimeException();
    }

    @PreRemove
    void onPreRemove(Object o) {
        throw new RuntimeException();
    }
}

package br.com.cominotti.olympics_api.server.infrastructure.rest.views;

import br.com.cominotti.olympics_api.server.infrastructure.persistence.listeners.PreventAnyUpdateListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "local")
@EntityListeners(PreventAnyUpdateListener.class)
public class LocalVo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

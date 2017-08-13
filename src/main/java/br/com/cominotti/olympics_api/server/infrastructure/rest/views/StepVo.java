package br.com.cominotti.olympics_api.server.infrastructure.rest.views;

import br.com.cominotti.olympics_api.server.infrastructure.persistence.listeners.PreventAnyUpdateListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "step")
@EntityListeners(PreventAnyUpdateListener.class)
public class StepVo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "accepts_same_competitors")
    @NotNull
    private Boolean acceptsSameCompetitors;


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

    public Boolean getAcceptsSameCompetitors() {
        return acceptsSameCompetitors;
    }

    public void setAcceptsSameCompetitors(Boolean acceptsSameCompetitors) {
        this.acceptsSameCompetitors = acceptsSameCompetitors;
    }
}

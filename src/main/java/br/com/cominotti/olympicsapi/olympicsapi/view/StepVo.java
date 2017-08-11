package br.com.cominotti.olympicsapi.olympicsapi.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "step")
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

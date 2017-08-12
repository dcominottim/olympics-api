package br.com.cominotti.olympics_api.server.infrastructure.rest.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "competitor")
public class CompetitorVo {

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

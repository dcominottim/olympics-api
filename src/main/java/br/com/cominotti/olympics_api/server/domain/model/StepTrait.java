package br.com.cominotti.olympics_api.server.domain.model;

import javax.validation.constraints.NotNull;

public interface StepTrait {

    Integer getId();

    @NotNull
    String name();

    @NotNull
    Boolean acceptsSameCompetitors();
}

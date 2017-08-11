package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import javax.validation.constraints.NotNull;

public interface StepTrait {

    Integer getId();

    @NotNull
    String name();

    Boolean acceptsSameCompetitors();
}

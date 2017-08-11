package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import javax.validation.constraints.NotNull;

public interface LocalTrait {

    Integer getId();

    @NotNull
    String getName();
}

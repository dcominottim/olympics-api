package br.com.cominotti.olympics_api.server.domain.model;

import javax.validation.constraints.NotNull;

public interface ModalityTrait {

    Integer getId();

    @NotNull
    String getName();
}

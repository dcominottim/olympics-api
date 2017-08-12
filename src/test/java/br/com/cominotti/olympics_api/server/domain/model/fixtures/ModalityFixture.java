package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.ModalityTrait;

public class ModalityFixture {

    public static ModalityTrait newModalityTrait(final Integer id) {
        return new ModalityTrait() {
            @Override
            public Integer getId() {
                return id;
            }

            @Override
            public String getName() {
                return "Futebol";
            }
        };
    }
}

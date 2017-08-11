package br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures;

import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.ModalityTrait;

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

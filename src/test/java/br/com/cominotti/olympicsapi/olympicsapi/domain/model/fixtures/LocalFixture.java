package br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures;

import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.LocalTrait;

public class LocalFixture {

    public static LocalTrait newLocalTrait(final Integer id) {
        return new LocalTrait() {
            @Override
            public Integer getId() {
                return id;
            }

            @Override
            public String getName() {
                return "Estádio X";
            }

            public boolean equals(Object object) {
                return LocalTrait.class.isInstance(object)
                        && ((LocalTrait) object).getId().equals(getId());
            }
        };
    }
}

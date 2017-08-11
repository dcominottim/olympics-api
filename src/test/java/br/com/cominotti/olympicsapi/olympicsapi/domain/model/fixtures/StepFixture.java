package br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures;

import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.StepTrait;

import java.util.Objects;

public class StepFixture {

    public static StepTrait newInstance(final boolean acceptsSameCompetitors) {
        return new StepTrait() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String name() {
                return "Finais";
            }

            @Override
            public Boolean acceptsSameCompetitors() {
                return Objects.requireNonNull(acceptsSameCompetitors);
            }
        };
    }
}

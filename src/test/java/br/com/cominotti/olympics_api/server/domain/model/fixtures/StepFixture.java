package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.StepTrait;

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

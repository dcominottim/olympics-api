package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.*;

import java.time.LocalDateTime;

public class CompetitionFixture {

    public static CompetitionTrait newCompetitionTrait() {
        return new CompetitionTrait() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public CompetitorTrait getCompetitor1() {
                return CompetitorFixture.newCompetitor(1);
            }

            @Override
            public CompetitorTrait getCompetitor2() {
                return CompetitorFixture.newCompetitor(2);
            }

            @Override
            public LocalTrait getLocal() {
                return LocalFixture.newLocalTrait(1);
            }

            @Override
            public ModalityTrait getModality() {
                return ModalityFixture.newModalityTrait(1);
            }

            @Override
            public StepTrait getStep() {
                return StepFixture.newInstance(false);
            }

            @Override
            public LocalDateTime getStartDateTime() {
                return LocalDateTime.now();
            }

            @Override
            public LocalDateTime getEndDateTime() {
                return getStartDateTime().plusHours(1);
            }
        };
    }
}

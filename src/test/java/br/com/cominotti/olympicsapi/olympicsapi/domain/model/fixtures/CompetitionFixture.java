package br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures;

import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.*;

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
                return null;
            }

            @Override
            public CompetitorTrait getCompetitor2() {
                return null;
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
            public Step getStep() {
                return null;
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

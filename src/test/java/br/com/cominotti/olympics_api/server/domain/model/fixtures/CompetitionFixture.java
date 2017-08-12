package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompetitionFixture {


    public static CompetitionTrait newTraitInstance(@NotNull final LocalDateTime startDateTime,
                                                    @NotNull final LocalDateTime endDateTime) {
        return newTraitInstance(
            LocalFixture.newTraitInstance(1),
            ModalityFixture.newTraitInstance(1),
            startDateTime,
            endDateTime
        );
    }

    public static CompetitionTrait newTraitInstance(@NotNull final LocalTrait localTrait,
                                                    @NotNull final ModalityTrait modalityTrait,
                                                    @NotNull final LocalDateTime startDateTime,
                                                    @NotNull final LocalDateTime endDateTime) {
        return new CompetitionTrait() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public CompetitorTrait getCompetitor1() {
                return CompetitorFixture.newTraitInstance(1);
            }

            @Override
            public CompetitorTrait getCompetitor2() {
                return CompetitorFixture.newTraitInstance(2);
            }

            @Override
            public LocalTrait getLocal() {
                return localTrait;
            }

            @Override
            public ModalityTrait getModality() {
                return modalityTrait;
            }

            @Override
            public StepTrait getStep() {
                return StepFixture.newTraitInstance(false);
            }

            @Override
            public LocalDateTime getStartDateTime() {
                return startDateTime;
            }

            @Override
            public LocalDateTime getEndDateTime() {
                return endDateTime;
            }
        };
    }
}

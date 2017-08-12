package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.infrastructure.localization.ErrorMessages;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public interface CompetitionTrait {

    int MINIMUM_DURATION_IN_MINUTES = 30;


    Integer getId();

    @NotNull
    CompetitorTrait getCompetitor1();

    @NotNull
    CompetitorTrait getCompetitor2();

    @NotNull
    LocalTrait getLocal();

    @NotNull
    ModalityTrait getModality();

    @NotNull
    StepTrait getStep();

    @NotNull
    LocalDateTime getStartDateTime();

    @NotNull
    LocalDateTime getEndDateTime();


    interface Rules {

        static boolean hasInvalidTimeInterval(@NotNull final LocalDateTime startDateTime,
                                              @NotNull final LocalDateTime endDateTime) {
            Objects.requireNonNull(startDateTime);
            Objects.requireNonNull(endDateTime);

            return endDateTime.isBefore(startDateTime)
                || Duration.between(startDateTime, endDateTime).toMinutes() < MINIMUM_DURATION_IN_MINUTES;
        }

        class AllowedTimeIntervalViolated extends DomainException {

            public AllowedTimeIntervalViolated() {
                super(ErrorMessages.COMPETITION_INVALID_TIME_INTERVAL);
            }
        }

        static boolean hasInvalidCompetitors(@NotNull final StepTrait step,
                                             @NotNull final CompetitorTrait competitor1,
                                             @NotNull final CompetitorTrait competitor2) {
            Objects.requireNonNull(step);
            Objects.requireNonNull(competitor1);
            Objects.requireNonNull(competitor2);

            return step.acceptsSameCompetitors() ? false
                : competitor1.equals(competitor2);
        }

        class AllowedCompetitorsViolated extends DomainException {

            public AllowedCompetitorsViolated() {
                super(ErrorMessages.COMPETITION_INVALID_COMPETITORS);
            }
        }
    }
}

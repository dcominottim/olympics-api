package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.infrastructure.localization.ErrorMessages;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ScheduleTrait<TCompetitionTrait extends CompetitionTrait> {

    @NotNull
    Integer getId();

    @NotNull
    @Valid
    Set<TCompetitionTrait> getCompetitions();

    void setCompetitions(@NotNull @Valid Set<TCompetitionTrait> competitions);


    default void addCompetition(final TCompetitionTrait newCompetition) {
        final boolean hasReachedMaxCompetitionsPerDay =
            Rules.hasReachedMaxCompetitionsPerDay(
                getCompetitions().stream(),
                newCompetition
            );

        if (hasReachedMaxCompetitionsPerDay) {
            throw new Rules.MaximumCompetitionsPerDayThresholdReached();
        }

        final boolean hasViolatedCompetitionCriteria =
            Rules.hasViolatedCompetitionCriteria(
                getCompetitions().stream(),
                newCompetition
            );

        if (hasViolatedCompetitionCriteria) {
            throw new Rules.CompetitionCriteriaViolated();
        }

        final Set<TCompetitionTrait> newCompetitionCollection = new HashSet<>(getCompetitions());
        newCompetitionCollection.add(newCompetition);
        setCompetitions(newCompetitionCollection);
    }


    interface Rules {

        static boolean hasReachedMaxCompetitionsPerDay(@NotNull final Stream<? extends CompetitionTrait> competitionStream,
                                                       @NotNull final CompetitionTrait newCompetition) {
            Objects.requireNonNull(competitionStream);
            Objects.requireNonNull(newCompetition);

            return competitionStream.filter(
                    comparedCompetition -> comparedCompetition.getStartDateTime().toLocalDate().isEqual(
                        newCompetition.getStartDateTime().toLocalDate()
                    )
                ).collect(Collectors.toList()).stream()
                .filter(
                    comparedCompetition -> comparedCompetition.getLocal().equals(
                        newCompetition.getLocal()
                    )
                ).collect(Collectors.toList()).size() == 4;
        }

        class MaximumCompetitionsPerDayThresholdReached extends DomainException {

            private MaximumCompetitionsPerDayThresholdReached() {
                super(ErrorMessages.SCHEDULE_MAXIMUM_COMPETITIONS_PER_DAY_THRESHOLD_REACHED);
            }
        }

        static boolean hasViolatedCompetitionCriteria(@NotNull final Stream<? extends CompetitionTrait> competitionStream,
                                                      @NotNull final CompetitionTrait newCompetition) {
            Objects.requireNonNull(competitionStream);
            Objects.requireNonNull(newCompetition);

            return competitionStream.anyMatch(
                comparedCompetition ->
                    comparedCompetition.getLocal().equals(newCompetition.getLocal())
                        && comparedCompetition.getModality().equals(newCompetition.getModality())
                        && comparedCompetition.getStartDateTime().toLocalDate().isEqual(
                        newCompetition.getStartDateTime().toLocalDate()
                    )
                    && new LocalTimeRange(
                        newCompetition.getStartDateTime().toLocalTime(),
                        newCompetition.getEndDateTime().toLocalTime()
                    ).overlaps(
                        new LocalTimeRange(
                            comparedCompetition.getStartDateTime().toLocalTime(),
                            comparedCompetition.getEndDateTime().toLocalTime()
                        )
                    )
            );
        }

        class CompetitionCriteriaViolated extends DomainException {

            private CompetitionCriteriaViolated() {
                super(ErrorMessages.SCHEDULE_INVALID_COMPETITION_CRITERIA);
            }
        }
    }
}

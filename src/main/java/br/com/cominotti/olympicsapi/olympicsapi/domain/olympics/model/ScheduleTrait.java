package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import br.com.cominotti.olympicsapi.olympicsapi.infra.localization.ErrorMessages;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface ScheduleTrait<TCompetitionTrait extends CompetitionTrait> {

    @NotNull
    Integer getId();

    @NotNull
    @Valid
    Set<TCompetitionTrait> getCompetitions();

    void setCompetitions(@NotNull @Valid Set<TCompetitionTrait> competitions);

    default void addCompetition(final TCompetitionTrait newCompetition) {
        final boolean hasReachedMaxCompetitionsPerDay = getCompetitions().stream()
                .filter(
                        comparedCompetition -> comparedCompetition.getStartDateTime().toLocalDate().isEqual(
                                newCompetition.getStartDateTime().toLocalDate()
                        )
                ).collect(Collectors.toList()).stream()
                .filter(
                        comparedCompetition -> comparedCompetition.getLocal().equals(
                                newCompetition.getLocal()
                        )
                ).collect(Collectors.toList()).size() == 4;


        if (hasReachedMaxCompetitionsPerDay) {
            throw new DomainException(ErrorMessages.SCHEDULE_MAXIMUM_COMPETITIONS_PER_DAY_THRESHOLD_REACHED);
        }

        final boolean cannotAddCompetition = getCompetitions().stream().anyMatch(
                comparedCompetition ->
                        comparedCompetition.getLocal().equals(newCompetition.getLocal())
                                && comparedCompetition.getModality().equals(newCompetition.getModality())
                                && comparedCompetition.getStartDateTime().toLocalDate().equals(
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

        if (cannotAddCompetition) {
            throw new DomainException(ErrorMessages.SCHEDULE_INVALID_COMPETITION_CRITERIA);
        }

        final Set<TCompetitionTrait> newCompetitionCollection = new HashSet<>(getCompetitions());
        newCompetitionCollection.add(newCompetition);
        setCompetitions(newCompetitionCollection);
    }
}

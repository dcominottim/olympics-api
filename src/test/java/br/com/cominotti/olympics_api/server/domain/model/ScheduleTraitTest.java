package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.domain.model.fixtures.CompetitionFixture;
import br.com.cominotti.olympics_api.server.domain.model.fixtures.ScheduleFixture;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class ScheduleTraitTest {

    @Test
    public void canAddCompetition() throws Exception {
        final ScheduleTrait<CompetitionTrait> scheduleTrait = ScheduleFixture.newTraitInstance();

        scheduleTrait.addCompetition(
            CompetitionFixture.newTraitInstance(
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(CompetitionTrait.MINIMUM_DURATION_IN_MINUTES)
            )
        );

        Assert.assertTrue(scheduleTrait.getCompetitions().size() == 1);
    }

    @Test(expected = ScheduleTrait.Rules.MaximumCompetitionsPerDayThresholdReached.class)
    public void cannotAddCompetitionWhenMaxPerDayHasBeenExceeded() throws Exception {
        final ScheduleTrait<CompetitionTrait> scheduleTrait = ScheduleFixture.newTraitInstance();

        LocalDateTime baseDateTime = LocalDateTime.of(2017, 1, 1, 12, 0);

        for (int i = 0; i <= 4; i++) {
            final LocalDateTime endDateTime = baseDateTime.plusMinutes(CompetitionTrait.MINIMUM_DURATION_IN_MINUTES);

            scheduleTrait.addCompetition(
                CompetitionFixture.newTraitInstance(
                    baseDateTime,
                    endDateTime
                )
            );

            baseDateTime = endDateTime;
        }
    }

    @Test(expected = ScheduleTrait.Rules.CompetitionCriteriaViolated.class)
    public void cannotAddCompetitionWhenCriteriaHasBeenViolated() throws Exception {
        final ScheduleTrait<CompetitionTrait> scheduleTrait = ScheduleFixture.newTraitInstance();

        LocalDateTime baseDateTime = LocalDateTime.of(2017, 1, 1, 12, 0);

        for (int i = 0; i <= 1; i++) {
            final LocalDateTime endDateTime = baseDateTime.plusMinutes(CompetitionTrait.MINIMUM_DURATION_IN_MINUTES);

            scheduleTrait.addCompetition(
                CompetitionFixture.newTraitInstance(
                    baseDateTime,
                    endDateTime
                )
            );

            baseDateTime = endDateTime.minusMinutes(1);
        }
    }
}
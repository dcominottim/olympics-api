package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.domain.model.fixtures.CompetitorFixture;
import br.com.cominotti.olympics_api.server.domain.model.fixtures.StepFixture;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CompetitionTraitTest {

    @Test
    public void acceptsValidTimeIntervals() {
        final LocalDateTime startDateTime =
            LocalDateTime.of(2017, 1, 1, 15, 0);

        final LocalDateTime endDateTime =
            startDateTime.plusMinutes(CompetitionTrait.MINIMUM_DURATION_IN_MINUTES);

        final boolean isInvalidTimeInterval =
            CompetitionTrait.Rules.hasInvalidTimeInterval(
                startDateTime, endDateTime
            );

        Assert.assertFalse(isInvalidTimeInterval);
    }

    @Test
    public void rejectsInvalidTimeIntervals() {
        final LocalDateTime startDateTime =
            LocalDateTime.of(2017, 1, 1, 15, 0);

        final LocalDateTime endDateTime =
            startDateTime.plusMinutes(CompetitionTrait.MINIMUM_DURATION_IN_MINUTES - 1);

        final boolean isInvalidTimeInterval =
            CompetitionTrait.Rules.hasInvalidTimeInterval(
                startDateTime, endDateTime
            );

        Assert.assertTrue(isInvalidTimeInterval);
    }

    @Test
    public void acceptsValidCompetitors() {
        final boolean areInvalidCompetitors =
            CompetitionTrait.Rules.hasInvalidCompetitors(
                StepFixture.newInstance(true),
                CompetitorFixture.newCompetitor(1),
                CompetitorFixture.newCompetitor(1)
            )
            && !CompetitionTrait.Rules.hasInvalidCompetitors(
                StepFixture.newInstance(false),
                CompetitorFixture.newCompetitor(1),
                CompetitorFixture.newCompetitor(2)
            );

        Assert.assertFalse(areInvalidCompetitors);
    }

    @Test
    public void rejectsInvalidCompetitors() {
        final boolean areInvalidCompetitors =
            CompetitionTrait.Rules.hasInvalidCompetitors(
                StepFixture.newInstance(false),
                CompetitorFixture.newCompetitor(1),
                CompetitorFixture.newCompetitor(1)
            );

        Assert.assertTrue(areInvalidCompetitors);
    }
}

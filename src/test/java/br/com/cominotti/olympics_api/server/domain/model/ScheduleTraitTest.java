package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.domain.model.fixtures.CompetitionFixture;
import br.com.cominotti.olympics_api.server.domain.model.fixtures.ScheduleFixture;
import org.junit.Assert;
import org.junit.Test;

public class ScheduleTraitTest {

    @Test
    public void canAddCompetition() throws Exception {
        final ScheduleTrait<CompetitionTrait> scheduleTrait = ScheduleFixture.newScheduleTrait();

        scheduleTrait.addCompetition(CompetitionFixture.newCompetitionTrait());

        Assert.assertTrue(scheduleTrait.getCompetitions().size() == 1);
    }

    @Test(expected = DomainException.class)
    public void cannotAddCompetitionWhenMaxPerDayHasBeenExceeded() throws Exception {
        final ScheduleTrait<CompetitionTrait> scheduleTrait = ScheduleFixture.newScheduleTrait();

        for (int i = 0; i <= 4; i++) {
            scheduleTrait.addCompetition(CompetitionFixture.newCompetitionTrait());
        }
    }
}
package br.com.cominotti.olympicsapi.olympicsapi.domain.model;

import br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures.CompetitionFixture;
import br.com.cominotti.olympicsapi.olympicsapi.domain.model.fixtures.ScheduleFixture;
import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.CompetitionTrait;
import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.DomainException;
import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.ScheduleTrait;
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
package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.CompetitionTrait;
import br.com.cominotti.olympics_api.server.domain.model.Schedule;
import br.com.cominotti.olympics_api.server.domain.model.ScheduleTrait;

import java.util.HashSet;
import java.util.Set;

public class ScheduleFixture {

    public static ScheduleTrait<CompetitionTrait> newScheduleTrait() {
        return new ScheduleTrait<CompetitionTrait>() {

            Set<CompetitionTrait> competitions = new HashSet<>();

            @Override
            public Integer getId() {
                return Schedule.GLOBAL_ID;
            }

            @Override
            public Set<CompetitionTrait> getCompetitions() {
                return competitions;
            }

            @Override
            public void setCompetitions(Set<CompetitionTrait> competitions) {
                this.competitions = competitions;
            }
        };
    }
}

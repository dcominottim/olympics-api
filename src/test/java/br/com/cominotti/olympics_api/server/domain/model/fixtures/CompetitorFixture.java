package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.CompetitorTrait;

public class CompetitorFixture {

    public static CompetitorTrait newTraitInstance(final Integer id) {
        return new CompetitorTrait() {
            @Override
            public Integer getId() {
                return id;
            }

            @Override
            public String getName() {
                return "Competitor";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                CompetitorTrait that = (CompetitorTrait) o;

                if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
                return getName().equals(that.getName());
            }

            @Override
            public int hashCode() {
                int result = getId() != null ? getId().hashCode() : 0;
                result = 31 * result + getName().hashCode();
                return result;
            }
        };
    }
}

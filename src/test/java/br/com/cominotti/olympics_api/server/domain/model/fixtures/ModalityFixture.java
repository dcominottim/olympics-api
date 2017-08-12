package br.com.cominotti.olympics_api.server.domain.model.fixtures;

import br.com.cominotti.olympics_api.server.domain.model.ModalityTrait;

public class ModalityFixture {

    public static ModalityTrait newTraitInstance(final Integer id) {
        return new ModalityTrait() {
            @Override
            public Integer getId() {
                return id;
            }

            @Override
            public String getName() {
                return "Futebol";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                ModalityTrait modality = (ModalityTrait) o;

                if (getId() != null ? !getId().equals(modality.getId()) : modality.getId() != null) return false;
                return getName().equals(modality.getName());
            }

            @Override
            public int hashCode() {
                int result = getId() != null ? getName().hashCode() : 0;
                result = 31 * result + getName().hashCode();
                return result;
            }
        };
    }
}

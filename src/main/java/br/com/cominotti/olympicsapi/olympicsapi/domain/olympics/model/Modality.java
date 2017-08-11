package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "modality")
public class Modality implements ModalityTrait {

    private static final String SEQUENCE_NAME = "seq_modality";

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @SequenceGenerator(
            name = SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME,
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;


    protected Modality() {}

    public Modality(final Integer id,
                    @NotNull final String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modality modality = (Modality) o;

        if (id != null ? !id.equals(modality.id) : modality.id != null) return false;
        return name.equals(modality.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}

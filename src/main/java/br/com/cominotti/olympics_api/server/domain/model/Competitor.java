package br.com.cominotti.olympics_api.server.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "competitor")
public class Competitor implements CompetitorTrait {

    private static final String SEQUENCE_NAME = "seq_competitor";

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


    protected Competitor() {}

    public Competitor(final Integer id,
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

        Competitor that = (Competitor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}

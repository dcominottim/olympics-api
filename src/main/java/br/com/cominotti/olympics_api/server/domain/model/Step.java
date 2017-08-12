package br.com.cominotti.olympics_api.server.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "step")
public class Step implements StepTrait {

    private static final String SEQUENCE_NAME = "seq_step";

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

    @Column(name = "accepts_same_competitors", nullable = false)
    private Boolean acceptsSameCompetitors;


    protected Step() {
    }

    public Step(final Integer id,
                @NotNull final String name,
                @NotNull final Boolean acceptsSameCompetitors) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.acceptsSameCompetitors = Objects.requireNonNull(acceptsSameCompetitors);
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Boolean acceptsSameCompetitors() {
        return acceptsSameCompetitors;
    }
}

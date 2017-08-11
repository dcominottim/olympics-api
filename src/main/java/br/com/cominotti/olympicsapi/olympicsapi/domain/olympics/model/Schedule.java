package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "schedule")
public class Schedule implements ScheduleTrait<Competition> {

    public static final Integer GLOBAL_ID = 1;

    private static final String SEQUENCE_NAME = "seq_schedule";

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

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Competition> competitions = new HashSet<>();


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Set<Competition> getCompetitions() {
        return new HashSet<>(competitions);
    }

    @Override
    public void setCompetitions(Set<Competition> competitions) {
        this.competitions.clear();
        this.competitions.addAll(competitions);
    }
}

package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.infrastructure.localization.ErrorMessages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "competition")
public class Competition implements CompetitionTrait {

    private static final String SEQUENCE_NAME = "seq_competition";

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

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Competitor competitor1;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Competitor competitor2;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Local local;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Modality modality;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Step step;

    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_datetime", nullable = false)
    private LocalDateTime endDateTime;


    protected Competition() {
    }

    public Competition(final Integer id,
                       @NotNull final Competitor competitor1,
                       @NotNull final Competitor competitor2,
                       @NotNull final Local local,
                       @NotNull final Modality modality,
                       @NotNull final Step step,
                       @NotNull final LocalDateTime startDateTime,
                       @NotNull final LocalDateTime endDateTime) {
        this.id = id;
        this.competitor1 = Objects.requireNonNull(competitor1);
        this.competitor2 = Objects.requireNonNull(competitor2);
        this.local = Objects.requireNonNull(local);
        this.modality = Objects.requireNonNull(modality);
        this.step = Objects.requireNonNull(step);
        this.startDateTime = Objects.requireNonNull(startDateTime);
        this.endDateTime = Objects.requireNonNull(endDateTime);

        final boolean hasInvalidTimeInterval =
            Rules
                .hasInvalidTimeInterval(startDateTime, endDateTime);

        if (hasInvalidTimeInterval) {
            throw new DomainException(ErrorMessages.COMPETITION_INVALID_TIME_INTERVAL);
        }

        final boolean hasInvalidCompetitors =
            Rules
                .hasInvalidCompetitors(step, competitor1, competitor2);

        if (hasInvalidCompetitors) {
            throw new DomainException(ErrorMessages.COMPETITION_INVALID_COMPETITORS);
        }
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public CompetitorTrait getCompetitor1() {
        return competitor1;
    }

    @Override
    public CompetitorTrait getCompetitor2() {
        return competitor2;
    }

    @Override
    public LocalTrait getLocal() {
        return local;
    }

    @Override
    public ModalityTrait getModality() {
        return modality;
    }

    @Override
    public StepTrait getStep() {
        return step;
    }

    @Override
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    @Override
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
}

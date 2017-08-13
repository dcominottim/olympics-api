package br.com.cominotti.olympics_api.server.infrastructure.rest.views;

import br.com.cominotti.olympics_api.server.infrastructure.persistence.listeners.PreventAnyUpdateListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "competition")
@EntityListeners(PreventAnyUpdateListener.class)
public class CompetitionVo {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @NotNull
    private CompetitorVo competitor1;

    @ManyToOne
    @NotNull
    private CompetitorVo competitor2;

    @ManyToOne
    @NotNull
    private LocalVo local;

    @ManyToOne
    @NotNull
    private ModalityVo modality;

    @ManyToOne
    @NotNull
    private StepVo step;

    @Column(name = "start_datetime")
    @NotNull
    private LocalDateTime startDateTime;

    @Column(name = "end_datetime")
    @NotNull
    private LocalDateTime endDateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompetitorVo getCompetitor1() {
        return competitor1;
    }

    public void setCompetitor1(CompetitorVo competitor1) {
        this.competitor1 = competitor1;
    }

    public CompetitorVo getCompetitor2() {
        return competitor2;
    }

    public void setCompetitor2(CompetitorVo competitor2) {
        this.competitor2 = competitor2;
    }

    public LocalVo getLocal() {
        return local;
    }

    public void setLocal(LocalVo local) {
        this.local = local;
    }

    public ModalityVo getModality() {
        return modality;
    }

    public void setModality(ModalityVo modality) {
        this.modality = modality;
    }

    public StepVo getStep() {
        return step;
    }

    public void setStep(StepVo step) {
        this.step = step;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}

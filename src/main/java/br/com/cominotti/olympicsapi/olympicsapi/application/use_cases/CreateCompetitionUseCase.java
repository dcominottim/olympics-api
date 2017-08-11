package br.com.cominotti.olympicsapi.olympicsapi.application.use_cases;

import br.com.cominotti.olympicsapi.olympicsapi.application.RunnableUseCase;
import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.Competition;
import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.Schedule;
import br.com.cominotti.olympicsapi.olympicsapi.infra.persistence.*;
import br.com.cominotti.olympicsapi.olympicsapi.view.CompetitionVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class CreateCompetitionUseCase implements RunnableUseCase<CreateCompetitionUseCaseInput, CompetitionVo> {

    private ScheduleRepository scheduleRepository;

    private CompetitionRepository competitionRepository;

    private CompetitorRepository competitorRepository;

    private ModalityRepository modalityRepository;

    private LocalRepository localRepository;

    private StepRepository stepRepository;

    private CompetitionVoRepository competitionVoRepository;


    public CreateCompetitionUseCase() {}

    @Inject
    public CreateCompetitionUseCase(final ScheduleRepository scheduleRepository,
                                    final CompetitionRepository competitionRepository,
                                    final CompetitorRepository competitorRepository,
                                    final ModalityRepository modalityRepository,
                                    final LocalRepository localRepository,
                                    final StepRepository stepRepository,
                                    final CompetitionVoRepository competitionVoRepository) {
        this.scheduleRepository = Objects.requireNonNull(scheduleRepository);
        this.competitionRepository = Objects.requireNonNull(competitionRepository);
        this.competitorRepository = Objects.requireNonNull(competitorRepository);
        this.modalityRepository = Objects.requireNonNull(modalityRepository);
        this.localRepository = Objects.requireNonNull(localRepository);
        this.stepRepository = Objects.requireNonNull(stepRepository);
        this.competitionVoRepository = Objects.requireNonNull(competitionVoRepository);
    }


    @Override
    public CompetitionVo run(final CreateCompetitionUseCaseInput input) {
        final Competition newCompetition = new Competition(
            null,
            competitorRepository.findBy(input.getCompetitor1().getId()),
            competitorRepository.findBy(input.getCompetitor2().getId()),
            localRepository.findBy(input.getLocal().getId()),
            modalityRepository.findBy(input.getModality().getId()),
            stepRepository.findBy(input.getStep().getId()),
            input.getStartDateTime(),
            input.getEndDateTime()
        );

        final Schedule globalSchedule = scheduleRepository.findBy(Schedule.GLOBAL_ID);

        competitionRepository.saveAndFlush(newCompetition);
        globalSchedule.addCompetition(newCompetition);

        return competitionVoRepository.findBy(newCompetition.getId());
    }
}

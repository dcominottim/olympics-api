package br.com.cominotti.olympics_api.server.application;

import br.com.cominotti.olympics_api.server.application.use_cases.*;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OlympicsUseCaseRegistry implements UseCaseRegistry {

    @Inject
    private ListCompetitorsUseCase listCompetitorsUseCase;

    @Inject
    private ListCompetitionsUseCase listCompetitionsUseCase;

    @Inject
    private CreateCompetitionUseCase createCompetitionUseCase;

    @Inject
    private ListStepsUseCase listStepsUseCase;

    @Inject
    private ListModalitiesUseCase listModalitiesUseCase;

    @Inject
    private ListLocalsUseCase listLocalsUseCase;


    @Override
    public List<CompetitorVo> run(ListCompetitorsUseCaseInput input) {
        return listCompetitorsUseCase.run(input);
    }

    @Override
    public List<CompetitionVo> run(ListCompetitionsUseCaseInput input) {
        return listCompetitionsUseCase.run(input);
    }

    @Override
    public CompetitionVo run(CreateCompetitionUseCaseInput input) {
        return createCompetitionUseCase.run(input);
    }

    @Override
    public List<ModalityVo> run(ListModalitiesUseCaseInput input) {
        return listModalitiesUseCase.run(input);
    }

    @Override
    public List<StepVo> run(ListStepsUseCaseInput input) {
        return listStepsUseCase.run(input);
    }

    @Override
    public List<LocalVo> run(ListLocalsUseCaseInput input) {
        return listLocalsUseCase.run(input);
    }
}

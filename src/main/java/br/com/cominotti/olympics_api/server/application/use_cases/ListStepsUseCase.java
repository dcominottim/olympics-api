package br.com.cominotti.olympics_api.server.application.use_cases;

import br.com.cominotti.olympics_api.server.application.RunnableUseCase;
import br.com.cominotti.olympics_api.server.infrastructure.persistence.StepVoRepository;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.StepVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ListStepsUseCase implements RunnableUseCase<ListStepsUseCaseInput, List<StepVo>> {

    private StepVoRepository stepVoRepository;


    public ListStepsUseCase() {
    }

    @Inject
    public ListStepsUseCase(final StepVoRepository stepVoRepository) {
        this.stepVoRepository = Objects.requireNonNull(stepVoRepository);
    }


    @Override
    public List<StepVo> run(final ListStepsUseCaseInput listStepsUseCaseInput) {
        return stepVoRepository.findAll();
    }
}

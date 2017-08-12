package br.com.cominotti.olympics_api.server.application.use_cases;

import br.com.cominotti.olympics_api.server.application.RunnableUseCase;
import br.com.cominotti.olympics_api.server.infrastructure.persistence.ModalityVoRepository;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.ModalityVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ListModalitiesUseCase implements RunnableUseCase<ListModalitiesUseCaseInput, List<ModalityVo>> {

    private ModalityVoRepository modalityVoRepository;


    public ListModalitiesUseCase() {}

    @Inject
    public ListModalitiesUseCase(final ModalityVoRepository modalityVoRepository) {
        this.modalityVoRepository = Objects.requireNonNull(modalityVoRepository);
    }

    @Override
    public List<ModalityVo> run(final ListModalitiesUseCaseInput listModalitiesUseCaseInput) {
        return modalityVoRepository.findAll();
    }
}

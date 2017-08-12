package br.com.cominotti.olympics_api.server.application.use_cases;

import br.com.cominotti.olympics_api.server.application.RunnableUseCase;
import br.com.cominotti.olympics_api.server.infrastructure.persistence.LocalVoRepository;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.LocalVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ListLocalsUseCase implements RunnableUseCase<ListLocalsUseCaseInput, List<LocalVo>> {

    private LocalVoRepository localVoRepository;


    public ListLocalsUseCase() {
    }

    @Inject
    public ListLocalsUseCase(final LocalVoRepository localVoRepository) {
        this.localVoRepository = Objects.requireNonNull(localVoRepository);
    }


    @Override
    public List<LocalVo> run(final ListLocalsUseCaseInput listLocalsUseCaseInput) {
        return localVoRepository.findAll();
    }
}

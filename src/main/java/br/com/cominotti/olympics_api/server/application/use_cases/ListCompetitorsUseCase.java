package br.com.cominotti.olympics_api.server.application.use_cases;

import br.com.cominotti.olympics_api.server.application.RunnableUseCase;
import br.com.cominotti.olympics_api.server.infrastructure.persistence.repositories.CompetitorVoRepository;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.CompetitorVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ListCompetitorsUseCase implements RunnableUseCase<ListCompetitorsUseCaseInput, List<CompetitorVo>> {

    private CompetitorVoRepository competitorVoRepository;


    public ListCompetitorsUseCase() {
    }

    @Inject
    public ListCompetitorsUseCase(final CompetitorVoRepository competitorVoRepository) {
        this.competitorVoRepository = Objects.requireNonNull(competitorVoRepository);
    }


    @Override
    public List<CompetitorVo> run(final ListCompetitorsUseCaseInput input) {
        return competitorVoRepository.findAll();
    }
}

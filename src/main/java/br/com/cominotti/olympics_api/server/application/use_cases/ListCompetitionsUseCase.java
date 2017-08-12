package br.com.cominotti.olympics_api.server.application.use_cases;

import br.com.cominotti.olympics_api.server.application.RunnableUseCase;
import br.com.cominotti.olympics_api.server.infrastructure.persistence.CompetitionVoRepository;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.CompetitionVo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ListCompetitionsUseCase implements RunnableUseCase<ListCompetitionsUseCaseInput, List<CompetitionVo>> {

    private CompetitionVoRepository competitionVoRepository;


    public ListCompetitionsUseCase() {
    }

    @Inject
    public ListCompetitionsUseCase(final CompetitionVoRepository competitionVoRepository) {
        this.competitionVoRepository = Objects.requireNonNull(competitionVoRepository);
    }


    @Override
    public List<CompetitionVo> run(final ListCompetitionsUseCaseInput input) {
        return (input.getModalityId() == null)
            ? competitionVoRepository.findAllOrderByStartDateTimeAsc()
            : competitionVoRepository.findByModality_idOrderByStartDateTimeAsc(input.getModalityId());
    }
}

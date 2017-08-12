package br.com.cominotti.olympics_api.server.application;

import br.com.cominotti.olympics_api.server.application.use_cases.*;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface UseCaseRegistry {

    @NotNull
    @Valid
    List<CompetitorVo> run(@NotNull @Valid ListCompetitorsUseCaseInput input);

    @NotNull
    @Valid
    List<CompetitionVo> run(@NotNull @Valid ListCompetitionsUseCaseInput input);

    @NotNull
    @Valid
    CompetitionVo run(@NotNull @Valid CreateCompetitionUseCaseInput input);

    @NotNull
    @Valid
    List<ModalityVo> run(@NotNull @Valid ListModalitiesUseCaseInput input);

    @NotNull
    @Valid
    List<StepVo> run(@NotNull @Valid ListStepsUseCaseInput input);

    @NotNull
    @Valid
    List<LocalVo> run(@NotNull @Valid ListLocalsUseCaseInput input);
}

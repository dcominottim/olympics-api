package br.com.cominotti.olympicsapi.olympicsapi.application;

import br.com.cominotti.olympicsapi.olympicsapi.application.use_cases.*;
import br.com.cominotti.olympicsapi.olympicsapi.view.*;

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

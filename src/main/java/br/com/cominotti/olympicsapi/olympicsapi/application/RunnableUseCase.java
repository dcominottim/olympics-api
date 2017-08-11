package br.com.cominotti.olympicsapi.olympicsapi.application;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunnableUseCase<Input, Output> {

    @NotNull
    @Valid
    Output run(@NotNull @Valid Input input);
}

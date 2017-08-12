package br.com.cominotti.olympics_api.server.infrastructure.rest.endpoints;

import br.com.cominotti.olympics_api.server.application.UseCaseRegistry;
import br.com.cominotti.olympics_api.server.application.use_cases.CreateCompetitionUseCaseInput;
import br.com.cominotti.olympics_api.server.application.use_cases.ListCompetitionsUseCaseInput;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
@Path("competitions")
public class CompetitionsEndpoint {

    private UseCaseRegistry useCaseRegistry;


    public CompetitionsEndpoint() {
    }

    @Inject
    public CompetitionsEndpoint(final UseCaseRegistry useCaseRegistry) {
        this.useCaseRegistry = Objects.requireNonNull(useCaseRegistry);
    }


    @GET
    @Produces("application/json;charset=UTF-8")
    public void getCompetitions(@Valid @BeanParam final ListCompetitionsUseCaseInput input,
                                @Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(input)
            ).build()
        );
    }

    @POST
    @Consumes("application/json;charset=UTF-8")
    @Produces("application/json;charset=UTF-8")
    public void createCompetition(@Valid final CreateCompetitionUseCaseInput input,
                                  @Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(input)
            ).build()
        );
    }
}

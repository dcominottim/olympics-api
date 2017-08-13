package br.com.cominotti.olympics_api.server.infrastructure.rest.endpoints;

import br.com.cominotti.olympics_api.server.application.UseCaseRegistry;
import br.com.cominotti.olympics_api.server.application.use_cases.CreateCompetitionUseCaseInput;
import br.com.cominotti.olympics_api.server.application.use_cases.ListCompetitionsUseCaseInput;
import br.com.cominotti.olympics_api.server.infrastructure.rest.CustomMediaType;

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
    @Produces(CustomMediaType.APPLICATION_JSON_UTF8)
    public void getCompetitions(@Valid @BeanParam final ListCompetitionsUseCaseInput input,
                                @Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(input)
            ).build()
        );
    }

    @POST
    @Consumes(CustomMediaType.APPLICATION_JSON_UTF8)
    @Produces(CustomMediaType.APPLICATION_JSON_UTF8)
    public void createCompetition(@Valid final CreateCompetitionUseCaseInput input,
                                  @Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(input)
            ).build()
        );
    }
}

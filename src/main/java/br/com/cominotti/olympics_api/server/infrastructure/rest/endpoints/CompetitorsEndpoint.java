package br.com.cominotti.olympics_api.server.infrastructure.rest.endpoints;

import br.com.cominotti.olympics_api.server.application.UseCaseRegistry;
import br.com.cominotti.olympics_api.server.application.use_cases.ListCompetitorsUseCaseInput;
import br.com.cominotti.olympics_api.server.infrastructure.rest.CustomMediaType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
@Path("competitors")
public class CompetitorsEndpoint {

    private UseCaseRegistry useCaseRegistry;


    public CompetitorsEndpoint() {
    }

    @Inject
    public CompetitorsEndpoint(final UseCaseRegistry useCaseRegistry) {
        this.useCaseRegistry = Objects.requireNonNull(useCaseRegistry);
    }


    @GET
    @Produces(CustomMediaType.APPLICATION_JSON_UTF8)
    public void getCompetitors(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(new ListCompetitorsUseCaseInput())
            ).build()
        );
    }
}

package br.com.cominotti.olympics_api.server.infrastructure.rest.endpoints;

import br.com.cominotti.olympics_api.server.application.UseCaseRegistry;
import br.com.cominotti.olympics_api.server.application.use_cases.ListModalitiesUseCaseInput;

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
@Path("modalities")
public class ModalitiesEndpoint {

    private UseCaseRegistry useCaseRegistry;


    public ModalitiesEndpoint() {
    }

    @Inject
    public ModalitiesEndpoint(final UseCaseRegistry useCaseRegistry) {
        this.useCaseRegistry = Objects.requireNonNull(useCaseRegistry);
    }


    @GET
    @Produces("application/json;charset=UTF-8")
    public void getModalities(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
            Response.ok(
                useCaseRegistry.run(new ListModalitiesUseCaseInput())
            ).build()
        );
    }
}

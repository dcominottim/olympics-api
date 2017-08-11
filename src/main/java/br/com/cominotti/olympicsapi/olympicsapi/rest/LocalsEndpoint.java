package br.com.cominotti.olympicsapi.olympicsapi.rest;

import br.com.cominotti.olympicsapi.olympicsapi.application.UseCaseRegistry;
import br.com.cominotti.olympicsapi.olympicsapi.application.use_cases.ListLocalsUseCaseInput;

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
@Path("locals")
public class LocalsEndpoint {

    private UseCaseRegistry useCaseRegistry;


    public LocalsEndpoint() {}

    @Inject
    public LocalsEndpoint(final UseCaseRegistry useCaseRegistry) {
        this.useCaseRegistry = Objects.requireNonNull(useCaseRegistry);
    }


    @GET
    @Produces("application/json;charset=UTF-8")
    public void getLocals(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.resume(
                Response.ok(
                        useCaseRegistry.run(new ListLocalsUseCaseInput())
                ).build()
        );
    }
}

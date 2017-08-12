package br.com.cominotti.olympics_api.server.infrastructure.configuration.mappers;

import br.com.cominotti.olympics_api.server.domain.model.DomainException;
import br.com.cominotti.olympics_api.server.infrastructure.localization.ResourceBundles;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.ErrorVo;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ResourceBundle;

@Provider
public class DomainExceptionMapper implements ExceptionMapper<DomainException> {

    @Context
    private HttpServletRequest request;


    @Override
    public Response toResponse(final DomainException exception) {
        final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(
                ResourceBundles.ERRORS.toString(),
                request.getLocale()
            );

        return Response.status(Response.Status.BAD_REQUEST)
            .entity(
                new ErrorVo(
                    resourceBundle.getString(
                        exception.getErrorMessageKey()
                    )
                )
            )
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}

package br.com.cominotti.olympics_api.server.infrastructure.configuration.mappers;

import br.com.cominotti.olympics_api.server.infrastructure.localization.ErrorMessages;
import br.com.cominotti.olympics_api.server.infrastructure.localization.ResourceBundles;
import br.com.cominotti.olympics_api.server.infrastructure.rest.views.ErrorVo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ResourceBundle;

@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Context
    private HttpServletRequest request;


    @Override
    public Response toResponse(final ValidationException exception) {
        final ResourceBundle resourceBundle =
                ResourceBundle.getBundle(
                        ResourceBundles.ERRORS.toString(), request.getLocale()
                );

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(
                        new ErrorVo(
                                resourceBundle.getString(
                                        ErrorMessages.GENERIC_BAD_DATA.toString()
                                )
                        )
                )
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

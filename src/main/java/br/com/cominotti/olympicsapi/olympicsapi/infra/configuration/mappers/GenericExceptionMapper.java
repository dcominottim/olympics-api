package br.com.cominotti.olympicsapi.olympicsapi.infra.configuration.mappers;

import br.com.cominotti.olympicsapi.olympicsapi.infra.localization.ErrorMessages;
import br.com.cominotti.olympicsapi.olympicsapi.infra.localization.ResourceBundles;
import br.com.cominotti.olympicsapi.olympicsapi.view.ErrorVo;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ResourceBundle;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Context
    private HttpServletRequest request;


    @Override
    public Response toResponse(final Exception exception) {
        final ResourceBundle resourceBundle =
                ResourceBundle.getBundle(
                        ResourceBundles.ERRORS.toString(), request.getLocale()
                );

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(
                        new ErrorVo(
                                resourceBundle.getString(
                                        ErrorMessages.GENERIC_INTERNAL_SERVER_ERROR.toString()
                                )
                        )
                )
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

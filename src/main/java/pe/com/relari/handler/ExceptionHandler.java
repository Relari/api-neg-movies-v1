package pe.com.relari.handler;

import pe.com.relari.config.ErrorProperties;
import pe.com.relari.model.common.DefaultResponse;
import pe.com.relari.model.common.ErrorResponse;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<ApiException> {

    private static final Logger log = Logger.getLogger(ExceptionHandler.class);

    ErrorProperties errorProperties;

    @Inject
    public ExceptionHandler(ErrorProperties errorProperties) {
        this.errorProperties = errorProperties;
    }

    @Override
    public Response toResponse(ApiException exception) {

        var errorResponse = new ErrorResponse(errorProperties.defaultMessage(), exception.getMessage());

        DefaultResponse<ErrorResponse> response = DefaultResponse.errorResponse(errorResponse);
        log.error(exception.getMessage());

        return Response.status(response.getStatus().getStatus())
                .entity(response)
                .header("Content-Type", "application/json")
                .build();
    }

}

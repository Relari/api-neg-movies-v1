package pe.com.relari.handler;

import pe.com.relari.config.ErrorProperties;
import pe.com.relari.model.common.ApiResponse;
import pe.com.relari.model.common.ErrorResponse;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pe.com.relari.model.common.ErrorType;
import pe.com.relari.model.common.StatusType;

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
        return ApiResponse.errorResponse(exception.errorType, exception.getMessage());
    }

}

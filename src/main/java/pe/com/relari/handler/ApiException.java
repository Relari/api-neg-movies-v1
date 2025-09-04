package pe.com.relari.handler;

import pe.com.relari.model.common.ErrorType;

public class ApiException extends RuntimeException {

    ErrorType errorType;

    public ApiException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ApiException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

}

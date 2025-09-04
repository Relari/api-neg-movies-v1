package pe.com.relari.model.common;

import jakarta.ws.rs.core.Response;
import lombok.Data;

@Data
public class ApiResponse<T> {

    private StatusType status;
    private int statusCode;
    private T data;

    private ApiResponse(StatusType status, int statusCode, T data) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static Response okResponse(Object data) {
        return Response.ok(new ApiResponse<>(StatusType.OK, 200, data)).build();
    }

    public static Response errorResponse(ErrorType errorType, String message) {
        ErrorResponse errorResponse = new ErrorResponse(errorType, message);
        return Response.status(errorType.getStatus())
                .entity(new ApiResponse<>(StatusType.ERROR, errorType.getStatus(), errorResponse)).build();
    }

}

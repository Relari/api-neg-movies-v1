package pe.com.relari.model.common;

import lombok.Data;

@Data
public class DefaultResponse<T> {

    private StatusType status;
    private int statusCode;
    private T data;

    private DefaultResponse(StatusType status, T data) {
        this.status = status;
        this.statusCode = status.getStatus();
        this.data = data;
    }

    public static DefaultResponse<Object> okResponse(Object data) {
        return new DefaultResponse<>(StatusType.OK, data);
    }

    public static DefaultResponse<ErrorResponse> errorResponse(ErrorResponse error) {
        return new DefaultResponse<>(StatusType.ERROR, error);
    }

}

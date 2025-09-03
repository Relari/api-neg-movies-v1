package pe.com.relari.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

public record ErrorResponse(
        @JsonProperty("error-code")
        String errorCode,
        @JsonProperty("error-message")
        String errorMessage) {
}

package pe.com.relari.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusType {
    OK(200), ERROR(500);

    private final int status;

}

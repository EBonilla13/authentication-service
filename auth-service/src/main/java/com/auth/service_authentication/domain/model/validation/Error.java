package com.auth.service_authentication.domain.model.validation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class Error {

    private final String field;
    private final String value;
    private final String message;

    public Error(String field, String value, String message) {
        this.field = field;
        this.value = value;
        this.message = message;
    }
    public Error(String field, String message){
        this(field, null, message);
    }
}

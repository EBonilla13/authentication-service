package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class TokenHash {
    private final String value;

    private TokenHash(String value){
        this.value = value;
    }

    public static TokenHash validate(String value, String field, Notification notification){
        if (value == null){
            notification.addError(new Error(field, field + " cannot be null"));
            return null;
        }else if (value.trim().isEmpty()){
            notification.addError(new Error(field, field + " cannot be empty"));
            return null;
        }
        return new TokenHash(value);
    }
}

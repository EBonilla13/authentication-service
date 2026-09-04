package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public final class ForeignKeyUUID {

    private final UUID value;

    private ForeignKeyUUID(UUID value){
        this.value = value;
    }

    public static ForeignKeyUUID validate(UUID value, String field, Notification notification){
        if (value == null){
            notification.addError(new Error(field, field + " must not be null"));
            return null;
        }
        return new ForeignKeyUUID(value);
    }
}

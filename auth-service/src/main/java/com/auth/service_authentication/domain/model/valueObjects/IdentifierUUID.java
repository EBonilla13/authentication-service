package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
import java.util.regex.Pattern;

@Getter
@ToString
@EqualsAndHashCode
public final class IdentifierUUID {

    private final UUID id;

    private IdentifierUUID(UUID id){
        this.id = id;
    }

    public static IdentifierUUID validate(UUID id){
        if (id == null)
            return new IdentifierUUID(UUID.randomUUID());

        return new IdentifierUUID(id);
    }

}

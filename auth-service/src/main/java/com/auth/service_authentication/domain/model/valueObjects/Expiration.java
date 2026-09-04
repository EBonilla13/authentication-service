package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@EqualsAndHashCode
public final class Expiration {

    private final Instant value;
    private static final Long EXPIRES_TIME = 1000L * 60L * 60L * 24L * 15L; // 15 days

    private Expiration(Instant value){
        this.value = value;
    }

    public static Expiration validate(Instant value){
        if ( value == null ){
            return new Expiration(Instant.now().plusMillis(EXPIRES_TIME));
        }
        return new Expiration(value);
    }
}

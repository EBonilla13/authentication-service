package com.auth.service_authentication.domain.model;

import com.auth.service_authentication.domain.model.validation.Notification;
import com.auth.service_authentication.domain.model.valueObjects.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public final class RefreshTokenModel {

    private final UUID id;
    private final UUID userId;
    private final String tokenHash;
    private final Instant expirationDate;
    private final Boolean isRevoked;

    private RefreshTokenModel(UUID id, UUID userId, String tokenHash, Instant expirationDate, Boolean isRevoked){
        this.id = id;
        this.userId = userId;
        this.tokenHash = tokenHash;
        this.expirationDate = expirationDate;
        this.isRevoked = isRevoked;
    }

    public static RefreshTokenModel restore(UUID id, UUID userId, String tokenHash,
                                            Instant expirationDate, Boolean isRevoked){
        return new RefreshTokenModel(id, userId, tokenHash, expirationDate, isRevoked);
    }

    public static RefreshTokenModel create(UUID id, UUID userId, String token, Instant expirationDate,
                                           Boolean isRevoked, Notification notification){
            UUID validId = IdentifierUUID.validate(id).getId();
            UUID validUserId = ForeignKeyUUID.validate(userId, "User Id", notification).getValue();
            String validToken = TokenHash.validate(token, "Token", notification).getValue();
            Instant validExpiration = Expiration.validate(expirationDate).getValue();
            Boolean validIsRevoked = AttributeBoolean.validate(isRevoked, "Is revoked", notification).getValue();

            if (notification.hasErrors())
                return null;

            return new RefreshTokenModel(validId, validUserId, validToken, validExpiration, validIsRevoked);
    }

    public static Boolean hasExpired(Instant date){
        return Instant.now().isBefore(date);
    }
}

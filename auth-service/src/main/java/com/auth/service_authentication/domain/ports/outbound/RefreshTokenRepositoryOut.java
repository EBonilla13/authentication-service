package com.auth.service_authentication.domain.ports.outbound;

import com.auth.service_authentication.domain.model.RefreshTokenModel;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepositoryOut {

    RefreshTokenModel save(RefreshTokenModel refreshToken);
    Optional<RefreshTokenModel> findByUserId(UUID userId);

}

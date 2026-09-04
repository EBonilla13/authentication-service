package com.auth.service_authentication.domain.ports.outbound;

import com.auth.service_authentication.domain.model.UserDetailsModel;

import java.util.Optional;
import java.util.UUID;

public interface UserDetailsRepositoryOut {

    UserDetailsModel save(UserDetailsModel userDetails);
    Optional<UserDetailsModel> findById(UUID userId);
    Optional<UserDetailsModel> findByName(String name);

}

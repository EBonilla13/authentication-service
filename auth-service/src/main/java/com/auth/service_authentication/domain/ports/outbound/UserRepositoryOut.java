package com.auth.service_authentication.domain.ports.outbound;

import com.auth.service_authentication.application.dtos.request.UserRequestDto;
import com.auth.service_authentication.application.dtos.response.UserResponseDto;
import com.auth.service_authentication.domain.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryOut {

    UserModel save(UserModel user);
    Optional<UserModel> findById(UUID id);
    List<UserModel> usersActive();
    List<UserModel> allUsers();
    void softDelete();
}

package com.auth.service_authentication.domain.ports.outbound;

import com.auth.service_authentication.domain.model.RolModel;

import java.util.List;
import java.util.Optional;

public interface RolRepositoryOut {

    RolModel save(RolModel rol);
    Optional<RolModel> findByName(String name);
    List<RolModel> roles();

}

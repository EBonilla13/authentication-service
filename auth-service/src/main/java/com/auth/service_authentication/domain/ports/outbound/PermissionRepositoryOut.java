package com.auth.service_authentication.domain.ports.outbound;

import com.auth.service_authentication.domain.model.PermissionModel;

import java.util.List;
import java.util.Optional;

public interface PermissionRepositoryOut {

    PermissionModel save(PermissionModel permission);
    Optional<PermissionModel> findByName(String name);
    List<PermissionModel> permissions();

}

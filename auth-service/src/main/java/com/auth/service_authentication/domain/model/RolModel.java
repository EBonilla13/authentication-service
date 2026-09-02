package com.auth.service_authentication.domain.model;

import com.auth.service_authentication.domain.model.validation.Notification;
import com.auth.service_authentication.domain.model.valueObjects.Identifier;
import com.auth.service_authentication.domain.model.valueObjects.Text;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public final class RolModel {

    private final Integer id;
    private final String name;
    private final Set<PermissionModel> permissions;

    private RolModel(Integer id, String name, Set<PermissionModel> permissions){
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }
    private RolModel(Integer id, String name){
        this(id, name, null);
    }

    // Validate a new rol or a update.
    public static RolModel validate(Integer id, String name, Notification notification){
        Integer validId = Identifier.validate(id, notification).getId();
        String validName = Text.validate(name, "Rol name", 75, notification).getValue();

        if (notification.hasErrors())
            return null;

        return new RolModel(validId, validName);
    }

    // Restore a rol from database
    public static RolModel restore(Integer id, String name, Set<PermissionModel> permissions){
        return new RolModel(id, name, permissions);
    }
}

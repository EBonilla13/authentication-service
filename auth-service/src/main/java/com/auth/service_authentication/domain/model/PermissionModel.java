package com.auth.service_authentication.domain.model;

import com.auth.service_authentication.domain.model.validation.Notification;
import com.auth.service_authentication.domain.model.valueObjects.Identifier;
import com.auth.service_authentication.domain.model.valueObjects.Text;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class PermissionModel {

    private final Integer id;
    private final String name;

    private PermissionModel(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public static PermissionModel validate(Integer id, String name, Notification notification){
        Integer validId = Identifier.validate(id, notification).getId();
        String validName = Text.validate(name, "Permission name", 125, notification).getValue();

        if (notification.hasErrors())
            return null;

        return new PermissionModel(validId, validName);
    }
}

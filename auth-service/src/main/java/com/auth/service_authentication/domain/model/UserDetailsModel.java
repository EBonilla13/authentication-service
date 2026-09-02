package com.auth.service_authentication.domain.model;

import com.auth.service_authentication.domain.model.validation.Notification;
import com.auth.service_authentication.domain.model.valueObjects.Age;
import com.auth.service_authentication.domain.model.valueObjects.AttributeBoolean;
import com.auth.service_authentication.domain.model.valueObjects.ForeignKeyUUID;
import com.auth.service_authentication.domain.model.valueObjects.Text;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public final class UserDetailsModel {

    private final UUID userId;
    private final String userName;
    private final String lastName;
    private final Short age;
    private final Boolean isActive;

    private UserDetailsModel(UUID userId, String userName, String lastName,
                             Short age, Boolean isActive){
        this.userId = userId;
        this.userName = userName;
        this.lastName = lastName;
        this.age = age;
        this.isActive = isActive;
    }

    public static UserDetailsModel restore(UUID userId, String userName, String lastName,
                                           Short age, Boolean isActive){
        return new UserDetailsModel(userId, userName, lastName, age, isActive);
    }

    public static UserDetailsModel create(UUID userId, String userName, String lastName, Short age,
                                          Boolean isActive, Notification notification){
            Short minAge = 21, maxAge = 60;

            UUID validUserId = ForeignKeyUUID.validate(userId, "User ID", notification).getValue();
            String validUserName = Text.validate(userName, "User name", 200, notification).getValue();
            String valisLastName = Text.validate(lastName, "Last name", 200, notification).getValue();
            Short validAge = Age.create(age, "Age user", minAge, maxAge, notification).getValue();
            Boolean validActive = AttributeBoolean.validate(isActive, "User details is active", notification).getValue();

            if (notification.hasErrors())
                return null;

            return new UserDetailsModel(validUserId, validUserName, valisLastName, validAge, validActive);
    }
}

package com.auth.service_authentication.domain.model;

import com.auth.service_authentication.domain.model.validation.Notification;
import com.auth.service_authentication.domain.model.valueObjects.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public final class UserModel {

    private final UUID id;
    private final String email;
    private final String username;
    private final String password;
    private final Boolean isActive;
    private final Set<RolModel> roles;


    // Private constructor
    private UserModel(UUID id, String email, String username, String password, Boolean isActive, Set<RolModel> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }
    private UserModel(UUID id, String email, String username, String password){
        this(id, email, username, password, true, null);
    }

    // Restore from database
    public static UserModel restore(UUID id, String email, String username, String password,
                                    Boolean isActive, Set<RolModel> roles){
        return new UserModel(id, email, username, password, isActive, roles);
    }

    // Validate each attribute of a new user or an update
    public static UserModel create(UUID id, String email, String username, String password, Notification notification){
        UUID validId = IdentifierUUID.validate(id).getId();
        String validEmail = Email.validate(email, notification).getEmail();
        String validUsername = Username.validate(username, notification).getUsername();
        String validPass = Password.validate(password, notification).getValue();

        if (notification.hasErrors())
            return null;

        return new UserModel(validId, validEmail, validUsername, validPass);
    }

    // It only validates the new password before updating it
    public static String validPassword(String value, Notification notification){
        String valid = Password.validate(value, notification).getValue();

        if (notification.hasErrors())
            return null;

        return valid;
    }

    // It only validates the new username before updating it
    public static String validUsername(String value, Notification notification){
        String validUsername = Username.validate(value, notification).getUsername();

        if (validUsername == null && notification.hasErrors())
            return null;

        return validUsername;
    }

    // This method only validates the new email
    public static String validEmail(String value, Notification notification){
        String validEmail = Email.validate(value, notification).getEmail();

        if (validEmail == null && notification.hasErrors())
            return null;

        return validEmail;
    }
}

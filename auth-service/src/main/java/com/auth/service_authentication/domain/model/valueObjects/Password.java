package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

@Getter
@ToString
@EqualsAndHashCode
public final class Password {

    private final String value;
    private static final Integer MAX_LENGTH_PASSWORD = 255;
    private static final String PASSWORD = "Password";
    private static final String REGEX_VALID_PASSWORD = "^(?=.*[0-9])(?=.*[_@-])[a-zA-Z0-9_@-]{8,}$";

    // Private construct
    private Password(String value){
        this.value = value;
    }

    // Validates whether a string has a valid password format
    private static boolean isValidPassword(String text){
        return Pattern.matches(REGEX_VALID_PASSWORD, text);
    }

    public static Password validate(String value, Notification notification){
        // Validate that the text is neither null nor empty
        if (value == null || value.trim().isEmpty()){
            notification.addError(new Error(PASSWORD, PASSWORD + " field must be required"));
            return null;
        }
        // Validate the maximum length
        if (value.length() > MAX_LENGTH_PASSWORD){
            notification.addError(new Error(PASSWORD, PASSWORD + " field excceds the allowed size"));
            return null;

            // Validate the password format
        }else if (!isValidPassword(value)){
            notification.addError(new Error(PASSWORD, PASSWORD + " field is invalid)"));
            return null;
        }
        return new Password(value);
    }
}

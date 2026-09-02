package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;

import java.util.regex.Pattern;

public final class Email {

    private final String email;
    private static final Integer MAX_LENGTH_EMAIL = 255;
    private static final String EMAIL = "Email";
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9-._]+@[a-zA-Z0-9]+(?:\\.[a-zA-Z]+)+$";

    private Email(String email){
        this.email = email;
    }

    public static Email validate(String email, Notification notification){
        if (email == null){
            notification.addError(new Error(EMAIL, null, "The field is required"));
            return null;
        }else if (email.length() > MAX_LENGTH_EMAIL){
            notification.addError(new Error(EMAIL, email, "The email exceeds the allowed size"));
            return null;
        }else if (!Pattern.matches(REGEX_EMAIL, email)){
            notification.addError(new Error(EMAIL, email, "Format is invalid"));
            return null;
        }
        return new Email(email);
    }

    public String getEmail(){
        return this.email;
    }
}

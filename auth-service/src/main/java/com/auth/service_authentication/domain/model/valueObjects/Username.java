package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;

import java.util.regex.Pattern;

public final class Username {

    private final String name;
    private static final Integer MAX_LENGTH_USERNAME = 150;
    private static final String USERNAME = "Username";
    private static final String REGEX_USERNAME = "^[a-zA-Z0-9_@-]+$";

    // Private construct
    private Username(String name){
        this.name = name;
    }

    public static Username validate(String name, Notification notification){
        if (name == null){
            notification.addError(new Error(USERNAME, null, "The " + USERNAME + " field is required"));
            return null;
        }else if (name.length() > MAX_LENGTH_USERNAME){
            notification.addError(new Error(USERNAME, name, "The " + USERNAME + " field exceeds the allowed size"));
            return null;
        }else if (!Pattern.matches(REGEX_USERNAME, name)){
            notification.addError(new Error(USERNAME, name, "The " + USERNAME + " field contains invalid characters"));
            return null;
        }
        return new Username(name);
    }

    public String getUsername(){
        return this.name;
    }
}

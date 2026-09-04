package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;

public final class Text {

    private final String value;

    private Text(String value){
        this.value = value;
    }

    public static Text validate(String value, String parameter, Integer maxLength, Notification notification){
        if (value == null || value.trim().isEmpty()){
            notification.addError(new Error(parameter, value, parameter + " cannot be null or empty"));
            return null;
        } else if (value.length() > maxLength) {
            notification.addError(new Error(parameter, parameter + " exceeds the allowed size"));
            return null;
        }
        return new Text(value);
    }

    public String getValue(){
        return this.value;
    }
}

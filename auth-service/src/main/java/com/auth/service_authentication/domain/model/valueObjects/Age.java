package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class Age {

    private final Short value;
    private static final Short MIN_AGE_DEF = 18;
    private static final Short MAX_AGE_DEF = 120;

    private Age(Short value){
        this.value = value;
    }

    public static Age create(Short value, String field, Short minAge, Short maxAge, Notification notification){
        return validate(value, field, minAge, maxAge, notification);
    }

    public static Age create(Short value, String field, Notification notification){
        return validate(value, field, MIN_AGE_DEF, MAX_AGE_DEF, notification);
    }

    private static Age validate(Short value, String field, Short minAge, Short maxAge, Notification notification){
        if (value == null){
            notification.addError(new Error(field, field + " must not be null"));
            return null;
        } else if (value < minAge) {
            notification.addError(new Error(field, Short.toString(value), "The " + field + " cannot be less than " + minAge + " years"));
            return null;
        }else if (value > maxAge){
            notification.addError(new Error(field, Short.toString(value), "The " + field + " cannot be greater than " + maxAge + " years"));
            return null;
        }
        return new Age(value);
    }
}

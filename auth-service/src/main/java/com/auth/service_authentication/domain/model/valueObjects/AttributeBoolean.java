package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class AttributeBoolean {

    private final Boolean value;

    private AttributeBoolean( Boolean value){
        this.value = value;
    }

    public static AttributeBoolean validate(Boolean value, String field, Notification notification){
        if (value == null){
            notification.addError(new Error(field, field + " cannot be null"));
            return null;
        }
        return new AttributeBoolean(value);
    }
}

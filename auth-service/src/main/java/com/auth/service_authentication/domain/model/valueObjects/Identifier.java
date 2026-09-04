package com.auth.service_authentication.domain.model.valueObjects;

import com.auth.service_authentication.domain.model.validation.Error;
import com.auth.service_authentication.domain.model.validation.Notification;

public final class Identifier {

    private final Integer id;
    private  static final String ID = "Id";

    private Identifier(Integer id){
        this.id = id;
    }

    public static Identifier validate(Integer id, Notification notification){
        if (id != null && id <= 0 ) {
            notification.addError(new Error(ID, String.valueOf(id), ID + " must not be zero or less"));
            return null;
        }
        return new Identifier(id);
    }

    public Integer getId(){
        return this.id;
    }
}

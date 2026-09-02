package com.auth.service_authentication.domain.model.validation;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Notification {
    // The Notifications class is used to handle errors in the domain layer, applying the Notification pattern.
    private final List<Error> errors = new ArrayList<>();

    public Notification(){}

    public void addError(Error error){
        this.errors.add(error);
    }

    public Boolean hasErrors(){
        return !this.errors.isEmpty();
    }

    public List<Error> getErrors(){
        return List.copyOf(this.errors);
    }

}

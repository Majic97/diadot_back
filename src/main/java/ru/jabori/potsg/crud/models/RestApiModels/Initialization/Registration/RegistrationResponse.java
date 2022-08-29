package ru.jabori.potsg.crud.models.RestApiModels.Initialization.Registration;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {

    public String registrationStatus;
    public String message;

    public RegistrationResponse(String registrationStatus, String message) {
        this.registrationStatus = registrationStatus;
        this.message = message;
    }

    public RegistrationResponse() {
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public String getMessage() {
        return message;
    }
}

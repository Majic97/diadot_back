package ru.jabori.potsg.crud.models.RestApiModels;

import java.io.Serializable;

public class DefaultResponse implements Serializable {

    private int status;

    private String message;

    public DefaultResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

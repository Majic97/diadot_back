package ru.jabori.potsg.crud.models.RestApiModels.Initialization.Authentication;

import java.io.Serializable;

public class GetNewTokenRequest implements Serializable {

    private String jwt;

    private String text;

    public GetNewTokenRequest(String jwt, String text) {

        setJwt(jwt);
        setText(text);
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {

        this.jwt = jwt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

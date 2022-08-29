package ru.jabori.potsg.crud.models.RestApiModels.Initialization.Authentication;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;

    private final String jwtRestart;

    public AuthenticationResponse(String jwt, String jwtRestart) {

        this.jwt = jwt;
        this.jwtRestart=jwtRestart;
    }

    public String getJwt() {
        return jwt;
    }

    public String getJwtRestart() {
        return jwtRestart;
    }


}

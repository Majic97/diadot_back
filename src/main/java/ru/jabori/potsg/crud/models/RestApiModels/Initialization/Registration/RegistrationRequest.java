package ru.jabori.potsg.crud.models.RestApiModels.Initialization.Registration;

import java.io.Serializable;

public class RegistrationRequest implements Serializable {

    private String region;
    private String userName;
    private String userNumber;
    private String email;
    private String information;
    private String login;
    private String password;


    public RegistrationRequest() {}

    public RegistrationRequest(String region, String userName,
                               String userNumber, String email, String information,
                               String login, String password) {
        this.region = region;
        this.userName = userName;
        this.userNumber = userNumber;
        this.email = email;
        this.information = information;
        this.login = login;
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

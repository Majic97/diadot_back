package ru.jabori.potsg.crud.models.RestApiModels.getChatDescription;

import java.io.Serializable;

public class LinkData implements Serializable {

    private int user_id;

    private String name;

    private int team_id;

    private boolean is_admin;

    private boolean redact_right;

    public LinkData(int user_id, String name, int team_id, boolean is_admin, boolean redact_right) {
        this.user_id = user_id;
        this.name = name;
        this.team_id = team_id;
        this.is_admin = is_admin;
        this.redact_right = redact_right;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isRedact_right() {
        return redact_right;
    }

    public void setRedact_right(boolean redact_right) {
        this.redact_right = redact_right;
    }
}

package ru.jabori.potsg.crud.models.RestApiModels.GET.getStatusInChat;

import java.io.Serializable;

public class GetStatusInChatResponse implements Serializable {

    private int user_id;

    private int team_id;

    private boolean isAdmin;

    private boolean redact_right;

    public GetStatusInChatResponse(int user_id, int team_id, boolean isAdmin, boolean redact_right) {
        this.user_id = user_id;
        this.team_id = team_id;
        this.isAdmin = isAdmin;
        this.redact_right = redact_right;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isRedact_right() {
        return redact_right;
    }

    public void setRedact_right(boolean redact_right) {
        this.redact_right = redact_right;
    }
}

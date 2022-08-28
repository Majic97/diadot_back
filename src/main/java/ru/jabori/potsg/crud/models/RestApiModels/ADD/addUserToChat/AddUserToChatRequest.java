package ru.jabori.potsg.crud.models.RestApiModels.ADD.addUserToChat;

import java.io.Serializable;

public class AddUserToChatRequest implements Serializable {

    private int author_id;

    private int chat_id;

    private int invited_user_id;

    private int team_id;

    private boolean redact_right;

    public AddUserToChatRequest(int author_id, int chat_id, int invited_user_id, int team_id, boolean redact_right) {
        this.author_id = author_id;
        this.chat_id = chat_id;
        this.invited_user_id = invited_user_id;
        this.team_id = team_id;
        this.redact_right = redact_right;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getInvited_user_id() {
        return invited_user_id;
    }

    public void setInvited_user_id(int invited_user_id) {
        this.invited_user_id = invited_user_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public boolean isRedact_right() {
        return redact_right;
    }

    public void setRedact_right(boolean redact_right) {
        this.redact_right = redact_right;
    }
}

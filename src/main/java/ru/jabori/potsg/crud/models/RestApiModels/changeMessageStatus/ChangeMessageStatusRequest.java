package ru.jabori.potsg.crud.models.RestApiModels.changeMessageStatus;

import java.io.Serializable;
import java.util.Date;

public class ChangeMessageStatusRequest implements Serializable {

     private int user_id;

     private int chat_id;

     private int suggester_id;

     private Date suggestion_date_time;

     private boolean isAdmin;

    public ChangeMessageStatusRequest(int user_id, int chat_id, int suggester_id, Date suggestion_date_time, boolean isAdmin) {
        this.user_id = user_id;
        this.chat_id = chat_id;
        this.suggester_id = suggester_id;
        this.suggestion_date_time = suggestion_date_time;
        this.isAdmin = isAdmin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getSuggester_id() {
        return suggester_id;
    }

    public void setSuggester_id(int suggester_id) {
        this.suggester_id = suggester_id;
    }

    public Date getSuggestion_date_time() {
        return suggestion_date_time;
    }

    public void setSuggestion_date_time(Date suggestion_date_time) {
        this.suggestion_date_time = suggestion_date_time;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

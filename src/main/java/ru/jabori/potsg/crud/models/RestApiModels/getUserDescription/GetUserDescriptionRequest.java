package ru.jabori.potsg.crud.models.RestApiModels.getUserDescription;

import java.io.Serializable;

public class GetUserDescriptionRequest implements Serializable {

    public int author_id;

    public int wanted_user_id;

    public GetUserDescriptionRequest(int author_id, int wanted_user_id) {
        this.author_id = author_id;
        this.wanted_user_id = wanted_user_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getWanted_user_id() {
        return wanted_user_id;
    }

    public void setWanted_user_id(int wanted_user_id) {
        this.wanted_user_id = wanted_user_id;
    }
}

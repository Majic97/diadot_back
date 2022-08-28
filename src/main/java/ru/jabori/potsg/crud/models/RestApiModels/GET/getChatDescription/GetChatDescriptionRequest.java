package ru.jabori.potsg.crud.models.RestApiModels.GET.getChatDescription;

import java.io.Serializable;

public class GetChatDescriptionRequest implements Serializable {

    private int user_id;
    private int chat_id;

    public GetChatDescriptionRequest(int user_id, int chat_id) {
        this.user_id = user_id;
        this.chat_id = chat_id;
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
}

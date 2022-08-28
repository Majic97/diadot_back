package ru.jabori.potsg.crud.models.RestApiModels.ADD.addNewChat;

import java.io.Serializable;

public class AddNewChatRequest implements Serializable {

    private int user_id;

    private String chat_name;

    private String chat_description;

    public AddNewChatRequest(int user_id, String chat_name, String chat_description) {
        this.user_id = user_id;
        this.chat_name = chat_name;
        this.chat_description = chat_description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_description() {
        return chat_description;
    }

    public void setChat_description(String chat_description) {
        this.chat_description = chat_description;
    }
}

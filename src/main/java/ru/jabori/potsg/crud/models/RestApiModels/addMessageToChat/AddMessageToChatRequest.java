package ru.jabori.potsg.crud.models.RestApiModels.addMessageToChat;

import java.io.Serializable;

public class AddMessageToChatRequest implements Serializable {

    private int user_id;

    private int chat_id;

    private float operation;

    private String description;

    public AddMessageToChatRequest(int user_id, int chat_id, float operation, String description) {
        this.user_id = user_id;
        this.chat_id = chat_id;
        this.operation = operation;
        this.description = description;
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

    public float getOperation() {
        return operation;
    }

    public void setOperation(float operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

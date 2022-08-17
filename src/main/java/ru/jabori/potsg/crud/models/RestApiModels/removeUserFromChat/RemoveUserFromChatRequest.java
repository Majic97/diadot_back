package ru.jabori.potsg.crud.models.RestApiModels.removeUserFromChat;

import java.io.Serializable;

public class RemoveUserFromChatRequest implements Serializable {

    private int author_id;

    private int chat_id;

    private int removes_user_id;

    public RemoveUserFromChatRequest(int author_id, int chat_id, int removes_user_id) {
        this.author_id = author_id;
        this.chat_id = chat_id;
        this.removes_user_id = removes_user_id;
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

    public int getRemoves_user_id() {
        return removes_user_id;
    }

    public void setRemoves_user_id(int removes_user_id) {
        this.removes_user_id = removes_user_id;
    }
}

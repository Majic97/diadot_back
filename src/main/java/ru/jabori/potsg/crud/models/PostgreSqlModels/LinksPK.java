package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LinksPK implements Serializable {

    @Column(name="chat_id")
    private int chatId;

    @Column(name = "user_id")
    private int userId;

    public LinksPK() {
    }

    public LinksPK(int chatId, int userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

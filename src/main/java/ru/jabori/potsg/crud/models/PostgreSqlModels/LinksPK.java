package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinksPK implements Serializable {

    @Column(name="chat_id")
    @NotNull
    private int chatId;

    @Column(name = "user_id")
    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinksPK)) return false;
        LinksPK linksPK = (LinksPK) o;
        return getChatId() == linksPK.getChatId() && getUserId() == linksPK.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId(), getUserId());
    }
}

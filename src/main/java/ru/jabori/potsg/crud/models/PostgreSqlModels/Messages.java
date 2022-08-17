package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Messages {

    @ManyToOne
    @JoinColumn(name = "suggester_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users messageUser;
    @ManyToOne
    @JoinColumn(name = "chat_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Chats chat;

    @EmbeddedId
    private MessagesPK messagePK;

    @Column(name="operation")
    @NotNull
    private float operation;

    @Column(name="description")
    @Length(max=200, message = "Description should be less than 200 characters")
    private String description;

    @Column(name="chat_id")
    @NotNull
    private int chatId;

    public Messages() {
    }

    public Messages(MessagesPK messagePK, float operation, String description, int chatId) {
        this.messagePK = messagePK;
        this.operation = operation;
        this.description = description;
        this.chatId = chatId;
    }

    public MessagesPK getMessagePK() {
        return messagePK;
    }

    public void setMessagePK(MessagesPK id) {
        this.messagePK = id;
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatid) {
        this.chatId = chatid;
    }

    public Chats getChat() {
        return chat;
    }

    public void setChat(Chats chat) {
        this.chat = chat;
    }

    public Users getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(Users messageUser) {
        this.messageUser = messageUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Messages)) return false;
        Messages messages = (Messages) o;
        return Float.compare(messages.getOperation(), getOperation()) == 0 && getChatId() == messages.getChatId() && getMessageUser().equals(messages.getMessageUser()) && getChat().equals(messages.getChat()) && getMessagePK().equals(messages.getMessagePK()) && getDescription().equals(messages.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageUser(), getChat(), getMessagePK(), getOperation(), getDescription(), getChatId());
    }
}

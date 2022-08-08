package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;

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
    private MessagesPK id;

    @Column(name="operation")
    private float operation;

    @Column(name="description")
    private String description;

    @Column(name="chatId")
    private int chatId;

    public Messages() {
    }

    public Messages(Users messageUser, Chats chat, MessagesPK id, float operation, String description, int chatId) {
        this.messageUser = messageUser;
        this.chat = chat;
        this.id = id;
        this.operation = operation;
        this.description = description;
        this.chatId = chatId;
    }

    public MessagesPK getId() {
        return id;
    }

    public void setId(MessagesPK id) {
        this.id = id;
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
}

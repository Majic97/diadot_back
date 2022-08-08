package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {

    @ManyToOne
    @JoinColumn(name = "accepterId",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users acceptTransactionUser;
    @ManyToOne
    @JoinColumn(name = "suggesterId",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users suggestTransactionUser;

    @ManyToOne
    @JoinColumn(name = "chatId",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Chats chat;

    @EmbeddedId
    private TransactionsPK id;

    @Column(name="operation")
    private float operation;

    @Column(name="result")
    private float result;

    @Column(name="description")
    private String description;

    @Column(name="suggestionDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date suggestionDateTime;

    @Column(name="suggesterId")
    private int suggesterId;

    @Column(name="chatId")
    private int chatId;

    public Transactions() {
    }

    public Transactions(Users acceptTransactionUser, Users suggestTransactionUser, Chats chat,
                        TransactionsPK id, float operation, float result, String description,
                        Date suggestionDateTime, int suggesterId, int chatId) {
        this.acceptTransactionUser = acceptTransactionUser;
        this.suggestTransactionUser = suggestTransactionUser;
        this.chat = chat;
        this.id = id;
        this.operation = operation;
        this.result = result;
        this.description = description;
        this.suggestionDateTime = suggestionDateTime;
        this.suggesterId = suggesterId;
        this.chatId = chatId;
    }

    public Users getUser2() {
        return suggestTransactionUser;
    }

    public void setSuggestTransactionUser(Users user) {
        this.suggestTransactionUser = user;
    }

    public TransactionsPK getId() {
        return id;
    }

    public void setId(TransactionsPK id) {
        this.id = id;
    }

    public float getOperation() {
        return operation;
    }

    public void setOperation(float operation) {
        this.operation = operation;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSuggestionDateTime() {
        return suggestionDateTime;
    }

    public void setSuggestionDateTime(Date suggestionDateTime) {
        this.suggestionDateTime = suggestionDateTime;
    }

    public int getSuggesterId() {
        return suggesterId;
    }

    public void setSuggesterId(int suggesterId) {
        this.suggesterId = suggesterId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public Users getSuggestTransactionUser() {
        return suggestTransactionUser;
    }

    public Chats getChat() {
        return chat;
    }

    public void setChat(Chats chat) {
        this.chat = chat;
    }

    public Users getAcceptTransactionUser() {
        return acceptTransactionUser;
    }

    public void setAcceptTransactionUser(Users acceptTransactionUser) {
        this.acceptTransactionUser = acceptTransactionUser;
    }
}

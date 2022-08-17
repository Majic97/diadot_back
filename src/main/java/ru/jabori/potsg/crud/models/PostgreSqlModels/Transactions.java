package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transactions {

    @ManyToOne
    @JoinColumn(name = "accepter_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users acceptTransactionUser;
    @ManyToOne
    @JoinColumn(name = "suggester_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users suggestTransactionUser;

    @ManyToOne
    @JoinColumn(name = "chat_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Chats chat;

    @EmbeddedId
    private TransactionsPK transactionPK;

    @Column(name="operation")
    @NotNull
    private float operation;

    @Column(name="result")
    @NotNull
    private float result;

    @Column(name="description")
    @Length(max = 200, message = "Description should be less than 200 characters")
    private String description;

    @Column(name="suggestion_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy/hh/mm/ss")
    @NotNull
    private Date suggestionDateTime;

    @Column(name="suggester_id")
    @NotNull
    private int suggesterId;

    @Column(name="chat_id")
    @NotNull
    private int chatId;

    @Column(name="is_cancelled_message")
    @NotNull
    private boolean isCancelledMessage;

    public Transactions() {
    }

    public Transactions(TransactionsPK transactionPK, float operation,
                        float result, String description, Date suggestionDateTime,
                        int suggesterId, int chatId, boolean isCancelledMessage) {
        this.transactionPK = transactionPK;
        this.operation = operation;
        this.result = result;
        this.description = description;
        this.suggestionDateTime = suggestionDateTime;
        this.suggesterId = suggesterId;
        this.chatId = chatId;
        this.isCancelledMessage = isCancelledMessage;
    }

    public Users getUser2() {
        return suggestTransactionUser;
    }

    public void setSuggestTransactionUser(Users user) {
        this.suggestTransactionUser = user;
    }

    public TransactionsPK getTransactionPK() {
        return transactionPK;
    }

    public void setTransactionPK(TransactionsPK id) {
        this.transactionPK = id;
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

    public boolean getIsCancelledMessage() {
        return isCancelledMessage;
    }

    public void setIsCancelledMessage(boolean isCancelledMessage) {
        this.isCancelledMessage = isCancelledMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transactions)) return false;
        Transactions that = (Transactions) o;
        return Float.compare(that.getOperation(), getOperation()) == 0 && Float.compare(that.getResult(), getResult()) == 0 && getSuggesterId() == that.getSuggesterId() && getChatId() == that.getChatId() && isCancelledMessage == that.isCancelledMessage && getAcceptTransactionUser().equals(that.getAcceptTransactionUser()) && getSuggestTransactionUser().equals(that.getSuggestTransactionUser()) && getChat().equals(that.getChat()) && getTransactionPK().equals(that.getTransactionPK()) && getDescription().equals(that.getDescription()) && getSuggestionDateTime().equals(that.getSuggestionDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcceptTransactionUser(), getSuggestTransactionUser(), getChat(), getTransactionPK(), getOperation(), getResult(), getDescription(), getSuggestionDateTime(), getSuggesterId(), getChatId(), isCancelledMessage);
    }
}

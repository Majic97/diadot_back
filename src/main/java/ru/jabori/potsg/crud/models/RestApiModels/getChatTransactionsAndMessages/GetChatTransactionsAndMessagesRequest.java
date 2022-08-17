package ru.jabori.potsg.crud.models.RestApiModels.getChatTransactionsAndMessages;

import java.io.Serializable;

public class GetChatTransactionsAndMessagesRequest implements Serializable {

    private int user_id;

    private int chat_id;

    private int transactions_count;

    public GetChatTransactionsAndMessagesRequest(int user_id, int chat_id, int transactions_count) {
        this.user_id = user_id;
        this.chat_id = chat_id;
        this.transactions_count = transactions_count;
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

    public int getTransactions_count() {
        return transactions_count;
    }

    public void setTransactions_count(int transactions_count) {
        this.transactions_count = transactions_count;
    }
}

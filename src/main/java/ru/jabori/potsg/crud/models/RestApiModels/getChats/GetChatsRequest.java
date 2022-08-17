package ru.jabori.potsg.crud.models.RestApiModels.getChats;

import java.io.Serializable;
import java.util.Date;

public class GetChatsRequest implements Serializable {

    private int userId;

    private int chat_id;

    private int chat_name;

    private Date last_transaction_date_time;

    private Date last_message_date_time;

    public GetChatsRequest(int userId, int chat_id, int chat_name, Date last_transaction_date_time, Date last_message_date_time) {
        this.userId = userId;
        this.chat_id = chat_id;
        this.chat_name = chat_name;
        this.last_transaction_date_time = last_transaction_date_time;
        this.last_message_date_time = last_message_date_time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getChat_name() {
        return chat_name;
    }

    public void setChat_name(int chat_name) {
        this.chat_name = chat_name;
    }

    public Date getLast_transaction_date_time() {
        return last_transaction_date_time;
    }

    public void setLast_transaction_date_time(Date last_transaction_date_time) {
        this.last_transaction_date_time = last_transaction_date_time;
    }

    public Date getLast_message_date_time() {
        return last_message_date_time;
    }

    public void setLast_message_date_time(Date last_message_date_time) {
        this.last_message_date_time = last_message_date_time;
    }
}

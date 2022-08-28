package ru.jabori.potsg.crud.models.RestApiModels.GET.getChats;

import java.io.Serializable;
import java.util.Date;

public class GetChatsResponse implements Serializable {

    private int chat_id;

    private String chat_name;

    private float last_transaction_result;

    private Date  last_transaction_date_time;

    private int message_count;

    private Date last_message_date_time;

    public GetChatsResponse(int chat_id, String chat_name, float last_transaction_result,
                            Date last_transaction_date_time, int message_count, Date last_message_date_time) {
        this.chat_id = chat_id;
        this.chat_name = chat_name;
        this.last_transaction_result = last_transaction_result;
        this.last_transaction_date_time = last_transaction_date_time;
        this.message_count = message_count;
        this.last_message_date_time = last_message_date_time;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public float getLast_transaction_result() {
        return last_transaction_result;
    }

    public void setLast_transaction_result(float last_transaction_result) {
        this.last_transaction_result = last_transaction_result;
    }

    public Date getLast_transaction_date_time() {
        return last_transaction_date_time;
    }

    public void setLast_transaction_date_time(Date last_transaction_date_time) {
        this.last_transaction_date_time = last_transaction_date_time;
    }

    public int getMessage_count() {
        return message_count;
    }

    public void setMessage_count(int message_count) {
        this.message_count = message_count;
    }

    public Date getLast_message_date_time() {
        return last_message_date_time;
    }

    public void setLast_message_date_time(Date last_message_date_time) {
        this.last_message_date_time = last_message_date_time;
    }
}

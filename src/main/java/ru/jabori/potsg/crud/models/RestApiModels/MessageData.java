package ru.jabori.potsg.crud.models.RestApiModels;

import java.io.Serializable;
import java.util.Date;

public class MessageData implements Serializable {
    private int message_id;
    private double operation;
    private Date suggest_date;
    private String suggest_author_id;

    public MessageData(int message_id, double operation,
                       Date suggest_date, String suggest_author_id) {
        this.message_id = message_id;
        this.operation = operation;
        this.suggest_date = suggest_date;
        this.suggest_author_id = suggest_author_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public double getOperation() {
        return operation;
    }

    public void setOperation(double operation) {
        this.operation = operation;
    }

    public Date getSuggest_date() {
        return suggest_date;
    }

    public void setSuggest_date(Date suggest_date) {
        this.suggest_date = suggest_date;
    }

    public String getSuggest_author_id() {
        return suggest_author_id;
    }

    public void setSuggest_author_id(String suggest_author_id) {
        this.suggest_author_id = suggest_author_id;
    }
}

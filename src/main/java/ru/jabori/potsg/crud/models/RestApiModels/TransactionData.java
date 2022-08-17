package ru.jabori.potsg.crud.models.RestApiModels;

import java.io.Serializable;
import java.util.Date;

public class TransactionData implements Serializable {
    private int transaction_id;
    private double operation;
    private double total;
    private Date suggest_date;
    private Date accept_date;
    private String suggest_author_name;
    private String accept_author_name;

    public TransactionData(int message_uniq_id, double operation,
                           double total, Date suggest_date, Date accept_date,
                           String suggest_author_name,
                           String accept_author_name) {
        this.transaction_id = message_uniq_id;
        this.operation = operation;
        this.total = total;
        this.suggest_date = suggest_date;
        this.accept_date = accept_date;
        this.suggest_author_name = suggest_author_name;
        this.accept_author_name = accept_author_name;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getOperation() {
        return operation;
    }

    public void setOperation(double operation) {
        this.operation = operation;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getSuggest_date() {
        return suggest_date;
    }

    public void setSuggest_date(Date suggest_date) {
        this.suggest_date = suggest_date;
    }

    public Date getAccept_date() {
        return accept_date;
    }

    public void setAccept_date(Date accept_date) {
        this.accept_date = accept_date;
    }

    public String getSuggest_author_name() {
        return suggest_author_name;
    }

    public void setSuggest_author_name(String suggest_author_name) {
        this.suggest_author_name = suggest_author_name;
    }

    public String getAccept_author_name() {
        return accept_author_name;
    }

    public void setAccept_author_name(String accept_author_name) {
        this.accept_author_name = accept_author_name;
    }
}

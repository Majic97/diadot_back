package ru.jabori.potsg.crud.models.simple;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LinksPK implements Serializable {

    @Column(name="user_id")
    private int user_id;

    @Column(name = "number")
    private int number;

    public LinksPK() {
    }

    public LinksPK(int user_id, int number) {
        this.user_id = user_id;
        this.number = number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

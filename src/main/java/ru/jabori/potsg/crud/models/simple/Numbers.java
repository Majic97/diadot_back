package ru.jabori.potsg.crud.models.simple;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="numbers")
public class Numbers implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToMany(mappedBy = "numbers1")
    private List<Links> links;

    @Id
    @Column(name="nid")
    private int numberId;

//    @Column(name="user_id")
//    private int user_id;

    @Column(name="number")
    private int number;

    public Numbers() {
    }

    public Numbers(int numberId, int number) {
        this.numberId = numberId;
//        this.user_id = user_id;
        this.number = number;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int id) {
        this.numberId = id;
    }

//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

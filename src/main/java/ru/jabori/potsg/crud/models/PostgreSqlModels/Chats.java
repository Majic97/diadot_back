package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="chats")
public class Chats {

    @OneToMany(mappedBy = "chat")
    private List<Links> links;

    @OneToMany(mappedBy = "chat")
    private List<Messages> messages;

    @OneToMany(mappedBy = "chat")
    private List<Transactions> transactions;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="currency")
    private String currency;

    public Chats() {
    }

    public Chats( String name, String description, String currency) {
        this.name = name;
        this.description = description;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }


}

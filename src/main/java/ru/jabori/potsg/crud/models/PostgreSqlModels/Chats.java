package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.hibernate.validator.constraints.Currency;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

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
    @NotNull
    private int id;

    @Column(name="name")
    @NotNull
    @Length(min = 5,max = 32 , message = "Name should be between 5 and 32 characters")
    private String name;

    @Column(name="description")
    @Length(max = 200 , message = "Name should be less than 200 characters")
    private String description;

    @Column(name="currency")
    @NotNull
    @Length(min =3,max = 3, message = "Currency should be 3 characters")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chats)) return false;
        Chats chats = (Chats) o;
        return getId() == chats.getId() && getLinks().equals(chats.getLinks()) && getMessages().equals(chats.getMessages()) && getTransactions().equals(chats.getTransactions()) && getName().equals(chats.getName()) && getDescription().equals(chats.getDescription()) && getCurrency().equals(chats.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLinks(), getMessages(), getTransactions(), getId(), getName(), getDescription(), getCurrency());
    }
}

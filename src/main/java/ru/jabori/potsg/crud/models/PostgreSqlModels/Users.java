package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class Users {

    @OneToMany(mappedBy = "linkUser")
    private List<Links> links;

    @OneToMany(mappedBy = "messageUser")
    private List<Messages> messages;

    @OneToMany(mappedBy = "acceptTransactionUser")
    private List<Transactions> transactionsUserAsAccepter;

    @OneToMany(mappedBy = "suggestTransactionUser")
    private List<Transactions> transactionsUserAsSuggester;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotNull
    @Length(min = 5,max = 32,message = "Name should be between 4 and 32 characters")
    private String name;

    @Column(name="login")
    @NotNull
    @Length(min = 5,max = 32,message = "Login should be between 4 and 32 characters")
    private String login;

    @Column(name="password")
    @Length(min = 64, max = 64 , message = "Password should be 64 characters")
    private String password;

    @Column(name="email")
    @NotNull
    @Email
    private String email;

    @Column(name="information")
    private String information;

    @Column(name="number")
    @Length(min=5, message = "Number should be more than 5 characters")
    private String number;

    @Column(name="region")
    @NotNull
    @Length(min = 5, max = 5, message = "Region should be 5 characters")
    private String region;

    public Users() {
    }

    public Users(String name, String login,
                 String password, String email,
                 String region, String information, String number) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.information = information;
        this.region = region;
        this.number = number;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Transactions> getTransactionsUserAsSuggester() {
        return transactionsUserAsSuggester;
    }

    public void setTransactionsUserAsSuggester(List<Transactions> transactionsUserAsSuggester) {
        this.transactionsUserAsSuggester = transactionsUserAsSuggester;
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

    public List<Transactions> getTransactionsUserAsAccepter() {
        return transactionsUserAsAccepter;
    }

    public void setTransactionsUserAsAccepter(List<Transactions> transactionsUserAsAccepter) {
        this.transactionsUserAsAccepter = transactionsUserAsAccepter;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() && getLinks().equals(users.getLinks()) && getMessages().equals(users.getMessages())
                && getTransactionsUserAsAccepter().equals(users.getTransactionsUserAsAccepter()) &&
                getTransactionsUserAsSuggester().equals(users.getTransactionsUserAsSuggester()) &&
                getName().equals(users.getName()) && getLogin().equals(users.getLogin()) &&
                getPassword().equals(users.getPassword()) && getEmail().equals(users.getEmail())
                && getInformation().equals(users.getInformation()) && getNumber().equals(users.getNumber())
                && getRegion().equals(users.getRegion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLinks(), getMessages(), getTransactionsUserAsAccepter(), getTransactionsUserAsSuggester(),
                getId(), getName(), getLogin(), getPassword(), getEmail(), getInformation(), getNumber(), getRegion());
    }
}

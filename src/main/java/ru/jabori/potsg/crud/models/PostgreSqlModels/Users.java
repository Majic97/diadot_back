package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.util.List;

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
    private String name;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="information")
    private String information;

    @Column(name="region")
    private String region;

    public Users() {
    }

    public Users(String name, String login,
                 String password, String email,
                 String region, String information) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.information = information;
        this.region = region;
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
}

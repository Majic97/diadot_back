package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="links")
public class Links {

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users linkUser;

    @ManyToOne
    @JoinColumn(name = "chat_id",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Chats chat;

    @EmbeddedId
    private LinksPK primaryKey;

    @Column(name="admin")
    @NotNull
    private boolean admin;

    @Column(name="reduct_right")
    @NotNull
    private boolean reductRight;

    @Column(name="invite_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy/hh/mm/ss")
    @NotNull
    private Date inviteDateTime;

    @Column(name="team_id")
    @NotNull
    private int teamId;

    public Links() {
    }

    public Links(LinksPK primaryKey, boolean admin,
                 boolean reductRight, int teamId) {
        this.primaryKey = primaryKey;
        this.admin = admin;
        this.reductRight = reductRight;
        this.inviteDateTime = Date.from(Instant.now());
        this.teamId = teamId;
    }

    public LinksPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(LinksPK id) {
        this.primaryKey = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean hasReductRight() {
        return reductRight;
    }

    public void setReductRight(boolean reductRight) {
        this.reductRight = reductRight;
    }

    public Date getInviteDateTime() {
        return inviteDateTime;
    }

    public void setInviteDateTime(Date inviteDateTime) {
        this.inviteDateTime = inviteDateTime;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Users getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(Users user) {
        this.linkUser = user;
    }

    public Chats getChat() {
        return chat;
    }

    public void setChat(Chats chat) {
        this.chat = chat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Links)) return false;
        Links links = (Links) o;
        return isAdmin() == links.isAdmin() && reductRight == links.reductRight && getTeamId() == links.getTeamId() && getLinkUser().equals(links.getLinkUser()) && getChat().equals(links.getChat()) && getPrimaryKey().equals(links.getPrimaryKey()) && getInviteDateTime().equals(links.getInviteDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLinkUser(), getChat(), getPrimaryKey(), isAdmin(), reductRight, getInviteDateTime(), getTeamId());
    }
}

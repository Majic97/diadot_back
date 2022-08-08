package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="links")
public class Links {

    @ManyToOne
    @JoinColumn(name = "userId",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Users linkUser;

    @ManyToOne
    @JoinColumn(name = "chatId",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Chats chat;

    @EmbeddedId
    private LinksPK primaryKey;

    @Column(name="admin")
    private boolean admin;

    @Column(name="reductRight")
    private boolean reductRight;

    @Column(name="inviteDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inviteDateTime;

    @Column(name="teamId")
    private int teamId;

    public Links() {
    }

    public Links(LinksPK primaryKey, boolean admin,
                 boolean reductRight, Date inviteDateTime, int teamId) {
        this.primaryKey = primaryKey;
        this.admin = admin;
        this.reductRight = reductRight;
        this.inviteDateTime = inviteDateTime;
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

    public boolean isReductRight() {
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
}

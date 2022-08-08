package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class TransactionsPK implements Serializable {

    @Column(name="acceptionDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptionDateTime;

    @Column(name = "accepterId")
    private int accepterId;

    public TransactionsPK() {
    }

    public TransactionsPK(Date acceptionDateTime, int accepterId) {
        this.acceptionDateTime = acceptionDateTime;
        this.accepterId = accepterId;
    }

    public Date getAcceptionDateTime() {
        return acceptionDateTime;
    }

    public void setAcceptionDateTime(Date acceptionDateTime) {
        this.acceptionDateTime = acceptionDateTime;
    }

    public int getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(int accepterId) {
        this.accepterId = accepterId;
    }
}

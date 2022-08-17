package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class TransactionsPK implements Serializable {

    @Column(name="acception_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy/hh/mm/ss")
    @NotNull
    private Date acceptionDateTime;

    @Column(name = "accepter_id")
    @NotNull
    private int accepterId;

    public TransactionsPK() {
    }

    public TransactionsPK( int accepterId) {
        this.acceptionDateTime =Date.from(Instant.now());
        this.accepterId = accepterId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionsPK)) return false;
        TransactionsPK that = (TransactionsPK) o;
        return getAccepterId() == that.getAccepterId() && getAcceptionDateTime().equals(that.getAcceptionDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcceptionDateTime(), getAccepterId());
    }
}

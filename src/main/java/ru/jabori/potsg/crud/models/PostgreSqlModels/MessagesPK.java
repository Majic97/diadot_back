package ru.jabori.potsg.crud.models.PostgreSqlModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class MessagesPK implements Serializable {

    @Column(name = "suggestion_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy/hh/mm/ss")
    @NotNull
    private Date suggestionDateTime;

    @Column(name="suggester_id")
    @NotNull
    private int suggesterId;

    public MessagesPK() {
    }

    public MessagesPK(int suggesterId) {
        this.suggestionDateTime = Date.from(Instant.now());
        this.suggesterId = suggesterId;
    }

    public MessagesPK( int suggesterId, Date suggestionDateTime) {
        this.suggestionDateTime = suggestionDateTime;
        this.suggesterId = suggesterId;
    }

    public Date getSuggestionDateTime() {
        return suggestionDateTime;
    }

    public void setSuggestionDateTime(Date suggestionDateTime) {
        this.suggestionDateTime = suggestionDateTime;
    }

    public int getSuggesterId() {
        return suggesterId;
    }

    public void setSuggesterId(int suggesterId) {
        this.suggesterId = suggesterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessagesPK)) return false;
        MessagesPK that = (MessagesPK) o;
        return getSuggesterId() == that.getSuggesterId() && getSuggestionDateTime().equals(that.getSuggestionDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuggestionDateTime(), getSuggesterId());
    }
}

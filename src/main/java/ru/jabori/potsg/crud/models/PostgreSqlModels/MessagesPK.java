package ru.jabori.potsg.crud.models.PostgreSqlModels;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MessagesPK implements Serializable {

    @Column(name = "suggestionDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date suggestionDateTime;

    @Column(name="suggesterId")
    private int suggesterId;

    public MessagesPK() {
    }

    public MessagesPK(Date suggestionDateTime, int suggesterId) {
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
}

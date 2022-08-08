package ru.jabori.potsg.crud.models.simple;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "links")
public class Links implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users users1;

    @ManyToOne
    @JoinColumn(name = "number",referencedColumnName = "number")
    private Numbers numbers1;

    @EmbeddedId
    private LinksPK linkspk;

    @Column(name = "inf")
    private String inf;

    public Links() {
    }

    public Links(LinksPK linkspk, String inf) {
        this.linkspk = linkspk;
        this.inf = inf;
    }

    public LinksPK getLinkspk() {
        return linkspk;
    }

    public void setLinkspk(LinksPK linkspk) {
        this.linkspk = linkspk;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}

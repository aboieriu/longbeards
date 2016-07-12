package ro.mmountains.repository.jpa.entity;

import ro.mmountains.domain.Message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by aboieriu on 7/12/16.
 */
@Entity
@Table(name = "message")
public class EMessage {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "read")
    private Boolean read;

    public EMessage(){};

    public EMessage(long id, String content, Boolean read) {
        this.id = id;
        this.content = content;
        this.read = read;
    }

    public Message convert() {
        return new Message(this.id, this.content, this.read);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}

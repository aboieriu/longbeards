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
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    public EMessage(){};

    public EMessage(Message message){
        this.id = message.getId();
        this.content = message.getContent();
    }

    public EMessage(long id, String content, Boolean read) {
        this.id = id;
        this.content = content;
    }

    public Message convert() {
        return new Message(this.id, this.content);
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

}

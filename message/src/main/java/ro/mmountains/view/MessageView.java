package ro.mmountains.view;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageView {
    private final long id;

    private final String content;

    private final Boolean read;

    @JsonCreator
    public MessageView(long id, String content, Boolean read) {
        this.id = id;
        this.content = content;
        this.read = read;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getRead() {
        return read;
    }
}

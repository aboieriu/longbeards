package ro.mmountains.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aboieriu on 7/12/16.
 */
public class MessageView {
    private final long id;

    private final String content;


    @JsonCreator
    public MessageView(
            @JsonProperty("id") long id,
            @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}

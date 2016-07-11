package ro.mmountains.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aboieriu on 7/12/16.
 */
public class DwarfView {
    private final long id;
    private final String name;

    @JsonCreator
    public DwarfView(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name
    ) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

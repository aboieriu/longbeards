package ro.mmountains.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ro.mmountains.domain.Dwarf;
import ro.mmountains.domain.Treasure;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureView {

    private long id;

    private String type;

    private long value;

    private DwarfView dwarf;

    public TreasureView(){};

    @JsonCreator
    public TreasureView(
            @JsonProperty("id") long id,
            @JsonProperty("type")String type,
            @JsonProperty("value")long value,
            @JsonProperty("dwarf") DwarfView dwarf) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.dwarf = dwarf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public DwarfView getDwarf() {
        return dwarf;
    }

    public void setDwarf(DwarfView dwarf) {
        this.dwarf = dwarf;
    }
}

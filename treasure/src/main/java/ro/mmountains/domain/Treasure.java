package ro.mmountains.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by aboieriu on 7/12/16.
 */
public class Treasure {

    private long id;

    private String type;

    private long value;

    private Boolean acknowledge;

    private Dwarf dwarf;

    public Treasure(long id, String type, long value, Boolean acknowledge, Dwarf dwarf) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.acknowledge = acknowledge;
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

    public Boolean getAcknowledge() {
        return acknowledge;
    }

    public void setAcknowledge(Boolean acknowledge) {
        this.acknowledge = acknowledge;
    }

    public Dwarf getDwarf() {
        return dwarf;
    }

    public void setDwarf(Dwarf dwarf) {
        this.dwarf = dwarf;
    }
}

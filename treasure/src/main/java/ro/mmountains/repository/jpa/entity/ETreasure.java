package ro.mmountains.repository.jpa.entity;

import org.hibernate.annotations.Entity;
import ro.mmountains.domain.Treasure;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by aboieriu on 7/12/16.
 */
@javax.persistence.Entity
@Table(name = "treasure")
public class ETreasure {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private long value;

    @Column(name = "acknowledge")
    private Boolean acknowledge;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EDwarf dwarf;

    public ETreasure(){}

    public ETreasure(long id, String type, long value, Boolean acknowledge, EDwarf dwarf) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.acknowledge = acknowledge;
        this.dwarf = dwarf;
    }

    public Treasure convert(){
        return new Treasure(this.id, this.type, this.value, this.acknowledge, this.dwarf != null ? this.dwarf.convert() : null);
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

    public EDwarf getDwarf() {
        return dwarf;
    }

    public void setDwarf(EDwarf dwarf) {
        this.dwarf = dwarf;
    }
}

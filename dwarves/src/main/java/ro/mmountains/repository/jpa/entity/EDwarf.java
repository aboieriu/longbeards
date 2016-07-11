package ro.mmountains.repository.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by aboieriu on 7/12/16.
 */
@Entity
@Table(name = "dwarf")
public class EDwarf {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public EDwarf(){}

    public EDwarf(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ro.mmountains.domain.Dwarf convert(){
        return new ro.mmountains.domain.Dwarf(this.id, this.name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

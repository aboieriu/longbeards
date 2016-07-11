package ro.mmountains.domain;

/**
 * Created by aboieriu on 7/12/16.
 */
public class Dwarf {
    private final long id;
    private final String name;

    public Dwarf(long id, String name) {
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

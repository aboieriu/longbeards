package ro.mmountains.repository.jpa;

import com.google.common.base.Preconditions;
import ro.mmountains.repository.jpa.entity.EDwarf;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public class DwarfRepository implements IDwarfRepository {
    private final IDwarfJpa dwarfJpa;

    public DwarfRepository(IDwarfJpa dwarfJpa) {
        this.dwarfJpa = Preconditions.checkNotNull(dwarfJpa, "Dwarf JPA needs to be initialized");
    }

    public IDwarfJpa getDwarfJpa() {
        return dwarfJpa;
    }

    public List<EDwarf> getAll() {
        return dwarfJpa.findAll();
    }
}

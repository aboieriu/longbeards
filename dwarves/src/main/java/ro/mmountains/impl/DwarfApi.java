package ro.mmountains.impl;

import com.google.common.base.Preconditions;
import ro.mmountains.api.IDwarfApi;
import ro.mmountains.domain.Dwarf;
import ro.mmountains.repository.jpa.entity.EDwarf;
import ro.mmountains.repository.jpa.IDwarfRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class DwarfApi implements IDwarfApi {
    private final IDwarfRepository dwarfRepository;

    public DwarfApi(IDwarfRepository dwarfRepository) {
        this.dwarfRepository = Preconditions.checkNotNull(dwarfRepository, "dwarfRepository must be initialized");
    }

    public IDwarfRepository getDwarfRepository() {
        return dwarfRepository;
    }

    public List<Dwarf> getAll() {
        List<EDwarf> dwarfs = this.dwarfRepository.getAll();
        return dwarfs.stream().map(dwarf -> dwarf.convert()).collect(Collectors.toList());
    }
}

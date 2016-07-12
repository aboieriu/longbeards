package ro.mmountains.repository.jpa;

import com.google.common.base.Preconditions;
import ro.mmountains.domain.Treasure;
import ro.mmountains.repository.jpa.entity.EDwarf;
import ro.mmountains.repository.jpa.entity.ETreasure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureRepository implements ITreasureRepository {

    private final ITreasureJpa treasureJpa;
    private final IDwarfRepository dwarfRepository;

    public TreasureRepository(ITreasureJpa treasureJpa, IDwarfRepository dwarfRepository) {
        this.treasureJpa = Preconditions.checkNotNull(treasureJpa, "treasureJpa must be initialized");
        this.dwarfRepository = Preconditions.checkNotNull(dwarfRepository, "dwarfRepository must be initialized");
    }

    public List<Treasure> getAll() {
        List<ETreasure> treasures = treasureJpa.findAll();
        return treasures.stream().map(treasure -> treasure.convert()).collect(Collectors.toList());
    }

    public void addTreasure(Treasure treasure) {
        ETreasure eTreasure = new ETreasure(treasure);
        if (treasure.getDwarf() != null) {
            Optional<EDwarf> eDwarf = dwarfRepository.findById(treasure.getDwarf().getId());
            if (eDwarf.isPresent()) {
                eTreasure.setDwarf(eDwarf.get());
            }
        }
        treasureJpa.saveAndFlush(eTreasure);
    }
}

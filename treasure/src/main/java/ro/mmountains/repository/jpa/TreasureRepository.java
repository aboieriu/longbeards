package ro.mmountains.repository.jpa;

import com.google.common.base.Preconditions;
import ro.mmountains.domain.Treasure;
import ro.mmountains.repository.jpa.entity.ETreasure;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureRepository implements ITreasureRepository {

    private ITreasureJpa treasureJpa;

    public TreasureRepository(ITreasureJpa treasureJpa) {
        this.treasureJpa = Preconditions.checkNotNull(treasureJpa, "treasureJpa must be initialized");
    }

    public List<Treasure> getAll() {
        List<ETreasure> treasures = treasureJpa.findAll();
        return treasures.stream().map(treasure -> treasure.convert()).collect(Collectors.toList());
    }
}

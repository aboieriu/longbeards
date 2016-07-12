package ro.mmountains.impl;

import com.google.common.base.Preconditions;
import ro.mmountains.api.ITreasureApi;
import ro.mmountains.domain.Treasure;
import ro.mmountains.repository.jpa.ITreasureRepository;
import ro.mmountains.repository.jpa.TreasureRepository;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureApi implements ITreasureApi {

    private final ITreasureRepository treasureRepository;

    public TreasureApi(ITreasureRepository treasureRepository) {
        this.treasureRepository = Preconditions.checkNotNull(treasureRepository, "treasureRepository must be initialized");
    }

    public List<Treasure> getAll(){
        return treasureRepository.getAll();
    }

    public List<Treasure> getNewTreasures() {
        return treasureRepository.getNewTreasures();
    }

    public void addTreasure(Treasure treasure) {
        this.treasureRepository.addTreasure(treasure);
    }

    public ITreasureRepository getTreasureRepository() {
        return treasureRepository;
    }
}

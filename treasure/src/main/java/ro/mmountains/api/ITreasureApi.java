package ro.mmountains.api;

import ro.mmountains.domain.Treasure;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface ITreasureApi {
    List<Treasure> getAll();
    void addTreasure(Treasure treasure);
}

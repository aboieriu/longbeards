package ro.mmountains.repository.jpa;

import ro.mmountains.domain.Treasure;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface ITreasureRepository {
    List<Treasure> getAll();
}

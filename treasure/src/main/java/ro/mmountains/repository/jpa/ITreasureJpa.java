package ro.mmountains.repository.jpa;

import ro.mmountains.repository.jpa.entity.ETreasure;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface ITreasureJpa extends BaseRepository<ETreasure, Long> {
    List<ETreasure> findByAcknowledgeFalse();
}

package ro.mmountains.repository.jpa;

import ro.mmountains.repository.jpa.entity.EDwarf;

import java.util.List;
import java.util.Optional;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface IDwarfRepository {
    List<EDwarf> getAll();
    Optional<EDwarf> findById(Long id);
}

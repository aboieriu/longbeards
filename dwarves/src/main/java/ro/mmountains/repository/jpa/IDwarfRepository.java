package ro.mmountains.repository.jpa;

import ro.mmountains.repository.jpa.entity.EDwarf;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface IDwarfRepository {
    List<EDwarf> getAll();
}

package ro.mmountains.view;

import ro.mmountains.domain.Dwarf;

/**
 * Created by aboieriu on 7/12/16.
 */
public class DwarfConverter {

    public DwarfConverter() {
    }

    public DwarfView reverse(Dwarf dwarf) {
        if (dwarf == null) {
            return null;
        }
        return new DwarfView(dwarf.getId(), dwarf.getName());
    }
}

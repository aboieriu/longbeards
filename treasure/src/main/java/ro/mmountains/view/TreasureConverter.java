package ro.mmountains.view;

import ro.mmountains.domain.Treasure;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureConverter {

    private DwarfConverter dwarfConverter = new DwarfConverter();

    public TreasureView reverse(Treasure treasure) {
        return new TreasureView(treasure.getId(), treasure.getType(), treasure.getValue(), dwarfConverter.reverse(treasure.getDwarf()));
    }
}
